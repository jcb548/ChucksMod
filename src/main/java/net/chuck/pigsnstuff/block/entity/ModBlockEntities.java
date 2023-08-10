package net.chuck.pigsnstuff.block.entity;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.ModBlocks;
import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<InfuserBlockEntity> INFUSER;
    public static void registerBlockEntities() {
        INFUSER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PigsNStuff.MOD_ID, "infuser"),
                FabricBlockEntityTypeBuilder.create(InfuserBlockEntity::new,
                        ModBlocks.INFUSER).build(null));
    }
}
