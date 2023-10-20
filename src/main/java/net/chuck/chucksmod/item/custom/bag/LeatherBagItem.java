package net.chuck.chucksmod.item.custom.bag;

import net.chuck.chucksmod.screen.bag.LeatherBagScreenHandlerFactory;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LeatherBagItem extends AbstractBagItem{
    public static final int INV_SIZE = 5;
    public LeatherBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if (world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        NamedScreenHandlerFactory screenHandlerFactory = new LeatherBagScreenHandlerFactory(itemStack);
        user.openHandledScreen(screenHandlerFactory);
        return TypedActionResult.consume(itemStack);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.chucksmod.leather_bag.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
