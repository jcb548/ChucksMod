package net.chuck.chucksmod.block.custom.crop.magical;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class AbstractMagicalCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;
    public AbstractMagicalCropBlock(Settings settings) {
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
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i;
        if (world.getBaseLightLevel(pos, 0) >= 9 && (i = this.getAge(state)) < this.getMaxAge() && random.nextInt(16) == 0) {
            world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
        }
    }
}
