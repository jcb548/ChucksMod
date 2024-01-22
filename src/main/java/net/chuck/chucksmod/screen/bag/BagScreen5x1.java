package net.chuck.chucksmod.screen.bag;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BagScreen5x1 extends AbstractBagScreen<BagScreenHandler5x1>{
    public BagScreen5x1(BagScreenHandler5x1 handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, ModScreenHandlers.SINGLE_ROW_INV_TITLE);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/bag/5x1_bag_gui.png");
    }
}
