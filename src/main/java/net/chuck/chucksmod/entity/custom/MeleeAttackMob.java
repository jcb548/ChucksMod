package net.chuck.chucksmod.entity.custom;

import net.minecraft.entity.mob.PathAwareEntity;

public interface MeleeAttackMob {
    PathAwareEntity getPathAwareEntity();
    void setAttackAnimationCooldown(int cooldown);
    int getAttackAnimationCooldown();
}
