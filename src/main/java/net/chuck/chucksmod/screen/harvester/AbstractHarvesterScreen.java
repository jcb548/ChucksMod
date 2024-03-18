package net.chuck.chucksmod.screen.harvester;

import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public abstract class AbstractHarvesterScreen <T extends AbstractHarvesterScreenHandler> extends AbstractEnergyUsingScreen<T> {
    public AbstractHarvesterScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
