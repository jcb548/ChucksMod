package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.FrankBoss;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FrankRenderer extends MobEntityRenderer<FrankBoss, FrankModel<FrankBoss>> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID, "textures/entity/frank_texture.png");

    public FrankRenderer(EntityRendererFactory.Context context) {
        super(context, new FrankModel<>(context.getPart(ModModelLayers.FRANK)), 1.0f);
    }

    // Scale entity
    @Override
    public void render(FrankBoss entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(1.5f, 1.5f, 1.5f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public Identifier getTexture(FrankBoss entity) {
        return TEXTURE;
    }
}
