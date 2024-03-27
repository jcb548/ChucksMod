package net.chuck.chucksmod.screen.quarry;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TriafiumQuarryScreen extends AbstractQuarryScreen<TriafiumQuarryScreenHandler> {
    public TriafiumQuarryScreen(TriafiumQuarryScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = 175;
    }

    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/quarry/triafium_quarry_gui.png");
    }

    @Override
    protected int getResetButtonY() {
        return 73;
    }
}
