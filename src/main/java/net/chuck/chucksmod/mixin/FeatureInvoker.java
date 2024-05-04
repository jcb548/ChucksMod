package net.chuck.chucksmod.mixin;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Feature.class)
public interface FeatureInvoker {
    @Invoker("register")
    static <C extends FeatureConfig, F extends Feature<C>> F callRegister(String name, F feature){
        throw new IllegalStateException();
    }
}
