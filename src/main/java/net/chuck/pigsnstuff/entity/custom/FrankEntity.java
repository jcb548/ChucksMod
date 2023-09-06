package net.chuck.pigsnstuff.entity.custom;

import net.chuck.pigsnstuff.entity.FrankFireballEntity;
import net.chuck.pigsnstuff.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class FrankEntity extends HostileEntity implements GeoEntity, RangedAttackMob {
    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(this.getDisplayName(), BossBar.Color.PURPLE,
            BossBar.Style.PROGRESS).setDarkenSky(false);
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public FrankEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0d)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 18.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0, 40, 20.0f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        targetSelector.add(2, new ActiveTargetGoal<>(this, LivingEntity.class, true));
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller",
                0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()){
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("animation.frank.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("animation.frank.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
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
    public void attack(LivingEntity target, float pullProgress) {
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
        double xDir = targetX - this.getX();
        double yDir = targetY - this.getY();
        double zDir = targetZ - this.getZ();
        FrankFireballEntity frankFireballEntity = new FrankFireballEntity(ModEntities.FRANK_FIREBALL, this.getX(), this.getY(),
                this.getZ(), xDir, yDir, zDir, this.getWorld());
        frankFireballEntity.setOwner(this);
        frankFireballEntity.setPos(this.getX(), this.getY(), this.getZ());
        this.getWorld().spawnEntity(frankFireballEntity);
    }
}
