package net.chuck.pigsnstuff.entity.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.FrankEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class FrankModel extends GeoModel<FrankEntity> {
    @Override
    public Identifier getModelResource(FrankEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "geo/frank.geo.json");
    }

    @Override
    public Identifier getTextureResource(FrankEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/frank_texture.png");
    }

    @Override
    public Identifier getAnimationResource(FrankEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "animations/frank.animation.json");
    }
}
