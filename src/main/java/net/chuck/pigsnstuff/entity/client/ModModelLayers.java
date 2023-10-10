package net.chuck.pigsnstuff.entity.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer WYATT =
            new EntityModelLayer(new Identifier(PigsNStuff.MOD_ID, "wyatt"), "main");
    public static final EntityModelLayer FRANK =
            new EntityModelLayer(new Identifier(PigsNStuff.MOD_ID, "frank"), "main");
    public static final EntityModelLayer FRANK_FIREBALL =
            new EntityModelLayer(new Identifier(PigsNStuff.MOD_ID, "frank_fireball"), "main");
}
