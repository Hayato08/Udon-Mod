package net.hayato08.udonmod.item.custom;

import net.hayato08.udonmod.particle.UdonParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class BukkakeKatanaItem extends SwordItem {
    private final Random random = new Random();

    public BukkakeKatanaItem(Tier tier, Properties properties) {
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

    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.canEnchant(stack) ||
                enchantment.canEnchant(Items.DIAMOND_SWORD.getDefaultInstance());
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Apply poison effect
        target.addEffect(new MobEffectInstance(MobEffects.POISON, 20 * 15, 1));

        // Create gray splash particles
        if (target.level() instanceof ServerLevel serverLevel) {
            Vec3 position = target.position().add(0, target.getBbHeight() / 2, 0);

            // Generate gray splash particles around the entity
            for (int i = 0; i < 20; i++) {
                double offsetX = random.nextDouble() - 0.5;
                double offsetY = random.nextDouble() * 0.5;
                double offsetZ = random.nextDouble() - 0.5;

                serverLevel.sendParticles(
                        UdonParticles.GRAY_SPLASH.get(),
                        position.x + offsetX,
                        position.y + offsetY,
                        position.z + offsetZ,
                        1, 0, 0.1, 0, 0.2
                );
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }
}