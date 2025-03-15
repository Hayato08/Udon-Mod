package net.hayato08.udonmod.item;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.entity.UdonEntities;
import net.hayato08.udonmod.item.armor.KitsuneArmorItem;
import net.hayato08.udonmod.item.armor.UdonArmorItem;
import net.hayato08.udonmod.item.armor.UdonArmorMaterials;
import net.hayato08.udonmod.item.armor.ZaruArmorItem;
import net.hayato08.udonmod.item.custom.*;
import net.hayato08.udonmod.item.katana.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UdonItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UdonMod.MOD_ID);

    public static final int ATTACK_DAMAGE_OF_COLD_KATANA = 6;
    public static final int ATTACK_DAMAGE_OF_KITSUNE_KATANA = 3;
    public static final int ATTACK_DAMAGE_OF_ZARU_KATANA = 3;
    public static final int ATTACK_DAMAGE_OF_BUKKAKE_KATANA = 1;
    public static final int ATTACK_DAMAGE_OF_CURRY_KATANA = 5;

    public static final DeferredItem<Item> FLOUR =
            ITEMS.register("flour", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OAGE =
            ITEMS.register("oage", () -> new Item(new Item.Properties()));
    // だしの素
    public static final DeferredItem<Item> DASHI =
            ITEMS.register("dashi", () -> new Item(new Item.Properties()));
    // 乾燥うどん
    public static final DeferredItem<Item> DRY_UDON =
            ITEMS.register("dry_udon", () -> new Item(new Item.Properties()));
    // 冷凍うどん
    public static final DeferredItem<Item> ICE_UDON =
            ITEMS.register("ice_udon", () -> new Item(new Item.Properties()));
    // アツアツの素うどん
    public static final DeferredItem<Item> BOILED_UDON =
            ITEMS.register("boiled_udon", () -> new Item(new Item.Properties()));
    // にぼし（乾燥したいわし）
    public static final DeferredItem<Item> DRY_IWASHI =
            ITEMS.register("dry_iwashi", () -> new Item(new Item.Properties()));
    // いわし
    public static final DeferredItem<Item> IWASHI = ITEMS.register("iwashi",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build()
            )));
    // 鰹節
    public static final DeferredItem<Item> DRY_KATSUO =
            ITEMS.register("dry_katsuo", () -> new Item(new Item.Properties()));
    // いわしフレークス
    public static final DeferredItem<Item> IWASHI_FLAKES =
            ITEMS.register("iwashi_flakes", () -> new Item(new Item.Properties()));
    // 削り鰹節
    public static final DeferredItem<Item> KATSUO_FLAKES =
            ITEMS.register("katsuo_flakes", () -> new Item(new Item.Properties()));
    // かつお
    public static final DeferredItem<Item> KATSUO = ITEMS.register("katsuo",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build()
            )));
    // うどんロープ
    public static final DeferredItem<Item> UDON_ROPE =
            ITEMS.register("udon_rope", () -> new Item(new Item.Properties()));
    // 高級だし
    public static final DeferredItem<Item> RICH_DASHI =
            ITEMS.register("rich_dashi", () -> new Item(new Item.Properties()));
    // 生うどん
    public static final DeferredItem<Item> RAW_UDON=
            ITEMS.register("raw_udon", () -> new Item(new Item.Properties()));

    // 武器（剣）kitsune_katana
    public static final DeferredItem<SwordItem> KITSUNE_KATANA =
            ITEMS.register("kitsune_katana", () -> new KitsuneKatanaItem(
                    UdonToolTiers.KITSUNE,
                    new Item.Properties()
                        .attributes(SwordItem.createAttributes(UdonToolTiers.KITSUNE, ATTACK_DAMAGE_OF_KITSUNE_KATANA, -2.4F))
                    )
            );
    // 武器（剣）cold_katana
    public static final DeferredItem<SwordItem> COLD_KATANA =
            ITEMS.register("cold_katana", () -> new ColdKatanaItem(
                    UdonToolTiers.COLD,
                    new Item.Properties()
                            .attributes(SwordItem.createAttributes(UdonToolTiers.COLD, ATTACK_DAMAGE_OF_COLD_KATANA, -2.4F)))
            );

    // 武器（剣）cold_katana
    public static final DeferredItem<SwordItem> ZARU_KATANA =
            ITEMS.register("zaru_katana", () -> new ZaruKatanaItem(
                    UdonToolTiers.ZARU,
                    new Item.Properties()
                            .attributes(SwordItem.createAttributes(UdonToolTiers.ZARU ,ATTACK_DAMAGE_OF_ZARU_KATANA, -2.4F)))
            );

    // 武器（剣）cold_katana
    public static final DeferredItem<SwordItem> BUKKAKE_KATANA =
            ITEMS.register("bukkake_katana", () -> new BukkakeKatanaItem(
                    UdonToolTiers.BUKKAKE,
                    new Item.Properties()
                            .attributes(SwordItem.createAttributes(UdonToolTiers.BUKKAKE, ATTACK_DAMAGE_OF_BUKKAKE_KATANA, -2.4F)))
            );

    // 武器（剣）cold_katana
    public static final DeferredItem<SwordItem> CURRY_KATANA =
            ITEMS.register("curry_katana", () -> new CurryKatanaItem(
                    UdonToolTiers.CURRY,
                    new Item.Properties()
                            .attributes(SwordItem.createAttributes(UdonToolTiers.CURRY, ATTACK_DAMAGE_OF_CURRY_KATANA, -2.4F)))
            );

    // armor items (防具)
    public static final DeferredItem<ArmorItem> KITSUNE_HELMET =
            ITEMS.register("kitsune_helmet",() -> new UdonArmorItem(KitsuneArmorItem.KITSUNE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> KITSUNE_CHESTPLATE =
            ITEMS.register("kitsune_chestplate",() -> new UdonArmorItem(KitsuneArmorItem.KITSUNE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE ,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE .getDurability(19))));
    public static final DeferredItem<ArmorItem> KITSUNE_LEGGINGS =
            ITEMS.register("kitsune_leggings",() -> new UdonArmorItem(KitsuneArmorItem.KITSUNE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> KITSUNE_BOOTS =
            ITEMS.register("kitsune_boots",() -> new UdonArmorItem(KitsuneArmorItem.KITSUNE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    // CURRY_ARMOR
    public static final DeferredItem<ArmorItem> CURRY_HELMET =
            ITEMS.register("curry_helmet",() -> new UdonArmorItem(UdonArmorMaterials.CURRY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> CURRY_CHESTPLATE =
            ITEMS.register("curry_chestplate",() -> new UdonArmorItem(UdonArmorMaterials.CURRY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> CURRY_LEGGINGS =
            ITEMS.register("curry_leggings",() -> new UdonArmorItem(UdonArmorMaterials.CURRY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> CURRY_BOOTS =
            ITEMS.register("curry_boots",() -> new UdonArmorItem(UdonArmorMaterials.CURRY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    // ZARU_ARMOR
    public static final DeferredItem<ArmorItem> ZARU_HELMET =
            ITEMS.register("zaru_helmet",() -> new UdonArmorItem(ZaruArmorItem.ZARU_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> ZARU_CHESTPLATE =
            ITEMS.register("zaru_chestplate",() -> new UdonArmorItem(ZaruArmorItem.ZARU_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> ZARU_LEGGINGS =
            ITEMS.register("zaru_leggings",() -> new UdonArmorItem(ZaruArmorItem.ZARU_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> ZARU_BOOTS =
            ITEMS.register("zaru_boots",() -> new UdonArmorItem(ZaruArmorItem.ZARU_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    // BUKKAKE_ARMOR
    public static final DeferredItem<ArmorItem> BUKKAKE_HELMET =
            ITEMS.register("bukkake_helmet",() -> new UdonArmorItem(UdonArmorMaterials.BUKKAKE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> BUKKAKE_CHESTPLATE =
            ITEMS.register("bukkake_chestplate",() -> new UdonArmorItem(UdonArmorMaterials.BUKKAKE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> BUKKAKE_LEGGINGS =
            ITEMS.register("bukkake_leggings",() -> new UdonArmorItem(UdonArmorMaterials.BUKKAKE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> BUKKAKE_BOOTS =
            ITEMS.register("bukkake_boots",() -> new UdonArmorItem(UdonArmorMaterials.BUKKAKE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    // COLD_ARMOR
    public static final DeferredItem<ArmorItem> COLD_HELMET =
            ITEMS.register("cold_helmet",() -> new UdonArmorItem(UdonArmorMaterials.COLD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> COLD_CHESTPLATE =
            ITEMS.register("cold_chestplate",() -> new UdonArmorItem(UdonArmorMaterials.COLD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> COLD_LEGGINGS =
            ITEMS.register("cold_leggings",() -> new UdonArmorItem(UdonArmorMaterials.COLD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> COLD_BOOTS =
            ITEMS.register("cold_boots",() -> new UdonArmorItem(UdonArmorMaterials.COLD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    // 食料（食べ物）
    // ぶっかけうどん
    public static final DeferredItem<Item> BUKKAKE_UDON =
            ITEMS.register("bukkake_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1) // 満腹度の設定
                    .saturationModifier(0.4f) // 隠し満腹度（満腹時以降の満腹度）
                    .alwaysEdible() // 満腹でも食べられる
                    .effect(new MobEffectInstance(MobEffects.HEAL, 1, 2), 1.0F)
                    .build())));
    // 高級ぶっかけうどん
    public static final DeferredItem<Item> RICH_BUKKAKE_UDON =
            ITEMS.register("rich_bukkake_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2) // 満腹度の設定
                    .saturationModifier(0.5f) // 隠し満腹度（満腹時以降の満腹度）
                    .alwaysEdible() // 満腹でも食べられる
                    .effect(new MobEffectInstance(MobEffects.HEAL, 1, 6), 1.0F)
                    .build())));

    // カレーうどん
    public static final DeferredItem<Item> CURRY_UDON =
            ITEMS.register("curry_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(20) // 満腹度の設定
                    .saturationModifier(0.7f) // 隠し満腹度（満腹時以降の満腹度）
                    .build())));

    // 高級カレーうどん
    public static final DeferredItem<Item> RICH_CURRY_UDON =
            ITEMS.register("rich_curry_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(20) // 満腹度の設定
                    .saturationModifier(0.7f) // 隠し満腹度（満腹時以降の満腹度）
                    .alwaysEdible() // 満腹でも食べられる
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0), 1.0F) //
                    .build())));

    // 冷うどん
    public static final DeferredItem<Item> COLD_UDON =
            ITEMS.register("cold_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5) // 満腹度の設定
                    .saturationModifier(0.4f) // 隠し満腹度（満腹時以降の満腹度）
                    .build())));

    // 高級冷うどん
    public static final DeferredItem<Item> RICH_COLD_UDON =
            ITEMS.register("rich_cold_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(7) // 満腹度の設定
                    .saturationModifier(0.4f) // 隠し満腹度（満腹時以降の満腹度）

                    .build())));

    // きつねうどん
    public static final DeferredItem<Item> KITSUNE_UDON =
            ITEMS.register("kitsune_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5) // 満腹度の設定
                    .saturationModifier(0.4f) // 隠し満腹度（満腹時以降の満腹度）
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F) // 移動速度上昇 30秒間
                    .build())));

    // 高級きつねうどん
    public static final DeferredItem<Item> RICH_KITSUNE_UDON =
            ITEMS.register("rich_kitsune_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(7) // 満腹度の設定
                    .saturationModifier(0.4f) // 隠し満腹度（満腹時以降の満腹度）
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1.0F) // 移動速度上昇２ 1分間
                    .build())));

    // ざるうどん
    public static final DeferredItem<Item> ZARU_UDON =
            ITEMS.register("zaru_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5) // 満腹度の設定
                    .saturationModifier(0.4f) // 隠し満腹度（満腹時以降の満腹度）
                    .fast()
                    .build())));

    // 高級ざるうどん
    public static final DeferredItem<Item> RICH_ZARU_UDON =
            ITEMS.register("rich_zaru_udon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(7) // 満腹度の設定
                    .saturationModifier(0.4f) // 隠し満腹度（満腹時以降の満腹度）
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200*4, 0), 1.0F) // 採掘速度上昇 5分間
                    .fast()
                    .build())));

    // スポーンエッグ
    public static final DeferredItem<Item> WOLFOX_SPAWN_EGG =
            ITEMS.register("wolfox_spawn_egg", () -> new DeferredSpawnEggItem(UdonEntities.WOLFOX, -1, -1, new Item.Properties()));

    public static final DeferredItem<Item> KATSUO_SPWAN_EGG =
            ITEMS.register("katsuo_spawn_egg", () -> new DeferredSpawnEggItem(UdonEntities.KATSUO, -1, -1, new Item.Properties()));

    public static final DeferredItem<Item> IWASHI_SPAWN_EGG =
            ITEMS.register("iwashi_spawn_egg", () -> new DeferredSpawnEggItem(UdonEntities.IWASHI, -1, -1, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
