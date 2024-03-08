package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.PippinBoss;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class PippinRenderer extends MobEntityRenderer<PippinBoss, PippinModel<PippinBoss>> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID, "textures/entity/pippin.png");
    public PippinRenderer(EntityRendererFactory.Context context) {
        super(context, new PippinModel<>(context.getPart(ModModelLayers.PIPPIN)), 0.4f);
        addFeature(new HeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    @Override
    public Identifier getTexture(PippinBoss entity) {
        return TEXTURE;
    }
}
