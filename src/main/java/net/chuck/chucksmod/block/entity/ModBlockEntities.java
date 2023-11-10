package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.entity.crusher.CrusherBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.IronPoweredCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.energy_storage.IronEnergyStorageBlockEntity;
import net.chuck.chucksmod.block.entity.furnace.IronPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.block.entity.generator.IronHeatGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.generator.TitaniumHeatGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.wire.CopperWireBlockEntity;
import net.chuck.chucksmod.block.entity.wire.GoldWireBlockEntity;
import net.chuck.chucksmod.block.entity.wire.TinWireBlockEntity;
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
    public static BlockEntityType<IronPoweredCrusherBlockEntity> IRON_POWERED_CRUSHER;
    public static BlockEntityType<IronPoweredFurnaceBlockEntity> IRON_POWERED_FURNACE;
    public static BlockEntityType<IronHeatGeneratorBlockEntity> IRON_HEAT_GENERATOR;
    public static BlockEntityType<IronEnergyStorageBlockEntity> IRON_ENERGY_STORAGE;
    public static BlockEntityType<TinWireBlockEntity> TIN_WIRE;
    public static BlockEntityType<CopperWireBlockEntity> COPPER_WIRE;
    public static BlockEntityType<GoldWireBlockEntity> GOLD_WIRE;
    public static BlockEntityType<TitaniumHeatGeneratorBlockEntity> TITANIUM_HEAT_GENERATOR;
    public static void registerBlockEntities() {
        CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "crusher"),
                FabricBlockEntityTypeBuilder.create(CrusherBlockEntity::new,
                        ModBlocks.CRUSHER).build());
        IRON_POWERED_CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "powered_crusher"),
                FabricBlockEntityTypeBuilder.create(IronPoweredCrusherBlockEntity::new,
                        ModBlocks.IRON_POWERED_CRUSHER).build());
        // Cables can now connect to block entity
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                IRON_POWERED_CRUSHER);
        IRON_POWERED_FURNACE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_powered_furnace"),
                FabricBlockEntityTypeBuilder.create(IronPoweredFurnaceBlockEntity::new,
                        ModBlocks.IRON_POWERED_FURNACE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                IRON_POWERED_FURNACE);
        IRON_HEAT_GENERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_heat_generator"),
                FabricBlockEntityTypeBuilder.create(IronHeatGeneratorBlockEntity::new,
                        ModBlocks.IRON_HEAT_GENERATOR).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                IRON_HEAT_GENERATOR);
        IRON_ENERGY_STORAGE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_energy_storage"),
                FabricBlockEntityTypeBuilder.create(IronEnergyStorageBlockEntity::new,
                        ModBlocks.IRON_ENERGY_STORAGE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) ->
                        blockEntity.energyStorage.getSideStorage(direction), IRON_ENERGY_STORAGE);
        TIN_WIRE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "tin_wire"),
                FabricBlockEntityTypeBuilder.create(TinWireBlockEntity::new, ModBlocks.TIN_WIRE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TIN_WIRE);
        COPPER_WIRE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "copper_wire"),
                FabricBlockEntityTypeBuilder.create(CopperWireBlockEntity::new, ModBlocks.COPPER_WIRE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                COPPER_WIRE);
        GOLD_WIRE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "gold_wire"),
                FabricBlockEntityTypeBuilder.create(GoldWireBlockEntity::new, ModBlocks.GOLD_WIRE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                GOLD_WIRE);
        TITANIUM_HEAT_GENERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_heat_generator"),
                FabricBlockEntityTypeBuilder.create(TitaniumHeatGeneratorBlockEntity::new,
                        ModBlocks.TITANIUM_HEAT_GENERATOR).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_HEAT_GENERATOR);
    }
}
