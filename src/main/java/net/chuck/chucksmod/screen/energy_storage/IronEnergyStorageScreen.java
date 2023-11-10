package net.chuck.chucksmod.screen.energy_storage;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.renderer.EnergyInfoArea;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IronEnergyStorageScreen extends AbstractEnergyStorageScreen<IronEnergyStorageScreenHandler> {
    private static final Identifier DISABLED = new Identifier(ChucksMod.MOD_ID,
            "textures/block/iron_energy_storage.png");
    private static final Identifier INSERT = new Identifier(ChucksMod.MOD_ID,
            "textures/block/iron_energy_storage_in.png");
    private static final Identifier EXTRACT = new Identifier(ChucksMod.MOD_ID,
            "textures/block/iron_energy_storage_out.png");
    public IronEnergyStorageScreen(IronEnergyStorageScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        up = new EnergyIOButton(this, 79, 17, Text.literal("Up")
                ,DISABLED, INSERT, EXTRACT);
    }

    @Override
    protected void assignEnergyInfoArea() {
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth)/2) + 156,
                ((height - backgroundHeight) / 2) + 13, handler.blockEntity.energyStorage.getSideStorage(null));
    }
}
