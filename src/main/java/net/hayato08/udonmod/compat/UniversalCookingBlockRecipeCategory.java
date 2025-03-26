package net.hayato08.udonmod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.block.UdonBlocks;
import net.hayato08.udonmod.recipe.UniversalCookingBlockRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class UniversalCookingBlockRecipeCategory implements IRecipeCategory<UniversalCookingBlockRecipe> {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, "universal_cooking_block");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID,
            "textures/screens/universal_cooking_block.png");

    public static final RecipeType<UniversalCookingBlockRecipe> UNIVERSAL_COOKING_BLOCK_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, UniversalCookingBlockRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public UniversalCookingBlockRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 54);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(UdonBlocks.UNIVERSAL_COOKING_BLOCK));
    }

    @Override
    public RecipeType<UniversalCookingBlockRecipe> getRecipeType() {
        return UNIVERSAL_COOKING_BLOCK_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.udonmod.universal_cooking_block");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, UniversalCookingBlockRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 34).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 34).addItemStack(recipe.getResultItem(null));
    }


}
