package net.chuck.chucksmod.block.entity.quarry;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.AbstractMiningBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public abstract class AbstractQuarryBlockEntity extends AbstractMiningBlockEntity {
    public AbstractQuarryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                     int invSize, int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, invSize, energyStorageSize, maxProgress, maxInsertExtract);
    }
    public void tick(World world, BlockPos pos, BlockState blockState) {
        if (world.isClient()) {
            return;
        }
        super.tick(world, pos, blockState);
        ServerWorld serverWorld = (ServerWorld) world;
        boolean shouldTryMine = world.isReceivingRedstonePower(pos) && this.hasEnoughEnergy() && yPos>-64;
        if(shouldTryMine){
            this.increaseProgress();
            this.extractEnergy();
            markDirty(world, pos, blockState);
            if(shouldBreakBlock()){
                BlockPos nextBlockPos = getNextBlockPos();
                BlockState nextBlockState = world.getBlockState(nextBlockPos);
                if(isBreakable(nextBlockState) && canBreak(nextBlockState)) {
                    List<ItemStack> drops = Block.getDroppedStacks(nextBlockState, serverWorld, nextBlockPos,
                            serverWorld.getBlockEntity(nextBlockPos), null, getTool());
                    for (int i = 0; i < drops.size(); i++) {
                        ItemStack excess = inventory.addStack(drops.get(i));
                        if (!excess.equals(ItemStack.EMPTY)) {
                            ItemEntity items = new ItemEntity(serverWorld, pos.getX() + 0.5, pos.getY() + 1,
                                    pos.getZ() + 0.5, excess);
                            world.spawnEntity(items);
                        }
                    }
                    world.breakBlock(nextBlockPos, false);
                }
                incrementBlockPos();
                this.resetProgress();
            }
        }
        blockState = blockState.with(AbstractEnergyUsingBlock.LIT, shouldTryMine);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
    }

    private boolean isBreakable(BlockState state){
        return !state.isIn(BlockTags.WITHER_IMMUNE) &&  !state.isLiquid();
    }

    public abstract ItemStack getTool();

    protected boolean canBreak(BlockState state) {
        return !state.isToolRequired() || state.isIn(BlockTags.PICKAXE_MINEABLE) && getTool().isSuitableFor(state);
    }
}
