package net.chuck.pigsnstuff.item;

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
}
