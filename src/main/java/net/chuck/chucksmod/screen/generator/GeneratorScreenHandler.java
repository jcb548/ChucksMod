package net.chuck.chucksmod.screen.generator;
import net.chuck.chucksmod.block.entity.generator.IronHeatGeneratorBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class GeneratorScreenHandler extends AbstractGeneratorScreenHandler {
    public final IronHeatGeneratorBlockEntity blockEntity;
    public GeneratorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(IronHeatGeneratorBlockEntity.DELEGATE_SIZE));
    }
    public GeneratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                        PropertyDelegate delegate) {
        super(syncId, playerInventory, entity,delegate, ModScreenHandlers.GENERATOR_SCREEN_HANDLER);
        this.blockEntity = (IronHeatGeneratorBlockEntity) entity;
    }
}