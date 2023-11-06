package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CopperWireBlockEntity extends WireBlockEntity{
    public CopperWireBlockEntity(BlockPos pos, BlockState state, long transferRate) {
        super(ModBlockEntities.COPPER_WIRE, pos, state, transferRate);
    }
}
