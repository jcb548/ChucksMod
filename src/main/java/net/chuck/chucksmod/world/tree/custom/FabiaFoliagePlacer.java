package net.chuck.chucksmod.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chuck.chucksmod.world.tree.ModFoliagePlacerTypes;
import net.chuck.chucksmod.world.tree.ModTrunkPlacerTypes;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class FabiaFoliagePlacer extends FoliagePlacer {
    public static final Codec<FabiaFoliagePlacer> CODEC = RecordCodecBuilder.create(fabiaFoliagePlacerInstance ->
            fillFoliagePlacerFields(fabiaFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(placer -> placer.height)).apply(fabiaFoliagePlacerInstance, FabiaFoliagePlacer::new));
    private final int height;
    public FabiaFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.FABIA_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        generateSquare(world, placer, random, config, treeNode.getCenter().up(2), 1, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(1),2, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0),2, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(-1),2, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(-2), 1, 0, treeNode.isGiantTrunk());
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == 0) {
            return (dx == radius-1 && dz == radius && random.nextFloat()<0.2f)
                    ||(dx == radius && dz == radius-1 && random.nextFloat()<0.2f)
                    ||(dx > 1 && dz > 1);
        }
        return dx == radius && dz == radius && radius > 0;
    }
}
