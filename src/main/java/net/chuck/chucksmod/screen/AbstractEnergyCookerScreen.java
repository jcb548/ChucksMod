package net.chuck.chucksmod.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public abstract class AbstractEnergyCookerScreen<T extends AbstractEnergyCookerScreenHandler> extends AbstractEnergyUsingScreen<T>{
    public AbstractEnergyCookerScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        super.drawBackground(context, delta, mouseX, mouseY);
        renderProgressArrow(context, getX(), getY());
    }
    protected void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(getTexture(),x + 79, y + 34, 176, 0, handler.getScaledProgress(24), 17);
        }
    }
}
