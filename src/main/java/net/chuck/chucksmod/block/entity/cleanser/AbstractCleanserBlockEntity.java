package net.chuck.chucksmod.block.entity.cleanser;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.ExperienceInteractingFluidStoring;
import net.chuck.chucksmod.fluid.ModFluids;
import net.chuck.chucksmod.screen.cleanser.CleanserScreenHandler;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class AbstractCleanserBlockEntity extends AbstractEnergyCookerBlockEntity implements ExperienceInteractingFluidStoring {
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
    public AbstractCleanserBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, energyStorageSize, maxProgress, maxInsertExtract);
    }

    @Override
    protected void craftItem() {
        ItemStack output = inventory.getStack(INPUT_SLOT).copy();
        output.setRepairCost(0);
        inventory.setStack(OUTPUT_SLOT, output);
        inventory.removeStack(INPUT_SLOT, 1);
        this.extractXp();
    }
    @Override
    public boolean hasRecipe() {
        return hasEnoughXp() && inventory.getStack(INPUT_SLOT).getRepairCost() > 0;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        sendFluidPacket();
        return new CleanserScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public SingleVariantStorage<FluidVariant> getFluidStorage() {
        return fluidStorage;
    }

    @Override
    public Fluid getAllowedFluid() {
        return ModFluids.STILL_LIQUID_XP;
    }
    public int getXpCost(){
        int levels = 0;
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(inventory.getStack(INPUT_SLOT));
        for(Enchantment key : enchantments.keySet()){
            levels += key.getMaxPower(enchantments.get(key));
        }
        return ModExperienceUtil.convertLevelToXp(levels/3);
    }
    private boolean hasEnoughXp(){
        return this.fluidStorage.amount >= getXpCost(); // mb amount
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("cleanser.fluid_variant"));
        fluidStorage.amount = nbt.getLong("cleanser.fluid_level");
        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.put("cleanser.fluid_variant", fluidStorage.variant.toNbt());
        nbt.putLong("cleanser.fluid_level", fluidStorage.amount);
        super.writeNbt(nbt);
    }
    private void extractXp() {
        try(Transaction transaction = Transaction.openOuter()){
            this.fluidStorage.extract(FluidVariant.of(ModFluids.STILL_LIQUID_XP),
                    getXpCost(), transaction);
            transaction.commit();
        }
    }
}
