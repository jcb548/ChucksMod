package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class SoulBlazeMoveControl extends MoveControl {
    private final SoulBlazeBoss soulBlaze;
    private int collisionCheckCooldown;

    public SoulBlazeMoveControl(SoulBlazeBoss entity) {
        super(entity);
        this.soulBlaze = entity;
    }

    @Override
    public void tick() {
        if (this.state != MoveControl.State.MOVE_TO) {
            return;
        }
        if (this.collisionCheckCooldown-- <= 0) {
            this.collisionCheckCooldown += this.soulBlaze.getRandom().nextInt(5) + 2;
            Vec3d vec3d = new Vec3d(this.targetX - this.soulBlaze.getX(), this.targetY - this.soulBlaze.getY(), this.targetZ - this.soulBlaze.getZ());
            double d = vec3d.length();
            if (this.willCollide(vec3d = vec3d.normalize(), MathHelper.ceil(d))) {
                this.soulBlaze.setVelocity(this.soulBlaze.getVelocity().add(vec3d.multiply(0.35)));
            } else {
                this.state = MoveControl.State.WAIT;
            }
        }
    }
    private boolean willCollide(Vec3d direction, int steps) {
        Box box = this.soulBlaze.getBoundingBox();
        for (int i = 1; i < steps; ++i) {
            box = box.offset(direction);
            if (this.soulBlaze.getWorld().isSpaceEmpty(this.soulBlaze, box)) continue;
            return false;
        }
        return true;
    }
}
