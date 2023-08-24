package net.chuck.pigsnstuff.world.gen;

import net.chuck.pigsnstuff.world.ModOrePlacement;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModWorldGeneration {
    public static void generateModWorldGen(){
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
    }
}
