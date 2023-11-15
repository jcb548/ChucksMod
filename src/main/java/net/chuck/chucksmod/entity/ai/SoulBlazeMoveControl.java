package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class SoulBlazeMoveControl extends MoveControl {
    private final SoulBlazeBoss soulBlaze;

    public SoulBlazeMoveControl(SoulBlazeBoss entity) {
        super(entity);
        this.soulBlaze = entity;
    }

    @Override
    public void tick() {
        if (this.state != MoveControl.State.MOVE_TO) {
            return;
        }
        lowHealthMovement();
        float newYaw = (float)(MathHelper.atan2(soulBlaze.getVelocity().z, soulBlaze.getVelocity().x) * 57.2957763671875) - 90.0f;
        this.soulBlaze.setYaw(this.wrapDegrees(this.soulBlaze.getYaw(), newYaw, 90.0f));
        this.soulBlaze.getLookControl().lookAt(this.soulBlaze.getVelocity());
        this.soulBlaze.setHeadYaw(this.wrapDegrees(this.soulBlaze.getYaw(), newYaw, 90.0f));
    }

    private void lowHealthMovement(){
        Vec3d vec3d = new Vec3d(this.targetX - this.soulBlaze.getX(), this.targetY - this.soulBlaze.getY(), this.targetZ - this.soulBlaze.getZ());
        if(this.targetY > this.soulBlaze.getY() - 2){
            vec3d = new Vec3d(vec3d.x, 2, vec3d.z);
        }
        double velMul = 0.1;
        this.soulBlaze.setVelocity(this.soulBlaze.getVelocity().add(vec3d.multiply(velMul)));
    }
}
