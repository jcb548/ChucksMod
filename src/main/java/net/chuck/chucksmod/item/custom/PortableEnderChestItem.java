package net.chuck.chucksmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PortableEnderChestItem extends Item {
    private static final Text CONTAINER_NAME = Text.translatable("container.enderchest");
    public PortableEnderChestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        user.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, playerInventory, player) ->
                GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, user.getEnderChestInventory()),
                CONTAINER_NAME));
        return TypedActionResult.consume(itemStack);

    }
}
