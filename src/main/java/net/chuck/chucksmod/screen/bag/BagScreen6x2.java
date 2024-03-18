package net.chuck.chucksmod.screen.bag;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BagScreen6x2 extends AbstractBagScreen<BagScreenHandler6x2>{
    public BagScreen6x2(BagScreenHandler6x2 handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, ModScreenHandlers.DOUBLE_ROW_INV_TITLE);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID,
                "textures/gui/bag/6x2_bag_gui.png");
    }
}
