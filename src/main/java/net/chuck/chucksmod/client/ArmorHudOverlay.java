package net.chuck.chucksmod.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ArmorHudOverlay implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext context, float tickDelta) {
        int x = 0;
        int y = 0;
        int playerArmor = 0;
        int armorValue = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if(client != null) {
            if(client.player != null){
                playerArmor = client.player.getArmor();
                armorValue = (int) Math.round(100*(1.0-(144.0/(Math.pow(playerArmor, 2) + 144))));
            }
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();
            x = width/2;
            y = height;
            int yAboveBottom = 48;
            if(client.player.isCreative()) yAboveBottom = 32;
                context.drawText(client.textRenderer, Text.literal("Armor: " + playerArmor +
                        " (-" + armorValue + "% Dmg)"), x - 90, y - yAboveBottom, 0xFFFFFF, true);
        }
    }
}
