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
    protected void registerStatesAndModels()
    {
        blockWithItem(UdonBlocks.STONE_MILL);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
