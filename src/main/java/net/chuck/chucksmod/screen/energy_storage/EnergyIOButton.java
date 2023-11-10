package net.chuck.chucksmod.screen.energy_storage;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class EnergyIOButton extends ClickableWidget {
    public AbstractEnergyStorageScreen screen;
    public final Identifier disabledTexture;
    public final Identifier insertTexture;
    public final Identifier extractTexture;
    public static final int WIDTH = 16;
    public static final int HEIGHT = WIDTH;
    public EnergyIOButton(AbstractEnergyStorageScreen screen, int x, int y, Text message,
                          Identifier disabledTexture, Identifier insertTexture, Identifier extractTexture) {
        super(x, y, WIDTH, HEIGHT, message);
        this.screen = screen;
        this.disabledTexture = disabledTexture;
        this.insertTexture = insertTexture;
        this.extractTexture = extractTexture;
    }

    @Override
    protected void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {

    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {

    }
}
