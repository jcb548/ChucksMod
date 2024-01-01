package net.chuck.chucksmod.networking;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.networking.packet.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModMessages {
    public static final Identifier ENERGY_SYNC = new Identifier(ChucksMod.MOD_ID, "energy_sync");
    public static final Identifier XP_SYNC = new Identifier(ChucksMod.MOD_ID, "xp_sync");
    public static final Identifier TELEPORT_PARTICLE = new Identifier(ChucksMod.MOD_ID, "teleport_particle");
    public static final Identifier ENERGY_STORAGE_BLOCK_SYNC =
            new Identifier(ChucksMod.MOD_ID, "energy_storage_sync");
    public static final Identifier RESET_QUARRY_SYNC = new Identifier(ChucksMod.MOD_ID, "quarry_reset_sync");
    public static final Identifier COPIER_XP_DRAIN = new Identifier(ChucksMod.MOD_ID, "copier_xd_drain");
    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(XP_SYNC, XpSyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(TELEPORT_PARTICLE, TeleportParticleS2CPacket::receive);
    }
    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(ENERGY_STORAGE_BLOCK_SYNC, EnergyStorageBlockSyncC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(RESET_QUARRY_SYNC, ResetQuarryC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(COPIER_XP_DRAIN, CopierDrainXpC2SPacket::receive);
    }
}
