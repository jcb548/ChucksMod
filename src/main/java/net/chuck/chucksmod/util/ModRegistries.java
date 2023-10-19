package net.chuck.chucksmod.util;

import net.chuck.chucksmod.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModRegistries {
    public static void registerModStuffs(){
        registerFlammableBlocks();
        registerStrippables();
        registerFuels();
    }
    private static void registerFlammableBlocks() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.EUCALYPTUS_LOG, 5, 5);
        instance.add(ModBlocks.EUCALYPTUS_WOOD, 5, 5);
        instance.add(ModBlocks.STRIPPED_EUCALYPTUS_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD, 5, 5);
        instance.add(ModBlocks.EUCALYPTUS_PLANKS, 5, 20);
        instance.add(ModBlocks.EUCALYPTUS_LEAVES, 30, 60);
    }

    private static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.EUCALYPTUS_LOG, ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        StrippableBlockRegistry.register(ModBlocks.EUCALYPTUS_WOOD, ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
        StrippableBlockRegistry.register(ModBlocks.DIRITIA_LOG, ModBlocks.STRIPPED_DIRITIA_LOG);
        StrippableBlockRegistry.register(ModBlocks.DIRITIA_WOOD, ModBlocks.STRIPPED_DIRITIA_WOOD);
    }

    private static void registerFuels(){
        FuelRegistry.INSTANCE.add(ModBlocks.EUCALYPTUS_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.EUCALYPTUS_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_EUCALYPTUS_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.EUCALYPTUS_PLANKS,300);
        FuelRegistry.INSTANCE.add(ModBlocks.DIRITIA_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.DIRITIA_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_DIRITIA_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_DIRITIA_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.DIRITIA_PLANKS,300);
    }
}
