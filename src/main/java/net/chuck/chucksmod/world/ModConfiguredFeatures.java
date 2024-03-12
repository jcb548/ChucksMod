package net.chuck.chucksmod.world;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.custom.crop.magical.AbstractMagicalCropBlock;
import net.chuck.chucksmod.world.tree.custom.TriafiaFoliagePlacer;
import net.chuck.chucksmod.world.tree.custom.TriafiaTrunkPlacer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
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
    public static final RegistryKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_KEY = registerKey("titanium_ore");
    
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
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TRIAFIUM_ORE_KEY =
            registerKey("nether_triafium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TITANIUM_ORE_KEY =
            registerKey("nether_titanium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_CRYSTAL_PLANT_KEY =
            registerKey("nether_crystal_plant");
    // End
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_TRIAFIUM_ORE_KEY =
            registerKey("end_triafium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_TITANIUM_ORE_KEY =
            registerKey("end_titanium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_PACSARIUM_ORE_KEY =
            registerKey("end_pacsarium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_ANCIENT_DEBRIS_KEY =
            registerKey("end_ancient_debris");
    //Triafia
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_TREE_KEY =
            registerKey("triafia_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_ANCIENT_DEBRIS_KEY =
            registerKey("triafia_ancient_debris");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_COAL_ORE_KEY =
            registerKey("triafia_coal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_COPPER_ORE_KEY =
            registerKey("triafia_copper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_DIAMOND_ORE_KEY =
            registerKey("triafia_diamond_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_PACSARIUM_ORE_KEY =
            registerKey("triafia_pacsarium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_EMERALD_ORE_KEY =
            registerKey("triafia_emerald_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_TRIAFIUM_ORE_KEY =
            registerKey("triafia_triafium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_GOLD_ORE_KEY =
            registerKey("triafia_gold_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_IRON_ORE_KEY =
            registerKey("triafia_iron_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_LAPIS_ORE_KEY =
            registerKey("triafia_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_REDSTONE_ORE_KEY =
            registerKey("triafia_redstone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_TIN_ORE_KEY =
            registerKey("triafia_tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_TITANIUM_ORE_KEY =
            registerKey("triafia_titanium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_ECLOGITE_VEIN_KEY =
            registerKey("triafia_eclogite_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_TUFF_VEIN_KEY =
            registerKey("triafia_tuff_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_ECLOGITE_PILE_KEY =
            registerKey("triafia_eclogite_pile");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_TUFF_PILE_KEY =
            registerKey("triafia_tuff_pile");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRIAFIA_PLANT_PATCH_KEY =
            registerKey("triafia_plant_patch");

    // Generation for Pacsaria Islands
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_PACSARIUM_ORE_KEY =
            registerKey("pacsaria_pacsarium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_TRIAFIUM_ORE_KEY =
            registerKey("pacsaria_triafium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_TITANIUM_ORE_KEY =
            registerKey("pacsaria_titanium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_ANCIENT_DEBRIS_KEY =
            registerKey("pacsaria_ancient_debris");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_COAL_ORE_KEY =
            registerKey("pacsaria_coal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_IRON_ORE_KEY =
            registerKey("pacsaria_iron_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_GOLD_ORE_KEY =
            registerKey("pacsaria_gold_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_DIAMOND_ORE_KEY =
            registerKey("pacsaria_diamond_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_REDSTONE_ORE_KEY =
            registerKey("pacsaria_redstone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_LAPIS_ORE_KEY =
            registerKey("pacsaria_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_COPPER_ORE_KEY =
            registerKey("pacsaria_copper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_CALCITE_VEIN_KEY =
            registerKey("pacsaria_calcite_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_BLACKSTONE_VEIN_KEY =
            registerKey("pacsaria_blackstone_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_ENDSTONE_VEIN_KEY =
            registerKey("pacsaria_endstone_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PACSARIA_TREE_KEY =
            registerKey("pacsaria_tree");


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ChucksMod.MOD_ID, name));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);
        RuleTest serpentiniteReplaceables = new BlockMatchRuleTest(ModBlocks.SERPENTINITE);

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
        List<OreFeatureConfig.Target> overworldTitanumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables,
                                ModBlocks.TITANIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,
                                ModBlocks.DEEPSLATE_TITANIUM_ORE.getDefaultState()));

        // New Nether Ores
        List<OreFeatureConfig.Target> netherTriafiumOre =
                List.of(OreFeatureConfig.createTarget(netherrackReplaceables,
                        ModBlocks.NETHER_TRIAFIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherTitaniumOre =
                List.of(OreFeatureConfig.createTarget(netherrackReplaceables,
                        ModBlocks.NETHER_TITANIUM_ORE.getDefaultState()));

        //End Ores
        List<OreFeatureConfig.Target> endTriafiumOre =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables,
                        ModBlocks.END_STONE_TRIAFIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endTitaniumOre =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables,
                        ModBlocks.END_STONE_TITANIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endPacsariumOre =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables,
                        ModBlocks.END_STONE_PACSARIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endAncientDebris =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables,
                        Blocks.ANCIENT_DEBRIS.getDefaultState()));
        //Triafia Ores
        List<OreFeatureConfig.Target> triafiaAncientDebris =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        Blocks.ANCIENT_DEBRIS.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaCoalOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_COAL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaCopperOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_COPPER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaDiamondOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_DIAMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaPacsariumOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_PACSARIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaEmeraldOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_EMERALD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaTriafiumOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_TRIAFIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaGoldOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_GOLD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaIronOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_IRON_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaLapisOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_LAPIS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaRedstoneOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_REDSTONE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaTinOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_TIN_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaTitaniumOre =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.SERPENTINITE_TITANIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaEclogiteVein =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        ModBlocks.ECLOGITE.getDefaultState()));
        List<OreFeatureConfig.Target> triafiaTuffVein =
                List.of(OreFeatureConfig.createTarget(serpentiniteReplaceables,
                        Blocks.TUFF.getDefaultState()));
        //Pacsaria Ores
        List<OreFeatureConfig.Target> pacsariaPacsariumOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        ModBlocks.DEEPSLATE_PACSARIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaTriafiumOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        ModBlocks.DEEPSLATE_TRIAFIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaTitaniumOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        ModBlocks.DEEPSLATE_TITANIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaAncientDebris =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.ANCIENT_DEBRIS.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaCoalOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_COAL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaIronOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_IRON_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaGoldOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_GOLD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaDiamondOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_DIAMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaCopperOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_COPPER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaRedstoneOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_REDSTONE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaLapisOre =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.DEEPSLATE_LAPIS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaCalcite =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.CALCITE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaBlackstoneVein =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.BLACKSTONE.getDefaultState()));
        List<OreFeatureConfig.Target> pacsariaEndstoneVein =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables,
                        Blocks.END_STONE.getDefaultState()));

        // Register New Trees
        register(context, EUCALYPTUS_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.EUCALYPTUS_LOG),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.of(ModBlocks.EUCALYPTUS_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 1, 1)).build());

        register(context, PACSARIA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PACSARIA_LOG),
                new ForkingTrunkPlacer(7, 3, 3),
                BlockStateProvider.of(ModBlocks.PACSARIA_LEAVES),
                new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1,1,1)).build());

        register(context, TRIAFIA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.TRIAFIA_LOG),
                new TriafiaTrunkPlacer(6, 1, 2),
                BlockStateProvider.of(ModBlocks.TRIAFIA_LEAVES),
                new TriafiaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1,0,2)).build());
        // Register New Misc
        register(context, TRIAFIA_ECLOGITE_PILE_KEY, Feature.BLOCK_PILE,
                new BlockPileFeatureConfig(BlockStateProvider.of(ModBlocks.ECLOGITE.getDefaultState())));
        register(context, TRIAFIA_TUFF_PILE_KEY, Feature.BLOCK_PILE,
                new BlockPileFeatureConfig(BlockStateProvider.of(Blocks.TUFF.getDefaultState())));
        register(context, TRIAFIA_PLANT_PATCH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TRIAFIA_PLANT))));
        DataPool states = DataPool.builder()
                .add(ModBlocks.NETHER_CRYSTAL_CROP.getDefaultState().with(AbstractMagicalCropBlock.AGE, 0), 1)
                .add(ModBlocks.NETHER_CRYSTAL_CROP.getDefaultState().with(AbstractMagicalCropBlock.AGE, 1), 1)
                .add(ModBlocks.NETHER_CRYSTAL_CROP.getDefaultState().with(AbstractMagicalCropBlock.AGE, 2), 1)
                .add(ModBlocks.NETHER_CRYSTAL_CROP.getDefaultState().with(AbstractMagicalCropBlock.AGE, 3), 1)
                .add(ModBlocks.NETHER_CRYSTAL_CROP.getDefaultState().with(AbstractMagicalCropBlock.AGE, 4), 1)
                .add(ModBlocks.NETHER_CRYSTAL_CROP.getDefaultState().with(AbstractMagicalCropBlock.AGE, 5), 1)
                .build();
        register(context, NETHER_CRYSTAL_PLANT_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(states)),0, 3, 1));

        // Register Overworld Ores
        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 9));
        register(context, TITANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTitanumOres, 9));
        register(context, NEW_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(newCopperOres, 12));
        register(context, NEW_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(newIronOres, 9));
        register(context, NEW_GOLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(newGoldOres, 9));
        register(context, NEW_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(newLapisOres, 7));
        register(context, NEW_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(newDiamondOres, 8));
        register(context, NEW_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(newRedstoneOres, 8));
        // Register new Nether Ores
        register(context, NETHER_TRIAFIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherTriafiumOre, 6));
        register(context, NETHER_TITANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherTitaniumOre, 10));
        register(context, NEW_QUARTZ_ORE_KEY, Feature.ORE, new OreFeatureConfig(newQuartzOres, 14));
        register(context, NEW_ANCIENT_DEBRIS_KEY, Feature.ORE, new OreFeatureConfig(newAncientDebris, 8));
        // Register End Ores
        register(context, END_TRIAFIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endTriafiumOre, 8));
        register(context, END_TITANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endTitaniumOre, 12));
        register(context, END_PACSARIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endPacsariumOre, 6));
        register(context, END_ANCIENT_DEBRIS_KEY, Feature.ORE, new OreFeatureConfig(endAncientDebris, 6));
        // Register Triafia Ores
        register(context, TRIAFIA_ANCIENT_DEBRIS_KEY, Feature.ORE, new OreFeatureConfig(triafiaAncientDebris, 7));
        register(context, TRIAFIA_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaCoalOre, 17));
        register(context, TRIAFIA_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaCopperOre, 14));
        register(context, TRIAFIA_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaDiamondOre, 9));
        register(context, TRIAFIA_PACSARIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaPacsariumOre, 6));
        register(context, TRIAFIA_EMERALD_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaEmeraldOre, 4));
        register(context, TRIAFIA_TRIAFIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaTriafiumOre, 11));
        register(context, TRIAFIA_GOLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaGoldOre, 10));
        register(context, TRIAFIA_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaIronOre, 10));
        register(context, TRIAFIA_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaLapisOre, 8));
        register(context, TRIAFIA_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaRedstoneOre, 12));
        register(context, TRIAFIA_TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaTinOre, 6));
        register(context, TRIAFIA_TITANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(triafiaTitaniumOre, 9));
        register(context, TRIAFIA_ECLOGITE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(triafiaEclogiteVein, 64));
        register(context, TRIAFIA_TUFF_VEIN_KEY, Feature.ORE, new OreFeatureConfig(triafiaTuffVein, 64));
        // Register Pacsaria Ores
        register(context, PACSARIA_PACSARIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaPacsariumOre, 12));
        register(context, PACSARIA_TITANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaTitaniumOre, 8));
        register(context, PACSARIA_TRIAFIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaTriafiumOre, 12));
        register(context, PACSARIA_ANCIENT_DEBRIS_KEY, Feature.ORE, new OreFeatureConfig(pacsariaAncientDebris, 10));
        register(context, PACSARIA_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaCoalOre, 16));
        register(context, PACSARIA_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaIronOre, 9));
        register(context, PACSARIA_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaDiamondOre, 8));
        register(context, PACSARIA_GOLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaGoldOre, 9));
        register(context, PACSARIA_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaRedstoneOre, 9));
        register(context, PACSARIA_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaLapisOre, 6));
        register(context, PACSARIA_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(pacsariaCopperOre, 16));
        register(context, PACSARIA_CALCITE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(pacsariaCalcite, 64));
        register(context, PACSARIA_BLACKSTONE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(pacsariaBlackstoneVein, 64));
        register(context, PACSARIA_ENDSTONE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(pacsariaEndstoneVein, 64));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void
        register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
                 F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    public static <FC extends FeatureConfig, F extends Feature<FC>> RandomPatchFeatureConfig createRandomPatchFeatureConfig(F feature, FC config, int xz, int y, int tries) {
        return ModConfiguredFeatures.createRandomPatchFeatureConfig(tries, xz, y, PlacedFeatures.createEntry(feature, config, BlockPredicate.matchingBlocks(Blocks.AIR)));
    }
    public static RandomPatchFeatureConfig createRandomPatchFeatureConfig(int tries, int xz, int y,
                                                                          RegistryEntry<PlacedFeature> feature) {
        return new RandomPatchFeatureConfig(tries, xz, y, feature);
    }
}
