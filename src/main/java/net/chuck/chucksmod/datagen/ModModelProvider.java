package net.chuck.chucksmod.datagen;

import dev.architectury.platform.Mod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.custom.LettuceCropBlock;
import net.chuck.chucksmod.block.custom.PineappleCropBlock;
import net.chuck.chucksmod.block.custom.TomatoCropBlock;
import net.chuck.chucksmod.fluid.ModFluids;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;

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
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.LETTUCE_CROP, LettuceCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.PINEAPPLE_CROP, PineappleCropBlock.AGE,
                0, 1, 2, 3, 4, 5, 6, 7, 8);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRON_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COPPER_DUST_BLOCK);
        blockStateModelGenerator.registerItemModel(ModBlocks.COPPER_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_DUST_BLOCK);
        blockStateModelGenerator.registerItemModel(ModBlocks.GOLD_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);
        blockStateModelGenerator.registerItemModel(ModBlocks.PRISMARINE_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OBSIDIAN_SAND);

        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_GLASS, ModBlocks.HARDENED_GLASS_PANE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HARDENED_TINTED_GLASS);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_BLACK_GLASS, 
                ModBlocks.HARDENED_BLACK_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_BLUE_GLASS,
                ModBlocks.HARDENED_BLUE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_BROWN_GLASS,
                ModBlocks.HARDENED_BROWN_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_CYAN_GLASS,
                ModBlocks.HARDENED_CYAN_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_GRAY_GLASS,
                ModBlocks.HARDENED_GRAY_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_GREEN_GLASS,
                ModBlocks.HARDENED_GREEN_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_LIGHT_BLUE_GLASS,
                ModBlocks.HARDENED_LIGHT_BLUE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_LIGHT_GRAY_GLASS,
                ModBlocks.HARDENED_LIGHT_GRAY_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_LIME_GLASS,
                ModBlocks.HARDENED_LIME_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_MAGENTA_GLASS,
                ModBlocks.HARDENED_MAGENTA_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_ORANGE_GLASS,
                ModBlocks.HARDENED_ORANGE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_PINK_GLASS,
                ModBlocks.HARDENED_PINK_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_PURPLE_GLASS,
                ModBlocks.HARDENED_PURPLE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_RED_GLASS,
                ModBlocks.HARDENED_RED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_WHITE_GLASS,
                ModBlocks.HARDENED_WHITE_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.HARDENED_YELLOW_GLASS, 
                ModBlocks.HARDENED_YELLOW_GLASS_PANE);
        
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerItemModel(ModBlocks.TIN_BARS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_DUST_BLOCK);
        blockStateModelGenerator.registerItemModel(ModBlocks.BRONZE_BARS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TITANIUM_ORE);
        blockStateModelGenerator.registerItemModel(ModBlocks.TITANIUM_BARS);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_POWERED_CRUSHER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_POWERED_FURNACE, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_HEAT_GENERATOR, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_QUARRY, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_COPIER, TexturedModel.ORIENTABLE);
        registerVerticalColumn(blockStateModelGenerator, ModBlocks.TITANIUM_FLUID_TANK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUL_GRAVEL);
        BlockStateModelGenerator.BlockTexturePool soul_stone_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SOUL_STONE);
        soul_stone_pool.stairs(ModBlocks.SOUL_STONE_STAIRS);
        soul_stone_pool.slab(ModBlocks.SOUL_STONE_SLAB);
        BlockStateModelGenerator.BlockTexturePool soul_stone_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SOUL_STONE_BRICKS);
        soul_stone_bricks_pool.stairs(ModBlocks.SOUL_STONE_BRICK_STAIRS);
        soul_stone_bricks_pool.slab(ModBlocks.SOUL_STONE_BRICK_SLAB);
        soul_stone_bricks_pool.wall(ModBlocks.SOUL_STONE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SOUL_STONE_BRICKS);
        blockStateModelGenerator.registerSimpleState(ModBlocks.SOUL_BLAZE_ALTAR);

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
        eucalyptus_pool.family(ModBlocks.EUCALYPTUS_FAMILY);

        blockStateModelGenerator.registerTintableCross(ModBlocks.DIRITIA_PLANT,
                BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.DIRITIA_LIGHT_PLANT,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.DIRITIA_SAPLING,
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
        diritia_pool.stairs(ModBlocks.DIRITIA_STAIRS);
        diritia_pool.slab(ModBlocks.DIRITIA_SLAB);
        diritia_pool.fence(ModBlocks.DIRITIA_FENCE);
        diritia_pool.fenceGate(ModBlocks.DIRITIA_FENCE_GATE);
        diritia_pool.button(ModBlocks.DIRITIA_BUTTON);
        diritia_pool.pressurePlate(ModBlocks.DIRITIA_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.DIRITIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.DIRITIA_TRAPDOOR);
        diritia_pool.family(ModBlocks.DIRITIA_FAMILY);

        blockStateModelGenerator.registerCooker(ModBlocks.CRUSHER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_POWERED_CRUSHER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_POWERED_FURNACE, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_HEAT_GENERATOR, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_QUARRY, TexturedModel.ORIENTABLE);
        registerVerticalColumn(blockStateModelGenerator, ModBlocks.IRON_FLUID_TANK);


        BlockStateModelGenerator.BlockTexturePool sandstone_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SANDSTONE_BRICKS);
        sandstone_bricks_pool.stairs(ModBlocks.SANDSTONE_BRICK_STAIRS);
        sandstone_bricks_pool.slab(ModBlocks.SANDSTONE_BRICK_SLAB);
        sandstone_bricks_pool.wall(ModBlocks.SANDSTONE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SANDSTONE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FRANK_ALTAR);

        blockStateModelGenerator.registerParentedItemModel(ModItems.SOUL_BLAZE_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.WYATT_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.FRANK_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STONE_DUST, Models.GENERATED);

        itemModelGenerator.register(ModItems.IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_ENERGY_CORE, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_POWER_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_COIL, Models.GENERATED);

        itemModelGenerator.register(ModItems.GOLD_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_POWER_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIL, Models.GENERATED);

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

        itemModelGenerator.register(ModItems.RAW_TITANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TITANIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TITANIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TITANIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TITANIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TITANIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TITANIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TITANIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TITANIUM_BOOTS);
        itemModelGenerator.register(ModItems.TITANIUM_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_ENERGY_CORE, Models.GENERATED);

        itemModelGenerator.register(ModItems.SOUL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLAZE_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_BLAZE_ROD, Models.GENERATED);

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

        itemModelGenerator.register(ModItems.HAMBURGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINEAPPLE, Models.GENERATED);

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

        itemModelGenerator.register(ModItems.OBSIDIAN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.PORTABLE_ENDERCHEST, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRING_STRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEATHER_STRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOOL_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEATHER_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABIUM_BAG, Models.GENERATED);

        itemModelGenerator.register(ModItems.HANGING_EUCALYPTUS_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.EUCALYPTUS_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EUCALYPTUS_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HANGING_DIRITIA_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRITIA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRITIA_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModFluids.LIQUID_XP_BUCKET, Models.GENERATED);
    }
    private static void registerVerticalColumn(BlockStateModelGenerator blockStateModelGenerator, Block block){
        TextureMap map =  new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getId(block))
                .put(TextureKey.UP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.DOWN, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.SIDE, TextureMap.getId(block));
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block,
                Models.CUBE.upload(block, map, blockStateModelGenerator.modelCollector)));
    }
}
