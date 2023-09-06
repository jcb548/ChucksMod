package net.chuck.pigsnstuff.entity.custom.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.FrankEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FrankRenderer extends GeoEntityRenderer<FrankEntity> {

    public FrankRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FrankModel());
    }

    @Override
    public Identifier getTextureLocation(FrankEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/frank_texture.png");
    }

    // Scale entity
    @Override
    public void render(FrankEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
