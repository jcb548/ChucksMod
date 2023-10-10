package net.chuck.pigsnstuff.entity.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.FrankFireballEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class FrankFireballRenderer extends EntityRenderer<FrankFireballEntity> {
    private static final Identifier TEXTURE = new Identifier(PigsNStuff.MOD_ID, "textures/entity/frank_fireball.png");
    private final FrankFireballModel model;
    public FrankFireballRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new FrankFireballModel(context.getPart(ModModelLayers.FRANK_FIREBALL));
    }
    @Override
    public void render(FrankFireballEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.push();
        poseStack.scale(1.0f, 1.0f, 1.0f);
        poseStack.translate(0f, -1.25f, 0f);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(this.model.getLayer(this.getTexture(entity)));
        this.model.render(poseStack, vertexConsumer, packedLight, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.pop();
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
    @Override
    public Identifier getTexture(FrankFireballEntity entity) {
        return TEXTURE;
    }
}
