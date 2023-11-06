package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TinWireBlockEntity extends WireBlockEntity{
    public TinWireBlockEntity(BlockPos pos, BlockState state, long transferRate) {
        super(ModBlockEntities.TIN_WIRE, pos, state, transferRate);
    }
}
