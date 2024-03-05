package net.chuck.chucksmod.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.entity.ModBoats;
import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.item.custom.*;
import net.chuck.chucksmod.item.custom.anti_large.*;
import net.chuck.chucksmod.item.custom.aqua.*;
import net.chuck.chucksmod.item.custom.ModSwordItem;
import net.chuck.chucksmod.item.custom.bag.*;
import net.chuck.chucksmod.item.custom.wither.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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
    public static final Item STONE_DUST = registerItem("stone_dust",
            new Item(new FabricItemSettings()));
    public static final Item IRON_DUST = registerItem("iron_dust",
            new Item(new FabricItemSettings()));
    public static final Item COPPER_DUST = registerItem("copper_dust",
            new Item(new FabricItemSettings()));
    public static final Item GOLD_DUST = registerItem("gold_dust",
            new Item(new FabricItemSettings()));

    //Vanilla gears
    public static final Item WRENCH = registerItem("wrench",
            new Item(new FabricItemSettings()));
    public static final Item IRON_GEAR = registerItem("iron_gear",
            new Item(new FabricItemSettings()));
    public static final Item COPPER_GEAR = registerItem("copper_gear",
            new Item(new FabricItemSettings()));
    public static final Item GOLD_GEAR = registerItem("gold_gear",
            new Item(new FabricItemSettings()));
    //Prismarine
    public static final Item IRON_ENERGY_CORE = registerItem("iron_energy_core",
            new Item(new FabricItemSettings()));
    public static final Item IRON_AXLE = registerItem("iron_axle",
            new Item(new FabricItemSettings()));
    public static final Item IRON_MOTOR = registerItem("iron_motor",
            new Item(new FabricItemSettings()));
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
            new ModSwordItem(ModToolMaterials.BRONZE, 3, -2.6f, new FabricItemSettings()));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            new ModPickaxeItem(ModToolMaterials.BRONZE, 1, -3.2f, new FabricItemSettings()));
    public static final Item BRONZE_AXE = registerItem("bronze_axe",
            new ModAxeItem(ModToolMaterials.BRONZE, 6, -4.0f, new FabricItemSettings()));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel",
            new ModShovelItem(ModToolMaterials.BRONZE, 1, -2.8f, new FabricItemSettings()));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe",
            new ModHoeItem(ModToolMaterials.BRONZE, -2, -1.4f, new FabricItemSettings()));
    public static final Item BRONZE_HELMET = registerItem("bronze_helmet",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BRONZE_BOOTS = registerItem("bronze_boots",
            new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    // Machine stuff
    public static final Item COPPER_POWER_CIRCUIT = registerItem("copper_power_circuit",
            new Item(new FabricItemSettings()));
    public static final Item COPPER_COIL = registerItem("copper_coil",
            new Item(new FabricItemSettings()));
    public static final Item GOLD_POWER_CIRCUIT = registerItem("gold_power_circuit",
            new Item(new FabricItemSettings()));
    public static final Item GOLD_COIL = registerItem("gold_coil",
            new Item(new FabricItemSettings()));
    // Obsidian
    public static final Item OBSIDIAN_DUST = registerItem("obsidian_dust",
            new Item(new FabricItemSettings()));
    // Titanium
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_DUST = registerItem("titanium_dust", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_GEAR = registerItem("titanium_gear", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_ENERGY_CORE = registerItem("titanium_energy_core",
            new Item(new FabricItemSettings()));
    public static final Item TITANIUM_AXLE = registerItem("titanium_axle", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_MOTOR = registerItem("titanium_motor", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_SWORD = registerItem("titanium_sword",
            new ModSwordItem(ModToolMaterials.TITANIUM, 3, -2.2f, new FabricItemSettings()));
    public static final Item TITANIUM_PICKAXE = registerItem("titanium_pickaxe",
            new ModPickaxeItem(ModToolMaterials.TITANIUM, 1, -2.8f, new FabricItemSettings()));
    public static final Item TITANIUM_AXE = registerItem("titanium_axe",
            new ModAxeItem(ModToolMaterials.TITANIUM, 6, -3.6f, new FabricItemSettings()));
    public static final Item TITANIUM_SHOVEL = registerItem("titanium_shovel",
            new ModShovelItem(ModToolMaterials.TITANIUM, 1, -2.4f, new FabricItemSettings()));
    public static final Item TITANIUM_HOE = registerItem("titanium_hoe",
            new ModHoeItem(ModToolMaterials.TITANIUM, -2, -1.0f, new FabricItemSettings()));
    public static final Item TITANIUM_HELMET = registerItem("titanium_helmet",
            new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TITANIUM_CHESTPLATE = registerItem("titanium_chestplate",
            new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TITANIUM_LEGGINGS = registerItem("titanium_leggings",
            new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TITANIUM_BOOTS = registerItem("titanium_boots",
            new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));


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
    public static final Item SOUL_DUST = registerItem("soul_dust", new Item(new FabricItemSettings()));
    public static final Item BLAZE_STAR = registerItem("blaze_star", new Item(new FabricItemSettings()));
    public static final Item SOUL_BLAZE_ROD = registerItem("soul_blaze_rod", new Item(new FabricItemSettings()));

    //Triafium
    public static final Item RAW_TRIAFIUM = registerItem("raw_triafium", new Item(new FabricItemSettings()));
    public static final Item TRIAFIUM_INGOT = registerItem("triafium_ingot", new Item(new FabricItemSettings()));
    public static final Item TRIAFIUM_GEAR = registerItem("triafium_gear", new Item(new FabricItemSettings()));
    public static final Item TRIAFIUM_SWORD = registerItem("triafium_sword",
            new ModAntiLargeSwordItem(ModToolMaterials.TRIAFIUM, 3, -1.8f, new FabricItemSettings()));
    public static final Item TRIAFIUM_PICKAXE = registerItem("triafium_pickaxe",
            new ModAntiLargePickaxeItem(ModToolMaterials.TRIAFIUM, 1, -2.4f, new FabricItemSettings()));
    public static final Item TRIAFIUM_AXE = registerItem("triafium_axe",
            new ModAntiLargeAxeItem(ModToolMaterials.TRIAFIUM, 6, -3.2f, new FabricItemSettings()));
    public static final Item TRIAFIUM_SHOVEL = registerItem("triafium_shovel",
            new ModAntiLargeShovelItem(ModToolMaterials.TRIAFIUM, 1, -2.0f, new FabricItemSettings()));
    public static final Item TRIAFIUM_HOE = registerItem("triafium_hoe",
            new ModAntiLargeHoeItem(ModToolMaterials.TRIAFIUM, -2, -0.4f, new FabricItemSettings()));
    public static final Item TRIAFIUM_HELMET = registerItem("triafium_helmet",
            new ArmorItem(ModArmorMaterials.TRIAFIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TRIAFIUM_CHESTPLATE = registerItem("triafium_chestplate",
            new ArmorItem(ModArmorMaterials.TRIAFIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TRIAFIUM_LEGGINGS = registerItem("triafium_leggings",
            new ArmorItem(ModArmorMaterials.TRIAFIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TRIAFIUM_BOOTS = registerItem("triafium_boots",
            new ArmorItem(ModArmorMaterials.TRIAFIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item TRIAFIA_CRYSTAL = registerItem("triafia_crystal",
            new Item(new FabricItemSettings()));
    public static final Item TRIAFIA_CRYSTAL_SHARD = registerItem("triafia_crystal_shard",
            new Item(new FabricItemSettings()));
    public static final Item TRIAFIA_CRYSTAL_DUST = registerItem("triafia_crystal_dust",
            new Item(new FabricItemSettings()));
    public static final Item FARMABYN_SPAWN_EGG = registerItem("farmabyn_spawn_egg",
        new SpawnEggItem(ModEntities.FARMABYN, 0xFFE9AE, 0x345E7E, new FabricItemSettings()));

    // Pacsarium
    public static final Item RAW_PACSARIUM = registerItem("raw_pacsarium", new Item(new FabricItemSettings()));
    public static final Item PACSARIUM_INGOT = registerItem("pacsarium_ingot",
            new Item(new FabricItemSettings()));
    public static final Item PACSARIUM_GEAR = registerItem("pacsarium_gear",
            new Item(new FabricItemSettings()));
    public static final Item PACSARIUM_SWORD = registerItem("pacsarium_sword",
            new ModSwordItem(ModToolMaterials.PACSARIUM, 3, -1.6f, new FabricItemSettings()));
    public static final Item PACSARIUM_PICKAXE = registerItem("pacsarium_pickaxe",
            new ModPickaxeItem(ModToolMaterials.PACSARIUM, 1, -2.2f, new FabricItemSettings()));
    public static final Item PACSARIUM_AXE = registerItem("pacsarium_axe",
            new ModAxeItem(ModToolMaterials.PACSARIUM, 6, -3.0f, new FabricItemSettings()));
    public static final Item PACSARIUM_SHOVEL = registerItem("pacsarium_shovel",
            new ModShovelItem(ModToolMaterials.PACSARIUM, 1, -1.8f, new FabricItemSettings()));
    public static final Item PACSARIUM_HOE = registerItem("pacsarium_hoe",
            new ModHoeItem(ModToolMaterials.PACSARIUM, -2, -1.8f, new FabricItemSettings()));
    public static final Item PACSARIUM_HELMET = registerItem("pacsarium_helmet",
            new ArmorItem(ModArmorMaterials.PACSARIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PACSARIUM_CHESTPLATE = registerItem("pacsarium_chestplate",
            new ArmorItem(ModArmorMaterials.PACSARIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PACSARIUM_LEGGINGS = registerItem("pacsarium_leggings",
            new ArmorItem(ModArmorMaterials.PACSARIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PACSARIUM_BOOTS = registerItem("pacsarium_boots",
            new ArmorItem(ModArmorMaterials.PACSARIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SOUL_BLAZE_SPAWN_EGG = registerItem("soul_blaze_spawn_egg",
            new SpawnEggItem(ModEntities.SOUL_BLAZE_BOSS, 0xD8CCF6, 0x00007B,
                    new FabricItemSettings()));
    public static final Item WYATT_SPAWN_EGG = registerItem("wyatt_spawn_egg",
            new SpawnEggItem(ModEntities.WYATT, 0xA175B6, 0x54002C,
                    new FabricItemSettings()));
    public static final Item FRANK_SPAWN_EGG = registerItem("frank_spawn_egg",
            new SpawnEggItem(ModEntities.FRANK_BOSS, 0xEED2FC, 0x000000,
                    new FabricItemSettings()));
    public static final Item PACSARIA_CRYSTAL = registerItem("pacsaria_crystal",
            new Item(new FabricItemSettings()));
    public static final Item PACSARIA_CRYSTAL_SHARD = registerItem("pacsaria_crystal_shard",
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
    public static final Item TRIAFIUM_BAG = registerItem("triafium_bag",
            new BagItem7x2(new FabricItemSettings()));
    public static final Item NETHERITE_BAG = registerItem("netherite_bag",
            new BagItem7x2(new FabricItemSettings()));
    public static final Item EUCALYPTUS_SIGN = registerItem("eucalyptus_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.STANDING_EUCALYPTUS_SIGN, ModBlocks.WALL_EUCALYPTUS_SIGN));
    public static final Item HANGING_EUCALYPTUS_SIGN = registerItem("eucalyptus_hanging_sign",
            new HangingSignItem(ModBlocks.HANGING_EUCALYPTUS_SIGN, ModBlocks.WALL_HANGING_EUCALYPTUS_SIGN,
                    new FabricItemSettings().maxCount(16)));
    public static final Item EUCALYPTUS_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ModBoats.EUCALYPTUS_BOAT_ID,
            ModBoats.EUCALYPTUS_BOAT_KEY, false);
    public static final Item EUCALYPTUS_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ModBoats.EUCALYPTUS_CHEST_BOAT_ID,
                    ModBoats.EUCALYPTUS_BOAT_KEY, true);
    public static final Item PACSARIA_SIGN = registerItem("pacsaria_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.STANDING_PACSARIA_SIGN, ModBlocks.WALL_PACSARIA_SIGN));
    public static final Item HANGING_PACSARIA_SIGN = registerItem("pacsaria_hanging_sign",
            new HangingSignItem(ModBlocks.HANGING_PACSARIA_SIGN, ModBlocks.WALL_HANGING_PACSARIA_SIGN,
                    new FabricItemSettings().maxCount(16)));
    public static final Item PACSARIA_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ModBoats.PACSARIA_BOAT_ID,
                    ModBoats.PACSARIA_BOAT_KEY, false);
    public static final Item PACSARIA_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ModBoats.PACSARIA_CHEST_BOAT_ID,
                    ModBoats.PACSARIA_BOAT_KEY, true);
    public static final Item TRIAFIA_SIGN = registerItem("triafia_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.STANDING_TRIAFIA_SIGN, ModBlocks.WALL_TRIAFIA_SIGN));
    public static final Item HANGING_TRIAFIA_SIGN = registerItem("triafia_hanging_sign",
            new HangingSignItem(ModBlocks.HANGING_TRIAFIA_SIGN, ModBlocks.WALL_HANGING_TRIAFIA_SIGN,
                    new FabricItemSettings().maxCount(16)));
    public static final Item TRIAFIA_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ModBoats.TRIAFIA_BOAT_ID,
                    ModBoats.TRIAFIA_BOAT_KEY, false);
    public static final Item TRIAFIA_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ModBoats.TRIAFIA_CHEST_BOAT_ID,
                    ModBoats.TRIAFIA_BOAT_KEY, true);

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
