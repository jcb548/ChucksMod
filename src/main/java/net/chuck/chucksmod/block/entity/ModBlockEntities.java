package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
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
    public static BlockEntityType<GeneratorBlockEntity> GENERATOR;
    public static BlockEntityType<WireBlockEntity> WIRE;
    public static void registerBlockEntities() {
        CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "crusher"),
                FabricBlockEntityTypeBuilder.create(CrusherBlockEntity::new,
                        ModBlocks.CRUSHER).build());
        POWERED_CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "powered_crusher"),
                FabricBlockEntityTypeBuilder.create(PoweredCrusherBlockEntity::new,
                        ModBlocks.POWERED_CRUSHER).build());
        // Cables can now connect to block entity
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                POWERED_CRUSHER);
        GENERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "generator"),
                FabricBlockEntityTypeBuilder.create(GeneratorBlockEntity::new,
                        ModBlocks.GENERATOR).build());
        // Cables can now connect to block entity
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                GENERATOR);
        WIRE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "wire"),
                FabricBlockEntityTypeBuilder.create(WireBlockEntity::new,
                        ModBlocks.WIRE).build());
    }
}
