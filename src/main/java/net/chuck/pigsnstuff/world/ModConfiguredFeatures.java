package net.chuck.pigsnstuff.world;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.block.custom.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> EUCALYPTUS_KEY = registerKey("eucalyptus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FABIUM_ORE_KEY = registerKey("fabium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIRITONIUM_ORE_KEY = registerKey("diritonium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIGHT_PILE_KEY = registerKey("light_pile");

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(PigsNStuff.MOD_ID, name));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new TagMatchRuleTest(BlockTags.DRAGON_IMMUNE);

        List<OreFeatureConfig.Target> overworldTinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                ModBlocks.TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                ModBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherFabiumOre =
                List.of(OreFeatureConfig.createTarget(netherrackReplaceables,
                        ModBlocks.FABIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endDiritoniumOre =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, ModBlocks.DIRITONIUM_ORE.getDefaultState()));

        register(context, EUCALYPTUS_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.EUCALYPTUS_LOG),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.of(ModBlocks.EUCALYPTUS_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 1, 1)).build());

        register(context, LIGHT_PILE_KEY, Feature.BLOCK_PILE, new BlockPileFeatureConfig
                (BlockStateProvider.of(Blocks.SHROOMLIGHT.getDefaultState())));

        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 9));
        register(context, FABIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherFabiumOre, 6));
        //register(context, DIRITONIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endDiritoniumOre, 6));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void
        register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
                 F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
