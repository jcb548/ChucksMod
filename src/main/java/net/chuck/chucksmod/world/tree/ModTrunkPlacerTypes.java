package net.chuck.chucksmod.world.tree;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.ChucksModClient;
import net.chuck.chucksmod.mixin.TrunkPlacerTypeInvoker;
import net.chuck.chucksmod.world.tree.custom.TriafiaTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static TrunkPlacerType<?> TRIAFIA_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("triafia_trunk_placer",
            TriafiaTrunkPlacer.CODEC);
    public static void register(){
        ChucksMod.LOGGER.info("Registering Trunk Placers for " + ChucksMod.MOD_ID);
    }
}
