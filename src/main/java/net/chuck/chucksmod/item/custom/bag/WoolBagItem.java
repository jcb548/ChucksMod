package net.chuck.chucksmod.item.custom.bag;

import net.chuck.chucksmod.screen.bag.WoolBagScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WoolBagItem extends AbstractBagItem{
    public static final int INV_SIZE = 3;
    public WoolBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if (world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        NamedScreenHandlerFactory screenHandlerFactory = new WoolBagScreenHandlerFactory(itemStack);
        user.openHandledScreen(screenHandlerFactory);
        return TypedActionResult.consume(itemStack);
    }
}
