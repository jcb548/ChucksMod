package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

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

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DIRITONIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAW_DIRITONIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DIRITONIUM_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.EUCALYPTUS_LOG);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        blockStateModelGenerator.registerLog(ModBlocks.EUCALYPTUS_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EUCALYPTUS_LEAVES);
        BlockStateModelGenerator.BlockTexturePool eucalyptus_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EUCALYPTUS_PLANKS);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.EUCALYPTUS_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        eucalyptus_pool.stairs(ModBlocks.EUCALYPTUS_STAIRS);
        eucalyptus_pool.slab(ModBlocks.EUCALYPTUS_SLAB);
        eucalyptus_pool.fence(ModBlocks.EUCALYPTUS_FENCE);
        eucalyptus_pool.fenceGate(ModBlocks.EUCALYPTUS_FENCE_GATE);
        eucalyptus_pool.button(ModBlocks.EUCALYPTUS_BUTTON);
        eucalyptus_pool.pressurePlate(ModBlocks.EUCALYPTUS_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.EUCALYPTUS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.EUCALYPTUS_TRAPDOOR);


        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SLATED_DIRT);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DIRITIA_PLANT,
                BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DIRITIA_LIGHT_PLANT,
                BlockStateModelGenerator.TintType.TINTED);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.INFUSER);
        blockStateModelGenerator.registerItemModel(ModBlocks.EUCALYPTUS_SAPLING);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_FABIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FABIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FABIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FABIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FABIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RAW_DIRITONIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRITONIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRITONIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRITONIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRITONIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRITONIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRITONIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CHEESEBURGER, Models.GENERATED);

        itemModelGenerator.register(ModItems.PRISMARINE_INGOT, Models.GENERATED);
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
    }
}
