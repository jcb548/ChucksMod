package net.chuck.chucksmod.block.entity.copier;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TitaniumCopierBlockEntity extends AbstractCopierBlockEntity implements TitaniumTier {
    public TitaniumCopierBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_COPIER, pos, state, MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return MEDIUM_USAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.titanium_copier");
    }

    @Override
    public int getXpDrainRate() {
        return XP_DRAIN_RATE;
    }

    @Override
    public int getBucketCapacity() {
        return XP_BUCKETS;
    }
}
