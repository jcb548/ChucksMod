package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SoulBlazeRenderer extends MobEntityRenderer<SoulBlazeBoss, SoulBlazeModel<SoulBlazeBoss>> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID, "textures/entity/soul_blaze.png");
    public SoulBlazeRenderer(EntityRendererFactory.Context context) {
        super(context, new SoulBlazeModel<>(context.getPart(ModModelLayers.SOUL_BLAZE)), 0.8f);
    }

    @Override
    public Identifier getTexture(SoulBlazeBoss entity) {
        return TEXTURE;
    }

    @Override
    public void render(SoulBlazeBoss mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1.5f, 1.5f, 1.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
