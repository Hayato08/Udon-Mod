package net.hayato08.udonmod.entity;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.entity.custom.IwashiEntity;
import net.hayato08.udonmod.entity.custom.KatsuoEntity;
import net.hayato08.udonmod.entity.custom.WolFoxEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class UdonEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, UdonMod.MOD_ID);

    public static final Supplier<EntityType<WolFoxEntity>> WOLFOX =
            ENTITY_TYPES.register("wolfox",
                    () -> EntityType.Builder.of(WolFoxEntity::new, MobCategory.CREATURE)
                            .sized(0.6f, 0.85f)
                            .build("wolfox"));

    public static final Supplier<EntityType<KatsuoEntity>> KATSUO = ENTITY_TYPES.register("katsuo",
            () -> EntityType.Builder.of(KatsuoEntity::new, MobCategory.WATER_CREATURE)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .sized(0.6f, 1.8f)
                    .build("katsuo"));

    public static final Supplier<EntityType<IwashiEntity>> IWASHI = ENTITY_TYPES.register("iwashi",
            () -> EntityType.Builder.of(IwashiEntity::new, MobCategory.WATER_CREATURE)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .sized(0.6f, 1.8f)
                    .build("iwashi"));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
