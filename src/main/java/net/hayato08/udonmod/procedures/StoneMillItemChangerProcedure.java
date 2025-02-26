package net.hayato08.udonmod.procedures;

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

// ボタンが押されたらこのクラスのexecuteメソッドが呼び出される
public class StoneMillItemChangerProcedure
{
	public static void execute(Entity entity)
	{
		if (entity == null)
			return;
		double slot0 = 0;
		double slot1 = 0;

		// スロット０に小麦が入っているとき
		if ((entity instanceof Player pPpayerSlotItem && pPpayerSlotItem.containerMenu instanceof Supplier pSupplier &&
				pSupplier.get() instanceof Map pSlot ? ((Slot) pSlot.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.WHEAT)
		{
			slot0 = getAmount(entity, 0); // スロット0にあるアイテムの個数
			slot1 = getAmount(entity, 1); // スロット1にあるアイテムの個数

			ItemStack pSetstack = new ItemStack(UdonItems.FLOUR.get()).copy(); // 変換するアイテムを取得

			if(slot1 != 0) //スロット１に何かアイテムがあるとき
			{
				// スロット１のアイテムが小麦粉のとき
				if ((entity instanceof Player pPpayerSlotItem && pPpayerSlotItem.containerMenu instanceof Supplier pSupplier &&
						pSupplier.get() instanceof Map pSlot ? ((Slot) pSlot.get(1)).getItem() : ItemStack.EMPTY).getItem() == UdonItems.FLOUR.get())
				{
					itemCanger(entity, pSetstack, slot0, slot1);
				}
			}
			else // スロット１にアイテムがないとき
			{
				// アイテムを変換
				itemCanger(entity, pSetstack, slot0, slot1);
			}
		}
		// かつお節を削り鰹節にする
		else if((entity instanceof Player pPlayerSlotItem && pPlayerSlotItem.containerMenu instanceof Supplier pSupplier &&
				pSupplier.get() instanceof Map pSlot ? ((Slot) pSlot.get(0)).getItem() : ItemStack.EMPTY).getItem() == UdonItems.DRIED_KATSUO.get())
		{
			slot0 = getAmount(entity, 0); // スロット0にあるアイテムの個数
			slot1 = getAmount(entity, 1); // スロット1にあるアイテムの個数

			ItemStack pSetstack = new ItemStack(UdonItems.KATSUO_FLAKES.get()).copy(); // 変換するアイテムを取得

			if(slot1 != 0) //スロット１に何かアイテムがあるとき
			{
				// スロット１のアイテムが削り鰹節のとき
				if ((entity instanceof Player pPpayerSlotItem && pPpayerSlotItem.containerMenu instanceof Supplier pSupplier &&
						pSupplier.get() instanceof Map pSlot ? ((Slot) pSlot.get(1)).getItem() : ItemStack.EMPTY).getItem() == UdonItems.KATSUO_FLAKES.get())
				{
					itemCanger(entity, pSetstack, slot0, slot1);
				}
			}
			else // スロット１にアイテムがないとき
			{
				// アイテムを変換
				itemCanger(entity, pSetstack, slot0, slot1);
			}
		}
	}

	// 石臼使用時の音を再生
	public static void playStoneMillSound (Player pPlayer)
	{
		pPlayer.level().playSound(
				null,
				pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
				UdonSounds.STONE_MILL_USE.get(),
				SoundSource.BLOCKS,
				1.0F, 1.0F
		);
	}

	/*
	    アイテムを変換するメソッド
	    第1引数は対象のエンティティ
	    第2引数は変換後のアイテム
	    第3、第4引数は各スロットのアイテムの個数
	    第4引数は2つのスロットの個数の合計値が64を超える場合は真
	    Usage:
			<ItemStack pSetstack = new ItemStack(UdonItems.FLOUR.get()).copy();>
			 itemCanger(entity, pSetstack, slot0, slot1, true);
	*/

	public static void itemCanger(Entity entity, ItemStack pSetstack, double slot0, double slot1)
	{
		if(slot0 + slot1 <= 64)
		{
			if (entity instanceof Player pPlayer) {
				playStoneMillSound(pPlayer);
			}
			if (entity instanceof Player pPlayer && pPlayer.containerMenu instanceof Supplier _current && _current.get() instanceof Map pSlots)
			{

				((Slot) pSlots.get(0)).remove((int) slot0); // スロット０のアイテムを削除
				pSetstack.setCount((int) (slot0 + slot1)); // スロット０にあった個数分、スロット1にアイテムを追加
				((Slot) pSlots.get(1)).set(pSetstack);
				pPlayer.containerMenu.broadcastChanges();
			}
		}
		else if(slot0 + slot1 > 64 && slot1 != 64)
		{
			if (entity instanceof Player pPlayer) {
				playStoneMillSound(pPlayer);
			}
			if (entity instanceof Player pPlayer && pPlayer.containerMenu instanceof Supplier _current && _current.get() instanceof Map pSlots)
			{
				((Slot) pSlots.get(0)).remove((int) (64 - slot1)); // スロット１にあるアイテムの個数と64との差分をスロット０から削除
				pSetstack.setCount(64); // スロット１に64個のアイテムを追加
				((Slot) pSlots.get(1)).set(pSetstack);
				pPlayer.containerMenu.broadcastChanges();
			}
		}
	}
	// 各スロットのアイテムの個数を取得
	public static int getAmount(Entity entity, int slotNo)
	{
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map pSlots)
		{
			ItemStack stack = ((Slot) pSlots.get(slotNo)).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}
