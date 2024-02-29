package net.chuck.chucksmod.datagen;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.*;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModChestLootTableGenerator extends SimpleFabricLootTableProvider {
    //
    public static final Identifier PACSARIA_HOUSE = new Identifier(ChucksMod.MOD_ID, "chests/pacsaria_house");
    // /setblock ~ ~ ~ minecraft:chest{LootTable:"chucksmod:chests/pacsaria_dungeon"}
    public static final Identifier PACSARIA_DUNGEON = new Identifier(ChucksMod.MOD_ID, "chests/pacsaria_dungeon");
    // /setblock ~ ~ ~ minecraft:chest{LootTable:"chucksmod:chests/pacsaria_library"}
    public static final Identifier PACSARIA_LIBRARY = new Identifier(ChucksMod.MOD_ID, "chests/pacsaria_library");
    // /setblock ~ ~ ~ minecraft:chest{LootTable:"chucksmod:chests/pacsaria_armoury"}
    public static final Identifier PACSARIA_ARMOURY = new Identifier(ChucksMod.MOD_ID, "chests/pacsaria_armoury");
    public static final Identifier GUNPOWDER = new Identifier(ChucksMod.MOD_ID, "chests/gunpowder");
    public static final Identifier SUGAR_CANE = new Identifier(ChucksMod.MOD_ID, "chests/sugar_cane");
    // /setblock ~ ~ ~ minecraft:chest{LootTable:"chucksmod:chests/chuck_house_resources"}
    public static final Identifier CHUCK_HOUSE_RESOURCES = new Identifier(ChucksMod.MOD_ID,
            "chests/chuck_house_resources");
    public static final Identifier CHUCK_HOUSE_BLOCKS = new Identifier(ChucksMod.MOD_ID,
            "chests/chuck_house_blocks");
    public static final Identifier TRIAFIA_CASTLE_LOOT = new Identifier(ChucksMod.MOD_ID,
            "chests/triafia_castle_loot");
    public ModChestLootTableGenerator(FabricDataOutput output) {
        super(output, LootContextTypes.CHEST);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        // /setblock ~ ~ ~ minecraft:chest{LootTable:"chucksmod:chests/pacsaria_house"}
        exporter.accept(PACSARIA_HOUSE, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(15))
                    .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(5))
                    .with(ItemEntry.builder(ModItems.PACSARIA_CRYSTAL_SHARD).weight(10))
                    .with(ItemEntry.builder(ModItems.PACSARIUM_INGOT).weight(10))
                    .with(ItemEntry.builder(Items.NAME_TAG).weight(20))
                    .with(ItemEntry.builder(Items.BOOK).weight(30))
                        .apply(EnchantWithLevelsLootFunction.builder(UniformLootNumberProvider.create(20.0f, 39.0f))))
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0f, 4.0f))
                    .with(ItemEntry.builder(Items.REDSTONE).weight(15))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 16.0f)))
                    .with(ItemEntry.builder(Items.POTION).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))))
                        .apply(SetPotionLootFunction.builder(Potions.STRONG_REGENERATION))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0f))
                    .with(ItemEntry.builder(Items.IRON_INGOT).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.GOLD_INGOT).weight(5))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                    .with(ItemEntry.builder(Items.COPPER_INGOT).weight(15))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.PRISMARINE_INGOT).weight(5))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.BRONZE_INGOT).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.TIN_INGOT).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                    .with(ItemEntry.builder(ModItems.HAMBURGER).weight(20))
                    .with(ItemEntry.builder(Items.QUARTZ).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 12.0f)))
                    .with(ItemEntry.builder(Items.COAL).weight(15))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.RAW_PACSARIUM).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.BONE).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.BLAZE_POWDER).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))));
        exporter.accept(PACSARIA_DUNGEON, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(5))
                    .with(ItemEntry.builder(ModItems.PACSARIUM_INGOT).weight(10))
                    .with(ItemEntry.builder(Items.NAME_TAG).weight(20))
                    .with(ItemEntry.builder(Items.BOOK).weight(30))
                        .apply(EnchantWithLevelsLootFunction.builder(UniformLootNumberProvider.create(20.0f, 39.0f))))
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0f, 4.0f))
                    .with(ItemEntry.builder(Items.REDSTONE).weight(15))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 16.0f)))
                    .with(ItemEntry.builder(Items.POTION).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))))
                        .apply(SetPotionLootFunction.builder(Potions.STRONG_REGENERATION))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0f))
                    .with(ItemEntry.builder(Items.IRON_INGOT).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.PACSARIA_CRYSTAL_SHARD).weight(20))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)))
                    .with(ItemEntry.builder(Items.GOLD_INGOT).weight(5))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                    .with(ItemEntry.builder(Items.COPPER_INGOT).weight(15))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.PRISMARINE_INGOT).weight(5))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.BRONZE_INGOT).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.TIN_INGOT).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                    .with(ItemEntry.builder(ModItems.HAMBURGER).weight(20))
                    .with(ItemEntry.builder(Items.QUARTZ).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 12.0f)))
                    .with(ItemEntry.builder(Items.COAL).weight(15))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.RAW_PACSARIUM).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.BONE).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.BLAZE_POWDER).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))));
        exporter.accept(PACSARIA_LIBRARY, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0f))
                    .with(ItemEntry.builder(Items.BOOK).weight(50))
                        .apply(EnchantWithLevelsLootFunction.builder(UniformLootNumberProvider.create(1.0f, 39.0f)))
                    .with(ItemEntry.builder(Items.PAPER).weight(50))
                    .with(ItemEntry.builder(Items.BOOK).weight(50))));
        exporter.accept(PACSARIA_ARMOURY, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(Items.NETHERITE_HELMET).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(Items.NETHERITE_CHESTPLATE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(Items.NETHERITE_LEGGINGS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(Items.NETHERITE_BOOTS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(Items.NETHERITE_SWORD).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(Items.NETHERITE_AXE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder()))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(ModItems.TRIAFIUM_HELMET).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.TRIAFIUM_CHESTPLATE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.TRIAFIUM_LEGGINGS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.TRIAFIUM_BOOTS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.TRIAFIUM_SWORD).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.TRIAFIUM_AXE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder()))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(ModItems.PACSARIUM_HELMET).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.PACSARIUM_CHESTPLATE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.PACSARIUM_LEGGINGS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.PACSARIUM_BOOTS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.PACSARIUM_SWORD).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.PACSARIUM_AXE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())));
        exporter.accept(GUNPOWDER, LootTable.builder()
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0f, 8.0f))
                    .with(ItemEntry.builder(Items.GUNPOWDER).weight(100))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 32.0f)))));
        exporter.accept(SUGAR_CANE, LootTable.builder()
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0f, 8.0f))
                    .with(ItemEntry.builder(Items.SUGAR_CANE).weight(100))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 32.0f)))
                ));
        exporter.accept(CHUCK_HOUSE_RESOURCES, LootTable.builder()
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2.0f, 6.0f))
                    .with(ItemEntry.builder(Items.RAW_IRON).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.RAW_COPPER).weight(12))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 12.0f)))
                    .with(ItemEntry.builder(ModItems.RAW_TIN).weight(8))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.RAW_GOLD).weight(6))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 6.0f)))
                    .with(ItemEntry.builder(Items.LAPIS_LAZULI).weight(6))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                    .with(ItemEntry.builder(ModItems.BRONZE_DUST).weight(6))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f))))
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2.0f, 6.0f))
                    .with(ItemEntry.builder(Items.IRON_INGOT).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.COPPER_INGOT).weight(12))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 12.0f)))
                    .with(ItemEntry.builder(ModItems.TIN_INGOT).weight(8))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.REDSTONE).weight(16))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                    .with(ItemEntry.builder(Items.DIAMOND).weight(4))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)))
                    .with(ItemEntry.builder(Items.GOLD_INGOT).weight(6))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 6.0f)))
                    .with(ItemEntry.builder(ModItems.BRONZE_INGOT).weight(6))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))));
        exporter.accept(CHUCK_HOUSE_BLOCKS, LootTable.builder()
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(4.0f, 16.0f))
                    .with(ItemEntry.builder(Blocks.COBBLESTONE).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                    .with(ItemEntry.builder(Blocks.STONE).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 12.0f)))
                    .with(ItemEntry.builder(Blocks.SMOOTH_STONE).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                    .with(ItemEntry.builder(Blocks.OAK_LOG).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                    .with(ItemEntry.builder(Blocks.SPRUCE_LOG).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                    .with(ItemEntry.builder(Blocks.JUNGLE_LOG).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                    .with(ItemEntry.builder(ModBlocks.EUCALYPTUS_LOG).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)))
                    .with(ItemEntry.builder(Blocks.BRICKS).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                    .with(ItemEntry.builder(Blocks.COBBLED_DEEPSLATE).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                    .with(ItemEntry.builder(Blocks.ANDESITE).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                    .with(ItemEntry.builder(Blocks.CALCITE).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                    .with(ItemEntry.builder(Blocks.DIRT).weight(20))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(12.0f, 24.0f)))
                    .with(ItemEntry.builder(Blocks.SAND).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(12.0f, 24.0f)))
                ));
        // /setblock ~ ~ ~ minecraft:chest{LootTable:"chucksmod:chests/triafia_castle_loot"}
        exporter.accept(TRIAFIA_CASTLE_LOOT, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                        .with(ItemEntry.builder(ModItems.RAW_TRIAFIUM).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)))
                        .with(ItemEntry.builder(ModItems.TRIAFIUM_INGOT).weight(5))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)))
                        .with(ItemEntry.builder(Items.NAME_TAG).weight(5))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                        .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(10))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                        .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(1))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f))))
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2.0f, 6.0f))
                        .with(ItemEntry.builder(ModItems.TITANIUM_INGOT).weight(7))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)))
                        .with(ItemEntry.builder(Items.DIAMOND_HORSE_ARMOR).weight(3))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                        .with(ItemEntry.builder(Items.IRON_HORSE_ARMOR).weight(8))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                        .with(ItemEntry.builder(Items.GOLDEN_HORSE_ARMOR).weight(5))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(5))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)))
                        .with(ItemEntry.builder(Items.FLINT_AND_STEEL).weight(5))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                        .with(ItemEntry.builder(ModItems.RAW_TRIAFIUM).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
                        .with(ItemEntry.builder(Items.IRON_INGOT).weight(8))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 8.0f)))
                ));
    }
}
