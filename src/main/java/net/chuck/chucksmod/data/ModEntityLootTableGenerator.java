package net.chuck.chucksmod.data;

import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModEntityLootTableGenerator extends SimpleFabricLootTableProvider {
    private static final Identifier SOUL_BLAZE = ModEntities.SOUL_BLAZE_BOSS.getLootTableId();
    public ModEntityLootTableGenerator(FabricDataOutput output) {
        super(output, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(SOUL_BLAZE, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0f))
                        .with(ItemEntry.builder(ModItems.SOUL_BLAZE_ROD))));
    }

}
