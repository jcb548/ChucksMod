package net.chuck.chucksmod.block.custom.fluid_pipe;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.fluid_pipe.IronFluidPipeBlockEntity;
import net.chuck.chucksmod.block.entity.fluid_pipe.TitaniumFluidPipeBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TitaniumFluidPipeBlock extends AbstractFluidPipeBlock{
    public TitaniumFluidPipeBlock(Settings settings) {
        super(settings);
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TitaniumFluidPipeBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.TITANIUM_FLUID_PIPE, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
