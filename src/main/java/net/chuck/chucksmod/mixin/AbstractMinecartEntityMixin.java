package net.chuck.chucksmod.mixin;

import net.chuck.chucksmod.block.ModBlockTags;
import net.chuck.chucksmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractMinecartEntity.class)
public class AbstractMinecartEntityMixin {
    @Inject(method = "getMaxSpeed", at = @At("RETURN"), cancellable = true)
    private void injected(CallbackInfoReturnable<Double> cir){
        cir.setReturnValue(cir.getReturnValue()*3);
    }

    @Redirect(method = "moveOnRail",at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean injected2(BlockState state, Block block){
        return state.isIn(ModBlockTags.POWERED_RAILS);
    }
}
