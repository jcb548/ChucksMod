package net.chuck.chucksmod.block.entity.portal_builder;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.chuck.chucksmod.recipe.PortalRecipe;
import net.chuck.chucksmod.screen.portal_builder.PortalBuilderScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class AbstractPortalBuilderBlockEntity extends AbstractEnergyCookerBlockEntity {
    public static final int INV_SIZE = 4;
    public static final int FIRST_BOSS_ITEM_SLOT = 2;
    public static final int SECOND_BOSS_ITEM_SLOT = 3;
    public AbstractPortalBuilderBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                            int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, INV_SIZE, energyStorageSize, maxProgress, maxInsertExtract);
    }
    private Optional<RecipeEntry<PortalRecipe>> getCurrentRecipe(){
        SimpleInventory inventory = new SimpleInventory(this.size());
        inventory.setStack(INPUT_SLOT, this.getStack(INPUT_SLOT));
        inventory.setStack(FIRST_BOSS_ITEM_SLOT, this.getStack(FIRST_BOSS_ITEM_SLOT));
        inventory.setStack(SECOND_BOSS_ITEM_SLOT, this.getStack(SECOND_BOSS_ITEM_SLOT));
        return getWorld().getRecipeManager().getFirstMatch(PortalRecipe.Type.INSTANCE, inventory, getWorld());
    }
    @Override
    protected void craftItem() {
        Optional<RecipeEntry<PortalRecipe>> recipe = getCurrentRecipe();
        this.removeStack(INPUT_SLOT,8);
        this.removeStack(FIRST_BOSS_ITEM_SLOT,1);
        this.removeStack(SECOND_BOSS_ITEM_SLOT,1);
        this.setStack(AbstractEnergyCookerBlockEntity.OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(AbstractEnergyCookerBlockEntity.OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    @Override
    protected boolean hasRecipe() {
        Optional<RecipeEntry<PortalRecipe>> recipe = getCurrentRecipe();
        return recipe.isPresent() && canInsertAmountIntoOutputSlot()
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new PortalBuilderScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
}
