package net.chuck.pigsnstuff.world;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> EUCALYPTUS_PLACED_KEY = registerKey("eucalyptus_placed");
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_FABIUM_ORE_PLACED_KEY =
            registerKey("nether_fabium_ore_placed");
    public static final RegistryKey<PlacedFeature> END_FABIUM_ORE_PLACED_KEY =
            registerKey("end_fabium_ore_placed");
    public static final RegistryKey<PlacedFeature> END_DIRITONIUM_ORE_PLACED_KEY =
            registerKey("end_diritonium_ore_placed");
    // Generation for Diritia Islands
    // Trees
    public static final RegistryKey<PlacedFeature> DIRITIA_TREE_PLACED_KEY =
            registerKey("diritia_tree_placed");
    /*public static final RegistryKey<PlacedFeature> DIRITIA_CHERRY_TREE_PLACED_KEY =
            registerKey("diritia_cherry_tree_placed");*/
    // Ores
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
    public static final RegistryKey<PlacedFeature> DIRITIA_CALCITE_VEIN_PLACED_KEY =
            registerKey("diritia_calcite_vein_placed");
    public static final RegistryKey<PlacedFeature> DIRITIA_SLATED_VEIN_PLACED_KEY =
            registerKey("diritia_slated_vein_placed");
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
        /*register(context, DIRITIA_CHERRY_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.DIRITIA_CHERRY_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures
                        .createCountExtraModifier(1, 0.1f, 1), Blocks.CHERRY_SAPLING));*/

        //Register New Overworld Ores
        register(context, TIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY), ModOrePlacement.modifiersWithCount(12,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed( -128), YOffset.fixed(16))));
        // Register New Nether Ores
        register(context, NETHER_FABIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.NETHER_FABIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(30,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        // Register End ores
        register(context, END_FABIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.END_FABIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        register(context, END_DIRITONIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.END_DIRITONIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(10,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
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
        register(context, DIRITIA_CALCITE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_CALCITE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
        register(context, DIRITIA_SLATED_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_SLATED_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
        register(context, DIRITIA_BLACKSTONE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_BLACKSTONE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
        register(context, DIRITIA_ENDSTONE_VEIN_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITIA_ENDSTONE_VEIN_KEY), ModOrePlacement.modifiersWithCount(4,
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(256))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PigsNStuff.MOD_ID, name));
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