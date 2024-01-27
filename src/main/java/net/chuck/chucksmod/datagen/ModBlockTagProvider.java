package net.chuck.chucksmod.datagen;

import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
                .addTag(ModBlockTags.DIRITONIUM_ORES)
                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK)
                .add(ModBlocks.DIRITONIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FABIUM_BLOCK)
                .add(ModBlocks.RAW_FABIUM_BLOCK)
                .addTag(ModBlockTags.FABIUM_ORES)
                .add(ModBlocks.FABIUM_PORTAL_BLOCK)
                .add(ModBlocks.FABIUM_PORTAL_BUILDER)

                .add(ModBlocks.DIRITONIUM_BARS)

                .addTag(ModBlockTags.HARDENED_GLASS)
                .addTag(ModBlockTags.HARDENED_GLASS_PANES)
                .add(ModBlocks.HARDENED_TINTED_GLASS);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GOLD_BARS)

                .add(ModBlocks.TITANIUM_BLOCK)
                .add(ModBlocks.RAW_TITANIUM_BLOCK)
                .add(ModBlocks.TITANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE)
                .add(ModBlocks.NETHER_TITANIUM_ORE)
                .add(ModBlocks.END_STONE_TITANIUM_ORE)
                .add(ModBlocks.TITANIUM_BARS)

                .add(ModBlocks.TITANIUM_MACHINE_BASE)
                .add(ModBlocks.TITANIUM_HEAT_GENERATOR)
                .add(ModBlocks.TITANIUM_POWERED_CRUSHER)
                .add(ModBlocks.TITANIUM_POWERED_FURNACE)
                .add(ModBlocks.TITANIUM_ENERGY_STORAGE)
                .add(ModBlocks.TITANIUM_QUARRY)
                .add(ModBlocks.TITANIUM_COPIER)
                .add(ModBlocks.TITANIUM_FLUID_TANK)
                .add(ModBlocks.TITANIUM_PUMP)
                .add(ModBlocks.TITANIUM_FLUID_PIPE)
                .add(ModBlocks.TITANIUM_STEAM_GENERATOR)
                .add(ModBlocks.TITANIUM_LAVA_GENERATOR)
                .add(ModBlocks.ECLOGITE)
                .add(ModBlocks.ECLOGITE_STAIRS)
                .add(ModBlocks.ECLOGITE_SLAB)
                .add(ModBlocks.ECLOGITE_WALL)
                .add(ModBlocks.ECLOGITE_BRICKS)
                .add(ModBlocks.ECLOGITE_BRICK_STAIRS)
                .add(ModBlocks.ECLOGITE_BRICK_SLAB)
                .add(ModBlocks.ECLOGITE_BRICK_WALL)
                .add(ModBlocks.CRACKED_ECLOGITE_BRICKS)
                .add(ModBlocks.SERPENTINITE)
                .add(ModBlocks.SERPENTINITE_STAIRS)
                .add(ModBlocks.SERPENTINITE_SLAB)
                .add(ModBlocks.SERPENTINITE_WALL)
                .add(ModBlocks.SERPENTINITE_BRICKS)
                .add(ModBlocks.SERPENTINITE_BRICK_STAIRS)
                .add(ModBlocks.SERPENTINITE_BRICK_SLAB)
                .add(ModBlocks.SERPENTINITE_BRICK_WALL)
                .add(ModBlocks.CRACKED_SERPENTINITE_BRICKS)
                .add(ModBlocks.POLISHED_SERPENTINITE)
                .add(ModBlocks.POLISHED_SERPENTINITE_STAIRS)
                .add(ModBlocks.POLISHED_SERPENTINITE_SLAB)
                .add(ModBlocks.POLISHED_SERPENTINITE_WALL);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.TIN_BARS)
                .addTag(ModBlockTags.BRONZE_BLOCKS)
                .add(ModBlocks.BRONZE_BARS)
                .add(ModBlocks.CRUSHER)

                .add(ModBlocks.IRON_MACHINE_BASE)
                .add(ModBlocks.IRON_HEAT_GENERATOR)
                .add(ModBlocks.IRON_POWERED_CRUSHER)
                .add(ModBlocks.IRON_POWERED_FURNACE)
                .add(ModBlocks.IRON_ENERGY_STORAGE)
                .add(ModBlocks.IRON_QUARRY)
                .add(ModBlocks.IRON_FLUID_TANK)
                .add(ModBlocks.IRON_PUMP)
                .add(ModBlocks.IRON_STEAM_GENERATOR)
                .add(ModBlocks.IRON_FLUID_PIPE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(ModBlockTags.BARS)
                .addTag(ModBlockTags.WIRES)
                .addTag(ModBlockTags.TIN_ORES)
                .addTag(ModBlockTags.TIN_BLOCKS)
                .addTag(ModBlockTags.RAW_TIN_BLOCKS)
                .addTag(ModBlockTags.TITANIUM_ORES)
                .addTag(ModBlockTags.TITANIUM_BLOCKS)
                .addTag(ModBlockTags.RAW_TITANIUM_BLOCKS)

                .add(ModBlocks.CRUSHER)

                .add(ModBlocks.IRON_MACHINE_BASE)
                .add(ModBlocks.IRON_HEAT_GENERATOR)
                .add(ModBlocks.IRON_POWERED_CRUSHER)
                .add(ModBlocks.IRON_POWERED_FURNACE)
                .add(ModBlocks.IRON_ENERGY_STORAGE)
                .add(ModBlocks.IRON_QUARRY)
                .add(ModBlocks.IRON_FLUID_TANK)
                .add(ModBlocks.IRON_PUMP)
                .add(ModBlocks.IRON_FLUID_PIPE)
                .add(ModBlocks.IRON_STEAM_GENERATOR)

                .add(ModBlocks.SANDSTONE_BRICKS)
                .add(ModBlocks.SANDSTONE_BRICK_STAIRS)
                .add(ModBlocks.SANDSTONE_BRICK_SLAB)
                .add(ModBlocks.SANDSTONE_BRICK_WALL)
                .add(ModBlocks.CRACKED_SANDSTONE_BRICKS)

                .add(ModBlocks.TITANIUM_MACHINE_BASE)
                .add(ModBlocks.TITANIUM_HEAT_GENERATOR)
                .add(ModBlocks.TITANIUM_POWERED_CRUSHER)
                .add(ModBlocks.TITANIUM_POWERED_FURNACE)
                .add(ModBlocks.TITANIUM_ENERGY_STORAGE)
                .add(ModBlocks.TITANIUM_QUARRY)
                .add(ModBlocks.TITANIUM_COPIER)
                .add(ModBlocks.TITANIUM_FLUID_TANK)
                .add(ModBlocks.TITANIUM_PUMP)
                .add(ModBlocks.TITANIUM_FLUID_PIPE)
                .add(ModBlocks.TITANIUM_STEAM_GENERATOR)
                .add(ModBlocks.TITANIUM_LAVA_GENERATOR)

                .add(ModBlocks.SOUL_STONE)
                .add(ModBlocks.SOUL_STONE_STAIRS)
                .add(ModBlocks.SOUL_STONE_SLAB)
                .add(ModBlocks.SOUL_STONE_BRICKS)
                .add(ModBlocks.SOUL_STONE_BRICK_STAIRS)
                .add(ModBlocks.SOUL_STONE_BRICK_SLAB)
                .add(ModBlocks.SOUL_STONE_BRICK_WALL)
                .add(ModBlocks.CRACKED_SOUL_STONE_BRICKS)

                .add(ModBlocks.ECLOGITE)
                .add(ModBlocks.ECLOGITE_STAIRS)
                .add(ModBlocks.ECLOGITE_SLAB)
                .add(ModBlocks.ECLOGITE_WALL)
                .add(ModBlocks.ECLOGITE_BRICKS)
                .add(ModBlocks.ECLOGITE_BRICK_STAIRS)
                .add(ModBlocks.ECLOGITE_BRICK_SLAB)
                .add(ModBlocks.ECLOGITE_BRICK_WALL)
                .add(ModBlocks.CRACKED_ECLOGITE_BRICKS)

                .add(ModBlocks.SERPENTINITE)
                .add(ModBlocks.SERPENTINITE_STAIRS)
                .add(ModBlocks.SERPENTINITE_SLAB)
                .add(ModBlocks.SERPENTINITE_WALL)
                .add(ModBlocks.SERPENTINITE_BRICKS)
                .add(ModBlocks.SERPENTINITE_BRICK_STAIRS)
                .add(ModBlocks.SERPENTINITE_BRICK_SLAB)
                .add(ModBlocks.SERPENTINITE_BRICK_WALL)
                .add(ModBlocks.CRACKED_SERPENTINITE_BRICKS)
                .add(ModBlocks.POLISHED_SERPENTINITE)
                .add(ModBlocks.POLISHED_SERPENTINITE_STAIRS)
                .add(ModBlocks.POLISHED_SERPENTINITE_SLAB)
                .add(ModBlocks.POLISHED_SERPENTINITE_WALL)

                .addTag(ModBlockTags.FABIUM_ORES)
                .add(ModBlocks.RAW_FABIUM_BLOCK)
                .add(ModBlocks.FABIUM_BLOCK)
                .add(ModBlocks.FABIUM_PORTAL_BLOCK)
                .add(ModBlocks.FABIUM_PORTAL_BUILDER)

                .addTag(ModBlockTags.BRONZE_BLOCKS)

                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK)
                .addTag(ModBlockTags.DIRITONIUM_ORES)

                .addTag(ModBlockTags.HARDENED_GLASS)
                .add(ModBlocks.HARDENED_TINTED_GLASS)
                .addTag(ModBlockTags.HARDENED_GLASS_PANES);


        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .addTag(ModBlockTags.DUST_BLOCKS)
                .add(ModBlocks.OBSIDIAN_SAND);

        getOrCreateTagBuilder(ModBlockTags.DUST_BLOCKS)
                .add(ModBlocks.IRON_DUST_BLOCK)
                .add(ModBlocks.COPPER_DUST_BLOCK)
                .add(ModBlocks.GOLD_DUST_BLOCK)
                .add(ModBlocks.PRISMARINE_DUST_BLOCK)
                .add(ModBlocks.PRISMARINE_IRON_DUST_BLOCK)
                .add(ModBlocks.TIN_DUST_BLOCK)
                .add(ModBlocks.BRONZE_DUST_BLOCK)
                .add(ModBlocks.TITANIUM_DUST_BLOCK)
                .add(ModBlocks.SOUL_GRAVEL);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.EUCALYPTUS_PLANKS)
                .add(ModBlocks.DIRITIA_PLANKS)
                .add(ModBlocks.FABIA_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.EUCALYPTUS_BUTTON)
                .add(ModBlocks.FABIA_BUTTON)
                .add(ModBlocks.DIRITIA_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.EUCALYPTUS_DOOR)
                .add(ModBlocks.DIRITIA_DOOR)
                .add(ModBlocks.FABIA_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.EUCALYPTUS_FENCE)
                .add(ModBlocks.FABIA_FENCE)
                .add(ModBlocks.DIRITIA_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.EUCALYPTUS_SLAB)
                .add(ModBlocks.DIRITIA_SLAB)
                .add(ModBlocks.FABIA_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.EUCALYPTUS_STAIRS)
                .add(ModBlocks.DIRITIA_STAIRS)
                .add(ModBlocks.FABIA_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EUCALYPTUS_PRESSURE_PLATE)
                .add(ModBlocks.DIRITIA_PRESSURE_PLATE)
                .add(ModBlocks.FABIA_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EUCALYPTUS_TRAPDOOR)
                .add(ModBlocks.DIRITIA_TRAPDOOR)
                .add(ModBlocks.FABIA_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.EUCALYPTUS_FENCE_GATE)
                .add(ModBlocks.DIRITIA_FENCE_GATE)
                .add(ModBlocks.FABIA_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.END_STONE_DIRITONIUM_ORE)
                .add(ModBlocks.DEEPSLATE_DIRITONIUM_ORE)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK)
                .add(Blocks.ANCIENT_DEBRIS);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(ModBlockTags.EUCALYPTUS_LOGS)
                .addTag(ModBlockTags.DIRITIA_LOGS)
                .addTag(ModBlockTags.FABIA_LOGS);

        getOrCreateTagBuilder(ModBlockTags.EUCALYPTUS_LOGS)
                .add(ModBlocks.EUCALYPTUS_LOG)
                .add(ModBlocks.EUCALYPTUS_WOOD)
                .add(ModBlocks.STRIPPED_EUCALYPTUS_LOG)
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);

        getOrCreateTagBuilder(ModBlockTags.DIRITIA_LOGS)
                .add(ModBlocks.DIRITIA_LOG)
                .add(ModBlocks.DIRITIA_WOOD)
                .add(ModBlocks.STRIPPED_DIRITIA_LOG)
                .add(ModBlocks.STRIPPED_DIRITIA_WOOD);

        getOrCreateTagBuilder(ModBlockTags.FABIA_LOGS)
                .add(ModBlocks.FABIA_LOG)
                .add(ModBlocks.FABIA_WOOD)
                .add(ModBlocks.STRIPPED_FABIA_LOG)
                .add(ModBlocks.STRIPPED_FABIA_WOOD);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SANDSTONE_BRICK_WALL);

        getOrCreateTagBuilder(ModBlockTags.HARDENED_GLASS)
                .add(ModBlocks.HARDENED_GLASS)
                .add(ModBlocks.HARDENED_BLACK_GLASS)
                .add(ModBlocks.HARDENED_BLUE_GLASS)
                .add(ModBlocks.HARDENED_BROWN_GLASS)
                .add(ModBlocks.HARDENED_CYAN_GLASS)
                .add(ModBlocks.HARDENED_GRAY_GLASS)
                .add(ModBlocks.HARDENED_GREEN_GLASS)
                .add(ModBlocks.HARDENED_LIGHT_BLUE_GLASS)
                .add(ModBlocks.HARDENED_LIGHT_GRAY_GLASS)
                .add(ModBlocks.HARDENED_LIME_GLASS)
                .add(ModBlocks.HARDENED_MAGENTA_GLASS)
                .add(ModBlocks.HARDENED_ORANGE_GLASS)
                .add(ModBlocks.HARDENED_PINK_GLASS)
                .add(ModBlocks.HARDENED_PURPLE_GLASS)
                .add(ModBlocks.HARDENED_RED_GLASS)
                .add(ModBlocks.HARDENED_WHITE_GLASS)
                .add(ModBlocks.HARDENED_YELLOW_GLASS);

        getOrCreateTagBuilder(ModBlockTags.HARDENED_GLASS_PANES)
                .add(ModBlocks.HARDENED_GLASS_PANE)
                .add(ModBlocks.HARDENED_BLACK_GLASS_PANE)
                .add(ModBlocks.HARDENED_BLUE_GLASS_PANE)
                .add(ModBlocks.HARDENED_BROWN_GLASS_PANE)
                .add(ModBlocks.HARDENED_CYAN_GLASS_PANE)
                .add(ModBlocks.HARDENED_GRAY_GLASS_PANE)
                .add(ModBlocks.HARDENED_GREEN_GLASS_PANE)
                .add(ModBlocks.HARDENED_LIGHT_BLUE_GLASS_PANE)
                .add(ModBlocks.HARDENED_LIGHT_GRAY_GLASS_PANE)
                .add(ModBlocks.HARDENED_LIME_GLASS_PANE)
                .add(ModBlocks.HARDENED_MAGENTA_GLASS_PANE)
                .add(ModBlocks.HARDENED_ORANGE_GLASS_PANE)
                .add(ModBlocks.HARDENED_PINK_GLASS_PANE)
                .add(ModBlocks.HARDENED_PURPLE_GLASS_PANE)
                .add(ModBlocks.HARDENED_RED_GLASS_PANE)
                .add(ModBlocks.HARDENED_WHITE_GLASS_PANE)
                .add(ModBlocks.HARDENED_YELLOW_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.TIN_ORES)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE);

        getOrCreateTagBuilder(ModBlockTags.TIN_BLOCKS)
                .add(ModBlocks.TIN_BLOCK);

        getOrCreateTagBuilder(ModBlockTags.RAW_TIN_BLOCKS)
                .add(ModBlocks.RAW_TIN_BLOCK);

        getOrCreateTagBuilder(ModBlockTags.BRONZE_BLOCKS)
                .add(ModBlocks.BRONZE_BLOCK);
        
        getOrCreateTagBuilder(ModBlockTags.TITANIUM_ORES)
                .add(ModBlocks.TITANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE)
                .add(ModBlocks.NETHER_TITANIUM_ORE)
                .add(ModBlocks.END_STONE_TITANIUM_ORE);

        getOrCreateTagBuilder(ModBlockTags.TITANIUM_BLOCKS)
                .add(ModBlocks.TITANIUM_BLOCK);

        getOrCreateTagBuilder(ModBlockTags.RAW_TITANIUM_BLOCKS)
                .add(ModBlocks.RAW_TITANIUM_BLOCK);

        getOrCreateTagBuilder(ModBlockTags.WIRES)
                .add(ModBlocks.TIN_WIRE)
                .add(ModBlocks.COPPER_WIRE)
                .add(ModBlocks.GOLD_WIRE);

        getOrCreateTagBuilder(ModBlockTags.BARS)
                .add(Blocks.IRON_BARS)
                .add(ModBlocks.TITANIUM_BARS)
                .add(ModBlocks.BRONZE_BARS)
                .add(ModBlocks.COPPER_BARS)
                .add(ModBlocks.GOLD_BARS)
                .add(ModBlocks.TIN_BARS)
                .add(ModBlocks.FABIUM_BARS)
                .add(ModBlocks.DIRITONIUM_BARS)
                .add(ModBlocks.PRISMARINE_BARS);

        getOrCreateTagBuilder(ModBlockTags.FABIUM_ORES)
                .add(ModBlocks.NETHER_FABIUM_ORE)
                .add(ModBlocks.END_STONE_FABIUM_ORE)
                .add(ModBlocks.DEEPSLATE_FABIUM_ORE);

        getOrCreateTagBuilder(ModBlockTags.DIRITONIUM_ORES)
                .add(ModBlocks.END_STONE_DIRITONIUM_ORE)
                .add(ModBlocks.DEEPSLATE_DIRITONIUM_ORE);

        getOrCreateTagBuilder(ModBlockTags.CRUSHERS)
                .add(ModBlocks.CRUSHER)
                .add(ModBlocks.IRON_POWERED_CRUSHER);

        getOrCreateTagBuilder(ModBlockTags.GENERATORS)
                .add(ModBlocks.IRON_HEAT_GENERATOR)
                .add(ModBlocks.TITANIUM_HEAT_GENERATOR);

        getOrCreateTagBuilder(ModBlockTags.MACHINE_BASES)
                .add(ModBlocks.IRON_MACHINE_BASE)
                .add(ModBlocks.TITANIUM_MACHINE_BASE);

        getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModBlocks.SOUL_GRAVEL)
                .add(ModBlocks.SOUL_STONE)
                .add(ModBlocks.SOUL_STONE_SLAB)
                .add(ModBlocks.SOUL_STONE_STAIRS)
                .add(ModBlocks.SOUL_STONE_BRICKS)
                .add(ModBlocks.SOUL_STONE_BRICK_SLAB)
                .add(ModBlocks.SOUL_STONE_BRICK_STAIRS)
                .add(ModBlocks.SOUL_STONE_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE)
                .add(ModBlocks.FRANK_ALTAR)
                .add(ModBlocks.SOUL_BLAZE_ALTAR);
    }
}
