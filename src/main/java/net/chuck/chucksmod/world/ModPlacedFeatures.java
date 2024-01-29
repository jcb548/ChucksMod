package net.chuck.chucksmod.world;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> EUCALYPTUS_PLACED_KEY = registerKey("eucalyptus_placed");
    // Overworld Ores
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final RegistryKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_COPPER_ORE_PLACED_KEY = registerKey("new_copper_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_IRON_ORE_PLACED_KEY = registerKey("new_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_GOLD_ORE_PLACED_KEY = registerKey("new_gold_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_LAPIS_ORE_PLACED_KEY = registerKey("new_lapis_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_DIAMOND_ORE_PLACED_KEY = registerKey("new_diamond_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_REDSTONE_ORE_PLACED_KEY = registerKey("new_redstone_ore_placed");
    // Nether
    public static final RegistryKey<PlacedFeature> NETHER_FABIUM_ORE_PLACED_KEY =
            registerKey("nether_fabium_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_QUARTZ_PLACED_KEY = registerKey("new_quartz_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_ANCIENT_DEBRIS_PLACED_KEY =
            registerKey("new_ancient_debris_placed");
    // End
    public static final RegistryKey<PlacedFeature> END_FABIUM_ORE_PLACED_KEY =
            registerKey("end_fabium_ore_placed");
    public static final RegistryKey<PlacedFeature> END_DIRITONIUM_ORE_PLACED_KEY =
            registerKey("end_diritonium_ore_placed");
    public static final RegistryKey<PlacedFeature> END_ANCIENT_DEBRIS_PLACED_KEY =
            registerKey("end_ancient_debris_placed");
    // Trees
    public static final RegistryKey<PlacedFeature> DIRITIA_TREE_PLACED_KEY =
            registerKey("diritia_tree_placed");
    public static final RegistryKey<PlacedFeature> FABIA_TREE_PLACED_KEY =
            registerKey("fabia_tree_placed");
    // Ores
    //Fabia
    public static final RegistryKey<PlacedFeature> FABIA_COAL_ORE_PLACED_KEY =
            registerKey("fabia_coal_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_COPPER_ORE_PLACED_KEY =
            registerKey("fabia_copper_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_DIAMOND_ORE_PLACED_KEY =
            registerKey("fabia_diamond_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_DIRITONIUM_ORE_PLACED_KEY =
            registerKey("fabia_diritonium_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_EMERALD_ORE_PLACED_KEY =
            registerKey("fabia_emerald_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_FABIUM_ORE_PLACED_KEY =
            registerKey("fabia_fabium_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_GOLD_ORE_PLACED_KEY =
            registerKey("fabia_gold_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_IRON_ORE_PLACED_KEY =
            registerKey("fabia_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_LAPIS_ORE_PLACED_KEY =
            registerKey("fabia_lapis_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_REDSTONE_ORE_PLACED_KEY =
            registerKey("fabia_redstone_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_TIN_ORE_PLACED_KEY =
            registerKey("fabia_tin_ore_placed");
    public static final RegistryKey<PlacedFeature> FABIA_TITANIUM_ORE_PLACED_KEY =
            registerKey("fabia_titanium_ore_placed");

    //Diritia
    public static final RegistryKey<PlacedFeature> DIRITIA_DIRITONIUM_ORE_PLACED_KEY =
            registerKey("diritia_diritonium_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_COAL_ORE_PLACED_KEY =
            registerKey("diritia_coal_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_IRON_ORE_PLACED_KEY =
            registerKey("diritia_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_GOLD_ORE_PLACED_KEY =
            registerKey("diritia_gold_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_DIAMOND_ORE_PLACED_KEY =
            registerKey("diritia_diamond_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_LAPIS_ORE_PLACED_KEY =
            registerKey("diritia_lapis_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_REDSTONE_ORE_PLACED_KEY =
            registerKey("diritia_redstone_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_COPPER_ORE_PLACED_KEY =
            registerKey("diritia_copper_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_FABIUM_ORE_PLACED_KEY =
            registerKey("diritia_fabium_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_ANCIENT_DEBRIS_PLACED_KEY =
            registerKey("diritia_ancient_debris_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_CALCITE_VEIN_PLACED_KEY =
            registerKey("diritia_calcite_vein_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_BLACKSTONE_VEIN_PLACED_KEY =
            registerKey("diritia_blackstone_vein_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_ENDSTONE_VEIN_PLACED_KEY =
            registerKey("diritia_endstone_vein_placed");
    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // Register New Trees
        register(context, EUCALYPTUS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.EUCALYPTUS_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures
                        .createCountExtraModifier(1, 0.1f, 2), ModBlocks.EUCALYPTUS_SAPLING));
        register(context, DIRITIA_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.DIRITIA_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures
                        .createCountExtraModifier(1, 0.1f, 2), ModBlocks.DIRITIA_SAPLING));
        register(context, FABIA_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.FABIA_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures
                        .createCountExtraModifier(1, 0.1f, 2), ModBlocks.FABIA_SAPLING));

        //Register New Overworld Ores
        register(context, TIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY), ModOrePlacement.modifiersWithCount(48,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( -16), YOffset.fixed(128))));
        register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.TITANIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(28,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( -64), YOffset.fixed(16))));
        register(context, NEW_COPPER_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_COPPER_ORE_KEY), ModOrePlacement.modifiersWithCount(32,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( -16), YOffset.fixed(128))));
        register(context, NEW_IRON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_IRON_ORE_KEY), ModOrePlacement.modifiersWithCount(48,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( -64), YOffset.fixed(64))));
        register(context, NEW_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_GOLD_ORE_KEY), ModOrePlacement.modifiersWithCount(32,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( -64), YOffset.fixed(32))));
        register(context, NEW_LAPIS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_LAPIS_ORE_KEY), ModOrePlacement.modifiersWithCount(32,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( -64), YOffset.fixed(32))));
        register(context, NEW_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_DIAMOND_ORE_KEY), ModOrePlacement.modifiersWithCount(24,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( -64), YOffset.fixed(16))));
        register(context, NEW_REDSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_REDSTONE_ORE_KEY), ModOrePlacement.modifiersWithCount(96,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( -64), YOffset.fixed(128))));
        // Register New Nether Ores
        register(context, NETHER_FABIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NETHER_FABIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(32,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, NEW_QUARTZ_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_QUARTZ_ORE_KEY), ModOrePlacement.modifiersWithCount(16,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, NEW_ANCIENT_DEBRIS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_ANCIENT_DEBRIS_KEY), ModOrePlacement.modifiersWithCount(30,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        // Register End ores
        register(context, END_FABIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.END_FABIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(32,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, END_DIRITONIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.END_DIRITONIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(16,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, END_ANCIENT_DEBRIS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.END_ANCIENT_DEBRIS_KEY), ModOrePlacement.modifiersWithCount(16,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        //Register Fabia Ores
        register(context, FABIA_COAL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_COAL_ORE_KEY), ModOrePlacement.modifiersWithCount(36,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-16), YOffset.fixed(96))));
        register(context, FABIA_COPPER_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_COPPER_ORE_KEY), ModOrePlacement.modifiersWithCount(36,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-16), YOffset.fixed(96))));
        register(context, FABIA_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_DIAMOND_ORE_KEY), ModOrePlacement.modifiersWithCount(6,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(32))));
        register(context, FABIA_DIRITONIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_DIRITONIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(6,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-16))));
        register(context, FABIA_EMERALD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_EMERALD_ORE_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-16))));
        register(context, FABIA_FABIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_FABIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(18,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(16))));
        register(context, FABIA_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_GOLD_ORE_KEY), ModOrePlacement.modifiersWithCount(9,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(32))));
        register(context, FABIA_IRON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_IRON_ORE_KEY), ModOrePlacement.modifiersWithCount(24,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(96))));
        register(context, FABIA_LAPIS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_LAPIS_ORE_KEY), ModOrePlacement.modifiersWithCount(16,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(32))));
        register(context, FABIA_REDSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_REDSTONE_ORE_KEY), ModOrePlacement.modifiersWithCount(36,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(96))));
        register(context, FABIA_TIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_TIN_ORE_KEY), ModOrePlacement.modifiersWithCount(10,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(96))));
        register(context, FABIA_TITANIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FABIA_TITANIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(10,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(16))));

        //Register Diritia ores
        register(context, DIRITIA_DIRITONIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_DIRITONIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, DIRITIA_COAL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_COAL_ORE_KEY), ModOrePlacement.modifiersWithCount(30,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed( 0), YOffset.fixed(256))));
        register(context, DIRITIA_IRON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_IRON_ORE_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, DIRITIA_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_GOLD_ORE_KEY), ModOrePlacement.modifiersWithCount(8,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(72))));
        register(context, DIRITIA_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_DIAMOND_ORE_KEY), ModOrePlacement.modifiersWithCount(5,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(64))));
        register(context, DIRITIA_LAPIS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_LAPIS_ORE_KEY), ModOrePlacement.modifiersWithCount(15,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, DIRITIA_REDSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_REDSTONE_ORE_KEY), ModOrePlacement.modifiersWithCount(30,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed( 0), YOffset.fixed(96))));
        register(context, DIRITIA_COPPER_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_DIRITONIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(30,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed( 0), YOffset.fixed(256))));
        register(context, DIRITIA_FABIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_FABIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, DIRITIA_ANCIENT_DEBRIS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_ANCIENT_DEBRIS_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, DIRITIA_CALCITE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_CALCITE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
        register(context, DIRITIA_BLACKSTONE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_BLACKSTONE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
        register(context, DIRITIA_ENDSTONE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_ENDSTONE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ChucksMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}