package net.chuck.chucksmod.world.tree;


import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.mixin.FoliagePlacerTypeInvoker;
import net.chuck.chucksmod.world.tree.custom.FabiaFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> FABIA_FOLIAGE_PLACER =
            FoliagePlacerTypeInvoker.callRegister("fabia_foliage_placer", FabiaFoliagePlacer.CODEC);
    public static void register(){
        ChucksMod.LOGGER.info("Registering Foliage Placer for " + ChucksMod.MOD_ID);
    }
}
