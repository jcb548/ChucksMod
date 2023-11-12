package net.chuck.chucksmod.block.custom.energy_storage;

import net.chuck.chucksmod.block.entity.energy_storage.AbstractEnergyStorageBlockEntity;
import net.chuck.chucksmod.util.DirectionEnergyIOProperty;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractEnergyStorageBlock extends BlockWithEntity implements BlockEntityProvider{
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final DirectionEnergyIOProperty UP = DirectionEnergyIOProperty.UP;
    public static final DirectionEnergyIOProperty DOWN = DirectionEnergyIOProperty.DOWN;
    public static final DirectionEnergyIOProperty NORTH = DirectionEnergyIOProperty.NORTH;
    public static final DirectionEnergyIOProperty SOUTH = DirectionEnergyIOProperty.SOUTH;
    public static final DirectionEnergyIOProperty EAST = DirectionEnergyIOProperty.EAST;
    public static final DirectionEnergyIOProperty WEST = DirectionEnergyIOProperty.WEST;
    protected AbstractEnergyStorageBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(UP, DirectionEnergyIOProperty.DISABLED)
                .with(DOWN, DirectionEnergyIOProperty.DISABLED)
                .with(NORTH, DirectionEnergyIOProperty.DISABLED)
                .with(SOUTH, DirectionEnergyIOProperty.DISABLED)
                .with(EAST, DirectionEnergyIOProperty.INSERT)
                .with(WEST, DirectionEnergyIOProperty.EXTRACT)
        );
    }
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction blockFacing = ctx.getHorizontalPlayerFacing().getOpposite();
        return this.getDefaultState().with(FACING, blockFacing)
                .with(DirectionEnergyIOProperty.getProperty(blockFacing),
                        DirectionEnergyIOProperty.DISABLED)
                .with(DirectionEnergyIOProperty.getProperty(blockFacing.getOpposite()),
                        DirectionEnergyIOProperty.DISABLED)
                .with(DirectionEnergyIOProperty.getProperty(blockFacing.rotateYClockwise()),
                        DirectionEnergyIOProperty.INSERT)
                .with(DirectionEnergyIOProperty.getProperty(blockFacing.rotateYCounterclockwise()),
                        DirectionEnergyIOProperty.EXTRACT);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, UP, DOWN, NORTH, SOUTH, EAST, WEST);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AbstractEnergyStorageBlockEntity) {
                ItemScatterer.spawn(world, pos, (AbstractEnergyStorageBlockEntity)blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
