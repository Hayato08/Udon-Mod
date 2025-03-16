package net.hayato08.udonmod.item.katana;

import net.hayato08.udonmod.particle.UdonParticles;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Random;

public class BukkakeKatanaItem extends SwordItem {
    private static final int PARTICLE_COUNT = 80;
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


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 毒を与える
        target.addEffect(new MobEffectInstance(MobEffects.POISON, 20 * 15, 1));

        // パーティクルを生成
        if (target.level() instanceof ServerLevel serverLevel) {
            Vec3 position = target.position().add(0, target.getBbHeight() / 2, 0);

            for (int i = 0; i < PARTICLE_COUNT; i++) {
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

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.udonmod.bukkake_katana"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}