package net.chuck.chucksmod.screen.bag;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public abstract class AbstractBagScreen<T extends AbstractBagScreenHandler> extends HandledScreen<T> {
    public AbstractBagScreen(T handler, PlayerInventory inventory, Text title, int titleY) {
        super(handler, inventory, title);
        this.playerInventoryTitleY = titleY;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight)/2;
        context.drawTexture(getTexture(), x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    protected abstract Identifier getTexture();
}
