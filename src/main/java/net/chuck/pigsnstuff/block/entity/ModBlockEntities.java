package net.chuck.pigsnstuff.block.entity;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.block.custom.PoweredCrusherBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModBlockEntities {
    public static BlockEntityType<CrusherBlockEntity> CRUSHER;
    public static BlockEntityType<PoweredCrusherBlockEntity> POWERED_CRUSHER;
    public static void registerBlockEntities() {
        CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PigsNStuff.MOD_ID, "crusher"),
                FabricBlockEntityTypeBuilder.create(CrusherBlockEntity::new,
                        ModBlocks.CRUSHER).build(null));
        POWERED_CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PigsNStuff.MOD_ID, "powered_crusher"),
                FabricBlockEntityTypeBuilder.create(PoweredCrusherBlockEntity::new,
                        ModBlocks.POWERED_CRUSHER).build(null));
        // Cables can now connect to block entity
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                POWERED_CRUSHER);
    }
}
