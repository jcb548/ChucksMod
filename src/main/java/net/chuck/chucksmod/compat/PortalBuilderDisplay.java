package net.chuck.chucksmod.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.chuck.chucksmod.recipe.PortalRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PortalBuilderDisplay extends BasicDisplay {
    public PortalBuilderDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public PortalBuilderDisplay(RecipeEntry<PortalRecipe> recipe){
        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(
                recipe.value().getResult(null)))));
    }

    private static List<EntryIngredient> getInputList(PortalRecipe recipe){
        if(recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        ItemStack stack = recipe.getIngredients().get(0).getMatchingStacks()[0];
        stack.setCount(8);
        list.add(EntryIngredients.of(stack));
        list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(1)));
        list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(2)));
        return list;
    }
    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PortalBuilderCategory.PORTAL_BUILDER;
    }
}
