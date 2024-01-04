package net.chuck.chucksmod.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class BucketSlot extends Slot {
    public BucketSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof BucketItem;
    }
}
