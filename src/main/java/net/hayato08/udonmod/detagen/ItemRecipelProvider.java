package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.block.UdonBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ItemRecipelProvider extends RecipeProvider {
    public ItemRecipelProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonBlocks.STONE_MILL.get())
                .pattern("ABB")
                .pattern("ABB")
                .pattern("CCC")
                .define('A', Tags.Items.RODS_WOODEN)
                .define('B', ItemTags.STONE_TOOL_MATERIALS)
                .define('C', Items.STONE)
                .unlockedBy("has_stone", has(Items.STONE)).save(recipeOutput);
        /*
        // 形状のないレシピの例（形状のないレシピとは、クラフトする際にどこに何をおいてもクラフトできるようなもの。例：石炭ブロック、たわら等）
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.EXMAPLE.get(),howManyCrafted)
                .requires(UdonBlocks.EXAMPLE_BLOCK)
                .unlockedBy("has_?????_!!!!!", has(UdonBlocks.EXAMPLE_BLOCK)).save(recipeOutput, "udonmod:example");

         */
    }
}
