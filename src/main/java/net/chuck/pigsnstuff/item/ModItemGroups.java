package net.chuck.pigsnstuff.item;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItems;
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
    public static final ItemGroup PIGS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PigsNStuff.MOD_ID, "pigsnstuff"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pigsnstuff"))
                .icon(() -> new ItemStack(Items.PORKCHOP)).entries((displayContext, entries) -> {
                        entries.add(ModItems.CHEESEBURGER);

                        entries.add(ModItems.IRON_DUST);
                        entries.add(ModItems.COPPER_DUST);
                        entries.add(ModItems.GOLD_DUST);
                        entries.add(ModItems.IRON_GEAR);
                        entries.add(ModItems.COPPER_GEAR);
                        entries.add(ModItems.GOLD_GEAR);
                        entries.add(ModBlocks.IRON_DUST_BLOCK);
                        entries.add(ModBlocks.COPPER_DUST_BLOCK);
                        entries.add(ModBlocks.GOLD_DUST_BLOCK);
                        entries.add(ModBlocks.TIN_DUST_BLOCK);

                        entries.add(ModItems.PRISMARINE_DUST);
                        entries.add(ModBlocks.PRISMARINE_DUST_BLOCK);
                        entries.add(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);
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
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);

                        entries.add(ModItems.BRONZE_DUST);
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModItems.BRONZE_GEAR);
                        entries.add(ModItems.BRONZE_SWORD);
                        entries.add(ModItems.BRONZE_PICKAXE);
                        entries.add(ModItems.BRONZE_AXE);
                        entries.add(ModItems.BRONZE_SHOVEL);
                        entries.add(ModItems.BRONZE_HOE);
                        entries.add(ModBlocks.BRONZE_BLOCK);
                        entries.add(ModBlocks.BRONZE_DUST_BLOCK);
                        entries.add(ModItems.BRONZE_HELMET);
                        entries.add(ModItems.BRONZE_CHESTPLATE);
                        entries.add(ModItems.BRONZE_LEGGINGS);
                        entries.add(ModItems.BRONZE_BOOTS);

                        entries.add(ModItems.RAW_FABIUM);
                        entries.add(ModItems.FABIUM_INGOT);
                        entries.add(ModItems.FABIUM_GEAR);
                        entries.add(ModBlocks.RAW_FABIUM_BLOCK);
                        entries.add(ModBlocks.FABIUM_BLOCK);
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

                        entries.add(ModItems.RAW_DIRITONIUM);
                        entries.add(ModItems.DIRITONIUM_INGOT);
                        entries.add(ModItems.DIRITONIUM_GEAR);
                        entries.add(ModBlocks.RAW_DIRITONIUM_BLOCK);
                        entries.add(ModBlocks.DIRITONIUM_BLOCK);
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

                        entries.add(ModItems.WITHER_BONE);
                        entries.add(ModItems.WITHER_SWORD);
                        entries.add(ModItems.WITHER_PICKAXE);
                        entries.add(ModItems.WITHER_AXE);
                        entries.add(ModItems.WITHER_SHOVEL);
                        entries.add(ModItems.WITHER_HOE);;

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

                        entries.add(ModBlocks.CRUSHER);
                        entries.add(ModBlocks.POWERED_CRUSHER);
                        entries.add(ModBlocks.GENERATOR);

                        entries.add(ModBlocks.SLATED_DIRT);
                        entries.add(ModBlocks.SLATED_GRASS);
                        entries.add(ModBlocks.DIRITIA_PLANT);
                        entries.add(ModBlocks.DIRITIA_LIGHT_PLANT);
                        entries.add(ModItems.DIRITIA_HOSTILE_SPAWN_EGG);

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
                        entries.add(ModBlocks.CORPORATE_ALTAR);
                    }).build());
    public static void registerItemGroups() {
        PigsNStuff.LOGGER.info("Registering Item Groups for " + PigsNStuff.MOD_ID);
    }
}
