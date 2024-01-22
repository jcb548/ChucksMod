package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.util.FluidStack;

public interface FluidStoringScreenHandler {
    FluidStoring getFluidStoring();
    void setFluidStack(FluidStack fluidStack);
}
