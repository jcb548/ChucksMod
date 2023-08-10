package net.chuck.pigsnstuff.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<InfusingScreenHandler> INFUSING_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        INFUSING_SCREEN_HANDLER = new ScreenHandlerType<>(InfusingScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
    }
}
