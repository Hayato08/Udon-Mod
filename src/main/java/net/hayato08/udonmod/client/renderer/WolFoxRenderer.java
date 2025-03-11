package net.hayato08.udonmod.client.renderer;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.entity.client.WolFoxModel;
import net.hayato08.udonmod.entity.custom.WolFoxEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WolFoxRenderer extends MobRenderer<WolFoxEntity, WolFoxModel<WolFoxEntity>> {
    private static final ResourceLocation TEXTURE =ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, "textures/entities/fox.png");

    public WolFoxRenderer(EntityRendererProvider.Context context) {
        super(context, new WolFoxModel(context.bakeLayer(WolFoxModel.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(WolFoxEntity entity) {
        return TEXTURE;
    }
}
