package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.bag.BagScreenHandler3x1;
import net.chuck.chucksmod.screen.bag.BagScreenHandler5x1;
import net.chuck.chucksmod.screen.bag.BagScreenHandler7x1;
import net.chuck.chucksmod.screen.bag.BagScreenHandler9x1;
import net.chuck.chucksmod.screen.bag.BagScreenHandler7x2;
import net.chuck.chucksmod.screen.copier.CopierScreenHandler;
import net.chuck.chucksmod.screen.crusher.CrusherScreenHandler;
import net.chuck.chucksmod.screen.crusher.PoweredCrusherScreenHandler;
import net.chuck.chucksmod.screen.furnace.PoweredFurnaceScreenHandler;
import net.chuck.chucksmod.screen.energy_storage.EnergyStorageScreenHandler;
import net.chuck.chucksmod.screen.generator.GeneratorScreenHandler;
import net.chuck.chucksmod.screen.generator.lava.LavaGeneratorScreenHandler;
import net.chuck.chucksmod.screen.generator.steam.SteamGeneratorScreenHandler;
import net.chuck.chucksmod.screen.portal_builder.PortalBuilderScreenHandler;
import net.chuck.chucksmod.screen.pump.PumpScreenHandler;
import net.chuck.chucksmod.screen.quarry.IronQuarryScreenHandler;
import net.chuck.chucksmod.screen.quarry.TitaniumQuarryScreenHandler;
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
    public static final int SINGLE_ROW_INV_TITLE = 38;
    public static final int DOUBLE_ROW_INV_TITLE = 56;
    public static final int INV_BELOW_TITLE = 11;
    public static final int HOTBAR_BELOW_TITLE = 69;
    public static ScreenHandlerType<CrusherScreenHandler> CRUSHER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(CrusherScreenHandler::new);
    public static ScreenHandlerType<PoweredCrusherScreenHandler> POWERED_CRUSHER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(PoweredCrusherScreenHandler::new);
    public static ScreenHandlerType<PoweredFurnaceScreenHandler> POWERED_FURNACE_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(PoweredFurnaceScreenHandler::new);
    public static ScreenHandlerType<GeneratorScreenHandler> GENERATOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(GeneratorScreenHandler::new);
    public static ScreenHandlerType<EnergyStorageScreenHandler> ENERGY_STORAGE_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(EnergyStorageScreenHandler::new);
    public static ScreenHandlerType<IronQuarryScreenHandler> IRON_QUARRY_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(IronQuarryScreenHandler::new);
    public static ScreenHandlerType<PumpScreenHandler> PUMP_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(PumpScreenHandler::new);
    public static ScreenHandlerType<SteamGeneratorScreenHandler> STEAM_GENERATOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(SteamGeneratorScreenHandler::new);
    public static ScreenHandlerType<LavaGeneratorScreenHandler> LAVA_GENERATOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(LavaGeneratorScreenHandler::new);
    public static ScreenHandlerType<TitaniumQuarryScreenHandler> TITANIUM_QUARRY_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(TitaniumQuarryScreenHandler::new);
    public static ScreenHandlerType<PortalBuilderScreenHandler> PORTAL_BUILDER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(PortalBuilderScreenHandler::new);
    public static ScreenHandlerType<CopierScreenHandler> COPIER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(CopierScreenHandler::new);
    public static ScreenHandlerType<BagScreenHandler3x1> BAG_3X1_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(BagScreenHandler3x1::new);
    public static ScreenHandlerType<BagScreenHandler5x1> BAG_5X1_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(BagScreenHandler5x1::new);
    public static ScreenHandlerType<BagScreenHandler7x1> BAG_7X1_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(BagScreenHandler7x1::new);
    public static ScreenHandlerType<BagScreenHandler9x1> BAG_9X1_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(BagScreenHandler9x1::new);
    public static ScreenHandlerType<BagScreenHandler7x2> BAG_7X2_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(BagScreenHandler7x2::new);


    public static void registerAllScreenHandlers() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "crusher"),
                CRUSHER_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "powered_crusher"),
                POWERED_CRUSHER_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "powered_furnace"),
                POWERED_FURNACE_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "generator"),
                GENERATOR_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "energy_storage"),
                ENERGY_STORAGE_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "steam_generator"),
                STEAM_GENERATOR_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "lava_generator"),
                LAVA_GENERATOR_SCREEN_HANDLER);

        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "iron_quarry"),
                IRON_QUARRY_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "titanium_quarry"),
                TITANIUM_QUARRY_SCREEN_HANDLER);

        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "copier"),
                COPIER_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "pump"),
                PUMP_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "portal_builder"),
                PORTAL_BUILDER_SCREEN_HANDLER);

        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "bag_3x1"),
                BAG_3X1_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "bag_5x1"),
                BAG_5X1_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "bag_7x1"),
                BAG_7X1_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "bag_9x1"),
                BAG_9X1_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "bag_7x2"),
                BAG_7X2_SCREEN_HANDLER);
    }
}
