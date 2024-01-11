package net.chuck.chucksmod.screen.pump;

import com.mojang.blaze3d.systems.RenderSystem;
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

public class PumpScreen extends AbstractEnergyUsingScreen<PumpScreenHandler> {
    private FluidStackRenderer fluidStackRenderer;
    public static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/pump_gui.png");
    public PumpScreen(PumpScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight)/2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        energyInfoArea.draw(context);
        fluidStackRenderer.drawFluid(context, handler.fluidStack, x+8, y+13, 15, 48,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*handler.pump.getBucketCapacity());
    }
    protected void assignFluidStackRenderer(){
        fluidStackRenderer = new FluidStackRenderer
                (FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*handler.pump.getBucketCapacity(),
                        true, 15, 48);
    }

    @Override
    protected void init() {
        super.init();
        assignFluidStackRenderer();
    }

    private void renderFluidAreaToolTips(DrawContext context, int pMouseX, int pMouseY, int x, int y){
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 8, 13, fluidStackRenderer.getWidth(),
                fluidStackRenderer.getHeight())){
            context.drawTooltip(this.client.textRenderer, fluidStackRenderer.getTooltip(handler.fluidStack,
                            TooltipContext.ADVANCED), Optional.empty(),
                    pMouseX-x, pMouseY-y);
        }
    }
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        renderFluidAreaToolTips(context, mouseX, mouseY, getX(), getY());
    }
}
