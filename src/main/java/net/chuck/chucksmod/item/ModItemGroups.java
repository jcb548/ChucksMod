package net.chuck.chucksmod.item;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.fluid.ModFluids;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
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
                        entries.add(ModItems.WRENCH);
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
                        entries.add(ModItems.IRON_AXLE);
                        entries.add(ModItems.IRON_MOTOR);
                        entries.add(ModBlocks.IRON_ENERGY_STORAGE);
                        entries.add(ModBlocks.IRON_POWERED_CRUSHER);
                        entries.add(ModBlocks.IRON_POWERED_FURNACE);
                        entries.add(ModBlocks.IRON_HEAT_GENERATOR);
                        entries.add(ModBlocks.IRON_QUARRY);
                        entries.add(ModBlocks.IRON_FLUID_TANK);
                        entries.add(ModBlocks.IRON_PUMP);
                        entries.add(ModBlocks.IRON_FLUID_PIPE);
                        entries.add(ModBlocks.IRON_STEAM_GENERATOR);

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
                        entries.add(ModItems.TITANIUM_AXLE);
                        entries.add(ModItems.TITANIUM_MOTOR);
                        entries.add(ModBlocks.TITANIUM_MACHINE_BASE);
                        entries.add(ModBlocks.TITANIUM_ENERGY_STORAGE);
                        entries.add(ModBlocks.TITANIUM_POWERED_CRUSHER);
                        entries.add(ModBlocks.TITANIUM_POWERED_FURNACE);
                        entries.add(ModBlocks.TITANIUM_HEAT_GENERATOR);
                        entries.add(ModBlocks.TITANIUM_STEAM_GENERATOR);
                        entries.add(ModBlocks.TITANIUM_LAVA_GENERATOR);
                        entries.add(ModBlocks.TITANIUM_QUARRY);
                        entries.add(ModBlocks.TITANIUM_COPIER);
                        entries.add(ModBlocks.TITANIUM_FLUID_TANK);
                        entries.add(ModBlocks.TITANIUM_PUMP);
                        entries.add(ModBlocks.TITANIUM_FLUID_PIPE);

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

                        entries.add(Blocks.TUFF);
                        entries.add(ModBlocks.TUFF_SLAB);
                        entries.add(ModBlocks.TUFF_STAIRS);
                        entries.add(ModBlocks.TUFF_WALL);

                        entries.add(ModBlocks.ECLOGITE);
                        entries.add(ModBlocks.ECLOGITE_SLAB);
                        entries.add(ModBlocks.ECLOGITE_STAIRS);
                        entries.add(ModBlocks.ECLOGITE_WALL);
                        entries.add(ModBlocks.ECLOGITE_BRICKS);
                        entries.add(ModBlocks.ECLOGITE_BRICK_SLAB);
                        entries.add(ModBlocks.ECLOGITE_BRICK_STAIRS);
                        entries.add(ModBlocks.ECLOGITE_BRICK_WALL);
                        entries.add(ModBlocks.CRACKED_ECLOGITE_BRICKS);
                        entries.add(ModBlocks.POLISHED_ECLOGITE);
                        entries.add(ModBlocks.POLISHED_ECLOGITE_SLAB);
                        entries.add(ModBlocks.POLISHED_ECLOGITE_STAIRS);
                        entries.add(ModBlocks.POLISHED_ECLOGITE_WALL);

                        entries.add(ModBlocks.SERPENTINITE);
                        entries.add(ModBlocks.SERPENTINITE_SLAB);
                        entries.add(ModBlocks.SERPENTINITE_STAIRS);
                        entries.add(ModBlocks.SERPENTINITE_WALL);
                        entries.add(ModBlocks.SERPENTINITE_BRICKS);
                        entries.add(ModBlocks.SERPENTINITE_BRICK_SLAB);
                        entries.add(ModBlocks.SERPENTINITE_BRICK_STAIRS);
                        entries.add(ModBlocks.SERPENTINITE_BRICK_WALL);
                        entries.add(ModBlocks.CRACKED_SERPENTINITE_BRICKS);
                        entries.add(ModBlocks.POLISHED_SERPENTINITE);
                        entries.add(ModBlocks.POLISHED_SERPENTINITE_SLAB);
                        entries.add(ModBlocks.POLISHED_SERPENTINITE_STAIRS);
                        entries.add(ModBlocks.POLISHED_SERPENTINITE_WALL);
                        entries.add(ModBlocks.SERPENTINITE_COAL_ORE);
                        entries.add(ModBlocks.SERPENTINITE_COPPER_ORE);
                        entries.add(ModBlocks.SERPENTINITE_DIAMOND_ORE);
                        entries.add(ModBlocks.SERPENTINITE_PACSARIUM_ORE);
                        entries.add(ModBlocks.SERPENTINITE_EMERALD_ORE);
                        entries.add(ModBlocks.SERPENTINITE_TRIAFIUM_ORE);
                        entries.add(ModBlocks.SERPENTINITE_GOLD_ORE);
                        entries.add(ModBlocks.SERPENTINITE_IRON_ORE);
                        entries.add(ModBlocks.SERPENTINITE_LAPIS_ORE);
                        entries.add(ModBlocks.SERPENTINITE_REDSTONE_ORE);
                        entries.add(ModBlocks.SERPENTINITE_TIN_ORE);
                        entries.add(ModBlocks.SERPENTINITE_TITANIUM_ORE);
                        entries.add(ModBlocks.PIPPIN_ALTAR);

                        entries.add(ModBlocks.GLAUCONITE);
                        entries.add(ModBlocks.GLAUCONITE_SLAB);
                        entries.add(ModBlocks.GLAUCONITE_STAIRS);
                        entries.add(ModBlocks.GLAUCONITE_WALL);
                        entries.add(ModBlocks.GLAUCONITE_BRICKS);
                        entries.add(ModBlocks.GLAUCONITE_BRICK_SLAB);
                        entries.add(ModBlocks.GLAUCONITE_BRICK_STAIRS);
                        entries.add(ModBlocks.GLAUCONITE_BRICK_WALL);
                        entries.add(ModBlocks.CRACKED_GLAUCONITE_BRICKS);
                        entries.add(ModBlocks.POLISHED_GLAUCONITE);
                        entries.add(ModBlocks.POLISHED_GLAUCONITE_SLAB);
                        entries.add(ModBlocks.POLISHED_GLAUCONITE_STAIRS);
                        entries.add(ModBlocks.POLISHED_GLAUCONITE_WALL);
                        
                        entries.add(ModBlocks.TRIAFIA_LOG);
                        entries.add(ModBlocks.TRIAFIA_WOOD);
                        entries.add(ModBlocks.STRIPPED_TRIAFIA_LOG);
                        entries.add(ModBlocks.STRIPPED_TRIAFIA_WOOD);
                        entries.add(ModBlocks.TRIAFIA_PLANKS);
                        entries.add(ModBlocks.TRIAFIA_LEAVES);
                        entries.add(ModBlocks.TRIAFIA_SAPLING);
                        entries.add(ModBlocks.TRIAFIA_SLAB);
                        entries.add(ModBlocks.TRIAFIA_STAIRS);
                        entries.add(ModBlocks.TRIAFIA_BUTTON);
                        entries.add(ModBlocks.TRIAFIA_PRESSURE_PLATE);
                        entries.add(ModBlocks.TRIAFIA_FENCE);
                        entries.add(ModBlocks.TRIAFIA_FENCE_GATE);
                        entries.add(ModBlocks.TRIAFIA_DOOR);
                        entries.add(ModBlocks.TRIAFIA_TRAPDOOR);
                        entries.add(ModItems.TRIAFIA_SIGN);
                        entries.add(ModItems.HANGING_TRIAFIA_SIGN);
                        entries.add(ModItems.TRIAFIA_BOAT);
                        entries.add(ModItems.TRIAFIA_CHEST_BOAT);
                        entries.add(ModItems.TRIAFIA_CRYSTAL);
                        entries.add(ModItems.TRIAFIA_CRYSTAL_SHARD);
                        entries.add(ModItems.TRIAFIA_CRYSTAL_DUST);
                        entries.add(ModBlocks.TRIAFIA_PLANT);
                        entries.add(ModItems.FARMABYN_SPAWN_EGG);
                        entries.add(ModItems.TRIAFIAN_PIG_SPAWN_EGG);
                        entries.add(ModItems.TRIAFIAN_PORKCHOP);
                        entries.add(ModItems.COOKED_TRIAFIAN_PORKCHOP);
                        entries.add(ModItems.PIPPIN_SPAWN_EGG);

                        entries.add(ModItems.RAW_TRIAFIUM);
                        entries.add(ModItems.TRIAFIUM_INGOT);
                        entries.add(ModItems.TRIAFIUM_GEAR);
                        entries.add(ModBlocks.RAW_TRIAFIUM_BLOCK);
                        entries.add(ModBlocks.TRIAFIUM_BLOCK);
                        entries.add(ModBlocks.TRIAFIUM_BARS);
                        entries.add(ModBlocks.NETHER_TRIAFIUM_ORE);
                        entries.add(ModBlocks.END_STONE_TRIAFIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TRIAFIUM_ORE);
                        entries.add(ModItems.TRIAFIUM_SWORD);
                        entries.add(ModItems.TRIAFIUM_PICKAXE);
                        entries.add(ModItems.TRIAFIUM_AXE);
                        entries.add(ModItems.TRIAFIUM_SHOVEL);
                        entries.add(ModItems.TRIAFIUM_HOE);
                        entries.add(ModItems.TRIAFIUM_HELMET);
                        entries.add(ModItems.TRIAFIUM_CHESTPLATE);
                        entries.add(ModItems.TRIAFIUM_LEGGINGS);
                        entries.add(ModItems.TRIAFIUM_BOOTS);
                        entries.add(ModItems.SOUL_BLAZE_SPAWN_EGG);
                        entries.add(ModBlocks.TRIAFIUM_PORTAL_BLOCK);

                        entries.add(ModItems.RAW_PACSARIUM);
                        entries.add(ModItems.PACSARIUM_INGOT);
                        entries.add(ModItems.PACSARIUM_GEAR);
                        entries.add(ModBlocks.RAW_PACSARIUM_BLOCK);
                        entries.add(ModBlocks.PACSARIUM_BLOCK);
                        entries.add(ModBlocks.PACSARIUM_BARS);
                        entries.add(ModBlocks.END_STONE_PACSARIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PACSARIUM_ORE);
                        entries.add(ModItems.PACSARIUM_SWORD);
                        entries.add(ModItems.PACSARIUM_PICKAXE);
                        entries.add(ModItems.PACSARIUM_AXE);
                        entries.add(ModItems.PACSARIUM_SHOVEL);
                        entries.add(ModItems.PACSARIUM_HOE);
                        entries.add(ModItems.PACSARIUM_HELMET);
                        entries.add(ModItems.PACSARIUM_CHESTPLATE);
                        entries.add(ModItems.PACSARIUM_LEGGINGS);
                        entries.add(ModItems.PACSARIUM_BOOTS);
                        entries.add(ModItems.PACSARIA_CRYSTAL);
                        entries.add(ModItems.PACSARIA_CRYSTAL_SHARD);

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
                        entries.add(ModBlocks.PACSARIA_PLANT);
                        entries.add(ModBlocks.PACSARIA_LIGHT_PLANT);
                        entries.add(ModItems.WYATT_SPAWN_EGG);
                        entries.add(ModItems.FRANK_SPAWN_EGG);

                        entries.add(ModBlocks.PACSARIA_LOG);
                        entries.add(ModBlocks.PACSARIA_WOOD);
                        entries.add(ModBlocks.STRIPPED_PACSARIA_LOG);
                        entries.add(ModBlocks.STRIPPED_PACSARIA_WOOD);
                        entries.add(ModBlocks.PACSARIA_PLANKS);
                        entries.add(ModBlocks.PACSARIA_LEAVES);
                        entries.add(ModBlocks.PACSARIA_SAPLING);
                        entries.add(ModBlocks.PACSARIA_SLAB);
                        entries.add(ModBlocks.PACSARIA_STAIRS);
                        entries.add(ModBlocks.PACSARIA_BUTTON);
                        entries.add(ModBlocks.PACSARIA_PRESSURE_PLATE);
                        entries.add(ModBlocks.PACSARIA_FENCE);
                        entries.add(ModBlocks.PACSARIA_FENCE_GATE);
                        entries.add(ModBlocks.PACSARIA_DOOR);
                        entries.add(ModBlocks.PACSARIA_TRAPDOOR);
                        entries.add(ModItems.PACSARIA_SIGN);
                        entries.add(ModItems.HANGING_PACSARIA_SIGN);
                        entries.add(ModItems.PACSARIA_BOAT);
                        entries.add(ModItems.PACSARIA_CHEST_BOAT);

                        entries.add(ModBlocks.FRANK_ALTAR);

                        entries.add(ModItems.PORTABLE_ENDERCHEST);
                        entries.add(ModItems.STRING_STRAP);
                        entries.add(ModItems.LEATHER_STRAP);
                        entries.add(ModItems.WOOL_BAG);
                        entries.add(ModItems.LEATHER_BAG);
                        entries.add(ModItems.COPPER_BAG);

                        entries.add(ModFluids.LIQUID_XP_BUCKET);
                    }).build());
    public static void registerItemGroups() {
        ChucksMod.LOGGER.info("Registering Item Groups for " + ChucksMod.MOD_ID);
    }
}
