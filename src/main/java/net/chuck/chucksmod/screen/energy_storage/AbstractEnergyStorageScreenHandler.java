package net.chuck.chucksmod.screen.energy_storage;

import net.chuck.chucksmod.block.entity.energy_storage.AbstractEnergyStorageBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public abstract class AbstractEnergyStorageScreenHandler extends ScreenHandler {
    protected final Inventory inventory;
    protected AbstractEnergyStorageScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                                 ScreenHandlerType type) {
        super(type, syncId);
        checkSize(((Inventory) entity), AbstractEnergyStorageBlockEntity.INV_SIZE);
        this.inventory = (Inventory) entity;
        inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory, AbstractEnergyStorageBlockEntity.INPUT_SLOT, 20, 35));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()){
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if(invSlot < this.inventory.size()) {
                if(!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)){
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, AbstractEnergyStorageBlockEntity.INPUT_SLOT,
                    this.inventory.size(), false)){
                return ItemStack.EMPTY;
            }
            if(originalStack.isEmpty()){
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    public void addPlayerInventory(PlayerInventory inventory) {
        for(int i=0;i<3;++i) {
            for(int j=0;j<9;++j) {
                this.addSlot(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
            }
        }
    }

    public void addPlayerHotbar(PlayerInventory inventory){
        for(int i=0;i<9;++i) {
            this.addSlot(new Slot(inventory, i, 8 + i*18, 142));
        }
    }

    public abstract void onButtonPress(byte id);
    public abstract String getSideState(byte id);
    public abstract byte directionToGUISide(byte id);
}
