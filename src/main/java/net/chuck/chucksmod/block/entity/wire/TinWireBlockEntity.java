package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TinWireBlockEntity extends AbstractWireBlockEntity {
    public TinWireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TIN_WIRE, pos, state);
    }

    @Override
    public long getTransferRate() {
        return 32;
    }
}
