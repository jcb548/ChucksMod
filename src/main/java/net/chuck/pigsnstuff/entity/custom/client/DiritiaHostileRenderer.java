package net.chuck.pigsnstuff.entity.custom.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.DiritiaHostileEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DiritiaHostileRenderer extends GeoEntityRenderer<DiritiaHostileEntity> {
    public DiritiaHostileRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new DiritiaHostileModel());
    }

    @Override
    public Identifier getTextureLocation(DiritiaHostileEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/diritia_hostile.png");
    }

    @Override
    public void render(DiritiaHostileEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
