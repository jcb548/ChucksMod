package net.chuck.chucksmod.block.entity.fluid_tank;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TriafiumFluidTankBlockEntity extends AbstractFluidTankBlockEntity implements TriafiumTier {
    public TriafiumFluidTankBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_FLUID_TANK, pos, state);
    }

    @Override
    public int getBucketCapacity() {
        return FLUID_TANK_BUCKETS;
    }

    @Override
    public int getXpDrainRate() {
        return XP_DRAIN_RATE;
    }
}
