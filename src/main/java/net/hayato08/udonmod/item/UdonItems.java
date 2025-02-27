package net.hayato08.udonmod.item;

import net.hayato08.udonmod.UdonMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UdonItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UdonMod.MOD_ID);

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
    public static final DeferredItem<Item> IWASHI=
            ITEMS.register("iwashi", () -> new Item(new Item.Properties()));
    // 鰹節
    public static final DeferredItem<Item> DRY_KATSUO =
            ITEMS.register("dry_katsuo", () -> new Item(new Item.Properties()));
    // 削り鰹節
    public static final DeferredItem<Item> KATSUO_FLAKES =
            ITEMS.register("katsuo_flakes", () -> new Item(new Item.Properties()));
    // かつお
    public static final DeferredItem<Item> KATSUO =
            ITEMS.register("katsuo", () -> new Item(new Item.Properties()));
    // うどんロープ
    public static final DeferredItem<Item> UDON_ROPE =
            ITEMS.register("udon_rope", () -> new Item(new Item.Properties()));
    // 高級だし
    public static final DeferredItem<Item> RICH_DASHI =
            ITEMS.register("rich_dashi", () -> new Item(new Item.Properties()));
    // 生うどん
    public static final DeferredItem<Item> RAW_UDON=
            ITEMS.register("raw_udon", () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> KITSUNE_HELMET =
            ITEMS.register("kitsune_helmet", KitsuneItem.Helmet::new);

    public static final DeferredItem<Item> KITSUNE_CHESTPLATE =
            ITEMS.register("kitsune_chestplate", KitsuneItem.Chestplate::new);

    public static final DeferredItem<Item> KITSUNE_LEGGINGS =
            ITEMS.register("kitsune_leggings", KitsuneItem.Leggings::new);

    public static final DeferredItem<Item> KITSUNE_BOOTS =
            ITEMS.register("kitsune_boots", KitsuneItem.Boots::new);

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
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200*5, 0), 1.0F) // 採掘速度上昇 5分間
                    .fast()
                    .build())));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
