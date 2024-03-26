package net.chuck.chucksmod.block.entity.generator.steam;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TriafiumSteamGeneratorBlockEntity extends AbstractSteamGeneratorBlockEntity implements TriafiumTier {
    public TriafiumSteamGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_STEAM_GENERATOR, pos, state, GENERATION, MACHINE_ENERGY_STORAGE);
    }

    @Override
    public SingleVariantStorage<FluidVariant> getFluidStorage() {
        return fluidStorage;
    }

    @Override
    public int getBucketCapacity() {
        return MACHINE_BUCKET_STORAGE;
    }

    @Override
    public int getGeneration() {
        return GENERATION;
    }

    @Override
    public int getMaxExtract() {
        return MAX_INSERT_EXTRACT;
    }

    @Override
    public int getEnergyStorageCapacity() {
        return MACHINE_ENERGY_STORAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_steam_generator");
    }
}
