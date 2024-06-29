package net.chuck.chucksmod.mixin;

import com.mojang.datafixers.util.Pair;
import net.chuck.chucksmod.block.ModBlockTags;
import net.chuck.chucksmod.util.MinecartUtil;
import net.minecraft.block.*;
import net.minecraft.block.enums.RailShape;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(AbstractMinecartEntity.class)
public abstract class AbstractMinecartEntityMixin{
    @Inject(method = "getMaxSpeed", at = @At("RETURN"), cancellable = true)
    private void injected(CallbackInfoReturnable<Double> cir){
        cir.setReturnValue(cir.getReturnValue()*2.5);
    }

    @Redirect(method = "moveOnRail",at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean injected2(BlockState state, Block block){
        return state.isIn(ModBlockTags.POWERED_RAILS);
    }

    @ModifyVariable(method = "moveOnRail", at = @At("STORE"), ordinal = 1)
    private Vec3d injected3(Vec3d vec3d){
       // System.out.println(vec3d.length());
        //System.out.println(vec3d.y);
        return vec3d;
    }
    @ModifyVariable(method = "moveOffRail", at = @At("STORE"), ordinal = -1)
    private Vec3d injected4(Vec3d value){
        //System.out.println(value.length());
        //System.out.println(value.y);
        return value;
    }

    @ModifyVariable(method = "tick", at = @At("STORE"))
    private BlockState injected5(BlockState state){
        //System.out.println(state);
        return state;
    }
    @ModifyVariable(method = "tick", at = @At("STORE"))
    private BlockPos injected6(BlockPos pos){
        //System.out.println(pos);
        return pos;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target =
            "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity;moveOnRail(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"))
    private void moveOnRails(AbstractMinecartEntity minecart, BlockPos pos, BlockState state){
        double x = minecart.getX();
        double y = minecart.getY();
        double z = minecart.getZ();
        minecart.onLanding();
        Vec3d velocity = minecart.getVelocity().multiply(1, 0, 1);
        RailShape railShape = state.get(((AbstractRailBlock)state.getBlock()).getShapeProperty());
        velocity = MinecartUtil.snapVelocityToTrack(railShape, velocity, minecart.getPos());
        double gravity = 1.0/128;
        boolean poweredRail = false;
        boolean isPowered = false;
        if(state.isIn(ModBlockTags.POWERED_RAILS)){
            poweredRail = true;
            isPowered = state.get(PoweredRailBlock.POWERED);
        }
        switch (railShape) {
            case ASCENDING_EAST: {
                velocity.add(-gravity, 0.0, 0.0);
                break;
            }
            case ASCENDING_WEST: {
                velocity.add(gravity, 0.0, 0.0);
                break;
            }
            case ASCENDING_NORTH: {
                velocity.add(0.0, 0.0, gravity);
                break;
            }
            case ASCENDING_SOUTH: {
                velocity.add(0.0, 0.0, -gravity);
            }
        }
        Pair<Vec3i, Vec3i> pair = AbstractMinecartEntity.getAdjacentRailPositionsByShape(railShape);
        Vec3i rail1 = pair.getFirst();
        Vec3i rail2 = pair.getSecond();
        Vec3i nextRail = rail1;
        if(velocity.x > 0 && rail1.getX() < 0 && velocity.z == 0) nextRail = rail2;
        else if(velocity.z > 0 && rail1.getZ() < 0 && velocity.x == 0) nextRail = rail2;
        int railXDif = Math.abs(rail1.getX() - rail2.getX());
        int railYDif = Math.abs(rail1.getY() - rail2.getY());
        int railZDif = Math.abs(rail1.getZ() - rail2.getZ());
        if(minecart.getVelocity().horizontalLength() > 0) minecart.setVelocity(Vec3d.of(nextRail).multiply(0.1, 0, 0.1));
        List<VoxelShape> collisions = MinecartUtil.checkCollisions(minecart, velocity, pos);
        velocity = MinecartUtil.adjustVelocityForCollisions(velocity, minecart.getBoundingBox(), collisions);
        minecart.setPosition(x + velocity.x, y + velocity.y, z + velocity.z);
        minecart.setPosition(MinecartUtil.snapPositionToRails(railShape, pos, minecart.getPos()));
    }
}
