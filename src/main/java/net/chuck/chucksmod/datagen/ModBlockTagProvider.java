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
                .addTag(ModBlockTags.PACSARIUM_ORES)
                .add(ModBlocks.RAW_PACSARIUM_BLOCK)
                .add(ModBlocks.PACSARIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(ModBlockTags.TRIAFIUM_TIER)
                .add(ModBlocks.TRIAFIUM_BLOCK)
                .add(ModBlocks.RAW_TRIAFIUM_BLOCK)
                .addTag(ModBlockTags.TRIAFIUM_ORES)
                .add(ModBlocks.TRIAFIUM_DUST_BLOCK)
                .add(ModBlocks.TRIAFIUM_PORTAL_BLOCK)
                .add(ModBlocks.TRIAFIUM_PORTAL_BUILDER)

                .add(ModBlocks.PACSARIUM_BARS)

                .addTag(ModBlockTags.HARDENED_GLASS)
                .addTag(ModBlockTags.HARDENED_GLASS_PANES)
                .add(ModBlocks.HARDENED_TINTED_GLASS);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .addTag(ModBlockTags.TITANIUM_TIER)
                .add(ModBlocks.GOLD_BARS)
                .add(ModBlocks.SERPENTINITE_GOLD_ORE)
                .add(ModBlocks.SERPENTINITE_DIAMOND_ORE)
                .add(ModBlocks.SERPENTINITE_EMERALD_ORE)
                .add(ModBlocks.SERPENTINITE_REDSTONE_ORE)

                .add(ModBlocks.TITANIUM_BLOCK)
                .add(ModBlocks.RAW_TITANIUM_BLOCK)
                .add(ModBlocks.TITANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE)
                .add(ModBlocks.NETHER_TITANIUM_ORE)
                .add(ModBlocks.END_STONE_TITANIUM_ORE)
                .add(ModBlocks.TITANIUM_BARS)
                .add(ModBlocks.SERPENTINITE_TITANIUM_ORE)

                .add(ModBlocks.ECLOGITE)
                .add(ModBlocks.ECLOGITE_STAIRS)
                .add(ModBlocks.ECLOGITE_SLAB)
                .add(ModBlocks.ECLOGITE_WALL)
                .add(ModBlocks.ECLOGITE_BRICKS)
                .add(ModBlocks.ECLOGITE_BRICK_STAIRS)
                .add(ModBlocks.ECLOGITE_BRICK_SLAB)
                .add(ModBlocks.ECLOGITE_BRICK_WALL)
                .add(ModBlocks.CRACKED_ECLOGITE_BRICKS)
                .add(ModBlocks.POLISHED_ECLOGITE)
                .add(ModBlocks.POLISHED_ECLOGITE_STAIRS)
                .add(ModBlocks.POLISHED_ECLOGITE_SLAB)
                .add(ModBlocks.POLISHED_ECLOGITE_WALL)
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
                .add(ModBlocks.GLAUCONITE)
                .add(ModBlocks.GLAUCONITE_STAIRS)
                .add(ModBlocks.GLAUCONITE_SLAB)
                .add(ModBlocks.GLAUCONITE_WALL)
                .add(ModBlocks.GLAUCONITE_BRICKS)
                .add(ModBlocks.GLAUCONITE_BRICK_STAIRS)
                .add(ModBlocks.GLAUCONITE_BRICK_SLAB)
                .add(ModBlocks.GLAUCONITE_BRICK_WALL)
                .add(ModBlocks.CRACKED_GLAUCONITE_BRICKS)
                .add(ModBlocks.POLISHED_GLAUCONITE)
                .add(ModBlocks.POLISHED_GLAUCONITE_STAIRS)
                .add(ModBlocks.POLISHED_GLAUCONITE_SLAB)
                .add(ModBlocks.POLISHED_GLAUCONITE_WALL);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .addTag(ModBlockTags.IRON_TIER)
                .add(ModBlocks.IRON_EXPERIENCE_DRAIN)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.SERPENTINITE_TIN_ORE)
                .add(ModBlocks.SERPENTINITE_IRON_ORE)
                .add(ModBlocks.SERPENTINITE_COPPER_ORE)
                .add(ModBlocks.SERPENTINITE_LAPIS_ORE)
                .add(ModBlocks.TIN_BARS)
                .addTag(ModBlockTags.BRONZE_BLOCKS)
                .add(ModBlocks.BRONZE_BARS)
                .add(ModBlocks.CRUSHER);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(ModBlockTags.QUARTZ_ORES)
                .addTag(ModBlockTags.BARS)
                .addTag(ModBlockTags.WIRES)
                .addTag(ModBlockTags.TIN_ORES)
                .addTag(ModBlockTags.TIN_BLOCKS)
                .addTag(ModBlockTags.RAW_TIN_BLOCKS)
                .addTag(ModBlockTags.TITANIUM_ORES)
                .addTag(ModBlockTags.TITANIUM_BLOCKS)
                .addTag(ModBlockTags.RAW_TITANIUM_BLOCKS)
                .addTag(ModBlockTags.MACHINES)
                .addTag(ModBlockTags.EXPERIENCE_DRAINS)

                .add(ModBlocks.CRUSHER)

                .add(ModBlocks.SANDSTONE_BRICKS)
                .add(ModBlocks.SANDSTONE_BRICK_STAIRS)
                .add(ModBlocks.SANDSTONE_BRICK_SLAB)
                .add(ModBlocks.SANDSTONE_BRICK_WALL)
                .add(ModBlocks.CRACKED_SANDSTONE_BRICKS)

                .add(ModBlocks.SOUL_STONE)
                .add(ModBlocks.SOUL_STONE_STAIRS)
                .add(ModBlocks.SOUL_STONE_SLAB)
                .add(ModBlocks.SOUL_STONE_BRICKS)
                .add(ModBlocks.SOUL_STONE_BRICK_STAIRS)
                .add(ModBlocks.SOUL_STONE_BRICK_SLAB)
                .add(ModBlocks.SOUL_STONE_BRICK_WALL)
                .add(ModBlocks.CRACKED_SOUL_STONE_BRICKS)
                
                .add(ModBlocks.TUFF_STAIRS)
                .add(ModBlocks.TUFF_SLAB)
                .add(ModBlocks.TUFF_WALL)

                .addTag(ModBlockTags.CONCRETE_SLABS)
                .addTag(ModBlockTags.CONCRETE_STAIRS)
                .addTag(ModBlockTags.CONCRETE_WALLS)

                .add(ModBlocks.ECLOGITE)
                .add(ModBlocks.ECLOGITE_STAIRS)
                .add(ModBlocks.ECLOGITE_SLAB)
                .add(ModBlocks.ECLOGITE_WALL)
                .add(ModBlocks.ECLOGITE_BRICKS)
                .add(ModBlocks.ECLOGITE_BRICK_STAIRS)
                .add(ModBlocks.ECLOGITE_BRICK_SLAB)
                .add(ModBlocks.ECLOGITE_BRICK_WALL)
                .add(ModBlocks.CRACKED_ECLOGITE_BRICKS)
                .add(ModBlocks.POLISHED_ECLOGITE)
                .add(ModBlocks.POLISHED_ECLOGITE_STAIRS)
                .add(ModBlocks.POLISHED_ECLOGITE_SLAB)
                .add(ModBlocks.POLISHED_ECLOGITE_WALL)

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
                .add(ModBlocks.SERPENTINITE_COAL_ORE)
                .add(ModBlocks.SERPENTINITE_COPPER_ORE)
                .add(ModBlocks.SERPENTINITE_DIAMOND_ORE)
                .add(ModBlocks.SERPENTINITE_EMERALD_ORE)
                .add(ModBlocks.SERPENTINITE_GOLD_ORE)
                .add(ModBlocks.SERPENTINITE_IRON_ORE)
                .add(ModBlocks.SERPENTINITE_LAPIS_ORE)
                .add(ModBlocks.SERPENTINITE_REDSTONE_ORE)

                .add(ModBlocks.GLAUCONITE)
                .add(ModBlocks.GLAUCONITE_STAIRS)
                .add(ModBlocks.GLAUCONITE_SLAB)
                .add(ModBlocks.GLAUCONITE_WALL)
                .add(ModBlocks.GLAUCONITE_BRICKS)
                .add(ModBlocks.GLAUCONITE_BRICK_STAIRS)
                .add(ModBlocks.GLAUCONITE_BRICK_SLAB)
                .add(ModBlocks.GLAUCONITE_BRICK_WALL)
                .add(ModBlocks.CRACKED_GLAUCONITE_BRICKS)
                .add(ModBlocks.POLISHED_GLAUCONITE)
                .add(ModBlocks.POLISHED_GLAUCONITE_STAIRS)
                .add(ModBlocks.POLISHED_GLAUCONITE_SLAB)
                .add(ModBlocks.POLISHED_GLAUCONITE_WALL)

                .addTag(ModBlockTags.TRIAFIUM_ORES)
                .add(ModBlocks.RAW_TRIAFIUM_BLOCK)
                .add(ModBlocks.TRIAFIUM_BLOCK)
                .add(ModBlocks.TRIAFIUM_PORTAL_BLOCK)
                .add(ModBlocks.TRIAFIUM_PORTAL_BUILDER)

                .addTag(ModBlockTags.BRONZE_BLOCKS)

                .add(ModBlocks.PACSARIUM_BLOCK)
                .add(ModBlocks.RAW_PACSARIUM_BLOCK)
                .addTag(ModBlockTags.PACSARIUM_ORES)

                .addTag(ModBlockTags.HARDENED_GLASS)
                .add(ModBlocks.HARDENED_TINTED_GLASS)
                .addTag(ModBlockTags.HARDENED_GLASS_PANES);


        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .addTag(ModBlockTags.DUST_BLOCKS);

        getOrCreateTagBuilder(ModBlockTags.DUST_BLOCKS)
                .add(ModBlocks.COAL_DUST_BLOCK)
                .add(ModBlocks.IRON_DUST_BLOCK)
                .add(ModBlocks.COPPER_DUST_BLOCK)
                .add(ModBlocks.GOLD_DUST_BLOCK)
                .add(ModBlocks.PRISMARINE_DUST_BLOCK)
                .add(ModBlocks.PRISMARINE_IRON_DUST_BLOCK)
                .add(ModBlocks.TIN_DUST_BLOCK)
                .add(ModBlocks.BRONZE_DUST_BLOCK)
                .add(ModBlocks.TITANIUM_DUST_BLOCK)
                .add(ModBlocks.OBSIDIAN_SAND)
                .add(ModBlocks.SOUL_GRAVEL)
                .add(ModBlocks.TRIAFIUM_DUST_BLOCK);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.EUCALYPTUS_PLANKS)
                .add(ModBlocks.PACSARIA_PLANKS)
                .add(ModBlocks.TRIAFIA_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.EUCALYPTUS_BUTTON)
                .add(ModBlocks.TRIAFIA_BUTTON)
                .add(ModBlocks.PACSARIA_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.EUCALYPTUS_DOOR)
                .add(ModBlocks.PACSARIA_DOOR)
                .add(ModBlocks.TRIAFIA_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.EUCALYPTUS_FENCE)
                .add(ModBlocks.TRIAFIA_FENCE)
                .add(ModBlocks.PACSARIA_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.EUCALYPTUS_SLAB)
                .add(ModBlocks.PACSARIA_SLAB)
                .add(ModBlocks.TRIAFIA_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.EUCALYPTUS_STAIRS)
                .add(ModBlocks.PACSARIA_STAIRS)
                .add(ModBlocks.TRIAFIA_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EUCALYPTUS_PRESSURE_PLATE)
                .add(ModBlocks.PACSARIA_PRESSURE_PLATE)
                .add(ModBlocks.TRIAFIA_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EUCALYPTUS_TRAPDOOR)
                .add(ModBlocks.PACSARIA_TRAPDOOR)
                .add(ModBlocks.TRIAFIA_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.EUCALYPTUS_FENCE_GATE)
                .add(ModBlocks.PACSARIA_FENCE_GATE)
                .add(ModBlocks.TRIAFIA_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.PACSARIUM_BLOCK)
                .add(ModBlocks.END_STONE_PACSARIUM_ORE)
                .add(ModBlocks.DEEPSLATE_PACSARIUM_ORE)
                .add(ModBlocks.RAW_PACSARIUM_BLOCK)
                .add(Blocks.ANCIENT_DEBRIS);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(ModBlockTags.EUCALYPTUS_LOGS)
                .addTag(ModBlockTags.PACSARIA_LOGS)
                .addTag(ModBlockTags.TRIAFIA_LOGS);

        getOrCreateTagBuilder(ModBlockTags.EUCALYPTUS_LOGS)
                .add(ModBlocks.EUCALYPTUS_LOG)
                .add(ModBlocks.EUCALYPTUS_WOOD)
                .add(ModBlocks.STRIPPED_EUCALYPTUS_LOG)
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);

        getOrCreateTagBuilder(ModBlockTags.PACSARIA_LOGS)
                .add(ModBlocks.PACSARIA_LOG)
                .add(ModBlocks.PACSARIA_WOOD)
                .add(ModBlocks.STRIPPED_PACSARIA_LOG)
                .add(ModBlocks.STRIPPED_PACSARIA_WOOD);

        getOrCreateTagBuilder(ModBlockTags.TRIAFIA_LOGS)
                .add(ModBlocks.TRIAFIA_LOG)
                .add(ModBlocks.TRIAFIA_WOOD)
                .add(ModBlocks.STRIPPED_TRIAFIA_LOG)
                .add(ModBlocks.STRIPPED_TRIAFIA_WOOD);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .addTag(ModBlockTags.CONCRETE_WALLS)
                .add(ModBlocks.SANDSTONE_BRICK_WALL)
                .add(ModBlocks.TUFF_WALL)
                .add(ModBlocks.ECLOGITE_WALL)
                .add(ModBlocks.ECLOGITE_BRICK_WALL)
                .add(ModBlocks.POLISHED_ECLOGITE_WALL)
                .add(ModBlocks.SERPENTINITE_WALL)
                .add(ModBlocks.SERPENTINITE_BRICK_WALL)
                .add(ModBlocks.POLISHED_SERPENTINITE_WALL)
                .add(ModBlocks.GLAUCONITE_WALL)
                .add(ModBlocks.GLAUCONITE_BRICK_WALL)
                .add(ModBlocks.POLISHED_GLAUCONITE_WALL);

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
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.SERPENTINITE_TIN_ORE);

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
                .add(ModBlocks.END_STONE_TITANIUM_ORE)
                .add(ModBlocks.SERPENTINITE_TITANIUM_ORE);

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
                .add(ModBlocks.TRIAFIUM_BARS)
                .add(ModBlocks.PACSARIUM_BARS)
                .add(ModBlocks.PRISMARINE_BARS);

        getOrCreateTagBuilder(ModBlockTags.TRIAFIUM_ORES)
                .add(ModBlocks.NETHER_TRIAFIUM_ORE)
                .add(ModBlocks.END_STONE_TRIAFIUM_ORE)
                .add(ModBlocks.DEEPSLATE_TRIAFIUM_ORE)
                .add(ModBlocks.SERPENTINITE_TRIAFIUM_ORE);

        getOrCreateTagBuilder(ModBlockTags.PACSARIUM_ORES)
                .add(ModBlocks.END_STONE_PACSARIUM_ORE)
                .add(ModBlocks.DEEPSLATE_PACSARIUM_ORE)
                .add(ModBlocks.SERPENTINITE_PACSARIUM_ORE);

        getOrCreateTagBuilder(ModBlockTags.CRUSHERS)
                .add(ModBlocks.CRUSHER)
                .add(ModBlocks.IRON_POWERED_CRUSHER);

        getOrCreateTagBuilder(ModBlockTags.GENERATORS)
                .add(ModBlocks.IRON_HEAT_GENERATOR)
                .add(ModBlocks.TITANIUM_HEAT_GENERATOR)
                .add(ModBlocks.IRON_STEAM_GENERATOR)
                .add(ModBlocks.TITANIUM_STEAM_GENERATOR)
                .add(ModBlocks.TITANIUM_LAVA_GENERATOR);

        getOrCreateTagBuilder(ModBlockTags.MACHINE_BASES)
                .add(ModBlocks.IRON_MACHINE_BASE)
                .add(ModBlocks.TITANIUM_MACHINE_BASE);

        getOrCreateTagBuilder(ModBlockTags.TRIAFIA_BASE_STONE)
                .add(ModBlocks.SERPENTINITE)
                .add(ModBlocks.GLAUCONITE)
                .add(ModBlocks.ECLOGITE);

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

        getOrCreateTagBuilder(BlockTags.COAL_ORES)
                .add(ModBlocks.SERPENTINITE_COAL_ORE);

        getOrCreateTagBuilder(BlockTags.IRON_ORES)
                .add(ModBlocks.SERPENTINITE_IRON_ORE);

        getOrCreateTagBuilder(BlockTags.GOLD_ORES)
                .add(ModBlocks.SERPENTINITE_GOLD_ORE);

        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES)
                .add(ModBlocks.SERPENTINITE_DIAMOND_ORE);

        getOrCreateTagBuilder(BlockTags.EMERALD_ORES)
                .add(ModBlocks.SERPENTINITE_EMERALD_ORE);

        getOrCreateTagBuilder(BlockTags.LAPIS_ORES)
                .add(ModBlocks.SERPENTINITE_LAPIS_ORE);

        getOrCreateTagBuilder(BlockTags.COPPER_ORES)
                .add(ModBlocks.SERPENTINITE_COPPER_ORE);

        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES)
                .add(ModBlocks.SERPENTINITE_REDSTONE_ORE);

        getOrCreateTagBuilder(ModBlockTags.COPPER_PLANTABLE)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.CUT_COPPER)
                .add(Blocks.EXPOSED_COPPER)
                .add(Blocks.EXPOSED_CUT_COPPER)
                .add(Blocks.OXIDIZED_COPPER)
                .add(Blocks.OXIDIZED_CUT_COPPER)
                .add(Blocks.WEATHERED_COPPER)
                .add(Blocks.WEATHERED_CUT_COPPER)
                .add(Blocks.WAXED_COPPER_BLOCK)
                .add(Blocks.WAXED_CUT_COPPER)
                .add(Blocks.WAXED_EXPOSED_COPPER)
                .add(Blocks.WAXED_EXPOSED_CUT_COPPER)
                .add(Blocks.WAXED_OXIDIZED_COPPER)
                .add(Blocks.WAXED_OXIDIZED_CUT_COPPER)
                .add(Blocks.WAXED_WEATHERED_COPPER)
                .add(Blocks.WAXED_WEATHERED_CUT_COPPER);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TITANIUM_BLOCK)
                .add(ModBlocks.TRIAFIUM_BLOCK)
                .add(ModBlocks.PACSARIUM_BLOCK)
                .add(ModBlocks.BRONZE_BLOCK);
        
        getOrCreateTagBuilder(ModBlockTags.MACHINES)
                .addTag(ModBlockTags.IRON_TIER)
                .addTag(ModBlockTags.TITANIUM_TIER)
                .addTag(ModBlockTags.TRIAFIUM_TIER);
        
        getOrCreateTagBuilder(ModBlockTags.IRON_TIER)
                .add(ModBlocks.IRON_MACHINE_BASE)
                .add(ModBlocks.IRON_HEAT_GENERATOR)
                .add(ModBlocks.IRON_POWERED_CRUSHER)
                .add(ModBlocks.IRON_POWERED_FURNACE)
                .add(ModBlocks.IRON_ENERGY_STORAGE)
                .add(ModBlocks.IRON_HARVESTER)
                .add(ModBlocks.IRON_QUARRY)
                .add(ModBlocks.IRON_FLUID_TANK)
                .add(ModBlocks.IRON_PUMP)
                .add(ModBlocks.IRON_STEAM_GENERATOR)
                .add(ModBlocks.IRON_FLUID_PIPE);
        
        getOrCreateTagBuilder(ModBlockTags.TITANIUM_TIER)
                .add(ModBlocks.TITANIUM_MACHINE_BASE)
                .add(ModBlocks.TITANIUM_ENERGY_STORAGE)
                .add(ModBlocks.TITANIUM_POWERED_CRUSHER)
                .add(ModBlocks.TITANIUM_POWERED_FURNACE)
                .add(ModBlocks.TITANIUM_HEAT_GENERATOR)
                .add(ModBlocks.TITANIUM_PUMP)
                .add(ModBlocks.TITANIUM_FLUID_PIPE)
                .add(ModBlocks.TITANIUM_EXPERIENCE_DRAIN)
                .add(ModBlocks.TITANIUM_FLUID_TANK)
                .add(ModBlocks.TITANIUM_STEAM_GENERATOR)
                .add(ModBlocks.TITANIUM_HARVESTER)
                .add(ModBlocks.TITANIUM_QUARRY)
                .add(ModBlocks.TITANIUM_LAVA_GENERATOR)
                .add(ModBlocks.TITANIUM_COPIER)
                .add(ModBlocks.TITANIUM_CLEANSER);

        getOrCreateTagBuilder(ModBlockTags.TRIAFIUM_TIER)
                .add(ModBlocks.TRIAFIUM_ENERGY_STORAGE)
                .add(ModBlocks.TRIAFIUM_POWERED_CRUSHER)
                .add(ModBlocks.TRIAFIUM_POWERED_FURNACE)
                .add(ModBlocks.TRIAFIUM_HEAT_GENERATOR)
                .add(ModBlocks.TRIAFIUM_PUMP)
                .add(ModBlocks.TRIAFIUM_FLUID_PIPE)
                .add(ModBlocks.TRIAFIUM_EXPERIENCE_DRAIN)
                .add(ModBlocks.TRIAFIUM_FLUID_TANK)
                .add(ModBlocks.TRIAFIUM_STEAM_GENERATOR)
                .add(ModBlocks.TRIAFIUM_HARVESTER)
                .add(ModBlocks.TRIAFIUM_QUARRY)
                .add(ModBlocks.TRIAFIUM_LAVA_GENERATOR)
                .add(ModBlocks.TRIAFIUM_COPIER)
                .add(ModBlocks.TRIAFIUM_CLEANSER)
                .add(ModBlocks.TRIAFIUM_PORTAL_BUILDER);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.EUCALYPTUS_LEAVES)
                .add(ModBlocks.TRIAFIA_LEAVES)
                .add(ModBlocks.PACSARIA_LEAVES);
        
        getOrCreateTagBuilder(ModBlockTags.SERPENTINITE)
                .add(ModBlocks.SERPENTINITE)
                .add(ModBlocks.SERPENTINITE_BRICKS)
                .add(ModBlocks.CRACKED_SERPENTINITE_BRICKS)
                .add(ModBlocks.POLISHED_SERPENTINITE);
        
        getOrCreateTagBuilder(ModBlockTags.ECLOGITE)
                .add(ModBlocks.ECLOGITE)
                .add(ModBlocks.ECLOGITE_BRICKS)
                .add(ModBlocks.CRACKED_ECLOGITE_BRICKS)
                .add(ModBlocks.POLISHED_ECLOGITE);

        getOrCreateTagBuilder(ModBlockTags.GLAUCONITE)
                .add(ModBlocks.GLAUCONITE)
                .add(ModBlocks.GLAUCONITE_BRICKS)
                .add(ModBlocks.CRACKED_GLAUCONITE_BRICKS)
                .add(ModBlocks.POLISHED_GLAUCONITE);

        getOrCreateTagBuilder(ModBlockTags.TRIAFIA_CRYSTAL_PLANTABLE)
                .forceAddTag(BlockTags.DIRT)
                .addTag(ModBlockTags.SERPENTINITE)
                .addTag(ModBlockTags.ECLOGITE)
                .addTag(ModBlockTags.GLAUCONITE);

        getOrCreateTagBuilder(ModBlockTags.QUARTZ_ORES)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(ModBlocks.SERPENTINITE_QUARTZ_ORE);
        
        getOrCreateTagBuilder(ModBlockTags.CONCRETE)
                .add(Blocks.WHITE_CONCRETE)
                .add(Blocks.LIGHT_GRAY_CONCRETE)
                .add(Blocks.GRAY_CONCRETE)
                .add(Blocks.BLACK_CONCRETE)
                .add(Blocks.BROWN_CONCRETE)
                .add(Blocks.RED_CONCRETE)
                .add(Blocks.ORANGE_CONCRETE)
                .add(Blocks.YELLOW_CONCRETE)
                .add(Blocks.LIME_CONCRETE)
                .add(Blocks.GREEN_CONCRETE)
                .add(Blocks.CYAN_CONCRETE)
                .add(Blocks.LIGHT_BLUE_CONCRETE)
                .add(Blocks.BLUE_CONCRETE)
                .add(Blocks.PURPLE_CONCRETE)
                .add(Blocks.MAGENTA_CONCRETE)
                .add(Blocks.PINK_CONCRETE);
        
        getOrCreateTagBuilder(ModBlockTags.CONCRETE_SLABS)
                .add(ModBlocks.WHITE_CONCRETE_SLAB)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB)
                .add(ModBlocks.GRAY_CONCRETE_SLAB)
                .add(ModBlocks.BLACK_CONCRETE_SLAB)
                .add(ModBlocks.BROWN_CONCRETE_SLAB)
                .add(ModBlocks.RED_CONCRETE_SLAB)
                .add(ModBlocks.ORANGE_CONCRETE_SLAB)
                .add(ModBlocks.YELLOW_CONCRETE_SLAB)
                .add(ModBlocks.LIME_CONCRETE_SLAB)
                .add(ModBlocks.GREEN_CONCRETE_SLAB)
                .add(ModBlocks.CYAN_CONCRETE_SLAB)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB)
                .add(ModBlocks.BLUE_CONCRETE_SLAB)
                .add(ModBlocks.PURPLE_CONCRETE_SLAB)
                .add(ModBlocks.MAGENTA_CONCRETE_SLAB)
                .add(ModBlocks.PINK_CONCRETE_SLAB);
        
        getOrCreateTagBuilder(ModBlockTags.CONCRETE_STAIRS)
                .add(ModBlocks.WHITE_CONCRETE_STAIRS)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS)
                .add(ModBlocks.GRAY_CONCRETE_STAIRS)
                .add(ModBlocks.BLACK_CONCRETE_STAIRS)
                .add(ModBlocks.BROWN_CONCRETE_STAIRS)
                .add(ModBlocks.RED_CONCRETE_STAIRS)
                .add(ModBlocks.ORANGE_CONCRETE_STAIRS)
                .add(ModBlocks.YELLOW_CONCRETE_STAIRS)
                .add(ModBlocks.LIME_CONCRETE_STAIRS)
                .add(ModBlocks.GREEN_CONCRETE_STAIRS)
                .add(ModBlocks.CYAN_CONCRETE_STAIRS)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS)
                .add(ModBlocks.BLUE_CONCRETE_STAIRS)
                .add(ModBlocks.PURPLE_CONCRETE_STAIRS)
                .add(ModBlocks.MAGENTA_CONCRETE_STAIRS)
                .add(ModBlocks.PINK_CONCRETE_STAIRS);

        getOrCreateTagBuilder(ModBlockTags.CONCRETE_WALLS)
                .add(ModBlocks.WHITE_CONCRETE_WALL)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_WALL)
                .add(ModBlocks.GRAY_CONCRETE_WALL)
                .add(ModBlocks.BLACK_CONCRETE_WALL)
                .add(ModBlocks.BROWN_CONCRETE_WALL)
                .add(ModBlocks.RED_CONCRETE_WALL)
                .add(ModBlocks.ORANGE_CONCRETE_WALL)
                .add(ModBlocks.YELLOW_CONCRETE_WALL)
                .add(ModBlocks.LIME_CONCRETE_WALL)
                .add(ModBlocks.GREEN_CONCRETE_WALL)
                .add(ModBlocks.CYAN_CONCRETE_WALL)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_WALL)
                .add(ModBlocks.BLUE_CONCRETE_WALL)
                .add(ModBlocks.PURPLE_CONCRETE_WALL)
                .add(ModBlocks.MAGENTA_CONCRETE_WALL)
                .add(ModBlocks.PINK_CONCRETE_WALL);

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ModBlocks.TRIAFIAN_VINE);

        getOrCreateTagBuilder(ModBlockTags.EXPERIENCE_DRAINS)
                .add(ModBlocks.IRON_EXPERIENCE_DRAIN)
                .add(ModBlocks.TITANIUM_EXPERIENCE_DRAIN)
                .add(ModBlocks.TRIAFIUM_EXPERIENCE_DRAIN);

        getOrCreateTagBuilder(ModBlockTags.POWERED_RAILS)
                .add(Blocks.POWERED_RAIL);
    }
}
