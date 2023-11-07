package net.chuck.chucksmod.mixin;

import net.chuck.chucksmod.item.enchantment.AlacrityEnchantment;
import net.chuck.chucksmod.item.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public class ModItemStackAlacrityMixin{
    @ModifyVariable(method = "getTooltip", at = @At(value = "LOAD", ordinal = 2), index = 14)
    public double injected(double d){
        int level = EnchantmentHelper.getLevel(ModEnchantments.ALACRITY, ((ItemStack) (Object) this));
        return d + (EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue() + d)
                *level*(AlacrityEnchantment.ATTACK_SPEED_BONUS);
    }
}
