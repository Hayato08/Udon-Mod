// java
package net.hayato08.udonmod.item.custom;

import net.hayato08.udonmod.entity.KitsuneFoxEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.bus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KitsuneKatanaItem extends SwordItem {

    private static int foxCounter = 0;
    private static final List<KitsuneFoxEntity> spawnedFoxes = new ArrayList<>();

    public KitsuneKatanaItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
        if (!world.isClientSide) {
            Iterator<KitsuneFoxEntity> iterator = spawnedFoxes.iterator();
            while (iterator.hasNext()) {
                KitsuneFoxEntity f = iterator.next();
                if (!f.isAlive()) {
                    iterator.remove();
                }
            }

            if (spawnedFoxes.size() < 5) {
                KitsuneFoxEntity fox = new KitsuneFoxEntity(EntityType.WOLF, world);
                if (fox != null) {
                    CompoundTag data = fox.getPersistentData();
                    data.putInt("kitsuneID", foxCounter++);
                    long despawnTime = world.getGameTime() + 600;
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
        Iterator<KitsuneFoxEntity> iterator = spawnedFoxes.iterator();
        while (iterator.hasNext()) {
            KitsuneFoxEntity fox = iterator.next();
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