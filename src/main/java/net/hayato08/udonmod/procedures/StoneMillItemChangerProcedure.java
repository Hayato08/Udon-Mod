package net.hayato08.udonmod.procedures;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.item.UdonItems;
import net.hayato08.udonmod.sound.UdonSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

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
			// スロット0にあるアイテムの個数
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

			// スロット1にあるアイテムの個数
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
				if (entity instanceof Player _player) {
					_player.level().playSound(
							null,
							_player.getX(), _player.getY(), _player.getZ(),
							UdonSounds.STONE_MILL_USE.get(),
							SoundSource.BLOCKS,
							1.0F, 1.0F
					);
				}

				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
				{
					// スロット０のアイテムを削除
					((Slot) _slots.get(0)).remove((int) slot0);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
				{
					// スロット０にあった個数分、スロット1に小麦粉を追加
					ItemStack _setstack = new ItemStack(UdonItems.FLOUR.get()).copy();
					_setstack.setCount((int) (slot0 + slot1));
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}

			}
			else if (slot0 + slot1 > 64) //スロット０と１の合計が64個を超える場合
			{
				if(slot1 != 64) // スロット０が64でないとき
				{
					if (entity instanceof Player _player)
					{
						_player.level().playSound(
								null,
								_player.getX(), _player.getY(), _player.getZ(),
								UdonSounds.STONE_MILL_USE.get(),
								SoundSource.BLOCKS,
								1.0F, 1.0F
						);
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
					{
						// スロット１にあるアイテムの個数と64との差分をスロット０から削除
						((Slot) _slots.get(0)).remove((int) (64 - slot1));
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots)
					{
						// スロット１に64個の小麦粉を追加
						ItemStack _setstack = new ItemStack(UdonItems.FLOUR.get()).copy();
						_setstack.setCount(64);
						((Slot) _slots.get(1)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}

			}
		}
	}
}
