package net.chuck.pigsnstuff.entity.custom.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.DiritiaHostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DiritiaHostileModel extends GeoModel<DiritiaHostileEntity> {
    @Override
    public Identifier getModelResource(DiritiaHostileEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "geo/diritia_hostile.geo.json");
    }

    @Override
    public Identifier getTextureResource(DiritiaHostileEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/diritia_hostile.png");
    }

    @Override
    public Identifier getAnimationResource(DiritiaHostileEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "animations/diritia_hostile.animation.json");
    }

    /*@Override
    public void setCustomAnimations(DiritiaHostileEntity animatable, long instanceId, AnimationState<DiritiaHostileEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }*/
}
