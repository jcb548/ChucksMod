package net.chuck.chucksmod.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;

public class PippinHealParticleS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        int id = buf.readInt();
        BlockPos pos = buf.readBlockPos();
        LivingEntity target = (LivingEntity) handler.getWorld().getEntityById(id);
        if(target != null) for(int i=0;i<3;i++) {
            handler.getWorld().addParticle(ParticleTypes.HEART,
                    pos.getX() + 0.5 + (target.getRandom().nextDouble()),
                    pos.getY() + (target.getRandom().nextDouble()),
                    pos.getZ() + 0.5 + (target.getRandom().nextDouble()),
                    (target.getRandom().nextDouble() - 0.5) * 2.0,
                    target.getRandom().nextDouble(),
                    (target.getRandom().nextDouble() - 0.5) * 2.0);
            handler.getWorld().addParticle(ParticleTypes.HEART,
                    target.getX() - 0.5 + (target.getRandom().nextDouble()),
                    target.getY() + (target.getRandom().nextDouble()),
                    target.getZ() - 0.5 + (target.getRandom().nextDouble()),
                    (target.getRandom().nextDouble() - 0.5) * 2.0,
                    target.getRandom().nextDouble(),
                    (target.getRandom().nextDouble() - 0.5) * 2.0);
        }
    }
}
