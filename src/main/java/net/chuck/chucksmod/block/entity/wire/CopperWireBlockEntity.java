package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CopperWireBlockEntity extends WireBlockEntity{
    public CopperWireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COPPER_WIRE, pos, state);
    }
    @Override
    public long getTransferRate() {
        return 128;
    }
}
