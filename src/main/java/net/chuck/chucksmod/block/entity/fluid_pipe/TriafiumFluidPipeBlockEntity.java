package net.chuck.chucksmod.block.entity.fluid_pipe;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TriafiumFluidPipeBlockEntity extends AbstractFluidPipeBlockEntity implements TriafiumTier {
    public TriafiumFluidPipeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_FLUID_PIPE, pos, state);
    }

    @Override
    public long getTransferRate() {
        return FLUID_PIPE_TRANSFER_RATE;
    }
}
