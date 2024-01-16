package net.chuck.chucksmod.block.entity.energy_storage;

import net.chuck.chucksmod.block.entity.EnergyStoring;
import net.chuck.chucksmod.block.entity.ImplementedInventory;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.energy_storage.EnergyStorageScreenHandler;
import net.chuck.chucksmod.util.DirectionIOProperty;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleSidedEnergyContainer;

public abstract class AbstractEnergyStorageBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,
        ImplementedInventory, EnergyStoring {
    public static final int INPUT_SLOT = 0;
    public static final int INV_SIZE = 1;
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY);
    public final SimpleSidedEnergyContainer energyStorage;
    public AbstractEnergyStorageBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state,
                                            int energyStorageSize, int maxInsertExtract) {
        super(entity, pos, state);
        energyStorage = new SimpleSidedEnergyContainer() {
            @Override
            public long getCapacity() {
                return energyStorageSize;
            }

            @Override
            public long getMaxInsert(Direction side) {
                if (allowInsert(side)){
                    return maxInsertExtract;
                }
                return 0;
            }

            @Override
            public long getMaxExtract(Direction side) {
                if(allowExtract(side)) {
                    return maxInsertExtract;
                }
                return 0;
            }
            @Override
            protected void onFinalCommit() {
                markDirty();
                if(!world.isClient()){
                    sendEnergyPacket();
                }
            }
        };
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        return new EnergyStorageScreenHandler(syncId, playerInventory, this);
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }
    // For saving nbt on world close
    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
        nbt.putLong("energy_storage.energy", energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        energyStorage.amount= nbt.getLong("energy_storage.energy");
    }

    public void setEnergyLevel(long energyLevel){
        this.energyStorage.amount = energyLevel;
    }
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
        buf.writeLong(this.energyStorage.amount);
    }

    private boolean allowInsert(Direction side){
        if(this.getCachedState().get(DirectionIOProperty.of(side.getName()))
                .equals(DirectionIOProperty.INSERT)){
            return true;
        }
        return false;
    }
    private boolean allowExtract(Direction side){
        if(this.getCachedState().get(DirectionIOProperty.of(side.getName()))
                .equals(DirectionIOProperty.EXTRACT)){
            return true;
        }
        return false;
    }

    @Override
    public EnergyStorage getEnergyStorage() {
        return energyStorage.getSideStorage(null);
    }
    protected void sendEnergyPacket() {
        for(ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())){
            sendEnergyPacket(player);
        }
    }
    public void sendEnergyPacket(ServerPlayerEntity player){
        PacketByteBuf data = PacketByteBufs.create();
        data.writeLong(energyStorage.amount);
        data.writeBlockPos(getPos());
        ServerPlayNetworking.send(player, ModMessages.ENERGY_SYNC, data);
    }
}
