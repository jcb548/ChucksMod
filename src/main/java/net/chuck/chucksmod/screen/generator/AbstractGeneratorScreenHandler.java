package net.chuck.chucksmod.screen.generator;

import net.chuck.chucksmod.block.entity.generator.AbstractGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.generator.IronHeatGeneratorBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public abstract class AbstractGeneratorScreenHandler extends ScreenHandler {
    protected final Inventory inventory;
    protected final PropertyDelegate propertyDelegate;
    protected AbstractGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                             PropertyDelegate delegate, ScreenHandlerType<?> type) {
        super(type, syncId);
        checkSize(((Inventory) entity), IronHeatGeneratorBlockEntity.INV_SIZE);
        this.inventory = (Inventory) entity;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;

        this.addSlot(new Slot(inventory, IronHeatGeneratorBlockEntity.FUEL_SLOT, 80, 39));

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
            } else if (!this.insertItem(originalStack, IronHeatGeneratorBlockEntity.FUEL_SLOT, this.inventory.size(), false)){
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
    public boolean isBurning() {
        return propertyDelegate.get(IronHeatGeneratorBlockEntity.BURN_TIME_IDX) > 0;
    }

    public int getScaledBurning() {
        int burnTime = this.propertyDelegate.get(IronHeatGeneratorBlockEntity.BURN_TIME_IDX);
        int fuelTime = this.propertyDelegate.get(IronHeatGeneratorBlockEntity.FUEL_TIME_IDX);
        int burnFlameSize = 13;

        return fuelTime != 0 && burnTime != 0 ? burnTime * burnFlameSize / fuelTime : 0;
    }
}
