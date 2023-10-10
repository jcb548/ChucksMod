package net.chuck.pigsnstuff.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class FrankFireballEntity extends ExplosiveProjectileEntity{
    public FrankFireballEntity(EntityType<? extends ExplosiveProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public FrankFireballEntity(EntityType<? extends ExplosiveProjectileEntity> type, double x, double y, double z,
                               double directionX, double directionY, double directionZ, World world) {
        this(type, world);
        this.refreshPositionAndAngles(x, y, z, this.getYaw(), this.getPitch());
        this.refreshPosition();
        double d = Math.sqrt(directionX * directionX + directionY * directionY + directionZ * directionZ);
        if (d != 0.0) {
            this.powerX = directionX / d * 0.2;
            this.powerY = directionY / d * 0.2;
            this.powerZ = directionZ / d * 0.2;
        }
    }
    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient){
            this.getWorld().createExplosion((Entity) this, this.getX(), this.getY(), this.getZ(),
                    1.0f, true, World.ExplosionSourceType.MOB);
            this.discard();
        }
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!this.getWorld().isClient){
            this.getWorld().createExplosion((Entity) this, this.getX(), this.getY(), this.getZ(),
                    1.0f, true, World.ExplosionSourceType.MOB);
            this.discard();
        }
        Entity entity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        if(owner instanceof LivingEntity livingOwner){
            entity.damage(this.getDamageSources().mobProjectile(this, livingOwner), 10.0f);
        } else {
            entity.damage(this.getDamageSources().magic(), 6.0f);
        }

    }
    @Override
    public boolean canHit() {
        return false;
    }
}
