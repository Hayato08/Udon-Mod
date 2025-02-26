package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.item.UdonItems;
import net.hayato08.udonmod.util.UdonTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class UdonItemTagProvider extends ItemTagsProvider {
    public UdonItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, UdonMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // 食べ物
        tag(UdonTags.Items.UDON_FOODS)
                .add(UdonItems.BUKKAKE_UDON.get())
                .add(UdonItems.RICH_BUKKAKE_UDON.get())
                .add(UdonItems.COLD_UDON.get())
                .add(UdonItems.RICH_COLD_UDON.get())
                .add(UdonItems.CURRY_UDON.get())
                .add(UdonItems.RICH_CURRY_UDON.get())
                .add(UdonItems.KITSUNE_UDON.get())
                .add(UdonItems.RICH_KITSUNE_UDON.get())
                .add(UdonItems.ZARU_UDON.get())
                .add(UdonItems.RICH_ZARU_UDON.get());

        // 石臼で使えるもの
        tag(UdonTags.Items.UDON_CHANGEABL_TO_POWDER)
                .add(UdonItems.DRY_KATSUO.get())
                .add(Items.WHEAT)
                .add(UdonItems.DRY_IWASHI.get());
    }
}
