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
import net.minecraft.predicate.BlockPredicate;
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
        AdvancementEntry root = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.OAK_LOG, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.root.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.root.desc"), // The description
                        new Identifier(ChucksMod.MOD_ID, "textures/block/eucalyptus_planks.png"), // Background image used
                        AdvancementFrame.TASK, true, true, false)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_logs", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.LOGS).build()))
                , consumer, "overworld/root");

        AdvancementEntry craftingTable = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.CRAFTING_TABLE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.crafting_table.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.crafting_table.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("crafting_table", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
                .parent(root)
                , consumer, "overworld/crafting_table");

        AdvancementEntry woodPickaxe = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.WOODEN_PICKAXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wooden_pickaxe.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wooden_pickaxe.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_wooden_pick", InventoryChangedCriterion.Conditions.items(Items.WOODEN_PICKAXE))
                .parent(craftingTable)
                , consumer, "overworld/wooden_pickaxe");

        AdvancementEntry cobble = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.COBBLESTONE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.cobble.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.cobble.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_cobble", InventoryChangedCriterion.Conditions.items(Items.COBBLESTONE))
                .parent(woodPickaxe)
                , consumer, "overworld/cobble");

        AdvancementEntry stoneTools = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.STONE_AXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.stone_tools.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.stone_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_stone_tools", InventoryChangedCriterion.Conditions.items(Items.STONE_SWORD,
                        Items.STONE_PICKAXE, Items.STONE_AXE, Items.STONE_SHOVEL, Items.STONE_HOE))
                .parent(cobble)
                , consumer, "overworld/stone_tools");

        AdvancementEntry furnace = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.FURNACE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.furnace.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.furnace.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_furnace", InventoryChangedCriterion.Conditions.items(Items.FURNACE))
                .parent(cobble)
                , consumer, "overworld/furnace");

        AdvancementEntry coal = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.COAL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.coal.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.coal.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_coal", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.COALS).build()))
                .parent(furnace)
                , consumer, "overworld/coal");

        AdvancementEntry meat = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.PORKCHOP,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.meat.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.meat.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_meat", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.RAW_MEAT).build()))
                .parent(stoneTools)
                , consumer, "overworld/meat");

        AdvancementEntry cookedMeat = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.COOKED_PORKCHOP,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.cooked_meat.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.cooked_meat.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("cook_meat", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.COOKED_MEAT).build()))
                .parent(meat)
                , consumer, "overworld/cooked_meat");

        AdvancementEntry seeds = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.WHEAT_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.seeds.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.seeds.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                        .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .criterion("get_seeds", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.SEEDS).build()))
                        .criterion("get_carrot_or_potato", 
                                InventoryChangedCriterion.Conditions.items(Items.CARROT, Items.POTATO))
                .parent(stoneTools)
                , consumer, "overworld/seeds");

        AdvancementEntry farmland = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.FARMLAND,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.farmland.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.farmland.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("create_farmland", ItemCriterion.Conditions.createItemUsedOnBlock(
                        LocationPredicate.Builder.create().block(BlockPredicate.Builder.create()
                                .blocks(Blocks.FARMLAND)),
                        ItemPredicate.Builder.create().tag(ItemTags.HOES)))
                .parent(seeds)
                , consumer, "overworld/farmland");

        AdvancementEntry plant_wheat = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.WHEAT_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_seeds.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_seeds.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_wheat", ItemCriterion.Conditions.createPlacedBlock(Blocks.WHEAT))
                .parent(farmland)
                , consumer, "overworld/plant_wheat");

        AdvancementEntry wheat = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.WHEAT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wheat.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wheat.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_wheat", InventoryChangedCriterion.Conditions.items(Items.WHEAT))
                .parent(plant_wheat)
                , consumer, "overworld/wheat");

        AdvancementEntry bread = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.BREAD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bread.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bread.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_bread", InventoryChangedCriterion.Conditions.items(Items.BREAD))
                .parent(wheat)
                , consumer, "overworld/bread");

        AdvancementEntry plant_beetroot = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.BEETROOT_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_beetroot.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_beetroot.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_beetroot", ItemCriterion.Conditions.createPlacedBlock(Blocks.BEETROOTS))
                .parent(farmland)
                , consumer, "overworld/plant_beetroot");

        AdvancementEntry beetroot = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.BEETROOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.beetroot.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.beetroot.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_beetroot", InventoryChangedCriterion.Conditions.items(Items.BEETROOT))
                .parent(plant_beetroot)
                , consumer, "overworld/beetroot");

        AdvancementEntry plant_tomato = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(ModItems.TOMATO_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_tomato.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_tomato.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_tomato", ItemCriterion.Conditions.createPlacedBlock(ModBlocks.TOMATO_CROP))
                .parent(farmland)
                , consumer, "overworld/plant_tomato");

        AdvancementEntry tomato = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(ModItems.TOMATO,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.tomato.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.tomato.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_tomato", InventoryChangedCriterion.Conditions.items(ModItems.TOMATO))
                .parent(plant_tomato)
                , consumer, "overworld/tomato");

        AdvancementEntry plant_lettuce = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(ModItems.LETTUCE_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_lettuce.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_lettuce.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_lettuce", ItemCriterion.Conditions.createPlacedBlock(ModBlocks.LETTUCE_CROP))
                .parent(farmland)
                , consumer, "overworld/plant_lettuce");

        AdvancementEntry lettuce = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(ModItems.LETTUCE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.lettuce.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.lettuce.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_lettuce", InventoryChangedCriterion.Conditions.items(ModItems.LETTUCE))
                .parent(plant_lettuce)
                , consumer, "overworld/lettuce");

        AdvancementEntry plantCarrot = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.CARROT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_carrot.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_carrot.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_carrot", ItemCriterion.Conditions.createPlacedBlock(Blocks.CARROTS))
                .parent(farmland)
                , consumer, "overworld/plant_carrot");

        AdvancementEntry goldenCarrot = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.GOLDEN_CARROT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.golden_carrot.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.golden_carrot.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("golden_carrot", InventoryChangedCriterion.Conditions.items(Items.GOLDEN_CARROT))
                .parent(plantCarrot)
                , consumer, "overworld/golden_carrot");

        AdvancementEntry plantPotato = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.POTATO,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_potato.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.plant_potato.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("plant_potato", ItemCriterion.Conditions.createPlacedBlock(Blocks.POTATOES))
                .parent(farmland)
                , consumer, "overworld/plant_potato");

        AdvancementEntry bakedPotato = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.BAKED_POTATO,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.baked_potato.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.baked_potato.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("baked_potato", InventoryChangedCriterion.Conditions.items(Items.BAKED_POTATO))
                .parent(plantPotato)
                , consumer, "overworld/baked_potato");

        AdvancementEntry raw_iron = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.RAW_IRON,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_iron.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_iron.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_raw_iron", InventoryChangedCriterion.Conditions.items(Items.RAW_IRON))
                .parent(stoneTools)
                , consumer, "overworld/raw_iron");

        AdvancementEntry iron = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.IRON_INGOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_iron", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .parent(raw_iron)
                , consumer, "overworld/iron");

        AdvancementEntry ironTools = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.IRON_PICKAXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_tools.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_tools", InventoryChangedCriterion.Conditions.items(Items.IRON_SWORD,
                        Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE))
                .parent(iron)
                , consumer, "overworld/iron_tools");

        AdvancementEntry ironArmor = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.IRON_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_armor.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_armor.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_armor", InventoryChangedCriterion.Conditions.items(Items.IRON_HELMET,
                        Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS))
                .parent(iron), consumer, "overworld/iron_armor");

        AdvancementEntry ironBag = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.IRON_BAG,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_bag.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_bag.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_bag", InventoryChangedCriterion.Conditions.items(ModItems.IRON_BAG))
                .parent(iron), consumer, "overworld/iron_bag");

        AdvancementEntry diamonds = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.DIAMOND,
                        Text.translatable("advancements."+ ChucksMod.MOD_ID + ".overworld.diamonds.title"),
                        Text.translatable("advancements."+ ChucksMod.MOD_ID + ".overworld.diamonds.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_diamonds", InventoryChangedCriterion.Conditions.items(Items.DIAMOND))
                .parent(ironTools)
                , consumer, "overworld/diamonds");

        AdvancementEntry diamondTools = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.DIAMOND_SWORD,
                        Text.translatable("advancements."+ ChucksMod.MOD_ID + ".overworld.diamond_tools.title"),
                        Text.translatable("advancements."+ ChucksMod.MOD_ID + ".overworld.diamond_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("diamond_tools", InventoryChangedCriterion.Conditions.items(Items.DIAMOND_SWORD,
                        Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE))
                .parent(diamonds)
                , consumer, "overworld/diamond_tools");

        AdvancementEntry diamondArmor = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.DIAMOND_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.diamond_armor.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.diamond_armor.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_diamond_armor", InventoryChangedCriterion.Conditions.items(Items.DIAMOND_HELMET,
                        Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS))
                .parent(diamonds)
                , consumer, "overworld/diamond_armor");

        AdvancementEntry redstone = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.REDSTONE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.redstone.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.redstone.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_redstone", InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .parent(ironTools)
                , consumer, "overworld/redstone");

        AdvancementEntry piston = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Blocks.PISTON,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.piston.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.piston.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_piston", InventoryChangedCriterion.Conditions.items(Blocks.PISTON))
                .parent(redstone)
                , consumer, "overworld/piston");

        AdvancementEntry ironGear = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.IRON_GEAR,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_gear.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.iron_gear.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron_gear", InventoryChangedCriterion.Conditions.items(ModItems.IRON_GEAR))
                .parent(iron)
                , consumer, "overworld/iron_gear");

        AdvancementEntry crusher = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModBlocks.CRUSHER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.crusher.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.crusher.desc"),
                        null, AdvancementFrame.GOAL, true, true, false)
                .criterion("get_piston", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.CRUSHERS).build()))
                .parent(ironGear)
                , consumer, "overworld/crusher");

        AdvancementEntry dust = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.IRON_DUST,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.dust.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.dust.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_dust", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.DUSTS).build()))
                .parent(crusher)
                , consumer, "overworld/dust");

        AdvancementEntry bronzeDust = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.BRONZE_DUST,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_dust.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_dust.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_bronze_dust", InventoryChangedCriterion.Conditions.items(ModItems.BRONZE_DUST))
                .parent(dust), consumer, "overworld/bronze_dust");

        AdvancementEntry bronze = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.BRONZE_INGOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_ingot.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_ingot.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_bronze", InventoryChangedCriterion.Conditions.items(ModItems.BRONZE_INGOT))
                .parent(bronzeDust), consumer, "overworld/bronze_ingot");


        AdvancementEntry bronzeTools = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                        .display(ModItems.BRONZE_PICKAXE,
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_tools.title"),
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_tools.desc"),
                                null, AdvancementFrame.TASK, true, true, false)
                        .criterion("get_bronze_tools", InventoryChangedCriterion.Conditions.items(ModItems.BRONZE_SWORD,
                                ModItems.BRONZE_PICKAXE, ModItems.BRONZE_AXE, ModItems.BRONZE_SHOVEL, ModItems.BRONZE_HOE))
                        .parent(bronze)
                , consumer, "overworld/bronze_tools");

        AdvancementEntry bronzeArmor = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                        .display(ModItems.BRONZE_CHESTPLATE,
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_armor.title"),
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_armor.desc"),
                                null, AdvancementFrame.TASK, true, true, false)
                        .criterion("get_bronze_armor", InventoryChangedCriterion.Conditions.items(ModItems.BRONZE_HELMET,
                                ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS))
                        .parent(bronze)
                , consumer, "overworld/bronze_armor");

        AdvancementEntry bronzeBag = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                        .display(ModItems.BRONZE_BAG,
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_bag.title"),
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bronze_bag.desc"),
                                null, AdvancementFrame.TASK, true, true, false)
                        .criterion("get_bronze_bag", InventoryChangedCriterion.Conditions.items(ModItems.BRONZE_BAG))
                        .parent(bronze)
                , consumer, "overworld/bronze_bag");

        AdvancementEntry obsidian = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Blocks.OBSIDIAN,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.obsidian.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.obsidian.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_obsidian", InventoryChangedCriterion.Conditions.items(Blocks.OBSIDIAN))
                .parent(diamondTools)
                , consumer, "overworld/obsidian");

        AdvancementEntry gravel = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Blocks.GRAVEL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.gravel.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.gravel.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_gravel", InventoryChangedCriterion.Conditions.items(Blocks.GRAVEL))
                .parent(stoneTools)
                , consumer, "overworld/gravel");

        AdvancementEntry flint = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.FLINT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.flint.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.flint.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_flint", InventoryChangedCriterion.Conditions.items(Items.FLINT))
                .parent(gravel)
                , consumer, "overworld/flint");

        AdvancementEntry sugarCane = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.SUGAR_CANE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sugar_cane.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sugar_cane.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_sugar_cane", InventoryChangedCriterion.Conditions.items(Items.SUGAR_CANE))
                .parent(root)
                , consumer, "overworld/sugar_cane");

        AdvancementEntry paper = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.PAPER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.paper.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.paper.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_paper", InventoryChangedCriterion.Conditions.items(Items.PAPER))
                .parent(sugarCane)
                , consumer, "overworld/sugar_cane");

        AdvancementEntry leather = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.LEATHER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.leather.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.leather.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_leather", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .parent(meat)
                , consumer, "overworld/leather");

        AdvancementEntry book = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.BOOK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.book.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.book.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_book", InventoryChangedCriterion.Conditions.items(Items.BOOK))
                .parent(leather)
                , consumer, "overworld/book");

        AdvancementEntry enchantmentTable = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
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
                , consumer, "overworld/enchanting_table");

        AdvancementEntry lapis = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.LAPIS_LAZULI,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.lapis.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.lapis.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_lapis", InventoryChangedCriterion.Conditions.items(Items.LAPIS_LAZULI))
                .parent(stoneTools)
                , consumer, "overworld/lapis");

        AdvancementEntry flintAndSteel = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.FLINT_AND_STEEL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.flint_and_steel.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.flint_and_steel.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_flint_and_steel", InventoryChangedCriterion.Conditions.items(Items.FLINT_AND_STEEL))
                .parent(iron)
                , consumer, "overworld/flint_and_steel");

        AdvancementEntry netherPortal = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.NETHERRACK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.nether_portal.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.nether_portal.desc"),
                        null, AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("light_nether_portal", ItemCriterion.Conditions.createPlacedBlock(Blocks.NETHER_PORTAL))
                .parent(obsidian)
                .rewards(AdvancementRewards.Builder.experience(100))
                , consumer, "overworld/nether_portal");

        AdvancementEntry village = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.OAK_PLANKS,
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
                , consumer, "overworld/village");

        AdvancementEntry trade = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.EMERALD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.trade.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.trade.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("trade", VillagerTradeCriterion.Conditions.any())
                .parent(village)
                , consumer, "overworld/trade");

        AdvancementEntry modern_tower = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.WHITE_CONCRETE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.modern_tower.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.modern_tower.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("modern_tower",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createStructure(ModStructureKeys.MODERN_TOWER)))
                .parent(root)
                , consumer, "overworld/modern_tower");

        AdvancementEntry spider = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.COBWEB,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.spider.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.spider.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_spider",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.SPIDER)))
                .parent(stoneTools)
                , consumer, "overworld/spider");

        AdvancementEntry string = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.STRING,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.string.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.string.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_string", InventoryChangedCriterion.Conditions.items(Items.STRING))
                .parent(spider)
                , consumer, "overworld/string");

        AdvancementEntry sticks = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.STICK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sticks.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sticks.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("sticks", InventoryChangedCriterion.Conditions.items(Items.STICK))
                .parent(root)
                , consumer, "overworld/sticks");

        AdvancementEntry bow = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.BOW,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bow.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bow.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bow", InventoryChangedCriterion.Conditions.items(Items.BOW))
                .parent(string)
                , consumer, "overworld/bow");

        AdvancementEntry fishingRod = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.FISHING_ROD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.fishing_rod.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.fishing_rod.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bow", InventoryChangedCriterion.Conditions.items(Items.FISHING_ROD))
                .parent(string)
                , consumer, "overworld/fishing_rod");

        AdvancementEntry shears = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.SHEARS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.shears.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.shears.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("shears", InventoryChangedCriterion.Conditions.items(Items.SHEARS))
                .parent(iron)
                , consumer, "overworld/shears");

        AdvancementEntry wool = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Blocks.WHITE_WOOL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wool.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wool.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("wool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(ItemTags.WOOL).build()))
                .parent(shears)
                , consumer, "overworld/wool");

        AdvancementEntry bed = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.RED_BED,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bed.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bed.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bed", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(ItemTags.BEDS).build()))
                .parent(wool)
                , consumer, "overworld/bed");

        AdvancementEntry sapling = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.OAK_SAPLING,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sapling.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.sapling.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("sapling", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(ItemTags.SAPLINGS).build()))
                .parent(root)
                , consumer, "overworld/sapling");

        AdvancementEntry replantSapling = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
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
                .criterion("replant_pacsaria", ItemCriterion.Conditions.createPlacedBlock(ModBlocks.PACSARIA_SAPLING))
                .parent(sapling)
                , consumer, "overworld/replant_sapling");

        AdvancementEntry zombie = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.ZOMBIE_HEAD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.zombie.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.zombie.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_zombie",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.ZOMBIE)))
                .parent(stoneTools)
                , consumer, "overworld/zombie");

        AdvancementEntry skeleton = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.SKELETON_SKULL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.skeleton.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.skeleton.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_skeleton",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.SKELETON)))
                .parent(stoneTools)
                , consumer, "overworld/skeleton");

        AdvancementEntry bone = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.BONE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bone.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bone.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bone", InventoryChangedCriterion.Conditions.items(Items.BONE))
                .parent(skeleton)
                , consumer, "overworld/bone");

        AdvancementEntry boneMeal = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.BONE_MEAL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bone_meal.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bone_meal.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bone_meal", InventoryChangedCriterion.Conditions.items(Items.BONE_MEAL))
                .parent(bone)
                , consumer, "overworld/bone_meal");

        AdvancementEntry arrow = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.BONE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.arrow.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.arrow.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bone", InventoryChangedCriterion.Conditions.items(Items.BONE))
                .parent(skeleton)
                , consumer, "overworld/bone");

        AdvancementEntry creeper = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.CREEPER_HEAD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.creeper.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.creeper.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_creeper",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.CREEPER)))
                .parent(stoneTools)
                , consumer, "overworld/creeper");

        AdvancementEntry gunpowder = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.GUNPOWDER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.gunpowder.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.gunpowder.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("gunpowder", InventoryChangedCriterion.Conditions.items(Items.GUNPOWDER))
                .parent(creeper)
                , consumer, "overworld/gunpowder");

        AdvancementEntry bucket = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.BUCKET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bucket.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.bucket.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bucket", InventoryChangedCriterion.Conditions.items(Items.BUCKET))
                .parent(iron)
                , consumer, "overworld/bucket");

        AdvancementEntry waterBucket = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.WATER_BUCKET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.water_bucket.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.water_bucket.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("water_bucket", InventoryChangedCriterion.Conditions.items(Items.WATER_BUCKET))
                .parent(bucket)
                , consumer, "overworld/water_bucket");

        AdvancementEntry woolBag = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.WOOL_BAG,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wool_bag.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wool_bag.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("wool_bag", InventoryChangedCriterion.Conditions.items(ModItems.WOOL_BAG))
                .parent(wool)
                , consumer, "overworld/wool_bag");

        AdvancementEntry leatherBag = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.LEATHER_BAG,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.leather_bag.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.leather_bag.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("leather_bag", InventoryChangedCriterion.Conditions.items(ModItems.LEATHER_BAG))
                .parent(leather)
                , consumer, "overworld/leather_bag");

        AdvancementEntry rawCopper = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.RAW_COPPER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_copper.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_copper.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("raw_copper", InventoryChangedCriterion.Conditions.items(Items.RAW_COPPER))
                .parent(stoneTools)
                , consumer, "overworld/raw_copper");

        AdvancementEntry copper = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.COPPER_INGOT ,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("copper", InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
                .parent(rawCopper)
                , consumer, "overworld/copper");

        AdvancementEntry copperWire = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModBlocks.COPPER_WIRE ,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper_wire.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper_wire.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_copper_wire", InventoryChangedCriterion.Conditions.items(ModBlocks.COPPER_WIRE))
                .parent(copper)
                , consumer, "overworld/copper_wire");

        AdvancementEntry rawTin = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                        .display(ModItems.RAW_TIN,
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_tin.title"),
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_tin.desc"),
                                null, AdvancementFrame.TASK, true, true, false)
                        .criterion("raw_tin", InventoryChangedCriterion.Conditions.items(ModItems.RAW_TIN))
                        .parent(stoneTools)
                , consumer, "overworld/raw_tin");

        AdvancementEntry tin = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                        .display(ModItems.TIN_INGOT ,
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.tin.title"),
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.tin.desc"),
                                null, AdvancementFrame.TASK, true, true, false)
                        .criterion("tin", InventoryChangedCriterion.Conditions.items(ModItems.TIN_INGOT))
                        .parent(rawTin)
                , consumer, "overworld/tin");

        AdvancementEntry tinWire = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                        .display(ModBlocks.TIN_WIRE ,
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.tin_wire.title"),
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.tin_wire.desc"),
                                null, AdvancementFrame.TASK, true, true, false)
                        .criterion("get_tin_wire", InventoryChangedCriterion.Conditions.items(ModBlocks.TIN_WIRE))
                        .parent(tin)
                , consumer, "overworld/tin_wire");
        
        AdvancementEntry copperBag = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                        .display(ModItems.COPPER_BAG,
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper_bag.title"),
                                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.copper_bag.desc"),
                                null, AdvancementFrame.TASK, true, true, false)
                        .criterion("copper_bag", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_BAG))
                        .parent(copper)
                , consumer, "overworld/copper_bag");

        AdvancementEntry rawTitanium = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.RAW_TITANIUM,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_titanium.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.raw_titanium.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_raw_titanium", InventoryChangedCriterion.Conditions.items(ModItems.RAW_TITANIUM))
                .parent(ironTools)
                , consumer, "overworld/raw_titanium");

        AdvancementEntry titanium = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.TITANIUM_INGOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium", InventoryChangedCriterion.Conditions.items(ModItems.TITANIUM_INGOT))
                .parent(rawTitanium)
                , consumer, "overworld/titanium");

        AdvancementEntry titaniumTools = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.TITANIUM_AXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_tools.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium_tools", InventoryChangedCriterion.Conditions.items(ModItems.TITANIUM_SWORD,
                        ModItems.TITANIUM_PICKAXE, ModItems.TITANIUM_AXE, ModItems.TITANIUM_SHOVEL, ModItems.TITANIUM_HOE))
                .parent(titanium)
                , consumer, "overworld/titanium_tools");

        AdvancementEntry titaniumArmor = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.TITANIUM_HELMET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_armor.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_armor.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium_armor", InventoryChangedCriterion.Conditions.items(ModItems.TITANIUM_HELMET,
                        ModItems.TITANIUM_CHESTPLATE, ModItems.TITANIUM_LEGGINGS, ModItems.TITANIUM_BOOTS))
                .parent(titanium)
                , consumer, "overworld/titanium_armor");

        AdvancementEntry titaniumBag = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.TITANIUM_BAG,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_bag.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.titanium_bag.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_titanium_bag", InventoryChangedCriterion.Conditions.items(ModItems.TITANIUM_BAG))
                .parent(titanium)
                , consumer, "overworld/titanium_bag");

        AdvancementEntry enderman = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.ENDER_PEARL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.enderman.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.enderman.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_enderman",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create()
                                .type(EntityType.ENDERMAN)))
                .parent(stoneTools)
                , consumer, "overworld/enderman");

        AdvancementEntry eyeOfEnder = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.ENDER_EYE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.eye_of_ender.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.eye_of_ender.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("eye_of_ender",
                        InventoryChangedCriterion.Conditions.items(Items.ENDER_EYE))
                .parent(enderman), consumer, "overworld/eye_of_ender");

        AdvancementEntry enderChest = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.ENDER_EYE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.ender_chest.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.ender_chest.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("ender_chest", InventoryChangedCriterion.Conditions.items(Items.ENDER_CHEST))
                .parent(eyeOfEnder), consumer, "overworld/ender_chest");

        AdvancementEntry stronghold = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.STONE_BRICKS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.stronghold.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.stronghold.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("stronghold",
                        TickCriterion.Conditions
                                .createLocation(LocationPredicate.Builder.createStructure(StructureKeys.STRONGHOLD)))
                .parent(enderman)
                , consumer, "overworld/stronghold");

        AdvancementEntry endPortal = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.END_PORTAL_FRAME,
                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.end_portal.title"),
                Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.end_portal.desc"),
                null, AdvancementFrame.TASK, true, true, false)
                .criterion("end_portal", ItemCriterion.Conditions.createItemUsedOnBlock(
                        LocationPredicate.Builder.create().block(BlockPredicate.Builder
                                .create().blocks(Blocks.END_PORTAL_FRAME)),
                        ItemPredicate.Builder.create().items(Items.ENDER_EYE)))
                .parent(stronghold)
                , consumer, "overworld/end_portal");

        AdvancementEntry chest = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.CHEST,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.chest.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.chest.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("chest",
                        InventoryChangedCriterion.Conditions.items(Items.CHEST))
                .parent(root)
                , consumer, "overworld/chest");
    }
}
