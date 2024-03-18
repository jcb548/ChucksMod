package net.chuck.chucksmod.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class ArmorHudOverlay implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext context, float tickDelta) {
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
            int x = width/2;
            int yAboveBottom = height - 39;
            float maxHealth = Math.max((float)client.player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH),
                    MathHelper.ceil(client.player.getHealth()));
            int playerAbsorption = MathHelper.ceil(client.player.getAbsorptionAmount());
            int healthRows = MathHelper.ceil((maxHealth + (float)playerAbsorption) / 2.0f / 10.0f);
            int rowHeight = Math.max(10 - (healthRows - 2), 3);
            int y = yAboveBottom - (healthRows - 1) * rowHeight - 10;
            if(client.player.isCreative()) y = height - 32;
            context.drawText(client.textRenderer, Text.literal("Armor: " + playerArmor +
                    " (-" + armorValue + "% Dmg)"), x - 90, y, 0xFFFFFF, true);
        }
    }
}
