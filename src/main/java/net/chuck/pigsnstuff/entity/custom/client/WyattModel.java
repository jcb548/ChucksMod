package net.chuck.pigsnstuff.entity.custom.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.WyattEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WyattModel extends GeoModel<WyattEntity> {
    @Override
    public Identifier getModelResource(WyattEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "geo/wyatt.geo.json");
    }

    @Override
    public Identifier getTextureResource(WyattEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/wyatt.png");
    }

    @Override
    public Identifier getAnimationResource(WyattEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "animations/wyatt.animation.json");
    }

    @Override
    public void setCustomAnimations(WyattEntity animatable, long instanceId, AnimationState<WyattEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
