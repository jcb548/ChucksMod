package net.chuck.chucksmod.world.tree;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.mixin.TreeDecoratorTypeInvoker;
import net.chuck.chucksmod.world.tree.custom.TriafianLeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecoratorTypes {
    public static final TreeDecoratorType<TriafianLeavesVineTreeDecorator> LEAVE_TRIAFIAN_VINE =
            TreeDecoratorTypeInvoker.callRegister("leave_triafian_vine", TriafianLeavesVineTreeDecorator.CODEC);
    public static void register(){
        ChucksMod.LOGGER.info("Registering Tree Decorators for " + ChucksMod.MOD_ID);
    }
}
