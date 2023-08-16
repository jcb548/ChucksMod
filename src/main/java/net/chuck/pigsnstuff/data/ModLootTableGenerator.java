package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.TIN_ORE, oreDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, oreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN));

        addDrop(ModBlocks.RAW_FABIUM_BLOCK);
        addDrop(ModBlocks.FABIUM_BLOCK);
        addDrop(ModBlocks.FABIUM_ORE, oreDrops(ModBlocks.FABIUM_ORE, ModItems.RAW_FABIUM));

        addDrop(ModBlocks.RAW_DIRITONIUM_BLOCK);
        addDrop(ModBlocks.DIRITONIUM_BLOCK);
        addDrop(ModBlocks.DIRITONIUM_ORE, oreDrops(ModBlocks.DIRITONIUM_ORE, ModItems.RAW_DIRITONIUM));

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

        addDrop(ModBlocks.INFUSER);
    }
}
