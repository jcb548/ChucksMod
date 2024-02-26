package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureKeys;

import java.util.function.Consumer;

public class NetherAdvancements {
    public static void generateAdvancements(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry root = Advancement.Builder.create()
                .display(Items.NETHERRACK, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.root.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.root.desc"), // The description
                        new Identifier("minecraft", "textures/block/nether_bricks.png"), // Background image used
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("enter_nether", ChangedDimensionCriterion.Conditions.to(World.NETHER))
                .build(consumer, ChucksMod.MOD_ID + "/nether/root");

        AdvancementEntry rawTriafium = Advancement.Builder.create().display(ModItems.RAW_TRIAFIUM,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.raw_triafium.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.raw_triafium.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("raw_triafium", InventoryChangedCriterion.Conditions.items(ModItems.RAW_TRIAFIUM))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/nether/raw_triafium");

        AdvancementEntry ancientDebris = Advancement.Builder.create().display(Blocks.ANCIENT_DEBRIS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.ancient_debris.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.ancient_debris.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("ancient_debris", InventoryChangedCriterion.Conditions.items(Blocks.ANCIENT_DEBRIS))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/nether/ancient_debris");

        AdvancementEntry quartz = Advancement.Builder.create().display(Items.QUARTZ,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.quartz.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.quartz.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("quartz", InventoryChangedCriterion.Conditions.items(Items.QUARTZ))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/nether/quartz");

        AdvancementEntry zombifiedPiglin = Advancement.Builder.create().display(Items.GOLD_NUGGET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.zombified_piglin.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.zombified_piglin.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_zombified_piglin",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.ZOMBIFIED_PIGLIN)))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/nether/zombified_piglin");
        
        AdvancementEntry enterFortress = Advancement.Builder.create().display(Blocks.NETHER_BRICKS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.enter_fortress.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".nether.enter_fortress.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enter_fortress",
                        TickCriterion.Conditions.createLocation(LocationPredicate.Builder
                                .createStructure(StructureKeys.FORTRESS)))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/nether/fortress");

        AdvancementEntry blaze = Advancement.Builder.create().display(Items.BLAZE_ROD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.blaze.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.blaze.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_blaze",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create()
                                .type(EntityType.BLAZE)))
                .parent(enterFortress)
                .build(consumer, ChucksMod.MOD_ID + "/nether/blaze");

        AdvancementEntry blazePowder = Advancement.Builder.create().display(Items.BLAZE_POWDER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.blaze_powder.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.blaze_powder.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("blaze_powder",
                        InventoryChangedCriterion.Conditions.items(Items.BLAZE_POWDER))
                .parent(blaze)
                .build(consumer, ChucksMod.MOD_ID + "/nether/blaze_powder");

        AdvancementEntry wither_skeleton = Advancement.Builder.create().display(Blocks.WITHER_SKELETON_SKULL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wither_skeleton.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".overworld.wither_skeleton.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("killed_wither_skeleton",
                        OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create()
                                .type(EntityType.WITHER_SKELETON)))
                .parent(enterFortress)
                .build(consumer, ChucksMod.MOD_ID + "/nether/wither_skeleton");
    }
}