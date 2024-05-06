package net.chuck.chucksmod.screen.portal_builder;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreen;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PortalBuilderScreen extends AbstractEnergyCookerScreen<PortalBuilderScreenHandler> {
    public PortalBuilderScreen(PortalBuilderScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/portal_builder_gui.png");
    }

    @Override
    protected void renderProgressArrow(DrawContext context, int x, int y){
        if(handler.isCrafting()){
            context.drawTexture(getTexture(),x + 85, y + 33, 176, 0, handler.getScaledProgress(24), 17);
        }
    }
}
