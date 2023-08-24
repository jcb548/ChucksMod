package net.chuck.pigsnstuff.recipe;

import net.chuck.pigsnstuff.PigsNStuff;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(PigsNStuff.MOD_ID, CrusherRecipe.Serializer.ID),
                CrusherRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(PigsNStuff.MOD_ID, CrusherRecipe.Type.ID),
                CrusherRecipe.Type.INSTANCE);
    }
}
