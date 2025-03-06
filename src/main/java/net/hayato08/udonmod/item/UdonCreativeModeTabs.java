package net.hayato08.udonmod.item;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.block.UdonBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UdonCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UdonMod.MOD_ID);

    public static final Supplier<CreativeModeTab> UDON_ITEMS_TAB = CREATIVE_MODE_TAB.register("udon_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(UdonItems.FLOUR.get())) // タブのアイコン
                    .title(Component.translatable("creativetab.udonmod.udon_items")) // タブのタイトル
                    .displayItems(((itemDisplayParameters, output) -> // そのタブに表示するアイテム
                    {
                        output.accept(UdonItems.DASHI);
                        output.accept(UdonItems.DRY_IWASHI);
                        output.accept(UdonItems.DRY_KATSUO);
                        output.accept(UdonItems.DRY_UDON);
                        output.accept(UdonItems.FLOUR);
                        output.accept(UdonItems.IWASHI);
                        output.accept(UdonItems.KATSUO);
                        output.accept(UdonItems.KATSUO_FLAKES);
                        output.accept(UdonItems.RAW_UDON);
                        output.accept(UdonItems.RICH_DASHI);
                        output.accept(UdonItems.UDON_ROPE);
                        output.accept(UdonItems.BOILED_UDON);
                        output.accept(UdonItems.OAGE);
                        output.accept(UdonItems.ICE_UDON);
                    }))

                    .build());

    // 武器・防具のタブ
    public static final Supplier<CreativeModeTab> UDON_TOOLS_TAB = CREATIVE_MODE_TAB.register("udon_tools_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(UdonItems.KITSUNE_HELMET.get())) // タブのアイコン
                .withTabsBefore(ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, "udon_items_tab")) //タブの場所（パスで指定したタブの右側に追加）
                .title(Component.translatable("creativetab.udonmod.udon_tools")) // タブのタイトル
                .displayItems(((itemDisplayParameters, output) -> // そのタブに表示するアイテム
                {
                    output.accept(UdonItems.KITSUNE_HELMET);
                    output.accept(UdonItems.KITSUNE_CHESTPLATE);
                    output.accept(UdonItems.KITSUNE_LEGGINGS);
                    output.accept(UdonItems.KITSUNE_BOOTS);
                    output.accept(UdonItems.KITSUNE_KATANA);
                    output.accept(UdonItems.COLD_KATANA);
                    output.accept(UdonItems.CURRY_KATANA);
                    output.accept(UdonItems.BUKKAKE_KATANA);
                    output.accept(UdonItems.ZARU_KATANA);

                }))

                .build());

    public static final Supplier<CreativeModeTab> UDON_FOODS_TAB = CREATIVE_MODE_TAB.register("udon_foods_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(UdonItems.BUKKAKE_UDON.get())) // タブのアイコン
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, "udon_tools_tab")) //タブの場所（パスで指定したタブの右側に追加）
                    .title(Component.translatable("creativetab.udonmod.udon_foods")) // タブのタイトル
                    .displayItems(((itemDisplayParameters, output) -> // そのタブに表示するアイテム
                    {
                        output.accept(UdonItems.BUKKAKE_UDON);
                        output.accept(UdonItems.RICH_BUKKAKE_UDON);
                        output.accept(UdonItems.COLD_UDON);
                        output.accept(UdonItems.RICH_COLD_UDON);
                        output.accept(UdonItems.CURRY_UDON);
                        output.accept(UdonItems.RICH_CURRY_UDON);
                        output.accept(UdonItems.KITSUNE_UDON);
                        output.accept(UdonItems.RICH_KITSUNE_UDON);
                        output.accept(UdonItems.ZARU_UDON);
                        output.accept(UdonItems.RICH_ZARU_UDON);
                    }))

                    .build());

    public static final Supplier<CreativeModeTab> UDON_FUNCTIONAL_BLOCKS_TAB = CREATIVE_MODE_TAB.register("udon_functional_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(UdonBlocks.STONE_MILL.get())) // タブのアイコン
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, "udon_foods_tab")) //タブの場所（パスで指定したタブの右側に追加)
                    .title(Component.translatable("creativetab.udonmod.udon_tools")) // タブのタイトル
                    .displayItems(((itemDisplayParameters, output) -> // そのタブに表示するアイテム
                    {
                        output.accept(UdonBlocks.STONE_MILL);
                    }))

                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
