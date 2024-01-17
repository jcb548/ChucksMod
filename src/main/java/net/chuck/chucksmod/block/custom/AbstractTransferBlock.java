package net.chuck.chucksmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTransferBlock extends BlockWithEntity {
    public static final BooleanProperty EAST = Properties.EAST;
    public static final BooleanProperty WEST = Properties.WEST;
    public static final BooleanProperty NORTH = Properties.NORTH;
    public static final BooleanProperty SOUTH = Properties.SOUTH;
    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty DOWN = Properties.DOWN;
    public static final Map<Direction, BooleanProperty> PROPERTY_MAP = Util.make(new HashMap<>(), map -> {
        map.put(Direction.EAST, EAST);
        map.put(Direction.WEST, WEST);
        map.put(Direction.NORTH, NORTH);
        map.put(Direction.SOUTH, SOUTH);
        map.put(Direction.UP, UP);
        map.put(Direction.DOWN, DOWN);
    });
    public AbstractTransferBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState()
                .with(EAST, false)
                .with(WEST, false)
                .with(NORTH, false)
                .with(SOUTH, false)
                .with(UP, false)
                .with(DOWN, false)
        );
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(EAST, WEST, NORTH, SOUTH, UP, DOWN);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return TransferBlockShapeUtil.getShape(state);
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return TransferBlockShapeUtil.getShape(state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
