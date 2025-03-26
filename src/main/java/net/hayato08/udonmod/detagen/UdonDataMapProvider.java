package net.hayato08.udonmod.detagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;

// https://youtu.be/T-9h-FbAQH0?t=1906
public class UdonDataMapProvider extends DataMapProvider {
    protected UdonDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
    }
}
