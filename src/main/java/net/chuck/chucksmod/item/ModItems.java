package net.chuck.chucksmod.item;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.item.custom.*;
import net.chuck.chucksmod.item.custom.anti_large.*;
import net.chuck.chucksmod.item.custom.aqua.*;
import net.chuck.chucksmod.item.custom.ModSwordItem;
import net.chuck.chucksmod.item.custom.bag.*;
import net.chuck.chucksmod.item.custom.wither.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.*;
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
public class ModItems {
    // random food items
    public static final Item HAMBURGER = registerItem("hamburger",
            new Item(new FabricItemSettings().food(ModFoodComponents.HAMBURGER)));
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));
    public static final Item LETTUCE = registerItem("lettuce",
            new Item(new FabricItemSettings().food(ModFoodComponents.LETTUCE)));
    public static final Item LETTUCE_SEEDS = registerItem("lettuce_seeds",
            new AliasedBlockItem(ModBlocks.LETTUCE_CROP, new FabricItemSettings()));
    public static final Item PINEAPPLE = registerItem("pineapple",
            new Item(new FabricItemSettings().food(ModFoodComponents.PINEAPPLE)));
    public static final Item PINEAPPLE_SEEDS = registerItem("pineapple_seeds",
            new AliasedBlockItem(ModBlocks.PINEAPPLE_CROP, new FabricItemSettings()));
    // Crushed Vanilla Resources
    public static final Item IRON_DUST = registerItem("iron_dust",
            new Item(new FabricItemSettings()));
    public static final Item COPPER_DUST = registerItem("copper_dust",
            new Item(new FabricItemSettings()));
    public static final Item GOLD_DUST = registerItem("gold_dust",
            new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_DUST = registerItem("obsidian_dust",
            new Item(new FabricItemSettings()));

    //Vanilla gears
    public static final Item IRON_GEAR = registerItem("iron_gear",
            new Item(new FabricItemSettings()));
    public static final Item COPPER_GEAR = registerItem("copper_gear",
            new Item(new FabricItemSettings()));
    public static final Item GOLD_GEAR = registerItem("gold_gear",
            new Item(new FabricItemSettings()));
    //Prismarine
    public static final Item PRISMARINE_DUST = registerItem("prismarine_dust",
            new Item(new FabricItemSettings()));
    public static final Item PRISMARINE_IRON_DUST = registerItem("prismarine_iron_dust",
            new Item(new FabricItemSettings()));
    public static final Item PRISMARINE_INGOT = registerItem("prismarine_ingot",
            new Item(new FabricItemSettings()));
    public static final Item PRISMARINE_GEAR = registerItem("prismarine_gear",
            new Item(new FabricItemSettings()));
    public static final Item PRISMARINE_SWORD = registerItem("prismarine_sword",
        new ModAquaSwordItem(ModToolMaterials.PRISMARINE, 3, -2.0f, new FabricItemSettings()));
    public static final Item PRISMARINE_PICKAXE = registerItem("prismarine_pickaxe",
        new ModAquaPickaxeItem(ModToolMaterials.PRISMARINE, 1, -2.4f, new FabricItemSettings()));
    public static final Item PRISMARINE_AXE = registerItem("prismarine_axe",
        new ModAquaAxeItem(ModToolMaterials.PRISMARINE, 6, -2.6f, new FabricItemSettings()));
    public static final Item PRISMARINE_SHOVEL = registerItem("prismarine_shovel",
            new ModAquaShovelItem(ModToolMaterials.PRISMARINE, 1, -3.6f, new FabricItemSettings()));
    public static final Item PRISMARINE_HOE = registerItem("prismarine_hoe",
            new ModAquaHoeItem(ModToolMaterials.PRISMARINE, -2, -0.4f, new FabricItemSettings()));
    public static final Item PRISMARINE_HELMET = registerItem("prismarine_helmet",
            new ArmorItem(ModArmorMaterials.PRISMARINE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PRISMARINE_CHESTPLATE = registerItem("prismarine_chestplate",
            new ArmorItem(ModArmorMaterials.PRISMARINE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PRISMARINE_LEGGINGS = registerItem("prismarine_leggings",
            new ArmorItem(ModArmorMaterials.PRISMARINE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PRISMARINE_BOOTS = registerItem("prismarine_boots",
            new ArmorItem(ModArmorMaterials.PRISMARINE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    // Tin
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings()));
    public static final Item TIN_DUST = registerItem("tin_dust", new Item(new FabricItemSettings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));
    public static final Item TIN_GEAR = registerItem("tin_gear", new Item(new FabricItemSettings()));

    //Bronze
    public static final Item BRONZE_DUST = registerItem("bronze_dust", new Item(new FabricItemSettings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings()));
    public static final Item BRONZE_GEAR = registerItem("bronze_gear", new Item(new FabricItemSettings()));
    public static final Item BRONZE_SWORD = registerItem("bronze_sword",
            new ModSwordItem(ModToolMaterials.BRONZE, 3, -1.6f, new FabricItemSettings()));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            new ModPickaxeItem(ModToolMaterials.BRONZE, 1, -2.2f, new FabricItemSettings()));
    public static final Item BRONZE_AXE = registerItem("bronze_axe",
            new ModAxeItem(ModToolMaterials.BRONZE, 6, -3.0f, new FabricItemSettings()));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel",
            new ModShovelItem(ModToolMaterials.BRONZE, 1, -1.8f, new FabricItemSettings()));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe",
            new ModHoeItem(ModToolMaterials.BRONZE, -2, -0.4f, new FabricItemSettings()));
    public static final Item BRONZE_HELMET = registerItem("bronze_helmet",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BRONZE_BOOTS = registerItem("bronze_boots",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    // Wither items
    public static final Item WITHER_BONE = registerItem("wither_bone", new Item(new FabricItemSettings()));
    public static final Item WITHER_SWORD = registerItem("wither_sword",
            new ModWitherSwordItem(ModToolMaterials.WITHER, 3, -2.2f, new FabricItemSettings()));
    public static final Item WITHER_PICKAXE = registerItem("wither_pickaxe",
            new ModWitherPickaxeItem(ModToolMaterials.WITHER, 1, -2.8f, new FabricItemSettings()));
    public static final Item WITHER_AXE = registerItem("wither_axe",
            new ModWitherAxeItem(ModToolMaterials.WITHER, 6, -2.8f, new FabricItemSettings()));
    public static final Item WITHER_SHOVEL = registerItem("wither_shovel",
            new ModWitherShovelItem(ModToolMaterials.WITHER, 1, -3.8f, new FabricItemSettings()));
    public static final Item WITHER_HOE = registerItem("wither_hoe",
            new ModWitherHoeItem(ModToolMaterials.WITHER, -2, -0.6f, new FabricItemSettings()));
    //Fabium
    public static final Item RAW_FABIUM = registerItem("raw_fabium", new Item(new FabricItemSettings()));
    public static final Item FABIUM_INGOT = registerItem("fabium_ingot", new Item(new FabricItemSettings()));
    public static final Item FABIUM_GEAR = registerItem("fabium_gear", new Item(new FabricItemSettings()));
    public static final Item FABIUM_SWORD = registerItem("fabium_sword",
            new ModAntiLargeSwordItem(ModToolMaterials.FABIUM, 3, -1.8f, new FabricItemSettings()));
    public static final Item FABIUM_PICKAXE = registerItem("fabium_pickaxe",
            new ModAntiLargePickaxeItem(ModToolMaterials.FABIUM, 1, -2.4f, new FabricItemSettings()));
    public static final Item FABIUM_AXE = registerItem("fabium_axe",
            new ModAntiLargeAxeItem(ModToolMaterials.FABIUM, 6, -3.2f, new FabricItemSettings()));
    public static final Item FABIUM_SHOVEL = registerItem("fabium_shovel",
            new ModAntiLargeShovelItem(ModToolMaterials.FABIUM, 1, -2.0f, new FabricItemSettings()));
    public static final Item FABIUM_HOE = registerItem("fabium_hoe",
            new ModAntiLargeHoeItem(ModToolMaterials.FABIUM, -2, -0.4f, new FabricItemSettings()));
    public static final Item FABIUM_HELMET = registerItem("fabium_helmet",
            new ArmorItem(ModArmorMaterials.FABIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item FABIUM_CHESTPLATE = registerItem("fabium_chestplate",
            new ArmorItem(ModArmorMaterials.FABIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item FABIUM_LEGGINGS = registerItem("fabium_leggings",
            new ArmorItem(ModArmorMaterials.FABIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item FABIUM_BOOTS = registerItem("fabium_boots",
            new ArmorItem(ModArmorMaterials.FABIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    // Diritonium
    public static final Item RAW_DIRITONIUM = registerItem("raw_diritonium", new Item(new FabricItemSettings()));
    public static final Item DIRITONIUM_INGOT = registerItem("diritonium_ingot",
            new Item(new FabricItemSettings()));
    public static final Item DIRITONIUM_GEAR = registerItem("diritonium_gear",
            new Item(new FabricItemSettings()));
    public static final Item DIRITONIUM_SWORD = registerItem("diritonium_sword",
            new ModSwordItem(ModToolMaterials.DIRITONIUM, 3, -1.6f, new FabricItemSettings()));
    public static final Item DIRITONIUM_PICKAXE = registerItem("diritonium_pickaxe",
            new ModPickaxeItem(ModToolMaterials.DIRITONIUM, 1, -2.2f, new FabricItemSettings()));
    public static final Item DIRITONIUM_AXE = registerItem("diritonium_axe",
            new ModAxeItem(ModToolMaterials.DIRITONIUM, 6, -3.0f, new FabricItemSettings()));
    public static final Item DIRITONIUM_SHOVEL = registerItem("diritonium_shovel",
            new ModShovelItem(ModToolMaterials.DIRITONIUM, 1, -1.8f, new FabricItemSettings()));
    public static final Item DIRITONIUM_HOE = registerItem("diritonium_hoe",
            new ModHoeItem(ModToolMaterials.DIRITONIUM, -2, -1.8f, new FabricItemSettings()));
    public static final Item DIRITONIUM_HELMET = registerItem("diritonium_helmet",
            new ArmorItem(ModArmorMaterials.DIRITONIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DIRITONIUM_CHESTPLATE = registerItem("diritonium_chestplate",
            new ArmorItem(ModArmorMaterials.DIRITONIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DIRITONIUM_LEGGINGS = registerItem("diritonium_leggings",
            new ArmorItem(ModArmorMaterials.DIRITONIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item DIRITONIUM_BOOTS = registerItem("diritonium_boots",
            new ArmorItem(ModArmorMaterials.DIRITONIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item WYATT_SPAWN_EGG = registerItem("wyatt_spawn_egg",
            new SpawnEggItem(ModEntities.WYATT, 0xA175B6, 0x54002C,
                    new FabricItemSettings()));
    public static final Item FRANK_SPAWN_EGG = registerItem("frank_spawn_egg",
            new SpawnEggItem(ModEntities.FRANK_BOSS, 0xEED2FC, 0x000000,
                    new FabricItemSettings()));
    public static final Item DIRITIA_CRYSTAL = registerItem("diritia_crystal",
            new Item(new FabricItemSettings()));
    public static final Item DIRITIA_CRYSTAL_SHARD = registerItem("diritia_crystal_shard",
            new Item(new FabricItemSettings()));

    public static final Item PORTABLE_ENDERCHEST = registerItem("portable_enderchest",
            new PortableEnderChestItem(new FabricItemSettings()));

    public static final Item STRING_STRAP = registerItem("string_strap", new Item(new FabricItemSettings()));
    public static final Item LEATHER_STRAP = registerItem("leather_strap", new Item(new FabricItemSettings()));

    public static final Item WOOL_BAG = registerItem("wool_bag", new BagItem3x1(new FabricItemSettings()));
    public static final Item LEATHER_BAG = registerItem("leather_bag",
            new BagItem5x1(new FabricItemSettings()));
    public static final Item COPPER_BAG = registerItem("copper_bag",
            new BagItem7x1(new FabricItemSettings()));
    public static final Item IRON_BAG = registerItem("iron_bag",
            new BagItem9x1(new FabricItemSettings()));
    public static final Item BRONZE_BAG = registerItem("bronze_bag",
            new BagItem9x1(new FabricItemSettings()));
    public static final Item FABIUM_BAG = registerItem("fabium_bag",
            new BagItem7x2(new FabricItemSettings()));
    public static final Item NETHERITE_BAG = registerItem("netherite_bag",
            new BagItem7x2(new FabricItemSettings()));

    private static void addItemsToIngredientGroup(FabricItemGroupEntries entries){
        entries.add(RAW_TIN);
        entries.add(TIN_DUST);
        entries.add(TIN_INGOT);
        entries.add(BRONZE_DUST);
        entries.add(BRONZE_INGOT);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ChucksMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ChucksMod.LOGGER.info("Registering Mod Items for " + ChucksMod.MOD_ID);
    }
}
