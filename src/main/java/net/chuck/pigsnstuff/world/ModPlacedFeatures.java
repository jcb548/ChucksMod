package net.chuck.pigsnstuff.world;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.ModBlocks;
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
    public static final RegistryKey<PlacedFeature> FABIUM_ORE_PLACED_KEY = registerKey("fabium_ore_placed");
    public static final RegistryKey<PlacedFeature> DIRITONIUM_ORE_PLACED_KEY = registerKey("diritonium_ore_placed");
    public static final RegistryKey<PlacedFeature> LIGHT_PILE_PLACED_KEY = registerKey("light_pile_placed");
    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, EUCALYPTUS_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.EUCALYPTUS_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures
                        .createCountExtraModifier(1, 0.1f, 2), ModBlocks.EUCALYPTUS_SAPLING));
        register(context, TIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY), ModOrePlacement.modifiersWithCount(12,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed( -128), YOffset.fixed(16))));
        register(context, FABIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                        .getOrThrow(ModConfiguredFeatures.FABIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(30,
                        HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));
        /*register(context, DIRITONIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.DIRITONIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(20,
                HeightRangePlacementModifier.uniform(YOffset.fixed( 0), YOffset.fixed(128))));*/
        register(context, LIGHT_PILE_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.LIGHT_PILE_KEY));
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