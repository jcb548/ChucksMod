package net.chuck.chucksmod.block.entity.energy_storage;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.chuck.chucksmod.screen.energy_storage.TitaniumEnergyStorageScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TitaniumEnergyStorageBlockEntity extends AbstractEnergyStorageBlockEntity implements TitaniumTier {
    public TitaniumEnergyStorageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_ENERGY_STORAGE, pos, state, ENERGY_STORAGE, ENERGY_STORAGE_INSERT_EXTRACT);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.titanium_energy_storage");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new TitaniumEnergyStorageScreenHandler(syncId, playerInventory, this);
    }
}
