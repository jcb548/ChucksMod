package net.chuck.chucksmod.block.entity.fluid_tank;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class IronFluidTankBlockEntity extends AbstractFluidTankBlockEntity implements IronTier {
    public IronFluidTankBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_FLUID_TANK, pos, state);
    }

    @Override
    public int getFluidCapacity() {
        return FLUID_TANK_BUCKETS;
    }
}
