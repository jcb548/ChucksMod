package net.chuck.chucksmod.block.entity.crusher;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class TitaniumPoweredCrusherBlockEntity extends AbstractPoweredCrusherBlockEntity implements TitaniumTier {
    public TitaniumPoweredCrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_POWERED_CRUSHER, pos, state, MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.titanium_powered_crusher");
    }

    @Override
    protected int getEnergyUsage() {
        return HIGH_USAGE;
    }
}
