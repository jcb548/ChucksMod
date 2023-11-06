package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.custom.wire.GoldWireBlock;
import net.chuck.chucksmod.block.entity.wire.CopperWireBlockEntity;
import net.chuck.chucksmod.block.entity.wire.GoldWireBlockEntity;
import net.chuck.chucksmod.block.entity.wire.TinWireBlockEntity;
import net.chuck.chucksmod.block.entity.wire.WireBlockEntity;
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
    public static BlockEntityType<GeneratorBlockEntity> GENERATOR;
    public static BlockEntityType<TinWireBlockEntity> TIN_WIRE;
    public static long TIN_WIRE_TRANSFER_RATE = 32;
    public static BlockEntityType<CopperWireBlockEntity> COPPER_WIRE;
    public static long COPPER_WIRE_TRANSFER_RATE = 128;
    public static BlockEntityType<GoldWireBlockEntity> GOLD_WIRE;
    public static long GOLD_WIRE_TRANSFER_RATE = 512;
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
        TIN_WIRE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "tin_wire"),
                FabricBlockEntityTypeBuilder.create((pos, state) -> new TinWireBlockEntity(pos, state,
                                TIN_WIRE_TRANSFER_RATE), ModBlocks.TIN_WIRE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TIN_WIRE);
        COPPER_WIRE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "copper_wire"),
                FabricBlockEntityTypeBuilder.create((pos, state) -> new CopperWireBlockEntity(pos, state,
                                COPPER_WIRE_TRANSFER_RATE), ModBlocks.COPPER_WIRE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                COPPER_WIRE);
        GOLD_WIRE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "gold_wire"),
                FabricBlockEntityTypeBuilder.create((pos, state) -> new GoldWireBlockEntity(pos, state,
                                GOLD_WIRE_TRANSFER_RATE), ModBlocks.GOLD_WIRE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                GOLD_WIRE);
    }
}
