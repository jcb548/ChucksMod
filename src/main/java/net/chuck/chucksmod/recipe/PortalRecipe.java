package net.chuck.chucksmod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chuck.chucksmod.block.entity.portal_builder.AbstractPortalBuilderBlockEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeCodecs;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.List;

public class PortalRecipe extends ModRecipe {
    public final int BLOCK = 0;
    public final int FIRST_BOSS_ITEM = 1;
    public final int SECOND_BOSS_ITEM = 2;
    public PortalRecipe(List<Ingredient> ingredients, ItemStack output){
        super(ingredients, output);
    }
    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient) return false;
        return this.ingredients.get(BLOCK).test(inventory.getStack(AbstractPortalBuilderBlockEntity.INPUT_SLOT)) &&
                inventory.getStack(AbstractPortalBuilderBlockEntity.INPUT_SLOT).getCount() >=8 &&
                this.ingredients.get(FIRST_BOSS_ITEM).test(inventory.getStack(AbstractPortalBuilderBlockEntity.FIRST_BOSS_ITEM_SLOT))
                && this.ingredients.get(SECOND_BOSS_ITEM).test(inventory.getStack(AbstractPortalBuilderBlockEntity.SECOND_BOSS_ITEM_SLOT));
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
    public static class Type implements RecipeType<PortalRecipe>{
        public static final Type INSTANCE = new Type();
        public static final String ID = "portal_recipe";
    }
    public static class Serializer implements RecipeSerializer<PortalRecipe>{
        public static final Serializer INSTANCE = new PortalRecipe.Serializer();
        public static final String ID = "portal_recipe";

        public static final Codec<PortalRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients")
                        .forGetter(PortalRecipe::getIngredients), RecipeCodecs.CRAFTING_RESULT.fieldOf("output")
                        .forGetter(r -> r.output)
        ).apply(in, PortalRecipe::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max){
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ?
                            DataResult.error(()-> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(()-> "Recipe has no ingredients!") : DataResult.success(list));
        }

        @Override
        public Codec<PortalRecipe> codec() {
            return CODEC;
        }

        @Override
        public PortalRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
            for(int i=0; i< inputs.size(); i++){
                inputs.set(i, Ingredient.fromPacket(buf));
            }
            ItemStack output = buf.readItemStack();
            return new PortalRecipe(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, PortalRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for(Ingredient ingredient : recipe.getIngredients()){
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.getResult(null));
        }
    }
}
