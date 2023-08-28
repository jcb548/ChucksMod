package net.chuck.pigsnstuff.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(InGameHud.class)
public class ModRemoveOldArmorDisplay {
    @ModifyVariable(method = "renderStatusBars", at = @At("STORE"), name = "u")
    private int injected(int u){
        return 0;
    }
}
