package net.chuck.chucksmod.block.custom.crusher;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractPoweredCrusherBlock extends AbstractEnergyUsingBlock {
    protected AbstractPoweredCrusherBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.chucksmod.crusher"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
