package net.chuck.pigsnstuff.screen;

import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<CrusherScreenHandler> INFUSING_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        INFUSING_SCREEN_HANDLER = new ScreenHandlerType<>(CrusherScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
    }
}
