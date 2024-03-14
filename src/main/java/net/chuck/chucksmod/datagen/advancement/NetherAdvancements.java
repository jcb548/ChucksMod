package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.world.gen.ModStructureKeys;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureKeys;

import java.util.function.Consumer;

public class NetherAdvancements {
    public static void generateAdvancements(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry root = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.NETHERRACK, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.root.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.root.desc"), // The description
                        new Identifier("minecraft", "textures/block/nether_bricks.png"), // Background image used
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("enter_nether", ChangedDimensionCriterion.Conditions.to(World.NETHER)), consumer, "nether/root");

        AdvancementEntry rawTriafium = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(ModItems.RAW_TRIAFIUM,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.raw_triafium.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.raw_triafium.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("raw_triafium", InventoryChangedCriterion.Conditions.items(ModItems.RAW_TRIAFIUM))
                .parent(root)
                , consumer, "nether/raw_triafium");

        AdvancementEntry triafium = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(ModItems.TRIAFIUM_INGOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.triafium.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.triafium.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("triafium", InventoryChangedCriterion.Conditions.items(ModItems.TRIAFIUM_INGOT))
                .parent(rawTriafium)
                , consumer, "nether/triafium");

        AdvancementEntry ancientDebris = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.ANCIENT_DEBRIS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.ancient_debris.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.ancient_debris.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("ancient_debris", InventoryChangedCriterion.Conditions.items(Blocks.ANCIENT_DEBRIS))
                .parent(root)
                , consumer, "nether/ancient_debris");

        AdvancementEntry netheriteScrap = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.NETHERITE_SCRAP,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.netherite_scrap.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.netherite_scrap.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("netherite_scrap", InventoryChangedCriterion.Conditions.items(Items.NETHERITE_SCRAP))
                .parent(ancientDebris)
                , consumer, "nether/netherite_scrap");

        AdvancementEntry netheriteIngot = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.NETHERITE_INGOT,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.netherite_ingot.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.netherite_ingot.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("netherite_ingot", InventoryChangedCriterion.Conditions.items(Items.NETHERITE_INGOT))
                .parent(netheriteScrap)
                , consumer, "nether/netherite_ingot");

        AdvancementEntry netheriteTool = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.NETHERITE_PICKAXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.netherite_tool.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.netherite_tool.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("netherite_tool", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.NETHERITE_TOOLS_ARMOR)))
                .parent(netheriteIngot)
                , consumer, "nether/netherite_tool");

        AdvancementEntry fullNetherite = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(
                Items.NETHERITE_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.full_netherite.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.full_netherite.desc"),
                        null, AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("full_netherite", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .items(Items.NETHERITE_PICKAXE, Items.NETHERITE_AXE, Items.NETHERITE_SHOVEL, Items.NETHERITE_HOE,
                                Items.NETHERITE_SWORD, Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE,
                                Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS)))
                .parent(netheriteTool)
                , consumer, "nether/full_netherite");

        AdvancementEntry quartz = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.QUARTZ,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.quartz.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.quartz.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("quartz", InventoryChangedCriterion.Conditions.items(Items.QUARTZ))
                .parent(root)
                , consumer, "nether/quartz");

        AdvancementEntry zombifiedPiglin = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.GOLD_NUGGET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.zombified_piglin.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.zombified_piglin.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_zombified_piglin",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.ZOMBIFIED_PIGLIN)))
                .parent(root), consumer, "nether/zombified_piglin");
        
        AdvancementEntry enterFortress = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.NETHER_BRICKS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.enter_fortress.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.enter_fortress.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enter_fortress",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder
                                .createStructure(StructureKeys.FORTRESS)))
                .parent(root)
                , consumer, "nether/fortress");

        AdvancementEntry blaze = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.BLAZE_ROD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.blaze.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.blaze.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_blaze",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create()
                                .type(EntityType.BLAZE)))
                .parent(enterFortress)
                , consumer, "nether/blaze");

        AdvancementEntry blazePowder = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.BLAZE_POWDER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.blaze_powder.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.blaze_powder.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("blaze_powder",
                        InventoryChangedCriterion.Conditions.items(Items.BLAZE_POWDER))
                .parent(blaze)
                , consumer, "nether/blaze_powder");

        AdvancementEntry wither_skeleton = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.WITHER_SKELETON_SKULL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.wither_skeleton.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.wither_skeleton.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_wither_skeleton",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create()
                                .type(EntityType.WITHER_SKELETON)))
                .parent(enterFortress), consumer, "nether/wither_skeleton");

        AdvancementEntry wither = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.NETHER_STAR,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + "nether.summon_wither.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + "nether.summon_wither.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("summon_wither", SummonedEntityCriterion.Conditions.create(EntityPredicate.Builder.create().type(EntityType.WITHER)))
                .parent(wither_skeleton), consumer, "nether/summon_wither");

        AdvancementEntry enterBastion = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.POLISHED_BLACKSTONE_BRICKS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.enter_bastion.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.enter_bastion.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enter_bastion",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder
                                .createStructure(StructureKeys.BASTION_REMNANT)))
                .parent(root), consumer, "nether/bastion");

        AdvancementEntry netheriteUpgrade = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.netherite_upgrade.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.netherite_upgrade.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("netherite_upgrade", InventoryChangedCriterion.Conditions.items
                        (Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .parent(enterBastion), consumer, "nether/netherite_upgrade");

        AdvancementEntry soulSand = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.SOUL_SAND,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.soul_sand.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.soul_sand.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .criterion("soul_sand", InventoryChangedCriterion.Conditions.items
                        (Blocks.SOUL_SAND))
                .criterion("soul_soil", InventoryChangedCriterion.Conditions.items
                        (Blocks.SOUL_SOIL))
                .parent(root), consumer, "nether/soul_sand");

        AdvancementEntry soulTorch = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.SOUL_TORCH,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.soul_torch.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.soul_torch.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("soul_torch", InventoryChangedCriterion.Conditions.items
                        (Blocks.SOUL_TORCH))
                .parent(soulSand)
                , consumer, "nether/soul_torch");

        AdvancementEntry soulLantern = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(Blocks.SOUL_LANTERN,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.soul_lantern.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.soul_lantern.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("soul_lantern", InventoryChangedCriterion.Conditions.items
                        (Blocks.SOUL_LANTERN))
                .parent(soulSand)
                , consumer, "nether/soul_lantern");

        AdvancementEntry blazeStar = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(ModItems.BLAZE_STAR,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.blaze_star.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.blaze_star.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("blaze_star", InventoryChangedCriterion.Conditions.items
                        (ModItems.BLAZE_STAR))
                .parent(blaze)
                , consumer, "nether/blaze_star");

        AdvancementEntry locateSoulBlazeAltar = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create().display(ModBlocks.SOUL_BLAZE_ALTAR,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.soul_blaze_altar.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.soul_blaze_altar.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("find_soul_blaze_altar",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder
                                .createStructure(ModStructureKeys.SOUL_BLAZE_ALTAR)))
                .parent(blazeStar)
                , consumer, "nether/soul_blaze_altar");

        AdvancementEntry summonSoulBlaze = ModAdvancementsProvider.buildAdvancement(
                Advancement.Builder.create().display(ModItems.SOUL_BLAZE_ROD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.summon_soul_blaze.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.summon_soul_blaze.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("summon_soul_blaze",
                        SummonedEntityCriterion.Conditions.create(EntityPredicate.Builder.create().type(ModEntities.SOUL_BLAZE_BOSS)))
                .parent(locateSoulBlazeAltar)
                , consumer, "nether/summon_soul_blaze");

        AdvancementEntry crystalSeeds = ModAdvancementsProvider.buildAdvancement(
                Advancement.Builder.create().display(ModItems.NETHER_CRYSTAL_SEEDS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.crystal_seeds.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.crystal_seeds.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("nether_crystal_seeds", InventoryChangedCriterion.Conditions.items(ModItems.NETHER_CRYSTAL_SEEDS))
                .parent(root),
                consumer, "nether/crystal_seeds");

        AdvancementEntry crystalShard = ModAdvancementsProvider.buildAdvancement(
                Advancement.Builder.create().display(ModItems.NETHER_CRYSTAL_SHARD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.crystal_shard.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.crystal_shard.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("nether_crystal_shard", InventoryChangedCriterion.Conditions.items(ModItems.NETHER_CRYSTAL_SHARD))
                .parent(crystalSeeds),
                consumer, "nether/crystal_shard");

        AdvancementEntry crystal = ModAdvancementsProvider.buildAdvancement(
                Advancement.Builder.create().display(ModItems.NETHER_CRYSTAL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.crystal.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.crystal.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("nether_crystal", InventoryChangedCriterion.Conditions.items(ModItems.NETHER_CRYSTAL))
                .parent(crystalShard),
                consumer, "nether/crystal");
    }
}