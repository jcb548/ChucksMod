package net.chuck.chucksmod.block.entity.pump;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TriafiumPumpBlockEntity extends AbstractPumpBlockEntity implements TriafiumTier {
    public TriafiumPumpBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_PUMP, pos, state, MACHINE_ENERGY_STORAGE, PUMP_SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return LOW_USAGE;
    }

    @Override
    protected int getSize() {
        return PUMP_SIZE;
    }

    @Override
    public int getBucketCapacity() {
        return MACHINE_BUCKET_STORAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_pump");
    }
}
