package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItemTags;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BRONZE_HELMET)
                .add(ModItems.BRONZE_CHESTPLATE)
                .add(ModItems.BRONZE_LEGGINGS)
                .add(ModItems.BRONZE_BOOTS)
                .add(ModItems.PRISMARINE_HELMET)
                .add(ModItems.PRISMARINE_CHESTPLATE)
                .add(ModItems.PRISMARINE_LEGGINGS)
                .add(ModItems.PRISMARINE_BOOTS)
                .add(ModItems.FABIUM_HELMET)
                .add(ModItems.FABIUM_CHESTPLATE)
                .add(ModItems.FABIUM_LEGGINGS)
                .add(ModItems.FABIUM_BOOTS)
                .add(ModItems.DIRITONIUM_HELMET)
                .add(ModItems.DIRITONIUM_CHESTPLATE)
                .add(ModItems.DIRITONIUM_LEGGINGS)
                .add(ModItems.DIRITONIUM_BOOTS);

        getOrCreateTagBuilder(ModItemTags.COOKED_MEAT)
                .add(Items.COOKED_BEEF)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.COOKED_CHICKEN)
                .add(Items.COOKED_RABBIT)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON)
                .add(Items.COOKED_MUTTON);

        getOrCreateTagBuilder(ModItemTags.RAW_MEAT)
                .add(Items.BEEF)
                .add(Items.PORKCHOP)
                .add(Items.CHICKEN)
                .add(Items.RABBIT)
                .add(Items.COD)
                .add(Items.SALMON)
                .add(Items.MUTTON);

        getOrCreateTagBuilder(ModItemTags.SEEDS)
                .add(Items.WHEAT_SEEDS)
                .add(Items.BEETROOT_SEEDS)
                .add(Items.MELON_SEEDS)
                .add(Items.PUMPKIN_SEEDS)
                .add(ModItems.TOMATO_SEEDS)
                .add(ModItems.LETTUCE_SEEDS)
                .add(ModItems.PINEAPPLE_SEEDS);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BRONZE_SWORD)
                .add(ModItems.FABIUM_SWORD)
                .add(ModItems.WITHER_SWORD)
                .add(ModItems.PRISMARINE_SWORD)
                .add(ModItems.DIRITONIUM_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BRONZE_PICKAXE)
                .add(ModItems.FABIUM_PICKAXE)
                .add(ModItems.WITHER_PICKAXE)
                .add(ModItems.PRISMARINE_PICKAXE)
                .add(ModItems.DIRITONIUM_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BRONZE_AXE)
                .add(ModItems.FABIUM_AXE)
                .add(ModItems.WITHER_AXE)
                .add(ModItems.PRISMARINE_AXE)
                .add(ModItems.DIRITONIUM_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BRONZE_SHOVEL)
                .add(ModItems.FABIUM_SHOVEL)
                .add(ModItems.WITHER_SHOVEL)
                .add(ModItems.PRISMARINE_SHOVEL)
                .add(ModItems.DIRITONIUM_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BRONZE_HOE)
                .add(ModItems.FABIUM_HOE)
                .add(ModItems.WITHER_HOE)
                .add(ModItems.PRISMARINE_HOE)
                .add(ModItems.DIRITONIUM_HOE);

        getOrCreateTagBuilder(ModItemTags.TIN_INGOTS)
                .add(ModItems.TIN_INGOT);

        getOrCreateTagBuilder(ModItemTags.BRONZE_INGOTS)
                .add(ModItems.BRONZE_INGOT);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.EUCALYPTUS_PLANKS.asItem())
                .add(ModBlocks.DIRITIA_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.EUCALYPTUS_BUTTON.asItem())
                .add(ModBlocks.DIRITIA_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.EUCALYPTUS_DOOR.asItem())
                .add(ModBlocks.DIRITIA_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.EUCALYPTUS_FENCE.asItem())
                .add(ModBlocks.DIRITIA_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.EUCALYPTUS_SLAB.asItem())
                .add(ModBlocks.DIRITIA_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.EUCALYPTUS_STAIRS.asItem())
                .add(ModBlocks.DIRITIA_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EUCALYPTUS_PRESSURE_PLATE.asItem())
                .add(ModBlocks.DIRITIA_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EUCALYPTUS_TRAPDOOR.asItem())
                .add(ModBlocks.DIRITIA_TRAPDOOR.asItem());

        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.EUCALYPTUS_FENCE_GATE.asItem())
                .add(ModBlocks.DIRITIA_FENCE_GATE.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.EUCALYPTUS_LOG.asItem())
                .add(ModBlocks.EUCALYPTUS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_LOG.asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.asItem())
                .add(ModBlocks.DIRITIA_LOG.asItem())
                .add(ModBlocks.DIRITIA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DIRITIA_LOG.asItem())
                .add(ModBlocks.STRIPPED_DIRITIA_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBlocks.SANDSTONE_BRICK_WALL.asItem());

        getOrCreateTagBuilder(ModItemTags.DUSTS)
                .add(ModItems.BRONZE_DUST)
                .add(ModItems.IRON_DUST)
                .add(ModItems.COPPER_DUST)
                .add(ModItems.TIN_DUST)
                .add(ModItems.GOLD_DUST)
                .add(ModItems.OBSIDIAN_DUST)
                .add(ModItems.PRISMARINE_DUST)
                .add(ModItems.PRISMARINE_IRON_DUST);
    }
}
