package net.chuck.chucksmod.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.RailShape;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.event.GameEvent;

public class MinecartUtil {
    public static Vec3d snapVelocityToTrack(RailShape shape, Vec3d velocity){
        switch (shape){
            case NORTH_SOUTH:{
                velocity = new Vec3d(0, 0, velocity.z);
                break;
            }
            case EAST_WEST:{
                velocity = new Vec3d(velocity.x, 0, 0);
                break;
            }
            case ASCENDING_NORTH:{
                velocity = new Vec3d(0, -velocity.z, velocity.z);
                break;
            }
            default:{
                velocity = new Vec3d(0, 0, velocity.z);
            }
        }
        return velocity;
    }

    public static Vec3d snapPositionToRails(RailShape shape, Vec3d pos){
        System.out.println(pos);
        System.out.println(shape);
        int xOffset = 0;
        if(pos.x < 0) xOffset = 1;
        int yOffset = 0;
        if(pos.y < 0) yOffset = 1;
        int zOffset = 0;
        if(pos.z < 0) zOffset = 1;
        Vec3d newPos = new Vec3d(0, 0, 0);
        switch (shape){
            case NORTH_SOUTH:{
                newPos = new Vec3d((int)pos.x + 0.5 - xOffset, pos.y, pos.z);
                break;
            }
            case EAST_WEST:{
                newPos = new Vec3d(pos.x, pos.y, (int)pos.z + 0.5 - zOffset);
                break;
            }
            case ASCENDING_NORTH:{
                newPos = new Vec3d((int)pos.x + 0.5 - xOffset, pos.y/*(int)pos.y - yOffset - (1-Math.abs(pos.z - (int)pos.z))*/, pos.z);
                break;
            }
        }
        System.out.println("newPos: "+ newPos);
        return newPos;
    }
}
