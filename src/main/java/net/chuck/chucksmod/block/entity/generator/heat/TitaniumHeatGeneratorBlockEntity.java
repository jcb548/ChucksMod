package net.chuck.chucksmod.block.entity.generator.heat;
import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TitaniumHeatGeneratorBlockEntity extends AbstractHeatGeneratorBlockEntity implements TitaniumTier {
    public TitaniumHeatGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_HEAT_GENERATOR, pos, state, GENERATION, MACHINE_ENERGY_STORAGE);
    }
    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.titanium_heat_generator");
    }

    @Override
    public int getGeneration() {
        return GENERATION;
    }

    @Override
    public int getMaxExtract() {
        return GEN_MAX_EXTRACT;
    }

    @Override
    public int getEnergyStorageCapacity() {
        return MACHINE_ENERGY_STORAGE;
    }
}
