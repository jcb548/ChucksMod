package net.chuck.chucksmod.block.custom.crop.magical;

import net.chuck.chucksmod.block.ModBlockTags;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class TriafiumCropBlock extends AbstractMagicalCropBlock {
    public TriafiumCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.TRIAFIUM_SEEDS;
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.TRIAFIUM_BLOCK) || floor.isOf(ModBlocks.RAW_TRIAFIUM_BLOCK) ||
                floor.isOf(ModBlocks.TRIAFIUM_DUST_BLOCK) || floor.isIn(ModBlockTags.TRIAFIUM_ORES);
    }
}
