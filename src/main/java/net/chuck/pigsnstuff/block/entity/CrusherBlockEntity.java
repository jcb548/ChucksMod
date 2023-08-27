package net.chuck.pigsnstuff.block.entity;

import com.google.common.collect.Maps;
import net.chuck.pigsnstuff.block.custom.CrusherBlock;
import net.chuck.pigsnstuff.recipe.CrusherRecipe;
import net.chuck.pigsnstuff.screen.CrusherScreenHandler;
import net.minecraft.SharedConstants;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
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
public class CrusherBlockEntity extends AbstractCrusherBlockEntity {
    public static final int FUEL_SLOT = 2;
    public static final int BURN_TIME_IDX = 2;
    public static final int FUEL_TIME_IDX = 3;
    public static final int DELEGATE_SIZE = 4;
    public static final int INV_SIZE = 3;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int burnTime = 0;
    private int fuelTime = 0;
    public static final Map<Item, Integer> FUELS = AbstractFurnaceBlockEntity.createFuelTimeMap();
    public CrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRUSHER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case PROGRESS_IDX: return CrusherBlockEntity.this.progress;
                    case MAX_PROGRESS_IDX: return CrusherBlockEntity.this.maxProgress;
                    case BURN_TIME_IDX: return CrusherBlockEntity.this.burnTime;
                    case FUEL_TIME_IDX: return CrusherBlockEntity.this.fuelTime;
                    default: return PROGRESS_IDX;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_IDX: CrusherBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS_IDX: CrusherBlockEntity.this.maxProgress = value; break;
                    case BURN_TIME_IDX: CrusherBlockEntity.this.burnTime = value; break;
                    case FUEL_TIME_IDX: CrusherBlockEntity.this.fuelTime = value; break;
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
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Crusher");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrusherScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
    // For saving nbt on world close
    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
        nbt.putInt("crusher.progress", progress);
        nbt.putInt("crusher.burnTime", burnTime);
        nbt.putInt("crusher.fuelTime", fuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("crusher.progress");
        burnTime = nbt.getInt("crusher.burnTime");
        fuelTime = nbt.getInt("crusher.fuelTime");
    }

    private boolean isBurning() {
        return this.burnTime > 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState,
                            CrusherBlockEntity entity) {
        boolean burning_start_of_tick = entity.isBurning();
        if (world.isClient()){
            return;
        }
        if (entity.isBurning()){
            --entity.burnTime;
        }
        if(hasRecipe(entity) && !entity.isBurning()){
            burnFuel(entity);
        }
        if(hasRecipe(entity) && entity.isBurning()){
            entity.progress++;
            markDirty(world, blockPos, blockState);
            if(entity.progress >= entity.maxProgress){
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, blockState);
        }
        if (burning_start_of_tick != entity.isBurning()){
            blockState = (BlockState)blockState.with(AbstractFurnaceBlock.LIT, entity.isBurning());
            world.setBlockState(blockPos, blockState, Block.NOTIFY_ALL);
            markDirty(world, blockPos, blockState);
        }
    }
    private static void burnFuel(CrusherBlockEntity entity){
        if (entity.getFuelTime(entity.inventory.get(FUEL_SLOT)) > 0){
            entity.fuelTime = entity.getFuelTime(entity.inventory.get(FUEL_SLOT));
            entity.burnTime = entity.getFuelTime(entity.inventory.get(FUEL_SLOT));
            entity.removeStack(FUEL_SLOT, 1);
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(CrusherBlock.FACING);

        if(side == Direction.DOWN){
            return false;
        }
        // From top insert into 1
        if(side == Direction.UP){
            return slot == INPUT_SLOT;
        }
        // right insert into 1
        // From left insert into 0
        return switch (localDir) {
            default ->
                side.getOpposite() == Direction.NORTH && slot == INPUT_SLOT || //&& stack.getItem() == ModBlockTags.CRUSHABLE
                        side.getOpposite() == Direction.EAST && slot == INPUT_SLOT ||
                        side.getOpposite() == Direction.WEST && slot == FUEL_SLOT;
            case EAST ->
                side.rotateYClockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                        side.rotateYClockwise() == Direction.EAST && slot == INPUT_SLOT ||
                        side.rotateYClockwise() == Direction.WEST && slot == FUEL_SLOT;
            case SOUTH ->
                side  == Direction.NORTH && slot == INPUT_SLOT ||
                        side == Direction.EAST && slot == INPUT_SLOT ||
                        side == Direction.WEST && slot == FUEL_SLOT;
            case WEST ->
                side.rotateYCounterclockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                        side.rotateYCounterclockwise() == Direction.EAST && slot == INPUT_SLOT ||
                        side.rotateYCounterclockwise() == Direction.WEST && slot == FUEL_SLOT;
        };
    }
}
