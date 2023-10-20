package net.chuck.chucksmod.item.custom;

import net.chuck.chucksmod.screen.BagScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BagItem extends Item{
    public static final int INV_SIZE = 9;
    public BagItem(Settings settings) {
        super(settings.maxCount(1));
    }
    public static final String ITEMS_KEY = "Items";

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if (world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        NamedScreenHandlerFactory screenHandlerFactory = new BagScreenHandlerFactory(itemStack);
        user.openHandledScreen(screenHandlerFactory);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public boolean canBeNested() {
        return false;
    }
}
