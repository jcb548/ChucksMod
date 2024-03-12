package net.chuck.chucksmod.world.gen;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOtherFeatureGeneration {
    public static void generate(){
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.NETHER_CRYSTAL_CROP_PLACED_KEY);
    }
}
