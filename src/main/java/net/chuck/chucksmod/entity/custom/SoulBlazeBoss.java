package net.chuck.chucksmod.entity.custom;

import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.entity.ai.SoulBlazeAttackGoal;
import net.chuck.chucksmod.entity.ai.SoulBlazeMoveControl;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.util.ModEntityStatuses;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
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
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

public class SoulBlazeBoss extends CustomBoss implements RangedAttackMob{
    private static final TrackedData<Integer> INVUL = DataTracker.registerData(SoulBlazeBoss.class,
            TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> SHOOTING =
            DataTracker.registerData(SoulBlazeBoss.class, TrackedDataHandlerRegistry.BOOLEAN);
    private final int INVUL_TIME = 100;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState leftAttackAnimationState = new AnimationState();
    private boolean leftAttack = false;
    public final AnimationState shootAnimationState = new AnimationState();
    public static final int SHOOT_WINDUP = 4;
    public int attackCounter = 0;
    public int ticksUntilShoot = -1;
    public int shootAnimationTimeout = 0;
    private int shootAnimationTicksRemaining = 0;
    public static final int SPECIAL_ATTACK_FREQ = 4;
    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(this.getDisplayName(), BossBar.Color.BLUE,
            BossBar.Style.PROGRESS).setDarkenSky(false);
    public SoulBlazeBoss(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new SoulBlazeMoveControl(this);
        this.setInvulnerable(true);
    }
    @Override
    public int getAttackAnimationLength() {
        return 10;
    }
    @Override
    public int getAttackWindup() {
        return 5;
    }
    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public boolean isImmuneToExplosion() {
        return true;
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
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 96)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2);
    }
    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(true);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SoulBlazeAttackGoal(this, 1.0, 30, 32f, false));

        this.goalSelector.add(1, new FlyGoal(this, 1));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 32f));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, AnimalEntity.class, false));
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
    protected void updateAnimations(){
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
        if(this.isAttacking() && attackAnimationCooldown<=0){
            attackAnimationCooldown = getAttackAnimationLength();
            leftAttack = !leftAttack;
            if(leftAttack) {
                leftAttackAnimationState.start(age);
            } else {
                attackAnimationState.start(age);
            }
        } else {
            if(attackAnimationCooldown>=0) --this.attackAnimationCooldown;
        }
        if(!this.isAttacking()){
            stopMeleeAttackAnimation();
        }
        if(this.isShooting() && shootAnimationTimeout <= 0){
            shootAnimationTimeout = getAttackAnimationCooldown();
            shootAnimationState.start(age);
        } else {
            if(shootAnimationTimeout>=0) --this.shootAnimationTimeout;
        }
        if(!this.isShooting()){
            shootAnimationState.stop();
        }
    }
    public void stopMeleeAttackAnimation(){
        if (leftAttack) {
            leftAttackAnimationState.stop();
        } else {
            attackAnimationState.stop();
        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(INVUL, INVUL_TIME);
        this.dataTracker.startTracking(SHOOTING, false);
    }
    public void setShooting(boolean shooting){
        this.dataTracker.set(SHOOTING, shooting);
    }
    public boolean isShooting(){
        return this.dataTracker.get(SHOOTING);
    }
    public int getInvulTimer(){
        return this.dataTracker.get(INVUL);
    }
    public void setInvulTimer(int invulnerableTime) {
        this.dataTracker.set(INVUL, invulnerableTime);
    }
    @Override
    protected void mobTick() {
        int invulTicks = this.getInvulTimer();
        if (invulTicks > 0) {
            invulTicks--;
            this.setInvulTimer(invulTicks);
            if (invulTicks <= 0) {
                this.setInvulnerable(false);
                this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(),
                        3.0f, true, World.ExplosionSourceType.MOB);
            }
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX() +
                    this.random.nextGaussian() * (double) 0.3f, this.getY() +
                    this.random.nextGaussian() * (double) 0.3f, this.getZ() +
                    this.random.nextGaussian() * (double) 0.3f, 0.0, 0.0, 0.0);
            this.getWorld().playSound(this.getX(), this.getY(), this.getZ(),
                    SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE.value(), SoundCategory.HOSTILE, 10f, 10f, false);
        }
        handleShootAfterAttackCombo();
        super.mobTick();
    }

    private void handleShootAfterAttackCombo(){
        if (ticksUntilShoot > 0) {
            ticksUntilShoot--;
            if (ticksUntilShoot == 4) {
                this.setShooting(true);
                shootAnimationTicksRemaining = getAttackAnimationLength();
            }
            if (ticksUntilShoot == 0) {
                if (getTarget() != null) shootAt(getTarget(), 1);
            }
        }
        if (shootAnimationTicksRemaining > 0){
            shootAnimationTicksRemaining--;
        } else {
            this.setShooting(false);
        }
    }
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("invul", this.getInvulTimer());
        nbt.putInt("attack_count", this.attackCounter);
        nbt.putBoolean("left_attack", leftAttack);
        nbt.putInt("ticks_till_shoot",ticksUntilShoot);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setInvulTimer(nbt.getInt("invul"));
        this.attackCounter = nbt.getInt("attack_count");
        this.leftAttack = nbt.getBoolean("left_attack");
        this.ticksUntilShoot = nbt.getInt("ticks_till_shoot");
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        this.shootRodAt(target, pullProgress);
    }
    private void shootRodAt(LivingEntity target, double power) {
        this.shootRodAt(target.getX(), target.getY() +
                (double)target.getStandingEyeHeight() * 0.5, target.getZ(), power);
    }

    private void shootRodAt(double targetX, double targetY, double targetZ, double power) {
        if (!this.isSilent()) {
            this.getWorld().syncWorldEvent(null, WorldEvents.BLAZE_SHOOTS, this.getBlockPos(), 0);
        }
        this.getWorld().sendEntityStatus(this, ModEntityStatuses.SHOOT_FIREBALL);
        double xDir = targetX - this.getX();
        double yDir = targetY - (this.getY()+2.0f);
        double zDir = targetZ - this.getZ();
        SoulBlazeRodEntity soulBlazeRodEntity = new SoulBlazeRodEntity(ModEntities.SOUL_BLAZE_ROD,
                this, this.getX(), this.getY()+2.0f, this.getZ(), xDir, yDir, zDir, this.getWorld(), power);
        soulBlazeRodEntity.setOwner(this);
        soulBlazeRodEntity.setPos(this.getX(), this.getY()+2.0f, this.getZ());
        this.getWorld().spawnEntity(soulBlazeRodEntity);
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if(source.getSource() instanceof SoulBlazeRodEntity){
            return false;
        }
        return super.damage(source, amount);
    }
}
