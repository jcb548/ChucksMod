package net.chuck.chucksmod.screen.energy_storage;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class EnergyIOButton extends PressableWidget {
    public final Identifier disabledTexture;
    public final Identifier insertTexture;
    public final Identifier extractTexture;
    public static final int WIDTH = 16;
    public static final int HEIGHT = WIDTH;
    public EnergyIOButton(int x, int y, Text message,
                          Identifier disabledTexture, Identifier insertTexture, Identifier extractTexture) {
        super(x, y, WIDTH, HEIGHT, message);
        this.disabledTexture = disabledTexture;
        this.insertTexture = insertTexture;
        this.extractTexture = extractTexture;
    }

    @Override
    public void onPress() {

    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {

    }
}
