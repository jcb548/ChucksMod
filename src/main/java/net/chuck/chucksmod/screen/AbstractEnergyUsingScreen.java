package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.screen.renderer.EnergyInfoArea;
import net.chuck.chucksmod.util.MouseUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

import java.util.Optional;

public abstract class AbstractEnergyUsingScreen<T extends AbstractEnergyUsingScreenHandler> extends AbstractModScreen<T> {
    protected EnergyInfoArea energyInfoArea;
    public AbstractEnergyUsingScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
        assignEnergyInfoArea();
    }
    protected void assignEnergyInfoArea() {
        energyInfoArea = new EnergyInfoArea(getX() + 156, getY() + 13,
                handler.blockEntity.energyStorage);
    }
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        renderEnergyAreaToolTips(context, mouseX, mouseY, getX(), getY());
    }
    private void renderEnergyAreaToolTips(DrawContext context, int pMouseX, int pMouseY, int x, int y){
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 13, 8, 64)){
            context.drawTooltip(this.client.textRenderer, energyInfoArea.getTooltips(), Optional.empty(),
                    pMouseX-x, pMouseY-y);
        }
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        super.drawBackground(context, delta, mouseX, mouseY);
        energyInfoArea.draw(context);
    }
}
