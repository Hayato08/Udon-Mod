package net.hayato08.udonmod.item.katana;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ZaruKatanaItem extends SwordItem {
    public ZaruKatanaItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
}
