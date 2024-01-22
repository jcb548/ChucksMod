package net.chuck.chucksmod.screen.crusher;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PoweredCrusherScreen extends AbstractEnergyUsingScreen<PoweredCrusherScreenHandler> {
    public PoweredCrusherScreen(PoweredCrusherScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID,
                "textures/gui/powered_crusher_gui.png");
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        super.drawBackground(context, delta, mouseX, mouseY);
        renderProgressArrow(context, getX(), getY());
    }

    private void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(getTexture(),x + 84, y + 35, 176, 0, 16, handler.getScaledProgress());
        }
    }
}
