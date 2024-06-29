package net.chuck.chucksmod.util;

import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.RailShape;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.*;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MinecartUtil {
    public static Vec3d snapVelocityToTrack(RailShape shape, Vec3d velocity, Vec3d pos){
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
            case ASCENDING_SOUTH:{
                velocity = new Vec3d(0, velocity.z, velocity.z);
                break;
            }
            case ASCENDING_EAST:{
                velocity = new Vec3d(velocity.x, velocity.x, 0);
                break;
            }
            case ASCENDING_WEST:{
                velocity = new Vec3d(velocity.x, -velocity.x, 0);
                break;
            }
            case NORTH_EAST:{
            }
        }
        return velocity;
    }

    public static Vec3d snapPositionToRails(RailShape shape, BlockPos blockPos, Vec3d pos){
        //System.out.println(pos);
        //System.out.println(shape);
        int xOffset = 0;
        if(pos.x < 0) xOffset = 1;
        int yOffset = 0;
        if(pos.y < 0) yOffset = 1;
        int zOffset = 0;
        if(pos.z < 0) zOffset = 1;
        Vec3d newPos = new Vec3d(0, 0, 0);
        System.out.println(shape);
        double blockX = pos.x + xOffset - (int)pos.x;
        double blockZ = pos.z + zOffset - (int)pos.z;
        System.out.println(blockX + ", " + blockZ);
        switch (shape){
            case NORTH_SOUTH, ASCENDING_SOUTH, ASCENDING_NORTH:{
                newPos = new Vec3d((int)pos.x + 0.5 - xOffset, pos.y, pos.z);
                break;
            }
            case EAST_WEST, ASCENDING_EAST, ASCENDING_WEST:{
                newPos = new Vec3d(pos.x, pos.y, (int)pos.z + 0.5 - zOffset);
                break;
            }
            case NORTH_EAST:
                //if(pos.x - (int)pos.x > 0.5)
        }
        return newPos;
    }

    public static List<VoxelShape> checkCollisions(AbstractMinecartEntity minecart, Vec3d velocity, BlockPos pos){
        Iterable<VoxelShape> initCollisions = minecart.getWorld().getBlockCollisions(minecart,
                minecart.getBoundingBox().stretch(velocity.multiply(1, 0, 1)));
        ArrayList<VoxelShape> collisions = new ArrayList<VoxelShape>();
        World world = minecart.getWorld();
        for (VoxelShape collision : initCollisions){
            BlockPos colPos = new BlockPos((int)collision.getMin(Direction.Axis.X), (int)collision.getMin(Direction.Axis.Y),
                    (int)collision.getMin(Direction.Axis.Z));
            //System.out.println(getRailShape(world.getBlockState(colPos.south())));
            if((world.getBlockState(colPos.south()).getBlock() instanceof AbstractRailBlock &&
                    getRailShape(world.getBlockState(colPos.south())).equals(RailShape.ASCENDING_NORTH)) ||
            (world.getBlockState(colPos.north()).getBlock() instanceof AbstractRailBlock &&
                    getRailShape(world.getBlockState(colPos.north())).equals(RailShape.ASCENDING_SOUTH)) ||
            (world.getBlockState(colPos.east()).getBlock() instanceof AbstractRailBlock &&
                    getRailShape(world.getBlockState(colPos.east())).equals(RailShape.ASCENDING_WEST)) ||
            (world.getBlockState(colPos.west()).getBlock() instanceof AbstractRailBlock &&
                    getRailShape(world.getBlockState(colPos.west())).equals(RailShape.ASCENDING_EAST))){
            } else {
                collisions.add(collision);
            }
        }
        return collisions;
    }

    public static RailShape getRailShape(BlockState state){
        return state.get(((AbstractRailBlock)state.getBlock()).getShapeProperty());
    }
    
    public static Vec3d adjustVelocityForCollisions(Vec3d velocity, Box entityBoundingBox, List<VoxelShape> collisions){
        boolean zFasterThanX;
        if (collisions.isEmpty()) {
            return velocity;
        }
        double x = velocity.x;
        double y = velocity.y;
        double z = velocity.z;
        zFasterThanX = Math.abs(x) < Math.abs(z);
        if (zFasterThanX && z != 0.0 && (z = VoxelShapes.calculateMaxOffset(Direction.Axis.Z, entityBoundingBox, collisions, z)) != 0.0) {
            entityBoundingBox = entityBoundingBox.offset(0.0, 0.0, z);
        }
        if (x != 0.0) {
            x = VoxelShapes.calculateMaxOffset(Direction.Axis.X, entityBoundingBox, collisions, x);
            if (!zFasterThanX && x != 0.0) {
                entityBoundingBox = entityBoundingBox.offset(x, 0.0, 0.0);
            }
        }
        if (!zFasterThanX && z != 0.0) {
            z = VoxelShapes.calculateMaxOffset(Direction.Axis.Z, entityBoundingBox, collisions, z);
        }
        return new Vec3d(x, y, z);
    }
}
