package net.chuck.chucksmod.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.chuck.chucksmod.screen.crusher.CrusherScreen;
import net.minecraft.registry.Registry;

public class ChucksModREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CrusherCategory());
        registry.addWorkstations(CrusherCategory.CRUSHER, EntryStacks.of(ModBlocks.CRUSHER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CrusherRecipe.class, CrusherRecipe.Type.INSTANCE,
                CrusherDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30),
                CrusherScreen.class, CrusherCategory.CRUSHER);
    }
}
