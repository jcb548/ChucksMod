package net.chuck.pigsnstuff.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent CHEESEBURGER = new FoodComponent.Builder().hunger(10).
            saturationModifier(1.0f).meat().build();

}
