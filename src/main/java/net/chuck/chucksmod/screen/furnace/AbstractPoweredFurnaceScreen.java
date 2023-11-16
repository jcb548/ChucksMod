package net.chuck.chucksmod.screen.furnace;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.renderer.EnergyInfoArea;
import net.chuck.chucksmod.util.MouseUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public abstract class AbstractPoweredFurnaceScreen<T extends AbstractPoweredFurnaceScreenHandler> extends HandledScreen<T> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/powered_furnace_gui.png");
    protected EnergyInfoArea energyInfoArea;
    public AbstractPoweredFurnaceScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
        assignEnergyInfoArea();
    }
    protected abstract void assignEnergyInfoArea();
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        int x = (width-backgroundWidth)/2;
        int y = (height-backgroundHeight)/2;
        renderEnergyAreaToolTips(context, mouseX, mouseY, x, y);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight)/2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        renderProgressArrow(context, x, y);
        energyInfoArea.draw(context);
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
    private void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(TEXTURE,x + 79, y + 34, 176, 0, handler.getScaledProgress(), 17);
        }
    }
    private void renderEnergyAreaToolTips(DrawContext context, int pMouseX, int pMouseY, int x, int y){
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 13, 8, 64)){
            context.drawTooltip(this.client.textRenderer, energyInfoArea.getTooltips(), Optional.empty(),
                    pMouseX-x, pMouseY-y);
        }
    }
    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY,
                                     int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x+offsetX, y+offsetY, width, height);
    }
}