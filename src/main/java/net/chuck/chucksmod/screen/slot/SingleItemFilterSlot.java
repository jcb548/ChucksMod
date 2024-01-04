package net.chuck.chucksmod.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class SingleItemFilterSlot extends Slot {
    private Item item;
    public SingleItemFilterSlot(Inventory inventory, int index, int x, int y, Item item) {
        super(inventory, index, x, y);
        this.item = item;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem().equals(item);
    }
}
