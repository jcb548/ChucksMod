package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
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
    protected void resetCooldown(){
        this.ticksUntilNextAttack = this.getTickCount(SoulBlazeBoss.ANIMATION_LENGTH);
    }
    protected boolean isTimeToAttack(){
        return this.ticksUntilNextAttack <= 0;
    }
    protected boolean isTimeToStartAttackAnimation(){
        return this.ticksUntilNextAttack <= attackDelay;
    }
    protected void performAttack(){
        this.resetCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(entity.enemy);
        this.entity.attackCounter++;
        if(entity.attackCounter >= SoulBlazeBoss.SPECIAL_ATTACK_FREQ){
            entity.enemy.damage(entity.getDamageSources().mobAttack(entity),
                    (float)entity.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)/2);
            Vec3d vec = new Vec3d(entity.getX()-entity.enemy.getX(),0,entity.getZ()-entity.enemy.getZ());
            vec.normalize();
            entity.enemy.takeKnockback(3, vec.x, vec.z);
            entity.enemy.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40));
            entity.ticksUntilShoot = SoulBlazeBoss.ATTACK_WINDUP + SoulBlazeBoss.SHOOT_WINDUP;
            entity.attackCounter = 0;
        }
    }

    @Override
    protected void attack(LivingEntity target) {
        entity.enemy = target;
        if (isEnemyWithinAttackDistance(target)) {
            shouldCountTillNextAttack = true;
            if (isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }
            if (isTimeToAttack()) {
                this.mob.getLookControl().lookAt(target.getX(), target.getY(), target.getZ());
                performAttack();
            }
        } else {
            resetCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }
}
