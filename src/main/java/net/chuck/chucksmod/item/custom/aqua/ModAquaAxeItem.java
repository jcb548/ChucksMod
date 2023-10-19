package net.chuck.chucksmod.item.custom.aqua;

import net.chuck.chucksmod.item.custom.ModAxeItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModAquaAxeItem extends ModAxeItem {
    public ModAquaAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target.getGroup() == EntityGroup.AQUATIC) {
            target.damage(target.getRecentDamageSource(),
                    2*(this.getAttackDamage()+1));
            //attacker.sendMessage(Text.of(Float.toString(this.getAttackDamage())));
            //attacker.sendMessage(Text.of(Float.toString(this.getMaterial().getAttackDamage())));
            //attacker.sendMessage(Text.of(Float.toString((2*(this.getAttackDamage()+1)))));
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.chucksmod.aqua_item.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
