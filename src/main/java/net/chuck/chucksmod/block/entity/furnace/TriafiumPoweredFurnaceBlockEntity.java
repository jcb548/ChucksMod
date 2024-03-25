package net.chuck.chucksmod.block.entity.furnace;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TriafiumPoweredFurnaceBlockEntity extends AbstractPoweredFurnaceBlockEntity implements TriafiumTier {
    public TriafiumPoweredFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_POWERED_FURNACE, pos, state,MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_powered_furnace");
    }

    @Override
    protected int getEnergyUsage() {
        return LOW_USAGE;
    }
}
