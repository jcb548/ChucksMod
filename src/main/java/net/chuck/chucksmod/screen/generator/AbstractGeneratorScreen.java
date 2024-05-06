package net.chuck.chucksmod.screen.generator;

import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public abstract class AbstractGeneratorScreen<T extends GeneratorScreenHandler> extends AbstractEnergyUsingScreen<T> {
    public AbstractGeneratorScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        super.drawBackground(context, delta, mouseX, mouseY);
        renderBurnFlames(context, getX(), getY());
    }
    protected void renderBurnFlames(DrawContext context, int x, int y){
        if(handler.isBurning()){
            context.drawTexture(getTexture(), x + 80, y+22+(12-handler.getScaledBurning()), 176,
                    (12-handler.getScaledBurning()),  14, handler.getScaledBurning() + 1);
        }
    }
}
