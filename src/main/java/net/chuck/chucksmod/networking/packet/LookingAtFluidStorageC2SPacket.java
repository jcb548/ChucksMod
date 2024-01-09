package net.chuck.chucksmod.networking.packet;

import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.block.entity.fluid_tank.AbstractFluidTankBlockEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class LookingAtFluidStorageC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender){
        //Happens on server only
        FluidVariant variant = FluidVariant.fromPacket(buf);
        BlockPos pos = buf.readBlockPos();
        long fluid = buf.readLong();
        if(player.getServerWorld().getWorldChunk(pos).getBlockEntity(pos) instanceof FluidStoring fluidStoring){
            if(fluidStoring.getFluidStorage().amount != fluid ||
                    !variant.equals(fluidStoring.getFluidStorage().variant)){
                fluidStoring.sendFluidPacket(player);
            }
        }
    }
}
