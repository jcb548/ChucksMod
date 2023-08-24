package net.chuck.pigsnstuff.block.entity;

import com.google.common.collect.Maps;
import net.chuck.pigsnstuff.block.custom.PoweredCrusherBlock;
import net.chuck.pigsnstuff.item.ModItems;
import net.chuck.pigsnstuff.networking.ModMessages;
import net.chuck.pigsnstuff.recipe.CrusherRecipe;
import net.chuck.pigsnstuff.screen.PoweredCrusherScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
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
import java.util.Optional;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class PoweredCrusherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {protected static final int INPUT_SLOT_INDEX = 0;
    protected static final int FUEL_SLOT = 0;
    protected static final int INPUT_SLOT = 1;
    protected static final int OUTPUT_SLOT = 2;
    public static final int PROGRESS_PROPERTY_INDEX = 0;
    public static final int MAX_PROGRESS_PROPERTY_INDEX = 1;
    public static final int BURN_TIME_PROPERTY_INDEX = 2;
    public static final int FUEL_TIME_PROPERTY_INDEX = 3;
    public static final int DEFAULT_CRUSH_TIME = 200;
    public static final int MAX_INSERT = 32;
    public static final int MAX_EXTRACT = MAX_INSERT;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(30000, MAX_INSERT, MAX_EXTRACT){
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
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    public static final Map<Item, Integer> FUELS = AbstractFurnaceBlockEntity.createFuelTimeMap();
    public PoweredCrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POWERED_CRUSHER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0: return PoweredCrusherBlockEntity.this.progress;
                    case 1: return PoweredCrusherBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: PoweredCrusherBlockEntity.this.progress = value; break;
                    case 1: PoweredCrusherBlockEntity.this.maxProgress = value; break;
                }
            }

            @Override
            public int size() {
                return 2;
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
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Powered Crusher");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new PoweredCrusherScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
    // For saving nbt on world close
    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
        nbt.putInt("powered_crusher.progress", progress);
        nbt.putLong("powered_crusher.energy", energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("powered_crusher.progress");
        energyStorage.amount= nbt.getLong("powered_crusher.energy");
    }
    public static void tick(World world, BlockPos blockPos, BlockState blockState,
                            PoweredCrusherBlockEntity entity) {
        if (world.isClient()){
            return;
        }

        if(hasEnergyItem(entity)){
            try(Transaction transaction = Transaction.openOuter()){
                entity.energyStorage.insert(16, transaction);
                transaction.commit();
            }
        }
        if(hasRecipe(entity) && hasEnoughEnergy(entity)){
            entity.progress++;
            extractEnergy(entity);
            markDirty(world, blockPos, blockState);
            if(entity.progress >= entity.maxProgress){
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, blockState);
        }
    }
    public void setEnergyLevel(long energyLevel){
        this.energyStorage.amount = energyLevel;
    }

    private static void extractEnergy(PoweredCrusherBlockEntity entity) {
        try(Transaction transaction = Transaction.openOuter()){
            entity.energyStorage.extract(32, transaction);
            transaction.commit();
        }
    }

    private static boolean hasEnoughEnergy(PoweredCrusherBlockEntity entity) {
        return entity.energyStorage.amount >= 32;
    }

    private static boolean hasEnergyItem(PoweredCrusherBlockEntity entity) {
        return entity.getStack(0).getItem() == Items.IRON_INGOT;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(PoweredCrusherBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0; i< entity.size(); i++){
            inventory.setStack(INPUT_SLOT, entity.getStack(INPUT_SLOT));
        }
        Optional<CrusherRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(CrusherRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            entity.removeStack(INPUT_SLOT,1);
            entity.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutputNoReg().getItem(),
                    entity.getStack(OUTPUT_SLOT).getCount() + 1));
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(PoweredCrusherBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0; i< entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }
        //boolean hasRawItemInFirstSlot = entity.getStack(1).getItem() == Items.BONE;
        Optional<CrusherRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(CrusherRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, match.get().getOutputNoReg().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(OUTPUT_SLOT).getItem() == output || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(OUTPUT_SLOT).getMaxCount() > inventory.getStack(2).getCount();
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(PoweredCrusherBlock.FACING);

        if(side == Direction.DOWN){
            return false;
        }
        // From top insert into 1
        if(side == Direction.UP){
            return slot == 1;
        }
        // right insert into 1
        // From left insert into 0
        return switch (localDir) {
            default ->
                    side.getOpposite() == Direction.NORTH && slot == 1 || //&& stack.getItem() == ModBlockTags.CRUSHABLE
                            side.getOpposite() == Direction.EAST && slot == 1 ||
                            side.getOpposite() == Direction.WEST && slot == 0;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == 1 ||
                            side.rotateYClockwise() == Direction.EAST && slot == 1 ||
                            side.rotateYClockwise() == Direction.WEST && slot == 0;
            case SOUTH ->
                    side  == Direction.NORTH && slot == 1 ||
                            side == Direction.EAST && slot == 1 ||
                            side == Direction.WEST && slot == 0;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == 1 ||
                            side.rotateYCounterclockwise() == Direction.EAST && slot == 1 ||
                            side.rotateYCounterclockwise() == Direction.WEST && slot == 0;
        };
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(PoweredCrusherBlock.FACING);

        if(side == Direction.UP){
            return false;
        }

        // From Down extract from 2
        if(side == Direction.DOWN){
            return slot == 2;
        }
        // From bottom extract from 2
        // From right extract from 2
        return switch (localDir) {
            default ->
                    side.getOpposite() == Direction.NORTH && slot == 2 || //&& stack.getItem() == ModBlockTags.CRUSHABLE
                            side.getOpposite() == Direction.EAST && slot == 2;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == 2 ||
                            side.rotateYClockwise() == Direction.EAST && slot == 2;
            case SOUTH ->
                    side  == Direction.NORTH && slot == 2 ||
                            side == Direction.EAST && slot == 2;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == 2 ||
                            side.rotateYCounterclockwise() == Direction.EAST && slot == 2;
        };
    }
}
