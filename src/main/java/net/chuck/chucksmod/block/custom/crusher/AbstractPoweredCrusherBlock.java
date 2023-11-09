package net.chuck.chucksmod.block.custom.crusher;

import net.chuck.chucksmod.block.entity.crusher.AbstractCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.AbstractPoweredCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.IronPoweredCrusherBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractPoweredCrusherBlock extends CrusherBlock{
    public AbstractPoweredCrusherBlock(Settings settings) {
        super(settings);
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AbstractPoweredCrusherBlockEntity) {
                ItemScatterer.spawn(world, pos, (AbstractPoweredCrusherBlockEntity)blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
