package net.chuck.pigsnstuff.screen;

import net.chuck.pigsnstuff.PigsNStuff;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModScreenHandlers {
    public static ScreenHandlerType<CrusherScreenHandler> CRUSHER_SCREEN_HANDLER;
    public static ScreenHandlerType<PoweredCrusherScreenHandler> POWERED_CRUSHER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(PoweredCrusherScreenHandler::new);

    public static void registerAllScreenHandlers() {
        CRUSHER_SCREEN_HANDLER = new ScreenHandlerType<>(CrusherScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(PigsNStuff.MOD_ID, "powered_crusher"),
                POWERED_CRUSHER_SCREEN_HANDLER);
    }
}
