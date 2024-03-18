package net.chuck.chucksmod.screen.harvester;

import net.chuck.chucksmod.block.entity.harvester.AbstractHarvesterBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;

public abstract class AbstractHarvesterScreenHandler extends AbstractEnergyUsingScreenHandler {
    protected AbstractHarvesterBlockEntity harvester = null;
    protected Inventory cropInventory;
    protected AbstractHarvesterScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity, PropertyDelegate delegate, ScreenHandlerType type,
                                             int seedInvSize, int cropInvSize) {
        super(syncId, playerInventory, entity, delegate, type, seedInvSize);
        if(entity instanceof AbstractHarvesterBlockEntity harvesterBlockEntity) harvester = harvesterBlockEntity;
        checkSize(harvester.getCropInventory(), cropInvSize);
        cropInventory = harvester.getCropInventory();
        addSeedSlots();
        addCropSlots();
    }
    public abstract void addSeedSlots();
    public abstract void addCropSlots();
    public abstract int getStartOfSeedInventory();
    public abstract int getEndOfSeedInventory();
    public abstract int getStartOfCropInventory();
    public abstract int getEndOfCropInventory();
    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot originalSlot = this.slots.get(slot);
        if(originalSlot != null && originalSlot.hasStack()){
            ItemStack oldStack = originalSlot.getStack();
            if(slot >= getStartOfSeedInventory() && slot <= getEndOfSeedInventory()){
                if(!this.insertItem(oldStack, PLAYER_INVENTORY_START_IDX, PLAYER_INVENTORY_END_IDX+1, false)){
                    return ItemStack.EMPTY;
                }
            } else if(slot >= getStartOfCropInventory() && slot <= getEndOfCropInventory()){
                if(!this.insertItem(oldStack, PLAYER_INVENTORY_START_IDX, PLAYER_INVENTORY_END_IDX+1, false)){
                    return ItemStack.EMPTY;
                }
            } else {
                if(oldStack.isEmpty()){
                    originalSlot.setStack(ItemStack.EMPTY);
                } else if (oldStack.getItem() instanceof AliasedBlockItem item && item.getBlock() instanceof CropBlock){
                    if(!this.insertItem(oldStack, getStartOfSeedInventory(), getEndOfCropInventory()+1, false)){
                        return ItemStack.EMPTY;
                    }
                } else {
                    if(!this.insertItem(oldStack, getStartOfCropInventory(), getEndOfCropInventory()+1, false)){
                        return ItemStack.EMPTY;
                    }
                }
            }
        }
        return itemStack;
    }
}
