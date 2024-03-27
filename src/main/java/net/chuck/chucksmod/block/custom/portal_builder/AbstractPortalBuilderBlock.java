package net.chuck.chucksmod.block.custom.portal_builder;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractPortalBuilderBlock extends AbstractEnergyUsingBlock {
    protected AbstractPortalBuilderBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.chucksmod.portal_builder.1"));
        tooltip.add(Text.translatable("tooltip.chucksmod.portal_builder.2"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
