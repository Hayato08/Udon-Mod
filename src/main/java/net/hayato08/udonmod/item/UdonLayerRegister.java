package net.hayato08.udonmod.item;

import net.hayato08.udonmod.client.model.IwashiMobModel;
import net.hayato08.udonmod.client.model.KatsuoMobModel;
import net.hayato08.udonmod.client.model.KitsuneArmorModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class UdonLayerRegister {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(KatsuoMobModel.LAYER_LOCATION, KatsuoMobModel::createBodyLayer);
		event.registerLayerDefinition(IwashiMobModel.LAYER_LOCATION, IwashiMobModel::createBodyLayer);
		event.registerLayerDefinition(KitsuneArmorModel.LAYER_LOCATION, KitsuneArmorModel::createBodyLayer);
	}
}
