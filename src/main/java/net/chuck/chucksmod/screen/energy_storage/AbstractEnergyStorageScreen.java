package net.chuck.chucksmod.screen.energy_storage;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.screen.renderer.EnergyInfoArea;
import net.chuck.chucksmod.util.DirectionEnergyIOProperty;
import net.chuck.chucksmod.util.MouseUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public abstract class AbstractEnergyStorageScreen<T extends AbstractEnergyStorageScreenHandler> extends HandledScreen<T> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/energy_storage_gui.png");
    private ButtonWidget up;
    private ButtonWidget down;
    private ButtonWidget north;
    private ButtonWidget south;
    private ButtonWidget east;
    private ButtonWidget west;
    protected EnergyInfoArea energyInfoArea;
    public static final int BUTTON_WIDTH = 16;
    public static final int BUTTON_HEIGHT = BUTTON_WIDTH;
    public AbstractEnergyStorageScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
        assignEnergyInfoArea();
        up = ButtonWidget.builder(Text.literal("U"), button -> {
            handler.onButtonPress(DirectionEnergyIOProperty.UP_KEY);
        }).dimensions(getX() + 80, getY() + 17,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        down = ButtonWidget.builder(Text.literal("D"), button -> {
            handler.onButtonPress(DirectionEnergyIOProperty.DOWN_KEY);
        }).dimensions(getX() + 80, getY() + 53,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        north = ButtonWidget.builder(Text.literal("N"), button -> {
            handler.onButtonPress(DirectionEnergyIOProperty.NORTH_KEY);
        }).dimensions(getX() + 80, getY() + 35,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        south = ButtonWidget.builder(Text.literal("S"), button -> {
            handler.onButtonPress(DirectionEnergyIOProperty.SOUTH_KEY);
        }).dimensions(getX() + 98, getY() + 53,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        east = ButtonWidget.builder(Text.literal("E"), button -> {
            handler.onButtonPress(DirectionEnergyIOProperty.EAST_KEY);
        }).dimensions(getX() + 62, getY() + 35,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        west = ButtonWidget.builder(Text.literal("W"), button -> {
            handler.onButtonPress(DirectionEnergyIOProperty.WEST_KEY);
        }).dimensions(getX() + 98, getY() + 35,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        this.addDrawableChild(up);
        this.addDrawableChild(down);
        this.addDrawableChild(north);
        this.addDrawableChild(south);
        this.addDrawableChild(east);
        this.addDrawableChild(west);
    }
    protected abstract void assignEnergyInfoArea();
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        renderEnergyAreaToolTips(context, mouseX, mouseY, getX(), getY());
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        context.drawTexture(TEXTURE, getX(), getY(), 0, 0, backgroundWidth, backgroundHeight);
        energyInfoArea.draw(context);
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
    private void renderEnergyAreaToolTips(DrawContext context, int pMouseX, int pMouseY, int x, int y){
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 13, 8, 64)){
            context.drawTooltip(this.client.textRenderer, energyInfoArea.getTooltips(), Optional.empty(),
                    pMouseX-x, pMouseY-y);
        }
    }
    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY,
                                     int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x+offsetX, y+offsetY, width, height);
    }

    protected int getX(){
        return (width - backgroundWidth) /2;
    }

    protected int getY(){
        return (height - backgroundHeight) /2;
    }
}
