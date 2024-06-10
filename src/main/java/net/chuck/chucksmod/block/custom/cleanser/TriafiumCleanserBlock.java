package net.chuck.chucksmod.block.custom.cleanser;

import net.chuck.chucksmod.block.entity.cleanser.TriafiumCleanserBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TriafiumCleanserBlock extends AbstractCleanserBlock{
    public TriafiumCleanserBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TriafiumCleanserBlockEntity(pos, state);
    }
}
