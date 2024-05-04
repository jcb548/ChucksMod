package net.chuck.chucksmod.world;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.mixin.FeatureInvoker;
import net.chuck.chucksmod.world.vegetation.TriafianVineFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {
    public static final Feature<DefaultFeatureConfig> TRIAFIAN_VINES = FeatureInvoker.callRegister("triafian_vines",
            new TriafianVineFeature(DefaultFeatureConfig.CODEC));

    public static void register(){
        ChucksMod.LOGGER.info("Registering Features for " + ChucksMod.MOD_ID);
    }
}
