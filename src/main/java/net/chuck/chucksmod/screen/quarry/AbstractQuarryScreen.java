package net.chuck.chucksmod.screen.quarry;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public abstract class AbstractQuarryScreen<T extends AbstractQuarryScreenHandler> extends AbstractEnergyUsingScreen<T> {
    public static final int BUTTON_WIDTH = 16;
    public static final int BUTTON_HEIGHT = BUTTON_WIDTH;
    protected ButtonWidget reset;
    public AbstractQuarryScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    protected int getResetButtonX(){
        return 134;
    }
    protected int getResetButtonY(){
        return 64;
    }

    @Override
    protected void init() {
        super.init();
        reset = ButtonWidget.builder(Text.literal("R"), button -> {
            handler.onButtonPress();
        }).dimensions(getX() + getResetButtonX(), getY()+getResetButtonY(), BUTTON_WIDTH, BUTTON_HEIGHT).build();
        reset.setTooltip(Tooltip.of(Text.translatable("tooltip.chucksmod.reset_quarry")));
        this.addSelectableChild(reset);
    }
}
