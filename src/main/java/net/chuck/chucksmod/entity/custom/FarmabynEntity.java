package net.chuck.chucksmod.entity.custom;

import net.chuck.chucksmod.entity.ai.CustomMeleeAttackGoal;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Arm;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FarmabynEntity extends HostileEntity implements MeleeAttackMob{
    public static final int ANIMATION_LENGTH = 15;
    public static final int ATTACK_WINDUP = 13;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationCooldown = 0;
    public FarmabynEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createFarmabynAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 25)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new CustomMeleeAttackGoal(this, 1.0d, true,
                ATTACK_WINDUP, ANIMATION_LENGTH, 2f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8f, 5));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 64));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public PathAwareEntity getPathAwareEntity() {
        return this;
    }

    @Override
    public void setAttackAnimationCooldown(int cooldown) {
        attackAnimationCooldown = cooldown;
    }

    @Override
    public int getAttackAnimationCooldown() {
        return attackAnimationCooldown;
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
            attackAnimationCooldown = ANIMATION_LENGTH;
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
    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }
}
