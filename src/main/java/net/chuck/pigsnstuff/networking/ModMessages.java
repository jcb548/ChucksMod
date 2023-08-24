package net.chuck.pigsnstuff.networking;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.networking.packet.EnergySyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
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
    public static final Identifier ENERGY_SYNC = new Identifier(PigsNStuff.MOD_ID, "energy_sync");
    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
    }
}
