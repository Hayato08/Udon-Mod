package net.hayato08.udonmod.entity;


import net.hayato08.udonmod.client.renderer.IwashiRenderer;
import net.hayato08.udonmod.client.renderer.KatsuoRenderer;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UdonModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(UdonEntities.KATSUO.get(), KatsuoRenderer::new);
        event.registerEntityRenderer(UdonEntities.IWASHI.get(), IwashiRenderer::new);
    }
}
