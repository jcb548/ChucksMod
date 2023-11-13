package net.chuck.chucksmod.entity.custom;

import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.entity.ai.DashAtTargetGoal;
import net.chuck.chucksmod.entity.ai.SoulBlazeMeleeAttackGoal;
import net.chuck.chucksmod.util.ModEntityStatuses;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
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
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

public class SoulBlazeBoss extends HostileEntity implements RangedAttackMob{
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(SoulBlazeBoss.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> INVUL = DataTracker.registerData(SoulBlazeBoss.class,
            TrackedDataHandlerRegistry.INTEGER);
    private final int INVUL_TIME = 60;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState leftAttackAnimationState = new AnimationState();
    public final AnimationState rightAttackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public static final int ATTACK_ANIMATION_LENGTH = 10;
    public static final int ATTACK_WINDUP = 5;
    private boolean left_attack = false;
    private boolean shoot_fireball_this_tick = false;
    public int attackCounter = 0;
    public int ticksUntilShoot = 4;
    public static final int SPECIAL_ATTACK_FREQ = 4;
    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(this.getDisplayName(), BossBar.Color.BLUE,
            BossBar.Style.PROGRESS).setDarkenSky(false);
    public SoulBlazeBoss(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, false);
        this.setInvulnerable(true);
    }

    @Override
    protected int computeFallDamage(float fallDistance, float damageMultiplier) {
        return 0;
    }

    public static DefaultAttributeContainer.Builder createSoulBlazeAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 9)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 5)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 1.5f);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanSwim(true);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.0, 30, 96f));
        this.goalSelector.add(2, new FlyGoal(this, 3));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 96f));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, AnimalEntity.class, false));
    }

    protected void halfHealthGoals() {
        this.clearGoals(goal -> true);
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new DashAtTargetGoal(this, 3, 0.6f, 3));
        this.goalSelector.add(2, new SoulBlazeMeleeAttackGoal(this, 1.5d, true));
        this.goalSelector.add(3, new FlyGoal(this, 3));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 16));
        this.goalSelector.add(5, new LookAroundGoal(this));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BLAZE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_BLAZE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BLAZE_DEATH;
    }

    @Override
    protected void updateLimbs(float posDelta) {
        super.updateLimbs(posDelta);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient){
            setupAnimationStates();
        }
    }
    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
        if(this.isAttacking() && attackAnimationTimeout<=0){
            left_attack = !left_attack;
            attackAnimationTimeout = ATTACK_ANIMATION_LENGTH;
            if(left_attack) {
                leftAttackAnimationState.start(age);
            } else {
                rightAttackAnimationState.start(age);
            }
        } else {
            --this.attackAnimationTimeout;
        }
        if(!this.isAttacking()){
            if(left_attack){
                leftAttackAnimationState.stop();
            } else {
                rightAttackAnimationState.stop();
            }
        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(INVUL, INVUL_TIME);
    }
    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING, attacking);
    }
    public boolean isAttacking(){
        return this.dataTracker.get(ATTACKING);
    }
    public int getInvulTimer(){
        return this.dataTracker.get(INVUL);
    }
    public void setInvulTimer(int invulnerableTime) {
        this.dataTracker.set(INVUL, invulnerableTime);
    }

    @Override
    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    @Override
    protected void mobTick() {
        int invulTicks = this.getInvulTimer();
        if(invulTicks>0){
            invulTicks--;
            this.setInvulTimer(invulTicks);
            if(invulTicks <= 0){
                this.setInvulnerable(false);
            }
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX() + this.random.nextGaussian() * (double)0.3f, this.getY() + this.random.nextGaussian() * (double)0.3f, this.getZ() + this.random.nextGaussian() * (double)0.3f, 0.0, 0.0, 0.0);
        }
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
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
    public void tickMovement() {
        /*if (!this.isOnGround() && this.getVelocity().y < 0.0) {
            this.setVelocity(this.getVelocity().multiply(1.0, 0.7, 1.0));
        }
         */
        super.tickMovement();
    }
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Invul", this.getInvulTimer());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setInvulTimer(nbt.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        this.shootRodAt(target);
    }
    private void shootRodAt(LivingEntity target) {
        this.shootRodAt(target.getX(), target.getY() +
                (double)target.getStandingEyeHeight() * 0.5, target.getZ());
    }

    private void shootRodAt(double targetX, double targetY, double targetZ) {
        if (!this.isSilent()) {
            this.getWorld().syncWorldEvent(null, WorldEvents.WITHER_SHOOTS, this.getBlockPos(), 0);
        }
        this.getWorld().sendEntityStatus(this, ModEntityStatuses.SHOOT_FIREBALL);
        double xDir = targetX - this.getX();
        double yDir = targetY - (this.getY()+2.0f);
        double zDir = targetZ - this.getZ();
        SoulBlazeRodEntity soulBlazeRodEntity = new SoulBlazeRodEntity(ModEntities.SOUL_BLAZE_ROD, this.getX(), this.getY()+2.0f,
                this.getZ(), xDir, yDir, zDir, this.getWorld());
        soulBlazeRodEntity.setOwner(this);
        soulBlazeRodEntity.setPos(this.getX(), this.getY()+2.0f, this.getZ());
        this.getWorld().spawnEntity(soulBlazeRodEntity);
    }
}
