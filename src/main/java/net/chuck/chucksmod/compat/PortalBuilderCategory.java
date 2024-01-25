package net.chuck.chucksmod.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

//done with help:
//https://github.com/TeamGalacticraft/Galacticraft/tree/main (MIT License)

public class PortalBuilderCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/rei_displays.png");
    public static final CategoryIdentifier<PortalBuilderDisplay> PORTAL_BUILDER =
            CategoryIdentifier.of(ChucksMod.MOD_ID, "portal_builder");
    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return PORTAL_BUILDER;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("title.chucksmod.portal_builder");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.FABIUM_PORTAL_BUILDER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX()-87, bounds.getCenterY()-35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x+25, startPoint.y+7,
                125, 64), 0, 36));
        widgets.add(Widgets.createSlot(new Point(startPoint.x+72, startPoint.y+31))
                .entries(display.getInputEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x+31, startPoint.y+13))
                .entries(display.getInputEntries().get(1)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x+31, startPoint.y+49))
                .entries(display.getInputEntries().get(2)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x+124, startPoint.y+31))
                .markOutput().entries(display.getOutputEntries().get(0)));

        widgets.add(new AnimatedWidget(TEXTURE, new Rectangle(startPoint.x+92, startPoint.y+30,
                24, 17),125, 36, true));
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 68;
    }
}
