package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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
                        .tag(ItemTags.SWORDS).build()))
                , consumer, "bosses/root");
    }
}
