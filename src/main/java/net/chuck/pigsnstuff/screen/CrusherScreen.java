package net.chuck.pigsnstuff.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.pigsnstuff.PigsNStuff;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */

public class CrusherScreen extends HandledScreen<CrusherScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(PigsNStuff.MOD_ID,
            "textures/gui/crusher_gui.png");
    public CrusherScreen(CrusherScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        //RenderSystem.setShader(GameRenderer::getPositionProgram);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight)/2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        renderProgressArrow(context, x, y);
        renderBurnFlames(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(TEXTURE,x + 84, y + 35, 176, 0, 16, handler.getScaledProgress());
        }
    }
    private void renderBurnFlames(DrawContext context, int x, int y){
        if(handler.isBurning()){
            context.drawTexture(TEXTURE, x + 56, y+36+(12-handler.getScaledBurning()), 176, 17+(12-handler.getScaledBurning()),  14, handler.getScaledBurning() + 1);
        }
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
