package net.chuck.chucksmod.block.custom.cleanser;

import net.chuck.chucksmod.block.entity.cleanser.TitaniumCleanserBlockEntity;
import net.chuck.chucksmod.block.entity.copier.TitaniumCopierBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TitaniumCleanserBlock extends AbstractCleanserBlock{
    public TitaniumCleanserBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TitaniumCleanserBlockEntity(pos, state);
    }
}
