package net.chuck.chucksmod.screen.energy_storage;

import net.chuck.chucksmod.block.entity.energy_storage.IronEnergyStorageBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class IronEnergyStorageScreenHandler extends AbstractEnergyStorageScreenHandler {
    public final IronEnergyStorageBlockEntity blockEntity;
    public IronEnergyStorageScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }
    public IronEnergyStorageScreenHandler(int syncId, PlayerInventory playerInventory,
                                          BlockEntity entity) {
        super(syncId, playerInventory, entity, ModScreenHandlers.IRON_ENERGY_STORAGE_SCREEN_HANDLER);
        this.blockEntity = (IronEnergyStorageBlockEntity) entity;
    }

}
