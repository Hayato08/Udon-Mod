package net.hayato08.udonmod.entity;

import net.hayato08.udonmod.UdonMod;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;


public class WolFoxEntity extends TamableAnimal {

    public WolFoxEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
    }


    public static AttributeSupplier.Builder createFoxAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(5, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new RandomSoundGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Mob.class, 10, true, false,
                (entity) -> {
                    // Wolfoxは攻撃しない
                    if (entity instanceof WolFoxEntity) {
                        return false;
                    }
                    // 飼いならされたキツネは攻撃しない
                    if (entity instanceof TamableAnimal tamable && tamable.isTame()) {
                        return false;
                    }
                    // プレイヤー（の所有物）は攻撃しない
                    if (this.getOwner() != null && entity == this.getOwner()) {
                        return false;
                    }
                    // プレイヤーが攻撃したエンティティか、モンスターのみを攻撃対象とする
                    return entity == this.getTarget() || entity.getType().getCategory() == MobCategory.MONSTER;
                }));
    }

    @Override
    public Component getDisplayName() {
        if (this.hasCustomName()) {
            return this.getCustomName();
        }
        return Component.translatable("entity." + UdonMod.MOD_ID + ".wolfox");
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        // 攻撃対象がWolfoxの場合は無視する
        if (target instanceof WolFoxEntity) {
            return;
        }
        super.setTarget(target);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        // ダメージソースがプレイヤーの場合はダメージを受けない
        if (source.getEntity() instanceof Player)
        {
            return true; // The attack "hit" but did no damage
        }
        // Keep existing logic for WolFox attackers
        if (source.getEntity() instanceof WolFoxEntity) {
            this.setTarget(null);
        }

        // Process damage normally for non-player sources
        return super.hurt(source, amount);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.FOX_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.FOX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.FOX_DEATH;
    }

    // Custom RandomSoundGoal for fox sounds
    public static class RandomSoundGoal extends Goal {
        private final WolFoxEntity fox;
        private int nextSoundTime;

        public RandomSoundGoal(WolFoxEntity fox) {
            this.fox = fox;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            if (this.fox.isAggressive()) {
                return false;
            } else if (this.fox.getRandom().nextInt(100) != 0) {
                return false;
            } else {
                return this.nextSoundTime <= 0;
            }
        }

        @Override
        public boolean canContinueToUse() {
            return this.nextSoundTime > 0;
        }

        @Override
        public void start() {
            this.nextSoundTime = 40 + this.fox.getRandom().nextInt(40);
            this.fox.playSound(SoundEvents.FOX_AMBIENT, 1.0F, 1.0F);
        }

        @Override
        public void tick() {
            this.nextSoundTime--;
        }
    }
}
