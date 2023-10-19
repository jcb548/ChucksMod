package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.ChucksMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
    public static ScreenHandlerType<CrusherScreenHandler> CRUSHER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(CrusherScreenHandler::new);
    public static ScreenHandlerType<PoweredCrusherScreenHandler> POWERED_CRUSHER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(PoweredCrusherScreenHandler::new);
    public static ScreenHandlerType<GeneratorScreenHandler> GENERATOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(GeneratorScreenHandler::new);
    public static ScreenHandlerType<BagScreenHandler> BAG_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(BagScreenHandler::new);

    public static void registerAllScreenHandlers() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "crusher"),
                CRUSHER_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "powered_crusher"),
                POWERED_CRUSHER_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "generator"),
                GENERATOR_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "bag"),
                BAG_SCREEN_HANDLER);
    }
}
