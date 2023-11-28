package net.chuck.chucksmod.block.custom.quarry;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractQuarryBlock extends AbstractEnergyUsingBlock {
    protected AbstractQuarryBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }
}
