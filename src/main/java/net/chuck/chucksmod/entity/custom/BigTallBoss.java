package net.chuck.chucksmod.entity.custom;

import net.chuck.chucksmod.entity.ai.BigTallBasicAttackGoal;
import net.chuck.chucksmod.entity.ai.BigTallRunAtGoal;
import net.chuck.chucksmod.sounds.ModSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Arm;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BigTallBoss extends HostileEntity implements MeleeAttackMob{
    public static final int RUN_AT_RANGE = 32;
    public static final int ATTACK_ANIMATION_LENGTH = 18;
    public static final int SPINNING_ANIMATION_LENGTH = 27;
    public static final int ATTACK_WINDUP = 5;
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(BigTallBoss.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> SPINNING =
            DataTracker.registerData(BigTallBoss.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationCooldown = 0;
    public final AnimationState spinAnimationState = new AnimationState();
    public int spinAnimationCooldown = 0;
    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(this.getDisplayName(), BossBar.Color.PURPLE,
            BossBar.Style.PROGRESS).setDarkenSky(false);
    public BigTallBoss(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new BigTallRunAtGoal(this));
        this.goalSelector.add(2, new BigTallBasicAttackGoal(this, 0.8f, true));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.5f, 1));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 40));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(SPINNING, false);
    }

    @Override
    public PathAwareEntity getPathAwareEntity() {
        return this;
    }

    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING, attacking);
    }
    public boolean isAttacking(){
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    public void setAttackAnimationCooldown(int cooldown) {
        attackAnimationCooldown = cooldown;
    }

    @Override
    public int getAttackAnimationCooldown() {
        return attackAnimationCooldown;
    }

    public void setSpinning(boolean spinning){
        this.dataTracker.set(SPINNING, spinning);
    }
    public boolean isSpinning(){
        return this.dataTracker.get(SPINNING);
    }
    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }
    private void updateAnimations(){
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
        if(isAttacking() && attackAnimationCooldown <= 0){
            attackAnimationCooldown = ATTACK_ANIMATION_LENGTH;
            attackAnimationState.start(age);
        } else if(attackAnimationCooldown >= 0){
            --attackAnimationCooldown;
        }
        if(!isAttacking()){
            attackAnimationState.stop();
        }
        if(isSpinning() && spinAnimationCooldown<=0){
            spinAnimationCooldown = SPINNING_ANIMATION_LENGTH;
            spinAnimationState.start(this.age);
        } else {
            --spinAnimationCooldown;
        }
        if(!isSpinning()){
            spinAnimationState.stop();
        }
    }
    @Override
    public void checkDespawn() {
        if (this.getWorld().getDifficulty() == Difficulty.PEACEFUL && this.isDisallowedInPeaceful()) {
            this.discard();
            return;
        }
        this.despawnCounter = 0;
    }
    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }
    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            updateAnimations();
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return super.isInvulnerableTo(damageSource) || (getHealth() < getMaxHealth()/2 && damageSource.isIn(DamageTypeTags.IS_PROJECTILE));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BIGTAL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BIGTAL_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BIGTAL_AMBIENT;
    }

    @Override
    public int getMinAmbientSoundDelay() {
        return 160;
    }

    @Override
    public FallSounds getFallSounds() {
        return new LivingEntity.FallSounds(ModSounds.BIGTAL_SMALL_FALL, ModSounds.BIGTAL_BIG_FALL);
    }
}
