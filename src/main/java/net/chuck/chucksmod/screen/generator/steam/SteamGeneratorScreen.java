package net.chuck.chucksmod.screen.generator.steam;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SteamGeneratorScreen extends AbstractEnergyUsingScreen<SteamGeneratorScreenHandler> {
    public SteamGeneratorScreen(SteamGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID,
                "textures/gui/steam_generator_gui.png");
    }

    @Override
    protected boolean fluidDisplay() {
        return true;
    }
}
