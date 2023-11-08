package net.chuck.chucksmod.screen.generator;

import net.chuck.chucksmod.screen.crusher.AbstractCrusherScreenHandler;
import net.chuck.chucksmod.screen.renderer.EnergyInfoArea;
import net.chuck.chucksmod.util.MouseUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

import java.util.Optional;

public abstract class AbstractGeneratorScreen<T extends AbstractGeneratorScreenHandler> extends HandledScreen<T> {
    protected EnergyInfoArea energyInfoArea;
    public AbstractGeneratorScreen(T handler, PlayerInventory inventory, Text title) {
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
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        int x = (width-backgroundWidth)/2;
        int y = (height-backgroundHeight)/2;

        renderEnergyAreaToolTips(context, mouseX, mouseY, x, y);
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
