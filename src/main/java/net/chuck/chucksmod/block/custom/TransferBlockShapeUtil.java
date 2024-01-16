package net.chuck.chucksmod.block.custom;

import net.chuck.chucksmod.util.DirectionIOProperty;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class TransferBlockShapeUtil {
    private static final Map<BlockState, VoxelShape> SHAPE_CACHE = new IdentityHashMap<>();

    private static VoxelShape getStateShape(BlockState state) {
        final double size = 0.375;
        final VoxelShape baseShape = VoxelShapes.cuboid(size, size, size, 1 - size, 1 - size, 1 - size);
        final List<VoxelShape> connections = new ArrayList<>();
        for (Direction dir : Direction.values()) {
            if (state.get(AbstractTransferBlock.PROPERTY_MAP.get(dir))) {
                double[] mins = new double[] { size, size, size };
                double[] maxs = new double[] { 1 - size, 1 - size, 1 - size };
                int axis = dir.getAxis().ordinal();
                if (dir.getDirection() == Direction.AxisDirection.POSITIVE) {
                    maxs[axis] = 1;
                } else {
                    mins[axis] = 0;
                }
                connections.add(VoxelShapes.cuboid(mins[0], mins[1], mins[2], maxs[0], maxs[1], maxs[2]));
            }
        }
        return VoxelShapes.union(baseShape, connections.toArray(new VoxelShape[]{}));
    }

    public static VoxelShape getShape(BlockState state) {
        return SHAPE_CACHE.computeIfAbsent(state, TransferBlockShapeUtil::getStateShape);
    }

}