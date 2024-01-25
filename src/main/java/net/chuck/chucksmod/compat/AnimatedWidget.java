package net.chuck.chucksmod.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.DrawableConsumer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.WidgetWithBounds;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AnimatedWidget extends WidgetWithBounds {
    private final int TICKS_UNTIL_UPDATE = 10;
    private int displayProgress = 0;
    private int ticksUntilUpdate = TICKS_UNTIL_UPDATE;
    private final Identifier texture;
    private final Rectangle bounds;
    private final int x;
    private final int y;
    private boolean horizontal;
    public AnimatedWidget(Identifier texture, Rectangle bounds, int x, int y, boolean horizontal){
        this.texture = texture;
        this.bounds = Objects.requireNonNull(bounds);
        this.x = x;
        this.y = y;
        this.horizontal = horizontal;
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        if(horizontal) context.drawTexture(texture, bounds.x, bounds.y, x, y, displayProgress, bounds.height);
        else context.drawTexture(texture, bounds.x, bounds.y, x, y, bounds.width, displayProgress);
        ticksUntilUpdate--;
        if(ticksUntilUpdate <=0) {
            ticksUntilUpdate = TICKS_UNTIL_UPDATE;
            displayProgress++;
            if((horizontal && displayProgress > bounds.width) ||
                    (!horizontal && displayProgress > bounds.height)) displayProgress = 0;
        }
    }

    @Override
    public List<? extends Element> children() {
        return Collections.emptyList();
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }
}
