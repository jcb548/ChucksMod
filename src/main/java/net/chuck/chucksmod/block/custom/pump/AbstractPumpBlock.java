package net.chuck.chucksmod.block.custom.pump;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.copier.AbstractCopierBlockEntity;
import net.chuck.chucksmod.block.entity.pump.AbstractPumpBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractPumpBlock extends AbstractEnergyUsingBlock {
    protected AbstractPumpBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if(player.getStackInHand(hand).getItem() instanceof BucketItem && world.getBlockEntity(pos) instanceof
                    AbstractPumpBlockEntity entity){
                entity.interactBucket(player, hand);
            } else {
                NamedScreenHandlerFactory screenHandlerFactory = ((AbstractPumpBlockEntity) world.getBlockEntity(pos));
                if (screenHandlerFactory != null) {
                    player.openHandledScreen(screenHandlerFactory);
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
