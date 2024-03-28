package net.chuck.chucksmod.block.custom.crop.magical;

import net.chuck.chucksmod.block.ModBlockTags;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class TriafiaCrystalCropBlock extends AbstractMagicalCropBlock {
    public TriafiaCrystalCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.TRIAFIA_CRYSTAL_SEEDS;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(ModBlockTags.TRIAFIA_CRYSTAL_PLANTABLE);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
    }
}
