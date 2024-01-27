package net.chuck.chucksmod.world.tree;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.ChucksModClient;
import net.chuck.chucksmod.mixin.TrunkPlacerTypeInvoker;
import net.chuck.chucksmod.world.tree.custom.FabiaTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static TrunkPlacerType<?> FABIA_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("fabia_trunk_placer",
            FabiaTrunkPlacer.CODEC);
    public static void register(){
        ChucksMod.LOGGER.info("Registering Trunk Placers for " + ChucksMod.MOD_ID);
    }
}
