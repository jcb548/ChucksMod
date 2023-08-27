package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.BlockTags;

import java.util.List;
import java.util.function.Consumer;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // Vanilla Resource Dust smelting and block crafting
        offerSmelting(exporter, List.of(ModItems.IRON_DUST), RecipeCategory.MISC, Items.IRON_INGOT,
                0.7f, 200, "iron_ingot");
        offerBlasting(exporter, List.of(ModItems.IRON_DUST), RecipeCategory.MISC, Items.IRON_INGOT,
                0.7f, 100, "iron_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModItems.IRON_DUST,
                RecipeCategory.DECORATIONS, ModBlocks.IRON_DUST_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModItems.IRON_GEAR)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', Items.IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        offerSmelting(exporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT,
                0.7f, 200, "copper_ingot");
        offerBlasting(exporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT,
                0.7f, 100, "copper_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModItems.COPPER_DUST,
                RecipeCategory.DECORATIONS, ModBlocks.COPPER_DUST_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModItems.COPPER_GEAR)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', Items.COPPER_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
        offerSmelting(exporter, List.of(ModItems.GOLD_DUST), RecipeCategory.MISC, Items.GOLD_INGOT,
                0.7f, 200, "gold_ingot");
        offerBlasting(exporter, List.of(ModItems.GOLD_DUST), RecipeCategory.MISC, Items.GOLD_INGOT,
                0.7f, 100, "gold_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModItems.GOLD_DUST,
                RecipeCategory.DECORATIONS, ModBlocks.GOLD_DUST_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModItems.GOLD_GEAR)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

        //Tin
        offerSmelting(exporter, List.of(ModItems.RAW_TIN), RecipeCategory.TOOLS, ModItems.TIN_INGOT,
                0.7f, 200, "tin_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_TIN), RecipeCategory.TOOLS, ModItems.TIN_INGOT,
                0.7f, 100, "tin_ingot");
        offerSmelting(exporter, List.of(ModItems.TIN_DUST), RecipeCategory.TOOLS, ModItems.TIN_INGOT,
                0.7f, 200, "tin_ingot");
        offerBlasting(exporter, List.of(ModItems.TIN_DUST), RecipeCategory.TOOLS, ModItems.TIN_INGOT,
                0.7f, 100, "tin_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModItems.TIN_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.TIN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModItems.TIN_DUST,
                RecipeCategory.DECORATIONS, ModBlocks.TIN_DUST_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModItems.TIN_GEAR)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', ModItems.TIN_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter);
        // Bronze
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS,
                ModItems.BRONZE_DUST,
                RecipeCategory.DECORATIONS,
                ModBlocks.BRONZE_DUST_BLOCK);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_DUST, 4)
                .input(ModItems.COPPER_DUST)
                .input(ModItems.COPPER_DUST)
                .input(ModItems.COPPER_DUST)
                .input(ModItems.TIN_DUST)
                .criterion(FabricRecipeProvider.hasItem(ModItems.COPPER_DUST),
                        FabricRecipeProvider.conditionsFromItem(ModItems.COPPER_DUST))
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_DUST),
                        FabricRecipeProvider.conditionsFromItem(ModItems.TIN_DUST))
                .offerTo(exporter, "bronze_dust_from_copper_and_tin");
        offerSmelting(exporter,
                List.of(ModItems.BRONZE_DUST),
                RecipeCategory.TOOLS,
                ModItems.BRONZE_INGOT,
                1f,
                200,
                "prismarine_ingot");
        offerBlasting(exporter,
                List.of(ModItems.BRONZE_DUST),
                RecipeCategory.TOOLS,
                ModItems.BRONZE_INGOT,
                1f,
                100,
                "prismarine_ingot");
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModItems.BRONZE_GEAR)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', ModItems.BRONZE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_SWORD)
                .pattern("B")
                .pattern("B")
                .pattern("S")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_AXE)
                .pattern("BB").pattern("BS").pattern(" S")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL)
                .pattern("B").pattern("S").pattern("S")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HOE)
                .pattern("BB").pattern(" S").pattern(" S")
                .input('B', ModItems.BRONZE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        // Prismarine
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRISMARINE_IRON_DUST, 2)
                .pattern(" P ")
                .pattern("PIP")
                .pattern(" P ")
                .input('P', ModItems.PRISMARINE_DUST)
                .input('I', ModItems.IRON_DUST)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PRISMARINE_DUST),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PRISMARINE_DUST))
                .criterion(FabricRecipeProvider.hasItem(ModItems.IRON_DUST),
                        FabricRecipeProvider.conditionsFromItem(ModItems.IRON_DUST))
                .offerTo(exporter);
        offerSmelting(exporter,
                List.of(ModItems.PRISMARINE_IRON_DUST),
                RecipeCategory.TOOLS,
                ModItems.PRISMARINE_INGOT,
                2f,
                200,
                "prismarine_ingot");
        offerBlasting(exporter,
                List.of(ModItems.PRISMARINE_IRON_DUST),
                RecipeCategory.TOOLS,
                ModItems.PRISMARINE_INGOT,
                2f,
                100,
                "prismarine_ingot");
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS,
                ModItems.PRISMARINE_DUST,
                RecipeCategory.DECORATIONS,
                ModBlocks.PRISMARINE_DUST_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModItems.PRISMARINE_GEAR)
                .pattern(" P ")
                .pattern("P P")
                .pattern(" P ")
                .input('P', ModItems.PRISMARINE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PRISMARINE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PRISMARINE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PRISMARINE_SWORD)
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .input('P', ModItems.PRISMARINE_INGOT)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PRISMARINE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PRISMARINE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRISMARINE_PICKAXE)
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
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

        offerSmelting(exporter, List.of(ModItems.RAW_FABIUM), RecipeCategory.TOOLS, ModItems.FABIUM_INGOT,
                1.0f, 200, "fabium_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_FABIUM), RecipeCategory.TOOLS, ModItems.FABIUM_INGOT,
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FABIUM_HELMET)
                .pattern("FFF").pattern("F F")
                .input('F', ModItems.FABIUM_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FABIUM_CHESTPLATE)
                .pattern("F F").pattern("FFF").pattern("FFF")
                .input('F', ModItems.FABIUM_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FABIUM_LEGGINGS)
                .pattern("FFF").pattern("F F").pattern("F F")
                .input('F', ModItems.FABIUM_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FABIUM_BOOTS)
                .pattern("F F").pattern("F F")
                .input('F', ModItems.FABIUM_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FABIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FABIUM_INGOT))
                .offerTo(exporter);

        offerSmelting(exporter, List.of(ModItems.RAW_DIRITONIUM), RecipeCategory.TOOLS, ModItems.DIRITONIUM_INGOT,
                1.3f, 200, "diritonium_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_DIRITONIUM), RecipeCategory.TOOLS, ModItems.DIRITONIUM_INGOT,
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
                .offerTo(exporter);
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

        offerShapelessRecipe(exporter, ModBlocks.DIRITIA_PLANKS, ModBlocks.DIRITIA_LOG,
                "diritia_planks", 4);
        offerShapelessRecipe(exporter, ModBlocks.DIRITIA_PLANKS, ModBlocks.DIRITIA_WOOD,
                "diritia_planks", 4);
        offerShapelessRecipe(exporter, ModBlocks.DIRITIA_PLANKS, ModBlocks.STRIPPED_DIRITIA_LOG,
                "diritia_planks", 4);
        offerShapelessRecipe(exporter, ModBlocks.DIRITIA_PLANKS, ModBlocks.STRIPPED_DIRITIA_WOOD,
                "diritia_planks", 4);
        createDoorRecipe(ModBlocks.DIRITIA_DOOR, Ingredient.ofItems(ModBlocks.DIRITIA_PLANKS))
                .criterion(hasItem(ModBlocks.DIRITIA_PLANKS), conditionsFromItem(ModBlocks.DIRITIA_PLANKS))
                .offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.DIRITIA_TRAPDOOR, Ingredient.ofItems(ModBlocks.DIRITIA_PLANKS))
                .criterion(hasItem(ModBlocks.DIRITIA_PLANKS), conditionsFromItem(ModBlocks.DIRITIA_PLANKS))
                .offerTo(exporter);
        createFenceRecipe(ModBlocks.DIRITIA_FENCE, Ingredient.ofItems(ModBlocks.DIRITIA_PLANKS))
                .criterion(hasItem(ModBlocks.DIRITIA_PLANKS), conditionsFromItem(ModBlocks.DIRITIA_PLANKS))
                .offerTo(exporter);
        createFenceGateRecipe(ModBlocks.DIRITIA_FENCE_GATE, Ingredient.ofItems(ModBlocks.DIRITIA_PLANKS))
                .criterion(hasItem(ModBlocks.DIRITIA_PLANKS), conditionsFromItem(ModBlocks.DIRITIA_PLANKS))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIRITIA_SLAB,
                Ingredient.ofItems(ModBlocks.DIRITIA_PLANKS))
                .criterion(hasItem(ModBlocks.DIRITIA_PLANKS), conditionsFromItem(ModBlocks.DIRITIA_PLANKS))
                .offerTo(exporter);
        createStairsRecipe(ModBlocks.DIRITIA_STAIRS, Ingredient.ofItems(ModBlocks.DIRITIA_PLANKS))
                .criterion(hasItem(ModBlocks.DIRITIA_PLANKS), conditionsFromItem(ModBlocks.DIRITIA_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRUSHER)
                .pattern("CPC")
                .pattern("GDG")
                .pattern("C C")
                .input('C', Blocks.COBBLESTONE)
                .input('G', ModItems.IRON_GEAR)
                .input('P', Blocks.PISTON)
                .input('D', Items.DIAMOND)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.IRON_GEAR),
                        FabricRecipeProvider.conditionsFromItem(ModItems.IRON_GEAR))
                .criterion(FabricRecipeProvider.hasItem(Blocks.PISTON),
                        FabricRecipeProvider.conditionsFromItem(Blocks.PISTON))
                .criterion(FabricRecipeProvider.hasItem(Items.DIAMOND),
                        FabricRecipeProvider.conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
    }
}
