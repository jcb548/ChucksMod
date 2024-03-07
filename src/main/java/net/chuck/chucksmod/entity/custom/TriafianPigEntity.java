package net.chuck.chucksmod.entity.custom;

import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.entity.ai.FarmabynAttackGoal;
import net.chuck.chucksmod.entity.ai.TriafianPigAttackGoal;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TriafianPigEntity extends AnimalEntity {
    public static final int ANIMATION_LENGTH = 11;
    public static final int ATTACK_WINDUP = 8;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationCooldown = 0;
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(TriafianPigEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public TriafianPigEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder setAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.TRIAFIAN_PIG.create(world);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new TriafianPigAttackGoal(this, 1.0d, true));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8f, 5));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 64));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }
    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING, attacking);
    }
    public boolean isAttacking(){
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }
    private void updateAnimations(){
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
        if(isAttacking() && attackAnimationCooldown <=0){
            attackAnimationCooldown = 15;
            attackAnimationState.start(age);
        } else {
            --attackAnimationCooldown;
        }
        if(!isAttacking()){
            attackAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            updateAnimations();
        }
    }
}
