package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.block.entity.copier.AbstractCopierBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.AbstractQuarryBlockEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class CopierDrainXpC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                        PacketByteBuf buf, PacketSender responseSender){
        //Happens on server only
        BlockPos pos = buf.readBlockPos();
        if(player.getServerWorld().getWorldChunk(pos).getBlockEntity(pos) instanceof AbstractCopierBlockEntity copier){
            if(copier.xp < copier.maxXp){
                copier.xp += copier.getXpDrainRate();
                player.totalExperience = player.totalExperience - copier.getXpDrainRate();
            }
        }
    }
}
