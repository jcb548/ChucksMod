package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.custom.ModItemGroups;
import net.chuck.pigsnstuff.item.custom.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT,
                0.7f, 200, "tin_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TIN_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.TIN_BLOCK);
    }
}
