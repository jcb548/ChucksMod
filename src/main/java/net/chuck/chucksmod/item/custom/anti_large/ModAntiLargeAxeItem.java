package net.chuck.chucksmod.item.custom.anti_large;

import net.chuck.chucksmod.item.custom.ModAxeItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
public class ModAntiLargeAxeItem extends ModAxeItem {
    public ModAntiLargeAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //attacker.sendMessage(Text.of(target.getDimensions(EntityPose.STANDING).toString()));
        if(target.getDimensions(EntityPose.STANDING).width > 1.2f) {
            target.damage(target.getRecentDamageSource(),
                    1.5f*(this.getAttackDamage()+1));
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.chucksmod.anti_large_item.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
