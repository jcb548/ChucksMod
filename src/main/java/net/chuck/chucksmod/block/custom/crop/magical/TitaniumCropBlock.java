package net.chuck.chucksmod.block.custom.crop.magical;

import net.chuck.chucksmod.block.ModBlockTags;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class TitaniumCropBlock extends AbstractMagicalCropBlock {
    public TitaniumCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.TITANIUM_SEEDS;
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(ModBlockTags.TITANIUM_ORES) || floor.isIn(ModBlockTags.TITANIUM_BLOCKS) ||
                floor.isOf(ModBlocks.TITANIUM_DUST_BLOCK) || floor.isIn(ModBlockTags.RAW_TITANIUM_BLOCKS);
    }
}
