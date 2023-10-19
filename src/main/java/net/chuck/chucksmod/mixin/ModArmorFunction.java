package net.chuck.chucksmod.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public abstract class ModArmorFunction{
    @Shadow public abstract void enterCombat();

    @Redirect(method = "applyDamage", at = @At(value = "INVOKE", target =
            "Lnet/minecraft/entity/LivingEntity;applyArmorToDamage(Lnet/minecraft/entity/damage/DamageSource;F)F"))
    private float injectApplyArmorToDamage(LivingEntity entity, DamageSource source, float amount) {
        if (!source.isIn(DamageTypeTags.BYPASSES_ARMOR)){
            entity.damageArmor(source,amount);
            return amount*(float)(144.0/(Math.pow(entity.getArmor(), 2) + 144));
        }
        return amount;
    }
}
