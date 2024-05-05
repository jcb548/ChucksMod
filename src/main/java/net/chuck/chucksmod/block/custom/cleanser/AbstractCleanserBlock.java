package net.chuck.chucksmod.block.custom.cleanser;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.ExperienceInteractingFluidStoring;
import net.chuck.chucksmod.block.entity.cleanser.AbstractCleanserBlockEntity;
import net.chuck.chucksmod.fluid.ModFluids;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractCleanserBlock extends AbstractEnergyUsingBlock {
    protected AbstractCleanserBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.chucksmod.cleanser"));
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if(player.getStackInHand(hand).getItem() instanceof BucketItem && world.getBlockEntity(pos) instanceof
                    AbstractCleanserBlockEntity entity){
                entity.interactBucket(player, hand);
            } else if(player.isSneaking()) {
                if(world.getBlockEntity(pos) instanceof ExperienceInteractingFluidStoring fluidTank){
                    if(fluidTank.getFluidStorage().variant.equals(FluidVariant.of(ModFluids.STILL_LIQUID_XP))){
                        fluidTank.interactExperience(player);
                    }
                }
            } else {
                NamedScreenHandlerFactory screenHandlerFactory = ((AbstractCleanserBlockEntity) world.getBlockEntity(pos));
                if (screenHandlerFactory != null) {
                    player.openHandledScreen(screenHandlerFactory);
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
