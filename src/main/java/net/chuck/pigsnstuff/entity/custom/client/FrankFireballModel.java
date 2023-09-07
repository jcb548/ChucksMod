package net.chuck.pigsnstuff.entity.custom.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.FrankFireballEntity;
import net.chuck.pigsnstuff.entity.custom.FrankEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class FrankFireballModel extends GeoModel<FrankFireballEntity> {
    @Override
    public Identifier getModelResource(FrankFireballEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "geo/frank_fireball.geo.json");
    }

    @Override
    public Identifier getTextureResource(FrankFireballEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/frank_fireball.png");
    }

    @Override
    public Identifier getAnimationResource(FrankFireballEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "animations/frank_fireball.animation.json");
    }
}
