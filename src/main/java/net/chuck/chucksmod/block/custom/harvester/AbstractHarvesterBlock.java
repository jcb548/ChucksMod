package net.chuck.chucksmod.block.custom.harvester;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.chuck.chucksmod.block.entity.harvester.AbstractHarvesterBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractHarvesterBlock extends AbstractEnergyUsingBlock {
    protected AbstractHarvesterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        if(world.getBlockEntity(pos) instanceof AbstractHarvesterBlockEntity entity) {
            return Math.min((2*ScreenHandler.calculateComparatorOutput(entity.getInventory()) +
                    5*ScreenHandler.calculateComparatorOutput(entity.getCropInventory()))
                            /7, 15);
        }
        return 0;
    }
}
