package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.chuck.chucksmod.block.entity.copier.AbstractCopierBlockEntity;
import net.chuck.chucksmod.block.entity.energy_storage.AbstractEnergyStorageBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.chuck.chucksmod.screen.copier.CopierScreenHandler;
import net.chuck.chucksmod.screen.energy_storage.EnergyStorageScreenHandler;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
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
        FluidVariant variant = FluidVariant.fromPacket(buf);
        long xpLevel = buf.readLong();
        BlockPos pos = buf.readBlockPos();

        if (client.world != null) {
            if (client.world.getWorldChunk(pos).getBlockEntity(pos) instanceof AbstractCopierBlockEntity copier) {
                copier.setXpLevel(variant, xpLevel);
                if (client.player.currentScreenHandler instanceof CopierScreenHandler screenHandler &&
                        screenHandler.copier.getPos().equals(pos)) {
                    copier.setXpLevel(variant, xpLevel);
                    screenHandler.setXp(new FluidStack(variant, xpLevel));
                }
            }
        }
    }
}
