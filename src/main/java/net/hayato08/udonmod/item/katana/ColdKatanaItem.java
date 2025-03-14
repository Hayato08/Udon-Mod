package net.hayato08.udonmod.item.katana;

import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ColdKatanaItem extends SwordItem {
    public ColdKatanaItem(Tier tier, Item.Properties properties) {
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
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level level = attacker.level();
        if (level.dimension() == Level.NETHER) {
            // ネザーでの攻撃時、追加ダメージを与える
            float extraDamage = UdonItems.ATTACK_DAMAGE_OF_COLD_KATANA * 1.5f; // 基本ダメージの50%を追加
            target.hurt(level.damageSources().playerAttack((Player) attacker), extraDamage);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}