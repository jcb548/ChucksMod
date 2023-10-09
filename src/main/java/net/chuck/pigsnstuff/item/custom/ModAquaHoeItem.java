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

public class ModAquaHoeItem extends ModHoeItem{
    public ModAquaHoeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
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
        tooltip.add(Text.translatable("tooltip.pigsnstuff.aqua_item.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
