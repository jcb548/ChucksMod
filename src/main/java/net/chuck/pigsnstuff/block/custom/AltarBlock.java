package net.chuck.pigsnstuff.block.custom;

import net.chuck.pigsnstuff.entity.ModEntities;
import net.chuck.pigsnstuff.entity.custom.FrankBoss;
import net.chuck.pigsnstuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AltarBlock extends Block {
    public AltarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);
        if(heldItem.isOf(ModItems.DIRITIA_CRYSTAL)){
            FrankBoss entity = new FrankBoss(ModEntities.FRANK_BOSS, world);
            entity.setPos(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            world.spawnEntity(entity);
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD );
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
