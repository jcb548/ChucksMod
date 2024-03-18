package net.chuck.chucksmod.block.entity.harvester;

import net.chuck.chucksmod.block.entity.AbstractMiningBlockEntity;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.util.ModNbt;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public abstract class AbstractHarvesterBlockEntity extends AbstractMiningBlockEntity {
    protected final SimpleInventory cropsInventory;
    public AbstractHarvesterBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int seedsInvSize,
                                        int cropsInvSize, int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, seedsInvSize, energyStorageSize, maxProgress, maxInsertExtract);
        cropsInventory = new SimpleInventory(cropsInvSize);
        cropsInventory.addListener(this);
        yPos = pos.getY();
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState blockState) {
        super.tick(world, pos, blockState);
        if(world.isClient) return;
        ServerWorld serverWorld = (ServerWorld) world;
        boolean shouldTryHarvest = world.isReceivingRedstonePower(pos) && hasEnoughEnergy();
        if(shouldTryHarvest){
            increaseProgress();
            extractEnergy();
            markDirty(serverWorld, pos, blockState);
            if(shouldBreakBlock()){
                boolean didAction = false;
                BlockPos nextBlockPos = getNextBlockPos();
                BlockState nextBlockState = world.getBlockState(nextBlockPos);
                if(isGrownCrop(nextBlockState)){
                    List<ItemStack> drops = Block.getDroppedStacks(nextBlockState, serverWorld, nextBlockPos,
                            serverWorld.getBlockEntity(nextBlockPos), null, getTool());
                    for (int i = 0; i < drops.size(); i++) {
                        ItemStack stack = drops.get(i);
                        ItemStack excess;
                        if(stack.getItem() instanceof AliasedBlockItem item && item.getBlock() instanceof CropBlock) {
                            excess = inventory.addStack(stack);
                        } else {
                            excess = cropsInventory.addStack(stack);
                        }
                        if (!excess.equals(ItemStack.EMPTY)) {
                            ItemEntity items = new ItemEntity(serverWorld, pos.getX() + 0.5, pos.getY() + 1,
                                    pos.getZ() + 0.5, excess);
                            serverWorld.spawnEntity(items);
                        }
                    }
                    serverWorld.breakBlock(nextBlockPos, false);
                    didAction = true;
                }
                if(world.getBlockState(nextBlockPos).isAir() && !inventory.isEmpty()){
                    int firstEmpty = 0;
                    while (inventory.getStack(firstEmpty).isEmpty()) {
                        firstEmpty++;
                    }
                    if (inventory.getStack(firstEmpty).getItem() instanceof AliasedBlockItem item){
                        world.setBlockState(nextBlockPos, item.getBlock().getDefaultState());
                        inventory.removeStack(firstEmpty, 1);
                    }
                    didAction = true;
                }
                if(didAction){
                    this.resetProgress();
                } else {
                    this.noMineResetProgress();
                }
                incrementBlockPos();
            }
        }
    }
    protected void incrementBlockPos(){
        xPos++;
        if(xPos>=getSize()){
            xPos = 0;
            zPos++;
            if(zPos>=getSize()){
                zPos = 0;
            }
        }
    }
    private boolean isGrownCrop(BlockState state){
        return state.getBlock() instanceof CropBlock block && block.getAge(state) == block.getMaxAge();
    }
    public abstract ItemStack getTool();
    public Inventory getCropInventory(){
        return cropsInventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        ModNbt.readNbt(nbt, "Crop_Items", cropsInventory.stacks);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        ModNbt.writeNbt(nbt, "Crop_Items", cropsInventory.stacks);
    }
}
