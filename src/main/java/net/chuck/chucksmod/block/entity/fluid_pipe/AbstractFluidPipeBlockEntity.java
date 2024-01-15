package net.chuck.chucksmod.block.entity.fluid_pipe;

import net.chuck.chucksmod.block.custom.fluid_pipe.AbstractFluidPipeBlock;
import net.chuck.chucksmod.block.entity.OfferedFluidStorage;
import net.chuck.chucksmod.block.entity.wire.WireTickManager;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiCache;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFluidPipeBlockEntity extends BlockEntity {
    public final SingleVariantStorage<FluidVariant> fluidStorage;
    private final BlockApiCache<Storage<FluidVariant>, Direction>[] adjacentCaches = new BlockApiCache[6];
    public long lastTick = 0;
    public int blockedSides = 0;
    public boolean ioBlocked = false;
    // null means that it needs to be re-queried
    public List<FluidPipeTarget> targets = null;
    public boolean extracting = false;
    private Direction lastInsertFrom = null;
    public AbstractFluidPipeBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        fluidStorage = new SingleVariantStorage<>() {
            @Override
            protected FluidVariant getBlankVariant() {
                return FluidVariant.blank();
            }

            @Override
            protected long getCapacity(FluidVariant variant) {
                return getTransferRate();
            }
        };
    }
    public void setExtracting(boolean extracting){this.extracting = extracting;}
    private BlockApiCache<Storage<FluidVariant>, Direction> getAdjacentCache(Direction direction) {
        if (adjacentCaches[direction.getId()] == null) {
            adjacentCaches[direction.getId()] = BlockApiCache.create(FluidStorage.SIDED, (ServerWorld) world, pos.offset(direction));
        }
        return adjacentCaches[direction.getId()];
    }
    public abstract long getTransferRate();
    @Nullable
    public BlockEntity getAdjacentBlockEntity(Direction direction) {
        return getAdjacentCache(direction).getBlockEntity();
    }
    public void appendTargets(List<OfferedFluidStorage> targetStorages, List<OfferedFluidStorage> extractionStorages){
        ServerWorld serverWorld = (ServerWorld) world;
        if(serverWorld == null){
            return;
        }
        // update targets
        if(targets == null){
            BlockState newBlockState = getCachedState();
            targets = new ArrayList<>();
            for (Direction direction: Direction.values()){
                boolean foundSomething = false;
                BlockApiCache<Storage<FluidVariant>, Direction> adjCache = getAdjacentCache(direction);
                if(adjCache.getBlockEntity() instanceof AbstractFluidPipeBlockEntity adjPipe) {
                    if (adjPipe.getTransferRate() == this.getTransferRate() /*&& (adjPipe.fluidStorage.variant.equals(FluidVariant.of(Fluids.EMPTY))
                            || adjPipe.fluidStorage.variant.equals(this.fluidStorage.variant))*/){
                        foundSomething = true;
                    }
                } else if(adjCache.find(direction.getOpposite()) != null){
                    foundSomething = true;
                    targets.add(new FluidPipeTarget(direction, adjCache));
                }
                newBlockState = newBlockState.with(AbstractFluidPipeBlock.PROPERTY_MAP.get(direction), foundSomething);
            }
            serverWorld.setBlockState(getPos(), newBlockState);
        }
        // fill the list
        for(FluidPipeTarget target: targets){
            Storage<FluidVariant> storage = target.find();
            if(storage == null){
                //Schedule a rebuild next tick
                targets = null;
            } else {
                if(this.extracting){
                    extractionStorages.add(new OfferedFluidStorage(this, target.directionTo, storage));
                } else {
                    targetStorages.add(new OfferedFluidStorage(this, target.directionTo, storage));
                }
            }
        }
        // reset blocked sides
        blockedSides = 0;
    }
    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        NbtCompound nbtTag = new NbtCompound();
        writeNbt(nbtTag);
        return BlockEntityUpdateS2CPacket.create(this);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if(nbt.contains("fluid_pipe.fluid_variant") && nbt.contains("fluid_pipe.fluid_level")){
            fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("fluid_pipe.fluid_variant"));
            fluidStorage.amount = nbt.getLong("fluid_pipe.fluid_level");
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.put("fluid_pipe.fluid_variant", fluidStorage.variant.toNbt());
        nbt.putLong("fluid_pipe.fluid_level", fluidStorage.amount);
    }

    public void neighbourUpdate(){
        targets=null;
    }

    public void tick(World world, BlockPos pos, BlockState state){
        if(world == null || world.isClient){
            return;
        }
        FluidPipeTickManager.handleFluidPipeTick(this);
    }
    private record FluidPipeTarget(Direction directionTo, BlockApiCache<Storage<FluidVariant>, Direction> cache){
        @Nullable
        Storage<FluidVariant> find(){
            return cache.find(directionTo.getOpposite());
        }
    }
}
