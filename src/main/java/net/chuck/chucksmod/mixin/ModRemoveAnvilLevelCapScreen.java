package net.chuck.chucksmod.mixin;

import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(AnvilScreen.class)
public class ModRemoveAnvilLevelCapScreen {
    @ModifyConstant(method = "drawForeground", constant = @Constant(intValue = 40))
    private int injected(int value){
        return Integer.MAX_VALUE;
    }
}
