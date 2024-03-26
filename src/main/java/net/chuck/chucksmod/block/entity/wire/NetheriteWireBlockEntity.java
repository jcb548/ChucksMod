package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class NetheriteWireBlockEntity extends AbstractWireBlockEntity implements TriafiumTier {
    public NetheriteWireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.NETHERITE_WIRE, pos, state);
    }

    @Override
    public long getTransferRate() {
        return WIRE_TRANSFER_RATE;
    }
}
