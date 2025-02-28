package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.block.UdonBlocks;
import net.hayato08.udonmod.item.UdonItems;
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
    protected void buildRecipes(RecipeOutput recipeOutput)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.RAW_UDON.get())
                .pattern("AB")
                .define('A', UdonItems.FLOUR)
                .define('B', Items.EGG)
                .unlockedBy("has_flour", has(UdonItems.FLOUR)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonBlocks.STONE_MILL.get())
                .pattern("ABB")
                .pattern("ABB")
                .pattern("CCC")
                .define('A', Tags.Items.RODS_WOODEN)
                .define('B', ItemTags.STONE_TOOL_MATERIALS)
                .define('C', Items.STONE)
                .unlockedBy("has_stone", has(Items.STONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.RICH_DASHI.get())
                .pattern("AB")
                .define('A', UdonItems.DASHI)
                .define('B', UdonItems.DRY_IWASHI)
                .unlockedBy("has_iwashi", has(UdonItems.DRY_IWASHI)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.BUKKAKE_UDON.get())
                .pattern("AB")
                .define('A', UdonItems.BOILED_UDON)
                .define('B', UdonItems.DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.RICH_BUKKAKE_UDON.get())
                .pattern("AB")
                .define('A', UdonItems.BOILED_UDON)
                .define('B', UdonItems.RICH_DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.RICH_COLD_UDON.get())
                .pattern("AB")
                .define('A', UdonItems.ICE_UDON)
                .define('B', UdonItems.RICH_DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.COLD_UDON.get())
                .pattern("AB")
                .define('A', UdonItems.ICE_UDON)
                .define('B', UdonItems.DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.ICE_UDON.get())
                .pattern(" B ")
                .pattern("BAB")
                .pattern(" B ")
                .define('A', UdonItems.RAW_UDON)
                .define('B', Items.ICE)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.ZARU_UDON.get())
                .pattern(" C ")
                .pattern("BAB")
                .pattern(" B ")
                .define('A', UdonItems.BOILED_UDON)
                .define('B', Items.ICE)
                .define('C', UdonItems.DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.RICH_ZARU_UDON.get())
                .pattern(" C ")
                .pattern("BAB")
                .pattern(" B ")
                .define('A', UdonItems.BOILED_UDON)
                .define('B', Items.ICE)
                .define('C', UdonItems.RICH_DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.UDON_ROPE.get())
                .pattern("AB")
                .define('A', UdonItems.RAW_UDON)
                .define('B', Items.SLIME_BALL)
                .unlockedBy("has_slime_ball", has(Items.SLIME_BALL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.KITSUNE_HELMET.get())
                        .pattern("AAA")
                        .pattern("A A")
                        .define('A', UdonItems.OAGE)
                        .unlockedBy("has_oage", has(UdonItems.OAGE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.KITSUNE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', UdonItems.OAGE)
                .unlockedBy("has_oage", has(UdonItems.OAGE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.KITSUNE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.OAGE)
                .unlockedBy("has_oage", has(UdonItems.OAGE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.KITSUNE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.OAGE)
                .unlockedBy("has_oage", has(UdonItems.OAGE.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.CURRY_UDON.get())
                .requires(UdonItems.BOILED_UDON)
                .requires(UdonItems.DASHI)
                .requires(Items.CARROT)
                .requires(Items.POTATO)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.RICH_CURRY_UDON.get())
                .requires(UdonItems.BOILED_UDON)
                .requires(UdonItems.RICH_DASHI)
                .requires(Items.CARROT)
                .requires(Items.POTATO)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.RICH_KITSUNE_UDON.get())
                .requires(UdonItems.BOILED_UDON)
                .requires(UdonItems.RICH_DASHI)
                .requires(UdonItems.OAGE)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.KITSUNE_UDON.get())
                .requires(UdonItems.BOILED_UDON)
                .requires(UdonItems.DASHI)
                .requires(UdonItems.OAGE)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);


    }
}
