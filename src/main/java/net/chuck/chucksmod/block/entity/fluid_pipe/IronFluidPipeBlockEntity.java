package net.chuck.chucksmod.block.entity.fluid_pipe;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class IronFluidPipeBlockEntity extends AbstractFluidPipeBlockEntity implements IronTier {
    public IronFluidPipeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_FLUID_PIPE, pos, state);
    }

    @Override
    public long getTransferRate() {
        return FLUID_PIPE_TRANSFER_RATE;
    }
}
