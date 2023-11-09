package net.chuck.chucksmod.screen.furnace;

import net.chuck.chucksmod.block.entity.crusher.AbstractCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.furnace.AbstractPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.block.entity.generator.AbstractHeatGeneratorBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPoweredFurnaceScreenHandler extends ScreenHandler {
    protected final Inventory inventory;
    protected final PropertyDelegate propertyDelegate;
    protected AbstractPoweredFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                                  PropertyDelegate delegate, ScreenHandlerType type) {
        super(type, syncId);
        checkSize(((Inventory) entity), AbstractPoweredFurnaceBlockEntity.INV_SIZE);
        this.inventory = (Inventory) entity;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;

        this.addSlot(new Slot(inventory, AbstractPoweredFurnaceBlockEntity.INPUT_SLOT, 55, 35));
        this.addSlot(new Slot(inventory, AbstractPoweredFurnaceBlockEntity.OUTPUT_SLOT, 116, 35));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
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
    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }
    public boolean isCrafting() {
        return propertyDelegate.get(AbstractPoweredFurnaceBlockEntity.PROGRESS_IDX) > 0;
    }
}
