package net.chuck.chucksmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.util.MouseUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public abstract class AbstractModScreen<T extends AbstractModScreenHandler> extends HandledScreen<T> {
    public AbstractModScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    protected int getX(){
        return (width - backgroundWidth) /2;
    }

    protected int getY(){
        return (height - backgroundHeight) /2;
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    public void renderInGameBackground(DrawContext context) {
        context.fillGradient(0, 0, this.width, this.height, -0x7FEFEFF0, -0x6FEFEFF0);
    }

    public abstract Identifier getTexture();
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 1.0f);
        context.drawTexture(getTexture(), getX(), getY(), 0, 0, backgroundWidth, backgroundHeight);
    }
    protected boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY,
                                       int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x+offsetX, y+offsetY, width, height);
    }
}
