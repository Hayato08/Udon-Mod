package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.block.UdonBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class UdonBlockTagProvider extends BlockTagsProvider {

    public UdonBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UdonMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(UdonBlocks.STONE_MILL.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(UdonBlocks.STONE_MILL.get());
    }

}
