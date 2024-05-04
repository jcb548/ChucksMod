package net.chuck.chucksmod.world;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

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
    public static final RegistryKey<PlacedFeature> NETHER_TRIAFIUM_ORE_PLACED_KEY =
            registerKey("nether_triafium_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_QUARTZ_PLACED_KEY = registerKey("new_quartz_ore_placed");
    public static final RegistryKey<PlacedFeature> NEW_ANCIENT_DEBRIS_PLACED_KEY =
            registerKey("new_ancient_debris_placed");
    public static final RegistryKey<PlacedFeature> NETHER_CRYSTAL_CROP_PLACED_KEY =
            registerKey("nether_crystal_crop");
    // End
    public static final RegistryKey<PlacedFeature> END_TRIAFIUM_ORE_PLACED_KEY =
            registerKey("end_triafium_ore_placed");
    public static final RegistryKey<PlacedFeature> END_PACSARIUM_ORE_PLACED_KEY =
            registerKey("end_pacsarium_ore_placed");
    public static final RegistryKey<PlacedFeature> END_ANCIENT_DEBRIS_PLACED_KEY =
            registerKey("end_ancient_debris_placed");
    // Trees
    public static final RegistryKey<PlacedFeature> PACSARIA_TREE_PLACED_KEY =
            registerKey("pacsaria_tree_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_TREE_PLACED_KEY =
            registerKey("triafia_tree_placed");
    // Ores
    //Triafia
    public static final RegistryKey<PlacedFeature> TRIAFIA_COAL_ORE_PLACED_KEY =
            registerKey("triafia_coal_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_COPPER_ORE_PLACED_KEY =
            registerKey("triafia_copper_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_DIAMOND_ORE_PLACED_KEY =
            registerKey("triafia_diamond_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_PACSARIUM_ORE_PLACED_KEY =
            registerKey("triafia_pacsarium_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_EMERALD_ORE_PLACED_KEY =
            registerKey("triafia_emerald_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_TRIAFIUM_ORE_PLACED_KEY =
            registerKey("triafia_triafium_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_GOLD_ORE_PLACED_KEY =
            registerKey("triafia_gold_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_IRON_ORE_PLACED_KEY =
            registerKey("triafia_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_LAPIS_ORE_PLACED_KEY =
            registerKey("triafia_lapis_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_REDSTONE_ORE_PLACED_KEY =
            registerKey("triafia_redstone_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_TIN_ORE_PLACED_KEY =
            registerKey("triafia_tin_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_TITANIUM_ORE_PLACED_KEY =
            registerKey("triafia_titanium_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_QUARTZ_ORE_PLACED_KEY =
            registerKey("triafia_quartz_ore_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_ECLOGITE_VEIN_PLACED_KEY =
            registerKey("triafia_eclogite_vein_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_TUFF_VEIN_PLACED_KEY =
            registerKey("triafia_tuff_vein_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_ECLOGITE_PILE_PLACED_KEY =
            registerKey("triafia_eclogite_pile_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_TUFF_PILE_PLACED_KEY =
            registerKey("triafia_tuff_pile_placed");
    public static final RegistryKey<PlacedFeature> TRIAFIA_PLANT_PATCH_PLACED_KEY =
            registerKey("triafia_plant_patch_placed");

    //Pacsaria
    public static final RegistryKey<PlacedFeature> PACSARIA_PACSARIUM_ORE_PLACED_KEY =
            registerKey("pacsaria_pacsarium_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_COAL_ORE_PLACED_KEY =
            registerKey("pacsaria_coal_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_IRON_ORE_PLACED_KEY =
            registerKey("pacsaria_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_GOLD_ORE_PLACED_KEY =
            registerKey("pacsaria_gold_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_DIAMOND_ORE_PLACED_KEY =
            registerKey("pacsaria_diamond_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_LAPIS_ORE_PLACED_KEY =
            registerKey("pacsaria_lapis_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_REDSTONE_ORE_PLACED_KEY =
            registerKey("pacsaria_redstone_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_COPPER_ORE_PLACED_KEY =
            registerKey("pacsaria_copper_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_TRIAFIUM_ORE_PLACED_KEY =
            registerKey("pacsaria_triafium_ore_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_ANCIENT_DEBRIS_PLACED_KEY =
            registerKey("pacsaria_ancient_debris_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_CALCITE_VEIN_PLACED_KEY =
            registerKey("pacsaria_calcite_vein_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_BLACKSTONE_VEIN_PLACED_KEY =
            registerKey("pacsaria_blackstone_vein_placed");
    public static final RegistryKey<PlacedFeature> PACSARIA_ENDSTONE_VEIN_PLACED_KEY =
            registerKey("pacsaria_endstone_vein_placed");
    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // Register New Trees
        register(context, EUCALYPTUS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.EUCALYPTUS_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures
                        .createCountExtraModifier(1, 0.1f, 2), ModBlocks.EUCALYPTUS_SAPLING));
        register(context, PACSARIA_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.PACSARIA_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures
                        .createCountExtraModifier(1, 0.1f, 2), ModBlocks.PACSARIA_SAPLING));
        register(context, TRIAFIA_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.TRIAFIA_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures
                        .createCountExtraModifier(1, 0.1f, 2), ModBlocks.TRIAFIA_SAPLING));

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
        register(context, NETHER_TRIAFIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NETHER_TRIAFIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(32,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, NEW_QUARTZ_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_QUARTZ_ORE_KEY), ModOrePlacement.modifiersWithCount(16,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, NEW_ANCIENT_DEBRIS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NEW_ANCIENT_DEBRIS_KEY), ModOrePlacement.modifiersWithCount(30,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, NETHER_CRYSTAL_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NETHER_CRYSTAL_PLANT_KEY),
                ModOrePlacement.modifiersWithRarity(5, CountMultilayerPlacementModifier.of(1)));
        // Register End ores
        register(context, END_TRIAFIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.END_TRIAFIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(32,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, END_PACSARIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.END_PACSARIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(16,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, END_ANCIENT_DEBRIS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.END_ANCIENT_DEBRIS_KEY), ModOrePlacement.modifiersWithCount(16,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        //Register Triafia Ores
        register(context, TRIAFIA_COAL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_COAL_ORE_KEY), ModOrePlacement.modifiersWithCount(36,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-16), YOffset.fixed(96))));
        register(context, TRIAFIA_COPPER_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_COPPER_ORE_KEY), ModOrePlacement.modifiersWithCount(36,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-16), YOffset.fixed(96))));
        register(context, TRIAFIA_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_DIAMOND_ORE_KEY), ModOrePlacement.modifiersWithCount(6,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(32))));
        register(context, TRIAFIA_PACSARIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_PACSARIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(6,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-16))));
        register(context, TRIAFIA_EMERALD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_EMERALD_ORE_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-16))));
        register(context, TRIAFIA_TRIAFIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_TRIAFIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(18,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(16))));
        register(context, TRIAFIA_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_GOLD_ORE_KEY), ModOrePlacement.modifiersWithCount(9,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(32))));
        register(context, TRIAFIA_IRON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_IRON_ORE_KEY), ModOrePlacement.modifiersWithCount(24,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(96))));
        register(context, TRIAFIA_LAPIS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_LAPIS_ORE_KEY), ModOrePlacement.modifiersWithCount(16,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(32))));
        register(context, TRIAFIA_REDSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_REDSTONE_ORE_KEY), ModOrePlacement.modifiersWithCount(36,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(96))));
        register(context, TRIAFIA_TIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_TIN_ORE_KEY), ModOrePlacement.modifiersWithCount(10,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(96))));
        register(context, TRIAFIA_TITANIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_TITANIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(10,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(16))));
        register(context, TRIAFIA_QUARTZ_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_QUARTZ_ORE_KEY), ModOrePlacement.modifiersWithCount(28,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(96))));
        register(context, TRIAFIA_ECLOGITE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_ECLOGITE_VEIN_KEY), ModOrePlacement.modifiersWithCount(6,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(128))));
        register(context, TRIAFIA_TUFF_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_TUFF_VEIN_KEY), ModOrePlacement.modifiersWithCount(6,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(128))));
        register(context, TRIAFIA_ECLOGITE_PILE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_ECLOGITE_PILE_KEY),
                ModOrePlacement.modifiersWithRarity(5, PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        register(context, TRIAFIA_TUFF_PILE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_TUFF_PILE_KEY),
                ModOrePlacement.modifiersWithRarity(5, PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        register(context, TRIAFIA_PLANT_PATCH_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.TRIAFIA_PLANT_PATCH_KEY),
                VegetationPlacedFeatures.modifiers(3));

        //Register Pacsaria ores
        register(context, PACSARIA_PACSARIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_PACSARIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, PACSARIA_COAL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_COAL_ORE_KEY), ModOrePlacement.modifiersWithCount(30,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed( 0), YOffset.fixed(256))));
        register(context, PACSARIA_IRON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_IRON_ORE_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, PACSARIA_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_GOLD_ORE_KEY), ModOrePlacement.modifiersWithCount(8,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(72))));
        register(context, PACSARIA_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_DIAMOND_ORE_KEY), ModOrePlacement.modifiersWithCount(5,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(64))));
        register(context, PACSARIA_LAPIS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_LAPIS_ORE_KEY), ModOrePlacement.modifiersWithCount(15,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, PACSARIA_REDSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_REDSTONE_ORE_KEY), ModOrePlacement.modifiersWithCount(30,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed( 0), YOffset.fixed(96))));
        register(context, PACSARIA_COPPER_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_PACSARIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(30,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed( 0), YOffset.fixed(256))));
        register(context, PACSARIA_TRIAFIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_TRIAFIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, PACSARIA_ANCIENT_DEBRIS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_ANCIENT_DEBRIS_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, PACSARIA_CALCITE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_CALCITE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
        register(context, PACSARIA_BLACKSTONE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_BLACKSTONE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
        register(context, PACSARIA_ENDSTONE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.PACSARIA_ENDSTONE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
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