package net.chuck.chucksmod.world.tree.custom;

import com.mojang.serialization.Codec;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.world.tree.ModTreeDecoratorTypes;
import net.minecraft.block.VineBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;


public class TriafianLeavesVineTreeDecorator extends TreeDecorator {
    public static final Codec<TriafianLeavesVineTreeDecorator> CODEC =
            (Codec.floatRange(0.0f, 1.0f).fieldOf("probability")).xmap(TriafianLeavesVineTreeDecorator::new,
                    treeDecorator -> Float.valueOf(treeDecorator.probability)).codec();
    private final float probability;
    public TriafianLeavesVineTreeDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorTypes.LEAVE_TRIAFIAN_VINE;
    }

    public void generate(TreeDecorator.Generator generator) {
        Random random = generator.getRandom();
        generator.getLeavesPositions().forEach(pos -> {
            BlockPos blockPos;
            if (random.nextFloat() < this.probability && generator.isAir(blockPos = pos.west())) {
                placeVines(blockPos, VineBlock.EAST, generator);
            }
            if (random.nextFloat() < this.probability && generator.isAir(blockPos = pos.east())) {
                placeVines(blockPos, VineBlock.WEST, generator);
            }
            if (random.nextFloat() < this.probability && generator.isAir(blockPos = pos.north())) {
                placeVines(blockPos, VineBlock.SOUTH, generator);
            }
            if (random.nextFloat() < this.probability && generator.isAir(blockPos = pos.south())) {
                placeVines(blockPos, VineBlock.NORTH, generator);
            }
        });
    }

    /**
     * Places a vine at a given position and then up to 4 more vines going downwards.
     */
    private static void placeVines(BlockPos pos, BooleanProperty faceProperty, TreeDecorator.Generator generator) {
        generator.replace(pos, ModBlocks.TRIAFIAN_VINE.getDefaultState().with(faceProperty, true));
        pos = pos.down();
        for (int i = generator.getRandom().nextBetween(2,5); generator.isAir(pos) && i > 0; --i) {
            generator.replace(pos, ModBlocks.TRIAFIAN_VINE.getDefaultState().with(faceProperty, true));
            pos = pos.down();
        }
    }
}
