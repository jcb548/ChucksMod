package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.block.entity.furnace.IronPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.block.entity.generator.IronHeatGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.IronPoweredCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.generator.TitaniumHeatGeneratorBlockEntity;
import net.chuck.chucksmod.screen.furnace.IronPoweredFurnaceScreenHandler;
import net.chuck.chucksmod.screen.generator.IronHeatGeneratorScreenHandler;
import net.chuck.chucksmod.screen.crusher.IronPoweredCrusherScreenHandler;
import net.chuck.chucksmod.screen.generator.TitaniumHeatGeneratorScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
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
public class EnergySyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        long energy = buf.readLong();
        BlockPos position = buf.readBlockPos();

        if(client.world.getBlockEntity(position) instanceof IronPoweredCrusherBlockEntity blockEntity) {
            blockEntity.setEnergyLevel(energy);

            if(client.player.currentScreenHandler instanceof IronPoweredCrusherScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setEnergyLevel(energy);
            }
        }
        if(client.world.getBlockEntity(position) instanceof IronPoweredFurnaceBlockEntity blockEntity) {
            blockEntity.setEnergyLevel(energy);

            if(client.player.currentScreenHandler instanceof IronPoweredFurnaceScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setEnergyLevel(energy);
            }
        }
        if(client.world.getBlockEntity(position) instanceof IronHeatGeneratorBlockEntity blockEntity) {
            blockEntity.setEnergyLevel(energy);

            if(client.player.currentScreenHandler instanceof IronHeatGeneratorScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setEnergyLevel(energy);
            }
        }
        if(client.world.getBlockEntity(position) instanceof TitaniumHeatGeneratorBlockEntity blockEntity) {
            blockEntity.setEnergyLevel(energy);

            if(client.player.currentScreenHandler instanceof TitaniumHeatGeneratorScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setEnergyLevel(energy);
            }
        }
    }
}
