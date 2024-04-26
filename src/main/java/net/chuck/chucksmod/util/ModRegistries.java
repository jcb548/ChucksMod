package net.chuck.chucksmod.util;

import net.chuck.chucksmod.block.ModBlocks;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import net.minecraft.world.GameRules;

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
        registerCommands();
    }
    private static void registerFlammableBlocks() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.EUCALYPTUS_LOG, 5, 5);
        instance.add(ModBlocks.EUCALYPTUS_WOOD, 5, 5);
        instance.add(ModBlocks.STRIPPED_EUCALYPTUS_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD, 5, 5);
        instance.add(ModBlocks.EUCALYPTUS_PLANKS, 5, 20);
        instance.add(ModBlocks.EUCALYPTUS_LEAVES, 30, 60);
        instance.add(ModBlocks.PACSARIA_LOG, 5, 5);
        instance.add(ModBlocks.PACSARIA_WOOD, 5, 5);
        instance.add(ModBlocks.STRIPPED_PACSARIA_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_PACSARIA_WOOD, 5, 5);
        instance.add(ModBlocks.PACSARIA_PLANKS, 5, 20);
        instance.add(ModBlocks.PACSARIA_LEAVES, 30, 60);
        instance.add(ModBlocks.TRIAFIA_LOG, 5, 5);
        instance.add(ModBlocks.TRIAFIA_WOOD, 5, 5);
        instance.add(ModBlocks.STRIPPED_TRIAFIA_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_TRIAFIA_WOOD, 5, 5);
        instance.add(ModBlocks.TRIAFIA_PLANKS, 5, 20);
        instance.add(ModBlocks.TRIAFIA_LEAVES, 30, 60);
    }

    private static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.EUCALYPTUS_LOG, ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        StrippableBlockRegistry.register(ModBlocks.EUCALYPTUS_WOOD, ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
        StrippableBlockRegistry.register(ModBlocks.PACSARIA_LOG, ModBlocks.STRIPPED_PACSARIA_LOG);
        StrippableBlockRegistry.register(ModBlocks.PACSARIA_WOOD, ModBlocks.STRIPPED_PACSARIA_WOOD);
        StrippableBlockRegistry.register(ModBlocks.TRIAFIA_LOG, ModBlocks.STRIPPED_TRIAFIA_LOG);
        StrippableBlockRegistry.register(ModBlocks.TRIAFIA_WOOD, ModBlocks.STRIPPED_TRIAFIA_WOOD);
    }

    private static void registerFuels(){
        FuelRegistry.INSTANCE.add(ModBlocks.EUCALYPTUS_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.EUCALYPTUS_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_EUCALYPTUS_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.EUCALYPTUS_PLANKS,300);
        FuelRegistry.INSTANCE.add(ModBlocks.PACSARIA_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.PACSARIA_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_PACSARIA_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_PACSARIA_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.PACSARIA_PLANKS,300);
        FuelRegistry.INSTANCE.add(ModBlocks.TRIAFIA_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.TRIAFIA_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_TRIAFIA_LOG,300);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_TRIAFIA_WOOD,300);
        FuelRegistry.INSTANCE.add(ModBlocks.TRIAFIA_PLANKS,300);
    }

    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(CommandManager.literal("gmc")
                        .requires(source -> source.hasPermissionLevel(2))
                        .requires(ServerCommandSource::isExecutedByPlayer)
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    ServerPlayerEntity player = source.getPlayer();
                    if(player == null || !player.changeGameMode(GameMode.CREATIVE)) return 0;
                    if (source.getEntity() == player) {
                        source.sendFeedback(() -> Text.translatable("commands.gamemode.success.self",
                                Text.translatable("gameMode." + GameMode.CREATIVE.getName())), true);
                    }
                    return 1;
                        })));

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(CommandManager.literal("gms")
                        .requires(source -> source.hasPermissionLevel(2))
                        .requires(ServerCommandSource::isExecutedByPlayer)
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    ServerPlayerEntity player = source.getPlayer();
                    if(player == null || !player.changeGameMode(GameMode.SURVIVAL)) return 0;
                    if (source.getEntity() == player) {
                        source.sendFeedback(() -> Text.translatable("commands.gamemode.success.self",
                                Text.translatable("gameMode." + GameMode.SURVIVAL.getName())), true);
                    }
                    return 1;
                        })));

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(CommandManager.literal("gmsp")
                        .requires(source -> source.hasPermissionLevel(2))
                        .requires(ServerCommandSource::isExecutedByPlayer)
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    ServerPlayerEntity player = source.getPlayer();
                    if(player == null || !player.changeGameMode(GameMode.SPECTATOR)) return 0;
                    if (source.getEntity() == player) {
                        source.sendFeedback(() -> Text.translatable("commands.gamemode.success.self",
                                Text.translatable("gameMode." + GameMode.SPECTATOR.getName())), true);
                    }
                    return 1;
                        })));
    }
}
