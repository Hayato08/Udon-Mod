package net.hayato08.udonmod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.block.UdonBlocks;
import net.hayato08.udonmod.client.gui.UniversalCookingBlockScreen;
import net.hayato08.udonmod.recipe.UdonRecipes;
import net.hayato08.udonmod.recipe.UniversalCookingBlockRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIUdonmodPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new UniversalCookingBlockRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<UniversalCookingBlockRecipe> universalCookingBlockRecipes = recipeManager
                .getAllRecipesFor(UdonRecipes.UNIVERSAL_COOKING_BLOCK_TYPE.get())
                .stream().map(RecipeHolder::value).toList();
        registration.addRecipes(UniversalCookingBlockRecipeCategory.UNIVERSAL_COOKING_BLOCK_RECIPE_RECIPE_TYPE,
                universalCookingBlockRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(UniversalCookingBlockScreen.class, 74, 30, 22, 20
        , UniversalCookingBlockRecipeCategory.UNIVERSAL_COOKING_BLOCK_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(UdonBlocks.UNIVERSAL_COOKING_BLOCK.asItem()),
                UniversalCookingBlockRecipeCategory.UNIVERSAL_COOKING_BLOCK_RECIPE_RECIPE_TYPE);
    }
}
