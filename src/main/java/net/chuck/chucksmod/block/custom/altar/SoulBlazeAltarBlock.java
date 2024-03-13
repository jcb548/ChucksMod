package net.chuck.chucksmod.block.custom.altar;

import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SoulBlazeAltarBlock extends Block {
    private static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),
            Block.createCuboidShape(7, 3, 7, 9, 16, 9));
    public SoulBlazeAltarBlock(Settings settings) {
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
        if(heldItem.isOf(ModItems.BLAZE_STAR)){
            SoulBlazeBoss entity = new SoulBlazeBoss(ModEntities.SOUL_BLAZE_BOSS, world);
            entity.setPos(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            world.spawnEntity(entity);
            if(!world.isClient)
                for (ServerPlayerEntity serverPlayerEntity : PlayerLookup.around((ServerWorld) world, entity.getPos(), 10)) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, entity);
                }
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD );
            int count = heldItem.getCount();
            if(!player.isCreative())
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
