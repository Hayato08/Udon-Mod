
package net.hayato08.udonmod.client.renderer;


import net.hayato08.udonmod.client.model.KatsuoMobModel;
import net.hayato08.udonmod.client.model.animations.KatsuoAnimation;
import net.hayato08.udonmod.entity.custom.KatsuoEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KatsuoRenderer extends MobRenderer<KatsuoEntity, KatsuoMobModel<KatsuoEntity>> {
	public KatsuoRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(KatsuoMobModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(KatsuoEntity entity) {
		return ResourceLocation.parse("udonmod:textures/entities/katsuo.png");
	}

	private static final class AnimatedModel extends KatsuoMobModel<KatsuoEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<KatsuoEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(KatsuoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, KatsuoAnimation.swim, ageInTicks, 1f);
				this.animate(entity.animationState1, KatsuoAnimation.stop, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(KatsuoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
