package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class GoldWireBlockEntity extends AbstractWireBlockEntity implements TitaniumTier {
    public GoldWireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GOLD_WIRE, pos, state);
    }

    @Override
    public long getTransferRate() {
        return WIRE_TRANSFER_RATE;
    }
}
