package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRON_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COPPER_DUST_BLOCK);
        blockStateModelGenerator.registerItemModel(ModBlocks.COPPER_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_DUST_BLOCK);
        blockStateModelGenerator.registerItemModel(ModBlocks.GOLD_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);
        blockStateModelGenerator.registerItemModel(ModBlocks.PRISMARINE_BARS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerItemModel(ModBlocks.TIN_BARS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_DUST_BLOCK);
        blockStateModelGenerator.registerItemModel(ModBlocks.BRONZE_BARS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FABIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_FABIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_FABIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_FABIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FABIUM_ORE);
        blockStateModelGenerator.registerItemModel(ModBlocks.FABIUM_BARS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIRITONIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_DIRITONIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_DIRITONIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_DIRITONIUM_ORE);
        blockStateModelGenerator.registerItemModel(ModBlocks.DIRITONIUM_BARS);

        BlockStateModelGenerator.LogTexturePool eucalyptus_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.EUCALYPTUS_LOG);
        eucalyptus_log_pool.log(ModBlocks.EUCALYPTUS_LOG);
        eucalyptus_log_pool.wood(ModBlocks.EUCALYPTUS_WOOD);
        BlockStateModelGenerator.LogTexturePool stripped_eucalyptus_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        stripped_eucalyptus_log_pool.log(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        stripped_eucalyptus_log_pool.wood(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EUCALYPTUS_LEAVES);
        BlockStateModelGenerator.BlockTexturePool eucalyptus_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EUCALYPTUS_PLANKS);
        blockStateModelGenerator.registerTintableCross(ModBlocks.EUCALYPTUS_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        eucalyptus_pool.stairs(ModBlocks.EUCALYPTUS_STAIRS);
        eucalyptus_pool.slab(ModBlocks.EUCALYPTUS_SLAB);
        eucalyptus_pool.fence(ModBlocks.EUCALYPTUS_FENCE);
        eucalyptus_pool.fenceGate(ModBlocks.EUCALYPTUS_FENCE_GATE);
        eucalyptus_pool.button(ModBlocks.EUCALYPTUS_BUTTON);
        eucalyptus_pool.pressurePlate(ModBlocks.EUCALYPTUS_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.EUCALYPTUS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.EUCALYPTUS_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SLATED_DIRT);
        blockStateModelGenerator.registerTintableCross(ModBlocks.DIRITIA_PLANT,
                BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.DIRITIA_LIGHT_PLANT,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.LogTexturePool diritia_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.DIRITIA_LOG);
        diritia_log_pool.log(ModBlocks.DIRITIA_LOG);
        diritia_log_pool.wood(ModBlocks.DIRITIA_WOOD);
        BlockStateModelGenerator.LogTexturePool stripped_diritia_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DIRITIA_LOG);
        stripped_diritia_log_pool.log(ModBlocks.STRIPPED_DIRITIA_LOG);
        stripped_diritia_log_pool.wood(ModBlocks.STRIPPED_DIRITIA_WOOD);

        BlockStateModelGenerator.BlockTexturePool diritia_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DIRITIA_PLANKS);
        blockStateModelGenerator.registerTintableCross(ModBlocks.DIRITIA_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        diritia_pool.stairs(ModBlocks.DIRITIA_STAIRS);
        diritia_pool.slab(ModBlocks.DIRITIA_SLAB);
        diritia_pool.fence(ModBlocks.DIRITIA_FENCE);
        diritia_pool.fenceGate(ModBlocks.DIRITIA_FENCE_GATE);
        diritia_pool.button(ModBlocks.DIRITIA_BUTTON);
        diritia_pool.pressurePlate(ModBlocks.DIRITIA_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.DIRITIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.DIRITIA_TRAPDOOR);

        blockStateModelGenerator.registerCooker(ModBlocks.CRUSHER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.POWERED_CRUSHER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.GENERATOR, TexturedModel.ORIENTABLE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORPORATE_ALTAR);
        blockStateModelGenerator.registerParentedItemModel(ModItems.WYATT_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_GEAR, Models.GENERATED);

        itemModelGenerator.register(ModItems.TIN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_GEAR, Models.GENERATED);

        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BRONZE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BRONZE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BRONZE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BRONZE_BOOTS);

        itemModelGenerator.register(ModItems.RAW_FABIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABIUM_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FABIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FABIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FABIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FABIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FABIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FABIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FABIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FABIUM_BOOTS);

        itemModelGenerator.register(ModItems.RAW_DIRITONIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRITONIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRITONIUM_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRITONIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRITONIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRITONIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRITONIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIRITONIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIRITONIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIRITONIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIRITONIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIRITONIUM_BOOTS);
        itemModelGenerator.register(ModItems.DIRITIA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRITIA_CRYSTAL_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHEESEBURGER, Models.GENERATED);

        itemModelGenerator.register(ModItems.PRISMARINE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PRISMARINE_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PRISMARINE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PRISMARINE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PRISMARINE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PRISMARINE_BOOTS);

        itemModelGenerator.register(ModItems.WITHER_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_HOE, Models.HANDHELD);
    }
}
