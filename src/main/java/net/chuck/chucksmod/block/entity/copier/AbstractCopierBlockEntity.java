package net.chuck.chucksmod.block.entity.copier;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.copier.CopierScreenHandler;
import net.chuck.chucksmod.util.ModExperienceUtil;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class AbstractCopierBlockEntity extends AbstractEnergyCookerBlockEntity {
    public static final int INV_SIZE = 3;
    public static final int BOOK_SLOT = 2;
    public int maxXp;
    public int xp = 0;
    public AbstractCopierBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                     int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, INV_SIZE, energyStorageSize, maxProgress, maxInsertExtract);
        this.maxProgress = maxProgress;
    }
    public boolean hasEnchantedBook(){
        return inventory.getStack(INPUT_SLOT).getItem() instanceof EnchantedBookItem;
    }

    @Override
    public boolean hasRecipe() {
        if(!inventory.getStack(BOOK_SLOT).getItem().equals(Items.BOOK) ||
                !hasEnchantedBook()){
            return false;
        }
        int cost = getXpCost();
        return cost <= xp && canInsertAmountIntoOutputSlot() &&
                canInsertItemIntoOutputSlot(inventory.getStack(INPUT_SLOT).getItem());
    }

    @Override
    protected void craftItem() {
        this.xp -= getXpCost();
        inventory.setStack(OUTPUT_SLOT, inventory.getStack(INPUT_SLOT).copy());
        inventory.removeStack(BOOK_SLOT, 1);
    }
    public int getXpCost(){
        int levels = 0;
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(inventory.getStack(INPUT_SLOT));
        for(Enchantment key : enchantments.keySet()){
            levels += key.getMaxPower(enchantments.get(key));
        }
        return ModExperienceUtil.convertLevelToXp(levels/3);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new CopierScreenHandler(syncId, playerInventory, this, propertyDelegate,
                this.energyStorage.amount, this.xp);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
        buf.writeLong(this.energyStorage.amount);
        buf.writeInt(this.xp);
    }

    public void syncXp(){
        if(!world.isClient) {
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(xp);
            data.writeBlockPos(getPos());
            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(player, ModMessages.XP_SYNC, data);
            }
        }
    }
    public abstract int getXpDrainRate();
}
