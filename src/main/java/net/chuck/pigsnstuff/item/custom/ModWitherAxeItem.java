package net.chuck.pigsnstuff.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModWitherAxeItem extends ModAxeItem{
    public ModWitherAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.damage(target.getRecentDamageSource(), this.getAttackDamage()+1);
        attacker.heal(this.getMaterial().getAttackDamage()/2);
        //attacker.sendMessage(Text.of(Float.toString(this.getMaterial().getAttackDamage())));
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.pigsnstuff.wither_item.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
