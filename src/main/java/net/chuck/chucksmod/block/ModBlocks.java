package net.chuck.chucksmod.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.custom.altar.FrankAltarBlock;
import net.chuck.chucksmod.block.custom.altar.PippinAltarBlock;
import net.chuck.chucksmod.block.custom.altar.SoulBlazeAltarBlock;
import net.chuck.chucksmod.block.custom.cleanser.TitaniumCleanserBlock;
import net.chuck.chucksmod.block.custom.copier.TitaniumCopierBlock;
import net.chuck.chucksmod.block.custom.copier.TriafiumCopierBlock;
import net.chuck.chucksmod.block.custom.crop.*;
import net.chuck.chucksmod.block.custom.crop.magical.*;
import net.chuck.chucksmod.block.custom.crusher.CrusherBlock;
import net.chuck.chucksmod.block.custom.crusher.IronPoweredCrusherBlock;
import net.chuck.chucksmod.block.custom.crusher.TitaniumPoweredCrusherBlock;
import net.chuck.chucksmod.block.custom.crusher.TriafiumPoweredCrusherBlock;
import net.chuck.chucksmod.block.custom.energy_storage.IronEnergyStorageBlock;
import net.chuck.chucksmod.block.custom.energy_storage.TitaniumEnergyStorageBlock;
import net.chuck.chucksmod.block.custom.energy_storage.TriafiumEnergyStorageBlock;
import net.chuck.chucksmod.block.custom.experience_drain.IronExperienceDrainBlock;
import net.chuck.chucksmod.block.custom.experience_drain.TitaniumExperienceDrainBlock;
import net.chuck.chucksmod.block.custom.experience_drain.TriafiumExperienceDrainBlock;
import net.chuck.chucksmod.block.custom.fluid_pipe.IronFluidPipeBlock;
import net.chuck.chucksmod.block.custom.fluid_pipe.TitaniumFluidPipeBlock;
import net.chuck.chucksmod.block.custom.fluid_pipe.TriafiumFluidPipeBlock;
import net.chuck.chucksmod.block.custom.fluid_tank.IronFluidTankBlock;
import net.chuck.chucksmod.block.custom.fluid_tank.TitaniumFluidTankBlock;
import net.chuck.chucksmod.block.custom.fluid_tank.TriafiumFluidTankBlock;
import net.chuck.chucksmod.block.custom.furnace.IronPoweredFurnaceBlock;
import net.chuck.chucksmod.block.custom.furnace.TitaniumPoweredFurnaceBlock;
import net.chuck.chucksmod.block.custom.furnace.TriafiumPoweredFurnaceBlock;
import net.chuck.chucksmod.block.custom.generator.heat.IronHeatGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.heat.TriafiumHeatGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.lava.TitaniumLavaGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.lava.TriafiumLavaGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.steam.IronSteamGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.heat.TitaniumHeatGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.steam.TitaniumSteamGeneratorBlock;
import net.chuck.chucksmod.block.custom.generator.steam.TriafiumSteamGeneratorBlock;
import net.chuck.chucksmod.block.custom.harvester.IronHarvesterBlock;
import net.chuck.chucksmod.block.custom.harvester.TitaniumHarvesterBlock;
import net.chuck.chucksmod.block.custom.harvester.TriafiumHarvesterBlock;
import net.chuck.chucksmod.block.custom.portal_builder.TriafiumPortalBuilderBlock;
import net.chuck.chucksmod.block.custom.pump.IronPumpBlock;
import net.chuck.chucksmod.block.custom.pump.TitaniumPumpBlock;
import net.chuck.chucksmod.block.custom.pump.TriafiumPumpBlock;
import net.chuck.chucksmod.block.custom.quarry.IronQuarryBlock;
import net.chuck.chucksmod.block.custom.quarry.TitaniumQuarryBlock;
import net.chuck.chucksmod.block.custom.quarry.TriafiumQuarryBlock;
import net.chuck.chucksmod.block.custom.wire.CopperWireBlock;
import net.chuck.chucksmod.block.custom.wire.GoldWireBlock;
import net.chuck.chucksmod.block.custom.wire.NetheriteWireBlock;
import net.chuck.chucksmod.block.custom.wire.TinWireBlock;
import net.chuck.chucksmod.world.tree.PacsariaSaplingGenerator;
import net.chuck.chucksmod.world.tree.EucalyptusSaplingGenerator;
import net.chuck.chucksmod.world.tree.TriafiaSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
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
    public static final Block COAL_DUST_BLOCK = registerBlock("coal_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.BLACK)));
    public static final Block COAL_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "coal_crop"),
                    new CoalCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.GRAY)));
    public static final Block IRON_DUST_BLOCK = registerBlock("iron_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.IRON_GRAY)));
    public static final Block IRON_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "iron_crop"),
                    new IronCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.IRON_GRAY)));
    public static final Block IRON_MACHINE_BASE = registerBlock("iron_machine_base",
            new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).nonOpaque()
                    .strength(5.0f, 6.0f)));
    public static final Block COPPER_DUST_BLOCK = registerBlock("copper_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.ORANGE)));
    public static final Block COPPER_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "copper_crop"),
                    new CopperCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.ORANGE)));
    public static final Block OBSIDIAN_SAND = registerBlock("obsidian_sand",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).resistance(1200.0f).requiresTool()
                    .mapColor(MapColor.PALE_PURPLE)));
    public static final Block COPPER_BARS = registerBlock("copper_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f)
                    .mapColor(MapColor.ORANGE)));
    public static final Block COPPER_WIRE = registerBlock("copper_wire",
            new CopperWireBlock(FabricBlockSettings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.ORANGE)));
    public static final Block GOLD_DUST_BLOCK = registerBlock("gold_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.GOLD)));
    public static final Block GOLD_BARS = registerBlock("gold_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f)
                    .mapColor(MapColor.GOLD)));
    public static final Block GOLD_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "gold_crop"),
                    new GoldCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.GOLD)));
    public static final Block GOLD_WIRE = registerBlock("gold_wire",
            new GoldWireBlock(FabricBlockSettings.copy(Blocks.GOLD_BLOCK).mapColor(MapColor.GOLD)));
    public static final Block PRISMARINE_DUST_BLOCK = registerBlock("prismarine_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block PRISMARINE_IRON_DUST_BLOCK = registerBlock("prismarine_iron_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block PRISMARINE_BARS = registerBlock("prismarine_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS)));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            new Block(FabricBlockSettings.copy(ModBlocks.TIN_BLOCK).mapColor(MapColor.LIGHT_BLUE_GRAY)));
    public static final Block TIN_DUST_BLOCK = registerBlock("tin_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.LIGHT_BLUE_GRAY)));
    public static final Block TIN_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "tin_crop"),
                    new TinCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.LIGHT_BLUE_GRAY)));
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block TIN_BARS = registerBlock("tin_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f).mapColor(MapColor.LIGHT_GRAY)));
    //Bronze
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK).mapColor(MapColor.BROWN)));
    public static final Block BRONZE_DUST_BLOCK = registerBlock("bronze_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.BROWN)));
    public static final Block BRONZE_BARS = registerBlock("bronze_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).mapColor(MapColor.BROWN)));

    public static final Block LAPIS_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "lapis_crop"),
                    new LapisCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block REDSTONE_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "redstone_crop"),
                    new RedstoneCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.RED)));
    public static final Block DIAMOND_DUST_BLOCK = registerBlock("diamond_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block DIAMOND_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "diamond_crop"),
                    new DiamondCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block EMERALD_DUST_BLOCK = registerBlock("emerald_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block EMERALD_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "emerald_crop"),
                    new EmeraldCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.EMERALD_GREEN)));

    // Eucalyptus
    public static final Block EUCALYPTUS_LOG = registerBlock("eucalyptus_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final Block EUCALYPTUS_WOOD = registerBlock("eucalyptus_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final Block STRIPPED_EUCALYPTUS_LOG = registerBlock("stripped_eucalyptus_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_EUCALYPTUS_WOOD = registerBlock("stripped_eucalyptus_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block EUCALYPTUS_PLANKS = registerBlock("eucalyptus_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block EUCALYPTUS_LEAVES = registerBlock("eucalyptus_leaves",
            Blocks.createLeavesBlock(BlockSoundGroup.GRASS));
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
            new CrusherBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).mapColor(MapColor.GRAY)));
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
    public static final Block IRON_HARVESTER = registerBlock("iron_harvester",
            new IronHarvesterBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_FLUID_PIPE = registerBlock("iron_fluid_pipe",
            new IronFluidPipeBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block IRON_EXPERIENCE_DRAIN = registerBlock("iron_experience_drain",
            new IronExperienceDrainBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK).nonOpaque()));

    public static final Block TIN_WIRE = registerBlock("tin_wire",
            new TinWireBlock(FabricBlockSettings.copy(ModBlocks.TIN_BLOCK).mapColor(MapColor.LIGHT_GRAY)));
    //Titanium
    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block",
            new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).strength(6.0f, 7.0f).mapColor(MapColor.PALE_YELLOW)));
    public static final Block RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            new Block(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_DUST_BLOCK = registerBlock("titanium_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.PALE_YELLOW)));
    public static final Block TITANIUM_ORE = registerBlock("titanium_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block NETHER_TITANIUM_ORE = registerBlock("nether_titanium_ore",
            new Block(FabricBlockSettings.copy(Blocks.NETHERRACK).strength(3.0f, 3.0f)));
    public static final Block END_STONE_TITANIUM_ORE = registerBlock("endstone_titanium_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block TITANIUM_BARS = registerBlock("titanium_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(3.0f, 6.0f).mapColor(MapColor.PALE_YELLOW)));
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
    public static final Block TITANIUM_CLEANSER = registerBlock("titanium_cleanser",
            new TitaniumCleanserBlock(FabricBlockSettings.copy(TITANIUM_BLOCK)));
    public static final Block TITANIUM_FLUID_TANK = registerBlock("titanium_fluid_tank",
            new TitaniumFluidTankBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_PUMP = registerBlock("titanium_pump",
            new TitaniumPumpBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_FLUID_PIPE = registerBlock("titanium_fluid_pipe",
            new TitaniumFluidPipeBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_EXPERIENCE_DRAIN = registerBlock("titanium_experience_drain",
            new TitaniumExperienceDrainBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK).nonOpaque()));
    public static final Block TITANIUM_STEAM_GENERATOR = registerBlock("titanium_steam_generator",
            new TitaniumSteamGeneratorBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_LAVA_GENERATOR = registerBlock("titanium_lava_generator",
            new TitaniumLavaGeneratorBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_BLOCK)));
    public static final Block TITANIUM_HARVESTER = registerBlock("titanium_harvester",
            new TitaniumHarvesterBlock(FabricBlockSettings.copy(TITANIUM_BLOCK)));
    public static final Block TITANIUM_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "titanium_crop"),
                    new TitaniumCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.PALE_YELLOW)));
    // Nether
    public static final Block NETHER_CRYSTAL_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "nether_crystal_crop"),
                    new NetherCrystalCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.ORANGE)
                            .luminance(state -> 12)));
    public static final Block NETHERITE_DUST_BLOCK = registerBlock("netherite_dust_block",
            new FallingBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_DUST_BLOCK).mapColor(MapColor.BLACK)));
    public static final Block NETHERITE_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "netherite_crop"),
                    new NetheriteCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.BLACK)));
    public static final Block NETHERITE_WIRE = registerBlock("netherite_wire",
            new NetheriteWireBlock(FabricBlockSettings.copy(Blocks.NETHERITE_BLOCK)));
    // Soul Blocks
    public static final Block SOUL_GRAVEL = registerBlock("soul_gravel",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND).mapColor(MapColor.BROWN)));
    public static final Block SOUL_STONE = registerBlock("soul_stone",
            new Block(FabricBlockSettings.copy(Blocks.STONE).mapColor(MapColor.BROWN)));
    public static final Block SOUL_STONE_STAIRS = registerBlock("soul_stone_stairs",
            new StairsBlock(ModBlocks.SOUL_STONE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.STONE_STAIRS)));
    public static final Block SOUL_STONE_SLAB = registerBlock("soul_stone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_SLAB).mapColor(MapColor.BROWN)));
    public static final Block SOUL_STONE_BRICKS = registerBlock("soul_stone_bricks",
            new Block(FabricBlockSettings.copy(Blocks.STONE).mapColor(MapColor.BROWN)));
    public static final Block SOUL_STONE_BRICK_STAIRS = registerBlock("soul_stone_brick_stairs",
            new StairsBlock(ModBlocks.SOUL_STONE_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final Block SOUL_STONE_BRICK_SLAB = registerBlock("soul_stone_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_SLAB).mapColor(MapColor.BROWN)));
    public static final Block SOUL_STONE_BRICK_WALL = registerBlock("soul_stone_brick_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_WALL).mapColor(MapColor.BROWN)));
    public static final Block CRACKED_SOUL_STONE_BRICKS = registerBlock("cracked_soul_stone_bricks",
            new Block(FabricBlockSettings.copy(Blocks.STONE).mapColor(MapColor.BROWN)));
    public static final Block SOUL_BLAZE_ALTAR = registerBlock("soul_blaze_altar",
            new SoulBlazeAltarBlock(FabricBlockSettings.copy(Blocks.BEDROCK).mapColor(MapColor.BROWN)));
    
    //Concrete
    public static final Block WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.WHITE_CONCRETE)));
    public static final Block WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            new StairsBlock(Blocks.WHITE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.WHITE_CONCRETE)));
    public static final Block WHITE_CONCRETE_WALL = registerBlock("white_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.WHITE_CONCRETE)));
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            new StairsBlock(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block LIGHT_GRAY_CONCRETE_WALL = registerBlock("light_gray_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)));
    public static final Block GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            new StairsBlock(Blocks.GRAY_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)));
    public static final Block GRAY_CONCRETE_WALL = registerBlock("gray_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.GRAY_CONCRETE)));
    public static final Block BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));
    public static final Block BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            new StairsBlock(Blocks.BLACK_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));
    public static final Block BLACK_CONCRETE_WALL = registerBlock("black_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE)));
    public static final Block BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BROWN_CONCRETE)));
    public static final Block BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            new StairsBlock(Blocks.BROWN_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BROWN_CONCRETE)));
    public static final Block BROWN_CONCRETE_WALL = registerBlock("brown_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.BROWN_CONCRETE)));
    public static final Block RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.RED_CONCRETE)));
    public static final Block RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            new StairsBlock(Blocks.RED_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.RED_CONCRETE)));
    public static final Block RED_CONCRETE_WALL = registerBlock("red_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.RED_CONCRETE)));
    public static final Block ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.ORANGE_CONCRETE)));
    public static final Block ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            new StairsBlock(Blocks.ORANGE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.ORANGE_CONCRETE)));
    public static final Block ORANGE_CONCRETE_WALL = registerBlock("orange_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.ORANGE_CONCRETE)));
    public static final Block YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.YELLOW_CONCRETE)));
    public static final Block YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            new StairsBlock(Blocks.YELLOW_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.YELLOW_CONCRETE)));
    public static final Block YELLOW_CONCRETE_WALL = registerBlock("yellow_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.YELLOW_CONCRETE)));
    public static final Block LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIME_CONCRETE)));
    public static final Block LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            new StairsBlock(Blocks.LIME_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIME_CONCRETE)));
    public static final Block LIME_CONCRETE_WALL = registerBlock("lime_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.LIME_CONCRETE)));
    public static final Block GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            new StairsBlock(Blocks.GREEN_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block GREEN_CONCRETE_WALL = registerBlock("green_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.CYAN_CONCRETE)));
    public static final Block CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            new StairsBlock(Blocks.CYAN_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.CYAN_CONCRETE)));
    public static final Block CYAN_CONCRETE_WALL = registerBlock("cyan_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.CYAN_CONCRETE)));
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            new StairsBlock(Blocks.LIGHT_BLUE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block LIGHT_BLUE_CONCRETE_WALL = registerBlock("light_blue_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)));
    public static final Block BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            new StairsBlock(Blocks.BLUE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)));
    public static final Block BLUE_CONCRETE_WALL = registerBlock("blue_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.BLUE_CONCRETE)));
    public static final Block PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            new StairsBlock(Blocks.PURPLE_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block PURPLE_CONCRETE_WALL = registerBlock("purple_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Block MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            new StairsBlock(Blocks.MAGENTA_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Block MAGENTA_CONCRETE_WALL = registerBlock("magenta_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Block PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.PINK_CONCRETE)));
    public static final Block PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            new StairsBlock(Blocks.PINK_CONCRETE.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.PINK_CONCRETE)));
    public static final Block PINK_CONCRETE_WALL = registerBlock("pink_concrete_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.PINK_CONCRETE)));
    //tuff
    public static final Block TUFF_SLAB = registerBlock("tuff_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.TUFF)));
    public static final Block TUFF_STAIRS = registerBlock("tuff_stairs",
            new StairsBlock(Blocks.TUFF.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.TUFF)));
    public static final Block TUFF_WALL = registerBlock("tuff_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.TUFF)));

    // Triafium
    public static final Block RAW_TRIAFIUM_BLOCK = registerBlock("raw_triafium_block",
            new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK).strength(6.0f, 8.0f).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIUM_BLOCK = registerBlock("triafium_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK).strength(6.0f, 8.0f).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIUM_BARS = registerBlock("triafium_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).mapColor(MapColor.DARK_GREEN)));
    public static final Block NETHER_TRIAFIUM_ORE = registerBlock("nether_triafium_ore",
            new Block(FabricBlockSettings.copy(Blocks.NETHER_QUARTZ_ORE)));
    public static final Block END_STONE_TRIAFIUM_ORE = registerBlock("endstone_triafium_ore",
            new Block(FabricBlockSettings.copy(Blocks.NETHER_QUARTZ_ORE)));
    public static final Block DEEPSLATE_TRIAFIUM_ORE = registerBlock("deepslate_triafium_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block TRIAFIUM_DUST_BLOCK = registerBlock("triafium_dust_block",
            new FallingBlock(FabricBlockSettings.copy(ModBlocks.TITANIUM_DUST_BLOCK)
                    .mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIUM_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "triafium_crop"),
                    new TriafiumCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIUM_PORTAL_BLOCK = registerBlock("triafium_portal_block",
            new Block(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_MACHINE_BASE = registerBlock("triafium_machine_base",
            new Block(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK).nonOpaque()
                    .strength(7.0f, 9.0f)));
    public static final Block TRIAFIUM_ENERGY_STORAGE = registerBlock("triafium_energy_storage",
            new TriafiumEnergyStorageBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_POWERED_CRUSHER = registerBlock("triafium_powered_crusher",
            new TriafiumPoweredCrusherBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_POWERED_FURNACE = registerBlock("triafium_powered_furnace",
            new TriafiumPoweredFurnaceBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_HEAT_GENERATOR = registerBlock("triafium_heat_generator",
            new TriafiumHeatGeneratorBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_PUMP = registerBlock("triafium_pump",
            new TriafiumPumpBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_FLUID_PIPE = registerBlock("triafium_fluid_pipe",
            new TriafiumFluidPipeBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_EXPERIENCE_DRAIN = registerBlock("triafium_experience_drain",
            new TriafiumExperienceDrainBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK).nonOpaque()));
    public static final Block TRIAFIUM_FLUID_TANK = registerBlock("triafium_fluid_tank",
            new TriafiumFluidTankBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_STEAM_GENERATOR = registerBlock("triafium_steam_generator",
            new TriafiumSteamGeneratorBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_HARVESTER = registerBlock("triafium_harvester",
            new TriafiumHarvesterBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_QUARRY = registerBlock("triafium_quarry",
            new TriafiumQuarryBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_LAVA_GENERATOR = registerBlock("triafium_lava_generator",
            new TriafiumLavaGeneratorBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_COPIER = registerBlock("triafium_copier",
            new TriafiumCopierBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    public static final Block TRIAFIUM_PORTAL_BUILDER = registerBlock("triafium_portal_builder",
            new TriafiumPortalBuilderBlock(FabricBlockSettings.copy(ModBlocks.TRIAFIUM_BLOCK)));
    
    //Triafia
    public static final Block ECLOGITE = registerBlock("eclogite",
            new Block(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).strength(4.0f, 9.0f).mapColor(MapColor.BRIGHT_TEAL)));
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
    public static final Block POLISHED_ECLOGITE = registerBlock("polished_eclogite",
            new Block(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block POLISHED_ECLOGITE_STAIRS = registerBlock("polished_eclogite_stairs",
            new StairsBlock(ModBlocks.POLISHED_ECLOGITE.getDefaultState(),
                    FabricBlockSettings.copy(ECLOGITE)));
    public static final Block POLISHED_ECLOGITE_SLAB = registerBlock("polished_eclogite_slab",
            new SlabBlock(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block POLISHED_ECLOGITE_WALL = registerBlock("polished_eclogite_wall",
            new WallBlock(FabricBlockSettings.copy(ECLOGITE)));
    public static final Block SERPENTINITE = registerBlock("serpentinite",
            new Block(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).strength(3.0f, 7.0f)
                    .mapColor(MapColor.LICHEN_GREEN)));
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
    public static final Block GLAUCONITE = registerBlock("glauconite",
            new Block(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).strength(3.0f, 7.0f)
                    .mapColor(MapColor.TERRACOTTA_GREEN)));
    public static final Block GLAUCONITE_STAIRS = registerBlock("glauconite_stairs",
            new StairsBlock(ModBlocks.GLAUCONITE.getDefaultState(),
                    FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block GLAUCONITE_SLAB = registerBlock("glauconite_slab",
            new SlabBlock(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block GLAUCONITE_WALL = registerBlock("glauconite_wall",
            new WallBlock(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block GLAUCONITE_BRICKS = registerBlock("glauconite_bricks",
            new Block(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block GLAUCONITE_BRICK_STAIRS = registerBlock("glauconite_brick_stairs",
            new StairsBlock(ModBlocks.GLAUCONITE_BRICKS.getDefaultState(),
                    FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block GLAUCONITE_BRICK_SLAB = registerBlock("glauconite_brick_slab",
            new SlabBlock(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block GLAUCONITE_BRICK_WALL = registerBlock("glauconite_brick_wall",
            new WallBlock(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block CRACKED_GLAUCONITE_BRICKS = registerBlock("cracked_glauconite_bricks",
            new Block(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block POLISHED_GLAUCONITE = registerBlock("polished_glauconite",
            new Block(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block POLISHED_GLAUCONITE_STAIRS = registerBlock("polished_glauconite_stairs",
            new StairsBlock(ModBlocks.POLISHED_GLAUCONITE.getDefaultState(),
                    FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block POLISHED_GLAUCONITE_SLAB = registerBlock("polished_glauconite_slab",
            new SlabBlock(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block POLISHED_GLAUCONITE_WALL = registerBlock("polished_glauconite_wall",
            new WallBlock(FabricBlockSettings.copy(GLAUCONITE)));
    public static final Block TRIAFIA_CRYSTAL_CROP =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "triafia_crystal_crop"),
                    new TriafiaCrystalCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.DARK_GREEN)
                            .luminance(state -> 5)));
    public static final Block PIPPIN_ALTAR = registerBlock("pippin_altar",
            new PippinAltarBlock(FabricBlockSettings.copy(Blocks.BEDROCK)));
    //Serpentinite Ores
    public static final Block SERPENTINITE_COAL_ORE = registerBlock("serpentinite_coal_ore",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE).strength(5.0f, 9.0f).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block SERPENTINITE_COPPER_ORE = registerBlock("serpentinite_copper_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_DIAMOND_ORE = registerBlock("serpentinite_diamond_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_PACSARIUM_ORE = registerBlock("serpentinite_pacsarium_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_EMERALD_ORE = registerBlock("serpentinite_emerald_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_TRIAFIUM_ORE = registerBlock("serpentinite_triafium_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_GOLD_ORE = registerBlock("serpentinite_gold_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_IRON_ORE = registerBlock("serpentinite_iron_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_LAPIS_ORE = registerBlock("serpentinite_lapis_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_REDSTONE_ORE = registerBlock("serpentinite_redstone_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_TIN_ORE = registerBlock("serpentinite_tin_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_TITANIUM_ORE = registerBlock("serpentinite_titanium_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block SERPENTINITE_QUARTZ_ORE = registerBlock("serpentinite_quartz_ore",
            new Block(FabricBlockSettings.copy(ModBlocks.SERPENTINITE_COAL_ORE)));
    public static final Block TRIAFIA_LOG = registerBlock("triafia_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIA_WOOD = registerBlock("triafia_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.DARK_GREEN)));
    public static final Block STRIPPED_TRIAFIA_LOG = registerBlock("stripped_triafia_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.DARK_GREEN)));
    public static final Block STRIPPED_TRIAFIA_WOOD = registerBlock("stripped_triafia_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIA_PLANKS = registerBlock("triafia_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIA_LEAVES = registerBlock("triafia_leaves",
            Blocks.createLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block TRIAFIA_SAPLING = registerBlock("triafia_sapling",
            new SaplingBlock(new TriafiaSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIA_STAIRS = registerBlock("triafia_stairs",
            new StairsBlock(ModBlocks.TRIAFIA_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIA_SLAB = registerBlock("triafia_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIA_BUTTON = registerBlock("triafia_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.DARK_GREEN), BlockSetType.OAK, 10, true));
    public static final Block TRIAFIA_PRESSURE_PLATE = registerBlock("triafia_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.DARK_GREEN), BlockSetType.OAK));
    public static final Block TRIAFIA_FENCE = registerBlock("triafia_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIA_FENCE_GATE = registerBlock("triafia_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.DARK_GREEN), WoodType.OAK));
    public static final Block TRIAFIA_DOOR = registerBlock("triafia_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.DARK_GREEN), BlockSetType.OAK));
    public static final Block TRIAFIA_TRAPDOOR = registerBlock("triafia_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.DARK_GREEN), BlockSetType.OAK));
    public static final Identifier TRIAFIA_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/triafia");
    public static final Identifier TRIAFIA_HANGING_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/hanging/triafia");
    public static final Identifier TRIAFIA_HANGING_GUI_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "textures/gui/hanging_signs/triafia");
    public static final Block STANDING_TRIAFIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "triafia_standing_sign"),
                    new TerraformSignBlock(TRIAFIA_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN).mapColor(MapColor.DARK_GREEN)));
    public static final Block WALL_TRIAFIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "triafia_wall_sign"),
                    new TerraformWallSignBlock(TRIAFIA_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).mapColor(MapColor.DARK_GREEN)));
    public static final Block HANGING_TRIAFIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "triafia_hanging_sign"),
                    new TerraformHangingSignBlock(TRIAFIA_HANGING_SIGN_TEXTURE, TRIAFIA_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.DARK_GREEN)));
    public static final Block WALL_HANGING_TRIAFIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "triafia_wall_standing_sign"),
                    new TerraformWallHangingSignBlock(TRIAFIA_HANGING_SIGN_TEXTURE,
                            TRIAFIA_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.DARK_GREEN)));
    public static final BlockFamily TRIAFIA_FAMILY = BlockFamilies.register(ModBlocks.TRIAFIA_PLANKS)
            .sign(ModBlocks.STANDING_TRIAFIA_SIGN, ModBlocks.WALL_TRIAFIA_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();
    public static final Block TRIAFIA_PLANT = registerBlock("triafia_plant",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS).mapColor(MapColor.DARK_GREEN)));
    public static final Block TRIAFIAN_VINE = registerBlock("triafian_vine",
            new VineBlock(FabricBlockSettings.copy(Blocks.VINE)));

    // Pacsarium
    public static final Block PACSARIUM_BLOCK = registerBlock("pacsarium_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block RAW_PACSARIUM_BLOCK = registerBlock("raw_pacsarium_block",
            new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block END_STONE_PACSARIUM_ORE = registerBlock("endstone_pacsarium_ore",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE).strength(5.0f, 9.0f).mapColor(MapColor.PURPLE)));
    public static final Block DEEPSLATE_PACSARIUM_ORE = registerBlock("deepslate_pacsarium_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_GOLD_ORE).strength(5.0f, 9.0f).mapColor(MapColor.PURPLE)));
    public static final Block PACSARIUM_BARS = registerBlock("pacsarium_bars",
            new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).mapColor(MapColor.PURPLE)));
    // Pacsaria blocks
    public static final Block PACSARIA_PLANT = registerBlock("pacsaria_plant",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS).mapColor(MapColor.PURPLE)));
    public static final Block PACSARIA_LIGHT_PLANT = registerBlock("pacsaria_plant_light",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS).luminance(state -> 15).mapColor(MapColor.ORANGE)));
    // Eucalyptus
    public static final Block PACSARIA_LOG = registerBlock("pacsaria_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(3.0f).mapColor(MapColor.PURPLE)));
    public static final Block PACSARIA_WOOD = registerBlock("pacsaria_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(3.0f).mapColor(MapColor.PURPLE)));
    public static final Block STRIPPED_PACSARIA_LOG = registerBlock("stripped_pacsaria_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).strength(3.0f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block STRIPPED_PACSARIA_WOOD = registerBlock("stripped_pacsaria_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).strength(3.0f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PACSARIA_PLANKS = registerBlock("pacsaria_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(3.0f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PACSARIA_LEAVES = registerBlock("pacsaria_leaves",
            Blocks.createLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block PACSARIA_SAPLING = registerBlock("pacsaria_sapling", new SaplingBlock(new
            PacsariaSaplingGenerator(),FabricBlockSettings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PACSARIA_STAIRS = registerBlock("pacsaria_stairs",
            new StairsBlock(ModBlocks.PACSARIA_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS).strength(3.0f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PACSARIA_SLAB = registerBlock("pacsaria_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).strength(3.0f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PACSARIA_BUTTON = registerBlock("pacsaria_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).strength(2.0f).mapColor(MapColor.PALE_PURPLE),
                    BlockSetType.OAK, 10, true));
    public static final Block PACSARIA_PRESSURE_PLATE = registerBlock("pacsaria_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).strength(2.0f).mapColor(MapColor.PALE_PURPLE),
                    BlockSetType.OAK));
    public static final Block PACSARIA_FENCE = registerBlock("pacsaria_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).strength(3.0f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PACSARIA_FENCE_GATE = registerBlock("pacsaria_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).strength(3.0f)
                    .mapColor(MapColor.PALE_PURPLE), WoodType.OAK));
    public static final Block PACSARIA_DOOR = registerBlock("pacsaria_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).strength(3.0f).mapColor(MapColor.PALE_PURPLE),
                    BlockSetType.OAK));
    public static final Block PACSARIA_TRAPDOOR = registerBlock("pacsaria_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).strength(3.0f)
                    .mapColor(MapColor.PALE_PURPLE), BlockSetType.OAK));
    public static final Identifier PACSARIA_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/pacsaria");
    public static final Identifier PACSARIA_HANGING_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "entity/signs/hanging/pacsaria");
    public static final Identifier PACSARIA_HANGING_GUI_SIGN_TEXTURE =
            new Identifier(ChucksMod.MOD_ID, "textures/gui/hanging_signs/pacsaria");
    public static final Block STANDING_PACSARIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "pacsaria_standing_sign"),
                    new TerraformSignBlock(PACSARIA_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)
                            .strength(2.0f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block WALL_PACSARIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "pacsaria_wall_sign"),
                    new TerraformWallSignBlock(PACSARIA_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)
                            .strength(2.0f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block HANGING_PACSARIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "pacsaria_hanging_sign"),
                    new TerraformHangingSignBlock(PACSARIA_HANGING_SIGN_TEXTURE, PACSARIA_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN).strength(2.0f)
                                    .mapColor(MapColor.PALE_PURPLE)));
    public static final Block WALL_HANGING_PACSARIA_SIGN =
            Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "pacsaria_wall_standing_sign"),
                    new TerraformWallHangingSignBlock(PACSARIA_HANGING_SIGN_TEXTURE,
                            PACSARIA_HANGING_GUI_SIGN_TEXTURE,
                            FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).strength(2.0f)
                                    .mapColor(MapColor.PALE_PURPLE)));
    public static final BlockFamily PACSARIA_FAMILY = BlockFamilies.register(ModBlocks.PACSARIA_PLANKS)
            .sign(ModBlocks.STANDING_PACSARIA_SIGN, ModBlocks.WALL_PACSARIA_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();
    public static final Block FRANK_ALTAR = registerBlock("frank_altar",
            new FrankAltarBlock(FabricBlockSettings.copy(Blocks.BEDROCK)));
    
    // Hardened Glass
    public static final Block HARDENED_GLASS = registerBlock("hardened_glass",
            new GlassBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).requiresTool().resistance(1200.0f)
                    .solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).nonOpaque()
                    .mapColor(MapColor.WHITE)));
    public static final Block HARDENED_GLASS_PANE = registerBlock("hardened_glass_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE).requiresTool().resistance(1200.0f)
                    .solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)
                    .mapColor(MapColor.WHITE)));
    public static final Block HARDENED_BLACK_GLASS = registerBlock("hardened_black_stained_glass",
            new StainedGlassBlock(DyeColor.BLACK, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.BLACK)));
    public static final Block HARDENED_BLACK_GLASS_PANE = registerBlock("hardened_black_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.BLACK, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.BLACK)));
    public static final Block HARDENED_BLUE_GLASS = registerBlock("hardened_blue_stained_glass",
            new StainedGlassBlock(DyeColor.BLUE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.BLUE)));
    public static final Block HARDENED_BLUE_GLASS_PANE = registerBlock("hardened_blue_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.BLUE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.BLUE)));
    public static final Block HARDENED_BROWN_GLASS = registerBlock("hardened_brown_stained_glass",
            new StainedGlassBlock(DyeColor.BROWN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.BROWN)));
    public static final Block HARDENED_BROWN_GLASS_PANE = registerBlock("hardened_brown_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.BROWN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.BROWN)));
    public static final Block HARDENED_CYAN_GLASS = registerBlock("hardened_cyan_stained_glass",
            new StainedGlassBlock(DyeColor.CYAN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.CYAN)));
    public static final Block HARDENED_CYAN_GLASS_PANE = registerBlock("hardened_cyan_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.CYAN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.CYAN)));
    public static final Block HARDENED_GRAY_GLASS = registerBlock("hardened_gray_stained_glass",
            new StainedGlassBlock(DyeColor.GRAY, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.GRAY)));
    public static final Block HARDENED_GRAY_GLASS_PANE = registerBlock("hardened_gray_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.GRAY, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.GRAY)));
    public static final Block HARDENED_GREEN_GLASS = registerBlock("hardened_green_stained_glass",
            new StainedGlassBlock(DyeColor.GREEN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.GREEN)));
    public static final Block HARDENED_GREEN_GLASS_PANE = registerBlock("hardened_green_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.GREEN, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.GREEN)));
    public static final Block HARDENED_LIGHT_BLUE_GLASS = registerBlock("hardened_light_blue_stained_glass",
            new StainedGlassBlock(DyeColor.LIGHT_BLUE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.LIGHT_BLUE)));
    public static final Block HARDENED_LIGHT_BLUE_GLASS_PANE = registerBlock("hardened_light_blue_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.LIGHT_BLUE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block HARDENED_LIGHT_GRAY_GLASS = registerBlock("hardened_light_gray_stained_glass",
            new StainedGlassBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.LIGHT_GRAY)));
    public static final Block HARDENED_LIGHT_GRAY_GLASS_PANE = registerBlock("hardened_light_gray_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block HARDENED_LIME_GLASS = registerBlock("hardened_lime_stained_glass",
            new StainedGlassBlock(DyeColor.LIME, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.LIME)));
    public static final Block HARDENED_LIME_GLASS_PANE = registerBlock("hardened_lime_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.LIME, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.LIME)));
    public static final Block HARDENED_MAGENTA_GLASS = registerBlock("hardened_magenta_stained_glass",
            new StainedGlassBlock(DyeColor.MAGENTA, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.MAGENTA)));
    public static final Block HARDENED_MAGENTA_GLASS_PANE = registerBlock("hardened_magenta_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.MAGENTA, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.MAGENTA)));
    public static final Block HARDENED_ORANGE_GLASS = registerBlock("hardened_orange_stained_glass",
            new StainedGlassBlock(DyeColor.ORANGE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.ORANGE)));
    public static final Block HARDENED_ORANGE_GLASS_PANE = registerBlock("hardened_orange_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.ORANGE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.ORANGE)));
    public static final Block HARDENED_PINK_GLASS = registerBlock("hardened_pink_stained_glass",
            new StainedGlassBlock(DyeColor.PINK, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.PINK)));
    public static final Block HARDENED_PINK_GLASS_PANE = registerBlock("hardened_pink_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.PINK, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.PINK)));
    public static final Block HARDENED_PURPLE_GLASS = registerBlock("hardened_purple_stained_glass",
            new StainedGlassBlock(DyeColor.PURPLE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.PURPLE)));
    public static final Block HARDENED_PURPLE_GLASS_PANE = registerBlock("hardened_purple_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.PURPLE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.PURPLE)));
    public static final Block HARDENED_RED_GLASS = registerBlock("hardened_red_stained_glass",
            new StainedGlassBlock(DyeColor.RED, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.RED)));
    public static final Block HARDENED_RED_GLASS_PANE = registerBlock("hardened_red_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.RED, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.RED)));
    public static final Block HARDENED_WHITE_GLASS = registerBlock("hardened_white_stained_glass",
            new StainedGlassBlock(DyeColor.WHITE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.WHITE)));
    public static final Block HARDENED_WHITE_GLASS_PANE = registerBlock("hardened_white_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.WHITE, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.WHITE)));
    public static final Block HARDENED_YELLOW_GLASS = registerBlock("hardened_yellow_stained_glass",
            new StainedGlassBlock(DyeColor.YELLOW, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.YELLOW)));
    public static final Block HARDENED_YELLOW_GLASS_PANE = registerBlock("hardened_yellow_stained_glass_pane",
            new StainedGlassPaneBlock(DyeColor.YELLOW, FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).mapColor(MapColor.YELLOW)));
    public static final Block HARDENED_TINTED_GLASS = registerBlock("hardened_tinted_glass",
            new TintedGlassBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE)
                    .requiresTool().resistance(1200.0f).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never).nonOpaque().mapColor(MapColor.GRAY)));
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
        new LettuceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.LIME)));
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
