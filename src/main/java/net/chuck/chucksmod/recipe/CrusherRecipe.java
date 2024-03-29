package net.chuck.chucksmod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chuck.chucksmod.block.entity.crusher.AbstractCrusherBlockEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.List;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class CrusherRecipe extends ModRecipe {
    public final int FIRST_INGREDIENT = 0;

    public CrusherRecipe(List<Ingredient> ingredients, ItemStack output) {
        super(ingredients, output);
    }
    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }

        return this.ingredients.get(FIRST_INGREDIENT).test(inventory.getStack(AbstractCrusherBlockEntity.INPUT_SLOT));
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CrusherRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "crusher_recipe";
    }
    public static class Serializer implements RecipeSerializer<CrusherRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "crusher_recipe";

        public static final Codec<CrusherRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients")
                        .forGetter(CrusherRecipe::getIngredients), RecipeCodecs.CRAFTING_RESULT.fieldOf("output")
                        .forGetter(r -> r.output)
        ).apply(in, CrusherRecipe::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max){
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ?
                            DataResult.error(()-> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(()-> "Recipe has no ingredients!") : DataResult.success(list));
        }

        @Override
        public Codec<CrusherRecipe> codec() {
            return CODEC;
        }

        @Override
        public CrusherRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
            for(int i=0; i< inputs.size(); i++){
                inputs.set(i, Ingredient.fromPacket(buf));
            }
            ItemStack output = buf.readItemStack();
            return new CrusherRecipe(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, CrusherRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for(Ingredient ingredient : recipe.getIngredients()){
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.getResult(null));
        }
    }
}
