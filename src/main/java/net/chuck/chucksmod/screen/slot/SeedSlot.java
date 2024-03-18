package net.chuck.chucksmod.screen.slot;

import net.minecraft.block.CropBlock;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class SeedSlot extends Slot {
    public SeedSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof AliasedBlockItem  item && item.getBlock() instanceof CropBlock;
    }
}
