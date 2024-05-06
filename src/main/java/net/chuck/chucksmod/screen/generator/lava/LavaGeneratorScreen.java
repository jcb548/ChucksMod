package net.chuck.chucksmod.screen.generator.lava;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.generator.AbstractGeneratorScreen;
import net.chuck.chucksmod.screen.renderer.FluidStackRenderer;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LavaGeneratorScreen extends AbstractGeneratorScreen<LavaGeneratorScreenHandler> {
    public LavaGeneratorScreen(LavaGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/liquid_generator_gui.png");
    }

    @Override
    protected boolean fluidDisplay() {
        return true;
    }
    @Override
    protected void renderBurnFlames(DrawContext context, int x, int y){
        if(handler.isBurning()){
            context.drawTexture(getTexture(), x + 80, y+22, 176, 0,  14, 14);
        }
    }
}
