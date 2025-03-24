package net.hayato08.udonmod.block.entity;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.block.UdonBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UdonBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, UdonMod.MOD_ID);

    public static final Supplier<BlockEntityType<UniversalCookingBlockEntity>> UNIVERSAL_COOKING_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("universal_cooking_block_entity", () -> BlockEntityType.Builder.of(
                    UniversalCookingBlockEntity::new, UdonBlocks.UNIVERSAL_COOKING_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}
