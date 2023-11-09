package net.chuck.chucksmod.block.custom.energy_storage;

import net.chuck.chucksmod.util.DirectionalPowerIOProperty;
import net.chuck.chucksmod.util.ModProperties;
import net.minecraft.block.*;
import net.minecraft.state.StateManager;

public abstract class AbstractEnergyStorageBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionalPowerIOProperty UP = ModProperties.UP;
    public static final DirectionalPowerIOProperty DOWN = ModProperties.DOWN;
    public static final DirectionalPowerIOProperty NORTH = ModProperties.NORTH;
    public static final DirectionalPowerIOProperty SOUTH = ModProperties.SOUTH;
    public static final DirectionalPowerIOProperty EAST = ModProperties.EAST;
    public static final DirectionalPowerIOProperty WEST = ModProperties.WEST;
    protected AbstractEnergyStorageBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(UP, DirectionalPowerIOProperty.DISABLED)
                .with(DOWN, DirectionalPowerIOProperty.DISABLED)
                .with(NORTH, DirectionalPowerIOProperty.DISABLED)
                .with(SOUTH, DirectionalPowerIOProperty.DISABLED)
                .with(EAST, DirectionalPowerIOProperty.EXTRACT)
                .with(WEST, DirectionalPowerIOProperty.INSERT)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, NORTH, SOUTH, EAST, WEST);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
