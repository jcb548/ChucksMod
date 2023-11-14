package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.custom.SoulBlazeRodEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SoulBlazeRodRenderer extends EntityRenderer<SoulBlazeRodEntity> {
    private final SoulBlazeRodModel model;
    public SoulBlazeRodRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new SoulBlazeRodModel(ctx.getPart(ModModelLayers.SOUL_BLAZE_ROD));
    }

    @Override
    public void render(SoulBlazeRodEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.scale(1.5f, 1.5f, 1.5f);
        matrices.translate(0f, -1.25f, 0f);
        this.model.setHeadRotation(entity.getYaw(), entity.getPitch());
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.model.getLayer(this.getTexture(entity)));
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(SoulBlazeRodEntity entity) {
        return SoulBlazeRenderer.TEXTURE;
    }
}
