package net.chuck.chucksmod.item.custom;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModFoodComponents {
    public static final FoodComponent HAMBURGER = new FoodComponent.Builder().hunger(5).
            saturationModifier(1.0f).meat().build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build();
    public static final FoodComponent LETTUCE = new FoodComponent.Builder().hunger(3).saturationModifier(0.4f).build();
    public static final FoodComponent PINEAPPLE = new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).build();
    //public static final FoodComponent PRISMARINE_APPLE = new FoodComponent.Builder().hunger(4).statusEffect(StatusEffectInstance.WATER_BREATHING, 1.0f, 30).snack().build();
    public static final FoodComponent TRIAFIAN_PORKCHOP = new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build();
    public static final FoodComponent COOKED_TRIAFIAN_PORKCHOP = new FoodComponent.Builder().hunger(10).saturationModifier(1.0f).build();
}
