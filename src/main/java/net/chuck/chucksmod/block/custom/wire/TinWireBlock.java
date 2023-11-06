package net.chuck.chucksmod.block.custom.wire;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.wire.TinWireBlockEntity;
import net.chuck.chucksmod.block.entity.wire.WireBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TinWireBlock extends WireBlock{
    public TinWireBlock(Settings settings, long transferRate) {
        super(settings, transferRate);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TinWireBlockEntity(pos, state, TRANSFER_RATE);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.TIN_WIRE, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
