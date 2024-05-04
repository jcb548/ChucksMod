package net.chuck.chucksmod.world.vegetation;

import com.mojang.serialization.Codec;
import net.chuck.chucksmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class TriafianVineFeature extends Feature<DefaultFeatureConfig> {
    public TriafianVineFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }
    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        context.getConfig();
        if (!structureWorldAccess.isAir(blockPos)) {
            return false;
        }
        for (Direction direction : Direction.values()) {
            if (direction == Direction.DOWN || !VineBlock.shouldConnectTo(structureWorldAccess,
                    blockPos.offset(direction), direction)) continue;
            structureWorldAccess.setBlockState(blockPos,
                    ModBlocks.TRIAFIAN_VINE.getDefaultState().with(VineBlock.getFacingProperty(direction), true),
                    Block.NOTIFY_LISTENERS);
            return true;
        }
        return false;
    }
}
