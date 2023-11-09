package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.bag.BagScreenHandler3x1;
import net.chuck.chucksmod.screen.bag.BagScreenHandler5x1;
import net.chuck.chucksmod.screen.bag.BagScreenHandler7x1;
import net.chuck.chucksmod.screen.bag.BagScreenHandler9x1;
import net.chuck.chucksmod.screen.bag.BagScreenHandler7x2;
import net.chuck.chucksmod.screen.crusher.CrusherScreenHandler;
import net.chuck.chucksmod.screen.crusher.IronPoweredCrusherScreenHandler;
import net.chuck.chucksmod.screen.energy_storage.IronEnergyStorageScreenHandler;
import net.chuck.chucksmod.screen.furnace.IronPoweredFurnaceScreenHandler;
import net.chuck.chucksmod.screen.generator.IronHeatGeneratorScreenHandler;
import net.chuck.chucksmod.screen.generator.TitaniumHeatGeneratorScreenHandler;
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
    public static ScreenHandlerType<IronPoweredCrusherScreenHandler> POWERED_CRUSHER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(IronPoweredCrusherScreenHandler::new);
    public static ScreenHandlerType<IronPoweredFurnaceScreenHandler> IRON_POWERED_FURNACE_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(IronPoweredFurnaceScreenHandler::new);
    public static ScreenHandlerType<IronHeatGeneratorScreenHandler> IRON_HEAT_GENERATOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(IronHeatGeneratorScreenHandler::new);
    public static ScreenHandlerType<IronEnergyStorageScreenHandler> IRON_ENERGY_STORAGE_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(IronEnergyStorageScreenHandler::new);
    public static ScreenHandlerType<TitaniumHeatGeneratorScreenHandler> TITANIUM_HEAT_GENERATOR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(TitaniumHeatGeneratorScreenHandler::new);
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
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "iron_powered_furnace"),
                IRON_POWERED_FURNACE_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "iron_heat_generator"),
                IRON_HEAT_GENERATOR_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ChucksMod.MOD_ID, "titanium_heat_generator"),
                TITANIUM_HEAT_GENERATOR_SCREEN_HANDLER);
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
