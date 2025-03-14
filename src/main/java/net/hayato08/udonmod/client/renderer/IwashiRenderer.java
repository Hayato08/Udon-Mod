package net.hayato08.udonmod.client.renderer;

import net.hayato08.udonmod.client.model.IwashiMobModel;
import net.hayato08.udonmod.client.model.animations.IwashiAnimation;
import net.hayato08.udonmod.entity.custom.IwashiEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class IwashiRenderer extends MobRenderer<IwashiEntity, IwashiMobModel<IwashiEntity>> {
	public IwashiRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(IwashiMobModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(IwashiEntity entity) {
		return ResourceLocation.parse("udonmod:textures/entities/iwashi.png");
	}

	private static final class AnimatedModel extends IwashiMobModel<IwashiEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<IwashiEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(IwashiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, IwashiAnimation.swim, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(IwashiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
