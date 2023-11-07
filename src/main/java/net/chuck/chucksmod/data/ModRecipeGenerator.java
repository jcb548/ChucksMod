package net.chuck.chucksmod.data;

import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.entity.ModBoats;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

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
    public void generate(RecipeExporter exporter) {
        generateVanillaDustSmeltingAndBlockRecipes(exporter);
        generateCopperRecipes(exporter);
        generateGoldRecipes(exporter);
        generateTinRecipes(exporter);
        generateBronzeRecipes(exporter);
        generatePrismarineRecipes(exporter);
        generateFabiumRecipes(exporter);
        generateDiritonoumRecipes(exporter);
        generateEucalyptusRecipes(exporter);
        generateDiritiaWoodRecipes(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRUSHER)
                .pattern("CPC")
                .pattern("GDG")
                .pattern("C C")
                .input('C', Blocks.COBBLESTONE)
                .input('G', ModItems.IRON_GEAR)
                .input('P', Blocks.PISTON)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.IRON_INGOT),
                        conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.IRON_GEAR),
                        conditionsFromItem(ModItems.IRON_GEAR))
                .criterion(hasItem(Blocks.PISTON),
                        conditionsFromItem(Blocks.PISTON))
                .criterion(hasItem(Items.DIAMOND),
                        conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        generateHardenedGlassRecipes(exporter);
        generateBagRecipes(exporter);
        generateIronMachineRecipes(exporter);
    }

    private void generateIronMachineRecipes(RecipeExporter exporter) {
        offerPowerAcceptorRecipe(exporter, ModBlocks.COPPER_WIRE.asItem(), ModItems.COPPER_POWER_ACCEPTOR);
        offerMachineBaseRecipe(exporter, Items.IRON_INGOT, ModItems.IRON_GEAR, ModBlocks.IRON_MACHINE_BASE.asItem());
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.IRON_HEAT_GENERATOR)
                .pattern(" P ")
                .pattern("WMW")
                .pattern("IFI")
                .input('P', ModItems.COPPER_POWER_ACCEPTOR)
                .input('W', ModBlocks.COPPER_WIRE)
                .input('M', ModBlocks.IRON_MACHINE_BASE)
                .input('I', Items.IRON_INGOT)
                .input('F', Blocks.FURNACE)
                .criterion(hasItem(ModItems.COPPER_POWER_ACCEPTOR),
                        conditionsFromItem(ModItems.COPPER_POWER_ACCEPTOR))
                .criterion(hasItem(ModBlocks.COPPER_WIRE),
                        conditionsFromItem(ModBlocks.COPPER_WIRE))
                .criterion(hasItem(ModBlocks.IRON_MACHINE_BASE),
                        conditionsFromItem(ModBlocks.IRON_MACHINE_BASE))
                .criterion(hasItem(Items.IRON_INGOT),
                        conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Blocks.FURNACE),
                        conditionsFromItem(Blocks.FURNACE))
                .offerTo(exporter);
    }

    public static String hasTag(TagKey<Item> material){
        return "has_" + material.id().getPath();
    }

    private void generateDiritiaWoodRecipes(RecipeExporter exporter) {
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
        createSignRecipe(ModItems.DIRITIA_SIGN, Ingredient.ofItems(ModBlocks.DIRITIA_PLANKS))
                .criterion(hasItem(ModBlocks.DIRITIA_PLANKS), conditionsFromItem(ModBlocks.DIRITIA_PLANKS))
                .offerTo(exporter);
        offerHangingSignRecipe(exporter, ModItems.HANGING_DIRITIA_SIGN, ModBlocks.DIRITIA_PLANKS);
        offerSmelting(exporter,
                List.of(ModBlocks.DIRITIA_LOG, ModBlocks.STRIPPED_DIRITIA_LOG,
                        ModBlocks.DIRITIA_WOOD, ModBlocks.STRIPPED_DIRITIA_WOOD),
                RecipeCategory.MISC,
                Items.CHARCOAL,
                2f,
                100,
                "charcoal");
        offerBoatRecipe(exporter, ModItems.DIRITIA_BOAT, ModBlocks.DIRITIA_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.DIRITIA_CHEST_BOAT, ModItems.DIRITIA_BOAT);
    }

    private void generateEucalyptusRecipes(RecipeExporter exporter) {
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
        createSignRecipe(ModItems.EUCALYPTUS_SIGN, Ingredient.ofItems(ModBlocks.EUCALYPTUS_PLANKS))
                .criterion(hasItem(ModBlocks.EUCALYPTUS_PLANKS), conditionsFromItem(ModBlocks.EUCALYPTUS_PLANKS))
                .offerTo(exporter);
        offerHangingSignRecipe(exporter, ModItems.HANGING_EUCALYPTUS_SIGN, ModBlocks.EUCALYPTUS_PLANKS);
        offerSmelting(exporter,
                List.of(ModBlocks.EUCALYPTUS_LOG, ModBlocks.STRIPPED_EUCALYPTUS_LOG,
                        ModBlocks.EUCALYPTUS_WOOD, ModBlocks.STRIPPED_EUCALYPTUS_WOOD),
                RecipeCategory.MISC,
                Items.CHARCOAL,
                2f,
                100,
                "charcoal");
        offerBoatRecipe(exporter, ModItems.EUCALYPTUS_BOAT, ModBlocks.EUCALYPTUS_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.EUCALYPTUS_CHEST_BOAT, ModItems.EUCALYPTUS_BOAT);
    }

    private void generateDiritonoumRecipes(RecipeExporter exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_DIRITONIUM), RecipeCategory.TOOLS, ModItems.DIRITONIUM_INGOT,
                1.3f, 200, "diritonium_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_DIRITONIUM), RecipeCategory.TOOLS, ModItems.DIRITONIUM_INGOT,
                1.3f, 100, "diritonium_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_DIRITONIUM,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_DIRITONIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.DIRITONIUM_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.DIRITONIUM_BLOCK);
        offerSwordRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_SWORD);
        offerPickaxeRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_PICKAXE);
        offerAxeRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_AXE);
        offerShovelRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_SHOVEL);
        offerHoeRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_HOE);
        offerHelmetRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_HELMET);
        offerChestplateRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_CHESTPLATE);
        offerLeggingsRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_LEGGINGS);
        offerBootsRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_BOOTS);
        offerGearRecipe(exporter, ModItems.DIRITONIUM_INGOT, ModItems.DIRITONIUM_GEAR);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.DIRITONIUM_BARS, ModItems.DIRITONIUM_INGOT);
        offerCompactingRecipe(exporter, RecipeCategory.MISC, ModItems.DIRITIA_CRYSTAL,
                ModItems.DIRITIA_CRYSTAL_SHARD);
    }

    private void generateFabiumRecipes(RecipeExporter exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_FABIUM), RecipeCategory.TOOLS, ModItems.FABIUM_INGOT,
                1.0f, 200, "fabium_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_FABIUM), RecipeCategory.TOOLS, ModItems.FABIUM_INGOT,
                1.0f, 100, "fabium_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_FABIUM,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_FABIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FABIUM_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.FABIUM_BLOCK);
        offerSwordRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_SWORD);
        offerPickaxeRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_PICKAXE);
        offerAxeRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_AXE);
        offerShovelRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_SHOVEL);
        offerHoeRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_HOE);
        offerHelmetRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_HELMET);
        offerChestplateRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_CHESTPLATE);
        offerLeggingsRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_LEGGINGS);
        offerBootsRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_BOOTS);
        offerGearRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_GEAR);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.FABIUM_BARS, ModItems.FABIUM_INGOT);
    }

    private void generatePrismarineRecipes(RecipeExporter exporter) {
        // Prismarine
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PRISMARINE_IRON_DUST, 2)
                .pattern(" P ")
                .pattern("PIP")
                .pattern(" P ")
                .input('P', ModItems.PRISMARINE_DUST)
                .input('I', ModItems.IRON_DUST)
                .criterion(hasItem(ModItems.PRISMARINE_DUST),
                        conditionsFromItem(ModItems.PRISMARINE_DUST))
                .criterion(hasItem(ModItems.IRON_DUST),
                        conditionsFromItem(ModItems.IRON_DUST))
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
        offerGearRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_GEAR);
        offerSwordRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_SWORD);
        offerPickaxeRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_PICKAXE);
        offerAxeRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_AXE);
        offerShovelRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_SHOVEL);
        offerHoeRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_HOE);
        offerHelmetRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_HELMET);
        offerChestplateRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_CHESTPLATE);
        offerLeggingsRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_LEGGINGS);
        offerBootsRecipe(exporter, ModItems.PRISMARINE_INGOT, ModItems.PRISMARINE_BOOTS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.PRISMARINE_BARS, ModItems.PRISMARINE_INGOT);
    }

    private void generateBronzeRecipes(RecipeExporter exporter) {
        // Bronze
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS,
                ModItems.BRONZE_DUST,
                RecipeCategory.DECORATIONS,
                ModBlocks.BRONZE_DUST_BLOCK);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_DUST, 4)
                .input(ModItems.COPPER_DUST, 3)
                .input(ModItems.TIN_DUST)
                .criterion(hasItem(ModItems.COPPER_DUST),
                        conditionsFromItem(ModItems.COPPER_DUST))
                .criterion(hasItem(ModItems.TIN_DUST),
                        conditionsFromItem(ModItems.TIN_DUST))
                .offerTo(exporter, "bronze_dust_from_copper_and_tin");
        offerSmelting(exporter,
                List.of(ModItems.BRONZE_DUST),
                RecipeCategory.TOOLS,
                ModItems.BRONZE_INGOT,
                1f,
                200,
                "bronze_ingot");
        offerBlasting(exporter,
                List.of(ModItems.BRONZE_DUST),
                RecipeCategory.TOOLS,
                ModItems.BRONZE_INGOT,
                1f,
                100,
                "bronze_ingot");
        offerGearRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_GEAR);
        offerSwordRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_SWORD);
        offerPickaxeRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_PICKAXE);
        offerAxeRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_AXE);
        offerShovelRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_SHOVEL);
        offerHoeRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_HOE);
        offerHelmetRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_HELMET);
        offerChestplateRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_CHESTPLATE);
        offerLeggingsRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_LEGGINGS);
        offerBootsRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_BOOTS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.BRONZE_BARS, ModItems.BRONZE_INGOT);
    }

    private void generateVanillaDustSmeltingAndBlockRecipes(RecipeExporter exporter) {
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
                .criterion(hasItem(Items.IRON_INGOT),
                        conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        offerSmelting(exporter, List.of(ModItems.GOLD_DUST), RecipeCategory.MISC, Items.GOLD_INGOT,
                0.7f, 200, "gold_ingot");
        offerBlasting(exporter, List.of(ModItems.GOLD_DUST), RecipeCategory.MISC, Items.GOLD_INGOT,
                0.7f, 100, "gold_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModItems.GOLD_DUST,
                RecipeCategory.DECORATIONS, ModBlocks.GOLD_DUST_BLOCK);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.GOLD_BARS, Items.GOLD_INGOT);
    }
    private void generateCopperRecipes(RecipeExporter exporter){
        offerSmelting(exporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT,
                0.7f, 200, "copper_ingot");
        offerBlasting(exporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT,
                0.7f, 100, "copper_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModItems.COPPER_DUST,
                RecipeCategory.DECORATIONS, ModBlocks.COPPER_DUST_BLOCK);
        offerGearRecipe(exporter, Items.COPPER_INGOT, ModItems.COPPER_GEAR);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.COPPER_BARS, Items.COPPER_INGOT);
        offerWireRecipe(exporter, Items.COPPER_INGOT, ModBlocks.COPPER_WIRE.asItem());
    }

    private void generateGoldRecipes(RecipeExporter exporter){
        offerGearRecipe(exporter, Items.GOLD_INGOT, ModItems.GOLD_GEAR);
        offerWireRecipe(exporter, Items.GOLD_INGOT, ModBlocks.GOLD_WIRE.asItem());
    }

    private void generateTinRecipes(RecipeExporter exporter) {
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
        offerGearRecipe(exporter, ModItemTags.TIN_INGOTS, ModItems.TIN_GEAR);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.TIN_BARS, ModItems.TIN_INGOT);
        offerWireRecipe(exporter, ModItemTags.TIN_INGOTS, ModBlocks.TIN_WIRE.asItem());
    }

    private void generateHardenedGlassRecipes(RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.OBSIDIAN_SAND, 2)
                .pattern(" D ")
                .pattern("DSD")
                .pattern(" D ")
                .input('D', ModItems.OBSIDIAN_DUST)
                .input('S', ItemTags.SAND)
                .group("obsidian_sand_from_sand")
                .criterion(hasItem(ModItems.OBSIDIAN_DUST),
                        conditionsFromItem(ModItems.OBSIDIAN_DUST))
                .offerTo(exporter);
        offerSmelting(exporter, List.of(ModBlocks.OBSIDIAN_SAND), RecipeCategory.MISC, ModBlocks.HARDENED_GLASS,
                2f, 200, "hardened_glass");
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.BLACK_DYE, ModBlocks.HARDENED_BLACK_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.BLUE_DYE, ModBlocks.HARDENED_BLUE_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.BROWN_DYE, ModBlocks.HARDENED_BROWN_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.CYAN_DYE, ModBlocks.HARDENED_CYAN_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.GRAY_DYE, ModBlocks.HARDENED_GRAY_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.GREEN_DYE, ModBlocks.HARDENED_GREEN_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.LIGHT_BLUE_DYE,
                ModBlocks.HARDENED_LIGHT_BLUE_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.LIGHT_GRAY_DYE,
                ModBlocks.HARDENED_LIGHT_GRAY_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.LIME_DYE, ModBlocks.HARDENED_LIME_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.MAGENTA_DYE, ModBlocks.HARDENED_MAGENTA_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.ORANGE_DYE, ModBlocks.HARDENED_ORANGE_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.PINK_DYE, ModBlocks.HARDENED_PINK_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.PURPLE_DYE, ModBlocks.HARDENED_PURPLE_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.RED_DYE, ModBlocks.HARDENED_RED_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.WHITE_DYE, ModBlocks.HARDENED_WHITE_GLASS);
        offerDyeingRecipe(exporter, ModItemTags.HARDENED_GLASS, Items.YELLOW_DYE, ModBlocks.HARDENED_YELLOW_GLASS);

        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_GLASS_PANE, ModBlocks.HARDENED_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_BLACK_GLASS_PANE, ModBlocks.HARDENED_BLACK_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_BLUE_GLASS_PANE, ModBlocks.HARDENED_BLUE_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_BROWN_GLASS_PANE, ModBlocks.HARDENED_BROWN_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_CYAN_GLASS_PANE, ModBlocks.HARDENED_CYAN_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_GRAY_GLASS_PANE, ModBlocks.HARDENED_GRAY_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_GREEN_GLASS_PANE, ModBlocks.HARDENED_GREEN_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_LIGHT_BLUE_GLASS_PANE, ModBlocks.HARDENED_LIGHT_BLUE_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_LIGHT_GRAY_GLASS_PANE, ModBlocks.HARDENED_LIGHT_GRAY_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_LIME_GLASS_PANE, ModBlocks.HARDENED_LIME_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_MAGENTA_GLASS_PANE, ModBlocks.HARDENED_MAGENTA_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_ORANGE_GLASS_PANE, ModBlocks.HARDENED_ORANGE_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_PINK_GLASS_PANE, ModBlocks.HARDENED_PINK_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_PURPLE_GLASS_PANE, ModBlocks.HARDENED_PURPLE_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_RED_GLASS_PANE, ModBlocks.HARDENED_RED_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_WHITE_GLASS_PANE, ModBlocks.HARDENED_WHITE_GLASS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.HARDENED_YELLOW_GLASS_PANE, ModBlocks.HARDENED_YELLOW_GLASS);
    }

    public static void offerSwordRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B")
                .pattern("B")
                .pattern("S")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }
    public static void offerSwordRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B")
                .pattern("B")
                .pattern("S")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerPickaxeRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerPickaxeRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerAxeRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BB")
                .pattern("BS")
                .pattern(" S")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerAxeRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BB")
                .pattern("BS")
                .pattern(" S")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerShovelRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B")
                .pattern("S")
                .pattern("S")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerShovelRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B")
                .pattern("S")
                .pattern("S")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerHoeRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BB")
                .pattern("S ")
                .pattern("S ")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerHoeRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BB")
                .pattern("S ")
                .pattern("S ")
                .input('B', material)
                .input('S', Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void offerHelmetRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern("B B")
                .input('B', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }
    public static void offerHelmetRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern("B B")
                .input('B', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }
    public static void offerChestplateRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }
    public static void offerChestplateRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }
    public static void offerLeggingsRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .criterion(hasTag(material), conditionsFromTag(material))
                .input('B', material)
                .offerTo(exporter);
    }
    public static void offerLeggingsRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }
    public static void offerBootsRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B B")
                .pattern("B B")
                .input('B', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }
    public static void offerBootsRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B B")
                .pattern("B B")
                .input('B', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }
    public static void offerGearRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }
    public static void offerGearRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }
    public static void offerWireRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output, 6)
                .pattern("##")
                .input('#', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }
    public static void offerWireRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output, 6)
                .pattern("##")
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }
    public static void offerDyeingRecipe(RecipeExporter exporter, TagKey<Item> input, Item dye, Block output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .input('G', input)
                .input('D', dye)
                .criterion(hasItem(dye), conditionsFromItem(dye))
                .criterion(hasTag(input), conditionsFromTag(input))
                .offerTo(exporter);
    }
    public static void offerDyeingRecipe(RecipeExporter exporter, Item input, Item dye, Block output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .input('G', input)
                .input('D', dye)
                .criterion(hasItem(input), conditionsFromItem(input))
                .criterion(hasItem(dye), conditionsFromItem(dye))
                .offerTo(exporter);
    }

    public void generateBagRecipes(RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STRING_STRAP, 1)
                .pattern("SSS")
                .pattern("S S")
                .input('S', Items.STRING)
                .criterion(hasItem(Items.STRING),
                        conditionsFromItem(Items.STRING))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEATHER_STRAP, 1)
                .pattern("SLS")
                .pattern("L L")
                .input('S', Items.STRING)
                .input('L', Items.LEATHER)
                .criterion(hasItem(Items.STRING),
                        conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.LEATHER),
                        conditionsFromItem(Items.LEATHER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WOOL_BAG, 1)
                .pattern("S S")
                .pattern("WWW")
                .pattern("WWW")
                .input('S', ModItems.STRING_STRAP)
                .input('W', ItemTags.WOOL)
                .criterion(hasItem(ModItems.STRING_STRAP),
                        conditionsFromItem(ModItems.STRING_STRAP))
                .offerTo(exporter);
        offerBagRecipe(exporter, Items.LEATHER, ModItems.LEATHER_BAG);
        offerBagRecipe(exporter, Items.COPPER_INGOT, ModItems.COPPER_BAG);
        offerBagRecipe(exporter, Items.IRON_INGOT, ModItems.IRON_BAG);
        offerBagRecipe(exporter, ModItemTags.BRONZE_INGOTS, ModItems.BRONZE_BAG);
        offerBagRecipe(exporter, ModItems.FABIUM_INGOT, ModItems.FABIUM_BAG);
        offerBagRecipe(exporter, Items.NETHERITE_INGOT, ModItems.NETHERITE_BAG);
    }

    public static void offerBagRecipe(RecipeExporter exporter, Item material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .pattern("S S")
                .pattern("MMM")
                .pattern("MMM")
                .input('S', ModItems.LEATHER_STRAP)
                .input('M', material)
                .criterion(hasItem(ModItems.LEATHER_STRAP), conditionsFromItem(ModItems.LEATHER_STRAP))
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerBagRecipe(RecipeExporter exporter, TagKey<Item> material, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .pattern("S S")
                .pattern("MMM")
                .pattern("MMM")
                .input('S', ModItems.LEATHER_STRAP)
                .input('M', material)
                .criterion(hasItem(ModItems.LEATHER_STRAP), conditionsFromItem(ModItems.LEATHER_STRAP))
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }
    public static void offerPowerAcceptorRecipe(RecipeExporter exporter, Item wire, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .pattern("WRW")
                .pattern("R R")
                .pattern("WRW")
                .input('R', Items.REDSTONE)
                .input('W', wire)
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);
    }
    public static void offerMachineBaseRecipe(RecipeExporter exporter, Item material, Item gear, Item output){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .pattern("MRM")
                .pattern("RGR")
                .pattern("MRM")
                .input('R', Items.REDSTONE)
                .input('M', material)
                .input('G', gear)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(gear), conditionsFromItem(gear))
                .offerTo(exporter);
    }
}
