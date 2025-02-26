package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class UdonItemModelProvider extends ItemModelProvider {
    public UdonItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UdonMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(UdonItems.DASHI.get());
        basicItem(UdonItems.DRY_IWASHI.get());
        basicItem(UdonItems.DRY_KATSUO.get());
        basicItem(UdonItems.DRY_UDON.get());
        basicItem(UdonItems.FLOUR.get());
        basicItem(UdonItems.IWASHI.get());
        basicItem(UdonItems.KATSUO.get());
        basicItem(UdonItems.KATSUO_FLAKES.get());
        basicItem(UdonItems.RAW_UDON.get());
        basicItem(UdonItems.RICH_DASHI.get());
        basicItem(UdonItems.ICE_UDON.get());
        basicItem(UdonItems.UDON_ROPE.get());
        basicItem(UdonItems.BUKKAKE_UDON.get());
        basicItem(UdonItems.RICH_BUKKAKE_UDON.get());
        basicItem(UdonItems.COLD_UDON.get());
        basicItem(UdonItems.RICH_COLD_UDON.get());
        basicItem(UdonItems.CURRY_UDON.get());
        basicItem(UdonItems.RICH_CURRY_UDON.get());
        basicItem(UdonItems.KITSUNE_UDON.get());
        basicItem(UdonItems.RICH_KITSUNE_UDON.get());
        basicItem(UdonItems.ZARU_UDON.get());
        basicItem(UdonItems.RICH_ZARU_UDON.get());
        basicItem(UdonItems.BOILED_UDON.get());
        basicItem(UdonItems.OAGE.get());


    }
}
