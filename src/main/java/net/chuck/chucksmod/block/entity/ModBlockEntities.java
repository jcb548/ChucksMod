package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.entity.copier.TitaniumCopierBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.CrusherBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.IronPoweredCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.TitaniumPoweredCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.TriafiumPoweredCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.energy_storage.IronEnergyStorageBlockEntity;
import net.chuck.chucksmod.block.entity.energy_storage.TitaniumEnergyStorageBlockEntity;
import net.chuck.chucksmod.block.entity.energy_storage.TriafiumEnergyStorageBlockEntity;
import net.chuck.chucksmod.block.entity.fluid_pipe.IronFluidPipeBlockEntity;
import net.chuck.chucksmod.block.entity.fluid_pipe.TitaniumFluidPipeBlockEntity;
import net.chuck.chucksmod.block.entity.fluid_tank.IronFluidTankBlockEntity;
import net.chuck.chucksmod.block.entity.fluid_tank.TitaniumFluidTankBlockEntity;
import net.chuck.chucksmod.block.entity.furnace.IronPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.block.entity.furnace.TitaniumPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.block.entity.furnace.TriafiumPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.block.entity.generator.heat.IronHeatGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.generator.lava.TitaniumLavaGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.generator.steam.IronSteamGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.generator.heat.TitaniumHeatGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.generator.steam.TitaniumSteamGeneratorBlockEntity;
import net.chuck.chucksmod.block.entity.harvester.IronHarvesterBlockEntity;
import net.chuck.chucksmod.block.entity.harvester.TitaniumHarvesterBlockEntity;
import net.chuck.chucksmod.block.entity.portal_builder.TriafiumPortalBuilderBlockEntity;
import net.chuck.chucksmod.block.entity.pump.IronPumpBlockEntity;
import net.chuck.chucksmod.block.entity.pump.TitaniumPumpBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.IronQuarryBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.TitaniumQuarryBlockEntity;
import net.chuck.chucksmod.block.entity.wire.CopperWireBlockEntity;
import net.chuck.chucksmod.block.entity.wire.GoldWireBlockEntity;
import net.chuck.chucksmod.block.entity.wire.TinWireBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
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
    public static BlockEntityType<IronQuarryBlockEntity> IRON_QUARRY;
    public static BlockEntityType<IronFluidTankBlockEntity> IRON_FLUID_TANK;
    public static BlockEntityType<IronPumpBlockEntity> IRON_PUMP;
    public static BlockEntityType<IronFluidPipeBlockEntity> IRON_FLUID_PIPE;
    public static BlockEntityType<IronSteamGeneratorBlockEntity> IRON_STEAM_GENERATOR;
    public static BlockEntityType<IronHarvesterBlockEntity> IRON_HARVESTER;
    public static BlockEntityType<TinWireBlockEntity> TIN_WIRE;
    public static BlockEntityType<CopperWireBlockEntity> COPPER_WIRE;
    public static BlockEntityType<GoldWireBlockEntity> GOLD_WIRE;
    public static BlockEntityType<TitaniumHeatGeneratorBlockEntity> TITANIUM_HEAT_GENERATOR;
    public static BlockEntityType<TitaniumEnergyStorageBlockEntity> TITANIUM_ENERGY_STORAGE;
    public static BlockEntityType<TitaniumPoweredCrusherBlockEntity> TITANIUM_POWERED_CRUSHER;
    public static BlockEntityType<TitaniumPoweredFurnaceBlockEntity> TITANIUM_POWERED_FURNACE;
    public static BlockEntityType<TitaniumQuarryBlockEntity> TITANIUM_QUARRY;
    public static BlockEntityType<TitaniumCopierBlockEntity> TITANIUM_COPIER;
    public static BlockEntityType<TitaniumFluidTankBlockEntity> TITANIUM_FLUID_TANK;
    public static BlockEntityType<TitaniumPumpBlockEntity> TITANIUM_PUMP;
    public static BlockEntityType<TitaniumFluidPipeBlockEntity> TITANIUM_FLUID_PIPE;
    public static BlockEntityType<TitaniumSteamGeneratorBlockEntity> TITANIUM_STEAM_GENERATOR;
    public static BlockEntityType<TitaniumLavaGeneratorBlockEntity> TITANIUM_LAVA_GENERATOR;
    public static BlockEntityType<TitaniumHarvesterBlockEntity> TITANIUM_HARVESTER;
    public static BlockEntityType<TriafiumEnergyStorageBlockEntity> TRIAFIUM_ENERGY_STORAGE;
    public static BlockEntityType<TriafiumPoweredCrusherBlockEntity> TRIAFIUM_POWERED_CRUSHER;
    public static BlockEntityType<TriafiumPoweredFurnaceBlockEntity> TRIAFIUM_POWERED_FURNACE;
    public static BlockEntityType<TriafiumPortalBuilderBlockEntity> TRIAFIUM_PORTAL_BUILDER;
    public static void registerBlockEntities() {
        CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "crusher"),
                FabricBlockEntityTypeBuilder.create(CrusherBlockEntity::new,
                        ModBlocks.CRUSHER).build());
        // Iron
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
        IRON_QUARRY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_quarry"),
                FabricBlockEntityTypeBuilder.create(IronQuarryBlockEntity::new,
                        ModBlocks.IRON_QUARRY).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                IRON_QUARRY);
        IRON_FLUID_TANK = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_fluid_tank"),
                FabricBlockEntityTypeBuilder.create(IronFluidTankBlockEntity::new,
                        ModBlocks.IRON_FLUID_TANK).build());
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                IRON_FLUID_TANK);

        IRON_PUMP = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_pump"),
                FabricBlockEntityTypeBuilder.create(IronPumpBlockEntity::new,
                        ModBlocks.IRON_PUMP).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                IRON_PUMP);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                IRON_PUMP);
        IRON_STEAM_GENERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_steam_generator"),
                FabricBlockEntityTypeBuilder.create(IronSteamGeneratorBlockEntity::new,
                        ModBlocks.IRON_STEAM_GENERATOR).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                IRON_STEAM_GENERATOR);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                IRON_STEAM_GENERATOR);
        
        IRON_HARVESTER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_harvester"),
                FabricBlockEntityTypeBuilder.create(IronHarvesterBlockEntity::new,
                        ModBlocks.IRON_HARVESTER).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                IRON_HARVESTER);

        // Wires
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

        TITANIUM_ENERGY_STORAGE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_energy_storage"),
                FabricBlockEntityTypeBuilder.create(TitaniumEnergyStorageBlockEntity::new,
                        ModBlocks.TITANIUM_ENERGY_STORAGE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) ->
                blockEntity.energyStorage.getSideStorage(direction), TITANIUM_ENERGY_STORAGE);
        TITANIUM_POWERED_CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_powered_crusher"),
                FabricBlockEntityTypeBuilder.create(TitaniumPoweredCrusherBlockEntity::new,
                        ModBlocks.TITANIUM_POWERED_CRUSHER).build());
        // Cables can now connect to block entity
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_POWERED_CRUSHER);
        TITANIUM_POWERED_FURNACE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_powered_furnace"),
                FabricBlockEntityTypeBuilder.create(TitaniumPoweredFurnaceBlockEntity::new,
                        ModBlocks.TITANIUM_POWERED_FURNACE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_POWERED_FURNACE);
        TITANIUM_HEAT_GENERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_heat_generator"),
                FabricBlockEntityTypeBuilder.create(TitaniumHeatGeneratorBlockEntity::new,
                        ModBlocks.TITANIUM_HEAT_GENERATOR).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_HEAT_GENERATOR);
        TITANIUM_QUARRY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_quarry"),
                FabricBlockEntityTypeBuilder.create(TitaniumQuarryBlockEntity::new,
                        ModBlocks.TITANIUM_QUARRY).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_QUARRY);
        TITANIUM_COPIER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_copier"),
                FabricBlockEntityTypeBuilder.create(TitaniumCopierBlockEntity::new,
                        ModBlocks.TITANIUM_COPIER).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_COPIER);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                TITANIUM_COPIER);

        TITANIUM_FLUID_TANK = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_fluid_tank"),
                FabricBlockEntityTypeBuilder.create(TitaniumFluidTankBlockEntity::new,
                        ModBlocks.TITANIUM_FLUID_TANK).build());
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                TITANIUM_FLUID_TANK);

        TITANIUM_PUMP = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_pump"),
                FabricBlockEntityTypeBuilder.create(TitaniumPumpBlockEntity::new,
                        ModBlocks.TITANIUM_PUMP).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_PUMP);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                TITANIUM_PUMP);

        TITANIUM_STEAM_GENERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_steam_generator"),
                FabricBlockEntityTypeBuilder.create(TitaniumSteamGeneratorBlockEntity::new,
                        ModBlocks.TITANIUM_STEAM_GENERATOR).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_STEAM_GENERATOR);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                TITANIUM_STEAM_GENERATOR);

        TITANIUM_LAVA_GENERATOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_lava_generator"),
                FabricBlockEntityTypeBuilder.create(TitaniumLavaGeneratorBlockEntity::new,
                        ModBlocks.TITANIUM_LAVA_GENERATOR).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_LAVA_GENERATOR);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                TITANIUM_LAVA_GENERATOR);
        
        TITANIUM_HARVESTER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_harvester"),
                FabricBlockEntityTypeBuilder.create(TitaniumHarvesterBlockEntity::new,
                        ModBlocks.TITANIUM_HARVESTER).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TITANIUM_HARVESTER);
        // Fluid Pipes
        IRON_FLUID_PIPE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "iron_fluid_pipe"),
                FabricBlockEntityTypeBuilder.create(IronFluidPipeBlockEntity::new, ModBlocks.IRON_FLUID_PIPE).build());
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                IRON_FLUID_PIPE);
        TITANIUM_FLUID_PIPE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "titanium_fluid_pipe"),
                FabricBlockEntityTypeBuilder.create(TitaniumFluidPipeBlockEntity::new, ModBlocks.TITANIUM_FLUID_PIPE).build());
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage,
                TITANIUM_FLUID_PIPE);
        
        //triafium
        TRIAFIUM_ENERGY_STORAGE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "triafium_energy_storage"),
                FabricBlockEntityTypeBuilder.create(TriafiumEnergyStorageBlockEntity::new,
                        ModBlocks.TRIAFIUM_ENERGY_STORAGE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) ->
                blockEntity.energyStorage.getSideStorage(direction), TRIAFIUM_ENERGY_STORAGE);
        TRIAFIUM_POWERED_CRUSHER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "triafium_powered_crusher"),
                FabricBlockEntityTypeBuilder.create(TriafiumPoweredCrusherBlockEntity::new,
                        ModBlocks.TRIAFIUM_POWERED_CRUSHER).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TRIAFIUM_POWERED_CRUSHER);
        
        TRIAFIUM_POWERED_FURNACE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "triafium_powered_furnace"),
                FabricBlockEntityTypeBuilder.create(TriafiumPoweredFurnaceBlockEntity::new,
                        ModBlocks.TRIAFIUM_POWERED_FURNACE).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TRIAFIUM_POWERED_FURNACE);
        
        TRIAFIUM_PORTAL_BUILDER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ChucksMod.MOD_ID, "triafium_portal_builder"),
                FabricBlockEntityTypeBuilder.create(TriafiumPortalBuilderBlockEntity::new,
                        ModBlocks.TRIAFIUM_PORTAL_BUILDER).build());
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage,
                TRIAFIUM_PORTAL_BUILDER);
    }
}
