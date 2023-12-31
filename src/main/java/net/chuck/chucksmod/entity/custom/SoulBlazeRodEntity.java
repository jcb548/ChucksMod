package net.chuck.chucksmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.text.Text;

public class SoulBlazeRodEntity extends ExplosiveProjectileEntity {
    private final float DAMAGE = 10.0f;
    public static final float DEFAULT_POWER = 0.4f;
    private float power;
    public SoulBlazeRodEntity(EntityType<? extends ExplosiveProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public SoulBlazeRodEntity(EntityType<? extends ExplosiveProjectileEntity> type, LivingEntity owner,
            double x, double y, double z, double directionX, double directionY, double directionZ, World world, double power) {
        this(type, world);
        this.refreshPositionAndAngles(x, y, z, this.getYaw(), this.getPitch());
        this.refreshPosition();
        double d = Math.sqrt(directionX * directionX + directionY * directionY + directionZ * directionZ);
        if (d != 0.0) {
            this.powerX = directionX / d * power;
            this.powerY = directionY / d * power;
            this.powerZ = directionZ / d * power;
        }
        this.setPitch(owner.getPitch());
        this.setYaw(owner.getYaw());
        this.power = (float)power;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient){
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(),
                    power+1f, false, World.ExplosionSourceType.MOB);
            this.discard();
        }
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if(!entityHitResult.getEntity().equals(this.getOwner())) {
            if (!this.getWorld().isClient) {
                this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(),
                        power+1.6f, false, World.ExplosionSourceType.MOB);
                this.discard();
            }
            Entity entity = entityHitResult.getEntity();
            Entity owner = this.getOwner();
            if (owner instanceof LivingEntity livingOwner) {
                entity.damage(this.getDamageSources().mobProjectile(this, livingOwner), DAMAGE);
            } else {
                entity.damage(this.getDamageSources().magic(), 6.0f);
            }
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.takeKnockback(4, -this.getVelocity().x, -this.getVelocity().z);
            }
        }
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    protected boolean isBurning() {
        return isOnFire();
    }
}
