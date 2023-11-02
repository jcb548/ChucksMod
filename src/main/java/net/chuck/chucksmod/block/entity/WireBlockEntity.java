package net.chuck.chucksmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class WireBlockEntity extends BlockEntity {
    public WireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WIRE, pos, state);
    }
}
