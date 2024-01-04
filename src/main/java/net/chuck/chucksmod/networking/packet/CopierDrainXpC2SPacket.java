package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.block.entity.copier.AbstractCopierBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.AbstractQuarryBlockEntity;
import net.chuck.chucksmod.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class CopierDrainXpC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                        PacketByteBuf buf, PacketSender responseSender){
        //Happens on server only
        BlockPos pos = buf.readBlockPos();
        UUID playerUuid = buf.readUuid();
        if(player.getServerWorld().getWorldChunk(pos).getBlockEntity(pos) instanceof AbstractCopierBlockEntity copier
                && player.getUuid().equals(playerUuid)){
            if(copier.fluidStorage.amount < copier.fluidStorage.getCapacity()){
                long transferAmount = copier.getXpDrainRate();
                if(copier.fluidStorage.getCapacity()-copier.fluidStorage.amount < transferAmount){
                    transferAmount = copier.fluidStorage.getCapacity()-copier.fluidStorage.amount;
                }
                if(player.totalExperience < transferAmount){
                    transferAmount = player.totalExperience;
                }
                copier.drainPlayerXp(transferAmount);
                player.addExperience(-(int)transferAmount);
            }
        }
    }
}
