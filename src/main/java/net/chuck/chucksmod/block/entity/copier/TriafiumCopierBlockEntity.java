package net.chuck.chucksmod.block.entity.copier;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TriafiumCopierBlockEntity extends AbstractCopierBlockEntity implements TriafiumTier {
    public TriafiumCopierBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_COPIER, pos, state, MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return MEDIUM_USAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_copier");
    }

    @Override
    public int getXpDrainRate() {
        return XP_DRAIN_RATE;
    }

    @Override
    public int getBucketCapacity() {
        return MACHINE_BUCKET_STORAGE;
    }
}
