package net.chuck.pigsnstuff.item.custom;

import net.chuck.pigsnstuff.item.ModItems;
import net.chuck.pigsnstuff.screen.BagScreenHandlerFactory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BagItem extends Item{
    public static final int INV_SIZE = 9;
    public BagItem(Settings settings) {
        super(settings.maxCount(1));
    }
    public static final String ITEMS_KEY = "Items";

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if (world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        NamedScreenHandlerFactory screenHandlerFactory = new BagScreenHandlerFactory(itemStack);
        user.openHandledScreen(screenHandlerFactory);
        return TypedActionResult.consume(itemStack);
    }
}
