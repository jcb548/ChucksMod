package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.chuck.chucksmod.block.entity.EnergyStoring;
import net.chuck.chucksmod.block.entity.energy_storage.AbstractEnergyStorageBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.chuck.chucksmod.screen.energy_storage.EnergyStorageScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class EnergySyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        long energy = buf.readLong();
        BlockPos position = buf.readBlockPos();
        if (client.world != null) {
            if (client.world.getBlockEntity(position) instanceof EnergyStoring energyStoring) {
                energyStoring.setEnergyLevel(energy);
                if (client.player.currentScreenHandler instanceof AbstractEnergyUsingScreenHandler screenHandler &&
                        screenHandler.blockEntity.getPos().equals(position)) {
                    energyStoring.setEnergyLevel(energy);
                }
                if (client.player.currentScreenHandler instanceof EnergyStorageScreenHandler screenHandler &&
                        screenHandler.blockEntity.getPos().equals(position)) {
                    energyStoring.setEnergyLevel(energy);
                }
            }
        }
    }
}
