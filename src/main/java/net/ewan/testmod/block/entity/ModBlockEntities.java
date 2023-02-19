package net.ewan.testmod.block.entity;

import net.ewan.testmod.block.CircuitFabricatorBlock;
import net.ewan.testmod.block.ModBlock;
import net.ewan.testmod.testmod;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static  final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, testmod.MOD_ID);

    public static final RegistryObject<BlockEntityType<RocketWorkbenchEntity>> ROCKET_WORKBENCH =
            BLOCK_ENTITIES.register("rocket_workbench", () ->
                    BlockEntityType.Builder.of(RocketWorkbenchEntity::new,
                            ModBlock.ROCKET_WORKBENCH_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<CircuitFabricatorBlockEntity>> CIRCUIT_FABRICATOR =
            BLOCK_ENTITIES.register("circuit_fabricator", () ->
                    BlockEntityType.Builder.of(CircuitFabricatorBlockEntity::new,
                            ModBlock.CIRCUIT_FABRICATOR_BLOCK.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
