package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.world.gen.ModStructureKeys;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureKeys;

import java.util.function.Consumer;

public class OverworldAdvancements {
    public static void generateAdvancements(Consumer<AdvancementEntry> consumer){
        AdvancementEntry root = Advancement.Builder.create()
                .display(Items.OAK_LOG, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.root.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.root.desc"), // The description
                        new Identifier(ChucksMod.MOD_ID, "textures/block/eucalyptus_planks.png"), // Background image used
                        AdvancementFrame.TASK, true, true, false)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_logs", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.LOGS).build()))
                .build(consumer, ChucksMod.MOD_ID + "/overworld/root");

        AdvancementEntry craftingTable = Advancement.Builder.create()
                .display(Items.CRAFTING_TABLE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.crafting_table.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.crafting_table.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("crafting_table", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/crafting_table");

        AdvancementEntry woodPickaxe = Advancement.Builder.create()
                .display(Items.WOODEN_PICKAXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wooden_pickaxe.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wooden_pickaxe.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_wooden_pick", InventoryChangedCriterion.Conditions.items(Items.WOODEN_PICKAXE))
                .parent(craftingTable)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/wooden_pickaxe");

        AdvancementEntry cobble = Advancement.Builder.create()
                .display(Items.COBBLESTONE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.cobble.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.cobble.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_cobble", InventoryChangedCriterion.Conditions.items(Items.COBBLESTONE))
                .parent(woodPickaxe)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/cobble");

        AdvancementEntry stoneTools = Advancement.Builder.create()
                .display(Items.STONE_AXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.stone_tools.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.stone_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_stone_tools", InventoryChangedCriterion.Conditions.items(Items.STONE_SWORD,
                        Items.STONE_PICKAXE, Items.STONE_AXE, Items.STONE_SHOVEL, Items.STONE_HOE))
                .parent(cobble)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/stone_tools");

        AdvancementEntry furnace = Advancement.Builder.create()
                .display(Items.FURNACE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.furnace.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.furnace.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_furnace", InventoryChangedCriterion.Conditions.items(Items.FURNACE))
                .parent(cobble)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/furnace");

        AdvancementEntry coal = Advancement.Builder.create()
                .display(Items.COAL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.coal.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.coal.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_coal", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.COALS).build()))
                .parent(furnace)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/coal");

        AdvancementEntry meat = Advancement.Builder.create()
                .display(Items.PORKCHOP,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.meat.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.meat.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_meat", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.RAW_MEAT).build()))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/meat");

        AdvancementEntry cookedMeat = Advancement.Builder.create()
                .display(Items.COOKED_PORKCHOP,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.cooked_meat.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.cooked_meat.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("cook_meat", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.COOKED_MEAT).build()))
                .parent(meat)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/cooked_meat");

        AdvancementEntry seeds = Advancement.Builder.create()
                .display(Items.WHEAT_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.seeds.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.seeds.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_seeds", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.SEEDS).build()))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/seeds");

        AdvancementEntry farmland = Advancement.Builder.create().display(Items.FARMLAND,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.farmland.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.farmland.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("create_farmland", ItemCriterion.Conditions.createItemUsedOnBlock(
                        LocationPredicate.Builder.create().block(BlockPredicate.Builder.create()
                                .blocks(Blocks.FARMLAND)),
                        ItemPredicate.Builder.create().tag(ItemTags.HOES)))
                .parent(seeds)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/farmland");

        AdvancementEntry plant_wheat = Advancement.Builder.create().display(Items.WHEAT_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_seeds.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_seeds.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_wheat", ItemCriterion.Conditions.createPlacedBlock(Blocks.WHEAT))
                .parent(farmland)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/plant_wheat");

        AdvancementEntry wheat = Advancement.Builder.create().display(Items.WHEAT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wheat.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wheat.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_wheat", InventoryChangedCriterion.Conditions.items(Items.WHEAT))
                .parent(plant_wheat)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/wheat");

        AdvancementEntry bread = Advancement.Builder.create().display(Items.BREAD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bread.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bread.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_bread", InventoryChangedCriterion.Conditions.items(Items.BREAD))
                .parent(wheat)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/bread");

        AdvancementEntry plant_beetroot = Advancement.Builder.create().display(Items.BEETROOT_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_beetroot.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_beetroot.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_beetroot", ItemCriterion.Conditions.createPlacedBlock(Blocks.BEETROOTS))
                .parent(farmland)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/plant_beetroot");

        AdvancementEntry beetroot = Advancement.Builder.create().display(Items.BEETROOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.beetroot.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.beetroot.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_beetroot", InventoryChangedCriterion.Conditions.items(Items.BEETROOT))
                .parent(plant_beetroot)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/beetroot");

        AdvancementEntry plant_tomato = Advancement.Builder.create().display(ModItems.TOMATO_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_tomato.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_tomato.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_tomato", ItemCriterion.Conditions.createPlacedBlock(ModBlocks.TOMATO_CROP))
                .parent(farmland)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/plant_tomato");

        AdvancementEntry tomato = Advancement.Builder.create().display(ModItems.TOMATO,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.tomato.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.tomato.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_tomato", InventoryChangedCriterion.Conditions.items(ModItems.TOMATO))
                .parent(plant_tomato)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/tomato");

        AdvancementEntry plant_lettuce = Advancement.Builder.create().display(ModItems.LETTUCE_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_lettuce.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_lettuce.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_lettuce", ItemCriterion.Conditions.createPlacedBlock(ModBlocks.LETTUCE_CROP))
                .parent(farmland)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/plant_lettuce");

        AdvancementEntry lettuce = Advancement.Builder.create().display(ModItems.LETTUCE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.lettuce.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.lettuce.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_lettuce", InventoryChangedCriterion.Conditions.items(ModItems.LETTUCE))
                .parent(plant_lettuce)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/lettuce");

        AdvancementEntry raw_iron = Advancement.Builder.create().display(Items.RAW_IRON,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_iron.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_iron.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_raw_iron", InventoryChangedCriterion.Conditions.items(Items.RAW_IRON))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/raw_iron");

        AdvancementEntry iron = Advancement.Builder.create().display(Items.IRON_INGOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_iron", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .parent(raw_iron)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/iron");

        AdvancementEntry ironTools = Advancement.Builder.create()
                .display(Items.IRON_PICKAXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_tools.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_tools", InventoryChangedCriterion.Conditions.items(Items.IRON_SWORD,
                        Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE))
                .parent(iron)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/iron_tools");

        AdvancementEntry ironArmor = Advancement.Builder.create()
                .display(Items.IRON_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_armor.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_armor.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_armor", InventoryChangedCriterion.Conditions.items(Items.IRON_HELMET,
                        Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS))
                .parent(iron)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/iron_armor");

        AdvancementEntry diamonds = Advancement.Builder.create()
                .display(Items.DIAMOND,
                        Text.translatable("advancements."+ ChucksMod.MOD_ID + ".overworld.diamonds.title"),
                        Text.translatable("advancements."+ ChucksMod.MOD_ID + ".overworld.diamonds.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_diamonds", InventoryChangedCriterion.Conditions.items(Items.DIAMOND))
                .parent(ironTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/diamonds");

        AdvancementEntry diamondTools = Advancement.Builder.create()
                .display(Items.DIAMOND_SWORD,
                        Text.translatable("advancements."+ ChucksMod.MOD_ID + ".overworld.diamond_tools.title"),
                        Text.translatable("advancements."+ ChucksMod.MOD_ID + ".overworld.diamond_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("diamond_tools", InventoryChangedCriterion.Conditions.items(Items.DIAMOND_SWORD,
                        Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE))
                .parent(diamonds)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/diamond_tools");

        AdvancementEntry diamondArmor = Advancement.Builder.create()
                .display(Items.DIAMOND_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.diamond_armor.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.diamond_armor.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_diamond_armor", InventoryChangedCriterion.Conditions.items(Items.DIAMOND_HELMET,
                        Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS))
                .parent(diamonds)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/diamond_armor");

        AdvancementEntry redstone = Advancement.Builder.create()
                .display(Items.REDSTONE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.redstone.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.redstone.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_redstone", InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .parent(ironTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/redstone");

        AdvancementEntry piston = Advancement.Builder.create()
                .display(Blocks.PISTON,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.piston.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.piston.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_piston", InventoryChangedCriterion.Conditions.items(Blocks.PISTON))
                .parent(redstone)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/piston");

        AdvancementEntry ironGear = Advancement.Builder.create()
                .display(ModItems.IRON_GEAR,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_gear.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_gear.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_gear", InventoryChangedCriterion.Conditions.items(ModItems.IRON_GEAR))
                .parent(iron)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/iron_gear");

        AdvancementEntry crusher = Advancement.Builder.create()
                .display(ModBlocks.CRUSHER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.crusher.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.crusher.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_piston", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.CRUSHERS).build()))
                .parent(ironGear)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/crusher");

        AdvancementEntry dust = Advancement.Builder.create()
                .display(ModItems.IRON_DUST,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.dust.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.dust.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_dust", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.DUSTS).build()))
                .parent(crusher)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/dust");

        AdvancementEntry obsidian = Advancement.Builder.create()
                .display(Blocks.OBSIDIAN,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.obsidian.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.obsidian.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_obsidian", InventoryChangedCriterion.Conditions.items(Blocks.OBSIDIAN))
                .parent(diamondTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/obsidian");

        AdvancementEntry gravel = Advancement.Builder.create()
                .display(Blocks.GRAVEL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.gravel.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.gravel.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_gravel", InventoryChangedCriterion.Conditions.items(Blocks.GRAVEL))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/gravel");

        AdvancementEntry flint = Advancement.Builder.create()
                .display(Items.FLINT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.flint.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.flint.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_flint", InventoryChangedCriterion.Conditions.items(Items.FLINT))
                .parent(gravel)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/flint");

        AdvancementEntry sugarCane = Advancement.Builder.create()
                .display(Items.SUGAR_CANE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sugar_cane.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sugar_cane.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_sugar_cane", InventoryChangedCriterion.Conditions.items(Items.SUGAR_CANE))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/sugar_cane");

        AdvancementEntry paper = Advancement.Builder.create()
                .display(Items.PAPER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.paper.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.paper.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_paper", InventoryChangedCriterion.Conditions.items(Items.PAPER))
                .parent(sugarCane)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/sugar_cane");

        AdvancementEntry leather = Advancement.Builder.create()
                .display(Items.LEATHER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.leather.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.leather.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_leather", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .parent(meat)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/leather");

        AdvancementEntry book = Advancement.Builder.create()
                .display(Items.BOOK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.book.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.book.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_book", InventoryChangedCriterion.Conditions.items(Items.BOOK))
                .parent(leather)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/book");

        AdvancementEntry enchantmentTable = Advancement.Builder.create()
                .display(Blocks.ENCHANTING_TABLE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.enchanting_table.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.enchanting_table.desc"),
                        null, AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("get_enchanting_table", InventoryChangedCriterion.Conditions.items
                        (Blocks.ENCHANTING_TABLE))
                .parent(obsidian)
                .rewards(AdvancementRewards.Builder.loot(new Identifier("minecraft",
                        "blocks/lapis_ore")).addLoot(new Identifier("minecraft",
                        "blocks/lapis_ore")).addLoot(new Identifier("minecraft",
                        "blocks/lapis_ore")))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(consumer, ChucksMod.MOD_ID + "/overworld/enchanting_table");

        AdvancementEntry lapis = Advancement.Builder.create()
                .display(Items.LAPIS_LAZULI,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.lapis.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.lapis.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_lapis", InventoryChangedCriterion.Conditions.items(Items.LAPIS_LAZULI))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/lapis");

        AdvancementEntry flintAndSteel = Advancement.Builder.create()
                .display(Items.FLINT_AND_STEEL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.flint_and_steel.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.flint_and_steel.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_flint_and_steel", InventoryChangedCriterion.Conditions.items(Items.FLINT_AND_STEEL))
                .parent(iron)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/flint_and_steel");

        AdvancementEntry netherPortal = Advancement.Builder.create().display(Blocks.NETHERRACK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.nether_portal.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.nether_portal.desc"),
                        null, AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("light_nether_portal", ItemCriterion.Conditions.createPlacedBlock(Blocks.NETHER_PORTAL))
                .parent(obsidian)
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(consumer, ChucksMod.MOD_ID + "/overworld/nether_portal");

        AdvancementEntry village = Advancement.Builder.create().display(Blocks.OAK_PLANKS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.village.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.village.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .criterion("desert_village",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createStructure(StructureKeys.VILLAGE_DESERT)))
                .criterion("plains_village",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createStructure(StructureKeys.VILLAGE_PLAINS)))
                .criterion("savanna_village",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createStructure(StructureKeys.VILLAGE_SAVANNA)))
                .criterion("snowy_village",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createStructure(StructureKeys.VILLAGE_SNOWY)))
                .criterion("taiga_village",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createStructure(StructureKeys.VILLAGE_TAIGA)))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/village");

        AdvancementEntry trade = Advancement.Builder.create().display(Items.EMERALD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.trade.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.trade.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("trade", VillagerTradeCriterion.Conditions.any())
                .parent(village)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/trade");

        AdvancementEntry modern_tower = Advancement.Builder.create().display(Blocks.WHITE_CONCRETE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.modern_tower.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.modern_tower.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("modern_tower",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createStructure(ModStructureKeys.MODERN_TOWER)))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/modern_tower");

        AdvancementEntry spider = Advancement.Builder.create().display(Blocks.COBWEB,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.spider.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.spider.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_spider",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.SPIDER)))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/spider");

        AdvancementEntry string = Advancement.Builder.create()
                .display(Items.STRING,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.string.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.string.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_string", InventoryChangedCriterion.Conditions.items(Items.STRING))
                .parent(spider)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/string");

        AdvancementEntry sticks = Advancement.Builder.create()
                .display(Items.STICK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sticks.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sticks.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("sticks", InventoryChangedCriterion.Conditions.items(Items.STICK))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/sticks");

        AdvancementEntry bow = Advancement.Builder.create()
                .display(Items.BOW,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bow.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bow.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bow", InventoryChangedCriterion.Conditions.items(Items.BOW))
                .parent(string)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/bow");

        AdvancementEntry fishingRod = Advancement.Builder.create()
                .display(Items.FISHING_ROD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.fishing_rod.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.fishing_rod.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bow", InventoryChangedCriterion.Conditions.items(Items.FISHING_ROD))
                .parent(string)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/fishing_rod");

        AdvancementEntry shears = Advancement.Builder.create()
                .display(Items.SHEARS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.shears.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.shears.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("shears", InventoryChangedCriterion.Conditions.items(Items.SHEARS))
                .parent(iron)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/shears");

        AdvancementEntry wool = Advancement.Builder.create()
                .display(Blocks.WHITE_WOOL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wool.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wool.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("wool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(ItemTags.WOOL).build()))
                .parent(shears)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/wool");

        AdvancementEntry bed = Advancement.Builder.create()
                .display(Items.RED_BED,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bed.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bed.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bed", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(ItemTags.BEDS).build()))
                .parent(wool)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/bed");

        AdvancementEntry sapling = Advancement.Builder.create()
                .display(Items.OAK_SAPLING,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sapling.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sapling.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("sapling", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(ItemTags.SAPLINGS).build()))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/sapling");

        AdvancementEntry replantSapling = Advancement.Builder.create()
                .display(Items.SPRUCE_SAPLING,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.replant_sapling.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.replant_sapling.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .criterion("replant_oak", ItemCriterion.Conditions.createPlacedBlock(Blocks.OAK_SAPLING))
                .criterion("replant_birch", ItemCriterion.Conditions.createPlacedBlock(Blocks.BIRCH_SAPLING))
                .criterion("replant_spruce", ItemCriterion.Conditions.createPlacedBlock(Blocks.SPRUCE_SAPLING))
                .criterion("replant_jungle", ItemCriterion.Conditions.createPlacedBlock(Blocks.JUNGLE_SAPLING))
                .criterion("replant_dark_oak", ItemCriterion.Conditions.createPlacedBlock(Blocks.DARK_OAK_SAPLING))
                .criterion("replant_acacia", ItemCriterion.Conditions.createPlacedBlock(Blocks.ACACIA_SAPLING))
                .criterion("replant_cherry", ItemCriterion.Conditions.createPlacedBlock(Blocks.CHERRY_SAPLING))
                .criterion("replant_mangrove", ItemCriterion.Conditions.createPlacedBlock(Blocks.MANGROVE_PROPAGULE))
                .criterion("replant_eucalyptus", ItemCriterion.Conditions.createPlacedBlock(ModBlocks.EUCALYPTUS_SAPLING))
                .criterion("replant_diritia", ItemCriterion.Conditions.createPlacedBlock(ModBlocks.DIRITIA_SAPLING))
                .parent(sapling)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/replant_sapling");

        AdvancementEntry zombie = Advancement.Builder.create().display(Blocks.ZOMBIE_HEAD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.zombie.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.zombie.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_zombie",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.ZOMBIE)))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/zombie");

        AdvancementEntry skeleton = Advancement.Builder.create().display(Blocks.SKELETON_SKULL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.skeleton.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.skeleton.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_skeleton",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.SKELETON)))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/skeleton");

        AdvancementEntry bone = Advancement.Builder.create()
                .display(Items.BONE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bone.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bone.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bone", InventoryChangedCriterion.Conditions.items(Items.BONE))
                .parent(skeleton)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/bone");

        AdvancementEntry boneMeal = Advancement.Builder.create()
                .display(Items.BONE_MEAL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bone_meal.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bone_meal.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bone_meal", InventoryChangedCriterion.Conditions.items(Items.BONE_MEAL))
                .parent(bone)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/bone_meal");

        AdvancementEntry arrow = Advancement.Builder.create()
                .display(Items.BONE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.arrow.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.arrow.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bone", InventoryChangedCriterion.Conditions.items(Items.BONE))
                .parent(skeleton)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/bone");

        AdvancementEntry creeper = Advancement.Builder.create().display(Blocks.CREEPER_HEAD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.creeper.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.creeper.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_creeper",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.CREEPER)))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/creeper");

        AdvancementEntry gunpowder = Advancement.Builder.create()
                .display(Items.GUNPOWDER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.gunpowder.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.gunpowder.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("gunpowder", InventoryChangedCriterion.Conditions.items(Items.GUNPOWDER))
                .parent(creeper)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/gunpowder");

        AdvancementEntry bucket = Advancement.Builder.create()
                .display(Items.WATER_BUCKET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bucket.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bucket.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bucket", InventoryChangedCriterion.Conditions.items(Items.BUCKET))
                .parent(iron)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/bucket");

        AdvancementEntry waterBucket = Advancement.Builder.create()
                .display(Items.WATER_BUCKET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.water_bucket.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.water_bucket.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("water_bucket", InventoryChangedCriterion.Conditions.items(Items.WATER_BUCKET))
                .parent(bucket)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/water_bucket");

        AdvancementEntry woolBag = Advancement.Builder.create()
                .display(ModItems.WOOL_BAG,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wool_bag.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wool_bag.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("wool_bag", InventoryChangedCriterion.Conditions.items(ModItems.WOOL_BAG))
                .parent(wool)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/wool_bag");

        AdvancementEntry leatherBag = Advancement.Builder.create()
                .display(ModItems.LEATHER_BAG,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.leather_bag.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.leather_bag.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("leather_bag", InventoryChangedCriterion.Conditions.items(ModItems.LEATHER_BAG))
                .parent(leather)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/leather_bag");

        AdvancementEntry rawCopper = Advancement.Builder.create()
                .display(Items.RAW_COPPER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_copper.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_copper.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("raw_copper", InventoryChangedCriterion.Conditions.items(Items.RAW_COPPER))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/raw_copper");

        AdvancementEntry copper = Advancement.Builder.create()
                .display(Items.COPPER_INGOT ,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("copper", InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
                .parent(rawCopper)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/copper");

        AdvancementEntry copperWire = Advancement.Builder.create()
                .display(ModBlocks.COPPER_WIRE ,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper_wire.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper_wire.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_copper_wire", InventoryChangedCriterion.Conditions.items(ModBlocks.COPPER_WIRE))
                .parent(copper)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/copper_wire");

        AdvancementEntry rawTitanium = Advancement.Builder.create()
                .display(ModItems.RAW_TITANIUM,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_titanium.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_titanium.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_raw_titanium", InventoryChangedCriterion.Conditions.items(ModItems.RAW_TITANIUM))
                .parent(ironTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/raw_titanium");

        AdvancementEntry titanium = Advancement.Builder.create()
                .display(ModItems.TITANIUM_INGOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium", InventoryChangedCriterion.Conditions.items(ModItems.TITANIUM_INGOT))
                .parent(rawTitanium)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/titanium");

        AdvancementEntry titaniumTools = Advancement.Builder.create()
                .display(ModItems.TITANIUM_AXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_tools.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium_tools", InventoryChangedCriterion.Conditions.items(ModItems.TITANIUM_SWORD,
                        ModItems.TITANIUM_PICKAXE, ModItems.TITANIUM_AXE, ModItems.TITANIUM_SHOVEL, ModItems.TITANIUM_HOE))
                .parent(titanium)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/titanium_tools");

        AdvancementEntry titaniumArmor = Advancement.Builder.create()
                .display(ModItems.TITANIUM_HELMET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_armor.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_armor.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium_armor", InventoryChangedCriterion.Conditions.items(ModItems.TITANIUM_HELMET,
                        ModItems.TITANIUM_CHESTPLATE, ModItems.TITANIUM_LEGGINGS, ModItems.TITANIUM_BOOTS))
                .parent(titanium)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/titanium_armor");

        AdvancementEntry enderman = Advancement.Builder.create().display(Items.ENDER_PEARL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.enderman.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.enderman.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_enderman",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create()
                                .type(EntityType.ENDERMAN)))
                .parent(stoneTools)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/enderman");

        AdvancementEntry eyeOfEnder = Advancement.Builder.create().display(Items.ENDER_EYE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.eye_of_ender.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.eye_of_ender.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("eye_of_ender",
                        InventoryChangedCriterion.Conditions.items(Items.ENDER_EYE))
                .parent(enderman)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/eye_of_ender");

        AdvancementEntry stronghold = Advancement.Builder.create().display(Blocks.STONE_BRICKS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.stronghold.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.stronghold.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("stronghold",
                        TickCriterion.Conditions
                                .createLocation(LocationPredicate.Builder.createStructure(StructureKeys.STRONGHOLD)))
                .parent(enderman)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/stronghold");

        AdvancementEntry endPortal = Advancement.Builder.create().display(Blocks.END_PORTAL_FRAME,
                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.end_portal.title"),
                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.end_portal.desc"),
                null, AdvancementFrame.TASK, true, true, false)
                .criterion("end_portal", ItemCriterion.Conditions.createItemUsedOnBlock(
                        LocationPredicate.Builder.create().block(BlockPredicate.Builder
                                .create().blocks(Blocks.END_PORTAL_FRAME)),
                        ItemPredicate.Builder.create().items(Items.ENDER_EYE)))
                .parent(stronghold)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/end_portal");

        AdvancementEntry chest = Advancement.Builder.create().display(Blocks.CHEST,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.chest.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.chest.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("chest",
                        InventoryChangedCriterion.Conditions.items(Items.CHEST))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/overworld/chest");
    }
}
