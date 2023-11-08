package net.chuck.chucksmod.screen.generator;

import net.chuck.chucksmod.screen.renderer.EnergyInfoArea;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class TitaniumHeatGeneratorScreen extends AbstractHeatGeneratorScreen<TitaniumHeatGeneratorScreenHandler> {
    public TitaniumHeatGeneratorScreen(TitaniumHeatGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    protected void assignEnergyInfoArea()  {
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth)/2) + 156,
                ((height - backgroundHeight) / 2) + 13, handler.blockEntity.energyStorage);
    }
}
