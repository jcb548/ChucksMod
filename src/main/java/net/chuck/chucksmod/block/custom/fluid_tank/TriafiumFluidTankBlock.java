package net.chuck.chucksmod.block.custom.fluid_tank;

import net.chuck.chucksmod.block.entity.fluid_tank.TriafiumFluidTankBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TriafiumFluidTankBlock extends AbstractFluidTankBlock{
    public TriafiumFluidTankBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TriafiumFluidTankBlockEntity(pos, state);
    }
}
