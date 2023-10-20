package net.chuck.chucksmod.screen.bag;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class WoolBagScreenHandlerFactory extends AbstractBagScreenHandlerFactory{
    public WoolBagScreenHandlerFactory(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("item.chucksmod.wool_bag");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new WoolBagScreenHandler(syncId, playerInventory, itemStack);
    }
}
