package net.chuck.chucksmod.screen.furnace;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PoweredFurnaceScreen extends AbstractEnergyUsingScreen<PoweredFurnaceScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/powered_furnace_gui.png");
    public PoweredFurnaceScreen(PoweredFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
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
    private void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(TEXTURE,x + 79, y + 34, 176, 0, handler.getScaledProgress(), 17);
        }
    }
}
