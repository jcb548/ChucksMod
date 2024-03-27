package net.chuck.chucksmod.screen.harvester;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TriafiumHarvesterScreen extends AbstractHarvesterScreen<TriafiumHarvesterScreenHandler>{
    public TriafiumHarvesterScreen(TriafiumHarvesterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/harvester/triafium_harvester_gui.png");
    }
}
