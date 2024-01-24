package net.chuck.chucksmod.block.entity.portal_builder;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.FabiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class FabiumPortalBuilderBlockEntity extends AbstractPortalBuilderBlockEntity implements FabiumTier {
    public FabiumPortalBuilderBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FABIUM_PORTAL_BUILDER, pos, state, MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return HIGH_USAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.fabium_portal_builder");
    }
}
