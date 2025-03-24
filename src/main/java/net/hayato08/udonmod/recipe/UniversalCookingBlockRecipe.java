package net.hayato08.udonmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record UniversalCookingBlockRecipe(Ingredient inputItem, ItemStack output) implements Recipe<UniversalCookingBlockRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(UniversalCookingBlockRecipeInput universalCookingBlockRecipeInput, Level level) {
        if(level.isClientSide())
        {
            return false;
        }
        return inputItem.test(universalCookingBlockRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(UniversalCookingBlockRecipeInput universalCookingBlockRecipeInput, HolderLookup.Provider provider) {

        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return false;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return UdonRecipes.UNIVERSAL_BLOCK_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return UdonRecipes.UNIVERSAL_COOKING_BLOCK_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<UniversalCookingBlockRecipe> {
        public static final MapCodec<UniversalCookingBlockRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(UniversalCookingBlockRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(UniversalCookingBlockRecipe::output)
        ).apply(inst, UniversalCookingBlockRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, UniversalCookingBlockRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, UniversalCookingBlockRecipe::inputItem,
                        ItemStack.STREAM_CODEC, UniversalCookingBlockRecipe::output,
                        UniversalCookingBlockRecipe::new);


        @Override
        public MapCodec<UniversalCookingBlockRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, UniversalCookingBlockRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
