package net.hayato08.udonmod.util;

import net.hayato08.udonmod.UdonMod;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class UdonTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_UDON_TOOL = createTag("needs_udon_tool");
        public static final TagKey<Block> INCCORECT_FOR_UDON_TOOL = createTag("incorrect_for_udon_tool");

        private static TagKey<Block> createTag(String name)
        {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> UDON_FOODS = createTag("udon_foods");
        public static final TagKey<Item> UDON_KATANA = createTag("udon_katana");
        public static final TagKey<Item> UDON_CHANGEABL_TO_POWDER = createTag("udon_changeable_to_powder");
        private static TagKey<Item> createTag(String name)
        {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, name));
        }
    }
}
