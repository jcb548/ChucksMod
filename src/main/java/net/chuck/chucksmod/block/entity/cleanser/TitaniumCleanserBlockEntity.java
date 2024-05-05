package net.chuck.chucksmod.block.entity.cleanser;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TitaniumCleanserBlockEntity extends AbstractCleanserBlockEntity implements TitaniumTier {
    public TitaniumCleanserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_CLEANSER, pos, state, MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return MEDIUM_USAGE;
    }

    @Override
    public int getXpDrainRate() {
        return XP_DRAIN_RATE;
    }

    @Override
    public int getBucketCapacity() {
        return MACHINE_BUCKET_STORAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.titanium_cleanser");
    }
}
