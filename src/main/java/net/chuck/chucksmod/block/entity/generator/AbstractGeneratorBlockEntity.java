package net.chuck.chucksmod.block.entity.generator;

import net.chuck.chucksmod.block.entity.ImplementedInventory;
import net.chuck.chucksmod.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public abstract class AbstractGeneratorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,
        ImplementedInventory {
    public static final int BURN_TIME_IDX = 0;
    public static final int FUEL_TIME_IDX = 1;
    public static final int STORAGE_SIZE_IDX = 2;
    public static final int GENERATION_SPEED_IDX = 3;
    public static final int DELEGATE_SIZE = 4;
    protected PropertyDelegate propertyDelegate;
    public SimpleEnergyStorage energyStorage;
    protected int burnTime = 0;
    protected int fuelTime = 0;
    public int energyStorageSize;
    public int generationSpeed;
    public AbstractGeneratorBlockEntity(BlockEntityType type, BlockPos pos, BlockState state,
                                        int generationSpeed, int energyStorageSize) {
        super(type, pos, state);
        this.generationSpeed = generationSpeed;
        this.energyStorageSize = energyStorageSize;
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case BURN_TIME_IDX: return AbstractGeneratorBlockEntity.this.burnTime;
                    case FUEL_TIME_IDX: return AbstractGeneratorBlockEntity.this.fuelTime;
                    case STORAGE_SIZE_IDX: return AbstractGeneratorBlockEntity.this.energyStorageSize;
                    case GENERATION_SPEED_IDX: return AbstractGeneratorBlockEntity.this.generationSpeed;
                    default: return BURN_TIME_IDX;
                }
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case BURN_TIME_IDX: AbstractGeneratorBlockEntity.this.burnTime = value; break;
                    case FUEL_TIME_IDX: AbstractGeneratorBlockEntity.this.fuelTime = value; break;
                    case STORAGE_SIZE_IDX: AbstractGeneratorBlockEntity.this.energyStorageSize = value; break;
                    case GENERATION_SPEED_IDX: AbstractGeneratorBlockEntity.this.generationSpeed = value; break;
                }
            }
            @Override
            public int size() {
                return DELEGATE_SIZE;
            }
        };
        energyStorage = new SimpleEnergyStorage(energyStorageSize, generationSpeed, generationSpeed){
            @Override
            protected void onFinalCommit() {
                markDirty();
                if(!world.isClient()){
                    PacketByteBuf data = PacketByteBufs.create();
                    data.writeLong(amount);
                    data.writeBlockPos(getPos());

                    for(ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())){
                        ServerPlayNetworking.send(player, ModMessages.ENERGY_SYNC, data);
                    }
                }

            }
            @Override
            public boolean supportsInsertion() {
                return false;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    protected void generateEnergy() {
        try(Transaction transaction = Transaction.openOuter()){
            this.energyStorage.insert(generationSpeed, transaction);
            transaction.commit();
        }
    }
    protected boolean isGenerating() {
        return this.burnTime > 0;
    }
    protected abstract void useFuel();
    public void tick(World world, BlockPos blockPos, BlockState blockState) {
        boolean burning_start_of_tick = this.isGenerating();
        if (world.isClient()){
            return;
        }
        if (!this.isGenerating() && this.energyStorage.amount < this.energyStorageSize){
            this.useFuel();
        }
        if (this.isGenerating()){
            --this.burnTime;
            this.generateEnergy();
        }
        if (burning_start_of_tick != this.isGenerating()){
            blockState = (BlockState)blockState.with(AbstractFurnaceBlock.LIT, this.isGenerating());
            world.setBlockState(blockPos, blockState, Block.NOTIFY_ALL);
            markDirty(world, blockPos, blockState);
        }
        for (Direction side : Direction.values()){
            BlockEntity entity = world.getBlockEntity(getPos().offset(side));
            EnergyStorageUtil.move(this.energyStorage, EnergyStorage.SIDED.find(world, pos.offset(side),
                    side.getOpposite()), generationSpeed, null);
        }
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("generator.burnTime", burnTime);
        nbt.putInt("generator.fuelTime", fuelTime);
        nbt.putLong("generator.energy", energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        burnTime = nbt.getInt("generator.burnTime");
        fuelTime = nbt.getInt("generator.fuelTime");
        energyStorage.amount = nbt.getLong("generator.energy");
    }
    public void setEnergyLevel(long energyLevel){
        this.energyStorage.amount = energyLevel;
    }
}
