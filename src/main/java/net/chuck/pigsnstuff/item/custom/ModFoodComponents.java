package net.chuck.pigsnstuff.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
    public static final FoodComponent CHEESEBURGER = new FoodComponent.Builder().hunger(5).
            saturationModifier(1.0f).meat().build();
    //public static final FoodComponent PRISMARINE_APPLE = new FoodComponent.Builder().hunger(4).statusEffect(StatusEffectInstance.WATER_BREATHING, 1.0f, 30).snack().build();
}
