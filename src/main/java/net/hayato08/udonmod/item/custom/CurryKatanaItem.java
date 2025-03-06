package net.hayato08.udonmod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CurryKatanaItem extends SwordItem {
    public CurryKatanaItem(Tier tier, Properties properties) {
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
        // カレーカタナで攻撃したモブを燃やす（5秒間）
        target.setRemainingFireTicks(15 * 20); // 10秒
        return super.hurtEnemy(stack, target, attacker);
    }
}