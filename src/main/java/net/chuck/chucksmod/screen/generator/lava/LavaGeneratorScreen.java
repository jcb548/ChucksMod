package net.chuck.chucksmod.screen.generator.lava;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.chuck.chucksmod.screen.renderer.FluidStackRenderer;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class LavaGeneratorScreen extends AbstractEnergyUsingScreen<LavaGeneratorScreenHandler> {
    private FluidStackRenderer fluidStackRenderer;
    public LavaGeneratorScreen(LavaGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/liquid_generator_gui.png");
    }
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        super.drawBackground(context, delta, mouseX, mouseY);
        renderBurnFlames(context, getX(), getY());
        fluidStackRenderer.drawFluid(context, handler.fluidStack, x+8, y+13, 15, 48,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*handler.getFluidStoring().getBucketCapacity());
    }
    protected void assignFluidStackRenderer(){
        fluidStackRenderer = new FluidStackRenderer
                (FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*handler.getFluidStoring().getBucketCapacity(),
                        true, 15, 48);
    }

    @Override
    protected void init() {
        super.init();
        assignFluidStackRenderer();
    }
    private void renderFluidAreaToolTips(DrawContext context, int pMouseX, int pMouseY, int x, int y){
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 8, 13, fluidStackRenderer.getWidth(), fluidStackRenderer.getHeight())){
            context.drawTooltip(this.client.textRenderer, fluidStackRenderer.getTooltip(handler.fluidStack,
                            TooltipContext.ADVANCED), Optional.empty(),
                    pMouseX-x, pMouseY-y);
        }
    }
    private void renderBurnFlames(DrawContext context, int x, int y){
        if(handler.isBurning()){
            context.drawTexture(getTexture(), x + 80, y+22, 176, 0,  14, 14);
        }
    }
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        renderFluidAreaToolTips(context, mouseX, mouseY, getX(), getY());
    }
}
