package net.chuck.chucksmod.screen.cleanser;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.entity.cleanser.AbstractCleanserBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreen;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.chuck.chucksmod.screen.renderer.FluidStackRenderer;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CleanserScreen extends AbstractEnergyCookerScreen<CleanserScreenHandler> {
    public CleanserScreen(CleanserScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture()  {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/cleanser_gui.png");
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
        if(handler.cleanser.getInventory().getStack(AbstractCleanserBlockEntity.INPUT_SLOT) != ItemStack.EMPTY)
            context.drawText(this.textRenderer, Text.literal(Integer.toString(handler.cleanser.getXpCost())),
                    97, 58, color, true);
    }
}
