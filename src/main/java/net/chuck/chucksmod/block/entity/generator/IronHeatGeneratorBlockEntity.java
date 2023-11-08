package net.chuck.chucksmod.block.entity.generator;
import net.chuck.chucksmod.block.custom.generator.IronHeatGeneratorBlock;
import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.screen.generator.GeneratorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class IronHeatGeneratorBlockEntity extends AbstractGeneratorBlockEntity {
    public static final int FUEL_SLOT = 0;

    public static final int INV_SIZE = 1;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY);
    public static final int MAX_INSERT = 32;
    public static final int MAX_EXTRACT = MAX_INSERT;
    public static final int GENERATION = MAX_EXTRACT;
    public static final Map<Item, Integer> FUELS = AbstractFurnaceBlockEntity.createFuelTimeMap();
    public static final int ENERGY_STORAGE = 10000;
    public IronHeatGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_HEAT_GENERATOR, pos, state, GENERATION, ENERGY_STORAGE);
    }
    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        }
        Item item = fuel.getItem();
        return FUELS.getOrDefault(item, 0)/4;
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.iron_heat_generator");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new GeneratorScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
    // For saving nbt on world close
    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);

    }

    @Override
    protected void useFuel() {
        if (this.getFuelTime(this.inventory.get(FUEL_SLOT)) > 0){
            this.fuelTime = this.getFuelTime(this.inventory.get(FUEL_SLOT));
            this.burnTime = this.getFuelTime(this.inventory.get(FUEL_SLOT));
            this.removeStack(FUEL_SLOT, 1);
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(IronHeatGeneratorBlock.FACING);

        if(side == Direction.DOWN){
            return false;
        }
        // From top insert into 1
        if(side == Direction.UP){
            return slot == FUEL_SLOT;
        }
        // right insert into 1
        // From left insert into 0
        return switch (localDir) {
            default ->
                    side.getOpposite() == Direction.NORTH && slot == FUEL_SLOT|| //&& stack.getItem() == ModBlockTags.CRUSHABLE
                            side.getOpposite() == Direction.EAST && slot == FUEL_SLOT ||
                            side.getOpposite() == Direction.WEST && slot == FUEL_SLOT;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == FUEL_SLOT ||
                            side.rotateYClockwise() == Direction.EAST && slot == FUEL_SLOT ||
                            side.rotateYClockwise() == Direction.WEST && slot == FUEL_SLOT;
            case SOUTH ->
                    side  == Direction.NORTH && slot == FUEL_SLOT ||
                            side == Direction.EAST && slot == FUEL_SLOT ||
                            side == Direction.WEST && slot == FUEL_SLOT;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == FUEL_SLOT ||
                            side.rotateYCounterclockwise() == Direction.EAST && slot == FUEL_SLOT ||
                            side.rotateYCounterclockwise() == Direction.WEST && slot == FUEL_SLOT;
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
}
