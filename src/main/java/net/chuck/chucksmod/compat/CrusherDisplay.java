package net.chuck.chucksmod.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.minecraft.recipe.RecipeEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrusherDisplay extends BasicDisplay {
    public CrusherDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public CrusherDisplay(RecipeEntry<CrusherRecipe> recipe){
        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(
                recipe.value().getResult(null)))));
    }

    private static List<EntryIngredient> getInputList(CrusherRecipe recipe){
        if(recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(0)));
        //list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(1)));
        return list;
    }
    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CrusherCategory.CRUSHER;
    }
}
