package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.ChangedDimensionCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.function.Consumer;

public class Bosses {
    public static void generateAdvancements(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry root = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.TITANIUM_SWORD, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".bosses.root.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".bosses.root.desc"), // The description
                        new Identifier("textures/block/end_stone.png"), // Background image used
                        AdvancementFrame.TASK, true, true, false)
                .criterion("got_sword", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS).build())), consumer, "bosses/root");

        AdvancementEntry nether = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.NETHERRACK, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".bosses.nether.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".bosses.nether.desc"), // The description
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enter_nether", ChangedDimensionCriterion.Conditions.to(World.NETHER))
                .parent(root), consumer, "bosses/nether");

        AdvancementEntry wither = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(Items.NETHER_STAR, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".bosses.wither.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".bosses.wither.desc"), // The description
                        null, AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("killed_wither", OnKilledCriterion.Conditions.createPlayerKilledEntity(
                        EntityPredicate.Builder.create().type(EntityType.WITHER)))
                        .parent(nether)
                        .rewards(AdvancementRewards.Builder.loot(new Identifier("entities/wither"))),
                consumer, "bosses/wither");

        AdvancementEntry soul_blaze = ModAdvancementsProvider.buildAdvancement(Advancement.Builder.create()
                .display(ModItems.SOUL_BLAZE_ROD, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".bosses.soul_blaze.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".bosses.soul_blaze.desc"), // The description
                        null, AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("killed_soul_blaze", OnKilledCriterion.Conditions.createPlayerKilledEntity(
                        EntityPredicate.Builder.create().type(ModEntities.SOUL_BLAZE_BOSS)))
                        .parent(nether)
                        .rewards(AdvancementRewards.Builder.loot(new Identifier(ChucksMod.MOD_ID,
                                "entities/soul_blaze"))), consumer, "bosses/soul_blaze");
    }
}
