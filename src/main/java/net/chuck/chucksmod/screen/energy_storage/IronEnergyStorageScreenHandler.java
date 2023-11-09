package net.chuck.chucksmod.screen.energy_storage;

import net.chuck.chucksmod.block.entity.energy_storage.IronEnergyStorageBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandlerType;

public class IronEnergyStorageScreenHandler extends AbstractEnergyStorageScreenHandler{
    public IronEnergyStorageBlockEntity blockEntity;
    public IronEnergyStorageScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(syncId, playerInventory, blockEntity, ModScreenHandlers.IRON_ENERGY_STORAGE_SCREEN_HANDLER);
        this.blockEntity = (IronEnergyStorageBlockEntity) blockEntity;
    }
    public IronEnergyStorageScreenHandler(int syncID, PlayerInventory inventory, PacketByteBuf buf){
        this(syncID, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }
}
