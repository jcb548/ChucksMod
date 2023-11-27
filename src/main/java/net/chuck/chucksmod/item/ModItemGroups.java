package net.chuck.chucksmod.item;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModItemGroups {
    public static final ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ChucksMod.MOD_ID, "chucksmod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.chucksmod"))
                .icon(() -> new ItemStack(Items.PORKCHOP)).entries((displayContext, entries) -> {
                        entries.add(ModItems.HAMBURGER);
                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModItems.LETTUCE);
                        entries.add(ModItems.LETTUCE_SEEDS);
                        entries.add(ModItems.PINEAPPLE);
                        entries.add(ModItems.PINEAPPLE_SEEDS);

                        entries.add(ModBlocks.SANDSTONE_BRICKS);
                        entries.add(ModBlocks.SANDSTONE_BRICK_STAIRS);
                        entries.add(ModBlocks.SANDSTONE_BRICK_SLAB);
                        entries.add(ModBlocks.SANDSTONE_BRICK_WALL);
                        entries.add(ModBlocks.CRACKED_SANDSTONE_BRICKS);

                        entries.add(ModItems.STONE_DUST);

                        entries.add(ModItems.IRON_DUST);
                        entries.add(ModBlocks.IRON_DUST_BLOCK);
                        entries.add(ModItems.IRON_GEAR);
                        entries.add(ModItems.IRON_ENERGY_CORE);
                        entries.add(ModBlocks.IRON_MACHINE_BASE);
                        entries.add(ModBlocks.IRON_ENERGY_STORAGE);
                        entries.add(ModBlocks.IRON_POWERED_CRUSHER);
                        entries.add(ModBlocks.IRON_POWERED_FURNACE);
                        entries.add(ModBlocks.IRON_HEAT_GENERATOR);
                        entries.add(ModBlocks.IRON_QUARRY);

                        entries.add(ModItems.COPPER_DUST);
                        entries.add(ModBlocks.COPPER_DUST_BLOCK);
                        entries.add(ModBlocks.COPPER_BARS);
                        entries.add(ModBlocks.COPPER_WIRE);
                        entries.add(ModItems.COPPER_GEAR);
                        entries.add(ModItems.COPPER_POWER_CIRCUIT);
                        entries.add(ModItems.COPPER_COIL);

                        entries.add(ModItems.GOLD_DUST);
                        entries.add(ModBlocks.GOLD_DUST_BLOCK);
                        entries.add(ModBlocks.GOLD_BARS);
                        entries.add(ModItems.GOLD_GEAR);
                        entries.add(ModBlocks.GOLD_WIRE);
                        entries.add(ModItems.GOLD_POWER_CIRCUIT);
                        entries.add(ModItems.GOLD_COIL);

                        entries.add(ModItems.OBSIDIAN_DUST);
                        entries.add(ModBlocks.OBSIDIAN_SAND);

                        entries.add(ModBlocks.HARDENED_GLASS);
                        entries.add(ModBlocks.HARDENED_TINTED_GLASS);
                        entries.add(ModBlocks.HARDENED_BLACK_GLASS);
                        entries.add(ModBlocks.HARDENED_BLUE_GLASS);
                        entries.add(ModBlocks.HARDENED_BROWN_GLASS);
                        entries.add(ModBlocks.HARDENED_CYAN_GLASS);
                        entries.add(ModBlocks.HARDENED_GRAY_GLASS);
                        entries.add(ModBlocks.HARDENED_GREEN_GLASS);
                        entries.add(ModBlocks.HARDENED_LIGHT_BLUE_GLASS);
                        entries.add(ModBlocks.HARDENED_LIGHT_GRAY_GLASS);
                        entries.add(ModBlocks.HARDENED_LIME_GLASS);
                        entries.add(ModBlocks.HARDENED_MAGENTA_GLASS);
                        entries.add(ModBlocks.HARDENED_ORANGE_GLASS);
                        entries.add(ModBlocks.HARDENED_PINK_GLASS);
                        entries.add(ModBlocks.HARDENED_PURPLE_GLASS);
                        entries.add(ModBlocks.HARDENED_RED_GLASS);
                        entries.add(ModBlocks.HARDENED_WHITE_GLASS);
                        entries.add(ModBlocks.HARDENED_YELLOW_GLASS);

                        entries.add(ModBlocks.HARDENED_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_BLACK_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_BLUE_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_BROWN_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_CYAN_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_GRAY_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_GREEN_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_LIGHT_BLUE_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_LIGHT_GRAY_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_LIME_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_MAGENTA_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_ORANGE_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_PINK_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_PURPLE_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_RED_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_WHITE_GLASS_PANE);
                        entries.add(ModBlocks.HARDENED_YELLOW_GLASS_PANE);

                        entries.add(ModItems.PRISMARINE_DUST);
                        entries.add(ModBlocks.PRISMARINE_DUST_BLOCK);
                        entries.add(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);
                        entries.add(ModBlocks.PRISMARINE_BARS);
                        entries.add(ModItems.PRISMARINE_IRON_DUST);
                        entries.add(ModItems.PRISMARINE_INGOT);
                        entries.add(ModItems.PRISMARINE_GEAR);
                        entries.add(ModItems.PRISMARINE_SWORD);
                        entries.add(ModItems.PRISMARINE_PICKAXE);
                        entries.add(ModItems.PRISMARINE_AXE);
                        entries.add(ModItems.PRISMARINE_SHOVEL);
                        entries.add(ModItems.PRISMARINE_HOE);
                        entries.add(ModItems.PRISMARINE_HELMET);
                        entries.add(ModItems.PRISMARINE_CHESTPLATE);
                        entries.add(ModItems.PRISMARINE_LEGGINGS);
                        entries.add(ModItems.PRISMARINE_BOOTS);

                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.TIN_DUST);
                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModItems.TIN_GEAR);
                        entries.add(ModBlocks.TIN_WIRE);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.RAW_TIN_BLOCK);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModBlocks.TIN_DUST_BLOCK);
                        entries.add(ModBlocks.TIN_BARS);

                        entries.add(ModItems.BRONZE_DUST);
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModItems.BRONZE_GEAR);
                        entries.add(ModItems.BRONZE_SWORD);
                        entries.add(ModItems.BRONZE_PICKAXE);
                        entries.add(ModItems.BRONZE_AXE);
                        entries.add(ModItems.BRONZE_SHOVEL);
                        entries.add(ModItems.BRONZE_HOE);
                        entries.add(ModBlocks.BRONZE_BLOCK);
                        entries.add(ModBlocks.BRONZE_BARS);
                        entries.add(ModBlocks.BRONZE_DUST_BLOCK);
                        entries.add(ModItems.BRONZE_HELMET);
                        entries.add(ModItems.BRONZE_CHESTPLATE);
                        entries.add(ModItems.BRONZE_LEGGINGS);
                        entries.add(ModItems.BRONZE_BOOTS);

                        entries.add(ModItems.RAW_TITANIUM);
                        entries.add(ModItems.TITANIUM_INGOT);
                        entries.add(ModBlocks.RAW_TITANIUM_BLOCK);
                        entries.add(ModBlocks.TITANIUM_BLOCK);
                        entries.add(ModBlocks.TITANIUM_BARS);
                        entries.add(ModBlocks.TITANIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TITANIUM_ORE);
                        entries.add(ModBlocks.NETHER_TITANIUM_ORE);
                        entries.add(ModBlocks.END_STONE_TITANIUM_ORE);
                        entries.add(ModItems.TITANIUM_SWORD);
                        entries.add(ModItems.TITANIUM_PICKAXE);
                        entries.add(ModItems.TITANIUM_AXE);
                        entries.add(ModItems.TITANIUM_SHOVEL);
                        entries.add(ModItems.TITANIUM_HOE);
                        entries.add(ModItems.TITANIUM_HELMET);
                        entries.add(ModItems.TITANIUM_CHESTPLATE);
                        entries.add(ModItems.TITANIUM_LEGGINGS);
                        entries.add(ModItems.TITANIUM_BOOTS);
                        entries.add(ModItems.TITANIUM_DUST);
                        entries.add(ModBlocks.TITANIUM_DUST_BLOCK);
                        entries.add(ModItems.TITANIUM_GEAR);
                        entries.add(ModItems.TITANIUM_ENERGY_CORE);
                        entries.add(ModBlocks.TITANIUM_MACHINE_BASE);
                        entries.add(ModBlocks.TITANIUM_ENERGY_STORAGE);
                        entries.add(ModBlocks.TITANIUM_POWERED_CRUSHER);
                        entries.add(ModBlocks.TITANIUM_POWERED_FURNACE);
                        entries.add(ModBlocks.TITANIUM_HEAT_GENERATOR);

                        entries.add(ModItems.SOUL_DUST);
                        entries.add(ModBlocks.SOUL_GRAVEL);
                        entries.add(ModBlocks.SOUL_STONE);
                        entries.add(ModBlocks.SOUL_STONE_STAIRS);
                        entries.add(ModBlocks.SOUL_STONE_SLAB);
                        entries.add(ModBlocks.SOUL_STONE_BRICKS);
                        entries.add(ModBlocks.SOUL_STONE_BRICK_STAIRS);
                        entries.add(ModBlocks.SOUL_STONE_BRICK_SLAB);
                        entries.add(ModBlocks.SOUL_STONE_BRICK_WALL);
                        entries.add(ModItems.BLAZE_STAR);
                        entries.add(ModBlocks.SOUL_BLAZE_ALTAR);
                        entries.add(ModItems.SOUL_BLAZE_ROD);

                        entries.add(ModItems.RAW_FABIUM);
                        entries.add(ModItems.FABIUM_INGOT);
                        entries.add(ModItems.FABIUM_GEAR);
                        entries.add(ModBlocks.RAW_FABIUM_BLOCK);
                        entries.add(ModBlocks.FABIUM_BLOCK);
                        entries.add(ModBlocks.FABIUM_BARS);
                        entries.add(ModBlocks.NETHER_FABIUM_ORE);
                        entries.add(ModBlocks.END_STONE_FABIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_FABIUM_ORE);
                        entries.add(ModItems.FABIUM_SWORD);
                        entries.add(ModItems.FABIUM_PICKAXE);
                        entries.add(ModItems.FABIUM_AXE);
                        entries.add(ModItems.FABIUM_SHOVEL);
                        entries.add(ModItems.FABIUM_HOE);
                        entries.add(ModItems.FABIUM_HELMET);
                        entries.add(ModItems.FABIUM_CHESTPLATE);
                        entries.add(ModItems.FABIUM_LEGGINGS);
                        entries.add(ModItems.FABIUM_BOOTS);
                        entries.add(ModItems.SOUL_BLAZE_SPAWN_EGG);

                        entries.add(ModItems.RAW_DIRITONIUM);
                        entries.add(ModItems.DIRITONIUM_INGOT);
                        entries.add(ModItems.DIRITONIUM_GEAR);
                        entries.add(ModBlocks.RAW_DIRITONIUM_BLOCK);
                        entries.add(ModBlocks.DIRITONIUM_BLOCK);
                        entries.add(ModBlocks.DIRITONIUM_BARS);
                        entries.add(ModBlocks.END_STONE_DIRITONIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_DIRITONIUM_ORE);
                        entries.add(ModItems.DIRITONIUM_SWORD);
                        entries.add(ModItems.DIRITONIUM_PICKAXE);
                        entries.add(ModItems.DIRITONIUM_AXE);
                        entries.add(ModItems.DIRITONIUM_SHOVEL);
                        entries.add(ModItems.DIRITONIUM_HOE);
                        entries.add(ModItems.DIRITONIUM_HELMET);
                        entries.add(ModItems.DIRITONIUM_CHESTPLATE);
                        entries.add(ModItems.DIRITONIUM_LEGGINGS);
                        entries.add(ModItems.DIRITONIUM_BOOTS);
                        entries.add(ModItems.DIRITIA_CRYSTAL);
                        entries.add(ModItems.DIRITIA_CRYSTAL_SHARD);

                        entries.add(ModItems.WITHER_BONE);
                        entries.add(ModItems.WITHER_SWORD);
                        entries.add(ModItems.WITHER_PICKAXE);
                        entries.add(ModItems.WITHER_AXE);
                        entries.add(ModItems.WITHER_SHOVEL);
                        entries.add(ModItems.WITHER_HOE);

                        entries.add(ModBlocks.EUCALYPTUS_LOG);
                        entries.add(ModBlocks.EUCALYPTUS_WOOD);
                        entries.add(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
                        entries.add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
                        entries.add(ModBlocks.EUCALYPTUS_PLANKS);
                        entries.add(ModBlocks.EUCALYPTUS_LEAVES);
                        entries.add(ModBlocks.EUCALYPTUS_SAPLING);
                        entries.add(ModBlocks.EUCALYPTUS_SLAB);
                        entries.add(ModBlocks.EUCALYPTUS_STAIRS);
                        entries.add(ModBlocks.EUCALYPTUS_BUTTON);
                        entries.add(ModBlocks.EUCALYPTUS_PRESSURE_PLATE);
                        entries.add(ModBlocks.EUCALYPTUS_FENCE);
                        entries.add(ModBlocks.EUCALYPTUS_FENCE_GATE);
                        entries.add(ModBlocks.EUCALYPTUS_DOOR);
                        entries.add(ModBlocks.EUCALYPTUS_TRAPDOOR);
                        entries.add(ModItems.EUCALYPTUS_SIGN);
                        entries.add(ModItems.HANGING_EUCALYPTUS_SIGN);
                        entries.add(ModItems.EUCALYPTUS_BOAT);
                        entries.add(ModItems.EUCALYPTUS_CHEST_BOAT);

                        entries.add(ModBlocks.CRUSHER);
                        entries.add(ModBlocks.DIRITIA_PLANT);
                        entries.add(ModBlocks.DIRITIA_LIGHT_PLANT);
                        entries.add(ModItems.WYATT_SPAWN_EGG);
                        entries.add(ModItems.FRANK_SPAWN_EGG);

                        entries.add(ModBlocks.DIRITIA_LOG);
                        entries.add(ModBlocks.DIRITIA_WOOD);
                        entries.add(ModBlocks.STRIPPED_DIRITIA_LOG);
                        entries.add(ModBlocks.STRIPPED_DIRITIA_WOOD);
                        entries.add(ModBlocks.DIRITIA_PLANKS);
                        entries.add(ModBlocks.DIRITIA_LEAVES);
                        entries.add(ModBlocks.DIRITIA_SAPLING);
                        entries.add(ModBlocks.DIRITIA_SLAB);
                        entries.add(ModBlocks.DIRITIA_STAIRS);
                        entries.add(ModBlocks.DIRITIA_BUTTON);
                        entries.add(ModBlocks.DIRITIA_PRESSURE_PLATE);
                        entries.add(ModBlocks.DIRITIA_FENCE);
                        entries.add(ModBlocks.DIRITIA_FENCE_GATE);
                        entries.add(ModBlocks.DIRITIA_DOOR);
                        entries.add(ModBlocks.DIRITIA_TRAPDOOR);
                        entries.add(ModItems.DIRITIA_SIGN);
                        entries.add(ModItems.HANGING_DIRITIA_SIGN);
                        entries.add(ModItems.DIRITIA_BOAT);
                        entries.add(ModItems.DIRITIA_CHEST_BOAT);

                        entries.add(ModBlocks.FRANK_ALTAR);

                        entries.add(ModItems.PORTABLE_ENDERCHEST);
                        entries.add(ModItems.STRING_STRAP);
                        entries.add(ModItems.LEATHER_STRAP);
                        entries.add(ModItems.WOOL_BAG);
                        entries.add(ModItems.LEATHER_BAG);
                        entries.add(ModItems.COPPER_BAG);
                    }).build());
    public static void registerItemGroups() {
        ChucksMod.LOGGER.info("Registering Item Groups for " + ChucksMod.MOD_ID);
    }
}
