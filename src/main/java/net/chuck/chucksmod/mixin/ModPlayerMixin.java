package net.chuck.chucksmod.mixin;

import net.chuck.chucksmod.item.enchantment.AlacrityEnchantment;
import net.chuck.chucksmod.item.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class ModPlayerMixin {
    @Inject(method = "getAttackCooldownProgressPerTick", cancellable = true, at = @At("RETURN"))
    public void injected(CallbackInfoReturnable<Float> cir){
        final int level = EnchantmentHelper.getLevel(ModEnchantments.ALACRITY,
                ((PlayerEntity) (Object) this).getMainHandStack());
        if(level > 0) {
            cir.setReturnValue((float)(1.0 /(((PlayerEntity) (Object) this)
                    .getAttributeValue(EntityAttributes.GENERIC_ATTACK_SPEED) +
                    AlacrityEnchantment.ATTACK_SPEED_BONUS*level) * 20.0));
        }
    }
}

