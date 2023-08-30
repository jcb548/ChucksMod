package net.chuck.pigsnstuff.entity.custom.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.WyattEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WyattRenderer extends GeoEntityRenderer<WyattEntity> {
    public WyattRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WyattModel());
    }

    @Override
    public Identifier getTextureLocation(WyattEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/wyatt.png");
    }

    @Override
    public void render(WyattEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
