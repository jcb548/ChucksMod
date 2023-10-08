package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.item.ModItemTags;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Items;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public ModAdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement root = Advancement.Builder.create()
                .display(Items.OAK_LOG, // The display icon
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".root.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".root.desc"), // The description
                        new Identifier(PigsNStuff.MOD_ID, "textures/block/eucalyptus_planks.png"), // Background image used
                        AdvancementFrame.TASK, true, true, false
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_logs", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.LOGS).build()))
                .build(consumer, PigsNStuff.MOD_ID + "/root");

        Advancement craftingTable = Advancement.Builder.create()
                .display(Items.CRAFTING_TABLE,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".crafting_table.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".crafting_table.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("crafting_table", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
                .parent(root)
                .build(consumer,PigsNStuff.MOD_ID + "/crafting_table");
        Advancement woodPickaxe = Advancement.Builder.create()
                .display(Items.WOODEN_PICKAXE,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".wooden_pickaxe.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".wooden_pickaxe.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_wooden_pick", InventoryChangedCriterion.Conditions.items(Items.WOODEN_PICKAXE))
                .parent(craftingTable)
                .build(consumer,PigsNStuff.MOD_ID + "/wooden_pickaxe");

        Advancement cobble = Advancement.Builder.create()
                .display(Items.COBBLESTONE,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".cobble.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".cobble.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_cobble", InventoryChangedCriterion.Conditions.items(Items.COBBLESTONE))
                .parent(woodPickaxe)
                .build(consumer,PigsNStuff.MOD_ID + "/cobble");

        Advancement stoneTools = Advancement.Builder.create()
                .display(Items.STONE_AXE,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".stone_tools.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".stone_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_stone_tools", InventoryChangedCriterion.Conditions.items(Items.STONE_SWORD,
                        Items.STONE_PICKAXE, Items.STONE_AXE, Items.STONE_SHOVEL, Items.STONE_HOE))
                .parent(cobble)
                .build(consumer,PigsNStuff.MOD_ID + "/stone_tools");

        Advancement furnace = Advancement.Builder.create()
                .display(Items.FURNACE,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".furnace.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".furnace.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_furnace", InventoryChangedCriterion.Conditions.items(Items.FURNACE))
                .parent(cobble)
                .build(consumer,PigsNStuff.MOD_ID + "/furnace");

        Advancement coal = Advancement.Builder.create()
                .display(Items.COAL,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".coal.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".coal.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_coal", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.COALS).build()))
                .parent(furnace)
                .build(consumer,PigsNStuff.MOD_ID + "/coal");

        Advancement meat = Advancement.Builder.create()
                .display(Items.PORKCHOP,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".meat.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".meat.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_meat", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.RAW_MEAT).build()))
                .parent(stoneTools)
                .build(consumer,PigsNStuff.MOD_ID + "/meat");

        Advancement cookedMeat = Advancement.Builder.create()
                .display(Items.COOKED_PORKCHOP,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".cooked_meat.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".cooked_meat.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("cook_meat", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.COOKED_MEAT).build()))
                .parent(meat)
                .build(consumer,PigsNStuff.MOD_ID + "/cooked_meat");

        Advancement seeds = Advancement.Builder.create()
                .display(Items.WHEAT_SEEDS,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".seeds.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".seeds.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_seeds", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.SEEDS).build()))
                .parent(stoneTools)
                .build(consumer,PigsNStuff.MOD_ID + "/seeds");

        Advancement farmland = Advancement.Builder.create().display(Items.FARMLAND,
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".farmland.title"),
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".farmland.desc"),
                null, AdvancementFrame.TASK, true, true, false)
                .criterion("create_farmland", ItemCriterion.Conditions.createItemUsedOnBlock(
                        LocationPredicate.Builder.create().block(BlockPredicate.Builder.create()
                                .blocks(Blocks.FARMLAND).build()),
                        ItemPredicate.Builder.create().tag(ItemTags.HOES)))
                .parent(seeds)
                .build(consumer, PigsNStuff.MOD_ID + "/farmland");

        Advancement plant_crop = Advancement.Builder.create().display(Blocks.WHEAT,
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".plant_seeds.title"),
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".plant_seeds.desc"),
                null, AdvancementFrame.TASK, true, true, false)
                .criteriaMerger(CriterionMerger.OR)
                .criterion("plant_wheat", ItemCriterion.Conditions.createPlacedBlock(Blocks.WHEAT))
                .criterion("plant_beetroot", ItemCriterion.Conditions.createPlacedBlock(Blocks.BEETROOTS))
                .parent(farmland)
                .build(consumer, PigsNStuff.MOD_ID + "/plant_crop");

        Advancement wheat = Advancement.Builder.create().display(Items.WHEAT,
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".wheat.title"),
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".wheat.desc"),
                null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_wheat", InventoryChangedCriterion.Conditions.items(Items.WHEAT))
                .parent(plant_crop)
                .build(consumer, PigsNStuff.MOD_ID + "/wheat");

        Advancement bread = Advancement.Builder.create().display(Items.BREAD,
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".bread.title"),
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".bread.desc"),
                null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_bread", InventoryChangedCriterion.Conditions.items(Items.BREAD))
                .parent(wheat)
                .build(consumer, PigsNStuff.MOD_ID + "/bread");

        Advancement raw_iron = Advancement.Builder.create().display(Items.RAW_IRON,
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".raw_iron.title"),
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".raw_iron.desc"),
                null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_raw_iron", InventoryChangedCriterion.Conditions.items(Items.RAW_IRON))
                .parent(stoneTools)
                .build(consumer, PigsNStuff.MOD_ID + "/raw_iron");

        Advancement iron = Advancement.Builder.create().display(Items.IRON_INGOT,
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".iron.title"),
                Text.translatable("advancements." + PigsNStuff.MOD_ID + ".iron.desc"),
                null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_iron", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .parent(raw_iron)
                .build(consumer, PigsNStuff.MOD_ID + "/iron");

        Advancement ironTools = Advancement.Builder.create()
                .display(Items.IRON_PICKAXE,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".iron_tools.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".iron_tools.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_stone_tools", InventoryChangedCriterion.Conditions.items(Items.IRON_SWORD,
                        Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE))
                .parent(iron)
                .build(consumer,PigsNStuff.MOD_ID + "/iron_tools");

        Advancement ironArmor = Advancement.Builder.create()
                .display(Items.IRON_CHESTPLATE,
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".iron_armor.title"),
                        Text.translatable("advancements." + PigsNStuff.MOD_ID + ".iron_armor.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("get_stone_tools", InventoryChangedCriterion.Conditions.items(Items.IRON_HELMET,
                    Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS))
                .parent(iron)
                .build(consumer,PigsNStuff.MOD_ID + "/iron_armor");
    }
}
