package net.chuck.chucksmod.block.custom.harvester;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.harvester.TitaniumHarvesterBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
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

public class TitaniumHarvesterBlock extends AbstractHarvesterBlock {
    public TitaniumHarvesterBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TitaniumHarvesterBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.TITANIUM_HARVESTER,
                ((world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1)));
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.chucksmod.titanium_harvester"));
        super.appendTooltip(stack, world, tooltip, options);
    }
    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = ((TitaniumHarvesterBlockEntity) world.getBlockEntity(pos));
            if(screenHandlerFactory != null){
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }
}
