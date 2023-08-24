package net.chuck.pigsnstuff.screen;

import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<CrusherScreenHandler> CRUSHER_SCREEN_HANDLER;
    public static ScreenHandlerType<PoweredCrusherScreenHandler> POWERED_CRUSHER_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        CRUSHER_SCREEN_HANDLER = new ScreenHandlerType<>(CrusherScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        POWERED_CRUSHER_SCREEN_HANDLER = new ScreenHandlerType<>(PoweredCrusherScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
    }
}
