package net.chuck.pigsnstuff.block;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.custom.InfuserBlock;
import net.chuck.pigsnstuff.block.custom.ModSlatedGrassBlock;
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
    // Tin
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)));
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
    public static final Block INFUSER = registerBlock("infuser",
            new InfuserBlock(FabricBlockSettings.copy(Blocks.SMOOTH_STONE)));
    // Fabium
    public static final Block FABIUM_BLOCK = registerBlock("fabium_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block RAW_FABIUM_BLOCK = registerBlock("raw_fabium_block",
            new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK)));
    public static final Block FABIUM_ORE = registerBlock("fabium_ore",
            new Block(FabricBlockSettings.copy(Blocks.NETHER_QUARTZ_ORE)));

    // Diritonium
    public static final Block DIRITONIUM_BLOCK = registerBlock("diritonium_block",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_BLOCK)));
    public static final Block RAW_DIRITONIUM_BLOCK = registerBlock("raw_diritonium_block",
            new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK)));
    public static final Block DIRITONIUM_ORE = registerBlock("diritonium_ore",
            new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE).strength(5.0f, 9.0f)));
    // Diritia blocks
    public static final Block DIRITIA_PLANT = registerBlock("diritia_plant",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS)));
    public static final Block DIRITIA_LIGHT_PLANT = registerBlock("diritia_plant_light",
            new PlantBlock(FabricBlockSettings.copy(Blocks.GRASS).luminance(state -> 15)));

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
