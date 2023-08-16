package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
        offerBlasting(exporter, List.of(ModItems.RAW_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT,
                0.7f, 100, "tin_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TIN_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.TIN_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRISMARINE_INGOT)
                .pattern("scs").pattern("cic").pattern("scs")
                .input('s', Items.PRISMARINE_SHARD)
                .input('c', Items.PRISMARINE_CRYSTALS)
                .input('i', Items.IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.PRISMARINE_SHARD),
                        FabricRecipeProvider.conditionsFromItem(Items.PRISMARINE_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.PRISMARINE_CRYSTALS),
                        FabricRecipeProvider.conditionsFromItem(Items.PRISMARINE_CRYSTALS))
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PRISMARINE_SWORD)
                .pattern("P").pattern("P").pattern("S")
                .input('P', ModItems.PRISMARINE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PRISMARINE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PRISMARINE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRISMARINE_PICKAXE)
                .pattern("PPP").pattern(" S ").pattern(" S ")
                .input('P', ModItems.PRISMARINE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PRISMARINE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PRISMARINE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRISMARINE_AXE)
                .pattern("PP").pattern("PS").pattern(" S")
                .input('P', ModItems.PRISMARINE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PRISMARINE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PRISMARINE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRISMARINE_SHOVEL)
                .pattern("P").pattern("S").pattern("S")
                .input('P', ModItems.PRISMARINE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PRISMARINE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PRISMARINE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRISMARINE_HOE)
                .pattern("PP").pattern(" S").pattern(" S")
                .input('P', ModItems.PRISMARINE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PRISMARINE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PRISMARINE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        offerSmelting(exporter, List.of(ModItems.RAW_FABIUM), RecipeCategory.MISC, ModItems.FABIUM_INGOT,
                1.0f, 200, "fabium_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_FABIUM), RecipeCategory.MISC, ModItems.FABIUM_INGOT,
                1.0f, 100, "fabium_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_FABIUM,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_FABIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FABIUM_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.FABIUM_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FABIUM_SWORD)
                .pattern("F").pattern("F").pattern("S")
                .input('F', ModItems.FABIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FABIUM_PICKAXE)
                .pattern("FFF").pattern(" S ").pattern(" S ")
                .input('F', ModItems.FABIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FABIUM_AXE)
                .pattern("FF").pattern("FS").pattern(" S")
                .input('F', ModItems.FABIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FABIUM_SHOVEL)
                .pattern("F").pattern("S").pattern("S")
                .input('F', ModItems.FABIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FABIUM_HOE)
                .pattern("FF").pattern(" S").pattern(" S")
                .input('F', ModItems.FABIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        offerSmelting(exporter, List.of(ModItems.RAW_DIRITONIUM), RecipeCategory.MISC, ModItems.DIRITONIUM_INGOT,
                1.3f, 200, "diritonium_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_DIRITONIUM), RecipeCategory.MISC, ModItems.DIRITONIUM_INGOT,
                1.3f, 100, "diritonium_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_DIRITONIUM,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_DIRITONIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.DIRITONIUM_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.DIRITONIUM_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DIRITONIUM_SWORD)
                .pattern("D").pattern("D").pattern("S")
                .input('D', ModItems.DIRITONIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIRITONIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIRITONIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DIRITONIUM_PICKAXE)
                .pattern("DDD").pattern(" S ").pattern(" S ")
                .input('D', ModItems.DIRITONIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIRITONIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIRITONIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DIRITONIUM_AXE)
                .pattern("DD").pattern("DS").pattern(" S")
                .input('D', ModItems.DIRITONIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIRITONIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIRITONIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DIRITONIUM_SHOVEL)
                .pattern("D").pattern("S").pattern("S")
                .input('D', ModItems.DIRITONIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIRITONIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIRITONIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DIRITONIUM_HOE)
                .pattern("DD").pattern(" S").pattern(" S")
                .input('D', ModItems.DIRITONIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIRITONIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIRITONIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        offerShapelessRecipe(exporter, ModBlocks.EUCALYPTUS_PLANKS, ModBlocks.EUCALYPTUS_LOG,
                "eucalyptus_planks", 4);
        offerShapelessRecipe(exporter, ModBlocks.EUCALYPTUS_PLANKS, ModBlocks.EUCALYPTUS_WOOD,
                "eucalyptus_planks", 4);
        offerShapelessRecipe(exporter, ModBlocks.EUCALYPTUS_PLANKS, ModBlocks.STRIPPED_EUCALYPTUS_LOG,
                "eucalyptus_planks", 4);
        offerShapelessRecipe(exporter, ModBlocks.EUCALYPTUS_PLANKS, ModBlocks.STRIPPED_EUCALYPTUS_WOOD,
                "eucalyptus_planks", 4);
        createDoorRecipe(ModBlocks.EUCALYPTUS_DOOR, Ingredient.ofItems(ModBlocks.EUCALYPTUS_PLANKS))
                .criterion(hasItem(ModBlocks.EUCALYPTUS_PLANKS), conditionsFromItem(ModBlocks.EUCALYPTUS_PLANKS))
                .offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.EUCALYPTUS_TRAPDOOR, Ingredient.ofItems(ModBlocks.EUCALYPTUS_PLANKS))
                .criterion(hasItem(ModBlocks.EUCALYPTUS_PLANKS), conditionsFromItem(ModBlocks.EUCALYPTUS_PLANKS))
                .offerTo(exporter, "eucalyptus_trapdoor_from_planks");
        createFenceRecipe(ModBlocks.EUCALYPTUS_FENCE, Ingredient.ofItems(ModBlocks.EUCALYPTUS_PLANKS))
                .criterion(hasItem(ModBlocks.EUCALYPTUS_PLANKS), conditionsFromItem(ModBlocks.EUCALYPTUS_PLANKS))
                .offerTo(exporter);
        createFenceGateRecipe(ModBlocks.EUCALYPTUS_FENCE_GATE, Ingredient.ofItems(ModBlocks.EUCALYPTUS_PLANKS))
                .criterion(hasItem(ModBlocks.EUCALYPTUS_PLANKS), conditionsFromItem(ModBlocks.EUCALYPTUS_PLANKS))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EUCALYPTUS_SLAB,
                Ingredient.ofItems(ModBlocks.EUCALYPTUS_PLANKS))
                .criterion(hasItem(ModBlocks.EUCALYPTUS_PLANKS), conditionsFromItem(ModBlocks.EUCALYPTUS_PLANKS))
                .offerTo(exporter);
        createStairsRecipe(ModBlocks.EUCALYPTUS_STAIRS, Ingredient.ofItems(ModBlocks.EUCALYPTUS_PLANKS))
                .criterion(hasItem(ModBlocks.EUCALYPTUS_PLANKS), conditionsFromItem(ModBlocks.EUCALYPTUS_PLANKS))
                .offerTo(exporter);
    }
}
