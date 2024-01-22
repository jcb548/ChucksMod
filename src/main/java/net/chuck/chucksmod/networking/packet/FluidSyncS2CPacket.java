package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.screen.FluidStoringScreenHandler;
import net.chuck.chucksmod.screen.copier.CopierScreenHandler;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class FluidSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos pos = buf.readBlockPos();
        if (client.world != null) {
            if (client.world.getWorldChunk(pos).getBlockEntity(pos) instanceof FluidStoring tank) {
                tank.setFluidStorage(variant, fluidLevel);
                if (client.player.currentScreenHandler instanceof FluidStoringScreenHandler screenHandler &&
                        screenHandler.getFluidStoring().getPos().equals(pos)) {
                    tank.setFluidStorage(variant, fluidLevel);
                    screenHandler.setFluidStack(new FluidStack(variant, fluidLevel));
                }
            }
        }
    }
}
