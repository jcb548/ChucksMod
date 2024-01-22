package net.chuck.chucksmod.screen.bag;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractModScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public abstract class AbstractBagScreen<T extends AbstractBagScreenHandler> extends AbstractModScreen<T> {
    public AbstractBagScreen(T handler, PlayerInventory inventory, Text title, int titleY) {
        super(handler, inventory, title);
        this.playerInventoryTitleY = titleY;
    }
}
