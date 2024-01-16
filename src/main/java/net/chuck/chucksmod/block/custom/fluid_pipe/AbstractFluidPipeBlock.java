package net.chuck.chucksmod.block.custom.fluid_pipe;

import com.ibm.icu.util.LocaleMatcher;
import net.chuck.chucksmod.block.custom.AbstractTransferBlock;
import net.chuck.chucksmod.block.custom.TransferBlockShapeUtil;
import net.chuck.chucksmod.block.entity.fluid_pipe.AbstractFluidPipeBlockEntity;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.util.DirectionIOProperty;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public abstract class AbstractFluidPipeBlock extends BlockWithEntity {
    public static final DirectionIOProperty EAST = DirectionIOProperty.EAST;
    public static final DirectionIOProperty WEST = DirectionIOProperty.WEST;
    public static final DirectionIOProperty NORTH = DirectionIOProperty.NORTH;
    public static final DirectionIOProperty SOUTH = DirectionIOProperty.SOUTH;
    public static final DirectionIOProperty UP = DirectionIOProperty.UP;
    public static final DirectionIOProperty DOWN = DirectionIOProperty.DOWN;
    public static final Map<Direction, DirectionIOProperty> PROPERTY_MAP = Util.make(new HashMap<>(), map -> {
        map.put(Direction.EAST, EAST);
        map.put(Direction.WEST, WEST);
        map.put(Direction.NORTH, NORTH);
        map.put(Direction.SOUTH, SOUTH);
        map.put(Direction.UP, UP);
        map.put(Direction.DOWN, DOWN);
    });
    public AbstractFluidPipeBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState()
                .with(EAST, DirectionIOProperty.DISABLED)
                .with(WEST, DirectionIOProperty.DISABLED)
                .with(NORTH, DirectionIOProperty.DISABLED)
                .with(SOUTH, DirectionIOProperty.DISABLED)
                .with(UP, DirectionIOProperty.DISABLED)
                .with(DOWN, DirectionIOProperty.DISABLED)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(EAST, WEST, NORTH, SOUTH, UP, DOWN);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return TransferBlockShapeUtil.getPipeShape(state);
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return TransferBlockShapeUtil.getPipeShape(state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && world.getBlockEntity(pos) instanceof AbstractFluidPipeBlockEntity pipe){
            if(!pipe.targets.isEmpty() && player.getStackInHand(hand).getItem().equals(ModItems.IRON_MOTOR)){
                Direction hitDirection = getHitDirection(hit.getPos(), pos, player);
                if(hitDirection != null && pipe.canExtract(hitDirection)) {
                    pipe.setExtracting(hitDirection, !pipe.extracting_map.get(hitDirection));
                    String value;
                    if(pipe.extracting_map.get(hitDirection)) value = DirectionIOProperty.EXTRACT;
                    else value = DirectionIOProperty.INSERT;
                    world.setBlockState(pos, world.getBlockState(pos).with(DirectionIOProperty.getProperty(hitDirection), value));
                }
            }
            player.sendMessage(Text.literal(pipe.extracting_map.toString()));
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if(!world.isClient) {
            if (world.getBlockEntity(pos) instanceof AbstractFluidPipeBlockEntity pipe) {
                pipe.neighbourUpdate();
            }
        }
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }
    @Nullable
    private Direction getHitDirection(Vec3d pos, BlockPos blockPos, PlayerEntity player){
        double localX = blockPos.getX() + 0.5 - pos.x;
        double localY = blockPos.getY() + 0.5 - pos.y;
        double localZ = blockPos.getZ() + 0.5 - pos.z;
        player.sendMessage(Text.literal(localX+ ", " + localY + ", "+localZ));
        if(Math.abs(localX) <= 0.2 && Math.abs(localZ) <= 0.2){
            if(localY > 0.2){
                return Direction.DOWN;
            }
            if(localY < -0.2){
                return Direction.UP;
            }
        }if(Math.abs(localY) <= 0.2 && Math.abs(localZ) <= 0.2){
            if(localX > 0.2){
                return Direction.WEST;
            }
            if(localX < -0.2){
                return Direction.EAST;
            }
        }
        if(Math.abs(localX) <= 0.2 && Math.abs(localY) <= 0.2){
            if(localZ > 0.2){
                return Direction.NORTH;
            }
            if(localZ < -0.2){
                return Direction.SOUTH;
            }
        }
        return null;
    }
}
