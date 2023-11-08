package net.chuck.chucksmod.screen.generator;

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

public class GeneratorScreen extends AbstractGeneratorScreen<GeneratorScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/generator_gui.png");
    public GeneratorScreen(GeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void assignEnergyInfoArea()  {
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth)/2) + 156,
                ((height - backgroundHeight) / 2) + 13, handler.blockEntity.energyStorage);
    }
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight)/2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        renderBurnFlames(context, x, y);
        energyInfoArea.draw(context);
    }
    private void renderBurnFlames(DrawContext context, int x, int y){
        if(handler.isBurning()){
            context.drawTexture(TEXTURE, x + 80, y+22+(12-handler.getScaledBurning()), 176, (12-handler.getScaledBurning()),  14, handler.getScaledBurning() + 1);
        }
    }
}
