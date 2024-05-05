package net.chuck.chucksmod.screen.furnace;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreen;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PoweredFurnaceScreen extends AbstractEnergyCookerScreen<PoweredFurnaceScreenHandler> {
    public PoweredFurnaceScreen(PoweredFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    public Identifier getTexture() {
        return new Identifier(ChucksMod.MOD_ID, "textures/gui/powered_furnace_gui.png");
    }
}
