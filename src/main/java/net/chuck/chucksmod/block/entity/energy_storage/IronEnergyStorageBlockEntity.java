package net.chuck.chucksmod.block.entity.energy_storage;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.chuck.chucksmod.screen.energy_storage.IronEnergyStorageScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class IronEnergyStorageBlockEntity extends AbstractEnergyStorageBlockEntity implements IronTier {
    public IronEnergyStorageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_ENERGY_STORAGE, pos, state, ENERGY_STORAGE, ENERGY_STORAGE_INSERT_EXTRACT);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.iron_energy_storage");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new IronEnergyStorageScreenHandler(syncId, playerInventory, this);
    }
}
