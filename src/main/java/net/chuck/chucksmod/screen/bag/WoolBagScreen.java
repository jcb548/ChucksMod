package net.chuck.chucksmod.screen.bag;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WoolBagScreen extends AbstractBagScreen<WoolBagScreenHandler>{
    public WoolBagScreen(WoolBagScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, 38);
    }

    @Override
    protected Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID,
                "textures/gui/bag/wool_bag_gui.png");
    }
}
