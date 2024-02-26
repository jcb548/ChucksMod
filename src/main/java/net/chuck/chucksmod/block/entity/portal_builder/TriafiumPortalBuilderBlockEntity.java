package net.chuck.chucksmod.block.entity.portal_builder;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TriafiumPortalBuilderBlockEntity extends AbstractPortalBuilderBlockEntity implements TriafiumTier {
    public TriafiumPortalBuilderBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_PORTAL_BUILDER, pos, state, MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return HIGH_USAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_portal_builder");
    }
}
