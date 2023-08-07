package net.chuck.pigsnstuff.item.custom;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ModSwordItems extends SwordItem {
    public ModSwordItems(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
