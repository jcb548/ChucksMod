package net.chuck.chucksmod.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;

public class ModBagSlot extends Slot {
    public ModBagSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }
    public ModBagSlot(Slot slot){
        super(slot.inventory, slot.getIndex(), slot.x, slot.y);
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        return false;
    }

    @Override
    public boolean canBeHighlighted() {
        return false;
    }
}
