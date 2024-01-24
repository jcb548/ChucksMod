package net.chuck.chucksmod.recipe;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;

import java.util.List;

public abstract class ModRecipe implements Recipe<SimpleInventory> {
    protected final ItemStack output;
    protected final List<Ingredient> ingredients;
    public ModRecipe(List<Ingredient> ingredients, ItemStack output){
        this.output = output;
        this.ingredients = ingredients;
    }
    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return this.getResult(registryManager).copy();
    }
    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return output.copy();
    }
    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.ingredients.size());
        list.addAll(ingredients);
        return list;
    }
}
