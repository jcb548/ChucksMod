package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.screen.renderer.FluidStackRenderer;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;

public interface FluidDisplayingScreenHandler {
    FluidStoring getFluidStoring();
    void setFluidStack(FluidStack fluidStack);
}
