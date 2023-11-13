package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

public class SoulBlazeMeleeAttackGoal extends MeleeAttackGoal {
    private final SoulBlazeBoss entity;
    private int attackDelay = SoulBlazeBoss.ATTACK_WINDUP;
    private int ticksUntilNextAttack = SoulBlazeBoss.ATTACK_WINDUP;
    private boolean shouldCountTillNextAttack = false;

    public SoulBlazeMeleeAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = (SoulBlazeBoss) mob;
    }

    @Override
    public void start() {
        super.start();
        attackDelay = SoulBlazeBoss.ATTACK_WINDUP;
        this.ticksUntilNextAttack = SoulBlazeBoss.ATTACK_WINDUP;
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack-1, 0);
        }
    }
    private boolean isEnemyWithinAttackDistance(LivingEntity enemy){
        return this.entity.distanceTo(enemy) <= 3f;
    }
    protected void resetAttackCooldown(){
        this.ticksUntilNextAttack = this.getTickCount(SoulBlazeBoss.ATTACK_ANIMATION_LENGTH);
    }
    protected boolean isTimeToAttack(){
        return this.ticksUntilNextAttack <= 0;
    }
    protected boolean isTimeToStartAttackAnimation(){
        return this.ticksUntilNextAttack <= attackDelay;
    }
    protected void performAttack(LivingEntity enemy){
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(enemy);
        this.entity.attackCounter++;
        if(entity.attackCounter >= SoulBlazeBoss.SPECIAL_ATTACK_FREQ){
            enemy.damage(entity.getDamageSources().mobAttack(entity),
                    (float)entity.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)/2);
            Vec3d vec = new Vec3d(enemy.getX()-entity.getX(),enemy.getY()-entity.getY(),enemy.getZ()-entity.getZ());
            vec.normalize();
            enemy.takeKnockback(10, vec.x, vec.z);
        }
    }

    @Override
    protected void attack(LivingEntity target) {
        if(isEnemyWithinAttackDistance(target)){
            shouldCountTillNextAttack = true;
            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }
            if(isTimeToAttack()){
                this.mob.getLookControl().lookAt(target.getX(), target.getY(), target.getZ());
                performAttack(target);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }
}
