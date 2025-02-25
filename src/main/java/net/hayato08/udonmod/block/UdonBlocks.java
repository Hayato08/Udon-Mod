package net.hayato08.udonmod.block;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.naming.directory.ModificationItem;
import java.util.function.Supplier;

public class UdonBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UdonMod.MOD_ID);

    // レジストリに登録
    public static final DeferredBlock<Block> STONE_MILL =
            registerBlock("stone_mill", () ->  new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONECUTTER)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        UdonItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

}
