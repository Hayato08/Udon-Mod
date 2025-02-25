
package net.hayato08.udonmod.init;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.world.inventory.StoneMillGuiMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UdonModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, UdonMod.MOD_ID);

	public static void register(IEventBus eventBus)
	{
		REGISTRY.register(eventBus);
	}

	public static final DeferredHolder<MenuType<?>, MenuType<StoneMillGuiMenu>> STONE_MILL_GUI = REGISTRY.register("stone_mill_gui", () -> IMenuTypeExtension.create(StoneMillGuiMenu::new));
}
