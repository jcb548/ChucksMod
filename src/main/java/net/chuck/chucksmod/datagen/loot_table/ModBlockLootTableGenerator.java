package net.chuck.chucksmod.datagen.loot_table;

import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.custom.crop.*;
import net.chuck.chucksmod.block.custom.crop.magical.AbstractMagicalCropBlock;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SANDSTONE_BRICKS);
        addDrop(ModBlocks.SANDSTONE_BRICK_STAIRS);
        addDrop(ModBlocks.SANDSTONE_BRICK_SLAB, slabDrops(ModBlocks.SANDSTONE_BRICK_SLAB));
        addDrop(ModBlocks.SANDSTONE_BRICKS);
        addDrop(ModBlocks.CRACKED_SANDSTONE_BRICKS);

        addDrop(ModBlocks.COAL_DUST_BLOCK);
        addDrop(ModBlocks.IRON_DUST_BLOCK);
        addDrop(ModBlocks.COPPER_DUST_BLOCK);
        addDrop(ModBlocks.GOLD_DUST_BLOCK);
        addDrop(ModBlocks.PRISMARINE_DUST_BLOCK);
        addDrop(ModBlocks.PRISMARINE_IRON_DUST_BLOCK);
        addDrop(ModBlocks.OBSIDIAN_SAND);
        
        BlockStatePropertyLootCondition.Builder coalCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.COAL_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.COAL_CROP, magicCropDrops(ModBlocks.COAL_CROP, ModItems.COAL_ESSENCE,
                ModItems.COAL_SEEDS, coalCropBuilder, 0.1f, 1));
        
        BlockStatePropertyLootCondition.Builder ironCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.IRON_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.IRON_CROP, magicCropDrops(ModBlocks.IRON_CROP, ModItems.IRON_ESSENCE,
                ModItems.IRON_SEEDS, ironCropBuilder, 0.075f, 1));
        
        BlockStatePropertyLootCondition.Builder copperCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.COPPER_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.COPPER_CROP, magicCropDrops(ModBlocks.COPPER_CROP, ModItems.COPPER_ESSENCE,
                ModItems.COPPER_SEEDS, copperCropBuilder, 0.1f, 1));
        
        BlockStatePropertyLootCondition.Builder goldCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.GOLD_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.GOLD_CROP, magicCropDrops(ModBlocks.GOLD_CROP, ModItems.GOLD_ESSENCE,
                ModItems.GOLD_SEEDS, goldCropBuilder, 0.05f, 1));
        
        BlockStatePropertyLootCondition.Builder tinCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.TIN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.TIN_CROP, magicCropDrops(ModBlocks.TIN_CROP, ModItems.TIN_ESSENCE,
                ModItems.TIN_SEEDS, tinCropBuilder, 0.075f, 1));
        
        BlockStatePropertyLootCondition.Builder lapisCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.LAPIS_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.LAPIS_CROP, magicCropDrops(ModBlocks.LAPIS_CROP, ModItems.LAPIS_ESSENCE,
                ModItems.LAPIS_SEEDS, lapisCropBuilder, 0.1f, 1));
        
        BlockStatePropertyLootCondition.Builder redstoneCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.REDSTONE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.REDSTONE_CROP, magicCropDrops(ModBlocks.REDSTONE_CROP, ModItems.REDSTONE_ESSENCE,
                ModItems.REDSTONE_SEEDS, redstoneCropBuilder, 0.1f, 1));
        
        BlockStatePropertyLootCondition.Builder diamondCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.DIAMOND_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.DIAMOND_CROP, magicCropDrops(ModBlocks.DIAMOND_CROP, ModItems.DIAMOND_ESSENCE,
                ModItems.DIAMOND_SEEDS, diamondCropBuilder, 0.025f, 1));
        
        BlockStatePropertyLootCondition.Builder titaniumCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.TITANIUM_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.TITANIUM_CROP, magicCropDrops(ModBlocks.TITANIUM_CROP, ModItems.TITANIUM_ESSENCE,
                ModItems.TITANIUM_SEEDS, titaniumCropBuilder, 0.025f, 1));
        
        BlockStatePropertyLootCondition.Builder emeraldCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.EMERALD_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.EMERALD_CROP, magicCropDrops(ModBlocks.EMERALD_CROP, ModItems.EMERALD_ESSENCE,
                ModItems.EMERALD_SEEDS, emeraldCropBuilder, 0.05f, 1));

        addDrop(ModBlocks.HARDENED_GLASS);
        addDrop(ModBlocks.HARDENED_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_BLACK_GLASS);
        addDrop(ModBlocks.HARDENED_BLACK_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_BLUE_GLASS);
        addDrop(ModBlocks.HARDENED_BLUE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_BROWN_GLASS);
        addDrop(ModBlocks.HARDENED_BROWN_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_CYAN_GLASS);
        addDrop(ModBlocks.HARDENED_CYAN_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_GRAY_GLASS);
        addDrop(ModBlocks.HARDENED_GRAY_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_GREEN_GLASS);
        addDrop(ModBlocks.HARDENED_GREEN_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_LIGHT_GRAY_GLASS);
        addDrop(ModBlocks.HARDENED_LIGHT_GRAY_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_LIGHT_BLUE_GLASS);
        addDrop(ModBlocks.HARDENED_LIGHT_BLUE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_LIME_GLASS);
        addDrop(ModBlocks.HARDENED_LIME_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_MAGENTA_GLASS);
        addDrop(ModBlocks.HARDENED_MAGENTA_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_ORANGE_GLASS);
        addDrop(ModBlocks.HARDENED_ORANGE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_PINK_GLASS);
        addDrop(ModBlocks.HARDENED_PINK_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_PURPLE_GLASS);
        addDrop(ModBlocks.HARDENED_PURPLE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_RED_GLASS);
        addDrop(ModBlocks.HARDENED_RED_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_WHITE_GLASS);
        addDrop(ModBlocks.HARDENED_WHITE_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_YELLOW_GLASS);
        addDrop(ModBlocks.HARDENED_YELLOW_GLASS_PANE);
        addDrop(ModBlocks.HARDENED_TINTED_GLASS);

        addDrop(ModBlocks.TIN_DUST_BLOCK);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.RAW_TIN_BLOCK);
        addDrop(ModBlocks.TIN_BARS);
        addDrop(ModBlocks.TIN_ORE, oreDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, oreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.TIN_WIRE);

        addDrop(ModBlocks.BRONZE_BLOCK);
        addDrop(ModBlocks.BRONZE_DUST_BLOCK);
        addDrop(ModBlocks.BRONZE_BARS);

        addDrop(ModBlocks.TITANIUM_DUST_BLOCK);
        addDrop(ModBlocks.TITANIUM_BLOCK);
        addDrop(ModBlocks.RAW_TITANIUM_BLOCK);
        addDrop(ModBlocks.TITANIUM_BARS);
        addDrop(ModBlocks.TITANIUM_ORE, oreDrops(ModBlocks.TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.DEEPSLATE_TITANIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.NETHER_TITANIUM_ORE, oreDrops(ModBlocks.NETHER_TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.END_STONE_TITANIUM_ORE, oreDrops(ModBlocks.END_STONE_TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.TITANIUM_MACHINE_BASE);
        addDrop(ModBlocks.TITANIUM_ENERGY_STORAGE);
        addDrop(ModBlocks.TITANIUM_POWERED_FURNACE);
        addDrop(ModBlocks.TITANIUM_POWERED_CRUSHER);
        addDrop(ModBlocks.TITANIUM_HEAT_GENERATOR);
        addDrop(ModBlocks.TITANIUM_HARVESTER);
        addDrop(ModBlocks.TITANIUM_QUARRY);
        addDrop(ModBlocks.TITANIUM_COPIER);
        addDrop(ModBlocks.TITANIUM_FLUID_PIPE);
        addDrop(ModBlocks.TITANIUM_EXPERIENCE_DRAIN);
        addDrop(ModBlocks.TITANIUM_FLUID_TANK);
        addDrop(ModBlocks.TITANIUM_PUMP);
        addDrop(ModBlocks.TITANIUM_STEAM_GENERATOR);
        addDrop(ModBlocks.TITANIUM_LAVA_GENERATOR);

        BlockStatePropertyLootCondition.Builder netheriteCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.NETHERITE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.NETHERITE_CROP, magicCropDrops(ModBlocks.NETHERITE_CROP, ModItems.NETHERITE_ESSENCE,
                ModItems.NETHERITE_SEEDS, netheriteCropBuilder, 0.025f, 1));

        BlockStatePropertyLootCondition.Builder netherCrystalCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.NETHER_CRYSTAL_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.NETHER_CRYSTAL_CROP, magicCropDrops(ModBlocks.NETHER_CRYSTAL_CROP, ModItems.NETHER_CRYSTAL_SHARD,
                ModItems.NETHER_CRYSTAL_SEEDS, netherCrystalCropBuilder, 0.025f, 1));

        addDrop(ModBlocks.SOUL_STONE);
        addDrop(ModBlocks.SOUL_STONE_STAIRS);
        addDrop(ModBlocks.SOUL_STONE_SLAB, slabDrops(ModBlocks.SOUL_STONE_SLAB));
        addDrop(ModBlocks.SOUL_STONE_BRICKS);
        addDrop(ModBlocks.SOUL_STONE_BRICK_STAIRS);
        addDrop(ModBlocks.SOUL_STONE_BRICK_SLAB, slabDrops(ModBlocks.SOUL_STONE_BRICK_SLAB));
        addDrop(ModBlocks.SOUL_STONE_BRICKS);
        addDrop(ModBlocks.CRACKED_SOUL_STONE_BRICKS);

        BlockStatePropertyLootCondition.Builder triafiaCrystalCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.TRIAFIA_CRYSTAL_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.TRIAFIA_CRYSTAL_CROP, magicCropDrops(ModBlocks.TRIAFIA_CRYSTAL_CROP, ModItems.TRIAFIA_CRYSTAL_SHARD,
                ModItems.TRIAFIA_CRYSTAL_SEEDS, triafiaCrystalCropBuilder, 0.025f, 1));

        addDrop(ModBlocks.WHITE_CONCRETE_STAIRS);
        addDrop(ModBlocks.WHITE_CONCRETE_SLAB, slabDrops(ModBlocks.WHITE_CONCRETE_SLAB));
        addDrop(ModBlocks.WHITE_CONCRETE_WALL);
        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB, slabDrops(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB));
        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_WALL);
        addDrop(ModBlocks.GRAY_CONCRETE_STAIRS);
        addDrop(ModBlocks.GRAY_CONCRETE_SLAB, slabDrops(ModBlocks.GRAY_CONCRETE_SLAB));
        addDrop(ModBlocks.GRAY_CONCRETE_WALL);
        addDrop(ModBlocks.BLACK_CONCRETE_STAIRS);
        addDrop(ModBlocks.BLACK_CONCRETE_SLAB, slabDrops(ModBlocks.BLACK_CONCRETE_SLAB));
        addDrop(ModBlocks.BLACK_CONCRETE_WALL);
        addDrop(ModBlocks.BROWN_CONCRETE_STAIRS);
        addDrop(ModBlocks.BROWN_CONCRETE_SLAB, slabDrops(ModBlocks.BROWN_CONCRETE_SLAB));
        addDrop(ModBlocks.BROWN_CONCRETE_WALL);
        addDrop(ModBlocks.RED_CONCRETE_STAIRS);
        addDrop(ModBlocks.RED_CONCRETE_SLAB, slabDrops(ModBlocks.RED_CONCRETE_SLAB));
        addDrop(ModBlocks.RED_CONCRETE_WALL);
        addDrop(ModBlocks.ORANGE_CONCRETE_STAIRS);
        addDrop(ModBlocks.ORANGE_CONCRETE_SLAB, slabDrops(ModBlocks.ORANGE_CONCRETE_SLAB));
        addDrop(ModBlocks.ORANGE_CONCRETE_WALL);
        addDrop(ModBlocks.YELLOW_CONCRETE_STAIRS);
        addDrop(ModBlocks.YELLOW_CONCRETE_SLAB, slabDrops(ModBlocks.YELLOW_CONCRETE_SLAB));
        addDrop(ModBlocks.YELLOW_CONCRETE_WALL);
        addDrop(ModBlocks.LIME_CONCRETE_STAIRS);
        addDrop(ModBlocks.LIME_CONCRETE_SLAB, slabDrops(ModBlocks.LIME_CONCRETE_SLAB));
        addDrop(ModBlocks.LIME_CONCRETE_WALL);
        addDrop(ModBlocks.GREEN_CONCRETE_STAIRS);
        addDrop(ModBlocks.GREEN_CONCRETE_SLAB, slabDrops(ModBlocks.GREEN_CONCRETE_SLAB));
        addDrop(ModBlocks.GREEN_CONCRETE_WALL);
        addDrop(ModBlocks.CYAN_CONCRETE_STAIRS);
        addDrop(ModBlocks.CYAN_CONCRETE_SLAB, slabDrops(ModBlocks.CYAN_CONCRETE_SLAB));
        addDrop(ModBlocks.CYAN_CONCRETE_WALL);
        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB, slabDrops(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB));
        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_WALL);
        addDrop(ModBlocks.BLUE_CONCRETE_STAIRS);
        addDrop(ModBlocks.BLUE_CONCRETE_SLAB, slabDrops(ModBlocks.BLUE_CONCRETE_SLAB));
        addDrop(ModBlocks.BLUE_CONCRETE_WALL);
        addDrop(ModBlocks.PURPLE_CONCRETE_STAIRS);
        addDrop(ModBlocks.PURPLE_CONCRETE_SLAB, slabDrops(ModBlocks.PURPLE_CONCRETE_SLAB));
        addDrop(ModBlocks.PURPLE_CONCRETE_WALL);
        addDrop(ModBlocks.MAGENTA_CONCRETE_STAIRS);
        addDrop(ModBlocks.MAGENTA_CONCRETE_SLAB, slabDrops(ModBlocks.MAGENTA_CONCRETE_SLAB));
        addDrop(ModBlocks.MAGENTA_CONCRETE_WALL);
        addDrop(ModBlocks.PINK_CONCRETE_STAIRS);
        addDrop(ModBlocks.PINK_CONCRETE_SLAB, slabDrops(ModBlocks.PINK_CONCRETE_SLAB));
        addDrop(ModBlocks.PINK_CONCRETE_WALL);
        
        addDrop(ModBlocks.TUFF_STAIRS);
        addDrop(ModBlocks.TUFF_SLAB, slabDrops(ModBlocks.TUFF_SLAB));
        addDrop(ModBlocks.TUFF_WALL);
        
        addDrop(ModBlocks.ECLOGITE);
        addDrop(ModBlocks.ECLOGITE_STAIRS);
        addDrop(ModBlocks.ECLOGITE_SLAB, slabDrops(ModBlocks.ECLOGITE_SLAB));
        addDrop(ModBlocks.ECLOGITE_WALL);
        addDrop(ModBlocks.ECLOGITE_BRICKS);
        addDrop(ModBlocks.ECLOGITE_BRICK_STAIRS);
        addDrop(ModBlocks.ECLOGITE_BRICK_SLAB, slabDrops(ModBlocks.ECLOGITE_BRICK_SLAB));
        addDrop(ModBlocks.ECLOGITE_BRICK_WALL);
        addDrop(ModBlocks.CRACKED_ECLOGITE_BRICKS);
        addDrop(ModBlocks.POLISHED_ECLOGITE);
        addDrop(ModBlocks.POLISHED_ECLOGITE_STAIRS);
        addDrop(ModBlocks.POLISHED_ECLOGITE_SLAB, slabDrops(ModBlocks.POLISHED_ECLOGITE_SLAB));
        addDrop(ModBlocks.POLISHED_ECLOGITE_WALL);

        addDrop(ModBlocks.SERPENTINITE);
        addDrop(ModBlocks.SERPENTINITE_STAIRS);
        addDrop(ModBlocks.SERPENTINITE_SLAB, slabDrops(ModBlocks.SERPENTINITE_SLAB));
        addDrop(ModBlocks.SERPENTINITE_WALL);
        addDrop(ModBlocks.SERPENTINITE_BRICKS);
        addDrop(ModBlocks.SERPENTINITE_BRICK_STAIRS);
        addDrop(ModBlocks.SERPENTINITE_BRICK_SLAB, slabDrops(ModBlocks.SERPENTINITE_BRICK_SLAB));
        addDrop(ModBlocks.SERPENTINITE_BRICK_WALL);
        addDrop(ModBlocks.CRACKED_SERPENTINITE_BRICKS);
        addDrop(ModBlocks.POLISHED_SERPENTINITE);
        addDrop(ModBlocks.POLISHED_SERPENTINITE_STAIRS);
        addDrop(ModBlocks.POLISHED_SERPENTINITE_SLAB, slabDrops(ModBlocks.POLISHED_SERPENTINITE_SLAB));
        addDrop(ModBlocks.POLISHED_SERPENTINITE_WALL);

        addDrop(ModBlocks.GLAUCONITE);
        addDrop(ModBlocks.GLAUCONITE_STAIRS);
        addDrop(ModBlocks.GLAUCONITE_SLAB, slabDrops(ModBlocks.GLAUCONITE_SLAB));
        addDrop(ModBlocks.GLAUCONITE_WALL);
        addDrop(ModBlocks.GLAUCONITE_BRICKS);
        addDrop(ModBlocks.GLAUCONITE_BRICK_STAIRS);
        addDrop(ModBlocks.GLAUCONITE_BRICK_SLAB, slabDrops(ModBlocks.GLAUCONITE_BRICK_SLAB));
        addDrop(ModBlocks.GLAUCONITE_BRICK_WALL);
        addDrop(ModBlocks.CRACKED_GLAUCONITE_BRICKS);
        addDrop(ModBlocks.POLISHED_GLAUCONITE);
        addDrop(ModBlocks.POLISHED_GLAUCONITE_STAIRS);
        addDrop(ModBlocks.POLISHED_GLAUCONITE_SLAB, slabDrops(ModBlocks.POLISHED_GLAUCONITE_SLAB));
        addDrop(ModBlocks.POLISHED_GLAUCONITE_WALL);

        addDrop(ModBlocks.SERPENTINITE_COAL_ORE, oreDrops(ModBlocks.SERPENTINITE_COAL_ORE, Items.COAL));
        addDrop(ModBlocks.SERPENTINITE_COPPER_ORE, copperOreDrops(ModBlocks.SERPENTINITE_COPPER_ORE));
        addDrop(ModBlocks.SERPENTINITE_DIAMOND_ORE, oreDrops(ModBlocks.SERPENTINITE_DIAMOND_ORE, Items.DIAMOND));
        addDrop(ModBlocks.SERPENTINITE_PACSARIUM_ORE, oreDrops(ModBlocks.SERPENTINITE_PACSARIUM_ORE, ModItems.RAW_PACSARIUM));
        addDrop(ModBlocks.SERPENTINITE_EMERALD_ORE, oreDrops(ModBlocks.SERPENTINITE_EMERALD_ORE, Items.EMERALD));
        addDrop(ModBlocks.SERPENTINITE_TRIAFIUM_ORE, oreDrops(ModBlocks.SERPENTINITE_TRIAFIUM_ORE, ModItems.RAW_TRIAFIUM));
        addDrop(ModBlocks.SERPENTINITE_GOLD_ORE, oreDrops(ModBlocks.SERPENTINITE_GOLD_ORE, Items.RAW_GOLD));
        addDrop(ModBlocks.SERPENTINITE_IRON_ORE, oreDrops(ModBlocks.SERPENTINITE_IRON_ORE, Items.RAW_IRON));
        addDrop(ModBlocks.SERPENTINITE_LAPIS_ORE, lapisOreDrops(ModBlocks.SERPENTINITE_LAPIS_ORE));
        addDrop(ModBlocks.SERPENTINITE_REDSTONE_ORE, redstoneOreDrops(ModBlocks.SERPENTINITE_REDSTONE_ORE));
        addDrop(ModBlocks.SERPENTINITE_TIN_ORE, oreDrops(ModBlocks.SERPENTINITE_TIN_ORE, ModItems.RAW_TIN));
        addDrop(ModBlocks.SERPENTINITE_TITANIUM_ORE, oreDrops(ModBlocks.SERPENTINITE_TITANIUM_ORE, ModItems.RAW_TITANIUM));
        addDrop(ModBlocks.SERPENTINITE_QUARTZ_ORE, oreDrops(ModBlocks.SERPENTINITE_QUARTZ_ORE, Items.QUARTZ));

        addDrop(ModBlocks.TRIAFIA_SAPLING);
        addDrop(ModBlocks.TRIAFIA_LOG);
        addDrop(ModBlocks.TRIAFIA_WOOD);
        addDrop(ModBlocks.STRIPPED_TRIAFIA_LOG);
        addDrop(ModBlocks.STRIPPED_TRIAFIA_WOOD);
        addDrop(ModBlocks.TRIAFIA_LEAVES, leavesDrops(ModBlocks.TRIAFIA_LEAVES, ModBlocks.TRIAFIA_SAPLING,
                0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f));
        addDrop(ModBlocks.TRIAFIA_BUTTON);
        addDrop(ModBlocks.TRIAFIA_DOOR, doorDrops(ModBlocks.TRIAFIA_DOOR));
        addDrop(ModBlocks.TRIAFIA_TRAPDOOR);
        addDrop(ModBlocks.TRIAFIA_FENCE);
        addDrop(ModBlocks.TRIAFIA_FENCE_GATE);
        addDrop(ModBlocks.TRIAFIA_PRESSURE_PLATE);
        addDrop(ModBlocks.TRIAFIA_STAIRS);
        addDrop(ModBlocks.TRIAFIA_SLAB, slabDrops(ModBlocks.TRIAFIA_SLAB));
        addDrop(ModBlocks.TRIAFIA_PLANT, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(WITH_SILK_TOUCH_OR_SHEARS)
                        .with(ItemEntry.builder(ModBlocks.TRIAFIA_PLANT))
                ).pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with(ItemEntry.builder(ModItems.LETTUCE_SEEDS))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
                ).pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with(ItemEntry.builder(ModItems.TOMATO_SEEDS))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
                ).pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with(ItemEntry.builder(ModItems.PINEAPPLE_SEEDS))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
                ));
        addDrop(ModBlocks.TRIAFIAN_VINE, dropsWithShears(ModBlocks.TRIAFIAN_VINE));
        
        addDrop(ModBlocks.RAW_TRIAFIUM_BLOCK);
        addDrop(ModBlocks.TRIAFIUM_BLOCK);
        addDrop(ModBlocks.TRIAFIUM_BARS);
        addDrop(ModBlocks.NETHER_TRIAFIUM_ORE, oreDrops(ModBlocks.NETHER_TRIAFIUM_ORE, ModItems.RAW_TRIAFIUM));
        addDrop(ModBlocks.END_STONE_TRIAFIUM_ORE, oreDrops(ModBlocks.END_STONE_TRIAFIUM_ORE, ModItems.RAW_TRIAFIUM));
        addDrop(ModBlocks.DEEPSLATE_TRIAFIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_TRIAFIUM_ORE, ModItems.RAW_TRIAFIUM));
        BlockStatePropertyLootCondition.Builder triafiumCropBuilder = BlockStatePropertyLootCondition.builder
                (ModBlocks.TRIAFIUM_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(AbstractMagicalCropBlock.AGE, AbstractMagicalCropBlock.MAX_AGE));
        addDrop(ModBlocks.TRIAFIUM_CROP, magicCropDrops(ModBlocks.TRIAFIUM_CROP, ModItems.TRIAFIUM_ESSENCE,
                ModItems.TRIAFIUM_SEEDS, triafiumCropBuilder, 0.025f, 1));
        addDrop(ModBlocks.TRIAFIUM_PORTAL_BLOCK);
        addDrop(ModBlocks.TRIAFIUM_MACHINE_BASE);
        addDrop(ModBlocks.TRIAFIUM_ENERGY_STORAGE);
        addDrop(ModBlocks.TRIAFIUM_POWERED_CRUSHER);
        addDrop(ModBlocks.TRIAFIUM_POWERED_FURNACE);
        addDrop(ModBlocks.TRIAFIUM_HEAT_GENERATOR);
        addDrop(ModBlocks.TRIAFIUM_PUMP);
        addDrop(ModBlocks.TRIAFIUM_FLUID_PIPE);
        addDrop(ModBlocks.TRIAFIUM_EXPERIENCE_DRAIN);
        addDrop(ModBlocks.TRIAFIUM_FLUID_TANK);
        addDrop(ModBlocks.TRIAFIUM_STEAM_GENERATOR);
        addDrop(ModBlocks.TRIAFIUM_HARVESTER);
        addDrop(ModBlocks.TRIAFIUM_QUARRY);
        addDrop(ModBlocks.TRIAFIUM_LAVA_GENERATOR);
        addDrop(ModBlocks.TRIAFIUM_COPIER);
        addDrop(ModBlocks.TRIAFIUM_PORTAL_BUILDER);

        addDrop(ModBlocks.RAW_PACSARIUM_BLOCK);
        addDrop(ModBlocks.PACSARIUM_BLOCK);
        addDrop(ModBlocks.PACSARIUM_BARS);
        addDrop(ModBlocks.END_STONE_PACSARIUM_ORE, oreDrops(ModBlocks.END_STONE_PACSARIUM_ORE,
                ModItems.RAW_PACSARIUM));
        addDrop(ModBlocks.DEEPSLATE_PACSARIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_PACSARIUM_ORE,
                ModItems.RAW_PACSARIUM));

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

        addDrop(ModBlocks.PACSARIA_SAPLING);
        addDrop(ModBlocks.PACSARIA_LOG);
        addDrop(ModBlocks.PACSARIA_WOOD);
        addDrop(ModBlocks.STRIPPED_PACSARIA_LOG);
        addDrop(ModBlocks.STRIPPED_PACSARIA_WOOD);
        addDrop(ModBlocks.PACSARIA_LEAVES, leavesDrops(ModBlocks.PACSARIA_LEAVES, ModBlocks.PACSARIA_SAPLING,
                0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f));
        addDrop(ModBlocks.PACSARIA_BUTTON);
        addDrop(ModBlocks.PACSARIA_DOOR, doorDrops(ModBlocks.PACSARIA_DOOR));
        addDrop(ModBlocks.PACSARIA_TRAPDOOR);
        addDrop(ModBlocks.PACSARIA_FENCE);
        addDrop(ModBlocks.PACSARIA_FENCE_GATE);
        addDrop(ModBlocks.PACSARIA_PRESSURE_PLATE);
        addDrop(ModBlocks.PACSARIA_STAIRS);
        addDrop(ModBlocks.PACSARIA_SLAB, slabDrops(ModBlocks.PACSARIA_SLAB));
        addDrop(ModBlocks.PACSARIA_PLANT, grassDrops(ModBlocks.PACSARIA_PLANT));
        addDrop(ModBlocks.PACSARIA_LIGHT_PLANT);

        addDrop(ModBlocks.IRON_MACHINE_BASE);
        addDrop(ModBlocks.CRUSHER);
        addDrop(ModBlocks.IRON_POWERED_CRUSHER);
        addDrop(ModBlocks.IRON_POWERED_FURNACE);
        addDrop(ModBlocks.IRON_HEAT_GENERATOR);
        addDrop(ModBlocks.IRON_HARVESTER);
        addDrop(ModBlocks.IRON_QUARRY);
        addDrop(ModBlocks.IRON_ENERGY_STORAGE);
        addDrop(ModBlocks.IRON_FLUID_TANK);
        addDrop(ModBlocks.IRON_PUMP);
        addDrop(ModBlocks.IRON_FLUID_PIPE);
        addDrop(ModBlocks.IRON_EXPERIENCE_DRAIN);
        addDrop(ModBlocks.IRON_STEAM_GENERATOR);

        addDrop(ModBlocks.COPPER_WIRE);
        addDrop(ModBlocks.GOLD_WIRE);

        BlockStatePropertyLootCondition.Builder tomatoCropBuilder = BlockStatePropertyLootCondition.builder
                        (ModBlocks.TOMATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, TomatoCropBlock.MAX_AGE));
        addDrop(ModBlocks.TOMATO_CROP, cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS,
                tomatoCropBuilder));

        BlockStatePropertyLootCondition.Builder lettuceCropBuilder = BlockStatePropertyLootCondition.builder
                        (ModBlocks.LETTUCE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(LettuceCropBlock.AGE, LettuceCropBlock.MAX_AGE));
        addDrop(ModBlocks.LETTUCE_CROP, cropDrops(ModBlocks.LETTUCE_CROP, ModItems.LETTUCE, ModItems.LETTUCE_SEEDS,
                lettuceCropBuilder));

        BlockStatePropertyLootCondition.Builder pineappleCropBuilder = BlockStatePropertyLootCondition.builder
                        (ModBlocks.PINEAPPLE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(PineappleCropBlock.AGE, PineappleCropBlock.MAX_AGE));
        addDrop(ModBlocks.PINEAPPLE_CROP, cropDrops(ModBlocks.PINEAPPLE_CROP, ModItems.PINEAPPLE, ModItems.PINEAPPLE_SEEDS,
                pineappleCropBuilder));
    }
    public LootTable.Builder magicCropDrops(Block crop, Item product, Item seeds, LootCondition.Builder condition,
                                                   float probability, int extra) {
        return this.applyExplosionDecay(crop,
                LootTable.builder().pool(LootPool.builder()
                        .with((ItemEntry.builder(product).conditionally(condition))
                                .alternatively(ItemEntry.builder(seeds))))
                        .pool(LootPool.builder()
                                .conditionally(condition)
                                .with((ItemEntry.builder(seeds).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, probability, extra))))));
    }
}
