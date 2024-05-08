package net.chuck.chucksmod.block.custom.altar;

import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.entity.custom.PippinBoss;
import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PippinAltarBlock extends Block {
    private static VoxelShape SHAPE = Block.createCuboidShape(6, 0, 6, 10, 13, 10);
    public PippinAltarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);
        if(heldItem.isOf(ModItems.COOKED_TRIAFIAN_PORKCHOP) || heldItem.isOf(ModItems.TRIAFIAN_PORKCHOP)){
            PippinBoss entity = new PippinBoss(ModEntities.PIPPIN, world);
            entity.setPos(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
            world.spawnEntity(entity);
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD );
            int count = heldItem.getCount();
            if(count > 1){
                heldItem.setCount(count-1);
                player.setStackInHand(hand, heldItem);
            } else {
                player.setStackInHand(hand, ItemStack.EMPTY);
            }
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
