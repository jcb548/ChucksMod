package net.chuck.pigsnstuff.block.entity;
import net.chuck.pigsnstuff.block.custom.GeneratorBlock;
import net.chuck.pigsnstuff.networking.ModMessages;
import net.chuck.pigsnstuff.screen.GeneratorScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Map;

public class GeneratorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,
        ImplementedInventory {
    public static final int FUEL_SLOT = 0;
    public static final int BURN_TIME_IDX = 0;
    public static final int FUEL_TIME_IDX = 1;
    public static final int DELEGATE_SIZE = 2;
    public static final int INV_SIZE = 1;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int burnTime = 0;
    private int fuelTime = 0;
    public static final int MAX_INSERT = 32;
    public static final int MAX_EXTRACT = MAX_INSERT;
    public static final int GENERATION = MAX_INSERT;
    public static final Map<Item, Integer> FUELS = AbstractFurnaceBlockEntity.createFuelTimeMap();
    public static final int ENERGY_STORAGE = 30000;
    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(ENERGY_STORAGE, MAX_INSERT, MAX_EXTRACT){
        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient()){
                PacketByteBuf data = PacketByteBufs.create();
                data.writeLong(amount);
                data.writeBlockPos(getPos());

                for(ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())){
                    ServerPlayNetworking.send(player, ModMessages.ENERGY_SYNC, data);
                }
            }

        }
    };
    public GeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GENERATOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case BURN_TIME_IDX: return GeneratorBlockEntity.this.burnTime;
                    case FUEL_TIME_IDX: return GeneratorBlockEntity.this.fuelTime;
                    default: return BURN_TIME_IDX;
                }
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case BURN_TIME_IDX: GeneratorBlockEntity.this.burnTime = value; break;
                    case FUEL_TIME_IDX: GeneratorBlockEntity.this.fuelTime = value; break;
                }
            }
            @Override
            public int size() {
                return DELEGATE_SIZE;
            }
        };
    }
    public static boolean canUseAsFuel(ItemStack stack) {
        return FUELS.containsKey(stack.getItem());
    }
    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        }
        Item item = fuel.getItem();
        return FUELS.getOrDefault(item, 0);
    }
    private static void generateEnergy(GeneratorBlockEntity entity, long amount) {
        try(Transaction transaction = Transaction.openOuter()){
            entity.energyStorage.insert(amount, transaction);
            transaction.commit();
        }
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Generator");
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
        nbt.putInt("generator.burnTime", burnTime);
        nbt.putInt("generator.fuelTime", fuelTime);
        nbt.putLong("generator.energy", energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        burnTime = nbt.getInt("generator.burnTime");
        fuelTime = nbt.getInt("generator.fuelTime");
        energyStorage.amount = nbt.getLong("generator.energy");

    }

    private boolean isBurning() {
        return this.burnTime > 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState,
                            GeneratorBlockEntity entity) {
        boolean burning_start_of_tick = entity.isBurning();
        if (world.isClient()){
            return;
        }
        if (!entity.isBurning() && entity.energyStorage.amount < ENERGY_STORAGE){
            burnFuel(entity);
        }
        if (entity.isBurning()){
            --entity.burnTime;
            generateEnergy(entity, GENERATION);
        }
        if (burning_start_of_tick != entity.isBurning()){
            blockState = (BlockState)blockState.with(AbstractFurnaceBlock.LIT, entity.isBurning());
            world.setBlockState(blockPos, blockState, Block.NOTIFY_ALL);
            markDirty(world, blockPos, blockState);
        }
    }
    private static void burnFuel(GeneratorBlockEntity entity){
        if (entity.getFuelTime(entity.inventory.get(FUEL_SLOT)) > 0){
            entity.fuelTime = entity.getFuelTime(entity.inventory.get(FUEL_SLOT));
            entity.burnTime = entity.getFuelTime(entity.inventory.get(FUEL_SLOT));
            entity.removeStack(FUEL_SLOT, 1);
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(GeneratorBlock.FACING);

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
    public void setEnergyLevel(long energyLevel){
        this.energyStorage.amount = energyLevel;
    }
}
