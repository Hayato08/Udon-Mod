package net.hayato08.udonmod.events;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.entity.custom.WolFoxEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = UdonMod.MOD_ID)
public class WolFoxEventHandler {

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) // プレイヤーがログインしたとき
    {
        if (event.getEntity().level() instanceof ServerLevel serverLevel) {
            // 既存のWolfoxをすべて削除
            for (Entity entity : serverLevel.getAllEntities()) {
                if (entity instanceof WolFoxEntity) {
                    entity.discard();
                }
            }
        }
    }
}