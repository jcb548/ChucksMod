package net.chuck.chucksmod.screen.bag;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BagScreen7x2 extends AbstractBagScreen<BagScreenHandler7x2>{
    public BagScreen7x2(BagScreenHandler7x2 handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, ModScreenHandlers.DOUBLE_ROW_INV_TITLE);
    }

    @Override
    protected Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID,
                "textures/gui/bag/7x2_bag_gui.png");
    }
}
