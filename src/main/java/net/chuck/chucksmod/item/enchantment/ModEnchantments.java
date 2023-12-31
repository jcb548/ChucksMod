package net.chuck.chucksmod.item.enchantment;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static Enchantment WITHERING = new WitheringEnchantment();
    public static Enchantment ALACRITY = new AlacrityEnchantment();
    public static Enchantment LIFESTEAL_ONE = new LifestealOneEnchantment();
    public static Enchantment ENDER = new EnderEnchantment();
    public static void registerEnchantments(){
        Registry.register(Registries.ENCHANTMENT, new Identifier(ChucksMod.MOD_ID, "withering"), WITHERING);
        Registry.register(Registries.ENCHANTMENT, new Identifier(ChucksMod.MOD_ID, "alacrity"), ALACRITY);
        Registry.register(Registries.ENCHANTMENT, new Identifier(ChucksMod.MOD_ID, "lifesteal_one"), LIFESTEAL_ONE);
        Registry.register(Registries.ENCHANTMENT, new Identifier(ChucksMod.MOD_ID, "ender"), ENDER);
    }
}
