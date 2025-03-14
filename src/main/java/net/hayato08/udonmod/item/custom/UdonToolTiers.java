package net.hayato08.udonmod.item.custom;

import net.hayato08.udonmod.item.UdonItems;
import net.hayato08.udonmod.util.UdonTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class UdonToolTiers {
    public static final Tier KITSUNE = new SimpleTier(UdonTags.Blocks.INCCORECT_FOR_UDON_TOOL,
            2000, 4f, 3f, 28, () -> Ingredient.of(UdonItems.OAGE));

    public static final Tier COLD = new SimpleTier(UdonTags.Blocks.INCCORECT_FOR_UDON_TOOL,
            2000, 4f, 0f, 28, () -> Ingredient.of(UdonItems.ICE_UDON));

    // Fix the repair material for CURRY
    public static final Tier CURRY = new SimpleTier(UdonTags.Blocks.INCCORECT_FOR_UDON_TOOL,
            2000, 4f, 0f, 28, () -> Ingredient.of(UdonItems.CURRY_UDON)); // Change to CURRY_UDON

    // Fix the repair material for BUKKAKE
    public static final Tier BUKKAKE = new SimpleTier(UdonTags.Blocks.INCCORECT_FOR_UDON_TOOL,
            2000, 4f, 0f, 28, () -> Ingredient.of(UdonItems.BUKKAKE_UDON));

    public static final Tier ZARU = new SimpleTier(UdonTags.Blocks.INCCORECT_FOR_UDON_TOOL,
            2000, 4f, 3.0f, 28, () -> Ingredient.of(UdonItems.ICE_UDON));
}
