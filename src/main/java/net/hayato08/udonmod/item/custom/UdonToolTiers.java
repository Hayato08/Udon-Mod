package net.hayato08.udonmod.item.custom;

import net.hayato08.udonmod.item.UdonItems;
import net.hayato08.udonmod.util.UdonTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class UdonToolTiers {

    // きつねツールのティア
    public static final Tier KITSUNE = new SimpleTier(UdonTags.Blocks.INCCORECT_FOR_UDON_TOOL,
            1400, 4f, 3f, 28, () -> Ingredient.of(UdonItems.OAGE));
}
