package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.TriafianPigEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class TriafianPigRenderer extends MobEntityRenderer<TriafianPigEntity, TriafianPigModel<TriafianPigEntity>> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID, "textures/entity/triafian_pig.png");
    public TriafianPigRenderer(EntityRendererFactory.Context context) {
        super(context, new TriafianPigModel<>(context.getPart(ModModelLayers.TRIAFIAN_PIG)), 0.6f);
    }

    @Override
    public Identifier getTexture(TriafianPigEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TriafianPigEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) matrixStack.scale(0.6f, 0.6f, 0.6f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
