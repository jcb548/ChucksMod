package net.chuck.chucksmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagicalAliasedBlockItem extends AliasedBlockItem {
    private Text tooltip;
    public MagicalAliasedBlockItem(Block block, Item.Settings settings, Text tooltip) {
        super(block, settings);
        this.tooltip = tooltip;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(this.tooltip);
        super.appendTooltip(stack, world, tooltip, context);
    }
}
