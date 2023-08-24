package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.IRON_DUST_BLOCK);
        addDrop(ModBlocks.COPPER_DUST_BLOCK);
        addDrop(ModBlocks.GOLD_DUST_BLOCK);
        addDrop(ModBlocks.PRISMARINE_DUST_BLOCK);
        addDrop(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);

        addDrop(ModBlocks.TIN_DUST_BLOCK);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.TIN_ORE, oreDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, oreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN));

        addDrop(ModBlocks.BRONZE_BLOCK);
        addDrop(ModBlocks.BRONZE_DUST_BLOCK);

        addDrop(ModBlocks.RAW_FABIUM_BLOCK);
        addDrop(ModBlocks.FABIUM_BLOCK);
        addDrop(ModBlocks.NETHER_FABIUM_ORE, oreDrops(ModBlocks.NETHER_FABIUM_ORE, ModItems.RAW_FABIUM));
        addDrop(ModBlocks.END_STONE_FABIUM_ORE, oreDrops(ModBlocks.END_STONE_FABIUM_ORE, ModItems.RAW_FABIUM));
        addDrop(ModBlocks.DEEPSLATE_FABIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_FABIUM_ORE, ModItems.RAW_FABIUM));

        addDrop(ModBlocks.RAW_DIRITONIUM_BLOCK);
        addDrop(ModBlocks.DIRITONIUM_BLOCK);
        addDrop(ModBlocks.END_STONE_DIRITONIUM_ORE, oreDrops(ModBlocks.END_STONE_DIRITONIUM_ORE,
                ModItems.RAW_DIRITONIUM));
        addDrop(ModBlocks.DEEPSLATE_DIRITONIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_DIRITONIUM_ORE,
                ModItems.RAW_DIRITONIUM));

        addDrop(ModBlocks.EUCALYPTUS_SAPLING);
        addDrop(ModBlocks.EUCALYPTUS_LOG);
        addDrop(ModBlocks.EUCALYPTUS_WOOD);
        addDrop(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        addDrop(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
        addDrop(ModBlocks.EUCALYPTUS_LEAVES, leavesDrops(ModBlocks.EUCALYPTUS_LEAVES, ModBlocks.EUCALYPTUS_SAPLING,
                0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f));
        addDrop(ModBlocks.EUCALYPTUS_BUTTON);
        addDrop(ModBlocks.EUCALYPTUS_DOOR, doorDrops(ModBlocks.EUCALYPTUS_DOOR));
        addDrop(ModBlocks.EUCALYPTUS_TRAPDOOR);
        addDrop(ModBlocks.EUCALYPTUS_FENCE);
        addDrop(ModBlocks.EUCALYPTUS_FENCE_GATE);
        addDrop(ModBlocks.EUCALYPTUS_PRESSURE_PLATE);
        addDrop(ModBlocks.EUCALYPTUS_STAIRS);
        addDrop(ModBlocks.EUCALYPTUS_SLAB, slabDrops(ModBlocks.EUCALYPTUS_SLAB));

        addDrop(ModBlocks.SLATED_DIRT);
        addDrop(ModBlocks.SLATED_GRASS);

        addDrop(ModBlocks.DIRITIA_SAPLING);
        addDrop(ModBlocks.DIRITIA_LOG);
        addDrop(ModBlocks.DIRITIA_WOOD);
        addDrop(ModBlocks.STRIPPED_DIRITIA_LOG);
        addDrop(ModBlocks.STRIPPED_DIRITIA_WOOD);
        addDrop(ModBlocks.DIRITIA_LEAVES, leavesDrops(ModBlocks.DIRITIA_LEAVES, ModBlocks.DIRITIA_SAPLING,
                0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f));
        addDrop(ModBlocks.DIRITIA_BUTTON);
        addDrop(ModBlocks.DIRITIA_DOOR, doorDrops(ModBlocks.DIRITIA_DOOR));
        addDrop(ModBlocks.DIRITIA_TRAPDOOR);
        addDrop(ModBlocks.DIRITIA_FENCE);
        addDrop(ModBlocks.DIRITIA_FENCE_GATE);
        addDrop(ModBlocks.DIRITIA_PRESSURE_PLATE);
        addDrop(ModBlocks.DIRITIA_STAIRS);
        addDrop(ModBlocks.DIRITIA_SLAB, slabDrops(ModBlocks.DIRITIA_SLAB));
        addDrop(ModBlocks.DIRITIA_PLANT, grassDrops(ModBlocks.DIRITIA_PLANT));
        addDrop(ModBlocks.DIRITIA_LIGHT_PLANT);

        addDrop(ModBlocks.CRUSHER);
        addDrop(ModBlocks.POWERED_CRUSHER);
    }
}
