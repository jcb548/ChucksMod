package net.chuck.chucksmod.block.entity.generator.heat;
import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TriafiumHeatGeneratorBlockEntity extends AbstractHeatGeneratorBlockEntity implements TriafiumTier {
    public TriafiumHeatGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_HEAT_GENERATOR, pos, state, GENERATION, MACHINE_ENERGY_STORAGE);
    }
    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_heat_generator");
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
