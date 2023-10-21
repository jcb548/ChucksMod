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

public class CrusherCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/crusher_gui.png");
    public static final CategoryIdentifier<CrusherDisplay> CRUSHER =
            CategoryIdentifier.of(ChucksMod.MOD_ID, "crusher");
    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return CRUSHER;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.chucksmod.crusher");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.CRUSHER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX()-87, bounds.getCenterY()-35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y,
                175, 82)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x+56, startPoint.y+17))
                .entries(display.getInputEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x+116, startPoint.y+35))
                .markOutput().entries(display.getOutputEntries().get(0)));
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return DisplayCategory.super.getDisplayHeight();
    }
}
