package net.chuck.chucksmod.block.entity.energy_storage;

import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.util.DirectionalPowerIOProperty;
import net.chuck.chucksmod.util.ModProperties;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;
import team.reborn.energy.api.base.SimpleEnergyStorage;
import team.reborn.energy.api.base.SimpleSidedEnergyContainer;

import java.util.HashMap;

public abstract class AbstractEnergyStorageBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory {
    public final SimpleSidedEnergyContainer energyStorage;
    public AbstractEnergyStorageBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.energyStorage = new SimpleSidedEnergyContainer(){
            @Override
            public long getCapacity() {
                return getEnergyCapacity();
            }

            @Override
            public long getMaxInsert(Direction side) {
                if(allowInsert(side)) return getMaxInsertExtract();
                else return 0;
            }

            @Override
            public long getMaxExtract(Direction side) {
                if(allowExtract(side)) return getMaxInsertExtract();
                else return 0;
            }

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
        };
    }
    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
    private byte getIO(Direction side){
        return this.getCachedState().get(DirectionalPowerIOProperty.of(side.getName()));
    }

    private boolean allowInsert(Direction side){
        return getIO(side) == DirectionalPowerIOProperty.INSERT;
    }

    private boolean allowExtract(Direction side){
        return getIO(side) == DirectionalPowerIOProperty.EXTRACT;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("energy_storage.energy", energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        energyStorage.amount = nbt.getLong("energy_storage.energy");
    }
    public void tick(World world, BlockPos blockPos, BlockState blockState){
        if (world.isClient()){
            return;
        }
        for (Direction side : Direction.values()){
            if(allowExtract(side)) {
                EnergyStorageUtil.move(this.energyStorage.getSideStorage(side),
                        EnergyStorage.SIDED.find(world, pos.offset(side), side.getOpposite()),
                        getMaxInsertExtract(), null);
            }
        }
    }
    public abstract long getMaxInsertExtract();
    public abstract long getEnergyCapacity();

    public void setEnergyLevel(long energyLevel){
        this.energyStorage.amount = energyLevel;
    }
}
