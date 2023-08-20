package net.chuck.pigsnstuff.block;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.custom.CrusherBlock;
import net.chuck.pigsnstuff.block.custom.ModSlatedGrassBlock;
import net.chuck.pigsnstuff.world.tree.DiritiaSaplingGenerator;
import net.chuck.pigsnstuff.world.tree.EucalyptusSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block IRON_DUST_BLOCK = registerBlock("iron_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block COPPER_DUST_BLOCK = registerBlock("copper_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block GOLD_DUST_BLOCK = registerBlock("gold_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block PRISMARINE_DUST_BLOCK = registerBlock("prismarine_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block PRISMARINE_IRON_DUST_BLOCK = registerBlock("prismarine_iron_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    // Tin
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block TIN_DUST_BLOCK = registerBlock("tin_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    //Bronze
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block BRONZE_DUST_BLOCK = registerBlock("bronze_dust_block",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));

    // Eucalyptus
    public static final Block EUCALYPTUS_LOG = registerBlock("eucalyptus_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(4.0f)));
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
    public static final Block CRUSHER = registerBlock("crusher",
            new CrusherBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE)));
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
            new Block(FabricBlockSettings.copy(Blocks.NETHER_QUARTZ_ORE)));

    // Diritonium
    public static final Block DIRITONIUM_BLOCK = registerBlock("diritonium_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block RAW_DIRITONIUM_BLOCK = registerBlock("raw_diritonium_block",
            new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK)));
    public static final Block END_STONE_DIRITONIUM_ORE = registerBlock("endstone_diritonium_ore",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE).strength(5.0f, 9.0f)));
    public static final Block DEEPSLATE_DIRITONIUM_ORE = registerBlock("deepslate_diritonium_ore",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE).strength(5.0f, 9.0f)));
    // Diritia blocks
    public static final Block DIRITIA_PLANT = registerBlock("diritia_plant",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS)));
    public static final Block DIRITIA_LIGHT_PLANT = registerBlock("diritia_plant_light",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS).luminance(state -> 15)));
    // Eucalyptus
    public static final Block DIRITIA_LOG = registerBlock("diritia_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(4.0f)));
    public static final Block DIRITIA_WOOD = registerBlock("diritia_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_DIRITIA_LOG = registerBlock("stripped_diritia_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_DIRITIA_WOOD = registerBlock("stripped_diritia_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block DIRITIA_PLANKS = registerBlock("diritia_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block DIRITIA_LEAVES = registerBlock("diritia_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));
    public static final Block DIRITIA_SAPLING = registerBlock("diritia_sapling",
            new SaplingBlock(new DiritiaSaplingGenerator(),FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block DIRITIA_STAIRS = registerBlock("diritia_stairs",
            new StairsBlock(ModBlocks.DIRITIA_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block DIRITIA_SLAB = registerBlock("diritia_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block DIRITIA_BUTTON = registerBlock("diritia_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block DIRITIA_PRESSURE_PLATE = registerBlock("diritia_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block DIRITIA_FENCE = registerBlock("diritia_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
    public static final Block DIRITIA_FENCE_GATE = registerBlock("diritia_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block DIRITIA_DOOR = registerBlock("diritia_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block DIRITIA_TRAPDOOR = registerBlock("diritia_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    // New base materials
    public static final Block SLATED_DIRT = registerBlock("slated_dirt",
            new Block(FabricBlockSettings.copy(Blocks.DIRT).strength(1.0f).requiresTool()));
    public static final Block SLATED_GRASS = registerBlock("slated_grass",
            new ModSlatedGrassBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK).strength(1.2f).requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PigsNStuff.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(PigsNStuff.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        PigsNStuff.LOGGER.info("Registering ModBlocks for " + PigsNStuff.MOD_ID);
    }
}
