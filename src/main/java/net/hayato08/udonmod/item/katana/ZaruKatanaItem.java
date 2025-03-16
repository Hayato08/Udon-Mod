package net.hayato08.udonmod.item.katana;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

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

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.udonmod.zaru_katana"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
