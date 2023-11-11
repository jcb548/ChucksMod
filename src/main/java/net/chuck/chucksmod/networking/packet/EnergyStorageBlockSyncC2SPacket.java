package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.util.DirectionEnergyIOProperty;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.BlockState;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class EnergyStorageBlockSyncC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender){
        //Happens on server only
        BlockPos pos = buf.readBlockPos();
        byte side = buf.readByte();
        String value = buf.readString(1);
        BlockState oldState = player.getServerWorld().getBlockState(pos);
        player.getServerWorld().setBlockState(pos,
                oldState.withIfExists(DirectionEnergyIOProperty.getSide(side),
                        DirectionEnergyIOProperty.getNextState(value)));
    }
}
