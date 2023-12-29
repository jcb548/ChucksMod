package net.chuck.chucksmod.screen.quarry;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;

public class MiningBookSlot extends Slot {
    public MiningBookSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }
    public static boolean canAccept(ItemStack stack){
        if(stack.getItem() instanceof EnchantedBookItem) {
            NbtList nbtList = EnchantedBookItem.getEnchantmentNbt(stack);
            for (int i = 0; i < nbtList.size(); ++i) {
                NbtCompound nbtCompound = nbtList.getCompound(i);
                Identifier id = EnchantmentHelper.getIdFromNbt(nbtCompound);
                if(id.equals(EnchantmentHelper.getEnchantmentId(Enchantments.FORTUNE)) ||
                        id.equals(EnchantmentHelper.getEnchantmentId(Enchantments.SILK_TOUCH))){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return canAccept(stack);
    }
}
