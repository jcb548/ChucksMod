package net.chuck.chucksmod.screen.copier;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.chuck.chucksmod.screen.renderer.FluidStackRenderer;
import net.chuck.chucksmod.screen.renderer.XpInfoArea;
import net.chuck.chucksmod.util.FluidStack;
import net.chuck.chucksmod.util.MouseUtil;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CopierScreen extends AbstractEnergyUsingScreen<CopierScreenHandler> {
    private XpInfoArea xpInfoArea;
    public static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/copier_gui.png");
    private FluidStackRenderer fluidStackRenderer;
    protected ButtonWidget drainXp;
    public CopierScreen(CopierScreenHandler handler, PlayerInventory inventory, Text title) {
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
        fluidStackRenderer.drawFluid(context, handler.fluidStack, x+8, y+13, 15, 46,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*handler.copier.getXpCapacity());
    }
    private void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(TEXTURE,x + 102, y + 37, 176, 68, handler.getScaledProgress(), 16);
        }
    }

    protected void assignFluidStackRenderer(){
        fluidStackRenderer = new FluidStackRenderer
                (FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*handler.copier.getXpCapacity(),
                        true, 15, 46);
    }

    @Override
    protected void init() {
        super.init();
        drainXp = ButtonWidget.builder(Text.translatable("tooltip.chucksmod.drain_xp"), button -> {
            handler.onButtonPress();
        }).dimensions(getX() + 46, getY() + 16, 48, 16).build();
        this.addDrawableChild(drainXp);
        assignFluidStackRenderer();
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY,
                                     FluidStackRenderer renderer){
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x+offsetX, x+offsetY, renderer.getWidth(),
                renderer.getHeight());
    }

    private void renderXpAreaToolTips(DrawContext context, int pMouseX, int pMouseY, int x, int y){
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 8, 13, fluidStackRenderer.getWidth(), fluidStackRenderer.getHeight())){
            context.drawTooltip(this.client.textRenderer, fluidStackRenderer.getTooltip(handler.fluidStack,
                            TooltipContext.ADVANCED), Optional.empty(),
                    pMouseX-x, pMouseY-y);
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        renderXpAreaToolTips(context, mouseX, mouseY, getX(), getY());
        if(handler.copier.hasEnchantedBook()){
            context.drawText(this.textRenderer, Text.literal(Integer.toString(handler.copier.getXpCost())),
                    97, 58, 8453920, true);
        }
    }
}
