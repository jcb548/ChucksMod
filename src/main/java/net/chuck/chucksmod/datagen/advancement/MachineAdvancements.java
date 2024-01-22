package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class MachineAdvancements {
    public static void generateAdvancements(Consumer<AdvancementEntry> consumer){
        AdvancementEntry root = Advancement.Builder.create()
                .display(ModItems.BRONZE_GEAR, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.root.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.root.desc"), // The description
                        new Identifier(ChucksMod.MOD_ID, "textures/block/iron_powered_crusher_top.png"), // Background image used
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("got_gear", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.GEARS).build()))
                .build(consumer, ChucksMod.MOD_ID + "/machines/root");

        AdvancementEntry ironMachineBase = Advancement.Builder.create()
                .display(ModBlocks.IRON_MACHINE_BASE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_machine_base.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_machine_base.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_iron_machine_base", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_MACHINE_BASE))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_machine_base");
        consumer.accept(ironMachineBase);

        AdvancementEntry ironCrusher = Advancement.Builder.create()
                .display(ModBlocks.IRON_POWERED_CRUSHER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_crusher.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_crusher.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_crusher", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_POWERED_CRUSHER))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_crusher");

        AdvancementEntry ironFurnace = Advancement.Builder.create()
                .display(ModBlocks.IRON_POWERED_FURNACE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_furnace.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_furnace.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_furnace", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_POWERED_FURNACE))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_furnace");

        AdvancementEntry ironHeatGenerator = Advancement.Builder.create()
                .display(ModBlocks.IRON_HEAT_GENERATOR,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_heat_generator.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_heat_generator.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_heat_generator", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_HEAT_GENERATOR))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_heat_generator");

        AdvancementEntry ironSteamGenerator = Advancement.Builder.create()
                .display(ModBlocks.IRON_STEAM_GENERATOR,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_steam_generator.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_steam_generator.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_steam_generator", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_STEAM_GENERATOR))
                .parent(ironHeatGenerator)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_steam_generator");

        AdvancementEntry ironEnergyStorage = Advancement.Builder.create()
                .display(ModBlocks.IRON_ENERGY_STORAGE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_energy_storage.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_energy_storage.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_energy_storage", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_ENERGY_STORAGE))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_energy_storage");

        AdvancementEntry ironTank = Advancement.Builder.create()
                .display(ModBlocks.IRON_FLUID_TANK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_tank.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_tank.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_tank", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_FLUID_TANK))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_tank");

        AdvancementEntry ironPump = Advancement.Builder.create()
                .display(ModBlocks.IRON_PUMP,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_pump.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_pump.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_pump", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_PUMP))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_pump");

        AdvancementEntry ironQuarry = Advancement.Builder.create()
                .display(ModBlocks.IRON_QUARRY,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_quarry.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_quarry.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_quarry", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_QUARRY))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_quarry");

        AdvancementEntry ironFluidPipe = Advancement.Builder.create()
                .display(ModBlocks.IRON_FLUID_PIPE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_fluid_pipe.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_fluid_pipe.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_fluid_pipe", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_FLUID_PIPE))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_fluid_pipe");

        AdvancementEntry tinWire = Advancement.Builder.create()
                .display(ModBlocks.TIN_WIRE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.tin_wire.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.tin_wire.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_tin_wire", InventoryChangedCriterion.Conditions.items(ModBlocks.TIN_WIRE))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/machines/tin_wire");

        AdvancementEntry copperWire = Advancement.Builder.create()
                .display(ModBlocks.COPPER_WIRE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.copper_wire.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.copper_wire.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_copper_wire", InventoryChangedCriterion.Conditions.items(ModBlocks.COPPER_WIRE))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/copper_wire");

        AdvancementEntry titaniumMachineBase = Advancement.Builder.create()
                .display(ModBlocks.TITANIUM_MACHINE_BASE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.titanium_machine_base.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.titanium_machine_base.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_titanium_machine_base", InventoryChangedCriterion.Conditions.items(ModBlocks.TITANIUM_MACHINE_BASE))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/titanium_machine_base");

        AdvancementEntry titaniumMachines = Advancement.Builder.create()
                .display(ModBlocks.TITANIUM_POWERED_CRUSHER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.titanium_machines.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.titanium_machines.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium_machines", InventoryChangedCriterion.Conditions.items(
                        ModBlocks.TITANIUM_POWERED_CRUSHER,
                        ModBlocks.TITANIUM_POWERED_FURNACE,
                        ModBlocks.TITANIUM_FLUID_TANK,
                        ModBlocks.TITANIUM_FLUID_PIPE,
                        ModBlocks.TITANIUM_QUARRY,
                        ModBlocks.TITANIUM_HEAT_GENERATOR,
                        ModBlocks.TITANIUM_STEAM_GENERATOR,
                        ModBlocks.TITANIUM_ENERGY_STORAGE,
                        ModBlocks.TITANIUM_PUMP
                        ))
                .parent(titaniumMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/titanium_machines");

        AdvancementEntry goldWire = Advancement.Builder.create()
                .display(ModBlocks.GOLD_WIRE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.gold_wire.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.gold_wire.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_gold_wire", InventoryChangedCriterion.Conditions.items(ModBlocks.GOLD_WIRE))
                .parent(titaniumMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/gold_wire");

        AdvancementEntry titaniumCopier = Advancement.Builder.create()
                .display(ModBlocks.TITANIUM_COPIER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.titanium_copier.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.titanium_copier.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium_copier", InventoryChangedCriterion.Conditions.items(ModBlocks.TITANIUM_COPIER))
                .parent(titaniumMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/titanium_copier");
    }
    // /advancement grant Player66 through minecraft:chucksmod/machines/titanium_machines
}
