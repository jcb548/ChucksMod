package net.chuck.chucksmod.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;

public class TeleportParticleS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        int id = buf.readInt();
        double oldX = buf.readDouble();
        double oldY = buf.readDouble();
        double oldZ = buf.readDouble();
        LivingEntity target = (LivingEntity) handler.getWorld().getEntityById(id);
        for(int i=0;i<30;i++) {
            handler.getWorld().addParticle(ParticleTypes.PORTAL,
                    oldX + (2.0 * target.getRandom().nextDouble() - 1.0),
                    oldY + (2.0 * target.getRandom().nextDouble()),
                    oldZ + (2.0 * target.getRandom().nextDouble() - 1.0),
                    (target.getRandom().nextDouble() - 0.5) * 2.0,
                    target.getRandom().nextDouble(),
                    (target.getRandom().nextDouble() - 0.5) * 2.0);
            handler.getWorld().addParticle(ParticleTypes.PORTAL,
                    target.getX() + (2.0 * target.getRandom().nextDouble() - 1.0),
                    target.getY() + (2.0 * target.getRandom().nextDouble()),
                    target.getZ() + (2.0 * target.getRandom().nextDouble() - 1.0),
                    (target.getRandom().nextDouble() - 0.5) * 2.0,
                    target.getRandom().nextDouble(),
                    (target.getRandom().nextDouble() - 0.5) * 2.0);
        }
    }
}
