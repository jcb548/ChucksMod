package net.chuck.pigsnstuff.world.gen;

import net.chuck.pigsnstuff.world.ModOrePlacement;

public class ModWorldGeneration {
    public static void generateModWorldGen(){
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
    }
}
