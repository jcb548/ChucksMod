package net.chuck.chucksmod.block.entity.fluid_tank;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TitaniumFluidTankBlockEntity extends AbstractFluidTankBlockEntity implements TitaniumTier {
    public TitaniumFluidTankBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_FLUID_TANK, pos, state);
    }

    @Override
    public int getBucketCapacity() {
        return FLUID_TANK_BUCKETS;
    }
}
