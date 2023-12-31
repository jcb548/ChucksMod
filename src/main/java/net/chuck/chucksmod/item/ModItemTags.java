package net.chuck.chucksmod.item;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> RAW_MEAT = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "raw_meat"));
    public static final TagKey<Item> COOKED_MEAT = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "cooked_meat"));
    public static final TagKey<Item> SEEDS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "seeds"));
    public static final TagKey<Item> TIN_INGOTS = TagKey.of(RegistryKeys.ITEM,
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
    public static final TagKey<Item> TITANIUM_INGOTS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "titanium_ingots"));
    public static final TagKey<Item> TITANIUM_DUSTS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("c", "titanium_dusts"));
    public static final TagKey<Item> CRUSHERS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(ChucksMod.MOD_ID, "crushers"));
}
