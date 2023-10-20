package net.chuck.chucksmod.screen.bag;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class LeatherBagScreenHandlerFactory extends AbstractBagScreenHandlerFactory{
    public LeatherBagScreenHandlerFactory(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public Text getDisplayName() {
        return  Text.translatable("item.chucksmod.leather_bag");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new LeatherBagScreenHandler(syncId, playerInventory, itemStack);
    }
}
