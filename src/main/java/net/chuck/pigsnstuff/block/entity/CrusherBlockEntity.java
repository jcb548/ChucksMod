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
public class CrusherBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {protected static final int INPUT_SLOT_INDEX = 0;
    protected static final int FUEL_SLOT = 0;
    protected static final int INPUT_SLOT = 1;
    protected static final int OUTPUT_SLOT = 2;
    public static final int PROGRESS_PROPERTY_INDEX = 0;
    public static final int MAX_PROGRESS_PROPERTY_INDEX = 1;
    public static final int BURN_TIME_PROPERTY_INDEX = 2;
    public static final int FUEL_TIME_PROPERTY_INDEX = 3;
    public static final int DEFAULT_CRUSH_TIME = 200;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int burnTime = 0;
    private int fuelTime = 0;
    public static final Map<Item, Integer> FUELS = AbstractFurnaceBlockEntity.createFuelTimeMap();
    public CrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRUSHER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0: return CrusherBlockEntity.this.progress;
                    case 1: return CrusherBlockEntity.this.maxProgress;
                    case 2: return CrusherBlockEntity.this.burnTime;
                    case 3: return CrusherBlockEntity.this.fuelTime;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CrusherBlockEntity.this.progress = value; break;
                    case 1: CrusherBlockEntity.this.maxProgress = value; break;
                    case 2: CrusherBlockEntity.this.burnTime = value; break;
                    case 3: CrusherBlockEntity.this.fuelTime = value; break;
                }
            }

            @Override
            public int size() {
                return 4;
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
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("crusher.progress");
        burnTime = nbt.getInt("crusher.burnTime");
    }

    private boolean isBurning() {
        return this.burnTime > 0;
    }
    public static void tick(World world, BlockPos blockPos, BlockState blockState,
                            CrusherBlockEntity crusherBlockEntity) {
        boolean burning_start_of_tick = crusherBlockEntity.isBurning();
        if (world.isClient()){
            return;
        }
        if (crusherBlockEntity.isBurning()){
            --crusherBlockEntity.burnTime;
        }
        if(hasRecipe(crusherBlockEntity) && !crusherBlockEntity.isBurning()){
            burnFuel(crusherBlockEntity);
        }
        if(hasRecipe(crusherBlockEntity) && crusherBlockEntity.isBurning()){
            crusherBlockEntity.progress++;
            markDirty(world, blockPos, blockState);
            if(crusherBlockEntity.progress >= crusherBlockEntity.maxProgress){
                craftItem(crusherBlockEntity);
            }
        } else {
            crusherBlockEntity.resetProgress();
            markDirty(world, blockPos, blockState);
        }
        if (burning_start_of_tick != crusherBlockEntity.isBurning()){
            blockState = (BlockState)blockState.with(AbstractFurnaceBlock.LIT, crusherBlockEntity.isBurning());
            world.setBlockState(blockPos, blockState, Block.NOTIFY_ALL);
            markDirty(world, blockPos, blockState);
        }
    }
    private static void burnFuel(CrusherBlockEntity crusherBlockEntity){
        if (crusherBlockEntity.getFuelTime(crusherBlockEntity.inventory.get(FUEL_SLOT)) > 0){
            crusherBlockEntity.fuelTime = crusherBlockEntity.getFuelTime(crusherBlockEntity.inventory.get(FUEL_SLOT));
            crusherBlockEntity.burnTime = crusherBlockEntity.getFuelTime(crusherBlockEntity.inventory.get(FUEL_SLOT));
            crusherBlockEntity.removeStack(FUEL_SLOT, 1);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(CrusherBlockEntity crusherBlockEntity) {
        SimpleInventory inventory = new SimpleInventory(crusherBlockEntity.size());
        for(int i = 0; i< crusherBlockEntity.size(); i++){
            inventory.setStack(INPUT_SLOT, crusherBlockEntity.getStack(INPUT_SLOT));
        }
        Optional<CrusherRecipe> recipe = crusherBlockEntity.getWorld().getRecipeManager()
                .getFirstMatch(CrusherRecipe.Type.INSTANCE, inventory, crusherBlockEntity.getWorld());

        if(hasRecipe(crusherBlockEntity)) {
            crusherBlockEntity.removeStack(INPUT_SLOT,1);
            crusherBlockEntity.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutputNoReg().getItem(),
                    crusherBlockEntity.getStack(OUTPUT_SLOT).getCount() + 1));
            crusherBlockEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(CrusherBlockEntity crusherBlockEntity) {
        SimpleInventory inventory = new SimpleInventory(crusherBlockEntity.size());
        for(int i = 0; i< crusherBlockEntity.size(); i++){
            inventory.setStack(i, crusherBlockEntity.getStack(i));
        }
        //boolean hasRawItemInFirstSlot = crusherBlockEntity.getStack(1).getItem() == Items.BONE;
        Optional<CrusherRecipe> match = crusherBlockEntity.getWorld().getRecipeManager()
                .getFirstMatch(CrusherRecipe.Type.INSTANCE, inventory, crusherBlockEntity.getWorld());

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
        Direction localDir = this.getWorld().getBlockState(this.pos).get(CrusherBlock.FACING);

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
        Direction localDir = this.getWorld().getBlockState(this.pos).get(CrusherBlock.FACING);

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
