package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer WYATT =
            new EntityModelLayer(new Identifier(ChucksMod.MOD_ID, "wyatt"), "main");
    public static final EntityModelLayer FRANK =
            new EntityModelLayer(new Identifier(ChucksMod.MOD_ID, "frank"), "main");
    public static final EntityModelLayer FRANK_FIREBALL =
            new EntityModelLayer(new Identifier(ChucksMod.MOD_ID, "frank_fireball"), "main");
    public static final EntityModelLayer SOUL_BLAZE =
            new EntityModelLayer(new Identifier(ChucksMod.MOD_ID, "soul_blaze"), "main");
}
