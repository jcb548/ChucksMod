package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class GoldWireBlockEntity extends WireBlockEntity{
    public GoldWireBlockEntity(BlockPos pos, BlockState state, long transferRate) {
        super(ModBlockEntities.GOLD_WIRE, pos, state, transferRate);
    }
}
