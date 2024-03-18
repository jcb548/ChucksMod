package net.chuck.chucksmod.screen.bag;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import org.jetbrains.annotations.Nullable;

public class BagScreenHandlerFactory6x2 extends AbstractBagScreenHandlerFactory{
    public BagScreenHandlerFactory6x2(ItemStack itemStack) {
        super(itemStack);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new BagScreenHandler6x2(syncId, playerInventory, itemStack);
    }
}
