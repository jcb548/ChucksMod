package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.SmotolEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class SmotolRenderer extends MobEntityRenderer<SmotolEntity, SmotolModel<SmotolEntity>> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID, "textures/entity/smotol.png");
    public SmotolRenderer(EntityRendererFactory.Context context) {
        super(context, new SmotolModel<>(context.getPart(ModModelLayers.SMOTOL)), 0.4f);
    }

    @Override
    public Identifier getTexture(SmotolEntity entity) {
        return TEXTURE;
    }
}
