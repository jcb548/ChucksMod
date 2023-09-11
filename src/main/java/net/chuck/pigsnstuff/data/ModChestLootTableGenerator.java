package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.*;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModChestLootTableGenerator extends SimpleFabricLootTableProvider {
    // /setblock ~ ~ ~ minecraft:chest{LootTable:"pigsnstuff:chests/diritia_house"}
    public static final Identifier DIRITIA_HOUSE = new Identifier(PigsNStuff.MOD_ID, "chests/diritia_house");
    // /setblock ~ ~ ~ minecraft:chest{LootTable:"pigsnstuff:chests/diritia_dungeon"}
    public static final Identifier DIRITIA_DUNGEON = new Identifier(PigsNStuff.MOD_ID, "chests/diritia_dungeon");
    // /setblock ~ ~ ~ minecraft:chest{LootTable:"pigsnstuff:chests/diritia_library"}
    public static final Identifier DIRITIA_LIBRARY = new Identifier(PigsNStuff.MOD_ID, "chests/diritia_library");
    // /setblock ~ ~ ~ minecraft:chest{LootTable:"pigsnstuff:chests/diritia_armoury"}
    public static final Identifier DIRITIA_ARMOURY = new Identifier(PigsNStuff.MOD_ID, "chests/diritia_armoury");
    public static final Identifier GUNPOWDER = new Identifier(PigsNStuff.MOD_ID, "chests/gunpowder");
    public static final Identifier SUGAR_CANE = new Identifier(PigsNStuff.MOD_ID, "chests/sugar_cane");
    public ModChestLootTableGenerator(FabricDataOutput output) {
        super(output, LootContextTypes.CHEST);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        // /setblock ~ ~ ~ minecraft:chest{LootTable:"pigsnstuff:chests/diritia_house"}
        exporter.accept(DIRITIA_HOUSE, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(15))
                    .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(5))
                    .with(ItemEntry.builder(ModItems.DIRITIA_CRYSTAL_SHARD).weight(10))
                    .with(ItemEntry.builder(ModItems.DIRITONIUM_INGOT).weight(10))
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
                    .with(ItemEntry.builder(ModItems.CHEESEBURGER).weight(20))
                    .with(ItemEntry.builder(Items.QUARTZ).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 12.0f)))
                    .with(ItemEntry.builder(Items.COAL).weight(15))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.RAW_DIRITONIUM).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.BONE).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.BLAZE_POWDER).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))));
        exporter.accept(DIRITIA_DUNGEON, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(5))
                    .with(ItemEntry.builder(ModItems.DIRITONIUM_INGOT).weight(10))
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
                    .with(ItemEntry.builder(ModItems.DIRITIA_CRYSTAL_SHARD).weight(20))
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
                    .with(ItemEntry.builder(ModItems.CHEESEBURGER).weight(20))
                    .with(ItemEntry.builder(Items.QUARTZ).weight(10))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 12.0f)))
                    .with(ItemEntry.builder(Items.COAL).weight(15))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(ModItems.RAW_DIRITONIUM).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.BONE).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))
                    .with(ItemEntry.builder(Items.BLAZE_POWDER).weight(10))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)))));
        exporter.accept(DIRITIA_LIBRARY, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0f))
                    .with(ItemEntry.builder(Items.BOOK).weight(50))
                        .apply(EnchantWithLevelsLootFunction.builder(UniformLootNumberProvider.create(1.0f, 39.0f)))
                    .with(ItemEntry.builder(Items.PAPER).weight(50))
                    .with(ItemEntry.builder(Items.BOOK).weight(50))));
        exporter.accept(DIRITIA_ARMOURY, LootTable.builder()
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
                    .with(ItemEntry.builder(ModItems.FABIUM_HELMET).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.FABIUM_CHESTPLATE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.FABIUM_LEGGINGS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.FABIUM_BOOTS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.FABIUM_SWORD).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.FABIUM_AXE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder()))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(ModItems.DIRITONIUM_HELMET).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.DIRITONIUM_CHESTPLATE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.DIRITONIUM_LEGGINGS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.DIRITONIUM_BOOTS).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.DIRITONIUM_SWORD).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())
                    .with(ItemEntry.builder(ModItems.DIRITONIUM_AXE).weight(10))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1f, 0.9f)))
                        .apply(EnchantRandomlyLootFunction.builder())));
        exporter.accept(GUNPOWDER, LootTable.builder()
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0f, 8.0f))
                    .with(ItemEntry.builder(Items.GUNPOWDER).weight(100))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 32.0f)))));
        exporter.accept(SUGAR_CANE, LootTable.builder()
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0f, 8.0f))
                    .with(ItemEntry.builder(Items.SUGAR_CANE).weight(100))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 32.0f)))));
    }
}
