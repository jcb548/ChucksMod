package net.chuck.chucksmod.block.entity.generator.lava;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TitaniumLavaGeneratorBlockEntity extends AbstractLavaGeneratorBlockEntity implements TitaniumTier {
    public TitaniumLavaGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_LAVA_GENERATOR, pos, state, 0, GENERATION, MACHINE_ENERGY_STORAGE);
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
        return Text.translatable("block.chucksmod.titanium_lava_generator");
    }
}
