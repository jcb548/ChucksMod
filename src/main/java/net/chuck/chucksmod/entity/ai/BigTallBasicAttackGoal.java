package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.animation.BigTallAnimations;
import net.chuck.chucksmod.entity.custom.BigTallBoss;
import net.chuck.chucksmod.entity.custom.BigTallBoss;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class BigTallBasicAttackGoal extends MeleeAttackGoal {
    private final BigTallBoss boss;
    private int ticksUntilNextAttack = BigTallBoss.ATTACK_WINDUP;
    private boolean shouldCountUntilNextAttack = false;
    public BigTallBasicAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        boss = (BigTallBoss) mob;
    }

    @Override
    public boolean canStart() {
        return super.canStart() && !(boss.isRunning() || boss.isSpinning());
    }

    @Override
    public void stop() {
        boss.setAttacking(false);
        super.stop();
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountUntilNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack-1, 0);
        }
    }
    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy){
        return boss.distanceTo(pEnemy) <= 3f;
    }
    private void resetAttackCooldown(){ticksUntilNextAttack = getTickCount(BigTallBoss.ATTACK_ANIMATION_LENGTH);}
    private boolean isTimeToStartAttackAnimation(){return ticksUntilNextAttack <= BigTallBoss.ATTACK_WINDUP;}
    private boolean isTimeToAttack(){return ticksUntilNextAttack <= 0;}
    private void performAttack(LivingEntity pEnemy){
        resetAttackCooldown();
        boss.swingHand(Hand.MAIN_HAND);
        boss.tryAttack(pEnemy);
    }

    @Override
    protected void attack(LivingEntity target) {
        if(isEnemyWithinAttackDistance(target)){
            shouldCountUntilNextAttack = true;
            if(isTimeToStartAttackAnimation()){
                boss.setAttacking(true);
            }
            if(isTimeToAttack()){
                this.boss.getLookControl().lookAt(target.getX(), target.getEyeY(), target.getZ());
                performAttack(target);
            }
        } else {
            resetAttackCooldown();
            shouldCountUntilNextAttack = false;
            boss.setAttacking(false);
            boss.attackAnimationCooldown = 0;
        }
    }
}
