package net.chuck.chucksmod.screen.energy_storage;

import net.chuck.chucksmod.screen.renderer.EnergyInfoArea;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class IronEnergyStorageScreen extends AbstractEnergyStorageScreen<IronEnergyStorageScreenHandler> {
    public IronEnergyStorageScreen(IronEnergyStorageScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void assignEnergyInfoArea() {
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth)/2) + 156,
                ((height - backgroundHeight) / 2) + 13, handler.blockEntity.energyStorage.getSideStorage(null));
    }
}
