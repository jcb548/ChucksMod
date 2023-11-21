package net.chuck.chucksmod.block.entity.furnace;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TitaniumPoweredFurnaceBlockEntity extends AbstractPoweredFurnaceBlockEntity implements TitaniumTier {
    public TitaniumPoweredFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_POWERED_FURNACE, pos, state,MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.titanium_powered_furnace");
    }

    @Override
    protected int getEnergyUsage() {
        return LOW_USAGE;
    }
}
