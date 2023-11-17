package net.chuck.chucksmod.block.entity.crusher;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.math.BlockPos;

import java.util.Optional;

public abstract class AbstractPoweredCrusherBlockEntity extends AbstractEnergyCookerBlockEntity {
    public static final int DELEGATE_SIZE = 2;
    public static final int INV_SIZE = 2;

    public AbstractPoweredCrusherBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state,
                                             int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(entity, pos, state, energyStorageSize, maxProgress, maxInsertExtract);
    }
    protected void craftItem() {
        Optional<RecipeEntry<CrusherRecipe>> recipe = getCurrentRecipe();
        this.removeStack(INPUT_SLOT,1);
        this.setStack(AbstractEnergyCookerBlockEntity.OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(AbstractEnergyCookerBlockEntity.OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    protected boolean hasRecipe() {
        Optional<RecipeEntry<CrusherRecipe>> recipe = getCurrentRecipe();
        return recipe.isPresent() && canInsertAmountIntoOutputSlot()
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeEntry<CrusherRecipe>> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for(int i=0; i< this.size(); i++){
            inventory.setStack(i, this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(CrusherRecipe.Type.INSTANCE, inventory, getWorld());
    }
}
