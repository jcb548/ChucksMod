package net.chuck.chucksmod.datagen.models;

import dev.architectury.platform.Mod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.custom.crop.*;
import net.chuck.chucksmod.block.custom.crop.magical.AbstractMagicalCropBlock;
import net.chuck.chucksmod.fluid.ModFluids;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.LETTUCE_CROP, LettuceCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.PINEAPPLE_CROP, PineappleCropBlock.AGE,
                0, 1, 2, 3, 4, 5, 6, 7, 8);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COAL_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRON_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COPPER_DUST_BLOCK);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.COPPER_BARS);
        ModModelGenerator.registerWire(blockStateModelGenerator, ModBlocks.COPPER_WIRE);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.COAL_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.IRON_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.COPPER_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.GOLD_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.TIN_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.LAPIS_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.REDSTONE_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.DIAMOND_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.TITANIUM_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.EMERALD_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_DUST_BLOCK);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.GOLD_BARS);
        ModModelGenerator.registerWire(blockStateModelGenerator, ModBlocks.GOLD_WIRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_DUST_BLOCK);

        ModModelGenerator.registerWire(blockStateModelGenerator, ModBlocks.NETHERITE_WIRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHERITE_DUST_BLOCK);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.NETHERITE_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.PRISMARINE_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OBSIDIAN_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIAMOND_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EMERALD_DUST_BLOCK);

        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_GLASS, ModBlocks.HARDENED_GLASS_PANE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HARDENED_TINTED_GLASS);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_BLACK_GLASS, 
                ModBlocks.HARDENED_BLACK_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_BLUE_GLASS,
                ModBlocks.HARDENED_BLUE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_BROWN_GLASS,
                ModBlocks.HARDENED_BROWN_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_CYAN_GLASS,
                ModBlocks.HARDENED_CYAN_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_GRAY_GLASS,
                ModBlocks.HARDENED_GRAY_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_GREEN_GLASS,
                ModBlocks.HARDENED_GREEN_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_LIGHT_BLUE_GLASS,
                ModBlocks.HARDENED_LIGHT_BLUE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_LIGHT_GRAY_GLASS,
                ModBlocks.HARDENED_LIGHT_GRAY_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_LIME_GLASS,
                ModBlocks.HARDENED_LIME_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_MAGENTA_GLASS,
                ModBlocks.HARDENED_MAGENTA_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_ORANGE_GLASS,
                ModBlocks.HARDENED_ORANGE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_PINK_GLASS,
                ModBlocks.HARDENED_PINK_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_PURPLE_GLASS,
                ModBlocks.HARDENED_PURPLE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_RED_GLASS,
                ModBlocks.HARDENED_RED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_WHITE_GLASS,
                ModBlocks.HARDENED_WHITE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_YELLOW_GLASS, 
                ModBlocks.HARDENED_YELLOW_GLASS_PANE);

        ModModelGenerator.registerMachineBase(blockStateModelGenerator, ModBlocks.IRON_MACHINE_BASE);
        ModModelGenerator.registerEnergyStorage(blockStateModelGenerator, ModBlocks.IRON_ENERGY_STORAGE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_POWERED_CRUSHER, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_POWERED_FURNACE, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_HEAT_GENERATOR, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_HARVESTER, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_QUARRY, ModTexturedModel.ORIENTABLE_MACHINE);
        ModModelGenerator.registerVerticalColumn(blockStateModelGenerator, ModBlocks.IRON_FLUID_TANK);
        ModModelGenerator.registerExperienceDrain(blockStateModelGenerator, ModBlocks.IRON_EXPERIENCE_DRAIN);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_PUMP, ModTexturedModel.ORIENTABLE_MACHINE);
        ModModelGenerator.registerPipe(blockStateModelGenerator, ModBlocks.IRON_FLUID_PIPE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_STEAM_GENERATOR, ModTexturedModel.ORIENTABLE_MACHINE);
        
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.TIN_BARS);
        ModModelGenerator.registerWire(blockStateModelGenerator, ModBlocks.TIN_WIRE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_DUST_BLOCK);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.BRONZE_BARS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TITANIUM_ORE);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.TITANIUM_BARS);

        ModModelGenerator.registerMachineBase(blockStateModelGenerator, ModBlocks.TITANIUM_MACHINE_BASE);
        ModModelGenerator.registerEnergyStorage(blockStateModelGenerator, ModBlocks.TITANIUM_ENERGY_STORAGE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_POWERED_CRUSHER, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_POWERED_FURNACE, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_HEAT_GENERATOR, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_QUARRY, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_COPIER, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_CLEANSER, ModTexturedModel.ORIENTABLE_MACHINE);
        ModModelGenerator.registerVerticalColumn(blockStateModelGenerator, ModBlocks.TITANIUM_FLUID_TANK);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_PUMP, ModTexturedModel.ORIENTABLE_MACHINE);
        ModModelGenerator.registerPipe(blockStateModelGenerator, ModBlocks.TITANIUM_FLUID_PIPE);
        ModModelGenerator.registerExperienceDrain(blockStateModelGenerator, ModBlocks.TITANIUM_EXPERIENCE_DRAIN);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_STEAM_GENERATOR, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_LAVA_GENERATOR, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_HARVESTER, ModTexturedModel.ORIENTABLE_MACHINE);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.NETHER_CRYSTAL_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUL_GRAVEL);
        BlockStateModelGenerator.BlockTexturePool soul_stone_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SOUL_STONE);
        soul_stone_pool.stairs(ModBlocks.SOUL_STONE_STAIRS);
        soul_stone_pool.slab(ModBlocks.SOUL_STONE_SLAB);
        BlockStateModelGenerator.BlockTexturePool soul_stone_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SOUL_STONE_BRICKS);
        soul_stone_bricks_pool.stairs(ModBlocks.SOUL_STONE_BRICK_STAIRS);
        soul_stone_bricks_pool.slab(ModBlocks.SOUL_STONE_BRICK_SLAB);
        soul_stone_bricks_pool.wall(ModBlocks.SOUL_STONE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SOUL_STONE_BRICKS);
        blockStateModelGenerator.registerSimpleState(ModBlocks.SOUL_BLAZE_ALTAR);

        BlockStateModelGenerator.BlockTexturePool white_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.WHITE_CONCRETE);
        white_concrete_pool.stairs(ModBlocks.WHITE_CONCRETE_STAIRS);
        white_concrete_pool.slab(ModBlocks.WHITE_CONCRETE_SLAB);
        white_concrete_pool.wall(ModBlocks.WHITE_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool light_gray_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIGHT_GRAY_CONCRETE);
        light_gray_concrete_pool.stairs(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        light_gray_concrete_pool.slab(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        light_gray_concrete_pool.wall(ModBlocks.LIGHT_GRAY_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool gray_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GRAY_CONCRETE);
        gray_concrete_pool.stairs(ModBlocks.GRAY_CONCRETE_STAIRS);
        gray_concrete_pool.slab(ModBlocks.GRAY_CONCRETE_SLAB);
        gray_concrete_pool.wall(ModBlocks.GRAY_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool black_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLACK_CONCRETE);
        black_concrete_pool.stairs(ModBlocks.BLACK_CONCRETE_STAIRS);
        black_concrete_pool.slab(ModBlocks.BLACK_CONCRETE_SLAB);
        black_concrete_pool.wall(ModBlocks.BLACK_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool brown_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BROWN_CONCRETE);
        brown_concrete_pool.stairs(ModBlocks.BROWN_CONCRETE_STAIRS);
        brown_concrete_pool.slab(ModBlocks.BROWN_CONCRETE_SLAB);
        brown_concrete_pool.wall(ModBlocks.BROWN_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool red_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.RED_CONCRETE);
        red_concrete_pool.stairs(ModBlocks.RED_CONCRETE_STAIRS);
        red_concrete_pool.slab(ModBlocks.RED_CONCRETE_SLAB);
        red_concrete_pool.wall(ModBlocks.RED_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool orange_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.ORANGE_CONCRETE);
        orange_concrete_pool.stairs(ModBlocks.ORANGE_CONCRETE_STAIRS);
        orange_concrete_pool.slab(ModBlocks.ORANGE_CONCRETE_SLAB);
        orange_concrete_pool.wall(ModBlocks.ORANGE_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool yellow_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.YELLOW_CONCRETE);
        yellow_concrete_pool.stairs(ModBlocks.YELLOW_CONCRETE_STAIRS);
        yellow_concrete_pool.slab(ModBlocks.YELLOW_CONCRETE_SLAB);
        yellow_concrete_pool.wall(ModBlocks.YELLOW_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool lime_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIME_CONCRETE);
        lime_concrete_pool.stairs(ModBlocks.LIME_CONCRETE_STAIRS);
        lime_concrete_pool.slab(ModBlocks.LIME_CONCRETE_SLAB);
        lime_concrete_pool.wall(ModBlocks.LIME_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool green_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GREEN_CONCRETE);
        green_concrete_pool.stairs(ModBlocks.GREEN_CONCRETE_STAIRS);
        green_concrete_pool.slab(ModBlocks.GREEN_CONCRETE_SLAB);
        green_concrete_pool.wall(ModBlocks.GREEN_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool cyan_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CYAN_CONCRETE);
        cyan_concrete_pool.stairs(ModBlocks.CYAN_CONCRETE_STAIRS);
        cyan_concrete_pool.slab(ModBlocks.CYAN_CONCRETE_SLAB);
        cyan_concrete_pool.wall(ModBlocks.CYAN_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool light_blue_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIGHT_BLUE_CONCRETE);
        light_blue_concrete_pool.stairs(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        light_blue_concrete_pool.slab(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        light_blue_concrete_pool.wall(ModBlocks.LIGHT_BLUE_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool blue_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLUE_CONCRETE);
        blue_concrete_pool.stairs(ModBlocks.BLUE_CONCRETE_STAIRS);
        blue_concrete_pool.slab(ModBlocks.BLUE_CONCRETE_SLAB);
        blue_concrete_pool.wall(ModBlocks.BLUE_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool purple_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PURPLE_CONCRETE);
        purple_concrete_pool.stairs(ModBlocks.PURPLE_CONCRETE_STAIRS);
        purple_concrete_pool.slab(ModBlocks.PURPLE_CONCRETE_SLAB);
        purple_concrete_pool.wall(ModBlocks.PURPLE_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool magenta_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.MAGENTA_CONCRETE);
        magenta_concrete_pool.stairs(ModBlocks.MAGENTA_CONCRETE_STAIRS);
        magenta_concrete_pool.slab(ModBlocks.MAGENTA_CONCRETE_SLAB);
        magenta_concrete_pool.wall(ModBlocks.MAGENTA_CONCRETE_WALL);
        BlockStateModelGenerator.BlockTexturePool pink_concrete_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PINK_CONCRETE);
        pink_concrete_pool.stairs(ModBlocks.PINK_CONCRETE_STAIRS);
        pink_concrete_pool.slab(ModBlocks.PINK_CONCRETE_SLAB);
        pink_concrete_pool.wall(ModBlocks.PINK_CONCRETE_WALL);

        BlockStateModelGenerator.BlockTexturePool tuff_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.TUFF);
        tuff_pool.stairs(ModBlocks.TUFF_STAIRS);
        tuff_pool.slab(ModBlocks.TUFF_SLAB);
        tuff_pool.wall(ModBlocks.TUFF_WALL);
        
        BlockStateModelGenerator.BlockTexturePool eclogite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ECLOGITE);
        eclogite_pool.stairs(ModBlocks.ECLOGITE_STAIRS);
        eclogite_pool.slab(ModBlocks.ECLOGITE_SLAB);
        eclogite_pool.wall(ModBlocks.ECLOGITE_WALL);
        BlockStateModelGenerator.BlockTexturePool eclogite_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ECLOGITE_BRICKS);
        eclogite_bricks_pool.stairs(ModBlocks.ECLOGITE_BRICK_STAIRS);
        eclogite_bricks_pool.slab(ModBlocks.ECLOGITE_BRICK_SLAB);
        eclogite_bricks_pool.wall(ModBlocks.ECLOGITE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_ECLOGITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polished_eclogite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_ECLOGITE);
        polished_eclogite_pool.stairs(ModBlocks.POLISHED_ECLOGITE_STAIRS);
        polished_eclogite_pool.slab(ModBlocks.POLISHED_ECLOGITE_SLAB);
        polished_eclogite_pool.wall(ModBlocks.POLISHED_ECLOGITE_WALL);

        BlockStateModelGenerator.BlockTexturePool serpentinite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SERPENTINITE);
        serpentinite_pool.stairs(ModBlocks.SERPENTINITE_STAIRS);
        serpentinite_pool.slab(ModBlocks.SERPENTINITE_SLAB);
        serpentinite_pool.wall(ModBlocks.SERPENTINITE_WALL);
        BlockStateModelGenerator.BlockTexturePool serpentinite_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SERPENTINITE_BRICKS);
        serpentinite_bricks_pool.stairs(ModBlocks.SERPENTINITE_BRICK_STAIRS);
        serpentinite_bricks_pool.slab(ModBlocks.SERPENTINITE_BRICK_SLAB);
        serpentinite_bricks_pool.wall(ModBlocks.SERPENTINITE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SERPENTINITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polished_serpentinite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_SERPENTINITE);
        polished_serpentinite_pool.stairs(ModBlocks.POLISHED_SERPENTINITE_STAIRS);
        polished_serpentinite_pool.slab(ModBlocks.POLISHED_SERPENTINITE_SLAB);
        polished_serpentinite_pool.wall(ModBlocks.POLISHED_SERPENTINITE_WALL);

        BlockStateModelGenerator.BlockTexturePool glauconite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLAUCONITE);
        glauconite_pool.stairs(ModBlocks.GLAUCONITE_STAIRS);
        glauconite_pool.slab(ModBlocks.GLAUCONITE_SLAB);
        glauconite_pool.wall(ModBlocks.GLAUCONITE_WALL);
        BlockStateModelGenerator.BlockTexturePool glauconite_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLAUCONITE_BRICKS);
        glauconite_bricks_pool.stairs(ModBlocks.GLAUCONITE_BRICK_STAIRS);
        glauconite_bricks_pool.slab(ModBlocks.GLAUCONITE_BRICK_SLAB);
        glauconite_bricks_pool.wall(ModBlocks.GLAUCONITE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_GLAUCONITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polished_glauconite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_GLAUCONITE);
        polished_glauconite_pool.stairs(ModBlocks.POLISHED_GLAUCONITE_STAIRS);
        polished_glauconite_pool.slab(ModBlocks.POLISHED_GLAUCONITE_SLAB);
        polished_glauconite_pool.wall(ModBlocks.POLISHED_GLAUCONITE_WALL);

        blockStateModelGenerator.registerSingleton(ModBlocks.TRIAFIA_LEAVES, TexturedModel.LEAVES);
        BlockStateModelGenerator.LogTexturePool triafia_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.TRIAFIA_LOG);
        triafia_log_pool.log(ModBlocks.TRIAFIA_LOG);
        triafia_log_pool.wood(ModBlocks.TRIAFIA_WOOD);
        BlockStateModelGenerator.LogTexturePool stripped_triafia_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_TRIAFIA_LOG);
        stripped_triafia_log_pool.log(ModBlocks.STRIPPED_TRIAFIA_LOG);
        stripped_triafia_log_pool.wood(ModBlocks.STRIPPED_TRIAFIA_WOOD);

        BlockStateModelGenerator.BlockTexturePool triafia_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TRIAFIA_PLANKS);
        triafia_pool.stairs(ModBlocks.TRIAFIA_STAIRS);
        triafia_pool.slab(ModBlocks.TRIAFIA_SLAB);
        triafia_pool.fence(ModBlocks.TRIAFIA_FENCE);
        triafia_pool.fenceGate(ModBlocks.TRIAFIA_FENCE_GATE);
        triafia_pool.button(ModBlocks.TRIAFIA_BUTTON);
        triafia_pool.pressurePlate(ModBlocks.TRIAFIA_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.TRIAFIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TRIAFIA_TRAPDOOR);
        triafia_pool.family(ModBlocks.TRIAFIA_FAMILY);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TRIAFIA_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TRIAFIA_PLANT,
                BlockStateModelGenerator.TintType.TINTED);
        ModModelGenerator.registerWallPlant(blockStateModelGenerator, ModBlocks.TRIAFIAN_VINE);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.TRIAFIA_CRYSTAL_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIAFIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TRIAFIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TRIAFIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_TRIAFIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TRIAFIUM_ORE);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.TRIAFIUM_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIAFIUM_DUST_BLOCK);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.TRIAFIUM_CROP, BlockStateModelGenerator.TintType.NOT_TINTED,
                AbstractMagicalCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIAFIUM_PORTAL_BLOCK);

        ModModelGenerator.registerMachineBase(blockStateModelGenerator, ModBlocks.TRIAFIUM_MACHINE_BASE);
        ModModelGenerator.registerEnergyStorage(blockStateModelGenerator, ModBlocks.TRIAFIUM_ENERGY_STORAGE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_POWERED_CRUSHER, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_POWERED_FURNACE, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_HEAT_GENERATOR, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_PUMP, ModTexturedModel.ORIENTABLE_MACHINE);
        ModModelGenerator.registerExperienceDrain(blockStateModelGenerator, ModBlocks.TRIAFIUM_EXPERIENCE_DRAIN);
        ModModelGenerator.registerPipe(blockStateModelGenerator, ModBlocks.TRIAFIUM_FLUID_PIPE);
        ModModelGenerator.registerVerticalColumn(blockStateModelGenerator, ModBlocks.TRIAFIUM_FLUID_TANK);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_STEAM_GENERATOR, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_HARVESTER, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_QUARRY, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_LAVA_GENERATOR, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_COPIER, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_CLEANSER, ModTexturedModel.ORIENTABLE_MACHINE);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_PORTAL_BUILDER, ModTexturedModel.ORIENTABLE_MACHINE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_COPPER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_PACSARIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_EMERALD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_TRIAFIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_GOLD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_LAPIS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_REDSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_QUARTZ_ORE);
        blockStateModelGenerator.registerSimpleState(ModBlocks.PIPPIN_ALTAR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACSARIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PACSARIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_PACSARIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PACSARIUM_ORE);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.PACSARIUM_BARS);

        BlockStateModelGenerator.LogTexturePool eucalyptus_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.EUCALYPTUS_LOG);
        eucalyptus_log_pool.log(ModBlocks.EUCALYPTUS_LOG);
        eucalyptus_log_pool.wood(ModBlocks.EUCALYPTUS_WOOD);
        BlockStateModelGenerator.LogTexturePool stripped_eucalyptus_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        stripped_eucalyptus_log_pool.log(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        stripped_eucalyptus_log_pool.wood(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EUCALYPTUS_LEAVES);
        BlockStateModelGenerator.BlockTexturePool eucalyptus_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EUCALYPTUS_PLANKS);
        blockStateModelGenerator.registerTintableCross(ModBlocks.EUCALYPTUS_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        eucalyptus_pool.stairs(ModBlocks.EUCALYPTUS_STAIRS);
        eucalyptus_pool.slab(ModBlocks.EUCALYPTUS_SLAB);
        eucalyptus_pool.fence(ModBlocks.EUCALYPTUS_FENCE);
        eucalyptus_pool.fenceGate(ModBlocks.EUCALYPTUS_FENCE_GATE);
        eucalyptus_pool.button(ModBlocks.EUCALYPTUS_BUTTON);
        eucalyptus_pool.pressurePlate(ModBlocks.EUCALYPTUS_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.EUCALYPTUS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.EUCALYPTUS_TRAPDOOR);
        eucalyptus_pool.family(ModBlocks.EUCALYPTUS_FAMILY);

        blockStateModelGenerator.registerTintableCross(ModBlocks.PACSARIA_PLANT,
                BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PACSARIA_LIGHT_PLANT,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PACSARIA_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSingleton(ModBlocks.PACSARIA_LEAVES, TexturedModel.LEAVES);
        BlockStateModelGenerator.LogTexturePool pacsaria_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.PACSARIA_LOG);
        pacsaria_log_pool.log(ModBlocks.PACSARIA_LOG);
        pacsaria_log_pool.wood(ModBlocks.PACSARIA_WOOD);
        BlockStateModelGenerator.LogTexturePool stripped_pacsaria_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PACSARIA_LOG);
        stripped_pacsaria_log_pool.log(ModBlocks.STRIPPED_PACSARIA_LOG);
        stripped_pacsaria_log_pool.wood(ModBlocks.STRIPPED_PACSARIA_WOOD);

        BlockStateModelGenerator.BlockTexturePool pacsaria_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PACSARIA_PLANKS);
        pacsaria_pool.stairs(ModBlocks.PACSARIA_STAIRS);
        pacsaria_pool.slab(ModBlocks.PACSARIA_SLAB);
        pacsaria_pool.fence(ModBlocks.PACSARIA_FENCE);
        pacsaria_pool.fenceGate(ModBlocks.PACSARIA_FENCE_GATE);
        pacsaria_pool.button(ModBlocks.PACSARIA_BUTTON);
        pacsaria_pool.pressurePlate(ModBlocks.PACSARIA_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.PACSARIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PACSARIA_TRAPDOOR);
        pacsaria_pool.family(ModBlocks.PACSARIA_FAMILY);

        blockStateModelGenerator.registerCooker(ModBlocks.CRUSHER, TexturedModel.ORIENTABLE);

        ModModelGenerator.registerTurnableRail(blockStateModelGenerator, Blocks.RAIL);
        ModModelGenerator.registerStraightRail(blockStateModelGenerator, Blocks.POWERED_RAIL);

        BlockStateModelGenerator.BlockTexturePool sandstone_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SANDSTONE_BRICKS);
        sandstone_bricks_pool.stairs(ModBlocks.SANDSTONE_BRICK_STAIRS);
        sandstone_bricks_pool.slab(ModBlocks.SANDSTONE_BRICK_SLAB);
        sandstone_bricks_pool.wall(ModBlocks.SANDSTONE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SANDSTONE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FRANK_ALTAR);

        blockStateModelGenerator.registerParentedItemModel(ModItems.SOUL_BLAZE_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.WYATT_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.FRANK_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.FARMABYN_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.TRIAFIAN_PIG_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.TRIAFIAN_COW_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.PIPPIN_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.BIG_TALL_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.SMOTOL_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WRENCH, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_DUST, Models.GENERATED);

        itemModelGenerator.register(ModItems.COAL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COAL_ESSENCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_ESSENCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.IRON_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_ENERGY_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_AXLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_MOTOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_POWER_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_COIL, Models.GENERATED);

        itemModelGenerator.register(ModItems.GOLD_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_POWER_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIL, Models.GENERATED);

        itemModelGenerator.register(ModItems.NETHERITE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_POWER_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_COIL, Models.GENERATED);

        itemModelGenerator.register(ModItems.TIN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_GEAR, Models.GENERATED);

        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BRONZE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BRONZE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BRONZE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BRONZE_BOOTS);

        itemModelGenerator.register(ModItems.RAW_TITANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TITANIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TITANIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TITANIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TITANIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TITANIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TITANIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TITANIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TITANIUM_BOOTS);
        itemModelGenerator.register(ModItems.TITANIUM_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_ENERGY_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_AXLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_MOTOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.SOUL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLAZE_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_BLAZE_ROD, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_TRIAFIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TRIAFIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TRIAFIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TRIAFIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TRIAFIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TRIAFIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TRIAFIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TRIAFIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TRIAFIUM_BOOTS);
        itemModelGenerator.register(ModItems.TRIAFIUM_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_ENERGY_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_AXLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_MOTOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.TRIAFIA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIA_CRYSTAL_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIA_CRYSTAL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FARMABYN, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_FARMABYN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIAN_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_TRIAFIAN_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIAN_BEEF, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_TRIAFIAN_BEEF, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_PACSARIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIUM_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PACSARIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PACSARIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PACSARIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PACSARIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PACSARIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PACSARIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PACSARIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PACSARIUM_BOOTS);
        itemModelGenerator.register(ModItems.PACSARIA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIA_CRYSTAL_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAMBURGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINEAPPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.PRISMARINE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PRISMARINE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PRISMARINE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PRISMARINE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PRISMARINE_BOOTS);

        itemModelGenerator.register(ModItems.NETHER_QUARTZ_DUST, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHER_CRYSTAL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHER_CRYSTAL_SHARD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHER_CRYSTAL_DUST, Models.HANDHELD);

        itemModelGenerator.register(ModItems.WITHER_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.LAPIS_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDSTONE_ESSENCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.DIAMOND_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_ESSENCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.EMERALD_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_ESSENCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.OBSIDIAN_DUST, Models.GENERATED);

        itemModelGenerator.register(ModItems.PORTABLE_ENDERCHEST, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRING_STRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEATHER_STRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOOL_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEATHER_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_BAG, Models.GENERATED);

        itemModelGenerator.register(ModItems.HANGING_EUCALYPTUS_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.EUCALYPTUS_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EUCALYPTUS_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HANGING_PACSARIA_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIA_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HANGING_TRIAFIA_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIA_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModFluids.LIQUID_XP_BUCKET, Models.GENERATED);
    }
}
