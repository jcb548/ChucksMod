package net.chuck.chucksmod.screen.generator;
import net.chuck.chucksmod.block.entity.generator.IronHeatGeneratorBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class IronHeatGeneratorScreenHandler extends AbstractGeneratorScreenHandler {
    public final IronHeatGeneratorBlockEntity blockEntity;
    public IronHeatGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(IronHeatGeneratorBlockEntity.DELEGATE_SIZE));
    }
    public IronHeatGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                          PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.IRON_HEAT_GENERATOR_SCREEN_HANDLER);
        this.blockEntity = (IronHeatGeneratorBlockEntity) entity;
    }
}