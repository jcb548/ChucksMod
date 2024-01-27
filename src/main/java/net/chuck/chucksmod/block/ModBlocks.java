package net.chuck.chucksmod.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.custom.*;
import net.chuck.chucksmod.block.custom.altar.FrankAltarBlock;
import net.chuck.chucksmod.block.custom.altar.SoulBlazeAltarBlock;
import net.chuck.chucksmod.block.custom.copier.TitaniumCopierBlock;
import net.chuck.chucksmod.block.custom.crusher.CrusherBlock;
import net.chuck.chucksmod.block.custom.crusher.IronPoweredCrusherBlock;
import net.chuck.chucksmod.block.custom.crusher.TitaniumPoweredCrusherBlock;
import net.chuck.chucksmod.block.custom.energy_storage.IronEnergyStorageBlock;
import net.chuck.chucksmod.block.custom.energy_storage.TitaniumEnergyStorageBlock;
import net.chuck.chucksmod.block.custom.fluid_pipe.IronFluidPipeBlock;
import net.chuck.chucksmod.block.custom.fluid_pipe.TitaniumFluidPipeBlock;
import net.chuck.chucksmod.block.custom.fluid_tank.IronFluidTankBlock;
import net.chuck.chucksmod.block.custom.fluid_tank.TitaniumFluidTankBlock;
import net.chuck.chucksmod.block.custom.furnace.IronPoweredFurnaceBlock;
import net.chuck.chucksmod.block.custom.furnace.TitaniumPoweredFurnaceBlock;
import net.chuck.chucksmod.block.custom.generator.heat.IronHeatGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.lava.TitaniumLavaGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.steam.IronSteamGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.heat.TitaniumHeatGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.steam.TitaniumSteamGeneratorBlock;
import net.chuck.chucksmod.block.custom.portal_builder.FabiumPortalBuilderBlock;
import net.chuck.chucksmod.block.custom.pump.IronPumpBlock;
import net.chuck.chucksmod.block.custom.pump.TitaniumPumpBlock;
import net.chuck.chucksmod.block.custom.quarry.IronQuarryBlock;
import net.chuck.chucksmod.block.custom.quarry.TitaniumQuarryBlock;
import net.chuck.chucksmod.block.custom.wire.CopperWireBlock;
import net.chuck.chucksmod.block.custom.wire.GoldWireBlock;
import net.chuck.chucksmod.block.custom.wire.TinWireBlock;
import net.chuck.chucksmod.world.tree.DiritiaSaplingGenerator;
import net.chuck.chucksmod.world.tree.EucalyptusSaplingGenerator;
import net.chuck.chucksmod.world.tree.FabiaSaplingGenerator;
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
            new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).nonOpaque().strength(5.0f, 6.0f)));
    public static final Block COPPER_DUST_BLOCK = registerBlock("copper_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block OBSIDIAN_SAND = registerBlock("obsidian_sand",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).resistance(1200.0f).requiresTool()));
    public static final Block COPPER_BARS = registerBlock("copper_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f)));
    public static final Block COPPER_WIRE = registerBlock("copper_wire",
            new CopperWireBlock(FabricBlockSettings.copy(Blocks.COPPER_BLOCK)));
    public static final Block GOLD_DUST_BLOCK = registerBlock("gold_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block GOLD_BARS = registerBlock("gold_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f)));
    public static final Block GOLD_WIRE = registerBlock("gold_wire",
            new GoldWireBlock(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block PRISMARINE_DUST_BLOCK = registerBlock("prismarine_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block PRISMARINE_IRON_DUST_BLOCK = registerBlock("prismarine_iron_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block PRISMARINE_BARS = registerBlock("prismarine_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS)));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            new Block(FabricBlockSettings.copy(ModBlocks.TIN_BLOCK)));
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
    public static final Block IRON_HEAT_GENERATOR = registerBlock("iron_heat_generator",
            new IronHeatGeneratorBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_POWERED_CRUSHER = registerBlock("iron_powered_crusher",
            new IronPoweredCrusherBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_POWERED_FURNACE = registerBlock("iron_powered_furnace",
            new IronPoweredFurnaceBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_ENERGY_STORAGE = registerBlock("iron_energy_storage",
            new IronEnergyStorageBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_QUARRY = registerBlock("iron_quarry",
            new IronQuarryBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_FLUID_TANK = registerBlock("iron_fluid_tank",
            new IronFluidTankBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_PUMP = registerBlock("iron_pump",
            new IronPumpBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_STEAM_GENERATOR = registerBlock("iron_steam_generator",
            new IronSteamGeneratorBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_FLUID_PIPE = registerBlock("iron_fluid_pipe",
            new IronFluidPipeBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));

    public static final Block TIN_WIRE = registerBlock("tin_wire",
            new TinWireBlock(FabricBlockSettings.copy(ModBlocks.TIN_BLOCK)));
    //Titanium
    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block",
            new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).strength(6.0f, 7.0f)));
    public static final Block RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            new Block(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_DUST_BLOCK = registerBlock("titanium_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block TITANIUM_ORE = registerBlock("titanium_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block NETHER_TITANIUM_ORE = registerBlock("nether_titanium_ore",
            new Block(FabricBlockSettings.copy(Blocks.NETHERRACK).strength(3.0f, 3.0f)));
    public static final Block END_STONE_TITANIUM_ORE = registerBlock("endstone_titanium_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)));
    public static final Block TITANIUM_BARS = registerBlock("titanium_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f)));
    public static final Block TITANIUM_MACHINE_BASE = registerBlock("titanium_machine_base",
            new Block(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK).nonOpaque()
                    .strength(6.0f, 7.0f)));
    public static final Block TITANIUM_ENERGY_STORAGE = registerBlock("titanium_energy_storage",
            new TitaniumEnergyStorageBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_POWERED_CRUSHER = registerBlock("titanium_powered_crusher",
            new TitaniumPoweredCrusherBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_POWERED_FURNACE = registerBlock("titanium_powered_furnace",
            new TitaniumPoweredFurnaceBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_HEAT_GENERATOR = registerBlock("titanium_heat_generator",
            new TitaniumHeatGeneratorBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_QUARRY = registerBlock("titanium_quarry",
            new TitaniumQuarryBlock(FabricBlockSettings.copy(TITANIUM_BLOCK)));
    public static final Block TITANIUM_COPIER = registerBlock("titanium_copier",
            new TitaniumCopierBlock(FabricBlockSettings.copy(TITANIUM_BLOCK)));
    public static final Block TITANIUM_FLUID_TANK = registerBlock("titanium_fluid_tank",
            new TitaniumFluidTankBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_PUMP = registerBlock("titanium_pump",
            new TitaniumPumpBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_FLUID_PIPE = registerBlock("titanium_fluid_pipe",
            new TitaniumFluidPipeBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_STEAM_GENERATOR = registerBlock("titanium_steam_generator",
            new TitaniumSteamGeneratorBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_LAVA_GENERATOR = registerBlock("titanium_lava_generator",
            new TitaniumLavaGeneratorBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    // Soul Blocks
    public static final Block SOUL_GRAVEL = registerBlock("soul_gravel",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block SOUL_STONE = registerBlock("soul_stone",
            new Block(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block SOUL_STONE_STAIRS = registerBlock("soul_stone_stairs",
            new StairsBlock(ModBlocks.SOUL_STONE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.STONE_STAIRS)));
    public static final Block SOUL_STONE_SLAB = registerBlock("soul_stone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_SLAB)));
    public static final Block SOUL_STONE_BRICKS = registerBlock("soul_stone_bricks",
            new Block(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block SOUL_STONE_BRICK_STAIRS = registerBlock("soul_stone_brick_stairs",
            new StairsBlock(ModBlocks.SOUL_STONE_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final Block SOUL_STONE_BRICK_SLAB = registerBlock("soul_stone_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_SLAB)));
    public static final Block SOUL_STONE_BRICK_WALL = registerBlock("soul_stone_brick_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_WALL)));
    public static final Block CRACKED_SOUL_STONE_BRICKS = registerBlock("cracked_soul_stone_bricks",
            new Block(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block SOUL_BLAZE_ALTAR = registerBlock("soul_blaze_altar",
            new SoulBlazeAltarBlock(FabricBlockSettings.copy(Blocks.BEDROCK)));

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
    public static final Block FABIUM_PORTAL_BLOCK = registerBlock("fabium_portal_block",
            new Block(FabricBlockSettings.copy(ModBlocks.FABIUM_BLOCK)));
    public static final Block FABIUM_PORTAL_BUILDER = registerBlock("fabium_portal_builder",
            new FabiumPortalBuilderBlock(FabricBlockSettings.copy(ModBlocks.FABIUM_BLOCK)));
    
    //Fabia
    public static final Block ECLOGITE = registerBlock("eclogite",
            new Block(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).strength(4.0f, 9.0f)));
    public static final Block ECLOGITE_STAIRS = registerBlock("eclogite_stairs",
            new StairsBlock(ModBlocks.ECLOGITE.getDefaultState(),
                    FabricBlockSettings.copy(ECLOGITE)));
    public static final Block ECLOGITE_SLAB = registerBlock("eclogite_slab",
            new SlabBlock(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block ECLOGITE_WALL = registerBlock("eclogite_wall",
            new WallBlock(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block ECLOGITE_BRICKS = registerBlock("eclogite_bricks",
            new Block(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block ECLOGITE_BRICK_STAIRS = registerBlock("eclogite_brick_stairs",
            new StairsBlock(ModBlocks.ECLOGITE_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(ECLOGITE)));
    public static final Block ECLOGITE_BRICK_SLAB = registerBlock("eclogite_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block ECLOGITE_BRICK_WALL = registerBlock("eclogite_brick_wall",
            new WallBlock(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block CRACKED_ECLOGITE_BRICKS = registerBlock("cracked_eclogite_bricks",
            new Block(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block SERPENTINITE = registerBlock("serpentinite",
            new Block(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).strength(3.0f, 7.0f)));
    public static final Block SERPENTINITE_STAIRS = registerBlock("serpentinite_stairs",
            new StairsBlock(ModBlocks.SERPENTINITE.getDefaultState(),
                    FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block SERPENTINITE_SLAB = registerBlock("serpentinite_slab",
            new SlabBlock(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block SERPENTINITE_WALL = registerBlock("serpentinite_wall",
            new WallBlock(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block SERPENTINITE_BRICKS = registerBlock("serpentinite_bricks",
            new Block(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block SERPENTINITE_BRICK_STAIRS = registerBlock("serpentinite_brick_stairs",
            new StairsBlock(ModBlocks.SERPENTINITE_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block SERPENTINITE_BRICK_SLAB = registerBlock("serpentinite_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block SERPENTINITE_BRICK_WALL = registerBlock("serpentinite_brick_wall",
            new WallBlock(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block CRACKED_SERPENTINITE_BRICKS = registerBlock("cracked_serpentinite_bricks",
            new Block(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block POLISHED_SERPENTINITE = registerBlock("polished_serpentinite",
            new Block(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block POLISHED_SERPENTINITE_STAIRS = registerBlock("polished_serpentinite_stairs",
            new StairsBlock(ModBlocks.POLISHED_SERPENTINITE.getDefaultState(),
                    FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block POLISHED_SERPENTINITE_SLAB = registerBlock("polished_serpentinite_slab",
            new SlabBlock(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block POLISHED_SERPENTINITE_WALL = registerBlock("polished_serpentinite_wall",
            new WallBlock(FabricBlockSettings.copy(SERPENTINITE)));
    public static final Block FABIA_LOG = registerBlock("fabia_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block FABIA_WOOD = registerBlock("fabia_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_FABIA_LOG = registerBlock("stripped_fabia_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_FABIA_WOOD = registerBlock("stripped_fabia_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block FABIA_PLANKS = registerBlock("fabia_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block FABIA_LEAVES = registerBlock("fabia_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block FABIA_SAPLING = registerBlock("fabia_sapling",
            new SaplingBlock(new FabiaSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block FABIA_STAIRS = registerBlock("fabia_stairs",
            new StairsBlock(ModBlocks.FABIA_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block FABIA_SLAB = registerBlock("fabia_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block FABIA_BUTTON = registerBlock("fabia_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block FABIA_PRESSURE_PLATE = registerBlock("fabia_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block FABIA_FENCE = registerBlock("fabia_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
    public static final Block FABIA_FENCE_GATE = registerBlock("fabia_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block FABIA_DOOR = registerBlock("fabia_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block FABIA_TRAPDOOR = registerBlock("fabia_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Identifier FABIA_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/fabia");
    public static final Identifier FABIA_HANGING_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/hanging/fabia");
    public static final Identifier FABIA_HANGING_GUI_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "textures/gui/hanging_signs/fabia");
    public static final Block STANDING_FABIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "fabia_standing_sign"),
                    new TerraformSignBlock(FABIA_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_FABIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "fabia_wall_sign"),
                    new TerraformWallSignBlock(FABIA_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_FABIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "fabia_hanging_sign"),
                    new TerraformHangingSignBlock(FABIA_HANGING_SIGN_TEXTURE, FABIA_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_FABIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "fabia_wall_standing_sign"),
                    new TerraformWallHangingSignBlock(FABIA_HANGING_SIGN_TEXTURE,
                            FABIA_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final BlockFamily FABIA_FAMILY = BlockFamilies.register(ModBlocks.FABIA_PLANKS)
            .sign(ModBlocks.STANDING_FABIA_SIGN, ModBlocks.WALL_FABIA_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();
    

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
            new FrankAltarBlock(FabricBlockSettings.copy(Blocks.BEDROCK)));
    
    // Hardened Glass
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
            new Block(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE)));
    public static final Block SANDSTONE_BRICK_STAIRS = registerBlock("sandstone_brick_stairs",
            new StairsBlock(ModBlocks.SANDSTONE_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_STAIRS)));
    public static final Block SANDSTONE_BRICK_SLAB = registerBlock("sandstone_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_SLAB)));
    public static final Block SANDSTONE_BRICK_WALL = registerBlock("sandstone_brick_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE)));
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
