package net.chuck.chucksmod.screen.quarry;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TitaniumQuarryScreen extends AbstractQuarryScreen<TitaniumQuarryScreenHandler> {
    public TitaniumQuarryScreen(TitaniumQuarryScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/quarry/titanium_quarry_gui.png");
    }
}
