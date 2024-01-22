package net.chuck.chucksmod.screen.generator.heat;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.chuck.chucksmod.screen.generator.GeneratorScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HeatGeneratorScreen extends AbstractEnergyUsingScreen<GeneratorScreenHandler> {
    public HeatGeneratorScreen(GeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/generator_gui.png");
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        super.drawBackground(context, delta, mouseX, mouseY);
        renderBurnFlames(context, getX(), getY());
    }
    private void renderBurnFlames(DrawContext context, int x, int y){
        if(handler.isBurning()){
            context.drawTexture(getTexture(), x + 80, y+22+(12-handler.getScaledBurning()), 176, (12-handler.getScaledBurning()),  14, handler.getScaledBurning() + 1);
        }
    }
}
