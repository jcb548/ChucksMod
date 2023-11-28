package net.chuck.chucksmod.networking;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.networking.packet.EnergyStorageBlockSyncC2SPacket;
import net.chuck.chucksmod.networking.packet.EnergySyncS2CPacket;
import net.chuck.chucksmod.networking.packet.ResetQuarryC2SPacket;
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
    public static final Identifier ENERGY_STORAGE_BLOCK_SYNC =
            new Identifier(ChucksMod.MOD_ID, "energy_storage_sync");
    public static final Identifier RESET_QUARRY_SYNC = new Identifier(ChucksMod.MOD_ID, "quarry_reset_sync");
    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
    }
    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(ENERGY_STORAGE_BLOCK_SYNC, EnergyStorageBlockSyncC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(RESET_QUARRY_SYNC, ResetQuarryC2SPacket::receive);
    }
}
