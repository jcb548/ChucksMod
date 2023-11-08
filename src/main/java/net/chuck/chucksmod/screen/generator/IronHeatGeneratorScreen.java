package net.chuck.chucksmod.screen.generator;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.renderer.EnergyInfoArea;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IronHeatGeneratorScreen extends AbstractHeatGeneratorScreen<IronHeatGeneratorScreenHandler> {
    public IronHeatGeneratorScreen(IronHeatGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    protected void assignEnergyInfoArea()  {
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth)/2) + 156,
                ((height - backgroundHeight) / 2) + 13, handler.blockEntity.energyStorage);
    }
}
