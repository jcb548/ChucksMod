package net.chuck.chucksmod.item.custom.bag;

import net.chuck.chucksmod.screen.bag.BagScreenHandlerFactory7x2;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BagItem7x2 extends AbstractBagItem{
    public static final int INV_WIDTH = 7;
    public static final int INV_HEIGHT = 2;

    public static final int INV_SIZE = INV_WIDTH*INV_HEIGHT;
    public BagItem7x2(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if (world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        NamedScreenHandlerFactory screenHandlerFactory = new BagScreenHandlerFactory7x2(itemStack);
        user.openHandledScreen(screenHandlerFactory);
        return TypedActionResult.consume(itemStack);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.chucksmod.7x2bag.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public int getInvSize() {
        return INV_SIZE;
    }
}
