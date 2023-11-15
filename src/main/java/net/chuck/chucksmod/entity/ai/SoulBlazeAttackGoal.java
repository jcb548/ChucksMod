package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.chuck.chucksmod.entity.custom.SoulBlazeRodEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

public class SoulBlazeAttackGoal extends MeleeAttackGoal {
    private final SoulBlazeBoss soulBlaze;
    private int attackDelay = SoulBlazeBoss.ATTACK_WINDUP;
    private int ticksUntilNextAttack = SoulBlazeBoss.ATTACK_WINDUP;
    private boolean shouldCountTillNextAttack = false;
    private int updateCountdownTicks = -1;
    private int seenTargetTicks;
    private final int intervalTicks;
    private final float squaredMaxShootRange;
    private final double mobSpeed;

    public SoulBlazeAttackGoal(PathAwareEntity mob, double speed, int intervalTicks,
                               float maxShootRange, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        soulBlaze = (SoulBlazeBoss) mob;
        this.mobSpeed = speed;
        this.intervalTicks = intervalTicks;
        this.squaredMaxShootRange = maxShootRange * maxShootRange;
    }
    @Override
    public boolean canStart() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null || !livingEntity.isAlive()) {
            return false;
        }
        soulBlaze.setTarget(livingEntity);
        return true;
    }

    @Override
    public void start() {
        super.start();
        this.soulBlaze.setAttacking(false);
        this.soulBlaze.enemy = soulBlaze.getTarget();
        attackDelay = SoulBlazeBoss.ATTACK_WINDUP;
        this.ticksUntilNextAttack = SoulBlazeBoss.ATTACK_WINDUP;
    }

    @Override
    public void stop() {
        soulBlaze.setAttacking(false);
        super.stop();
    }

    @Override
    public void tick() {
        if(soulBlaze.getHealth() > 0.5* soulBlaze.getMaxHealth()){
            aboveHalfHealthTick();
        } else {
            super.tick();
            if (shouldCountTillNextAttack) {
                this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            }
        }
    }

    public void aboveHalfHealthTick() {
        double d = this.soulBlaze.squaredDistanceTo(this.soulBlaze.enemy);
        boolean canSeeEnemy = this.mob.getVisibilityCache().canSee(this.soulBlaze.enemy);
        this.seenTargetTicks = canSeeEnemy ? ++this.seenTargetTicks : 0;
        if (d > (double)this.squaredMaxShootRange || this.seenTargetTicks < 5) {
            this.mob.getNavigation().startMovingTo(this.soulBlaze.enemy, mobSpeed);
        } else {
            this.mob.getNavigation().stop();
        }
        this.mob.getLookControl().lookAt(this.soulBlaze.enemy, 30.0f, 30.0f);
        if (--this.updateCountdownTicks == 0) {
            if (!canSeeEnemy) {
                return;
            }
            this.soulBlaze.shootAt(this.soulBlaze.enemy, SoulBlazeRodEntity.DEFAULT_POWER);
            this.updateCountdownTicks = this.intervalTicks;
        } else if (this.updateCountdownTicks < 0) {
            this.updateCountdownTicks = this.intervalTicks;
        }
    }
    private boolean isEnemyWithinAttackDistance(LivingEntity enemy){
        return this.soulBlaze.distanceTo(enemy) <= 6f;
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
        this.mob.tryAttack(soulBlaze.enemy);
        this.soulBlaze.attackCounter++;
        if(soulBlaze.attackCounter >= SoulBlazeBoss.SPECIAL_ATTACK_FREQ){
            soulBlaze.enemy.damage(soulBlaze.getDamageSources().mobAttack(soulBlaze),
                    (float)soulBlaze.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)/2);
            Vec3d vec = new Vec3d(soulBlaze.getX()-soulBlaze.enemy.getX(),0,soulBlaze.getZ()-soulBlaze.enemy.getZ());
            vec.normalize();
            soulBlaze.enemy.takeKnockback(3, vec.x, vec.z);
            soulBlaze.enemy.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40));
            soulBlaze.ticksUntilShoot = SoulBlazeBoss.ATTACK_WINDUP + SoulBlazeBoss.SHOOT_WINDUP;
            soulBlaze.attackCounter = 0;
        }
    }

    @Override
    protected void attack(LivingEntity target) {
        soulBlaze.enemy = target;
        if (isEnemyWithinAttackDistance(target)) {
            shouldCountTillNextAttack = true;
            if (isTimeToStartAttackAnimation()) {
                soulBlaze.setAttacking(true);
            }
            if (isTimeToAttack()) {
                this.mob.getLookControl().lookAt(target.getX(), target.getY(), target.getZ());
                performAttack();
            }
        } else {
            resetCooldown();
            shouldCountTillNextAttack = false;
            soulBlaze.setAttacking(false);
            soulBlaze.attackAnimationTimeout = 0;
        }
    }
}
