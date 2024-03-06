package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.FarmabynEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class FarmabynRenderer extends MobEntityRenderer<FarmabynEntity, FarmabynModel<FarmabynEntity>> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID, "textures/entity/farmabyn.png");
    public FarmabynRenderer(EntityRendererFactory.Context context) {
        super(context, new FarmabynModel<>(context.getPart(ModModelLayers.FARMABYN)), 0.6f);
        addFeature(new HeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    @Override
    public Identifier getTexture(FarmabynEntity entity) {
        return TEXTURE;
    }
}
