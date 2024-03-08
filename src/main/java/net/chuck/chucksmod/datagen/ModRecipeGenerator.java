package net.chuck.chucksmod.datagen;

import com.sun.jna.platform.unix.X11;
import dev.architectury.platform.Mod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MossBlock;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
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
        generateSoulRecipes(exporter);
        generateTriafiumRecipes(exporter);
        generateWoodRecipes(exporter, ModItemTags.EUCALYPTUS_LOGS, ModBlocks.EUCALYPTUS_PLANKS, ModBlocks.EUCALYPTUS_SLAB, 
                ModBlocks.EUCALYPTUS_STAIRS, ModBlocks.EUCALYPTUS_DOOR, ModBlocks.EUCALYPTUS_TRAPDOOR, ModBlocks.EUCALYPTUS_FENCE,
                ModBlocks.EUCALYPTUS_FENCE_GATE, ModBlocks.EUCALYPTUS_BUTTON, ModItems.EUCALYPTUS_SIGN, 
                ModItems.HANGING_EUCALYPTUS_SIGN, ModItems.EUCALYPTUS_BOAT, ModItems.EUCALYPTUS_CHEST_BOAT);
        generateWoodRecipes(exporter, ModItemTags.TRIAFIA_LOGS, ModBlocks.TRIAFIA_PLANKS, ModBlocks.TRIAFIA_SLAB, 
                ModBlocks.TRIAFIA_STAIRS, ModBlocks.TRIAFIA_DOOR, ModBlocks.TRIAFIA_TRAPDOOR, ModBlocks.TRIAFIA_FENCE,
                ModBlocks.TRIAFIA_FENCE_GATE, ModBlocks.TRIAFIA_BUTTON, ModItems.TRIAFIA_SIGN, 
                ModItems.HANGING_TRIAFIA_SIGN, ModItems.TRIAFIA_BOAT, ModItems.TRIAFIA_CHEST_BOAT);
        generateWoodRecipes(exporter, ModItemTags.PACSARIA_LOGS, ModBlocks.PACSARIA_PLANKS, ModBlocks.PACSARIA_SLAB, 
                ModBlocks.PACSARIA_STAIRS, ModBlocks.PACSARIA_DOOR, ModBlocks.PACSARIA_TRAPDOOR, ModBlocks.PACSARIA_FENCE,
                ModBlocks.PACSARIA_FENCE_GATE, ModBlocks.PACSARIA_BUTTON, ModItems.PACSARIA_SIGN, 
                ModItems.HANGING_PACSARIA_SIGN, ModItems.PACSARIA_BOAT, ModItems.PACSARIA_CHEST_BOAT);
        generateTriafiaRecipes(exporter);
        generatePascariumRecipes(exporter);
        generateSandstoneRecipes(exporter);

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
        generateTitaniumRecipes(exporter);
        generateCustomSlabStairWallRecipes(exporter, Blocks.TUFF, ModBlocks.TUFF_SLAB, ModBlocks.TUFF_STAIRS, ModBlocks.TUFF_WALL);
        generateCustomStoneRecipes(exporter, ModBlocks.ECLOGITE, ModBlocks.ECLOGITE_SLAB, ModBlocks.ECLOGITE_STAIRS,
                ModBlocks.ECLOGITE_WALL, ModBlocks.ECLOGITE_BRICKS, ModBlocks.ECLOGITE_BRICK_SLAB,
                ModBlocks.ECLOGITE_BRICK_STAIRS, ModBlocks.ECLOGITE_BRICK_WALL, ModBlocks.POLISHED_ECLOGITE,
                ModBlocks.POLISHED_ECLOGITE_SLAB, ModBlocks.POLISHED_ECLOGITE_STAIRS, ModBlocks.POLISHED_ECLOGITE_WALL);
        generateCustomStoneRecipes(exporter, ModBlocks.SERPENTINITE, ModBlocks.SERPENTINITE_SLAB, ModBlocks.SERPENTINITE_STAIRS,
                ModBlocks.SERPENTINITE_WALL, ModBlocks.SERPENTINITE_BRICKS, ModBlocks.SERPENTINITE_BRICK_SLAB,
                ModBlocks.SERPENTINITE_BRICK_STAIRS, ModBlocks.SERPENTINITE_BRICK_WALL, ModBlocks.POLISHED_SERPENTINITE,
                ModBlocks.POLISHED_SERPENTINITE_SLAB, ModBlocks.POLISHED_SERPENTINITE_STAIRS, ModBlocks.POLISHED_SERPENTINITE_WALL);
        generateCustomStoneRecipes(exporter, ModBlocks.GLAUCONITE, ModBlocks.GLAUCONITE_SLAB, ModBlocks.GLAUCONITE_STAIRS,
                ModBlocks.GLAUCONITE_WALL, ModBlocks.GLAUCONITE_BRICKS, ModBlocks.GLAUCONITE_BRICK_SLAB,
                ModBlocks.GLAUCONITE_BRICK_STAIRS, ModBlocks.GLAUCONITE_BRICK_WALL, ModBlocks.POLISHED_GLAUCONITE,
                ModBlocks.POLISHED_GLAUCONITE_SLAB, ModBlocks.POLISHED_GLAUCONITE_STAIRS, ModBlocks.POLISHED_GLAUCONITE_WALL);
    }

    private void generateSandstoneRecipes(RecipeExporter exporter) {
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICKS,
                Blocks.SMOOTH_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_STAIRS,
                Blocks.SMOOTH_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_SLAB,
                Blocks.SMOOTH_SANDSTONE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_WALL,
                Blocks.SMOOTH_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_STAIRS,
                ModBlocks.SANDSTONE_BRICKS);
        RecipeProvider.createStairsRecipe(ModBlocks.SANDSTONE_BRICK_STAIRS,
                        Ingredient.ofItems(ModBlocks.SANDSTONE_BRICKS))
                .criterion(hasItem(ModBlocks.SANDSTONE_BRICKS),
                        conditionsFromItem(ModBlocks.SANDSTONE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_SLAB,
                ModBlocks.SANDSTONE_BRICKS, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_SLAB,
                ModBlocks.SANDSTONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_WALL,
                ModBlocks.SANDSTONE_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SANDSTONE_BRICK_WALL,
                ModBlocks.SANDSTONE_BRICKS);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BREWING, ModBlocks.SANDSTONE_BRICKS, Blocks.SMOOTH_SANDSTONE);
    }
    private void generateCustomStoneRecipes(RecipeExporter exporter, Block base, Block slab, Block stairs, Block wall,
                                            Block bricks, Block brickSlab, Block brickStairs, Block brickWall,
                                            Block polished, Block polishedSlab, Block polishedStairs, Block polishedWall) {
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, slab, base, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, stairs, base);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wall, base);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, bricks, base);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, brickSlab, base, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, brickStairs, base);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, brickWall, base);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, brickSlab, bricks, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, brickStairs, bricks);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, brickWall, bricks);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polished, base);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polishedSlab, base, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polishedStairs, base);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polishedWall, base);
        RecipeProvider.createStairsRecipe(stairs, Ingredient.ofItems(base))
                .criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter);
        RecipeProvider.createStairsRecipe(brickStairs, Ingredient.ofItems(bricks))
                .criterion(hasItem(bricks), conditionsFromItem(bricks)).offerTo(exporter);
        RecipeProvider.createStairsRecipe(polishedStairs, Ingredient.ofItems(polished))
                .criterion(hasItem(polished), conditionsFromItem(polished)).offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, slab,
                base);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, brickSlab,
                bricks);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polishedSlab,
                polished);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wall,
                base);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, brickWall,
                bricks);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polishedWall,
                polished);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polished, base);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, bricks, polished);
    }
    private void generateCustomSlabStairWallRecipes(RecipeExporter exporter, Block base, Block slab, Block stairs, Block wall) {
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, slab, base, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, stairs, base);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wall, base);
        RecipeProvider.createStairsRecipe(stairs, Ingredient.ofItems(base))
                .criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, slab,
                base);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wall,
                base);
    }

    private void generateSoulRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_GRAVEL)
                .pattern("#S#")
                .pattern("S#S")
                .pattern("#S#")
                .input('#', ModItems.STONE_DUST)
                .input('S', ModItems.SOUL_DUST)
                .criterion(hasItem(ModItems.STONE_DUST),
                        conditionsFromItem(ModItems.STONE_DUST))
                .criterion(hasItem(ModItems.SOUL_DUST),
                        conditionsFromItem(ModItems.SOUL_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.BLAZE_STAR)
                .pattern("RRR")
                .pattern("RLR")
                .pattern("RRR")
                .input('R', Items.BLAZE_ROD)
                .input('L', Blocks.SOUL_LANTERN)
                .criterion(hasItem(Items.BLAZE_ROD),
                        conditionsFromItem(Items.BLAZE_ROD))
                .criterion(hasItem(Blocks.SOUL_LANTERN),
                        conditionsFromItem(Blocks.SOUL_LANTERN))
                .offerTo(exporter);
        offerSmelting(exporter, List.of(ModBlocks.SOUL_GRAVEL),
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SOUL_STONE,
                2f,
                100,
                "soul_stone");
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICKS,
                ModBlocks.SOUL_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICK_STAIRS,
                ModBlocks.SOUL_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICK_SLAB,
                ModBlocks.SOUL_STONE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICK_WALL,
                ModBlocks.SOUL_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICK_STAIRS,
                ModBlocks.SOUL_STONE_BRICKS);
        RecipeProvider.createStairsRecipe(ModBlocks.SOUL_STONE_BRICK_STAIRS,
                        Ingredient.ofItems(ModBlocks.SOUL_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.SOUL_STONE_BRICKS),
                        conditionsFromItem(ModBlocks.SOUL_STONE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICK_SLAB,
                ModBlocks.SOUL_STONE_BRICKS, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICK_SLAB,
                ModBlocks.SOUL_STONE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICK_WALL,
                ModBlocks.SOUL_STONE_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICK_WALL,
                ModBlocks.SOUL_STONE_BRICKS);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BREWING, ModBlocks.SOUL_STONE_BRICKS, ModBlocks.SOUL_STONE);
    }

    private void generateIronMachineRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WRENCH)
                .pattern(" I ")
                .pattern(" II")
                .pattern("I  ")
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        offerMachineBaseRecipe(exporter, Items.IRON_INGOT, ModItems.IRON_GEAR, ModBlocks.IRON_MACHINE_BASE.asItem());
        offerPoweredFurnaceRecipe(exporter, ModBlocks.IRON_POWERED_FURNACE, ModItems.COPPER_POWER_CIRCUIT,
                ModBlocks.COPPER_WIRE, ModBlocks.IRON_MACHINE_BASE);
        offerPoweredCrusherRecipe(exporter, ModBlocks.IRON_POWERED_CRUSHER, ModItems.COPPER_POWER_CIRCUIT,
                ModBlocks.IRON_MACHINE_BASE, ModBlocks.COPPER_WIRE, ModItems.IRON_GEAR, ModItems.IRON_MOTOR);
        offerHeatGeneratorRecipe(exporter, ModBlocks.IRON_HEAT_GENERATOR, ModItems.COPPER_COIL,
                ModItems.COPPER_POWER_CIRCUIT, ModBlocks.COPPER_WIRE, ModBlocks.IRON_MACHINE_BASE);
        offerEnergyCoreRecipe(exporter, ModItems.IRON_ENERGY_CORE, Items.IRON_INGOT);
        offerEnergyStorageRecipe(exporter, ModBlocks.IRON_ENERGY_STORAGE, ModItems.COPPER_POWER_CIRCUIT,
                ModBlocks.COPPER_WIRE, ModBlocks.IRON_MACHINE_BASE, ModItems.IRON_ENERGY_CORE);
        offerAxleRecipe(exporter, ModItems.IRON_AXLE, Items.IRON_INGOT);
        offerMotorRecipe(exporter, ModItems.IRON_MOTOR, Items.IRON_INGOT, ModItems.IRON_AXLE, ModBlocks.COPPER_WIRE);
        offerQuarryRecipe(exporter, ModBlocks.IRON_QUARRY, ModBlocks.IRON_MACHINE_BASE, Items.IRON_PICKAXE,
                Items.IRON_SHOVEL, ModItems.COPPER_POWER_CIRCUIT, ModItems.IRON_MOTOR, ModBlocks.COPPER_WIRE);
        offerTankRecipe(exporter, ModBlocks.IRON_FLUID_TANK, Items.IRON_INGOT);
        offerPumpRecipe(exporter, ModBlocks.IRON_PUMP, ModBlocks.IRON_MACHINE_BASE, ModItems.COPPER_POWER_CIRCUIT,
                ModItems.IRON_MOTOR, ModItems.IRON_GEAR, ModBlocks.IRON_FLUID_TANK, ModBlocks.COPPER_WIRE);
        offerFluidPipeRecipe(exporter, ModBlocks.IRON_FLUID_PIPE, Items.IRON_INGOT);
        offerSteamGeneratorRecipe(exporter, ModBlocks.IRON_STEAM_GENERATOR, ModItems.COPPER_COIL, 
                ModItems.COPPER_POWER_CIRCUIT, ModBlocks.COPPER_WIRE, ModBlocks.IRON_MACHINE_BASE, ModBlocks.IRON_FLUID_TANK);
    }

    public static String hasTag(TagKey<Item> material) {
        return "has_" + material.id().getPath();
    }
    private void generateWoodRecipes(RecipeExporter exporter, TagKey<Item> logs, Block planks, Block slab, Block stairs,
                                     Block door, Block trapdoor, Block fence, Block fenceGate, Block button, Item sign,
                                     Item hangingSign, Item boat, Item chestBoat) {
        offerPlanksRecipe(exporter, planks, logs, 4);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, slab, planks);
        createStairsRecipe(stairs, Ingredient.ofItems(planks)).criterion(hasItem(planks), conditionsFromItem(planks))
                .offerTo(exporter);
        createDoorRecipe(door, Ingredient.ofItems(planks)).criterion(hasItem(planks), conditionsFromItem(planks))
                .offerTo(exporter);
        createTrapdoorRecipe(trapdoor, Ingredient.ofItems(planks)).criterion(hasItem(planks), conditionsFromItem(planks))
                .offerTo(exporter);
        createFenceRecipe(fence, Ingredient.ofItems(planks)).criterion(hasItem(planks), conditionsFromItem(planks))
                .offerTo(exporter);
        createFenceGateRecipe(fenceGate, Ingredient.ofItems(planks)).criterion(hasItem(planks), conditionsFromItem(planks))
                .offerTo(exporter);
        offerSingleOutputShapelessRecipe(exporter, button, planks, "button");
        createSignRecipe(sign, Ingredient.ofItems(planks)).criterion(hasItem(planks), conditionsFromItem(planks))
                .offerTo(exporter);
        offerHangingSignRecipe(exporter, hangingSign, planks);
        offerBoatRecipe(exporter, boat, planks);
        offerChestBoatRecipe(exporter, chestBoat, boat);
    }

    
    private void generateTriafiumRecipes(RecipeExporter exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_TRIAFIUM), RecipeCategory.TOOLS, ModItems.TRIAFIUM_INGOT,
                1.0f, 200, "triafium_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_TRIAFIUM), RecipeCategory.TOOLS, ModItems.TRIAFIUM_INGOT,
                1.0f, 100, "triafium_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TRIAFIUM,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_TRIAFIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TRIAFIUM_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.TRIAFIUM_BLOCK);
        offerSwordRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_SWORD);
        offerPickaxeRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_PICKAXE);
        offerAxeRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_AXE);
        offerShovelRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_SHOVEL);
        offerHoeRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_HOE);
        offerHelmetRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_HELMET);
        offerChestplateRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_CHESTPLATE);
        offerLeggingsRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_LEGGINGS);
        offerBootsRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_BOOTS);
        offerGearRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_GEAR);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.TRIAFIUM_BARS, ModItems.TRIAFIUM_INGOT);
    }
    private void generateTriafiaRecipes(RecipeExporter exporter) {
        offerCompactingRecipe(exporter, RecipeCategory.MISC, ModItems.TRIAFIA_CRYSTAL,
                ModItems.TRIAFIA_CRYSTAL_SHARD);
        offerSmelting(exporter, List.of(ModItems.TRIAFIAN_PORKCHOP), RecipeCategory.FOOD, ModItems.COOKED_TRIAFIAN_PORKCHOP,
                0.5f, 200, "triafian_porkchop");
        offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, 100,
                ModItems.TRIAFIAN_PORKCHOP, ModItems.COOKED_TRIAFIAN_PORKCHOP, 0.5f);
    }

    private void generatePascariumRecipes(RecipeExporter exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_PACSARIUM), RecipeCategory.TOOLS, ModItems.PACSARIUM_INGOT,
                1.3f, 200, "pacsarium_ingot");
        offerBlasting(exporter, List.of(ModItems.RAW_PACSARIUM), RecipeCategory.TOOLS, ModItems.PACSARIUM_INGOT,
                1.3f, 100, "pacsarium_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PACSARIUM,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_PACSARIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PACSARIUM_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.PACSARIUM_BLOCK);
        offerSwordRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_SWORD);
        offerPickaxeRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_PICKAXE);
        offerAxeRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_AXE);
        offerShovelRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_SHOVEL);
        offerHoeRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_HOE);
        offerHelmetRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_HELMET);
        offerChestplateRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_CHESTPLATE);
        offerLeggingsRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_LEGGINGS);
        offerBootsRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_BOOTS);
        offerGearRecipe(exporter, ModItems.PACSARIUM_INGOT, ModItems.PACSARIUM_GEAR);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.PACSARIUM_BARS, ModItems.PACSARIUM_INGOT);
        offerCompactingRecipe(exporter, RecipeCategory.MISC, ModItems.PACSARIA_CRYSTAL,
                ModItems.PACSARIA_CRYSTAL_SHARD);
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
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS,
                ModItems.BRONZE_INGOT,
                RecipeCategory.DECORATIONS,
                ModBlocks.BRONZE_BLOCK);
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

    private void generateTitaniumRecipes(RecipeExporter exporter) {
        // Titanium
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS,
                ModItems.TITANIUM_DUST,
                RecipeCategory.DECORATIONS,
                ModBlocks.TITANIUM_DUST_BLOCK);
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS,
                ModItems.TITANIUM_INGOT,
                RecipeCategory.DECORATIONS,
                ModBlocks.TITANIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.DECORATIONS,
                ModItems.RAW_TITANIUM,
                RecipeCategory.DECORATIONS,
                ModBlocks.RAW_TITANIUM_BLOCK);
        offerSmelting(exporter,
                List.of(ModItems.TITANIUM_DUST),
                RecipeCategory.TOOLS,
                ModItems.TITANIUM_INGOT,
                1f,
                200,
                "titanium_ingot");
        offerBlasting(exporter,
                List.of(ModItems.TITANIUM_DUST),
                RecipeCategory.TOOLS,
                ModItems.TITANIUM_INGOT,
                1f,
                100,
                "titanium_ingot");
        offerGearRecipe(exporter, ModItemTags.TITANIUM_INGOTS, ModItems.TITANIUM_GEAR);
        offerSwordRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_SWORD);
        offerPickaxeRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_PICKAXE);
        offerAxeRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_AXE);
        offerShovelRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_SHOVEL);
        offerHoeRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_HOE);
        offerHelmetRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_HELMET);
        offerChestplateRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_CHESTPLATE);
        offerLeggingsRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_LEGGINGS);
        offerBootsRecipe(exporter, ModItems.TITANIUM_INGOT, ModItems.TITANIUM_BOOTS);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.TITANIUM_BARS, ModItems.TITANIUM_INGOT);
        offerMachineBaseRecipe(exporter, ModItemTags.TITANIUM_INGOTS, ModItems.TITANIUM_GEAR,
                ModBlocks.TITANIUM_MACHINE_BASE.asItem());
        offerPoweredFurnaceRecipe(exporter, ModBlocks.TITANIUM_POWERED_FURNACE, ModItems.GOLD_POWER_CIRCUIT,
                ModBlocks.GOLD_WIRE, ModBlocks.TITANIUM_MACHINE_BASE);
        offerPoweredCrusherRecipe(exporter, ModBlocks.TITANIUM_POWERED_CRUSHER, ModItems.GOLD_POWER_CIRCUIT,
                ModBlocks.TITANIUM_MACHINE_BASE, ModBlocks.GOLD_WIRE, ModItems.TITANIUM_GEAR, ModItems.TITANIUM_MOTOR);
        offerHeatGeneratorRecipe(exporter, ModBlocks.TITANIUM_HEAT_GENERATOR, ModItems.GOLD_COIL,
                ModItems.GOLD_POWER_CIRCUIT, ModBlocks.GOLD_WIRE, ModBlocks.TITANIUM_MACHINE_BASE);
        offerEnergyCoreRecipe(exporter, ModItems.TITANIUM_ENERGY_CORE, ModItems.TITANIUM_INGOT);
        offerEnergyStorageRecipe(exporter, ModBlocks.TITANIUM_ENERGY_STORAGE, ModItems.GOLD_POWER_CIRCUIT,
                ModBlocks.GOLD_WIRE, ModBlocks.TITANIUM_MACHINE_BASE, ModItems.TITANIUM_ENERGY_CORE);
        offerAxleRecipe(exporter, ModItems.TITANIUM_AXLE, ModItemTags.TITANIUM_INGOTS);
        offerMotorRecipe(exporter, ModItems.TITANIUM_MOTOR, ModItemTags.TITANIUM_INGOTS, ModItems.TITANIUM_AXLE,
                ModBlocks.GOLD_WIRE);
        offerQuarryRecipe(exporter, ModBlocks.TITANIUM_QUARRY, ModBlocks.TITANIUM_MACHINE_BASE,
                ModItems.TITANIUM_PICKAXE, ModItems.TITANIUM_SHOVEL, ModItems.GOLD_POWER_CIRCUIT,
                ModItems.TITANIUM_MOTOR, ModBlocks.GOLD_WIRE);
        offerTankRecipe(exporter, ModBlocks.TITANIUM_FLUID_TANK, ModItemTags.TITANIUM_INGOTS);
        offerPumpRecipe(exporter, ModBlocks.TITANIUM_PUMP, ModBlocks.TITANIUM_MACHINE_BASE, ModItems.GOLD_POWER_CIRCUIT,
                ModItems.TITANIUM_MOTOR, ModItems.TITANIUM_GEAR, ModBlocks.TITANIUM_FLUID_TANK, ModBlocks.GOLD_WIRE);
        offerCopierRecipe(exporter, ModBlocks.TITANIUM_COPIER, ModBlocks.TITANIUM_MACHINE_BASE,
                ModItems.GOLD_POWER_CIRCUIT, ModBlocks.TITANIUM_FLUID_TANK, ModBlocks.GOLD_WIRE);
        offerFluidPipeRecipe(exporter, ModBlocks.TITANIUM_FLUID_PIPE, ModItemTags.TITANIUM_INGOTS);
        offerSteamGeneratorRecipe(exporter, ModBlocks.TITANIUM_STEAM_GENERATOR, ModItems.GOLD_COIL,
                ModItems.GOLD_POWER_CIRCUIT, ModBlocks.GOLD_WIRE, ModBlocks.TITANIUM_MACHINE_BASE,
                ModBlocks.TITANIUM_FLUID_TANK);
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

    private void generateCopperRecipes(RecipeExporter exporter) {
        offerSmelting(exporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT,
                0.7f, 200, "copper_ingot");
        offerBlasting(exporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT,
                0.7f, 100, "copper_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModItems.COPPER_DUST,
                RecipeCategory.DECORATIONS, ModBlocks.COPPER_DUST_BLOCK);
        offerGearRecipe(exporter, Items.COPPER_INGOT, ModItems.COPPER_GEAR);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.COPPER_BARS, Items.COPPER_INGOT);
        offerWireRecipe(exporter, Items.COPPER_INGOT, ModBlocks.COPPER_WIRE.asItem());
        offerCoilRecipe(exporter, ModBlocks.COPPER_WIRE.asItem(), ModItems.COPPER_COIL);
        offerPowerCircuitRecipe(exporter, ModBlocks.COPPER_WIRE.asItem(), ModItems.COPPER_POWER_CIRCUIT);
    }

    private void generateGoldRecipes(RecipeExporter exporter) {
        offerGearRecipe(exporter, Items.GOLD_INGOT, ModItems.GOLD_GEAR);
        offerWireRecipe(exporter, Items.GOLD_INGOT, ModBlocks.GOLD_WIRE.asItem());
        offerCoilRecipe(exporter, ModBlocks.GOLD_WIRE.asItem(), ModItems.GOLD_COIL);
        offerPowerCircuitRecipe(exporter, ModBlocks.GOLD_WIRE.asItem(), ModItems.GOLD_POWER_CIRCUIT);
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

    private void generateHardenedGlassRecipes(RecipeExporter exporter) {
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

    public static void offerSwordRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
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

    public static void offerSwordRecipe(RecipeExporter exporter, Item material, Item output) {
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

    public static void offerPickaxeRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
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

    public static void offerPickaxeRecipe(RecipeExporter exporter, Item material, Item output) {
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

    public static void offerAxeRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
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

    public static void offerAxeRecipe(RecipeExporter exporter, Item material, Item output) {
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

    public static void offerShovelRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
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

    public static void offerShovelRecipe(RecipeExporter exporter, Item material, Item output) {
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

    public static void offerHoeRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
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

    public static void offerHoeRecipe(RecipeExporter exporter, Item material, Item output) {
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

    public static void offerHelmetRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern("B B")
                .input('B', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }

    public static void offerHelmetRecipe(RecipeExporter exporter, Item material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern("B B")
                .input('B', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerChestplateRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }

    public static void offerChestplateRecipe(RecipeExporter exporter, Item material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerLeggingsRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .criterion(hasTag(material), conditionsFromTag(material))
                .input('B', material)
                .offerTo(exporter);
    }

    public static void offerLeggingsRecipe(RecipeExporter exporter, Item material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerBootsRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B B")
                .pattern("B B")
                .input('B', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }

    public static void offerBootsRecipe(RecipeExporter exporter, Item material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("B B")
                .pattern("B B")
                .input('B', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerGearRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }

    public static void offerGearRecipe(RecipeExporter exporter, Item material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerWireRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output, 6)
                .pattern("##")
                .input('#', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }

    public static void offerWireRecipe(RecipeExporter exporter, Item material, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output, 6)
                .pattern("##")
                .input('#', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerDyeingRecipe(RecipeExporter exporter, TagKey<Item> input, Item dye, Block output) {
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

    public static void offerDyeingRecipe(RecipeExporter exporter, Item input, Item dye, Block output) {
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

    public void generateBagRecipes(RecipeExporter exporter) {
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
        offerBagRecipe(exporter, ModItems.TRIAFIUM_INGOT, ModItems.TRIAFIUM_BAG);
        offerBagRecipe(exporter, Items.NETHERITE_INGOT, ModItems.NETHERITE_BAG);
    }

    public static void offerBagRecipe(RecipeExporter exporter, Item material, Item output) {
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

    public static void offerBagRecipe(RecipeExporter exporter, TagKey<Item> material, Item output) {
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

    public static void offerPowerCircuitRecipe(RecipeExporter exporter, Item wire, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .pattern("WRW")
                .pattern("RRR")
                .pattern("WRW")
                .input('R', Items.REDSTONE)
                .input('W', wire)
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);
    }

    public static void offerCoilRecipe(RecipeExporter exporter, Item wire, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 4)
                .pattern(" W ")
                .pattern("W W")
                .pattern(" W ")
                .input('W', wire)
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .offerTo(exporter);
    }

    public static void offerMachineBaseRecipe(RecipeExporter exporter, Item material, Item gear, Item output) {
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

    public static void offerMachineBaseRecipe(RecipeExporter exporter, TagKey<Item> material, Item gear, Item output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .pattern("MRM")
                .pattern("RGR")
                .pattern("MRM")
                .input('R', Items.REDSTONE)
                .input('M', material)
                .input('G', gear)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(gear), conditionsFromItem(gear))
                .offerTo(exporter);
    }

    public static void offerPoweredCrusherRecipe(RecipeExporter exporter, Block crusher, Item powerCircuit,
                                                 Block machineBase, Block wire, Item gear, Item motor) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, crusher)
                .pattern("MCM")
                .pattern("WBW")
                .pattern("GPG")
                .input('C', powerCircuit)
                .input('W', wire)
                .input('B', machineBase)
                .input('M', motor)
                .input('P', Blocks.PISTON)
                .input('G', gear)
                .criterion(hasItem(powerCircuit), conditionsFromItem(powerCircuit))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(machineBase), conditionsFromItem(machineBase))
                .criterion(hasItem(motor), conditionsFromItem(motor))
                .criterion(hasItem(Blocks.PISTON), conditionsFromItem(Blocks.PISTON))
                .criterion(hasItem(gear), conditionsFromItem(gear))
                .offerTo(exporter);
    }

    public static void offerHeatGeneratorRecipe(RecipeExporter exporter, Block generator, Item coil, Item powerCircuit,
                                                Block wire, Block machineBase) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, generator)
                .pattern(" P ")
                .pattern("WMW")
                .pattern("CFC")
                .input('C', coil)
                .input('P', powerCircuit)
                .input('W', wire)
                .input('M', machineBase)
                .input('F', Blocks.FURNACE)
                .criterion(hasItem(coil), conditionsFromItem(coil))
                .criterion(hasItem(powerCircuit), conditionsFromItem(powerCircuit))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(machineBase), conditionsFromItem(machineBase))
                .criterion(hasItem(Blocks.FURNACE), conditionsFromItem(Blocks.FURNACE))
                .offerTo(exporter);
    }
    public static void offerSteamGeneratorRecipe(RecipeExporter exporter, Block generator, Item coil, Item powerCircuit,
                                                Block wire, Block machineBase, Block tank) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, generator)
                .pattern("TPG")
                .pattern("WMW")
                .pattern("CFC")
                .input('C', coil)
                .input('P', powerCircuit)
                .input('W', wire)
                .input('M', machineBase)
                .input('F', Blocks.FURNACE)
                .input('T', tank)
                .input('G', ModItemTags.GLASS)
                .criterion(hasItem(coil), conditionsFromItem(coil))
                .criterion(hasItem(powerCircuit), conditionsFromItem(powerCircuit))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(machineBase), conditionsFromItem(machineBase))
                .criterion(hasItem(Blocks.FURNACE), conditionsFromItem(Blocks.FURNACE))
                .criterion(hasItem(tank), conditionsFromItem(tank))
                .criterion(hasTag(ModItemTags.GLASS), conditionsFromTag(ModItemTags.GLASS))
                .offerTo(exporter);
    }

    public static void offerPoweredFurnaceRecipe(RecipeExporter exporter, Block furnace, Item powerCircuit,
                                                 Block wire, Block machineBase) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, furnace)
                .pattern(" P ")
                .pattern("WMW")
                .pattern("BFB")
                .input('P', powerCircuit)
                .input('W', wire)
                .input('M', machineBase)
                .input('F', Blocks.FURNACE)
                .input('B', Blocks.BRICKS)
                .criterion(hasItem(powerCircuit), conditionsFromItem(powerCircuit))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(machineBase), conditionsFromItem(machineBase))
                .criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS))
                .criterion(hasItem(Blocks.FURNACE), conditionsFromItem(Blocks.FURNACE))
                .offerTo(exporter);
    }

    public static void offerEnergyCoreRecipe(RecipeExporter exporter, Item energyCore, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, energyCore)
                .pattern("RMR")
                .pattern("MBM")
                .pattern("RMR")
                .input('R', Items.REDSTONE)
                .input('B', Blocks.REDSTONE_BLOCK)
                .input('M', material)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Blocks.REDSTONE_BLOCK), conditionsFromItem(Blocks.REDSTONE_BLOCK))
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerEnergyStorageRecipe(RecipeExporter exporter, Block energyStorage, Item powerCircuit,
                                                Block wire, Block machineBase, Item energyCore) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, energyStorage)
                .pattern("C C")
                .pattern("WMW")
                .pattern("LEL")
                .input('C', powerCircuit)
                .input('M', machineBase)
                .input('E', energyCore)
                .input('W', wire)
                .input('L', Blocks.LEVER)
                .criterion(hasItem(powerCircuit), conditionsFromItem(powerCircuit))
                .criterion(hasItem(machineBase), conditionsFromItem(machineBase))
                .criterion(hasItem(energyCore), conditionsFromItem(energyCore))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(Blocks.LEVER), conditionsFromItem(Blocks.LEVER))
                .offerTo(exporter);
    }

    public static void offerAxleRecipe(RecipeExporter exporter, Item axle, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, axle, 4)
                .pattern("MM")
                .input('M', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    public static void offerAxleRecipe(RecipeExporter exporter, Item axle, TagKey<Item> material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, axle, 4)
                .pattern("MM")
                .input('M', material)
                .criterion(hasTag(material), conditionsFromTag(material))
                .offerTo(exporter);
    }

    public static void offerMotorRecipe(RecipeExporter exporter, Item motor, Item material, Item axle, Block wire) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, motor, 2)
                .pattern("MIM")
                .pattern("WAW")
                .pattern("MIM")
                .input('M', material)
                .input('W', wire)
                .input('A', axle)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(axle), conditionsFromItem(axle))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, motor, 2)
                .pattern("MIM")
                .pattern("WAW")
                .pattern("MIM")
                .input('M', material)
                .input('W', wire)
                .input('A', axle)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(axle), conditionsFromItem(axle))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, CraftingRecipeJsonBuilder.getItemId(motor) + "_vertical");
    }

    public static void offerMotorRecipe(RecipeExporter exporter, Item motor, TagKey<Item> material, Item axle, Block wire) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, motor, 2)
                .pattern("MIM")
                .pattern("WAW")
                .pattern("MIM")
                .input('M', material)
                .input('W', wire)
                .input('A', axle)
                .input('I', Items.IRON_INGOT)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(axle), conditionsFromItem(axle))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, motor, 2)
                .pattern("MWM")
                .pattern("IAI")
                .pattern("MWM")
                .input('M', material)
                .input('W', wire)
                .input('A', axle)
                .input('I', Items.IRON_INGOT)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(axle), conditionsFromItem(axle))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, CraftingRecipeJsonBuilder.getItemId(motor) + "_vertical");
    }

    public static void offerQuarryRecipe(RecipeExporter exporter, Block quarry, Block machineBase, Item pickaxe,
                                         Item shovel, Item powerCircuit, Item motor, Block wire) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, quarry)
                .pattern("MCM")
                .pattern("WBW")
                .pattern("P#S")
                .input('M', motor)
                .input('C', powerCircuit)
                .input('W', wire)
                .input('B', machineBase)
                .input('P', pickaxe)
                .input('#', Blocks.CHEST)
                .input('S', shovel)
                .criterion(hasItem(motor), conditionsFromItem(motor))
                .criterion(hasItem(powerCircuit), conditionsFromItem(powerCircuit))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(machineBase), conditionsFromItem(machineBase))
                .criterion(hasItem(pickaxe), conditionsFromItem(pickaxe))
                .criterion(hasItem(Blocks.CHEST), conditionsFromItem(Blocks.CHEST))
                .criterion(hasItem(shovel), conditionsFromItem(shovel))
                .offerTo(exporter);
    }

    public static void offerTankRecipe(RecipeExporter exporter, Block tank, Item material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, tank)
                .pattern("MGM")
                .pattern("G G")
                .pattern("MGM")
                .input('M', material)
                .input('G', ModItemTags.GLASS)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasTag(ModItemTags.GLASS), conditionsFromTag(ModItemTags.GLASS))
                .offerTo(exporter);
    }

    public static void offerTankRecipe(RecipeExporter exporter, Block tank, TagKey<Item> material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, tank)
                .pattern("MGM")
                .pattern("G G")
                .pattern("MGM")
                .input('M', material)
                .input('G', ModItemTags.GLASS)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasTag(ModItemTags.GLASS), conditionsFromTag(ModItemTags.GLASS))
                .offerTo(exporter);
    }

    public static void offerPumpRecipe(RecipeExporter exporter, Block pump, Block machineBase, Item powerCircuit,
                                       Item motor, Item gear, Block tank, Block wire) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, pump)
                .pattern("MCM")
                .pattern("WBW")
                .pattern("GTG")
                .input('M', motor)
                .input('C', powerCircuit)
                .input('W', wire)
                .input('B', machineBase)
                .input('G', gear)
                .input('T', tank)
                .criterion(hasItem(motor), conditionsFromItem(motor))
                .criterion(hasItem(powerCircuit), conditionsFromItem(powerCircuit))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(machineBase), conditionsFromItem(machineBase))
                .criterion(hasItem(gear), conditionsFromItem(gear))
                .criterion(hasItem(tank), conditionsFromItem(tank))
                .offerTo(exporter);
    }

    public static void offerCopierRecipe(RecipeExporter exporter, Block copier, Block machineBase, Item powerCircuit,
                                         Block tank, Block wire){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, copier)
                .pattern(" C ")
                .pattern("WMW")
                .pattern("ABT")
                .input('C', powerCircuit)
                .input('W', wire)
                .input('M', machineBase)
                .input('T', tank)
                .input('A', Blocks.ANVIL)
                .input('B', Items.ENCHANTED_BOOK)
                .criterion(hasItem(powerCircuit), conditionsFromItem(powerCircuit))
                .criterion(hasItem(wire), conditionsFromItem(wire))
                .criterion(hasItem(machineBase), conditionsFromItem(machineBase))
                .criterion(hasItem(tank), conditionsFromItem(tank))
                .criterion(hasItem(Blocks.ANVIL), conditionsFromItem(Blocks.ANVIL))
                .criterion(hasItem(Items.ENCHANTED_BOOK), conditionsFromItem(Items.ENCHANTED_BOOK))
                .offerTo(exporter);
    }
    public static void offerItemPipeRecipe(RecipeExporter exporter, Block itemPipe, Item material){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, itemPipe, 8)
                .pattern("MMM")
                .pattern("T T")
                .pattern("MMM")
                .input('M', material)
                .input('T', ModItemTags.TIN_INGOTS)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasTag(ModItemTags.TIN_INGOTS), conditionsFromTag(ModItemTags.TIN_INGOTS))
                .offerTo(exporter);
    }
    public static void offerItemPipeRecipe(RecipeExporter exporter, Block itemPipe, TagKey<Item> material){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, itemPipe, 8)
                .pattern("MMM")
                .pattern("T T")
                .pattern("MMM")
                .input('M', material)
                .input('T', ModItemTags.TIN_INGOTS)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasTag(ModItemTags.TIN_INGOTS), conditionsFromTag(ModItemTags.TIN_INGOTS))
                .offerTo(exporter);
    }
    public static void offerFluidPipeRecipe(RecipeExporter exporter, Block fluidPipe, Item material){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, fluidPipe, 8)
                .pattern("MMM")
                .pattern("C C")
                .pattern("MMM")
                .input('M', material)
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(material), conditionsFromItem(material))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
    }
    public static void offerFluidPipeRecipe(RecipeExporter exporter, Block fluidPipe, TagKey<Item> material){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, fluidPipe, 8)
                .pattern("MMM")
                .pattern("C C")
                .pattern("MMM")
                .input('M', material)
                .input('C', Items.COPPER_INGOT)
                .criterion(hasTag(material), conditionsFromTag(material))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
    }
}
