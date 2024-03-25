package net.chuck.chucksmod.block.entity.crusher;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class TriafiumPoweredCrusherBlockEntity extends AbstractPoweredCrusherBlockEntity implements TriafiumTier {
    public TriafiumPoweredCrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_POWERED_CRUSHER, pos, state, MACHINE_ENERGY_STORAGE, SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_powered_crusher");
    }

    @Override
    protected int getEnergyUsage() {
        return HIGH_USAGE;
    }
}
