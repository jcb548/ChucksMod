package net.chuck.chucksmod.block.custom.pump;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.ExperienceInteractingFluidStoring;
import net.chuck.chucksmod.block.entity.pump.AbstractPumpBlockEntity;
import net.chuck.chucksmod.fluid.ModFluids;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractPumpBlock extends AbstractEnergyUsingBlock {
    protected AbstractPumpBlock(Settings settings) {
        super(settings);
    }
    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if(player.getStackInHand(hand).getItem() instanceof BucketItem && world.getBlockEntity(pos) instanceof
                    AbstractPumpBlockEntity entity){
                entity.interactBucket(player, hand);
            } else if(player.isSneaking()) {
                if(world.getBlockEntity(pos) instanceof ExperienceInteractingFluidStoring fluidTank){
                    if(fluidTank.getFluidStorage().variant.equals(FluidVariant.of(ModFluids.STILL_LIQUID_XP))){
                        fluidTank.interactExperience(player);
                    }
                }
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
