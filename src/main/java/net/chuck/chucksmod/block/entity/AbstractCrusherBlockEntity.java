package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.block.custom.CrusherBlock;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import java.util.Optional;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public abstract class AbstractCrusherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,
        ImplementedInventory {
    public static final int INPUT_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;
    public static final int PROGRESS_IDX = 0;
    public static final int MAX_PROGRESS_IDX = 1;
    protected int progress = 0;
    protected int maxProgress = 50;
    public AbstractCrusherBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state) {
        super(entity, pos, state);
    }

    protected void resetProgress() {
        this.progress = 0;
    }
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    protected void craftItem() {
        Optional<RecipeEntry<CrusherRecipe>> recipe = getCurrentRecipe();
        this.removeStack(INPUT_SLOT,1);
        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    protected boolean hasRecipe() {
        Optional<RecipeEntry<CrusherRecipe>> recipe = getCurrentRecipe();
        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
        && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeEntry<CrusherRecipe>> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for(int i=0; i< this.size(); i++){
            inventory.setStack(i, this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(CrusherRecipe.Type.INSTANCE, inventory, getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(Item output) {
        return this.getStack(OUTPUT_SLOT).getItem() == output || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() > this.getStack(OUTPUT_SLOT).getCount();
    }
    protected boolean hasCraftingFinished(){
        return progress >= maxProgress;
    }
    protected void increaseCraftProgress(){
        progress++;
    }
    private boolean isOutputSlotEmptyOrReceivable(){
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(CrusherBlock.FACING);

        if(side == Direction.DOWN){
            return false;
        }
        // From top insert into 1
        if(side == Direction.UP){
            return slot == INPUT_SLOT;
        }
        // right insert into 1
        // From left insert into 0
        return switch (localDir) {
            default ->
                side.getOpposite() == Direction.NORTH && slot == INPUT_SLOT || //&& stack.getItem() == ModBlockTags.CRUSHABLE
                        side.getOpposite() == Direction.EAST && slot == INPUT_SLOT||
                        side.getOpposite() == Direction.WEST && slot == INPUT_SLOT;
            case EAST ->
                side.rotateYClockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                        side.rotateYClockwise() == Direction.EAST && slot == INPUT_SLOT ||
                        side.rotateYClockwise() == Direction.WEST && slot == INPUT_SLOT;
            case SOUTH ->
                side  == Direction.NORTH && slot == INPUT_SLOT ||
                        side == Direction.EAST && slot == INPUT_SLOT ||
                        side == Direction.WEST && slot == INPUT_SLOT;
            case WEST ->
                side.rotateYCounterclockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                        side.rotateYCounterclockwise() == Direction.EAST && slot == INPUT_SLOT ||
                        side.rotateYCounterclockwise() == Direction.WEST && slot == INPUT_SLOT;
        };
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(CrusherBlock.FACING);

        if(side == Direction.UP){
            return false;
        }

        // From Down extract from 2
        if(side == Direction.DOWN){
            return slot == OUTPUT_SLOT;
        }
        // From bottom extract from 2
        // From right extract from 2
        return switch (localDir) {
            default ->
                    side.getOpposite() == Direction.NORTH && slot == OUTPUT_SLOT || //&& stack.getItem() == ModBlockTags.CRUSHABLE
                            side.getOpposite() == Direction.EAST && slot == OUTPUT_SLOT;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == OUTPUT_SLOT ||
                            side.rotateYClockwise() == Direction.EAST && slot == OUTPUT_SLOT;
            case SOUTH ->
                    side  == Direction.NORTH && slot == OUTPUT_SLOT ||
                            side == Direction.EAST && slot == OUTPUT_SLOT;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == OUTPUT_SLOT ||
                            side.rotateYCounterclockwise() == Direction.EAST && slot == OUTPUT_SLOT;
        };
    }
}
