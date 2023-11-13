package net.chuck.chucksmod.entity.ai;

import net.minecraft.entity.ai.goal.PounceAtTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Vec3d;

public class DashAtTargetGoal extends PounceAtTargetGoal {
    private float xMultiplier = 1;
    private float zMultiplier = 1;

    public DashAtTargetGoal(MobEntity mob, float xMul, float velocity, float zMul) {
        super(mob, velocity);
        xMultiplier = xMul;
        zMultiplier = zMul;
    }

    @Override
    public boolean canStart() {
        if (this.mob.hasControllingPassenger()) {
            return false;
        }
        this.target = this.mob.getTarget();
        if (this.target == null) {
            return false;
        }
        double d = this.mob.squaredDistanceTo(this.target);
        if (d < 16.0 || d > 256.0) {
            return false;
        }
        if (!this.mob.isOnGround()) {
            return false;
        }
        return this.mob.getRandom().nextInt(PounceAtTargetGoal.toGoalTicks(5)) == 0;
    }

    @Override
    public void start() {
        Vec3d vec3d = this.mob.getVelocity();
        Vec3d vec3d2 = new Vec3d(this.target.getX() - this.mob.getX(), 0.0, this.target.getZ() - this.mob.getZ());
        if (vec3d2.lengthSquared() > 1.0E-7) {
            vec3d2 = vec3d2.normalize().multiply(0.4).add(vec3d.multiply(0.2));
        }
        this.mob.setVelocity(xMultiplier*vec3d2.x, this.velocity, zMultiplier*vec3d2.z);
    }
}
