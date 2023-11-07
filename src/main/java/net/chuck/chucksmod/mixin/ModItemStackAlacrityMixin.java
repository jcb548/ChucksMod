package net.chuck.chucksmod.mixin;

import com.google.common.collect.Multimap;
import net.chuck.chucksmod.item.enchantment.AlacrityEnchantment;
import net.chuck.chucksmod.item.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Mixin(ItemStack.class)
public class ModItemStackAlacrityMixin{
    @ModifyVariable(method = "getTooltip", at = @At(value = "LOAD", ordinal = 2), index = 14)
    public double injected(double d){
        int level = EnchantmentHelper.getLevel(ModEnchantments.ALACRITY, ((ItemStack) (Object) this));
        return d + (EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue() + d)
                *level*(AlacrityEnchantment.ATTACK_SPEED_BONUS);
    }
}
