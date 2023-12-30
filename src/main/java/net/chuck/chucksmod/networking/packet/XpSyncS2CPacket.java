package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.chuck.chucksmod.block.entity.copier.AbstractCopierBlockEntity;
import net.chuck.chucksmod.block.entity.energy_storage.AbstractEnergyStorageBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.chuck.chucksmod.screen.copier.CopierScreenHandler;
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
public class XpSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        int xp = buf.readInt();
        BlockPos pos = buf.readBlockPos();
        if (client.world != null) {
            client.world.getPlayers().get(0).sendMessage(Text.literal("not null"));
            if (client.world.getWorldChunk(pos).getBlockEntity(pos) instanceof AbstractCopierBlockEntity blockEntity) {
                blockEntity.xp = xp;
                if (client.player.currentScreenHandler instanceof CopierScreenHandler screenHandler &&
                        screenHandler.blockEntity.getPos().equals(pos)) {
                    blockEntity.xp = xp;
                }
            }
        }
    }
}
