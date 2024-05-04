package net.chuck.chucksmod.item;

import dev.architectury.event.events.common.ExplosionEvent;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class ModItemTags {
    public static final TagKey<Item> RAW_MEAT = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "raw_meat"));
    public static final TagKey<Item> COOKED_MEAT = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "cooked_meat"));
    public static final TagKey<Item> SEEDS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "seeds"));
    public static final TagKey<Item> TIN_INGOTS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "tin_ingots"));
    public static final TagKey<Item> TIN_ORES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "tin_ingots"));
    public static final TagKey<Item> BRONZE_INGOTS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "bronze_ingots"));
    public static final TagKey<Item> DUSTS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "dusts"));
    public static final TagKey<Item> HELMETS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "helmets"));
    public static final TagKey<Item> CHESTPLATES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "chestplates"));
    public static final TagKey<Item> LEGGINGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "leggings"));
    public static final TagKey<Item> BOOTS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "boots"));
    public static final TagKey<Item> ENCHANTABLES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "enchantables"));
    public static final TagKey<Item> ELYTRAS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "elytras"));
    public static final TagKey<Item> BAGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "bags"));
    public static final TagKey<Item> HARDENED_GLASS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "hardened_glass"));
    public static final TagKey<Item> GEARS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "gears"));
    public static final TagKey<Item> RAW_TITANIUM = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "raw_titanium_ores"));
    public static final TagKey<Item> TITANIUM_ORES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "raw_titanium_ores"));
    public static final TagKey<Item> TITANIUM_INGOTS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "titanium_ingots"));
    public static final TagKey<Item> TITANIUM_DUSTS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "titanium_dusts"));
    public static final TagKey<Item> CRUSHERS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "crushers"));
    public static final TagKey<Item> GLASS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "glass"));
    public static final TagKey<Item> WRENCHES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "wrenches"));
    public static final TagKey<Item> EUCALYPTUS_LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "eucalyptus_logs"));
    public static final TagKey<Item> TRIAFIA_LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "triafia_logs"));
    public static final TagKey<Item> PACSARIA_LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "pacsaria_logs"));
    public static final TagKey<Item> NETHERITE_TOOLS_ARMOR = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "netherite_tools_armor"));
    public static final TagKey<Item> BRONZE_BLOCKS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "bronze_blocks"));
    public static final TagKey<Item> TRIAFIUM_ORES = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "triafium_blocks"));
    public static final TagKey<Item> QUARTZ_ORES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "quartz_ores"));
    public static final TagKey<Item> CONCRETE = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "concrete"));
    public static final TagKey<Item> CONCRETE_SLABS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "concrete_slabs"));
    public static final TagKey<Item> CONCRETE_STAIRS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "concrete_stairs"));
    public static final TagKey<Item> CONCRETE_WALLS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "concrete_walls"));
}
