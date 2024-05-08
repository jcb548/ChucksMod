package net.chuck.chucksmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

public abstract class CustomHostileEntity extends HostileEntity implements MeleeAttackMob{
    public final AnimationState idleAnimationState = new AnimationState();
    protected int idleAnimationCooldown = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationCooldown = 0;
    public CustomHostileEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    public abstract int getAttackAnimationLength();
    public abstract int getAttackWindup();
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
    protected void updateAnimations(){
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
        if(isAttacking() && attackAnimationCooldown <=0){
            attackAnimationCooldown = getAttackAnimationLength();
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
