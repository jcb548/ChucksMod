package net.chuck.chucksmod.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.custom.*;
import net.chuck.chucksmod.block.custom.crusher.CrusherBlock;
import net.chuck.chucksmod.block.custom.crusher.PoweredCrusherBlock;
import net.chuck.chucksmod.block.custom.generator.IronHeatGeneratorBlock;
import net.chuck.chucksmod.block.custom.wire.CopperWireBlock;
import net.chuck.chucksmod.block.custom.wire.GoldWireBlock;
import net.chuck.chucksmod.block.custom.wire.TinWireBlock;
import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.world.tree.DiritiaSaplingGenerator;
import net.chuck.chucksmod.world.tree.EucalyptusSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModBlocks {
    public static final Block IRON_DUST_BLOCK = registerBlock("iron_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block IRON_MACHINE_BASE = registerBlock("iron_machine_base",
            new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block COPPER_DUST_BLOCK = registerBlock("copper_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block OBSIDIAN_SAND = registerBlock("obsidian_sand",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).resistance(1200.0f).requiresTool()));
    public static final Block COPPER_BARS = registerBlock("copper_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f)));
    public static final Block COPPER_WIRE = registerBlock("copper_wire",
            new CopperWireBlock(FabricBlockSettings.copy(Blocks.COPPER_BLOCK), ModBlockEntities.COPPER_WIRE_TRANSFER_RATE));
    public static final Block GOLD_DUST_BLOCK = registerBlock("gold_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block GOLD_BARS = registerBlock("gold_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f)));
    public static final Block GOLD_WIRE = registerBlock("gold_wire",
            new GoldWireBlock(FabricBlockSettings.copy(Blocks.GOLD_BLOCK), ModBlockEntities.GOLD_WIRE_TRANSFER_RATE));
    public static final Block PRISMARINE_DUST_BLOCK = registerBlock("prismarine_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block PRISMARINE_IRON_DUST_BLOCK = registerBlock("prismarine_iron_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block PRISMARINE_BARS = registerBlock("prismarine_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS)));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block TIN_DUST_BLOCK = registerBlock("tin_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block TIN_BARS = registerBlock("tin_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f)));
    //Bronze
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block BRONZE_DUST_BLOCK = registerBlock("bronze_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block BRONZE_BARS = registerBlock("bronze_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS)));

    // Eucalyptus
    public static final Block EUCALYPTUS_LOG = registerBlock("eucalyptus_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block EUCALYPTUS_WOOD = registerBlock("eucalyptus_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_EUCALYPTUS_LOG = registerBlock("stripped_eucalyptus_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_EUCALYPTUS_WOOD = registerBlock("stripped_eucalyptus_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block EUCALYPTUS_PLANKS = registerBlock("eucalyptus_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block EUCALYPTUS_LEAVES = registerBlock("eucalyptus_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));
    public static final Block EUCALYPTUS_SAPLING = registerBlock("eucalyptus_sapling",
            new SaplingBlock(new EucalyptusSaplingGenerator(),FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block EUCALYPTUS_STAIRS = registerBlock("eucalyptus_stairs",
            new StairsBlock(ModBlocks.EUCALYPTUS_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block EUCALYPTUS_SLAB = registerBlock("eucalyptus_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block EUCALYPTUS_BUTTON = registerBlock("eucalyptus_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block EUCALYPTUS_PRESSURE_PLATE = registerBlock("eucalyptus_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block EUCALYPTUS_FENCE = registerBlock("eucalyptus_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
    public static final Block EUCALYPTUS_FENCE_GATE = registerBlock("eucalyptus_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block EUCALYPTUS_DOOR = registerBlock("eucalyptus_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block EUCALYPTUS_TRAPDOOR = registerBlock("eucalyptus_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Identifier EUCALYPTUS_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/eucalyptus");
    public static final Identifier EUCALYPTUS_HANGING_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/hanging/eucalyptus");
    public static final Identifier EUCALYPTUS_HANGING_GUI_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "textures/gui/hanging_signs/eucalyptus");
    public static final Block STANDING_EUCALYPTUS_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "eucalyptus_standing_sign"),
                    new TerraformSignBlock(EUCALYPTUS_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_EUCALYPTUS_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "eucalyptus_wall_sign"),
                    new TerraformWallSignBlock(EUCALYPTUS_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_EUCALYPTUS_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "eucalyptus_hanging_sign"),
                    new TerraformHangingSignBlock(EUCALYPTUS_HANGING_SIGN_TEXTURE, EUCALYPTUS_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_EUCALYPTUS_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "eucalyptus_wall_standing_sign"),
                    new TerraformWallHangingSignBlock(EUCALYPTUS_HANGING_SIGN_TEXTURE,
                            EUCALYPTUS_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));

    public static final BlockFamily EUCALYPTUS_FAMILY = BlockFamilies.register(ModBlocks.EUCALYPTUS_PLANKS)
            .sign(ModBlocks.STANDING_EUCALYPTUS_SIGN, ModBlocks.WALL_EUCALYPTUS_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block CRUSHER = registerBlock("crusher",
            new CrusherBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE)));
    public static final Block IRON_POWERED_CRUSHER = registerBlock("iron_powered_crusher",
            new PoweredCrusherBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE)));
    public static final Block IRON_HEAT_GENERATOR = registerBlock("iron_heat_generator",
            new IronHeatGeneratorBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE)));

    public static final Block TIN_WIRE = registerBlock("tin_wire",
            new TinWireBlock(FabricBlockSettings.copy(ModBlocks.TIN_BLOCK), ModBlockEntities.TIN_WIRE_TRANSFER_RATE));
    // Fabium
    public static final Block FABIUM_BLOCK = registerBlock("fabium_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block RAW_FABIUM_BLOCK = registerBlock("raw_fabium_block",
            new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK)));
    public static final Block NETHER_FABIUM_ORE = registerBlock("nether_fabium_ore",
            new Block(FabricBlockSettings.copy(Blocks.NETHER_QUARTZ_ORE)));
    public static final Block END_STONE_FABIUM_ORE = registerBlock("endstone_fabium_ore",
            new Block(FabricBlockSettings.copy(Blocks.NETHER_QUARTZ_ORE)));
    public static final Block DEEPSLATE_FABIUM_ORE = registerBlock("deepslate_fabium_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block FABIUM_BARS = registerBlock("fabium_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS)));

    // Diritonium
    public static final Block DIRITONIUM_BLOCK = registerBlock("diritonium_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block RAW_DIRITONIUM_BLOCK = registerBlock("raw_diritonium_block",
            new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK)));
    public static final Block END_STONE_DIRITONIUM_ORE = registerBlock("endstone_diritonium_ore",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE).strength(5.0f, 9.0f)));
    public static final Block DEEPSLATE_DIRITONIUM_ORE = registerBlock("deepslate_diritonium_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_GOLD_ORE).strength(5.0f, 9.0f)));
    public static final Block DIRITONIUM_BARS = registerBlock("diritonium_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS)));
    // Diritia blocks
    public static final Block DIRITIA_PLANT = registerBlock("diritia_plant",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS)));
    public static final Block DIRITIA_LIGHT_PLANT = registerBlock("diritia_plant_light",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS).luminance(state -> 15)));
    // Eucalyptus
    public static final Block DIRITIA_LOG = registerBlock("diritia_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(3.0f)));
    public static final Block DIRITIA_WOOD = registerBlock("diritia_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(3.0f)));
    public static final Block STRIPPED_DIRITIA_LOG = registerBlock("stripped_diritia_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).strength(3.0f)));
    public static final Block STRIPPED_DIRITIA_WOOD = registerBlock("stripped_diritia_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).strength(3.0f)));
    public static final Block DIRITIA_PLANKS = registerBlock("diritia_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(3.0f)));
    public static final Block DIRITIA_LEAVES = registerBlock("diritia_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));
    public static final Block DIRITIA_SAPLING = registerBlock("diritia_sapling",
            new SaplingBlock(new DiritiaSaplingGenerator(),FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block DIRITIA_STAIRS = registerBlock("diritia_stairs",
            new StairsBlock(ModBlocks.DIRITIA_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS).strength(3.0f)));
    public static final Block DIRITIA_SLAB = registerBlock("diritia_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).strength(3.0f)));
    public static final Block DIRITIA_BUTTON = registerBlock("diritia_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).strength(2.0f), BlockSetType.OAK, 10, true));
    public static final Block DIRITIA_PRESSURE_PLATE = registerBlock("diritia_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).strength(2.0f), BlockSetType.OAK));
    public static final Block DIRITIA_FENCE = registerBlock("diritia_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).strength(3.0f)));
    public static final Block DIRITIA_FENCE_GATE = registerBlock("diritia_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).strength(3.0f), WoodType.OAK));
    public static final Block DIRITIA_DOOR = registerBlock("diritia_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).strength(3.0f), BlockSetType.OAK));
    public static final Block DIRITIA_TRAPDOOR = registerBlock("diritia_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).strength(3.0f), BlockSetType.OAK));
    public static final Identifier DIRITIA_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/diritia");
    public static final Identifier DIRITIA_HANGING_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/hanging/diritia");
    public static final Identifier DIRITIA_HANGING_GUI_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "textures/gui/hanging_signs/diritia");
    public static final Block STANDING_DIRITIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "diritia_standing_sign"),
                    new TerraformSignBlock(DIRITIA_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN).strength(2.0f)));
    public static final Block WALL_DIRITIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "diritia_wall_sign"),
                    new TerraformWallSignBlock(DIRITIA_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).strength(2.0f)));
    public static final Block HANGING_DIRITIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "diritia_hanging_sign"),
                    new TerraformHangingSignBlock(DIRITIA_HANGING_SIGN_TEXTURE, DIRITIA_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN).strength(2.0f)));
    public static final Block WALL_HANGING_DIRITIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "diritia_wall_standing_sign"),
                    new TerraformWallHangingSignBlock(DIRITIA_HANGING_SIGN_TEXTURE,
                            DIRITIA_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).strength(2.0f)));
    public static final BlockFamily DIRITIA_FAMILY = BlockFamilies.register(ModBlocks.DIRITIA_PLANKS)
            .sign(ModBlocks.STANDING_DIRITIA_SIGN, ModBlocks.WALL_DIRITIA_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();
    public static final Block FRANK_ALTAR = registerBlock("frank_altar",
            new AltarBlock(FabricBlockSettings.copy(Blocks.BEDROCK)));
    
    // New base materials
    public static final Block SLATED_DIRT = registerBlock("slated_dirt",
            new Block(FabricBlockSettings.copy(Blocks.DIRT).strength(1.0f).requiresTool()));
    public static final Block SLATED_GRASS = registerBlock("slated_grass",
            new SlatedGrassBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK).strength(1.2f).requiresTool()));
    public static final Block HARDENED_GLASS = registerBlock("hardened_glass",
            new GlassBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).requiresTool().resistance(1200.0f)
                    .solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_GLASS_PANE = registerBlock("hardened_glass_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).requiresTool().resistance(1200.0f)
                    .solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HARDENED_BLACK_GLASS = registerBlock("hardened_black_stained_glass",
            new StainedGlassBlock(DyeColor.BLACK, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_BLACK_GLASS_PANE = registerBlock("hardened_black_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.BLACK, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_BLUE_GLASS = registerBlock("hardened_blue_stained_glass",
            new StainedGlassBlock(DyeColor.BLUE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_BLUE_GLASS_PANE = registerBlock("hardened_blue_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.BLUE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_BROWN_GLASS = registerBlock("hardened_brown_stained_glass",
            new StainedGlassBlock(DyeColor.BROWN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_BROWN_GLASS_PANE = registerBlock("hardened_brown_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.BROWN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_CYAN_GLASS = registerBlock("hardened_cyan_stained_glass",
            new StainedGlassBlock(DyeColor.CYAN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_CYAN_GLASS_PANE = registerBlock("hardened_cyan_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.CYAN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_GRAY_GLASS = registerBlock("hardened_gray_stained_glass",
            new StainedGlassBlock(DyeColor.GRAY, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_GRAY_GLASS_PANE = registerBlock("hardened_gray_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.GRAY, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_GREEN_GLASS = registerBlock("hardened_green_stained_glass",
            new StainedGlassBlock(DyeColor.GREEN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_GREEN_GLASS_PANE = registerBlock("hardened_green_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.GREEN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_LIGHT_BLUE_GLASS = registerBlock("hardened_light_blue_stained_glass",
            new StainedGlassBlock(DyeColor.LIGHT_BLUE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_LIGHT_BLUE_GLASS_PANE = registerBlock("hardened_light_blue_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.LIGHT_BLUE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_LIGHT_GRAY_GLASS = registerBlock("hardened_light_gray_stained_glass",
            new StainedGlassBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_LIGHT_GRAY_GLASS_PANE = registerBlock("hardened_light_gray_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_LIME_GLASS = registerBlock("hardened_lime_stained_glass",
            new StainedGlassBlock(DyeColor.LIME, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_LIME_GLASS_PANE = registerBlock("hardened_lime_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.LIME, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_MAGENTA_GLASS = registerBlock("hardened_magenta_stained_glass",
            new StainedGlassBlock(DyeColor.MAGENTA, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_MAGENTA_GLASS_PANE = registerBlock("hardened_magenta_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.MAGENTA, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_ORANGE_GLASS = registerBlock("hardened_orange_stained_glass",
            new StainedGlassBlock(DyeColor.ORANGE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_ORANGE_GLASS_PANE = registerBlock("hardened_orange_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.ORANGE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_PINK_GLASS = registerBlock("hardened_pink_stained_glass",
            new StainedGlassBlock(DyeColor.PINK, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_PINK_GLASS_PANE = registerBlock("hardened_pink_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.PINK, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_PURPLE_GLASS = registerBlock("hardened_purple_stained_glass",
            new StainedGlassBlock(DyeColor.PURPLE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_PURPLE_GLASS_PANE = registerBlock("hardened_purple_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.PURPLE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_RED_GLASS = registerBlock("hardened_red_stained_glass",
            new StainedGlassBlock(DyeColor.RED, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_RED_GLASS_PANE = registerBlock("hardened_red_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.RED, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_WHITE_GLASS = registerBlock("hardened_white_stained_glass",
            new StainedGlassBlock(DyeColor.WHITE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_WHITE_GLASS_PANE = registerBlock("hardened_white_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.WHITE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_YELLOW_GLASS = registerBlock("hardened_yellow_stained_glass",
            new StainedGlassBlock(DyeColor.YELLOW, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block HARDENED_YELLOW_GLASS_PANE = registerBlock("hardened_yellow_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.YELLOW, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));
    public static final Block HARDENED_TINTED_GLASS = registerBlock("hardened_tinted_glass",
            new TintedGlassBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque()));
    public static final Block SANDSTONE_BRICKS = registerBlock("sandstone_bricks",
            new Block(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block SANDSTONE_BRICK_STAIRS = registerBlock("sandstone_brick_stairs",
            new StairsBlock(ModBlocks.SANDSTONE_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.SANDSTONE_STAIRS)));
    public static final Block SANDSTONE_BRICK_SLAB = registerBlock("sandstone_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_SLAB)));
    public static final Block SANDSTONE_BRICK_WALL = registerBlock("sandstone_brick_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_WALL)));
    public static final Block CRACKED_SANDSTONE_BRICKS = registerBlock("cracked_sandstone_bricks",
            new Block(FabricBlockSettings.copy(Blocks.SANDSTONE)));

    public static final Block TOMATO_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "tomato_crop"),
        new TomatoCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
    public static final Block LETTUCE_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "lettuce_crop"),
        new LettuceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
    public static final Block PINEAPPLE_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "pineapple_crop"),
        new PineappleCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(ChucksMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        ChucksMod.LOGGER.info("Registering ModBlocks for " + ChucksMod.MOD_ID);
    }
}
