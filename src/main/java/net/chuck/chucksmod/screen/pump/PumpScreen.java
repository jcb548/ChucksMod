package net.chuck.chucksmod.screen.pump;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PumpScreen extends AbstractEnergyUsingScreen<PumpScreenHandler> {
    public PumpScreen(PumpScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    protected boolean fluidDisplay() {
        return true;
    }
    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/pump_gui.png");
    }
}
