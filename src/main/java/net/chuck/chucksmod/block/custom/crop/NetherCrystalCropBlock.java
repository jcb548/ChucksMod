package net.chuck.chucksmod.block.custom.crop;

import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class NetherCrystalCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;
    public NetherCrystalCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.NETHER_CRYSTAL_SEEDS;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.BASE_STONE_NETHER) || floor.isIn(BlockTags.SOUL_FIRE_BASE_BLOCKS);
    }
}
