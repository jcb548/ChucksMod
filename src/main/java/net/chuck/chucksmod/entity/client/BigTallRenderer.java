package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.BigTallBoss;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BigTallRenderer extends MobEntityRenderer<BigTallBoss, BigTallModel<BigTallBoss>> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID, "textures/entity/big_tall.png");
    public BigTallRenderer(EntityRendererFactory.Context context) {
        super(context, new BigTallModel<>(context.getPart(ModModelLayers.BIG_TALL)), 0.6f);
    }

    @Override
    public Identifier getTexture(BigTallBoss entity) {
        return TEXTURE;
    }
}
