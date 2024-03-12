package net.chuck.chucksmod.block.custom.crop.magical;

import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class IronCropBlock extends AbstractMagicalCropBlock {
    public IronCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.IRON_SEEDS;
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.IRON_ORES) || floor.isOf(Blocks.IRON_BLOCK) ||
                floor.isOf(ModBlocks.IRON_DUST_BLOCK);
    }
}
