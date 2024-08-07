package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.util.FluidStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractModScreenHandler extends ScreenHandler {
    public FluidStack fluidStack = null;
    public FluidStoring fluidStoring = null;
    protected final static int PLAYER_INVENTORY_START_IDX = 0;
    protected final static int PLAYER_INVENTORY_END_IDX = 35;
    protected AbstractModScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
    public void addPlayerInventory(PlayerInventory playerInventory, int y){
        for(int i=0;i<3;++i) {
            for(int j=0;j<9;++j) {
                this.addSlot(new Slot(playerInventory, j + i*9 + 9, 8 + j*18, y + i*18));
            }
        }
    }
    public void addPlayerInventory(PlayerInventory playerInventory){
        addPlayerInventory(playerInventory, 84);
    }
    public void addPlayerHotbar(PlayerInventory playerInventory, int y){
        for(int i=0;i<9;++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i*18, y));
        }
    }
    public void addPlayerHotbar(PlayerInventory playerInventory){
        addPlayerHotbar(playerInventory, 142);
    }
    public FluidStoring getFluidStoring() {
        return fluidStoring;
    }

    public void setFluidStack(FluidStack fluidStack) {
        this.fluidStack = fluidStack;
    }
    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot originalSlot = this.slots.get(slot);
        if(originalSlot != null && originalSlot.hasStack()){
            ItemStack oldStack = originalSlot.getStack();
            if(oldStack.isEmpty()){
                originalSlot.setStack(ItemStack.EMPTY);
            } else {
                if(slot < 9) {
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
        return newStack;
    }
}
