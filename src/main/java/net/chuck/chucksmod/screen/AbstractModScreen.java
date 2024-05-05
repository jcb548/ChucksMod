package net.chuck.chucksmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.screen.renderer.FluidStackRenderer;
import net.chuck.chucksmod.util.FluidStack;
import net.chuck.chucksmod.util.MouseUtil;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public abstract class AbstractModScreen<T extends AbstractModScreenHandler> extends HandledScreen<T> {
    protected FluidStackRenderer fluidStackRenderer = null;
    public AbstractModScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    protected int getX(){
        return (width - backgroundWidth) /2;
    }

    protected int getY(){
        return (height - backgroundHeight) /2;
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    public void renderInGameBackground(DrawContext context) {
        context.fillGradient(0, 0, this.width, this.height, -0x7FEFEFF0, -0x6FEFEFF0);
    }

    public abstract Identifier getTexture();
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 1.0f);
        context.drawTexture(getTexture(), getX(), getY(), 0, 0, backgroundWidth, backgroundHeight);
        if(fluidDisplay()) {
            fluidStackRenderer.drawFluid(context, handler.fluidStack, x + getFluidXOffset(), y + getFluidYOffset(), 15, 48,
                    FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * handler.getFluidStoring().getBucketCapacity());
        }
    }
    protected boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY,
                                       int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x+offsetX, y+offsetY, width, height);
    }
    protected boolean fluidDisplay(){
        return false;
    }

    @Override
    protected void init() {
        super.init();
        assignFluidStackRenderer();
    }
    protected void assignFluidStackRenderer(){}
    private void renderFluidAreaToolTips(DrawContext context, int pMouseX, int pMouseY, int x, int y){
        if(fluidDisplay() && isMouseAboveArea(pMouseX, pMouseY, x, y, getFluidXOffset(), getFluidYOffset(),
                fluidStackRenderer.getWidth(), fluidStackRenderer.getHeight())){
            context.drawTooltip(this.client.textRenderer, fluidStackRenderer.getTooltip(handler.fluidStack,
                            TooltipContext.ADVANCED), Optional.empty(),
                    pMouseX-x, pMouseY-y);
        }
    }
    protected int getFluidXOffset(){
        return 8;
    }
    protected int getFluidYOffset(){
        return 13;
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        if(fluidDisplay()) {
            renderFluidAreaToolTips(context, mouseX, mouseY, getX(), getY());
        }
    }
}
