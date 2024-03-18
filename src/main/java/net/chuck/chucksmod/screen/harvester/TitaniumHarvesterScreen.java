package net.chuck.chucksmod.screen.harvester;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TitaniumHarvesterScreen extends AbstractHarvesterScreen<TitaniumHarvesterScreenHandler>{
    public TitaniumHarvesterScreen(TitaniumHarvesterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/harvester/titanium_harvester_gui.png");
    }
}
