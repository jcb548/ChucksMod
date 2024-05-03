package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.BigTallBoss;
import net.chuck.chucksmod.entity.custom.MeleeAttackMob;

public class BigTallBasicAttackGoal extends CustomMeleeAttackGoal {
    private final BigTallBoss boss;
    public BigTallBasicAttackGoal(BigTallBoss mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle, BigTallBoss.ATTACK_WINDUP, BigTallBoss.ATTACK_ANIMATION_LENGTH, 3f);
        boss = mob;
    }
    @Override
    public boolean canStart() {
        return super.canStart() && !boss.isSpinning();
    }
}
