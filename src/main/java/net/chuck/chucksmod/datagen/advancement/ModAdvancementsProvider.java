package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.item.enchantment.ModEnchantments;
import net.chuck.chucksmod.world.gen.ModStructureKeys;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.AdvancementRequirements.CriterionMerger;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureKeys;

import java.util.Optional;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public ModAdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        OverworldAdvancements.generateAdvancements(consumer);
        EnchantingAdvancements.generateAdvancements(consumer);
        MachineAdvancements.generateAdvancements(consumer);
        Bosses.generateAdvancements(consumer);
        NetherAdvancements.generateAdvancements(consumer);
    }
}
