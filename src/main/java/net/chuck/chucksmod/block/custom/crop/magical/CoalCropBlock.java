package net.chuck.chucksmod.block.custom.crop.magical;

import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CoalCropBlock extends AbstractMagicalCropBlock {
    public CoalCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.COAL_SEEDS;
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.COAL_ORES) || floor.isOf(Blocks.COAL_BLOCK) ||
                floor.isOf(ModBlocks.COAL_DUST_BLOCK);
    }
}
