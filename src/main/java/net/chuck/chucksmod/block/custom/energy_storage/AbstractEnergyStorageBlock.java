package net.chuck.chucksmod.block.custom.energy_storage;

import net.chuck.chucksmod.block.entity.energy_storage.AbstractEnergyStorageBlockEntity;
import net.chuck.chucksmod.util.DirectionIOProperty;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractEnergyStorageBlock extends BlockWithEntity implements BlockEntityProvider{
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final DirectionIOProperty UP = DirectionIOProperty.UP;
    public static final DirectionIOProperty DOWN = DirectionIOProperty.DOWN;
    public static final DirectionIOProperty NORTH = DirectionIOProperty.NORTH;
    public static final DirectionIOProperty SOUTH = DirectionIOProperty.SOUTH;
    public static final DirectionIOProperty EAST = DirectionIOProperty.EAST;
    public static final DirectionIOProperty WEST = DirectionIOProperty.WEST;
    protected AbstractEnergyStorageBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(UP, DirectionIOProperty.DISABLED)
                .with(DOWN, DirectionIOProperty.DISABLED)
                .with(NORTH, DirectionIOProperty.DISABLED)
                .with(SOUTH, DirectionIOProperty.DISABLED)
                .with(EAST, DirectionIOProperty.INSERT)
                .with(WEST, DirectionIOProperty.EXTRACT)
        );
    }
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction blockFacing = ctx.getHorizontalPlayerFacing().getOpposite();
        return this.getDefaultState().with(FACING, blockFacing)
                .with(DirectionIOProperty.getProperty(blockFacing),
                        DirectionIOProperty.DISABLED)
                .with(DirectionIOProperty.getProperty(blockFacing.getOpposite()),
                        DirectionIOProperty.DISABLED)
                .with(DirectionIOProperty.getProperty(blockFacing.rotateYClockwise()),
                        DirectionIOProperty.INSERT)
                .with(DirectionIOProperty.getProperty(blockFacing.rotateYCounterclockwise()),
                        DirectionIOProperty.EXTRACT);
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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.chucksmod.energy_storage"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
