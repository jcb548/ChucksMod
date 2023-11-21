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

public class EnergyStorageScreen extends HandledScreen<EnergyStorageScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(ChucksMod.MOD_ID,
            "textures/gui/energy_storage_gui.png");
    private ButtonWidget up;
    private ButtonWidget down;
    private ButtonWidget front;
    private ButtonWidget back;
    private ButtonWidget left;
    private ButtonWidget right;
    protected EnergyInfoArea energyInfoArea;
    public static final int BUTTON_WIDTH = 16;
    public static final int BUTTON_HEIGHT = BUTTON_WIDTH;
    private final int ROW_1_Y = 17;
    private final int COLUMN_1_X = 62;
    private final int ROW_2_Y = 35;
    private final int COLUMN_2_X = 80;
    private final int ROW_3_Y = 53;
    private final int COLUMN_3_X = 98;
    public EnergyStorageScreen(EnergyStorageScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
        assignEnergyInfoArea();
        up = ButtonWidget.builder(Text.literal("U"), button -> {
            handler.onButtonPress(DirectionEnergyIOProperty.UP_KEY);
        }).dimensions(getX() + COLUMN_2_X, getY() + ROW_1_Y,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        down = ButtonWidget.builder(Text.literal("D"), button -> {
            handler.onButtonPress(DirectionEnergyIOProperty.DOWN_KEY);
        }).dimensions(getX() + COLUMN_2_X, getY() + ROW_3_Y,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        front = ButtonWidget.builder(Text.literal("N"), button -> {
            handler.onButtonPress(handler.directionToGUISide(DirectionEnergyIOProperty.NORTH_KEY));
        }).dimensions(getX() + COLUMN_2_X, getY() + ROW_2_Y,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        back = ButtonWidget.builder(Text.literal("S"), button -> {
            handler.onButtonPress(handler.directionToGUISide(DirectionEnergyIOProperty.SOUTH_KEY));
        }).dimensions(getX() + COLUMN_3_X, getY() + ROW_3_Y,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        left = ButtonWidget.builder(Text.literal("E"), button -> {
            handler.onButtonPress(handler.directionToGUISide(DirectionEnergyIOProperty.EAST_KEY));
        }).dimensions(getX() + COLUMN_1_X, getY() + ROW_2_Y,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        right = ButtonWidget.builder(Text.literal("W"), button -> {
            handler.onButtonPress(handler.directionToGUISide(DirectionEnergyIOProperty.WEST_KEY));
        }).dimensions(getX() + COLUMN_3_X, getY() + ROW_2_Y,
                BUTTON_WIDTH, BUTTON_HEIGHT).build();
        this.addSelectableChild(up);
        this.addSelectableChild(down);
        this.addSelectableChild(front);
        this.addSelectableChild(back);
        this.addSelectableChild(left);
        this.addSelectableChild(right);
    }
    protected void assignEnergyInfoArea() {
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth)/2) + 156,
                ((height - backgroundHeight) / 2) + 13, handler.blockEntity.energyStorage.getSideStorage(null));
    }
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
        drawSideTextures(context, x, y);
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
    private int getIOOffset(byte id){
        if(handler.getSideState(id).equals(DirectionEnergyIOProperty.INSERT)){
            return BUTTON_HEIGHT;
        }
        if(handler.getSideState(id).equals(DirectionEnergyIOProperty.EXTRACT)){
            return 2*BUTTON_HEIGHT;
        }
        return 0;
    }
    private void drawSideTextures(DrawContext context, int x, int y){
        context.drawTexture(TEXTURE, x+COLUMN_2_X, y+ROW_1_Y,176, getIOOffset(DirectionEnergyIOProperty.UP_KEY),
                BUTTON_WIDTH, BUTTON_HEIGHT);
        context.drawTexture(TEXTURE, x+COLUMN_2_X,y+ROW_3_Y,  176, getIOOffset(DirectionEnergyIOProperty.DOWN_KEY),
                BUTTON_WIDTH, BUTTON_HEIGHT);
        context.drawTexture(TEXTURE, x+COLUMN_2_X,y+ROW_2_Y,  176,
                getIOOffset(handler.directionToGUISide(DirectionEnergyIOProperty.NORTH_KEY)),
                BUTTON_WIDTH, BUTTON_HEIGHT);
        context.drawTexture(TEXTURE, x+COLUMN_3_X, y+ROW_3_Y, 176,
                getIOOffset(handler.directionToGUISide(DirectionEnergyIOProperty.SOUTH_KEY)),
                BUTTON_WIDTH, BUTTON_HEIGHT);
        context.drawTexture(TEXTURE, x+COLUMN_1_X,y+ROW_2_Y,  176,
                getIOOffset(handler.directionToGUISide(DirectionEnergyIOProperty.EAST_KEY)),
                BUTTON_WIDTH, BUTTON_HEIGHT);
        context.drawTexture(TEXTURE, x+COLUMN_3_X,y+ROW_2_Y,  176,
                getIOOffset(handler.directionToGUISide(DirectionEnergyIOProperty.WEST_KEY)),
                BUTTON_WIDTH, BUTTON_HEIGHT);
    }
}
