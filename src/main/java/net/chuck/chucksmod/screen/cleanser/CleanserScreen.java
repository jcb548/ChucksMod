package net.chuck.chucksmod.screen.cleanser;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreen;
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

public class CleanserScreen extends AbstractEnergyCookerScreen<CleanserScreenHandler> {
    public CleanserScreen(CleanserScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture()  {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/cleanser_gui.png");
    }
    protected void assignFluidStackRenderer(){
        fluidStackRenderer = new FluidStackRenderer
                (FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*handler.cleanser.getBucketCapacity(),
                        true, 15, 48);
    }
    @Override
    protected boolean fluidDisplay() {
        return true;
    }
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        int color = 0xCC0000;
        if(handler.cleanser.hasRecipe()) color = 8453920;
        context.drawText(this.textRenderer, Text.literal(Integer.toString(handler.cleanser.getXpCost())),
                    97, 58, color, true);
    }
}
