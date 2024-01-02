package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.item.enchantment.ModEnchantments;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.EnchantedItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Consumer;

public class EnchantingAdvancements {
    public static void generateAdvancements(Consumer<AdvancementEntry> consumer){
        AdvancementEntry root = Advancement.Builder.create()
                .display(Blocks.ENCHANTING_TABLE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchanting_table.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchanting_table.desc"),
                        new Identifier("textures/block/lapis_block.png") // Background image used
                        , AdvancementFrame.TASK, true, true, false)
                .criterion("get_enchanting_table", InventoryChangedCriterion.Conditions.items
                        (Blocks.ENCHANTING_TABLE))
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/enchanting_table");

        AdvancementEntry enchantItem = Advancement.Builder.create().display(Items.ENCHANTED_BOOK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_item.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_item.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enchant_item", EnchantedItemCriterion.Conditions.any())
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/enchant_item");

        AdvancementEntry unbreaking = Advancement.Builder.create().display(Items.DIAMOND,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.unbreaking.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.unbreaking.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("unbreaking", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.ENCHANTABLES)
                        .enchantment(new EnchantmentPredicate(Enchantments.UNBREAKING,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantItem)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/unbreaking");

        AdvancementEntry enchantSword = Advancement.Builder.create().display(Items.GOLDEN_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_sword.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_sword.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enchant_sword",
                        Criteria.ENCHANTED_ITEM.create(
                                new EnchantedItemCriterion.Conditions(Optional.empty(),
                                        Optional.of(ItemPredicate.Builder.create()
                                                .tag(ItemTags.SWORDS).build()),
                                        NumberRange.IntRange.ANY)))
                .parent(enchantItem)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/enchant_sword");

        AdvancementEntry sharpness = Advancement.Builder.create().display(Items.DIAMOND_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.sharpness.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.sharpness.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("sharpness", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS)
                        .enchantment(new EnchantmentPredicate(Enchantments.SHARPNESS,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantSword)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/sharpness");

        AdvancementEntry smite = Advancement.Builder.create().display(Items.IRON_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.smite.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.smite.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("smite", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS)
                        .enchantment(new EnchantmentPredicate(Enchantments.SMITE,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantSword)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/smite");

        AdvancementEntry bane_of_arthropods = Advancement.Builder.create().display(Items.STONE_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.bane_of_arthropods.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.bane_of_arthropods.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("bane_of_arthropods", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS)
                        .enchantment(new EnchantmentPredicate(Enchantments.BANE_OF_ARTHROPODS,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantSword)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/bane_of_arthropods");

        AdvancementEntry looting = Advancement.Builder.create().display(ModItems.TITANIUM_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.looting.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.looting.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("looting", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS)
                        .enchantment(new EnchantmentPredicate(Enchantments.LOOTING,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantSword)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/looting");

        AdvancementEntry sweeping = Advancement.Builder.create().display(ModItems.BRONZE_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.sweeping.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.sweeping.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("sweeping", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS)
                        .enchantment(new EnchantmentPredicate(Enchantments.SWEEPING,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantSword)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/sweeping");

        AdvancementEntry fire_aspect = Advancement.Builder.create().display(Items.NETHERITE_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.fire_aspect.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.fire_aspect.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("fire_aspect", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS)
                        .enchantment(new EnchantmentPredicate(Enchantments.FIRE_ASPECT,
                                NumberRange.IntRange.ANY)).build()))
                .parent(enchantSword)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/fire_aspect");

        AdvancementEntry knockback = Advancement.Builder.create().display(Items.WOODEN_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.knockback.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.knockback.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("knockback", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS)
                        .enchantment(new EnchantmentPredicate(Enchantments.KNOCKBACK,
                                NumberRange.IntRange.ANY)).build()))
                .parent(enchantSword)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/knockback");

        AdvancementEntry alacrity = Advancement.Builder.create().display(ModItems.FABIUM_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.alacrity.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.alacrity.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("alacrity", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.SWORDS)
                        .enchantment(new EnchantmentPredicate(ModEnchantments.ALACRITY,
                                NumberRange.IntRange.ANY)).build()))
                .parent(enchantSword)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/alacrity");

        AdvancementEntry enchantTool = Advancement.Builder.create().display(Items.GOLDEN_SHOVEL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_tool.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_tool.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enchant_tool",
                        Criteria.ENCHANTED_ITEM.create(
                                new EnchantedItemCriterion.Conditions(Optional.empty(),
                                        Optional.of(ItemPredicate.Builder.create()
                                                .tag(ItemTags.TOOLS).build()),
                                        NumberRange.IntRange.ANY)))
                .parent(enchantItem)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/enchant_tool");

        AdvancementEntry efficiency = Advancement.Builder.create().display(Items.GOLDEN_PICKAXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.efficiency.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.efficiency.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("efficiency", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.TOOLS)
                        .enchantment(new EnchantmentPredicate(Enchantments.EFFICIENCY,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantTool)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/efficiency");

        AdvancementEntry silk = Advancement.Builder.create().display(Items.DIAMOND_HOE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.silk.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.silk.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("silk", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.TOOLS)
                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH,
                                NumberRange.IntRange.ANY)).build()))
                .parent(enchantTool)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/silk");

        AdvancementEntry fortune = Advancement.Builder.create().display(Items.DIAMOND_PICKAXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.fortune.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.fortune.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("fortune", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.TOOLS)
                        .enchantment(new EnchantmentPredicate(Enchantments.FORTUNE,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantTool)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/fortune");

        AdvancementEntry enchantArmor = Advancement.Builder.create().display(Items.GOLDEN_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_armor.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_armor.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enchant_armor",
                        Criteria.ENCHANTED_ITEM.create(
                                new EnchantedItemCriterion.Conditions(Optional.empty(),
                                        Optional.of(ItemPredicate.Builder.create()
                                                .tag(ItemTags.TRIMMABLE_ARMOR).build()),
                                        NumberRange.IntRange.ANY)))
                .parent(enchantItem)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/enchant_armor");

        AdvancementEntry protection = Advancement.Builder.create().display(Items.DIAMOND_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.protection.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.protection.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("protection", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.TRIMMABLE_ARMOR)
                        .enchantment(new EnchantmentPredicate(Enchantments.PROTECTION,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantArmor)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/protection");

        AdvancementEntry fire_protection = Advancement.Builder.create().display(Items.NETHERITE_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.fire_protection.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.fire_protection.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("fire_protection", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.TRIMMABLE_ARMOR)
                        .enchantment(new EnchantmentPredicate(Enchantments.FIRE_PROTECTION,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantArmor)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/fire_protection");

        AdvancementEntry blast_protection = Advancement.Builder.create().display(Items.IRON_CHESTPLATE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.blast_protection.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.blast_protection.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("blast_protection", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.TRIMMABLE_ARMOR)
                        .enchantment(new EnchantmentPredicate(Enchantments.BLAST_PROTECTION,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantArmor)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/blast_protection");

        AdvancementEntry thorns = Advancement.Builder.create().display(Items.CACTUS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.thorns.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.thorns.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("thorns", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ItemTags.TRIMMABLE_ARMOR)
                        .enchantment(new EnchantmentPredicate(Enchantments.THORNS,
                                NumberRange.IntRange.atLeast(2))).build()))
                .parent(enchantArmor)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/thorns");

        AdvancementEntry enchantHelmet = Advancement.Builder.create().display(Items.GOLDEN_HELMET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_helmet.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_helmet.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enchant_helmet",
                        Criteria.ENCHANTED_ITEM.create(
                                new EnchantedItemCriterion.Conditions(Optional.empty(),
                                        Optional.of(ItemPredicate.Builder.create()
                                                .tag(ModItemTags.HELMETS).build()),
                                        NumberRange.IntRange.ANY)))
                .parent(enchantArmor)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/enchant_helmet");

        AdvancementEntry respiration = Advancement.Builder.create().display(Items.TURTLE_HELMET,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.respiration.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.respiration.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("respiration", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.HELMETS)
                        .enchantment(new EnchantmentPredicate(Enchantments.RESPIRATION,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantHelmet)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/respiration");

        AdvancementEntry aqua_affinity = Advancement.Builder.create().display(Items.IRON_PICKAXE,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.aqua_affinity.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.aqua_affinity.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("aqua_affinity", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.HELMETS)
                        .enchantment(new EnchantmentPredicate(Enchantments.AQUA_AFFINITY,
                                NumberRange.IntRange.ANY)).build()))
                .parent(enchantHelmet)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/aqua_affinity");

        AdvancementEntry enchantBoots = Advancement.Builder.create().display(Items.GOLDEN_BOOTS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_boots.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_boots.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enchant_boots",
                        Criteria.ENCHANTED_ITEM.create(
                                new EnchantedItemCriterion.Conditions(Optional.empty(),
                                        Optional.of(ItemPredicate.Builder.create()
                                                .tag(ModItemTags.BOOTS).build()),
                                        NumberRange.IntRange.ANY)))
                .parent(enchantArmor)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/enchant_boots");

        AdvancementEntry feather_falling = Advancement.Builder.create().display(Items.FEATHER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.feather_falling.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.feather_falling.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("feather_falling", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.BOOTS)
                        .enchantment(new EnchantmentPredicate(Enchantments.FEATHER_FALLING,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantBoots)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/feather_falling");

        AdvancementEntry depth_strider = Advancement.Builder.create().display(Items.IRON_BOOTS,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.depth_strider.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.depth_strider.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("depth_strider", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.BOOTS)
                        .enchantment(new EnchantmentPredicate(Enchantments.DEPTH_STRIDER,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantBoots)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/depth_strider");

        AdvancementEntry enchantBow = Advancement.Builder.create().display(Items.BOW,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_bow.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.enchant_bow.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enchant_bow",
                        Criteria.ENCHANTED_ITEM.create(
                                new EnchantedItemCriterion.Conditions(Optional.empty(),
                                        Optional.of(ItemPredicate.Builder.create().items(Items.BOW).build()),
                                        NumberRange.IntRange.ANY)))
                .parent(enchantItem)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/enchant_bow");

        AdvancementEntry power = Advancement.Builder.create().display(Items.ARROW,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.power.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.power.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("power", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .items(Items.BOW)
                        .enchantment(new EnchantmentPredicate(Enchantments.POWER,
                                NumberRange.IntRange.atLeast(3))).build()))
                .parent(enchantBow)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/power");

        AdvancementEntry infinity = Advancement.Builder.create().display(Items.SKELETON_SKULL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.infinity.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.infinity.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("infinity", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .items(Items.BOW)
                        .enchantment(new EnchantmentPredicate(Enchantments.INFINITY,
                                NumberRange.IntRange.ANY)).build()))
                .parent(enchantBow)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/infinity");

        AdvancementEntry flame = Advancement.Builder.create().display(Items.BLAZE_POWDER,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.flame.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.flame.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("flame", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .items(Items.BOW)
                        .enchantment(new EnchantmentPredicate(Enchantments.FLAME,
                                NumberRange.IntRange.ANY)).build()))
                .parent(enchantBow)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/flame");

        AdvancementEntry punch = Advancement.Builder.create().display(Items.WOODEN_SWORD,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.punch.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.punch.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("punch", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .items(Items.BOW)
                        .enchantment(new EnchantmentPredicate(Enchantments.PUNCH,
                                NumberRange.IntRange.ANY)).build()))
                .parent(enchantBow)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/punch");

        AdvancementEntry bookshelf = Advancement.Builder.create().display(Blocks.BOOKSHELF,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.bookshelf.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.bookshelf.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("enchant_item", InventoryChangedCriterion.Conditions.items(Blocks.BOOKSHELF))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/bookshelf");
        AdvancementEntry anvil = Advancement.Builder.create()
                .display(Items.ANVIL,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.anvil.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.anvil.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("anvil", InventoryChangedCriterion.Conditions.items(Items.ANVIL))
                .parent(root)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/anvil");

        AdvancementEntry mending = Advancement.Builder.create().display(Items.MOSS_BLOCK,
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.mending.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".enchanting.mending.desc"),
                        null, AdvancementFrame.TASK, true, true, false)
                .criterion("mending", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create()
                        .tag(ModItemTags.ENCHANTABLES)
                        .enchantment(new EnchantmentPredicate(Enchantments.MENDING,
                                NumberRange.IntRange.ANY)).build()))
                .parent(anvil)
                .build(consumer, ChucksMod.MOD_ID + "/enchanting/mending");
    }
}
