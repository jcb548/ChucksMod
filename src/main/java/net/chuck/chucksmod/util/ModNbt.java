package net.chuck.chucksmod.util;

import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.collection.DefaultedList;

public class ModNbt {
    public static NbtCompound writeNbt(NbtCompound nbt, String key, DefaultedList<ItemStack> stacks) {
        return ModNbt.writeNbt(nbt, key, stacks, true);
    }
    public static NbtCompound writeNbt(NbtCompound nbt, String key, DefaultedList<ItemStack> stacks, boolean setIfEmpty) {
        NbtList nbtList = new NbtList();
        for (int i = 0; i < stacks.size(); ++i) {
            ItemStack itemStack = stacks.get(i);
            if (itemStack.isEmpty()) continue;
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putByte("Slot", (byte)i);
            itemStack.writeNbt(nbtCompound);
            nbtList.add(nbtCompound);
        }
        if (!nbtList.isEmpty() || setIfEmpty) {
            nbt.put(key, nbtList);
        }
        return nbt;
    }
    public static void readNbt(NbtCompound nbt, String key, DefaultedList<ItemStack> stacks) {
        NbtList nbtList = nbt.getList(key, NbtElement.COMPOUND_TYPE);
        for (int i = 0; i < nbtList.size(); ++i) {
            NbtCompound nbtCompound = nbtList.getCompound(i);
            int j = nbtCompound.getByte("Slot") & 0xFF;
            if (j < 0 || j >= stacks.size()) continue;
            stacks.set(j, ItemStack.fromNbt(nbtCompound));
        }
    }
}
