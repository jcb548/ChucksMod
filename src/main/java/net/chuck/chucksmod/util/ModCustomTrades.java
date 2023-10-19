package net.chuck.chucksmod.util;

import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.TOMATO, 23),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.05f));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.LETTUCE, 24),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.05f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.LETTUCE, 8),
                    16, 5, 0.05f));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.TOMATO, 7),
                    16, 5, 0.05f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 16),
                    EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SHARPNESS, 5)),
                    6, 12, 0.075f));
        });
    }
}
