package net.chuck.chucksmod.datagen.models;

import com.ibm.icu.text.Normalizer2;
import dev.architectury.platform.Mod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.custom.LettuceCropBlock;
import net.chuck.chucksmod.block.custom.PineappleCropBlock;
import net.chuck.chucksmod.block.custom.TomatoCropBlock;
import net.chuck.chucksmod.fluid.ModFluids;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;

import static net.chuck.chucksmod.datagen.models.ModModelGenerator.registerVerticalColumn;

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
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.COPPER_BARS);
        ModModelGenerator.registerWire(blockStateModelGenerator, ModBlocks.COPPER_WIRE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_DUST_BLOCK);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.GOLD_BARS);
        ModModelGenerator.registerWire(blockStateModelGenerator, ModBlocks.GOLD_WIRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_DUST_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.PRISMARINE_BARS);
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
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.TIN_BARS);
        ModModelGenerator.registerWire(blockStateModelGenerator, ModBlocks.TIN_WIRE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_DUST_BLOCK);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.BRONZE_BARS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_DUST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TITANIUM_ORE);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.TITANIUM_BARS);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_POWERED_CRUSHER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_POWERED_FURNACE, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_HEAT_GENERATOR, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_QUARRY, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_COPIER, TexturedModel.ORIENTABLE);
        ModModelGenerator.registerVerticalColumn(blockStateModelGenerator, ModBlocks.TITANIUM_FLUID_TANK);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_PUMP, TexturedModel.ORIENTABLE);
        ModModelGenerator.registerPipe(blockStateModelGenerator, ModBlocks.TITANIUM_FLUID_PIPE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_STEAM_GENERATOR, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.TITANIUM_LAVA_GENERATOR, TexturedModel.ORIENTABLE);

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

        BlockStateModelGenerator.BlockTexturePool tuff_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.TUFF);
        tuff_pool.stairs(ModBlocks.TUFF_STAIRS);
        tuff_pool.slab(ModBlocks.TUFF_SLAB);
        tuff_pool.wall(ModBlocks.TUFF_WALL);
        
        BlockStateModelGenerator.BlockTexturePool eclogite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ECLOGITE);
        eclogite_pool.stairs(ModBlocks.ECLOGITE_STAIRS);
        eclogite_pool.slab(ModBlocks.ECLOGITE_SLAB);
        eclogite_pool.wall(ModBlocks.ECLOGITE_WALL);
        BlockStateModelGenerator.BlockTexturePool eclogite_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ECLOGITE_BRICKS);
        eclogite_bricks_pool.stairs(ModBlocks.ECLOGITE_BRICK_STAIRS);
        eclogite_bricks_pool.slab(ModBlocks.ECLOGITE_BRICK_SLAB);
        eclogite_bricks_pool.wall(ModBlocks.ECLOGITE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_ECLOGITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polished_eclogite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_ECLOGITE);
        polished_eclogite_pool.stairs(ModBlocks.POLISHED_ECLOGITE_STAIRS);
        polished_eclogite_pool.slab(ModBlocks.POLISHED_ECLOGITE_SLAB);
        polished_eclogite_pool.wall(ModBlocks.POLISHED_ECLOGITE_WALL);

        BlockStateModelGenerator.BlockTexturePool serpentinite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SERPENTINITE);
        serpentinite_pool.stairs(ModBlocks.SERPENTINITE_STAIRS);
        serpentinite_pool.slab(ModBlocks.SERPENTINITE_SLAB);
        serpentinite_pool.wall(ModBlocks.SERPENTINITE_WALL);
        BlockStateModelGenerator.BlockTexturePool serpentinite_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SERPENTINITE_BRICKS);
        serpentinite_bricks_pool.stairs(ModBlocks.SERPENTINITE_BRICK_STAIRS);
        serpentinite_bricks_pool.slab(ModBlocks.SERPENTINITE_BRICK_SLAB);
        serpentinite_bricks_pool.wall(ModBlocks.SERPENTINITE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SERPENTINITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polished_serpentinite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_SERPENTINITE);
        polished_serpentinite_pool.stairs(ModBlocks.POLISHED_SERPENTINITE_STAIRS);
        polished_serpentinite_pool.slab(ModBlocks.POLISHED_SERPENTINITE_SLAB);
        polished_serpentinite_pool.wall(ModBlocks.POLISHED_SERPENTINITE_WALL);

        BlockStateModelGenerator.BlockTexturePool glauconite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLAUCONITE);
        glauconite_pool.stairs(ModBlocks.GLAUCONITE_STAIRS);
        glauconite_pool.slab(ModBlocks.GLAUCONITE_SLAB);
        glauconite_pool.wall(ModBlocks.GLAUCONITE_WALL);
        BlockStateModelGenerator.BlockTexturePool glauconite_bricks_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLAUCONITE_BRICKS);
        glauconite_bricks_pool.stairs(ModBlocks.GLAUCONITE_BRICK_STAIRS);
        glauconite_bricks_pool.slab(ModBlocks.GLAUCONITE_BRICK_SLAB);
        glauconite_bricks_pool.wall(ModBlocks.GLAUCONITE_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_GLAUCONITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polished_glauconite_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_GLAUCONITE);
        polished_glauconite_pool.stairs(ModBlocks.POLISHED_GLAUCONITE_STAIRS);
        polished_glauconite_pool.slab(ModBlocks.POLISHED_GLAUCONITE_SLAB);
        polished_glauconite_pool.wall(ModBlocks.POLISHED_GLAUCONITE_WALL);

        blockStateModelGenerator.registerSingleton(ModBlocks.TRIAFIA_LEAVES, TexturedModel.LEAVES);
        BlockStateModelGenerator.LogTexturePool triafia_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.TRIAFIA_LOG);
        triafia_log_pool.log(ModBlocks.TRIAFIA_LOG);
        triafia_log_pool.wood(ModBlocks.TRIAFIA_WOOD);
        BlockStateModelGenerator.LogTexturePool stripped_triafia_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_TRIAFIA_LOG);
        stripped_triafia_log_pool.log(ModBlocks.STRIPPED_TRIAFIA_LOG);
        stripped_triafia_log_pool.wood(ModBlocks.STRIPPED_TRIAFIA_WOOD);

        BlockStateModelGenerator.BlockTexturePool triafia_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TRIAFIA_PLANKS);
        triafia_pool.stairs(ModBlocks.TRIAFIA_STAIRS);
        triafia_pool.slab(ModBlocks.TRIAFIA_SLAB);
        triafia_pool.fence(ModBlocks.TRIAFIA_FENCE);
        triafia_pool.fenceGate(ModBlocks.TRIAFIA_FENCE_GATE);
        triafia_pool.button(ModBlocks.TRIAFIA_BUTTON);
        triafia_pool.pressurePlate(ModBlocks.TRIAFIA_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.TRIAFIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TRIAFIA_TRAPDOOR);
        triafia_pool.family(ModBlocks.TRIAFIA_FAMILY);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TRIAFIA_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TRIAFIA_PLANT,
                BlockStateModelGenerator.TintType.TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIAFIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TRIAFIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TRIAFIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_TRIAFIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TRIAFIUM_ORE);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.TRIAFIUM_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIAFIUM_PORTAL_BLOCK);
        blockStateModelGenerator.registerCooker(ModBlocks.TRIAFIUM_PORTAL_BUILDER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_COPPER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_PACSARIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_EMERALD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_TRIAFIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_GOLD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_LAPIS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_REDSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleState(ModBlocks.PIPPIN_ALTAR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACSARIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PACSARIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_PACSARIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PACSARIUM_ORE);
        ModModelGenerator.registerBars(blockStateModelGenerator, ModBlocks.PACSARIUM_BARS);

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

        blockStateModelGenerator.registerTintableCross(ModBlocks.PACSARIA_PLANT,
                BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PACSARIA_LIGHT_PLANT,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PACSARIA_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.LogTexturePool pacsaria_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.PACSARIA_LOG);
        pacsaria_log_pool.log(ModBlocks.PACSARIA_LOG);
        pacsaria_log_pool.wood(ModBlocks.PACSARIA_WOOD);
        BlockStateModelGenerator.LogTexturePool stripped_pacsaria_log_pool =
                blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PACSARIA_LOG);
        stripped_pacsaria_log_pool.log(ModBlocks.STRIPPED_PACSARIA_LOG);
        stripped_pacsaria_log_pool.wood(ModBlocks.STRIPPED_PACSARIA_WOOD);

        BlockStateModelGenerator.BlockTexturePool pacsaria_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PACSARIA_PLANKS);
        pacsaria_pool.stairs(ModBlocks.PACSARIA_STAIRS);
        pacsaria_pool.slab(ModBlocks.PACSARIA_SLAB);
        pacsaria_pool.fence(ModBlocks.PACSARIA_FENCE);
        pacsaria_pool.fenceGate(ModBlocks.PACSARIA_FENCE_GATE);
        pacsaria_pool.button(ModBlocks.PACSARIA_BUTTON);
        pacsaria_pool.pressurePlate(ModBlocks.PACSARIA_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.PACSARIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PACSARIA_TRAPDOOR);
        pacsaria_pool.family(ModBlocks.PACSARIA_FAMILY);

        blockStateModelGenerator.registerCooker(ModBlocks.CRUSHER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_POWERED_CRUSHER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_POWERED_FURNACE, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_HEAT_GENERATOR, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_QUARRY, TexturedModel.ORIENTABLE);
        ModModelGenerator.registerVerticalColumn(blockStateModelGenerator, ModBlocks.IRON_FLUID_TANK);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_PUMP, TexturedModel.ORIENTABLE);
        ModModelGenerator.registerPipe(blockStateModelGenerator, ModBlocks.IRON_FLUID_PIPE);
        blockStateModelGenerator.registerCooker(ModBlocks.IRON_STEAM_GENERATOR, TexturedModel.ORIENTABLE);


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
        blockStateModelGenerator.registerParentedItemModel(ModItems.FARMABYN_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.TRIAFIAN_PIG_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WRENCH, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_DUST, Models.GENERATED);

        itemModelGenerator.register(ModItems.IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_ENERGY_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_AXLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_MOTOR, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.IRON_FLUID_PIPE.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_POWER_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_COIL, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.COPPER_WIRE.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.GOLD_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_POWER_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIL, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.GOLD_WIRE.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.TIN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.TIN_WIRE.asItem(), Models.GENERATED);

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
        itemModelGenerator.register(ModItems.TITANIUM_AXLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_MOTOR, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.TITANIUM_FLUID_PIPE.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.SOUL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLAZE_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_BLAZE_ROD, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_TRIAFIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TRIAFIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TRIAFIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TRIAFIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TRIAFIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TRIAFIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TRIAFIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TRIAFIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.TRIAFIUM_BOOTS);
        itemModelGenerator.register(ModItems.TRIAFIA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIA_CRYSTAL_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIA_CRYSTAL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIAN_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_TRIAFIAN_PORKCHOP, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_PACSARIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIUM_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PACSARIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PACSARIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PACSARIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PACSARIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PACSARIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PACSARIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PACSARIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PACSARIUM_BOOTS);
        itemModelGenerator.register(ModItems.PACSARIA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIA_CRYSTAL_SHARD, Models.GENERATED);

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
        itemModelGenerator.register(ModItems.TRIAFIUM_BAG, Models.GENERATED);

        itemModelGenerator.register(ModItems.HANGING_EUCALYPTUS_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.EUCALYPTUS_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EUCALYPTUS_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HANGING_PACSARIA_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACSARIA_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HANGING_TRIAFIA_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIAFIA_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModFluids.LIQUID_XP_BUCKET, Models.GENERATED);
    }
}
