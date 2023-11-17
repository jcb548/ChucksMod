package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.furnace.AbstractPoweredFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public abstract class AbstractEnergyCookerScreenHandler extends AbstractEnergyUsingScreenHandler{
    protected AbstractEnergyCookerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                                PropertyDelegate delegate, ScreenHandlerType type) {
        super(syncId, playerInventory, entity, delegate, type, AbstractEnergyCookerBlockEntity.INV_SIZE);
        this.addSlot(new Slot(inventory, AbstractEnergyCookerBlockEntity.INPUT_SLOT, 55, 35));
        this.addSlot(new Slot(inventory, AbstractEnergyCookerBlockEntity.OUTPUT_SLOT, 116, 35));
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
            } else if (!this.insertItem(originalStack, AbstractPoweredFurnaceBlockEntity.INPUT_SLOT,
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
    public boolean isCrafting() {
        return propertyDelegate.get(AbstractPoweredFurnaceBlockEntity.PROGRESS_IDX) > 0;
    }
}
