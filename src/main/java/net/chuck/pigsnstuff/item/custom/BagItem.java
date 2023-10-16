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
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
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
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        if(!itemStack.hasNbt()){
            NbtCompound nbt_temp = new NbtCompound();
            Inventories.writeNbt(nbt_temp, DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY));
            itemStack.setSubNbt(ITEMS_KEY, nbt_temp);
        }
        NbtCompound nbt = itemStack.getNbt();

        DefaultedList<ItemStack> nbtInventory = DefaultedList.ofSize(BagItem.INV_SIZE, ItemStack.EMPTY);
        if (nbt.contains(ITEMS_KEY, NbtElement.LIST_TYPE)) {
            Inventories.readNbt(nbt, nbtInventory);
        }
        Inventory inventory = ItemInventory.of(nbtInventory);
        NamedScreenHandlerFactory screenHandlerFactory = new BagScreenHandlerFactory(itemStack);
        user.openHandledScreen(screenHandlerFactory);
        return TypedActionResult.consume(itemStack);
    }

    public static ItemStack createBag(PlayerEntity user, Hand hand){
        ItemStack new_bag = new ItemStack(ModItems.BAG);
        return new_bag;
    }
}
