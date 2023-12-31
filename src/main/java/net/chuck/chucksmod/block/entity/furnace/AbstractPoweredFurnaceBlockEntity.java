package net.chuck.chucksmod.block.entity.furnace;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.screen.furnace.PoweredFurnaceScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPoweredFurnaceBlockEntity extends AbstractEnergyCookerBlockEntity {
    private final RecipeManager.MatchGetter<Inventory, SmeltingRecipe> matchGetter;
    public AbstractPoweredFurnaceBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state,
                                             int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(entity, pos, state, energyStorageSize, maxProgress, maxInsertExtract);
        this.matchGetter = RecipeManager.createCachedMatchGetter(RecipeType.SMELTING);
    }

    protected void craftItem() {
        RecipeEntry<SmeltingRecipe> recipe = getCurrentRecipe();
        if(recipe != null){
            this.removeStack(INPUT_SLOT,1);
            this.setStack(OUTPUT_SLOT, new ItemStack(recipe.value().getResult(null).getItem(),
                    getStack(OUTPUT_SLOT).getCount() + recipe.value().getResult(null).getCount()));
        }
    }
    protected boolean hasRecipe() {
        RecipeEntry<SmeltingRecipe> recipe = getCurrentRecipe();
        return recipe != null && canInsertAmountIntoOutputSlot()
                && canInsertItemIntoOutputSlot(recipe.value().getResult(null).getItem());
    }

    private RecipeEntry<SmeltingRecipe> getCurrentRecipe() {
        return this.matchGetter.getFirstMatch(this, world).orElse(null);
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        return new PoweredFurnaceScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
}
