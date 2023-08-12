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

        addDrop(ModBlocks.INFUSER);
    }
}
