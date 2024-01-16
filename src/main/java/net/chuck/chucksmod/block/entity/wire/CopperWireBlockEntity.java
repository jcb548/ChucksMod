package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CopperWireBlockEntity extends AbstractWireBlockEntity implements IronTier {
    public CopperWireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COPPER_WIRE, pos, state);
    }
    @Override
    public long getTransferRate() {
        return WIRE_TRANSFER_RATE;
    }
}
