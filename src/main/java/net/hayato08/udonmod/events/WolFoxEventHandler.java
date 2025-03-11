package net.hayato08.udonmod.events;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.entity.custom.WolFoxEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EventBusSubscriber(modid = UdonMod.MOD_ID)
public class WolFoxEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WolFoxEventHandler.class);

    @SubscribeEvent
    public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.getEntity().level() instanceof ServerLevel serverLevel) {
            for (Entity entity : serverLevel.getAllEntities()) {
                if (entity instanceof WolFoxEntity wolFox) {
                    entity.discard();
                }
            }
        }
    }
}