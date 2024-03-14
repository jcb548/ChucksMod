package net.chuck.chucksmod.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorMaterials.class)
public abstract class NetheriteArmorMixin {
    @Shadow public abstract String getName();
    @Inject(method = "getProtection", at = @At(value = "RETURN"), cancellable = true)
    private void injected(CallbackInfoReturnable<Integer> cir){
        int increaseProtAmount = 0;
        if(this.getName().equals("netherite"))
            increaseProtAmount = 1;
        cir.setReturnValue(cir.getReturnValue() + increaseProtAmount);
    }
}
