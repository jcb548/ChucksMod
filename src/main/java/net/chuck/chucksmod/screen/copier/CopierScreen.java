package net.chuck.chucksmod.screen.copier;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.chuck.chucksmod.screen.renderer.XpInfoArea;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CopierScreen extends AbstractEnergyUsingScreen<CopierScreenHandler> {
    private XpInfoArea xpInfoArea;
    public static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/copier_gui.png");
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
        if(!(xpInfoArea.getXp() == handler.copier.xp)) assignXpArea();
        xpInfoArea.draw(context);
    }
    private void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(TEXTURE,x + 102, y + 37, 176, 68, handler.getScaledProgress(), 16);
        }
    }

    protected void assignXpArea(){
        xpInfoArea = new XpInfoArea(getX() + 12, getY() + 13,
                handler.copier.maxXp, handler.copier.xp,
                8, 46);
    }

    @Override
    protected void init() {
        super.init();
        drainXp = ButtonWidget.builder(Text.translatable("tooltip.chucksmod.drain_xp"), button -> {
            handler.onButtonPress();
        }).dimensions(getX() + 26, getY() + 16, 48, 16).build();
        this.addDrawableChild(drainXp);
        assignXpArea();
    }

    private void renderXpAreaToolTips(DrawContext context, int pMouseX, int pMouseY, int x, int y){
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 12, 13, 8, 46)){
            context.drawTooltip(this.client.textRenderer, xpInfoArea.getTooltips(), Optional.empty(),
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
