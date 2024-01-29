package net.chuck.chucksmod.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chuck.chucksmod.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FabiaTrunkPlacer extends TrunkPlacer {
    public static final Codec<FabiaTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, FabiaTrunkPlacer::new));

    public FabiaTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.FABIA_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                                 Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);
        int treeHeight = height + random.nextBetween(firstRandomHeight-2, firstRandomHeight+2) +
                random.nextBetween(secondRandomHeight-2, secondRandomHeight + 2);
        List<FoliagePlacer.TreeNode> nodes = new ArrayList<>();
        for(int i=0; i<treeHeight; i++){
            getAndSetState(world, replacer, random, startPos.up(i), config);
            if(i >= 3 && i%2 == 0 && random.nextBoolean()){
                if(random.nextFloat()>0.25f){
                    int x=1;
                    int y = random.nextBetween(3, 5);
                    for(; x<= y;x++){
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x),
                                (BlockState) Function.identity().apply(config.trunkProvider.get(random,
                                        startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                    nodes.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.NORTH, x), 0, false));
                }if(random.nextFloat()>0.25f){
                    int x=1;
                    int y = random.nextBetween(3, 5);
                    for(; x<= y;x++){
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x),
                                (BlockState) Function.identity().apply(config.trunkProvider.get(random,
                                        startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                    nodes.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.SOUTH, x), 0, false));
                }if(random.nextFloat()>0.25f){
                    int x=1;
                    int y = random.nextBetween(3, 5);
                    for(; x<= y;x++){
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x),
                                (BlockState) Function.identity().apply(config.trunkProvider.get(random,
                                        startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                    nodes.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.EAST, x), 0, false));
                }if(random.nextFloat()>0.25f){
                    int x=1;
                    int y = random.nextBetween(3, 5);
                    for(; x<= y;x++){
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x),
                                (BlockState) Function.identity().apply(config.trunkProvider.get(random,
                                        startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                    nodes.add(new FoliagePlacer.TreeNode(startPos.up(i).offset(Direction.WEST, x), 0, false));
                }
            }
        }
        nodes.add(new FoliagePlacer.TreeNode(startPos.up(treeHeight),0,false));
        return nodes;
    }
}
