
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.hayato08.udonmod.init;

import net.hayato08.udonmod.client.gui.StoneMillGuiScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UdonModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(UdonModMenus.STONE_MILL_GUI.get(), StoneMillGuiScreen::new);
	}
}
