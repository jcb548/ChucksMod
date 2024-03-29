package net.chuck.chucksmod.block.custom.generator.steam;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.generator.steam.TitaniumSteamGeneratorBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TitaniumSteamGeneratorBlock extends AbstractSteamGeneratorBlock{
    public TitaniumSteamGeneratorBlock(Settings settings) {
        super(settings);
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TitaniumSteamGeneratorBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.TITANIUM_STEAM_GENERATOR,
                ((world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1)));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.getStackInHand(hand).getItem() instanceof BucketItem && world.getBlockEntity(pos) instanceof
                FluidStoring entity){
            entity.interactBucket(player, hand);
        } else {
            NamedScreenHandlerFactory screenHandlerFactory = (TitaniumSteamGeneratorBlockEntity) world.getBlockEntity(pos);
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }
}
