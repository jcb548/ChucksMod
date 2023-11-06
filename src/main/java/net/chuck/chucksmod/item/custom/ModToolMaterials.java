package net.chuck.chucksmod.item.custom;

import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public enum ModToolMaterials implements ToolMaterial
{
    //WOOD(MiningLevels.WOOD, 59, 2.0f, 0.0f, 15, () -> Ingredient.fromTag(ItemTags.PLANKS)),
    //STONE(MiningLevels.STONE, 131, 4.0f, 1.0f, 5, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),
    //IRON(MiningLevels.IRON, 250, 6.0f, 2.0f, 14, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    //DIAMOND(MiningLevels.DIAMOND, 1561, 8.0f, 3.0f, 10, () -> Ingredient.ofItems(Items.DIAMOND)),
    //GOLD(MiningLevels.WOOD, 32, 12.0f, 0.0f, 22, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    //NETHERITE(MiningLevels.NETHERITE, 2031, 9.0f, 4.0f, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));*/
    PRISMARINE(MiningLevels.IRON, 400, 7.0f, 2.5f, 18,
            () -> Ingredient.ofItems(ModItems.PRISMARINE_INGOT)),
    TIN(MiningLevels.STONE, 144, 5.0f, 1.5f, 15,
            () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    BRONZE(MiningLevels.IRON, 400, 7.0f, 2.5f, 19,
    () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
    WITHER(MiningLevels.IRON, 1024, 3.0f, 4.0f,20,
            () -> Ingredient.ofItems((ModItems.WITHER_BONE))),
    FABIUM(MiningLevels.NETHERITE, 1267, 8.0f, 4.0f, 12,
            () -> Ingredient.ofItems(ModItems.FABIUM_INGOT)),
    DIRITONIUM(5, 2431, 9.0f, 5.0f, 22,
            () -> Ingredient.ofItems(ModItems.DIRITONIUM_INGOT));
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed,
                             float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
