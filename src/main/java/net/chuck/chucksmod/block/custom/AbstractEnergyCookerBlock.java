package net.chuck.chucksmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public abstract class AbstractEnergyCookerBlock extends AbstractEnergyUsingBlock{
    public static final BooleanProperty LIT = Properties.LIT;
    protected AbstractEnergyCookerBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LIT);
    }
}
