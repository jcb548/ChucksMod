package net.chuck.chucksmod.block.entity.energy_storage;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TriafiumEnergyStorageBlockEntity extends AbstractEnergyStorageBlockEntity implements TriafiumTier {
    public TriafiumEnergyStorageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_ENERGY_STORAGE, pos, state, ENERGY_STORAGE, ENERGY_STORAGE_INSERT_EXTRACT);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_energy_storage");
    }
}
