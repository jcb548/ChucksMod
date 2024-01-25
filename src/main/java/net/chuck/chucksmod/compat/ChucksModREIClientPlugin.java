package net.chuck.chucksmod.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.chuck.chucksmod.recipe.PortalRecipe;
import net.chuck.chucksmod.screen.crusher.CrusherScreen;
import net.chuck.chucksmod.screen.portal_builder.PortalBuilderScreen;

public class ChucksModREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CrusherCategory());
        registry.addWorkstations(CrusherCategory.CRUSHER, EntryStacks.of(ModBlocks.CRUSHER),
                EntryStacks.of(ModBlocks.IRON_POWERED_CRUSHER), EntryStacks.of(ModBlocks.TITANIUM_POWERED_CRUSHER));
        registry.add(new PortalBuilderCategory());
        registry.addWorkstations(PortalBuilderCategory.PORTAL_BUILDER, EntryStacks.of(ModBlocks.FABIUM_PORTAL_BUILDER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CrusherRecipe.class, CrusherRecipe.Type.INSTANCE,
                CrusherDisplay::new);
        registry.registerRecipeFiller(PortalRecipe.class, PortalRecipe.Type.INSTANCE,
                PortalBuilderDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30),
                CrusherScreen.class, CrusherCategory.CRUSHER);
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30),
                PortalBuilderScreen.class, PortalBuilderCategory.PORTAL_BUILDER);
    }
}
