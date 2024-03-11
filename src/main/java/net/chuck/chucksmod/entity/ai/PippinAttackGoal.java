package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.FarmabynEntity;
import net.chuck.chucksmod.entity.custom.PippinBoss;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public class PippinAttackGoal extends MeleeAttackGoal {
    private final PippinBoss entity;
    private int ticksUntilNextAttack = PippinBoss.ATTACK_WINDUP;
    private boolean shouldCountUntilNextAttack = false;
    public PippinAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = (PippinBoss) mob;
    }

    @Override
    public void start() {
        super.start();
        ticksUntilNextAttack = PippinBoss.ATTACK_WINDUP;
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
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
        return entity.distanceTo(pEnemy) <= 3f;
    }
    private void resetAttackCooldown(){ticksUntilNextAttack = getTickCount(PippinBoss.ATTACK_ANIMATION_LENGTH);}
    private boolean isTimeToStartAttackAnimation(){return ticksUntilNextAttack <= PippinBoss.ATTACK_WINDUP;}
    private boolean isTimeToAttack(){return ticksUntilNextAttack <= 0;}
    private void performAttack(LivingEntity pEnemy){
        entity.swingHand(Hand.MAIN_HAND);
        entity.tryAttack(pEnemy);
        resetAttackCooldown();
    }

    @Override
    protected void attack(LivingEntity target) {
        if(isEnemyWithinAttackDistance(target)){
            shouldCountUntilNextAttack = true;
            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }
            if(isTimeToAttack()){
                this.entity.getLookControl().lookAt(target.getX(), target.getEyeY(), target.getZ());
                performAttack(target);
            }
        } else {
            resetAttackCooldown();
            shouldCountUntilNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationCooldown = 0;
        }
    }
}
