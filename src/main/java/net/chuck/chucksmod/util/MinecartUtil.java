package net.chuck.chucksmod.util;

import net.minecraft.block.enums.RailShape;
import net.minecraft.util.math.Vec3d;

public class MinecartUtil {
    public static Vec3d snapVelocityToTrack(RailShape shape, Vec3d velocity){
        if(shape.equals(RailShape.ASCENDING_NORTH) || shape.equals(RailShape.ASCENDING_SOUTH) ||
                shape.equals(RailShape.NORTH_SOUTH)){
            velocity = new Vec3d(0, velocity.y, velocity.z);
        }
        if(shape.equals(RailShape.ASCENDING_EAST) || shape.equals(RailShape.ASCENDING_WEST) ||
                shape.equals(RailShape.EAST_WEST)){
            velocity = new Vec3d(velocity.x, velocity.y, 0);
        }
        // +x, +z
        if(shape.equals(RailShape.NORTH_EAST) || shape.equals(RailShape.SOUTH_WEST)) {
            //moving in positive z
            if (velocity.x == 0) velocity = new Vec3d(velocity.z, velocity.y, 0);
            else velocity = new Vec3d(0, velocity.y, velocity.x);
        }
        if(shape.equals(RailShape.NORTH_WEST) || shape.equals(RailShape.SOUTH_EAST)) {
            //moving in positive z
            if(velocity.x == 0) velocity = new Vec3d(0, velocity.y, -velocity.x);
            else velocity = new Vec3d(-velocity.z, velocity.y, 0);
        }
        return velocity;
    }
}
