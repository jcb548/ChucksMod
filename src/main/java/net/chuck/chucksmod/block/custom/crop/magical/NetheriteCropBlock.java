package net.chuck.chucksmod.block.custom.crop.magical;

import net.chuck.chucksmod.block.ModBlockTags;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class NetheriteCropBlock extends AbstractMagicalCropBlock {
    public NetheriteCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.NETHERITE_SEEDS;
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.NETHERITE_BLOCK) || floor.isOf(Blocks.ANCIENT_DEBRIS);
    }
}
