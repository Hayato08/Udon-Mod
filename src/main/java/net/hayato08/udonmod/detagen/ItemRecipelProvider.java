package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.block.UdonBlocks;
import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ItemRecipelProvider extends RecipeProvider {
    public ItemRecipelProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput)
    {
        List<ItemLike> RAW_UDON_SMELTING = List.of(UdonItems.RAW_UDON);
        List<ItemLike> BOILED_UDON_SMELTING = List.of(UdonItems.BOILED_UDON);

        oreSmelting(recipeOutput, RAW_UDON_SMELTING, RecipeCategory.MISC, UdonItems.BOILED_UDON,0.25f, 200, "boiled_udon");
        oreBlasting(recipeOutput, RAW_UDON_SMELTING, RecipeCategory.MISC, UdonItems.BOILED_UDON,0.25f, 100, "boiled_udon");

        oreSmelting(recipeOutput, BOILED_UDON_SMELTING, RecipeCategory.MISC, UdonItems.DRY_UDON,0.25f, 200, "dry_udon");
        oreBlasting(recipeOutput, BOILED_UDON_SMELTING, RecipeCategory.MISC, UdonItems.DRY_UDON,0.25f, 100, "dry_udon");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonBlocks.STONE_MILL.get())
                .pattern("ABB")
                .pattern("ABB")
                .pattern("CCC")
                .define('A', Tags.Items.RODS_WOODEN)
                .define('B', ItemTags.STONE_TOOL_MATERIALS)
                .define('C', Items.STONE)
                .unlockedBy("has_stone", has(Items.STONE)).save(recipeOutput);


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

        // Kitsune
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.KITSUNE_KATANA.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('B', Tags.Items.RODS_WOODEN)
                .define('A', UdonItems.OAGE)
                .unlockedBy("has_oage", has(UdonItems.OAGE)).save(recipeOutput);


        // Bukkake
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.BUKKAKE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', UdonItems.BUKKAKE_UDON)
                .unlockedBy("has_bukkake_udon", has(UdonItems.BUKKAKE_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.BUKKAKE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', UdonItems.BUKKAKE_UDON)
                .unlockedBy("has_bukkake_udon", has(UdonItems.BUKKAKE_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.BUKKAKE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.BUKKAKE_UDON)
                .unlockedBy("has_bukkake_udon", has(UdonItems.BUKKAKE_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.BUKKAKE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.BUKKAKE_UDON)
                .unlockedBy("has_bukkake_udon", has(UdonItems.BUKKAKE_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.BUKKAKE_KATANA.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('B', Tags.Items.RODS_WOODEN)
                .define('A', UdonItems.BUKKAKE_UDON)
                .unlockedBy("has_bukkake_udon", has(UdonItems.BUKKAKE_UDON)).save(recipeOutput);


        // curry
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.CURRY_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', UdonItems.CURRY_UDON)
                .unlockedBy("has_curry_udon", has(UdonItems.CURRY_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.CURRY_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', UdonItems.CURRY_UDON)
                .unlockedBy("has_curry_udon", has(UdonItems.CURRY_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.CURRY_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.CURRY_UDON)
                .unlockedBy("has_curry_udon", has(UdonItems.CURRY_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.CURRY_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.CURRY_UDON)
                .unlockedBy("has_curry_udon", has(UdonItems.CURRY_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.CURRY_KATANA.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('B', Tags.Items.RODS_WOODEN)
                .define('A', UdonItems.CURRY_UDON)
                .unlockedBy("has_curry_udon", has(UdonItems.CURRY_UDON)).save(recipeOutput);

        // Cold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.COLD_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', UdonItems.COLD_UDON)
                .unlockedBy("has_cold_udon", has(UdonItems.COLD_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.COLD_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', UdonItems.COLD_UDON)
                .unlockedBy("has_cold_udon", has(UdonItems.COLD_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.COLD_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.COLD_UDON)
                .unlockedBy("has_cold_udon", has(UdonItems.COLD_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.COLD_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.COLD_UDON)
                .unlockedBy("has_cold_udon", has(UdonItems.COLD_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.COLD_KATANA.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('B', Tags.Items.RODS_WOODEN)
                .define('A', UdonItems.COLD_UDON)
                .unlockedBy("has_cold_udon", has(UdonItems.COLD_UDON)).save(recipeOutput);


        // Zaru
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.ZARU_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', UdonItems.ZARU_UDON)
                .unlockedBy("has_zaru_udon", has(UdonItems.ZARU_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.ZARU_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', UdonItems.ZARU_UDON)
                .unlockedBy("has_zaru_udon", has(UdonItems.ZARU_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.ZARU_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.ZARU_UDON)
                .unlockedBy("has_zaru_udon", has(UdonItems.ZARU_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.ZARU_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', UdonItems.ZARU_UDON)
                .unlockedBy("has_zaru_udon", has(UdonItems.ZARU_UDON.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UdonItems.ZARU_KATANA.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('B', Tags.Items.RODS_WOODEN)
                .define('A', UdonItems.ZARU_UDON)
                .unlockedBy("has_zaru_udon", has(UdonItems.ZARU_UDON)).save(recipeOutput);




        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.RAW_UDON.get())
                .requires(UdonItems.FLOUR)
                .requires( Items.EGG)
                .unlockedBy("has_flour", has(UdonItems.FLOUR)).save(recipeOutput);


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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.DASHI.get(), 4)
                .requires(UdonItems.KATSUO_FLAKES)
                .unlockedBy("has_katsuo", has(UdonItems.KATSUO)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.RICH_DASHI.get(), 4)
                .requires(UdonItems.DASHI, 4)
                .requires(UdonItems.DRY_IWASHI)
                .unlockedBy("has_iwashi", has(UdonItems.DRY_IWASHI)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.BUKKAKE_UDON.get())
                .requires(UdonItems.BOILED_UDON)
                .requires(UdonItems.DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.RICH_BUKKAKE_UDON.get())
                .requires(UdonItems.BOILED_UDON)
                .requires(UdonItems.RICH_DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.RICH_COLD_UDON.get())
                .requires(UdonItems.ICE_UDON)
                .requires(UdonItems.RICH_DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UdonItems.COLD_UDON.get())
                .requires(UdonItems.ICE_UDON)
                .requires(UdonItems.DASHI)
                .unlockedBy("has_boiled_udon", has(UdonItems.BOILED_UDON)).save(recipeOutput);


    }
}
