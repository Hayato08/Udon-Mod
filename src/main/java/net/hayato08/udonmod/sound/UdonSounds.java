package net.hayato08.udonmod.sound;

import net.hayato08.udonmod.UdonMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UdonSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, UdonMod.MOD_ID);

    public static final Supplier<SoundEvent> STONE_MILL_USE = registerSoundEvent("stone_mill_use");


    private static Supplier<SoundEvent> registerSoundEvent(String name)
    {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }

}
