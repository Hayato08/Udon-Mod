package net.hayato08.udonmod.item.custom;

import net.hayato08.udonmod.entity.UdonEntities;
import net.hayato08.udonmod.entity.custom.WolFoxEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.bus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KitsuneKatanaItem extends SwordItem {

    private static int foxCounter = 0;
    private static final int DESPAWN_TIME = 20 * 30; // 30 seconds
    private static final int MAX_FOXES = 5;
    private static final List<WolFoxEntity> spawnedFoxes = new ArrayList<>();

    public KitsuneKatanaItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return this.getTier().getEnchantmentValue(); // Ensures the enchantability value is used
    }


    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        // 素手でブロックを破壊できるかどうか
        if (state.requiresCorrectToolForDrops()) // ブロックを破壊できない（ドロップに適正なツールが必要）
        {
            return super.isCorrectToolForDrops(stack, state);
        } else {
            return true; // ブロックを破壊できる
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
        if (!world.isClientSide) {
            spawnedFoxes.removeIf(f -> !f.isAlive());

            if (spawnedFoxes.size() < MAX_FOXES) {
                WolFoxEntity fox = new WolFoxEntity(UdonEntities.WOLFOX.get(), world);
                if (fox != null) {
                    // キツネをプレイヤーに飼いならす
                    if (attacker instanceof Player player) {
                        fox.tame(player);
                    }

                    // 攻撃したエンティティをキツネのターゲットに設定
                    fox.setTarget(target);

                    CompoundTag data = fox.getPersistentData();
                    data.putInt("kitsuneID", foxCounter++);
                    long despawnTime = world.getGameTime() + DESPAWN_TIME;
                    data.putLong("despawnTime", despawnTime);

                    fox.moveTo(target.getX(), target.getY(), target.getZ(), target.getYRot(), target.getXRot());
                    world.addFreshEntity(fox);
                    spawnedFoxes.add(fox);
                }
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        Iterator<WolFoxEntity> iterator = spawnedFoxes.iterator();
        while (iterator.hasNext()) {
            WolFoxEntity fox = iterator.next();
            if (!fox.isAlive()) {
                iterator.remove();
                continue;
            }
            CompoundTag data = fox.getPersistentData();
            long despawnTime = data.getLong("despawnTime");
            if (fox.level().getGameTime() >= despawnTime) {
                fox.remove(Fox.RemovalReason.DISCARDED);
                iterator.remove();
            }
        }
    }
}