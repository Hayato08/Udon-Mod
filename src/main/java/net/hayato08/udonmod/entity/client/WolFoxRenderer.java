package net.hayato08.udonmod.entity.client;

import net.hayato08.udonmod.UdonMod;
import net.hayato08.udonmod.entity.WolFoxEntity;
import net.hayato08.udonmod.entity.client.WolFoxModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WolFoxRenderer extends MobRenderer<WolFoxEntity, WolFoxModel<WolFoxEntity>> {
    // テクスチャのパス。modidとパスは実際のリソースに合わせて変更してください。
    private static final ResourceLocation TEXTURE =ResourceLocation.fromNamespaceAndPath(UdonMod.MOD_ID, "textures/entities/fox.png");

    public WolFoxRenderer(EntityRendererProvider.Context context) {
        // context.bakeLayerで、クライアント側に登録したモデルレイヤーを参照します
        super(context, new WolFoxModel(context.bakeLayer(WolFoxModel.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(WolFoxEntity entity) {
        return TEXTURE;
    }
}
