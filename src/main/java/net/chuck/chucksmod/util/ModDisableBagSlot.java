package net.chuck.chucksmod.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.Slot;

public class ModDisableBagSlot extends Slot {
    public ModDisableBagSlot(Slot slot){
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
