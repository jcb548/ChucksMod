package net.chuck.chucksmod.world;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import java.util.List;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> EUCALYPTUS_KEY = registerKey("eucalyptus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    /* public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_CHERRY_TREE_KEY =
            registerKey("diritia_cherry_tree");*/
    // Make Vanilla ores easier to find for faster progression
    // Overworld
    public static final RegistryKey<ConfiguredFeature<?, ?>> NEW_COPPER_ORE_KEY =
            registerKey("new_copper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NEW_IRON_ORE_KEY =
            registerKey("new_iron_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NEW_GOLD_ORE_KEY =
            registerKey("new_gold_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NEW_LAPIS_ORE_KEY =
            registerKey("new_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NEW_DIAMOND_ORE_KEY =
            registerKey("new_diamond_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NEW_REDSTONE_ORE_KEY =
            registerKey("new_redstone_ore");
    // Nether
    public static final RegistryKey<ConfiguredFeature <?, ?>> NEW_QUARTZ_ORE_KEY =
            registerKey("new_quartz_ore");
    public static final RegistryKey<ConfiguredFeature <?, ?>> NEW_ANCIENT_DEBRIS_KEY =
            registerKey("new_ancient_debris");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_FABIUM_ORE_KEY =
            registerKey("nether_fabium_ore");
    // End
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_FABIUM_ORE_KEY =
            registerKey("end_fabium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_DIRITONIUM_ORE_KEY =
            registerKey("end_diritonium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_ANCIENT_DEBRIS_KEY =
            registerKey("end_ancient_debris");
    // Generation for Diritia Islands
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_DIRITONIUM_ORE_KEY =
            registerKey("diritia_diritonium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_FABIUM_ORE_KEY =
            registerKey("diritia_fabium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_ANCIENT_DEBRIS_KEY =
            registerKey("diritia_ancient_debris");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_COAL_ORE_KEY =
            registerKey("diritia_coal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_IRON_ORE_KEY =
            registerKey("diritia_iron_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_GOLD_ORE_KEY =
            registerKey("diritia_gold_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_DIAMOND_ORE_KEY =
            registerKey("diritia_diamond_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_REDSTONE_ORE_KEY =
            registerKey("diritia_redstone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_LAPIS_ORE_KEY =
            registerKey("diritia_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_COPPER_ORE_KEY =
            registerKey("diritia_copper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_CALCITE_VEIN_KEY =
            registerKey("diritia_calcite_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_BLACKSTONE_VEIN_KEY =
            registerKey("diritia_blackstone_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_ENDSTONE_VEIN_KEY =
            registerKey("diritia_endstone_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITIA_TREE_KEY =
            registerKey("diritia_tree");


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ChucksMod.MOD_ID, name));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        // Extra gen of overworld ores
        List<OreFeatureConfig.Target> newCopperOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                Blocks.COPPER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                Blocks.DEEPSLATE_COPPER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> newIronOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                Blocks.IRON_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                Blocks.DEEPSLATE_IRON_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> newGoldOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                Blocks.GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                Blocks.DEEPSLATE_GOLD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> newLapisOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                Blocks.LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                Blocks.DEEPSLATE_LAPIS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> newDiamondOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                Blocks.DIAMOND_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                Blocks.DEEPSLATE_DIAMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> newRedstoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                Blocks.REDSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                Blocks.DEEPSLATE_REDSTONE_ORE.getDefaultState()));

        // Increase gen of nether ores
        List<OreFeatureConfig.Target> newQuartzOres =
                List.of(OreFeatureConfig.createTarget(netherrackReplaceables,
                                Blocks.NETHER_QUARTZ_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> newAncientDebris =
                List.of(OreFeatureConfig.createTarget(netherrackReplaceables,
                                Blocks.ANCIENT_DEBRIS.getDefaultState()));
        // New Overworld Ores
        List<OreFeatureConfig.Target> overworldTinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                ModBlocks.TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                ModBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));

        // New Nether Ores
        List<OreFeatureConfig.Target> netherFabiumOre =
                List.of(OreFeatureConfig.createTarget(netherrackReplaceables,
                        ModBlocks.NETHER_FABIUM_ORE.getDefaultState()));

        //End Ores
        List<OreFeatureConfig.Target> endFabiumOre =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables,
                        ModBlocks.END_STONE_FABIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endDiritoniumOre =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables,
                        ModBlocks.END_STONE_DIRITONIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endAncientDebris =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables,
                        Blocks.ANCIENT_DEBRIS.getDefaultState()));
        //Diritia Ores
        List<OreFeatureConfig.Target> diritiaDiritoniumOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        ModBlocks.DEEPSLATE_DIRITONIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaFabiumOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        ModBlocks.DEEPSLATE_FABIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaAncientDebris =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.ANCIENT_DEBRIS.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaCoalOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_COAL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaIronOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_IRON_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaGoldOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_GOLD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaDiamondOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_DIAMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaCopperOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_COPPER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaRedstoneOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_REDSTONE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaLapisOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_LAPIS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaCalcite =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.CALCITE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaBlackstoneVein =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.BLACKSTONE.getDefaultState()));
        List<OreFeatureConfig.Target> diritiaEndstoneVein =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.END_STONE.getDefaultState()));

        // Register New Trees
        register(context, EUCALYPTUS_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.EUCALYPTUS_LOG),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.of(ModBlocks.EUCALYPTUS_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 1, 1)).build());

        register(context, DIRITIA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DIRITIA_LOG),
                new ForkingTrunkPlacer(7, 3, 3),
                BlockStateProvider.of(ModBlocks.DIRITIA_LEAVES),
                new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1,1,1)).build());

        /*register(context, DIRITIA_CHERRY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.CHERRY_LOG),
                new CherryTrunkPlacer(7, 3, 3, ConstantIntProvider.create(2),
                        UniformIntProvider.create(3, 5), UniformIntProvider.create(1, 2), ConstantIntProvider.create(1)),
                BlockStateProvider.of(Blocks.CHERRY_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(-1),
                        ConstantIntProvider.create(4), 0.25f, 0.25f,
                        0.16666667f, 0.33333f),
                new TwoLayersFeatureSize(1, 1, 1)).build());*/

        // Register Overworld Ores
        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 9));
        register(context, NEW_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(newCopperOres, 12));
        register(context, NEW_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(newIronOres, 9));
        register(context, NEW_GOLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(newGoldOres, 9));
        register(context, NEW_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(newLapisOres, 7));
        register(context, NEW_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(newDiamondOres, 8));
        register(context, NEW_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(newRedstoneOres, 8));
        // Register new Nether Ores
        register(context, NETHER_FABIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherFabiumOre, 6));
        register(context, NEW_QUARTZ_ORE_KEY, Feature.ORE, new OreFeatureConfig(newQuartzOres, 14));
        register(context, NEW_ANCIENT_DEBRIS_KEY, Feature.ORE, new OreFeatureConfig(newAncientDebris, 8));
        // Register End Ores
        register(context, END_FABIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endFabiumOre, 8));
        register(context, END_DIRITONIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endDiritoniumOre, 6));
        register(context, END_ANCIENT_DEBRIS_KEY, Feature.ORE, new OreFeatureConfig(endAncientDebris, 6));
        // Register Diritia Ores
        register(context, DIRITIA_DIRITONIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaDiritoniumOre, 12));
        register(context, DIRITIA_FABIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaFabiumOre, 12));
        register(context, DIRITIA_ANCIENT_DEBRIS_KEY, Feature.ORE, new OreFeatureConfig(diritiaAncientDebris, 10));
        register(context, DIRITIA_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaCoalOre, 16));
        register(context, DIRITIA_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaIronOre, 9));
        register(context, DIRITIA_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaDiamondOre, 8));
        register(context, DIRITIA_GOLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaGoldOre, 9));
        register(context, DIRITIA_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaRedstoneOre, 9));
        register(context, DIRITIA_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaLapisOre, 6));
        register(context, DIRITIA_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(diritiaCopperOre, 16));
        register(context, DIRITIA_CALCITE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(diritiaCalcite, 64));
        register(context, DIRITIA_BLACKSTONE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(diritiaBlackstoneVein, 64));
        register(context, DIRITIA_ENDSTONE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(diritiaEndstoneVein, 64));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void
        register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
                 F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
