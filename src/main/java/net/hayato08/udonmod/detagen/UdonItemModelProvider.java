package net.hayato08.udonmod.detagen;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.item.UdonItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class UdonItemModelProvider extends ItemModelProvider {
    public UdonItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UdonMod.MOD_ID, existingFileHelper);
    }

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    @Override
    protected void registerModels() {
        basicItem(UdonItems.DASHI.get());
        basicItem(UdonItems.DRY_IWASHI.get());
        basicItem(UdonItems.DRY_KATSUO.get());
        basicItem(UdonItems.DRY_UDON.get());
        basicItem(UdonItems.FLOUR.get());
        basicItem(UdonItems.IWASHI.get());
        basicItem(UdonItems.KATSUO.get());
        basicItem(UdonItems.KATSUO_FLAKES.get());
        basicItem(UdonItems.RAW_UDON.get());
        basicItem(UdonItems.RICH_DASHI.get());
        basicItem(UdonItems.ICE_UDON.get());
        basicItem(UdonItems.UDON_ROPE.get());
        basicItem(UdonItems.BUKKAKE_UDON.get());
        basicItem(UdonItems.RICH_BUKKAKE_UDON.get());
        basicItem(UdonItems.COLD_UDON.get());
        basicItem(UdonItems.RICH_COLD_UDON.get());
        basicItem(UdonItems.CURRY_UDON.get());
        basicItem(UdonItems.RICH_CURRY_UDON.get());
        basicItem(UdonItems.KITSUNE_UDON.get());
        basicItem(UdonItems.RICH_KITSUNE_UDON.get());
        basicItem(UdonItems.ZARU_UDON.get());
        basicItem(UdonItems.RICH_ZARU_UDON.get());
        basicItem(UdonItems.BOILED_UDON.get());
        basicItem(UdonItems.OAGE.get());

        trimmedArmorItem(UdonItems.KITSUNE_HELMET);
        trimmedArmorItem(UdonItems.KITSUNE_CHESTPLATE);
        trimmedArmorItem(UdonItems.KITSUNE_LEGGINGS);
        trimmedArmorItem(UdonItems.KITSUNE_BOOTS);

    }
    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = UdonMod.MOD_ID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }

}
