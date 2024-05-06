package net.chuck.chucksmod.block.entity.copier;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.ExperienceInteractingFluidStoring;
import net.chuck.chucksmod.fluid.ModFluids;
import net.chuck.chucksmod.screen.copier.CopierScreenHandler;
import net.chuck.chucksmod.util.FluidStack;
import net.chuck.chucksmod.util.ModExperienceUtil;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class AbstractCopierBlockEntity extends AbstractEnergyCookerBlockEntity implements ExperienceInteractingFluidStoring {
    public static final int INV_SIZE = 4;
    public static final int BOOK_SLOT = 2;
    public static final int XP_BUCKET_SLOT = 3;
    public SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET)* getBucketCapacity();
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient) {
                sendFluidPacket();
            }
        }
    };

    public AbstractCopierBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                     int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, INV_SIZE, energyStorageSize, maxProgress, maxInsertExtract);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("copier.fluid_variant"));
        fluidStorage.amount = nbt.getLong("copier.fluid_level");
        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.put("copier.fluid_variant", fluidStorage.variant.toNbt());
        nbt.putLong("copier.fluid_level", fluidStorage.amount);
        super.writeNbt(nbt);
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
        return hasEnoughXp() && canInsertAmountIntoOutputSlot() &&
                canInsertItemIntoOutputSlot(inventory.getStack(INPUT_SLOT).getItem());
    }

    @Override
    protected void craftItem() {
        inventory.setStack(OUTPUT_SLOT, inventory.getStack(INPUT_SLOT).copy());
        inventory.removeStack(BOOK_SLOT, 1);
        this.extractXp();
    }

    public int getXpCost(){
        int levels = 0;
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(inventory.getStack(INPUT_SLOT));
        for(Enchantment key : enchantments.keySet()){
            levels += key.getMaxPower(enchantments.get(key));
        }
        return ModExperienceUtil.convertLevelToXp(levels/10);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        sendFluidPacket();
        return new CopierScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    private boolean hasEnoughXp(){
        return this.fluidStorage.amount >= getXpCost(); // mb amount
    }

    @Override
    public void tick(World world, BlockPos blockPos, BlockState blockState) {
        super.tick(world, blockPos, blockState);
        if(canExtractFromXpBucket()){
            transferXpBucketToStorage();
        }
    }

    private void transferXpBucketToStorage() {
        try(Transaction transaction = Transaction.openOuter()){
            this.fluidStorage.insert(FluidVariant.of(ModFluids.STILL_LIQUID_XP),
                    FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
            transaction.commit();
            setStack(XP_BUCKET_SLOT, new ItemStack(Items.BUCKET));
        }
    }

    private boolean canExtractFromXpBucket() {
        return getStack(XP_BUCKET_SLOT).getItem() == ModFluids.LIQUID_XP_BUCKET && fluidStorage.amount + 1000 < fluidStorage.getCapacity();
    }

    private void extractXp() {
        try(Transaction transaction = Transaction.openOuter()){
            this.fluidStorage.extract(FluidVariant.of(ModFluids.STILL_LIQUID_XP),
                    getXpCost(), transaction);
            transaction.commit();
        }
    }
    @Override
    public SingleVariantStorage<FluidVariant> getFluidStorage() {
        return fluidStorage;
    }

    @Override
    public Fluid getAllowedFluid() {
        return ModFluids.STILL_LIQUID_XP;
    }
}
