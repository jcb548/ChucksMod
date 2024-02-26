package net.chuck.chucksmod.item.custom;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    BRONZE("bronze", 20, new int [] {2, 7, 6, 2}, 14,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
    PRISMARINE("prismarine", 20, new int [] {2, 7, 6, 2}, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.PRISMARINE_INGOT)),
    TRIAFIUM("triafium", 36, new int [] {4, 9, 8, 4}, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2f, 0.1f,
            () -> Ingredient.ofItems(ModItems.TRIAFIUM_INGOT)),
    PACSARIUM("pacsarium", 42, new int [] {5, 10, 9, 5}, 21,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3f, 0.2f,
            () -> Ingredient.ofItems(ModItems.PACSARIUM_INGOT)),
    TITANIUM("titanium", 34, new int [] {3, 8, 7, 3}, 11,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TITANIUM_INGOT));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability,
                      SoundEvent equipSound, float toughness, float knockbackResistance,
                      Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return ChucksMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
