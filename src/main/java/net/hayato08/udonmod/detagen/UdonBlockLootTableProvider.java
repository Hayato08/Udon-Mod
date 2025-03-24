package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.block.UdonBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class UdonBlockLootTableProvider extends BlockLootSubProvider {
    protected UdonBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(UdonBlocks.STONE_MILL.get());
        dropSelf(UdonBlocks.UNIVERSAL_COOKING_BLOCK.get());

        add(UdonBlocks.STONE_MILL.get(),
                block -> createBannerDrop(UdonBlocks.STONE_MILL.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return UdonBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
