package net.chuck.chucksmod.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.chuck.chucksmod.recipe.ModRecipe;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class CrusherRecipeJsonBuilder implements CraftingRecipeJsonBuilder {
    private final RecipeCategory category;
    private final Item output;
    private final int count;
    private final Ingredient input;
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap();
    @Nullable
    private String group;
    private final RecipeSerializer<? extends ModRecipe> serializer;
    private CrusherRecipeJsonBuilder(RecipeCategory category, Item output, int count, Ingredient input, @Nullable String group,
                                     RecipeSerializer<? extends ModRecipe> serializer){
        this.category = category;
        this.output = output;
        this.count = count;
        this.input = input;
        this.group = group;
        this.serializer = serializer;
    }
    public static CrusherRecipeJsonBuilder create(Ingredient input, RecipeCategory category, ItemConvertible output,
                                                  int count, String group){
        return new CrusherRecipeJsonBuilder(category, output.asItem(), count, input, group, CrusherRecipe.Serializer.INSTANCE);
    }
    @Override
    public CraftingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return output;
    }

    @Override
    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        this.validate(recipeId);
        Advancement.Builder builder = exporter.getAdvancementBuilder().criterion("has_the_recipe",
                RecipeUnlockedCriterion.create(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criteria.forEach(builder::criterion);
        exporter.accept(new CrusherRecipeJsonBuilder.CrusherRecipeJsonProvider(recipeId, category,
                this.group == null ? "" : this.group, this.input, this.output, this.count,
                builder.build(recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/")), this.serializer));
    }
    private void validate(Identifier recipeId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }
    record CrusherRecipeJsonProvider(Identifier id, RecipeCategory category, String group, Ingredient input,
                                     Item result, int count ,AdvancementEntry advancement,
                                     RecipeSerializer<? extends ModRecipe> serializer) implements RecipeJsonProvider
    {
        @Override
        public void serialize(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }
            json.addProperty("category", this.category.toString());
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(input.toJson(false));
            json.add("ingredients", jsonArray);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("item", Registries.ITEM.getId(this.result).toString());
            if(count > 1){
                jsonObject.addProperty("count", count);
            }
            json.add("output", jsonObject);
        }
    }
}
