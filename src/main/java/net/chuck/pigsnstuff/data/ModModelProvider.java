package net.chuck.pigsnstuff.data;

import com.ibm.icu.text.Normalizer2;
import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.custom.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_TIN_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FABIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAW_FABIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FABIUM_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.EUCALYPTUS_LOG);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        blockStateModelGenerator.registerLog(ModBlocks.EUCALYPTUS_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EUCALYPTUS_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EUCALYPTUS_LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.EUCALYPTUS_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.INFUSER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_FABIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHEESEBURGER, Models.GENERATED);

        itemModelGenerator.register(ModItems.PRISMARINE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.WITHER_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModBlocks.EUCALYPTUS_SAPLING.asItem(), Models.GENERATED);
    }
}
