package net.hayato08.udonmod.recipe;

import net.hayato08.udonmod.UdonMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UdonRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, UdonMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, UdonMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<UniversalCookingBlockRecipe>> UNIVERSAL_BLOCK_SERIALIZER =
            SERIALIZERS.register("universal_cooking_block", UniversalCookingBlockRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<UniversalCookingBlockRecipe>> UNIVERSAL_COOKING_BLOCK_TYPE =
            TYPES.register("universal_cooking_block", () -> new RecipeType<UniversalCookingBlockRecipe>() {
                @Override
                public String toString() {
                    return "universal_cooking_block";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
