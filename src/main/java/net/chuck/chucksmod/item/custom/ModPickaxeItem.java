package net.chuck.chucksmod.item.custom;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModPickaxeItem extends PickaxeItem {
    public ModPickaxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
