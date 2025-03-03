package net.hayato08.udonmod.item.custom;

import net.hayato08.udonmod.client.model.KitsuneArmorModel;
import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class KitsuneItem extends ArmorItem {
	public static Holder<ArmorMaterial> KITSUNE_ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(Type.class), map -> {
				map.put(Type.BOOTS, 3);
				map.put(Type.LEGGINGS, 5);
				map.put(Type.CHESTPLATE, 6);
				map.put(Type.HELMET, 3);
				map.put(Type.BODY, 11);
			}), 9, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.FOX_AMBIENT),
					() -> Ingredient.of(), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("udonmod:udon_kitsune_armor"))),
					0f, 0f);
			registerHelper.register(ResourceLocation.parse("udonmod:kitsune"), armorMaterial);
			KITSUNE_ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
						Map.of("head", new KitsuneArmorModel(Minecraft.getInstance().getEntityModels().bakeLayer(KitsuneArmorModel.LAYER_LOCATION)).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body",
								new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, UdonItems.KITSUNE_HELMET.get());

		event.registerItem(new IClientItemExtensions() {
			@Override
			@OnlyIn(Dist.CLIENT)
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", new KitsuneArmorModel(Minecraft.getInstance().getEntityModels().bakeLayer(KitsuneArmorModel.LAYER_LOCATION)).Body1, "left_arm",
						new KitsuneArmorModel(Minecraft.getInstance().getEntityModels().bakeLayer(KitsuneArmorModel.LAYER_LOCATION)).LeftArm1, "right_arm",
						new KitsuneArmorModel(Minecraft.getInstance().getEntityModels().bakeLayer(KitsuneArmorModel.LAYER_LOCATION)).RightArm1, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
						new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, UdonItems.KITSUNE_CHESTPLATE.get());

		event.registerItem(new IClientItemExtensions() {
			@Override
			@OnlyIn(Dist.CLIENT)
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
						Map.of("left_leg", new KitsuneArmorModel(Minecraft.getInstance().getEntityModels().bakeLayer(KitsuneArmorModel.LAYER_LOCATION)).LeftLeg1, "right_leg",
								new KitsuneArmorModel(Minecraft.getInstance().getEntityModels().bakeLayer(KitsuneArmorModel.LAYER_LOCATION)).RightLeg1, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
								new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, UdonItems.KITSUNE_BOOTS.get());
	}

	public KitsuneItem(Type type, Properties properties) {
		super(KITSUNE_ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends KitsuneItem {
		public Helmet() {
			super(Type.HELMET, new Properties().durability(Type.HELMET.getDurability(15)));
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("udonmod:textures/entities/kitsune_layer_1.png");
		}
	}

	public static class Chestplate extends KitsuneItem {
		public Chestplate() {
			super(Type.CHESTPLATE, new Properties().durability(Type.CHESTPLATE.getDurability(15)));
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("udonmod:textures/entities/kitsune_layer_1.png");
		}
	}

	public static class Leggings extends KitsuneItem {
		public Leggings() {
			super(Type.LEGGINGS, new Properties().durability(Type.LEGGINGS.getDurability(15)));
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("udonmod:textures/entities/kitsune_layer2.png");
		}
	}

	public static class Boots extends KitsuneItem {
		public Boots() {
			super(Type.BOOTS, new Properties().durability(Type.BOOTS.getDurability(15)));
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("udonmod:textures/entities/kitsune_layer_1.png");
		}
	}
}
