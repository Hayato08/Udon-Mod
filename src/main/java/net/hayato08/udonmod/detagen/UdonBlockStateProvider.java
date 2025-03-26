package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.block.UdonBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class UdonBlockStateProvider extends BlockStateProvider {
    public UdonBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UdonMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(UdonBlocks.STONE_MILL);

        // Special case for Universal Cooking Block with different textures
        var block = UdonBlocks.UNIVERSAL_COOKING_BLOCK.get();
        var side = modLoc("block/universal_cooking_block_1");
        var topBottom = modLoc("block/universal_cooking_block_2");

        var model = models().cubeBottomTop(
                "block/universal_cooking_block",  // model name
                side,       // side texture
                topBottom,  // bottom texture
                topBottom   // top texture
        );

        simpleBlockWithItem(block, model);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}