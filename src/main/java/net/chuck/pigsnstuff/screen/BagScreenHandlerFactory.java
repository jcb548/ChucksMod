package net.chuck.pigsnstuff.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class BagScreenHandlerFactory implements ExtendedScreenHandlerFactory {
    private final ItemStack itemStack;
    public BagScreenHandlerFactory (ItemStack itemStack){
        this.itemStack = itemStack;
    }
    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeItemStack(itemStack);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("title.pigsnstuff.bag");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new BagScreenHandler(syncId, playerInventory, itemStack);
    }
}
