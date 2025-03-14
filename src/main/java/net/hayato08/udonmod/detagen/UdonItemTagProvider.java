package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.item.UdonItems;
import net.hayato08.udonmod.util.UdonTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
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

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(UdonItems.KITSUNE_HELMET.get())
                .add(UdonItems.KITSUNE_CHESTPLATE.get())
                .add(UdonItems.KITSUNE_LEGGINGS.get())
                .add(UdonItems.KITSUNE_BOOTS.get());

        tag(UdonTags.Items.UDON_KATANA)
                .add(UdonItems.ZARU_KATANA.get())
                .add(UdonItems.CURRY_KATANA.get())
                .add(UdonItems.BUKKAKE_KATANA.get())
                .add(UdonItems.COLD_KATANA.get())
                .add(UdonItems.KITSUNE_KATANA.get());

        tag(ItemTags.SWORDS)
                .add(UdonItems.KITSUNE_KATANA.get())
                .add(UdonItems.ZARU_KATANA.get())
                .add(UdonItems.COLD_KATANA.get())
                .add(UdonItems.CURRY_KATANA.get())
                .add(UdonItems.BUKKAKE_KATANA.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(UdonItems.KITSUNE_HELMET.get())
                .add(UdonItems.CURRY_HELMET.get());
        tag(ItemTags.CHEST_ARMOR)
                .add(UdonItems.KITSUNE_CHESTPLATE.get())
                .add(UdonItems.CURRY_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR)
                .add(UdonItems.KITSUNE_LEGGINGS.get())
                .add(UdonItems.CURRY_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR)
                .add(UdonItems.KITSUNE_BOOTS.get())
                .add(UdonItems.CURRY_BOOTS.get());
    }
}
