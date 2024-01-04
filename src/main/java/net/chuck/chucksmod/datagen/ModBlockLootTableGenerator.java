package net.chuck.chucksmod.datagen;

import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.custom.LettuceCropBlock;
import net.chuck.chucksmod.block.custom.PineappleCropBlock;
import net.chuck.chucksmod.block.custom.TomatoCropBlock;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SANDSTONE_BRICKS);
        addDrop(ModBlocks.SANDSTONE_BRICK_STAIRS);
        addDrop(ModBlocks.SANDSTONE_BRICK_SLAB, slabDrops(ModBlocks.SANDSTONE_BRICK_SLAB));
        addDrop(ModBlocks.SANDSTONE_BRICKS);
        addDrop(ModBlocks.CRACKED_SANDSTONE_BRICKS);

        addDrop(ModBlocks.IRON_DUST_BLOCK);
        addDrop(ModBlocks.COPPER_DUST_BLOCK);
        addDrop(ModBlocks.GOLD_DUST_BLOCK);
        addDrop(ModBlocks.PRISMARINE_DUST_BLOCK);
        addDrop(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);
        addDrop(ModBlocks.OBSIDIAN_SAND);

        addDrop(ModBlocks.HARDENED_GLASS);
        addDrop(ModBlocks.HARDENED_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_BLACK_GLASS);
        addDrop(ModBlocks.HARDENED_BLACK_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_BLUE_GLASS);
        addDrop(ModBlocks.HARDENED_BLUE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_BROWN_GLASS);
        addDrop(ModBlocks.HARDENED_BROWN_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_CYAN_GLASS);
        addDrop(ModBlocks.HARDENED_CYAN_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_GRAY_GLASS);
        addDrop(ModBlocks.HARDENED_GRAY_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_GREEN_GLASS);
        addDrop(ModBlocks.HARDENED_GREEN_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_LIGHT_GRAY_GLASS);
        addDrop(ModBlocks.HARDENED_LIGHT_GRAY_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_LIGHT_BLUE_GLASS);
        addDrop(ModBlocks.HARDENED_LIGHT_BLUE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_LIME_GLASS);
        addDrop(ModBlocks.HARDENED_LIME_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_MAGENTA_GLASS);
        addDrop(ModBlocks.HARDENED_MAGENTA_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_ORANGE_GLASS);
        addDrop(ModBlocks.HARDENED_ORANGE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_PINK_GLASS);
        addDrop(ModBlocks.HARDENED_PINK_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_PURPLE_GLASS);
        addDrop(ModBlocks.HARDENED_PURPLE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_RED_GLASS);
        addDrop(ModBlocks.HARDENED_RED_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_WHITE_GLASS);
        addDrop(ModBlocks.HARDENED_WHITE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_YELLOW_GLASS);
        addDrop(ModBlocks.HARDENED_YELLOW_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_TINTED_GLASS);

        addDrop(ModBlocks.TIN_DUST_BLOCK);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.RAW_TIN_BLOCK);
        addDrop(ModBlocks.TIN_BARS);
        addDrop(ModBlocks.TIN_ORE, oreDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, oreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.TIN_WIRE);

        addDrop(ModBlocks.BRONZE_BLOCK);
        addDrop(ModBlocks.BRONZE_DUST_BLOCK);
        addDrop(ModBlocks.BRONZE_BARS);

        addDrop(ModBlocks.TITANIUM_DUST_BLOCK);
        addDrop(ModBlocks.TITANIUM_BLOCK);
        addDrop(ModBlocks.RAW_TITANIUM_BLOCK);
        addDrop(ModBlocks.TITANIUM_BARS);
        addDrop(ModBlocks.TITANIUM_ORE, oreDrops(ModBlocks.TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.DEEPSLATE_TITANIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.NETHER_TITANIUM_ORE, oreDrops(ModBlocks.NETHER_TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.END_STONE_TITANIUM_ORE, oreDrops(ModBlocks.END_STONE_TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.TITANIUM_MACHINE_BASE);
        addDrop(ModBlocks.TITANIUM_ENERGY_STORAGE);
        addDrop(ModBlocks.TITANIUM_POWERED_FURNACE);
        addDrop(ModBlocks.TITANIUM_POWERED_CRUSHER);
        addDrop(ModBlocks.TITANIUM_HEAT_GENERATOR);
        addDrop(ModBlocks.TITANIUM_QUARRY);
        addDrop(ModBlocks.TITANIUM_COPIER);

        addDrop(ModBlocks.SOUL_STONE);
        addDrop(ModBlocks.SOUL_STONE_STAIRS);
        addDrop(ModBlocks.SOUL_STONE_SLAB, slabDrops(ModBlocks.SOUL_STONE_SLAB));
        addDrop(ModBlocks.SOUL_STONE_BRICKS);
        addDrop(ModBlocks.SOUL_STONE_BRICK_STAIRS);
        addDrop(ModBlocks.SOUL_STONE_BRICK_SLAB, slabDrops(ModBlocks.SOUL_STONE_BRICK_SLAB));
        addDrop(ModBlocks.SOUL_STONE_BRICKS);
        addDrop(ModBlocks.CRACKED_SOUL_STONE_BRICKS);
        
        addDrop(ModBlocks.RAW_FABIUM_BLOCK);
        addDrop(ModBlocks.FABIUM_BLOCK);
        addDrop(ModBlocks.FABIUM_BARS);
        addDrop(ModBlocks.NETHER_FABIUM_ORE, oreDrops(ModBlocks.NETHER_FABIUM_ORE, ModItems.RAW_FABIUM));
        addDrop(ModBlocks.END_STONE_FABIUM_ORE, oreDrops(ModBlocks.END_STONE_FABIUM_ORE, ModItems.RAW_FABIUM));
        addDrop(ModBlocks.DEEPSLATE_FABIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_FABIUM_ORE, ModItems.RAW_FABIUM));

        addDrop(ModBlocks.RAW_DIRITONIUM_BLOCK);
        addDrop(ModBlocks.DIRITONIUM_BLOCK);
        addDrop(ModBlocks.DIRITONIUM_BARS);
        addDrop(ModBlocks.END_STONE_DIRITONIUM_ORE, oreDrops(ModBlocks.END_STONE_DIRITONIUM_ORE,
                ModItems.RAW_DIRITONIUM));
        addDrop(ModBlocks.DEEPSLATE_DIRITONIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_DIRITONIUM_ORE,
                ModItems.RAW_DIRITONIUM));

        addDrop(ModBlocks.EUCALYPTUS_SAPLING);
        addDrop(ModBlocks.EUCALYPTUS_LOG);
        addDrop(ModBlocks.EUCALYPTUS_WOOD);
        addDrop(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        addDrop(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
        addDrop(ModBlocks.EUCALYPTUS_LEAVES, leavesDrops(ModBlocks.EUCALYPTUS_LEAVES, ModBlocks.EUCALYPTUS_SAPLING,
                0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f));
        addDrop(ModBlocks.EUCALYPTUS_BUTTON);
        addDrop(ModBlocks.EUCALYPTUS_DOOR, doorDrops(ModBlocks.EUCALYPTUS_DOOR));
        addDrop(ModBlocks.EUCALYPTUS_TRAPDOOR);
        addDrop(ModBlocks.EUCALYPTUS_FENCE);
        addDrop(ModBlocks.EUCALYPTUS_FENCE_GATE);
        addDrop(ModBlocks.EUCALYPTUS_PRESSURE_PLATE);
        addDrop(ModBlocks.EUCALYPTUS_STAIRS);
        addDrop(ModBlocks.EUCALYPTUS_SLAB, slabDrops(ModBlocks.EUCALYPTUS_SLAB));

        addDrop(ModBlocks.DIRITIA_SAPLING);
        addDrop(ModBlocks.DIRITIA_LOG);
        addDrop(ModBlocks.DIRITIA_WOOD);
        addDrop(ModBlocks.STRIPPED_DIRITIA_LOG);
        addDrop(ModBlocks.STRIPPED_DIRITIA_WOOD);
        addDrop(ModBlocks.DIRITIA_LEAVES, leavesDrops(ModBlocks.DIRITIA_LEAVES, ModBlocks.DIRITIA_SAPLING,
                0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f));
        addDrop(ModBlocks.DIRITIA_BUTTON);
        addDrop(ModBlocks.DIRITIA_DOOR, doorDrops(ModBlocks.DIRITIA_DOOR));
        addDrop(ModBlocks.DIRITIA_TRAPDOOR);
        addDrop(ModBlocks.DIRITIA_FENCE);
        addDrop(ModBlocks.DIRITIA_FENCE_GATE);
        addDrop(ModBlocks.DIRITIA_PRESSURE_PLATE);
        addDrop(ModBlocks.DIRITIA_STAIRS);
        addDrop(ModBlocks.DIRITIA_SLAB, slabDrops(ModBlocks.DIRITIA_SLAB));
        addDrop(ModBlocks.DIRITIA_PLANT, grassDrops(ModBlocks.DIRITIA_PLANT));
        addDrop(ModBlocks.DIRITIA_LIGHT_PLANT);

        addDrop(ModBlocks.IRON_MACHINE_BASE);
        addDrop(ModBlocks.CRUSHER);
        addDrop(ModBlocks.IRON_POWERED_CRUSHER);
        addDrop(ModBlocks.IRON_POWERED_FURNACE);
        addDrop(ModBlocks.IRON_HEAT_GENERATOR);
        addDrop(ModBlocks.IRON_QUARRY);
        addDrop(ModBlocks.IRON_ENERGY_STORAGE);
        addDrop(ModBlocks.IRON_FLUID_TANK);

        addDrop(ModBlocks.COPPER_WIRE);
        addDrop(ModBlocks.GOLD_WIRE);

        BlockStatePropertyLootCondition.Builder tomatoCropBuilder = BlockStatePropertyLootCondition.builder
                        (ModBlocks.TOMATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, TomatoCropBlock.MAX_AGE));
        addDrop(ModBlocks.TOMATO_CROP, cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS,
                tomatoCropBuilder));

        BlockStatePropertyLootCondition.Builder lettuceCropBuilder = BlockStatePropertyLootCondition.builder
                        (ModBlocks.LETTUCE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(LettuceCropBlock.AGE, LettuceCropBlock.MAX_AGE));
        addDrop(ModBlocks.LETTUCE_CROP, cropDrops(ModBlocks.LETTUCE_CROP, ModItems.LETTUCE, ModItems.LETTUCE_SEEDS,
                lettuceCropBuilder));

        BlockStatePropertyLootCondition.Builder pineappleCropBuilder = BlockStatePropertyLootCondition.builder
                        (ModBlocks.PINEAPPLE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(PineappleCropBlock.AGE, PineappleCropBlock.MAX_AGE));
        addDrop(ModBlocks.PINEAPPLE_CROP, cropDrops(ModBlocks.PINEAPPLE_CROP, ModItems.PINEAPPLE, ModItems.PINEAPPLE_SEEDS,
                pineappleCropBuilder));
    }
}
