package net.chuck.chucksmod.mixin;

import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnvilScreenHandler.class)
public class ModRemoveAnvilLevelCapScreenHandler {
    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40))
    private int injected(int value){
        return Integer.MAX_VALUE;
    }

    @Inject(method = "getNextCost", at = @At("RETURN"), cancellable = true)
    private static void injected(int cost, CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue((int) Math.round(1.5d*cost + 1));
    }
}
