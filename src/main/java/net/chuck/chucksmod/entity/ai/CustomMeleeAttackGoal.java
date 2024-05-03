package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.MeleeAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.util.Hand;

public class CustomMeleeAttackGoal extends MeleeAttackGoal {
    private final MeleeAttackMob meleeMob;
    private final int windup;
    private final int animationLength;
    private final float attackRange;
    private int ticksUntilNextAttack;
    private boolean shouldCountUntilNextAttack = false;
    public CustomMeleeAttackGoal(MeleeAttackMob mob, double speed, boolean pauseWhenMobIdle, int attackWindup,
                                 int animationLength, float attackRange){
        super(mob.getPathAwareEntity(), speed, pauseWhenMobIdle);
        meleeMob = mob;
        windup = attackWindup;
        this.animationLength = animationLength;
        ticksUntilNextAttack = attackWindup;
        this.attackRange = attackRange;
    }

    @Override
    public void start() {
        super.start();
        ticksUntilNextAttack = windup;
    }
    @Override
    protected void attack(LivingEntity target) {
        if(isEnemyWithinAttackDistance(target)){
            shouldCountUntilNextAttack = true;
            if(isTimeToStartAttackAnimation()) mob.setAttacking(true);
            if(isTimeToAttack()){
                this.mob.getLookControl().lookAt(target.getX(), target.getEyeY(), target.getZ());
                performAttack(target);
            }
        } else {
            resetAttackCooldown();
            shouldCountUntilNextAttack = false;
            mob.setAttacking(false);
            meleeMob.setAttackAnimationCooldown(0);
        }
    }
    protected boolean isEnemyWithinAttackDistance(LivingEntity pEnemy){
        return mob.distanceTo(pEnemy) <= attackRange;
    }
    private void resetAttackCooldown(){this.ticksUntilNextAttack = getTickCount(animationLength+1);}
    private boolean isTimeToStartAttackAnimation(){return ticksUntilNextAttack <= windup;}
    private boolean isTimeToAttack(){return ticksUntilNextAttack <= 0;}
    protected void performAttack(LivingEntity pEnemy){
        resetAttackCooldown();
        mob.swingHand(Hand.MAIN_HAND);
        mob.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountUntilNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack-1, 0);
        }
    }
    @Override
    public void stop() {
        mob.setAttacking(false);
        super.stop();
    }
}
