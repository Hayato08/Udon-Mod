
package net.hayato08.udonmod.entity.custom;

import net.hayato08.udonmod.entity.UdonEntities;
import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.fluids.FluidType;

public class KatsuoEntity extends Monster {
	public final AnimationState animationState0 = new AnimationState();
	public final AnimationState animationState1 = new AnimationState();

	public KatsuoEntity(EntityType<KatsuoEntity> type, Level world)
	{
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.setPathfindingMalus(PathType.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (KatsuoEntity.this.isInWater())
				{
					KatsuoEntity.this.setDeltaMovement(KatsuoEntity.this.getDeltaMovement().add(0, 0.005, 0));
				}
				if (this.operation == Operation.MOVE_TO && !KatsuoEntity.this.getNavigation().isDone())
				{
					double dx = this.wantedX - KatsuoEntity.this.getX();
					double dy = this.wantedY - KatsuoEntity.this.getY();
					double dz = this.wantedZ - KatsuoEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * KatsuoEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					KatsuoEntity.this.setYRot(this.rotlerp(KatsuoEntity.this.getYRot(), f, 10));
					KatsuoEntity.this.yBodyRot = KatsuoEntity.this.getYRot();
					KatsuoEntity.this.yHeadRot = KatsuoEntity.this.getYRot();
					if (KatsuoEntity.this.isInWater())
					{
						KatsuoEntity.this.setSpeed((float) KatsuoEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						KatsuoEntity.this.setXRot(this.rotlerp(KatsuoEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(KatsuoEntity.this.getXRot() * (float) (Math.PI / 180.0));
						KatsuoEntity.this.setZza(f3 * f1);
						KatsuoEntity.this.setYya((float) (f1 * dy));
					}
					else
					{
						KatsuoEntity.this.setSpeed(f1 * 0.05F);
					}
				}
				else
				{
					KatsuoEntity.this.setSpeed(0);
					KatsuoEntity.this.setYya(0);
					KatsuoEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 5, 40));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 5, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = KatsuoEntity.this.getRandom();
				double dir_x = KatsuoEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = KatsuoEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = KatsuoEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 5));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn){
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(UdonItems.KATSUO.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState0.animateWhen(true, this.tickCount);
			this.animationState1.animateWhen(true, this.tickCount);
		}
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	@Override
	public boolean isPushedByFluid() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(UdonEntities.KATSUO.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)), RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(NeoForgeMod.SWIM_SPEED, 3);
		return builder;
	}
}
