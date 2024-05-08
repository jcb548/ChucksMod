package net.chuck.chucksmod.entity.custom;

import net.chuck.chucksmod.entity.ai.CustomMeleeAttackGoal;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Arm;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SmotolEntity extends CustomHostileEntity {
    public SmotolEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public int getAttackAnimationLength() {
        return 22;
    }
    @Override
    public int getAttackWindup() {
        return 9;
    }
    public static DefaultAttributeContainer.Builder createSmotolAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35f)
                .add(EntityAttributes.GENERIC_ARMOR, 3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 9);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new CustomMeleeAttackGoal(this, 1.0d, true,
                getAttackWindup(), getAttackAnimationLength(), 2f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8f, 5));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 64));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }
}
