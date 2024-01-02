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
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_machine_base", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_MACHINE_BASE))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_machine_base");

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

        AdvancementEntry ironEnergyStorage = Advancement.Builder.create()
                .display(ModBlocks.IRON_ENERGY_STORAGE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_energy_storage.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".machines.iron_energy_storage.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_energy_storage", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_ENERGY_STORAGE))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/iron_energy_storage");

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
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium_machine_base", InventoryChangedCriterion.Conditions.items(ModBlocks.TITANIUM_MACHINE_BASE))
                .parent(ironMachineBase)
                .build(consumer, ChucksMod.MOD_ID + "/machines/titanium_machine_base");
    }
}
