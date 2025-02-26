package net.hayato08.udonmod.procedures;

import io.netty.buffer.Unpooled;
import net.hayato08.udonmod.block.UdonBlocks;
import net.hayato08.udonmod.world.inventory.StoneMillGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StoneMillGuiOpenProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		// 対象の手でない場合は何もしない
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		// プレイヤーがいる場合
		if (event.getEntity() instanceof Player player)
		{
			// スニーク中の場合は、GUIオープンを行わず通常の処理（ブロック設置など）に任せる
			if (player.isShiftKeyDown())
				return;
			// スニークしていない場合で、対象ブロックが石臼ならGUIを開いてイベントをキャンセルする
			if (event.getLevel().getBlockState(event.getPos()).getBlock() == UdonBlocks.STONE_MILL.get()) {
				execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
				event.setCanceled(true);  // ここでイベントをキャンセルして、ブロック設置処理を止める
			}
		}
	}



	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UdonBlocks.STONE_MILL.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("StoneMillGui");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new StoneMillGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
