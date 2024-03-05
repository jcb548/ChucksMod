package net.chuck.chucksmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FarmabynEntity extends GolemEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;
    public FarmabynEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createFarmabynAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 25)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.2f, 10));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 64));
        this.goalSelector.add(4, new LookAroundGoal(this));
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
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            updateAnimations();
        }
    }
}
