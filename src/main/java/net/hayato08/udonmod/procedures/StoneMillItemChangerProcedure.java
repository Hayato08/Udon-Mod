package net.hayato08.udonmod.procedures;

import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.function.Supplier;

public class StoneMillItemChangerProcedure
{
	public static void execute(Entity entity)
	{
		if (entity == null)
			return;
		double slot0 = 0;
		double slot1 = 0;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.WHEAT)
		{
			slot0 = new Object()
			{
				public int getAmount(int sltid)
				{
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
					{
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount(0);

			slot1 = new Object()
			{
				public int getAmount(int sltid)
				{
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
					{
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount(1);

			if (slot0 + slot1 <= 64) // スロット０と１の和が64以下の時
			{
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
				{
					((Slot) _slots.get(0)).remove((int) slot0);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
				{
					ItemStack _setstack = new ItemStack(UdonItems.FLOUR.get()).copy();
					_setstack.setCount((int) (slot0 + slot1));
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else if (slot0 + slot1 > 64) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
				{
					((Slot) _slots.get(0)).remove((int) (64 - slot1));
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
				{
					ItemStack _setstack = new ItemStack(UdonItems.FLOUR.get()).copy();
					_setstack.setCount(64);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
	}
}
