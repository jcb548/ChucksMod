package net.chuck.pigsnstuff.entity.custom;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DiritiaHostileEntity extends HostileEntity implements GeoEntity{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public DiritiaHostileEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0d)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0d, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        targetSelector.add(2, new ActiveTargetGoal<>(this, LivingEntity.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller",
                -20, this::predicate),
                new AnimationController<>(this, "attackController",
                -20, this::attackPredicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        /*if(tAnimationState.isMoving() && this.handSwinging){
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("animation.diritia_hostile.attack", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else */if(tAnimationState.isMoving()){
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("animation.diritia_hostile.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("animation.diritia_hostile.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
    }

    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> tAnimationState){
        if(this.isAttacking()) {
            tAnimationState.getController().stop();
            tAnimationState.getController().forceAnimationReset();
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .thenPlay("animation.diritia_hostile.attack"));
        }
        return PlayState.CONTINUE;
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
