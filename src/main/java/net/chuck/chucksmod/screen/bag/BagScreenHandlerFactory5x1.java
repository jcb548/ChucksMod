package net.chuck.chucksmod.screen.bag;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class BagScreenHandlerFactory5x1 extends AbstractBagScreenHandlerFactory{
    public BagScreenHandlerFactory5x1(ItemStack itemStack) {
        super(itemStack);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new BagScreenHandler5x1(syncId, playerInventory, itemStack);
    }
}
