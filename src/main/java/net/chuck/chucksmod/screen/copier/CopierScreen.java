package net.chuck.chucksmod.screen.copier;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreen;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.chuck.chucksmod.screen.renderer.FluidStackRenderer;
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

public class CopierScreen extends AbstractEnergyCookerScreen<CopierScreenHandler> {
    private FluidStackRenderer fluidStackRenderer;
    public CopierScreen(CopierScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/copier_gui.png");
    }
    @Override
    protected void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(getTexture(),x + 102, y + 37, 176, 68, handler.getScaledProgress(22), 16);
        }
    }
    protected void assignFluidStackRenderer(){
        fluidStackRenderer = new FluidStackRenderer
                (FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*handler.copier.getBucketCapacity(),
                        true, 15, 48);
    }
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        if(handler.copier.hasEnchantedBook()){
            context.drawText(this.textRenderer, Text.literal(Integer.toString(handler.copier.getXpCost())),
                    97, 58, 8453920, true);
        }
    }
}
