package net.chuck.chucksmod.screen.renderer;

import net.chuck.chucksmod.screen.copier.CopierScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.Rect2i;
import net.minecraft.text.Text;
import team.reborn.energy.api.EnergyStorage;

import java.util.List;

/*
 *  BluSunrize
 *  Copyright (c) 2021
 *
 *  This code is licensed under "Blu's License of Common Sense" (FORGE VERSION)
 *  Details can be found in the license file in the root folder of this project
 */
public class XpInfoArea extends InfoArea {
    private final int maxXp;
    private int xp;

    public XpInfoArea(int xMin, int yMin)  {
        this(xMin, yMin, 0, 0,8,64);
    }

    public XpInfoArea(int xMin, int yMin, int maxXp, int xp)  {
        this(xMin, yMin, maxXp, xp,8,64);
    }

    public XpInfoArea(int xMin, int yMin, int maxXp, int xp, int width, int height)  {
        super(new Rect2i(xMin, yMin, width, height));
        this.maxXp = maxXp;
        this.xp = xp;
    }

    public List<Text> getTooltips() {
        return List.of(Text.literal(xp+"/"+maxXp+" XP"));
    }

    @Override
    public void draw(DrawContext context) {
        final int height = area.getHeight();
        int stored = (int)(height*((1.0f*xp/(1.0f*maxXp))));
        context.drawTexture(CopierScreen.TEXTURE, area.getX(), area.getY()+(height-stored),
                176, (height-stored), 8, stored);
    }
}