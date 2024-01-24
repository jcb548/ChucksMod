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
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public abstract class AbstractEnergyCookerScreenHandler extends AbstractEnergyUsingScreenHandler{
    protected final static int INPUT_SCREEN_SLOT_IDX = 36;
    protected final static int OUTPUT_SCREEN_SLOT_IDX = 37;
    protected AbstractEnergyCookerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                                PropertyDelegate delegate, ScreenHandlerType type, int invSize) {
        super(syncId, playerInventory, entity, delegate, type, invSize);
    }
    protected AbstractEnergyCookerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                                PropertyDelegate delegate, ScreenHandlerType type) {
        this(syncId, playerInventory, entity, delegate, type, AbstractEnergyCookerBlockEntity.INV_SIZE);
        this.addSlot(new Slot(inventory, AbstractEnergyCookerBlockEntity.INPUT_SLOT, 55, 35));
        this.addSlot(new Slot(inventory, AbstractEnergyCookerBlockEntity.OUTPUT_SLOT, 116, 35));
    }
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot originalSlot = this.slots.get(invSlot);
        if(originalSlot != null && originalSlot.hasStack()){
            ItemStack oldStack = originalSlot.getStack();
            if(invSlot == OUTPUT_SCREEN_SLOT_IDX){
                if(!this.insertItem(oldStack, PLAYER_INVENTORY_START_IDX, PLAYER_INVENTORY_END_IDX+1, false)){
                    return ItemStack.EMPTY;
                }
                originalSlot.onQuickTransfer(oldStack, newStack);
            } else if(invSlot == INPUT_SCREEN_SLOT_IDX){
                if(!this.insertItem(oldStack, PLAYER_INVENTORY_START_IDX, PLAYER_INVENTORY_END_IDX+1, true)){
                    return newStack;
                }
            } else {
                if(oldStack.isEmpty()){
                    originalSlot.setStack(ItemStack.EMPTY);
                } else if(isRecipeItem(oldStack)){
                    if(!this.insertItem(oldStack, INPUT_SCREEN_SLOT_IDX, INPUT_SCREEN_SLOT_IDX+1, true)){
                        return ItemStack.EMPTY;
                    }
                    originalSlot.markDirty();
                } else {
                    if(invSlot < 9) {
                        if (!this.insertItem(oldStack, 9, PLAYER_INVENTORY_END_IDX, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else {
                        if (!this.insertItem(oldStack, PLAYER_INVENTORY_START_IDX, 9, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                    originalSlot.setStack(ItemStack.EMPTY);
                }
                if(oldStack.getCount() == newStack.getCount()){
                    return ItemStack.EMPTY;
                }
                originalSlot.markDirty();
            }
        }
        return newStack;
    }
    protected abstract boolean isRecipeItem(ItemStack item);
    public boolean isCrafting() {
        return propertyDelegate.get(AbstractPoweredFurnaceBlockEntity.PROGRESS_IDX) > 0;
    }
    public int getScaledProgress(int size) {
        int progress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.PROGRESS_IDX);
        int maxProgress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.MAX_PROGRESS_IDX);
        int progressArrowSize = size;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }
}
