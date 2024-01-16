package net.chuck.chucksmod.block.custom.fluid_pipe;

import com.ibm.icu.util.LocaleMatcher;
import net.chuck.chucksmod.block.custom.AbstractTransferBlock;
import net.chuck.chucksmod.block.entity.fluid_pipe.AbstractFluidPipeBlockEntity;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

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

public abstract class AbstractFluidPipeBlock extends AbstractTransferBlock {
    public static final BooleanProperty EAST_EXTRACT = BooleanProperty.of("east_extract");
    public static final BooleanProperty WEST_EXTRACT = BooleanProperty.of("west_extract");
    public static final BooleanProperty NORTH_EXTRACT = BooleanProperty.of("north_extract");
    public static final BooleanProperty SOUTH_EXTRACT = BooleanProperty.of("south_extract");
    public static final BooleanProperty UP_EXTRACT = BooleanProperty.of("up_extract");
    public static final BooleanProperty DOWN_EXTRACT = BooleanProperty.of("down_extract");
    public AbstractFluidPipeBlock(Settings settings) {
        super(settings);
        /*setDefaultState(this.getDefaultState()
                .with(EAST_EXTRACT, false)
                .with(WEST_EXTRACT, false)
                .with(NORTH_EXTRACT, false)
                .with(SOUTH_EXTRACT, false)
                .with(UP_EXTRACT, false)
                .with(DOWN_EXTRACT, false)
        );*/
    }

    /*@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(EAST_EXTRACT, WEST_EXTRACT, NORTH_EXTRACT, SOUTH_EXTRACT, UP_EXTRACT, DOWN_EXTRACT);
    }*/

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && world.getBlockEntity(pos) instanceof AbstractFluidPipeBlockEntity pipe){
            if(!pipe.targets.isEmpty() && player.getStackInHand(hand).getItem().equals(ModItems.IRON_MOTOR)){
                Direction hitDirection = getHitDirection(hit.getPos(), pos, player);
                if(hitDirection != null && pipe.canExtract(hitDirection)) {
                    pipe.setExtracting(hitDirection, !pipe.extracting_map.get(hitDirection));
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
