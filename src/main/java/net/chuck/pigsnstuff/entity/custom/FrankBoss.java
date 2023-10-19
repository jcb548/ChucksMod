package net.chuck.pigsnstuff.entity.custom;

import net.chuck.pigsnstuff.entity.ModEntities;
import net.chuck.pigsnstuff.util.ModEntityStatuses;
import net.minecraft.entity.*;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

public class FrankBoss extends HostileEntity implements RangedAttackMob{
    public final net.minecraft.entity.AnimationState idleAnimationState = new net.minecraft.entity.AnimationState();
    private int idleAnimationTimeout = 0;
    public final net.minecraft.entity.AnimationState attackingAnimationState = new AnimationState();
    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(this.getDisplayName(), BossBar.Color.PURPLE,
            BossBar.Style.PROGRESS).setDarkenSky(false);
    public FrankBoss(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0d)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 18.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0, 20, 30.0f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        targetSelector.add(2, new ActiveTargetGoal<>(this, LivingEntity.class, true));
    }

    @Override
    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    @Override
    protected void mobTick() {
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
    public void shootAt(LivingEntity target, float pullProgress) {
        this.shootFireballAt(target);
    }

    private void shootFireballAt(LivingEntity target) {
        this.shootFireballAt(target.getX(), target.getY() +
                (double)target.getStandingEyeHeight() * 0.5, target.getZ());
    }

    private void shootFireballAt(double targetX, double targetY, double targetZ) {
        if (!this.isSilent()) {
            this.getWorld().syncWorldEvent(null, WorldEvents.WITHER_SHOOTS, this.getBlockPos(), 0);
        }
        this.getWorld().sendEntityStatus(this, ModEntityStatuses.SHOOT_FIREBALL);
        double xDir = targetX - this.getX();
        double yDir = targetY - (this.getY()+2.0f);
        double zDir = targetZ - this.getZ();
        FrankFireballEntity frankFireballEntity = new FrankFireballEntity(ModEntities.FRANK_FIREBALL, this.getX(), this.getY()+2.0f,
                this.getZ(), xDir, yDir, zDir, this.getWorld());
        frankFireballEntity.setOwner(this);
        frankFireballEntity.setPos(this.getX(), this.getY()+2.0f, this.getZ());
        this.getWorld().spawnEntity(frankFireballEntity);
        this.swingHand(this.getActiveHand());
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        EntityData data = super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        this.setLeftHanded(true);
        return data;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }
    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <=0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == ModEntityStatuses.SHOOT_FIREBALL) {
            this.idleAnimationState.stop();
            this.attackingAnimationState.start(this.age);
        } else {
            super.handleStatus(status);
        }
    }
}
