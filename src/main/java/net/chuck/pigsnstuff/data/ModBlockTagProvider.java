package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,
                new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.END_STONE_DIRITONIUM_ORE)
                .add(ModBlocks.DEEPSLATE_DIRITONIUM_ORE)
                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FABIUM_BLOCK)
                .add(ModBlocks.RAW_FABIUM_BLOCK)
                .add(ModBlocks.NETHER_FABIUM_ORE)
                .add(ModBlocks.END_STONE_FABIUM_ORE)
                .add(ModBlocks.DEEPSLATE_FABIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CRUSHER)
                .add(ModBlocks.SLATED_DIRT)
                .add(ModBlocks.SLATED_GRASS);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.BRONZE_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.NETHER_FABIUM_ORE)
                .add(ModBlocks.END_STONE_FABIUM_ORE)
                .add(ModBlocks.DEEPSLATE_FABIUM_ORE)
                .add(ModBlocks.RAW_FABIUM_BLOCK)
                .add(ModBlocks.FABIUM_BLOCK)

                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)

                .add(ModBlocks.BRONZE_BLOCK)

                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK)
                .add(ModBlocks.END_STONE_DIRITONIUM_ORE)
                .add(ModBlocks.DEEPSLATE_DIRITONIUM_ORE)

                .add(ModBlocks.CRUSHER);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.IRON_DUST_BLOCK)
                .add(ModBlocks.COPPER_DUST_BLOCK)
                .add(ModBlocks.GOLD_DUST_BLOCK)
                .add(ModBlocks.PRISMARINE_DUST_BLOCK)
                .add(ModBlocks.PRISMARINE_IRON_DUST_BLOCK)
                .add(ModBlocks.TIN_DUST_BLOCK)
                .add(ModBlocks.BRONZE_DUST_BLOCK)
                .add(ModBlocks.SLATED_GRASS)
                .add(ModBlocks.SLATED_DIRT);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.EUCALYPTUS_PLANKS)
                .add(ModBlocks.DIRITIA_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.EUCALYPTUS_BUTTON)
                .add(ModBlocks.DIRITIA_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.EUCALYPTUS_DOOR)
                .add(ModBlocks.DIRITIA_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.EUCALYPTUS_FENCE)
                .add(ModBlocks.DIRITIA_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.EUCALYPTUS_SLAB)
                .add(ModBlocks.DIRITIA_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.EUCALYPTUS_STAIRS)
                .add(ModBlocks.DIRITIA_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EUCALYPTUS_PRESSURE_PLATE)
                .add(ModBlocks.DIRITIA_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EUCALYPTUS_TRAPDOOR)
                .add(ModBlocks.DIRITIA_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.EUCALYPTUS_FENCE_GATE)
                .add(ModBlocks.DIRITIA_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.SLATED_DIRT)
                .add(ModBlocks.SLATED_GRASS);

        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.END_STONE_DIRITONIUM_ORE)
                .add(ModBlocks.DEEPSLATE_DIRITONIUM_ORE)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.EUCALYPTUS_LOG)
                .add(ModBlocks.EUCALYPTUS_WOOD)
                .add(ModBlocks.STRIPPED_EUCALYPTUS_LOG)
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD)
                .add(ModBlocks.DIRITIA_LOG)
                .add(ModBlocks.DIRITIA_WOOD)
                .add(ModBlocks.STRIPPED_DIRITIA_LOG)
                .add(ModBlocks.STRIPPED_DIRITIA_WOOD);
    }
}