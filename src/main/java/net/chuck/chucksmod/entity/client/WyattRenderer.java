package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.WyattEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WyattRenderer extends MobEntityRenderer<WyattEntity, WyattModel<WyattEntity>> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID, "textures/entity/wyatt.png");
    public WyattRenderer(EntityRendererFactory.Context context) {
        super(context, new WyattModel<>(context.getPart(ModModelLayers.WYATT)), 0.6f);
    }
    @Override
    public Identifier getTexture(WyattEntity entity) {
        return TEXTURE;
    }
    @Override
    public void render(WyattEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
