package net.hayato08.udonmod.item.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

// ぶっかけアーマーを装備していると、モンスターからの攻撃を25%の確率で無効化する
public class BukkakeArmorAttackNegation {
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (!hasFullBukkakeArmor(player)) {
            return;
        }
        Entity attacker = event.getSource().getEntity();
        if (attacker instanceof Monster) {
            // 25%の確率で攻撃を無効化
            if (player.level().random.nextFloat() < 0.25f) {
                event.setNewDamage(0.0f);
            }
        }
    }

    private static boolean hasFullBukkakeArmor(Player player) {
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (!(armorStack.getItem() instanceof ArmorItem armorItem)
                    || armorItem.getMaterial() != UdonArmorMaterials.BUKKAKE_ARMOR_MATERIAL) {
                return false;
            }
        }
        return true;
    }
}