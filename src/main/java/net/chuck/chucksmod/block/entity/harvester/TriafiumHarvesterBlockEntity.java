package net.chuck.chucksmod.block.entity.harvester;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.chuck.chucksmod.screen.harvester.TriafiumHarvesterScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TriafiumHarvesterBlockEntity extends AbstractHarvesterBlockEntity implements TriafiumTier {
    public TriafiumHarvesterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_HARVESTER, pos, state, HARVESTER_SEEDS_INV_SIZE, HARVESTER_CROPS_INV_SIZE,
                MACHINE_ENERGY_STORAGE, QUARRY_SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return MEDIUM_USAGE;
    }

    @Override
    protected int getSize() {
        return QUARRY_SIZE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_harvester");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        return new TriafiumHarvesterScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
}
