package net.chuck.pigsnstuff.entity.custom.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.FrankFireballEntity;
import net.chuck.pigsnstuff.entity.custom.FrankEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FrankFireballRenderer extends GeoEntityRenderer<FrankFireballEntity> {
    public FrankFireballRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FrankFireballModel());
    }
    @Override
    public Identifier getTextureLocation(FrankFireballEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/frank_fireball.png");
    }

    @Override
    public void render(FrankFireballEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
