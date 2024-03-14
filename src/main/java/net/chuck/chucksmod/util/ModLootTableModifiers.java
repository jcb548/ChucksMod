package net.chuck.chucksmod.util;

import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.item.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetContentsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK_ID
            = new Identifier("minecraft", "blocks/grass");
    private static final Identifier WITHER_SKELETON_ID =
            new Identifier("minecraft", "entities/wither_skeleton");
    private static final Identifier ENDER_DRAGON_ID = new Identifier("entities/ender_dragon");
    private static final Identifier MINESHAFT_ID =
             new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier NETHER_BRIDGE_ID = new Identifier("chests/nether_bridge");
    private static final Identifier BASTION_BRIDGE_ID = new Identifier("chests/bastion_bridge");
    private static final Identifier BASTION_HOGLIN_ID = new Identifier("chests/bastion_hoglin_stable");
    private static final Identifier BASTION_OTHER_ID = new Identifier("chests/bastion_other");
    private static final Identifier BASTION_TREASURE_ID = new Identifier("chests/bastion_treasure");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(GRASS_BLOCK_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f)) // drops 25% of the time
                        .with(ItemEntry.builder(Items.BEETROOT_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(GRASS_BLOCK_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f)) // drops 25% of the time
                        .with(ItemEntry.builder(ModItems.LETTUCE_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(GRASS_BLOCK_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f)) // drops 25% of the time
                        .with(ItemEntry.builder(ModItems.TOMATO_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (WITHER_SKELETON_ID.equals(id)) {
                LootPool.Builder witherBoneBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(KilledByPlayerLootCondition.builder()) // drops 15% of the time, 4% more per looting level
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.15f, 0.04f))
                        .with(ItemEntry.builder(ModItems.WITHER_BONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(witherBoneBuilder.build());
            }
            if (WITHER_SKELETON_ID.equals(id)) {
                LootPool.Builder extraWitherSkullBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.1f, 0.02f)) // increase drop rate of wither skull by 10% with no looting and 16% with looting 3
                        .with(ItemEntry.builder(Items.WITHER_SKELETON_SKULL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(extraWitherSkullBuilder.build());
            }
            if(MINESHAFT_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f)) // found 40% of the time
                        .with(ItemEntry.builder(ModItems.PINEAPPLE_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(ENDER_DRAGON_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1))
                        .with(ItemEntry.builder(Items.ENCHANTED_BOOK)
                            .apply(new SetEnchantmentsLootFunction.Builder(true)
                                    .enchantment(ModEnchantments.ENDER, ConstantLootNumberProvider.create(1))).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(NETHER_BRIDGE_ID.equals(id) || BASTION_BRIDGE_ID.equals(id) || BASTION_HOGLIN_ID.equals(id) ||
                BASTION_OTHER_ID.equals(id) || BASTION_TREASURE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.NETHER_CRYSTAL_SHARD))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)))
                        .with(ItemEntry.builder(ModItems.NETHER_CRYSTAL_SEEDS))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}
