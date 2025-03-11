package net.hayato08.udonmod.entity;

import net.hayato08.udonmod.entity.custom.WolFoxEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = "udonmod", bus = EventBusSubscriber.Bus.MOD)
public class UdonEntityAttributes {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(UdonEntities.KATSUO.get(), WolFoxEntity.createFoxAttributes().build());
        event.put(UdonEntities.WOLFOX.get(), WolFoxEntity.createFoxAttributes().build());
    }
}