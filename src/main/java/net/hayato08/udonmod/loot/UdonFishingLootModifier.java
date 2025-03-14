package net.hayato08.udonmod.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.List;

public class UdonFishingLootModifier extends LootModifier {
    public static final Codec<UdonFishingLootModifier> CODEC = RecordCodecBuilder.create(
            instance -> codecStart(instance).apply(instance, UdonFishingLootModifier::new)
    );

    public UdonFishingLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> objectArrayList, LootContext lootContext) {
        return null;
    }

    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        // Add a chance to get your custom fish when fishing
        if (context.getRandom().nextFloat() < 0.25f) {
            if (context.getRandom().nextBoolean()) {
                generatedLoot.add(new ItemStack(UdonItems.IWASHI.get()));
            } else {
                generatedLoot.add(new ItemStack(UdonItems.KATSUO.get()));
            }
        }
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return (MapCodec<? extends IGlobalLootModifier>) CODEC;
    }
}