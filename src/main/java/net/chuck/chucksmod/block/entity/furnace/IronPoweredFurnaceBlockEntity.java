package net.chuck.chucksmod.block.entity.furnace;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.chuck.chucksmod.screen.crusher.IronPoweredCrusherScreenHandler;
import net.chuck.chucksmod.screen.furnace.IronPoweredFurnaceScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class IronPoweredFurnaceBlockEntity extends AbstractPoweredFurnaceBlockEntity implements IronTier {
    public IronPoweredFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_POWERED_FURNACE, pos, state, ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.iron_powered_furnace");
    }

    @Override
    protected int getEnergyUsage() {
        return USAGE;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new IronPoweredFurnaceScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
}
