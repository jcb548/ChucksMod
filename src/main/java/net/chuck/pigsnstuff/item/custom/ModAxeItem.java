package net.chuck.pigsnstuff.item.custom;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModAxeItem extends AxeItem {
    public ModAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
