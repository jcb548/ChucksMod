package net.chuck.chucksmod.block.entity.fluid_pipe;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TitaniumFluidPipeBlockEntity extends AbstractFluidPipeBlockEntity implements TitaniumTier {
    public TitaniumFluidPipeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_FLUID_PIPE, pos, state);
    }

    @Override
    public long getTransferRate() {
        return FLUID_PIPE_TRANSFER_RATE;
    }
}
