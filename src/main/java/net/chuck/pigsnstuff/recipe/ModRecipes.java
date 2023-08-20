package net.chuck.pigsnstuff.recipe;

import net.chuck.pigsnstuff.PigsNStuff;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(PigsNStuff.MOD_ID, CrusherRecipe.Serializer.ID),
                CrusherRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(PigsNStuff.MOD_ID, CrusherRecipe.Type.ID),
                CrusherRecipe.Type.INSTANCE);
    }
}
