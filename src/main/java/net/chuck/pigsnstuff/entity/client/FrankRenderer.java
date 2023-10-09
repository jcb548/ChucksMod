package net.chuck.pigsnstuff.entity.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.FrankEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

public class FrankRenderer extends GeoEntityRenderer<FrankEntity> {
    private static final String MAIN_HAND = "left_arm_lower";
    protected ItemStack heldItem;

    public FrankRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FrankModel());
        addRenderLayer(new BlockAndItemGeoLayer<>(this){
            @Override
            protected ItemStack getStackForBone(GeoBone bone, FrankEntity animatable) {
                if (bone.getName().equals(MAIN_HAND)){
                    return FrankRenderer.this.heldItem;
                } else {
                    return null;
                }
                /*switch (bone.getName()){
                    case MAIN_HAND:  return FrankRenderer.this.heldItem;
                }*/
            }

            @Override
            protected void renderStackForBone(MatrixStack poseStack, GeoBone bone, ItemStack stack,
                                              FrankEntity animatable, VertexConsumerProvider bufferSource,
                                              float partialTick, int packedLight, int packedOverlay) {
                if (stack == FrankRenderer.this.heldItem) {
                    poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90f));
                    poseStack.translate(0.4f, -0.7f, -0.75f);
                    poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(55f));
                    poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180f));
                    super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick,
                            packedLight, packedOverlay);
                }
            }
        });
    }

    @Override
    public Identifier getTextureLocation(FrankEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/frank_texture.png");
    }

    // Scale entity
    @Override
    public void render(FrankEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(1.5f, 1.5f, 1.5f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public void preRender(MatrixStack poseStack, FrankEntity animatable, BakedGeoModel model,
                          VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender,
                          float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick,
                packedLight, packedOverlay, red, green, blue, alpha);
        this.heldItem = animatable.getMainHandStack();
    }
}
