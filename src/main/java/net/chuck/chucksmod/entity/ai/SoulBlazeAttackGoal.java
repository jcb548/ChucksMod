package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.MeleeAttackMob;
import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.chuck.chucksmod.entity.custom.SoulBlazeRodEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

public class SoulBlazeAttackGoal extends CustomMeleeAttackGoal {
    private final SoulBlazeBoss soulBlaze;
    private int updateCountdownTicks = -1;
    private int seenTargetTicks;
    private final int intervalTicks;
    private final float squaredMaxShootRange;
    private final double mobSpeed;

    public SoulBlazeAttackGoal(SoulBlazeBoss mob, double speed, int intervalTicks,
                               float maxShootRange, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle, mob.getAttackWindup(), mob.getAttackAnimationLength(), 6f);
        soulBlaze = mob;
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
    }

    @Override
    public void tick() {
        if(soulBlaze.getHealth() > 0.5* soulBlaze.getMaxHealth()){
            aboveHalfHealthTick();
        } else {
            super.tick();
        }
    }

    public void aboveHalfHealthTick() {
        double d = this.soulBlaze.squaredDistanceTo(this.soulBlaze.getTarget());
        boolean canSeeEnemy = this.mob.getVisibilityCache().canSee(this.soulBlaze.getTarget());
        this.seenTargetTicks = canSeeEnemy ? ++this.seenTargetTicks : 0;
        if (d > (double)this.squaredMaxShootRange || this.seenTargetTicks < 5) {
            this.mob.getNavigation().startMovingTo(this.soulBlaze.getTarget(), mobSpeed);
        } else {
            this.mob.getNavigation().stop();
        }
        this.mob.getLookControl().lookAt(this.soulBlaze.getTarget(), 30.0f, 30.0f);
        if (--this.updateCountdownTicks == 0) {
            if (!canSeeEnemy) {
                return;
            }
            this.soulBlaze.shootAt(this.soulBlaze.getTarget(), SoulBlazeRodEntity.DEFAULT_POWER);
            this.updateCountdownTicks = this.intervalTicks;
        } else if (this.updateCountdownTicks < 0) {
            this.updateCountdownTicks = this.intervalTicks;
        }
    }
    @Override
    protected void performAttack(LivingEntity target){
        this.resetCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(target);
        this.soulBlaze.attackCounter++;
        if(soulBlaze.attackCounter >= SoulBlazeBoss.SPECIAL_ATTACK_FREQ){
            target.damage(soulBlaze.getDamageSources().mobAttack(soulBlaze),
                    (float)soulBlaze.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)/2);
            Vec3d vec = new Vec3d(soulBlaze.getX()-target.getX(),0,soulBlaze.getZ()-target.getZ());
            vec.normalize();
            target.takeKnockback(3, vec.x, vec.z);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40));
            soulBlaze.ticksUntilShoot = this.soulBlaze.getAttackWindup() + SoulBlazeBoss.SHOOT_WINDUP;
            soulBlaze.attackCounter = 0;
        }
    }
}
