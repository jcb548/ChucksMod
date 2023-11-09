package net.chuck.chucksmod.screen.crusher;

import net.chuck.chucksmod.block.entity.crusher.AbstractCrusherBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public abstract class AbstractPoweredCrusherScreenHandler extends AbstractCrusherScreenHandler{
    public AbstractPoweredCrusherScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                               PropertyDelegate delegate, ScreenHandlerType type) {
        super(syncId, playerInventory, entity, delegate, type);
        this.slots.set(AbstractCrusherBlockEntity.INPUT_SLOT,
                new Slot(inventory, AbstractCrusherBlockEntity.INPUT_SLOT, 56, 35));
    }
}
