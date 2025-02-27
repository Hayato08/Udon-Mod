package net.hayato08.udonmod.client.model;// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hayato08.udonmod.UdonMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class KitsuneArmorModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("udonmod", "model_kitsun_armor_model"), "main");
	public final ModelPart Head;
	public final ModelPart Fox;
	public final ModelPart body2;
	public final ModelPart head2;
	public final ModelPart leg0;
	public final ModelPart leg1;
	public final ModelPart leg2;
	public final ModelPart leg3;
	public final ModelPart tail;
	public final ModelPart Body1;
	public final ModelPart RightArm1;
	public final ModelPart LeftArm1;
	public final ModelPart RightLeg1;
	public final ModelPart LeftLeg1;

	public KitsuneArmorModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Fox = this.Head.getChild("Fox");
		this.body2 = this.Fox.getChild("body2");
		this.head2 = this.Fox.getChild("head2");
		this.leg0 = this.Fox.getChild("leg0");
		this.leg1 = this.Fox.getChild("leg1");
		this.leg2 = this.Fox.getChild("leg2");
		this.leg3 = this.Fox.getChild("leg3");
		this.tail = this.Fox.getChild("tail");
		this.Body1 = root.getChild("Body1");
		this.RightArm1 = root.getChild("RightArm1");
		this.LeftArm1 = root.getChild("LeftArm1");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.LeftLeg1 = root.getChild("LeftLeg1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Fox = Head.addOrReplaceChild("Fox", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 19.0F, -21.0F, -0.5672F, 0.0F, 0.0F));
		PartDefinition body2 = Fox.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -41.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition head2 = Fox.addOrReplaceChild("head2",
				CubeListBuilder.create().texOffs(24, 16).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(16, 41).addBox(-4.0F, -4.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 28)
						.addBox(2.0F, -4.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 44).addBox(-2.0F, 2.0F, -9.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -43.3F, -2.7F, 0.5672F, 0.0F, 0.0F));
		PartDefinition leg0 = Fox.addOrReplaceChild("leg0", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -37.5373F, 6.8434F, -0.0873F, 0.0F, 0.0F));
		PartDefinition leg0_r1 = leg0.addOrReplaceChild("leg0_r1", CubeListBuilder.create().texOffs(16, 33).addBox(-3.005F, -8.1578F, -1.6458F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 4.0F, -6.0F, -0.9163F, 0.0F, 0.0F));
		PartDefinition leg1 = Fox.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -37.5373F, 6.8434F, -0.0873F, 0.0F, 0.0F));
		PartDefinition leg1_r1 = leg1.addOrReplaceChild("leg1_r1", CubeListBuilder.create().texOffs(46, 44).addBox(1.005F, -8.1578F, -1.6458F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 4.0F, -6.0F, -0.9163F, 0.0F, 0.0F));
		PartDefinition leg2 = Fox.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(-3.0F, -39.0F, -1.0F));
		PartDefinition leg2_r1 = leg2.addOrReplaceChild("leg2_r1", CubeListBuilder.create().texOffs(16, 33).addBox(-3.005F, -6.0746F, -0.0132F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 6.0F, 1.0F, 0.5672F, 0.0F, 0.0F));
		PartDefinition leg3 = Fox.addOrReplaceChild("leg3", CubeListBuilder.create(), PartPose.offset(1.0F, -39.0F, -1.0F));
		PartDefinition leg3_r1 = leg3.addOrReplaceChild("leg3_r1", CubeListBuilder.create().texOffs(46, 44).addBox(1.005F, -6.0746F, -0.0132F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 6.0F, 1.0F, 0.5672F, 0.0F, 0.0F));
		PartDefinition tail = Fox.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -41.0F, 7.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -7.0F, 4.75F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -9.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(24, 28).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition RightArm1 = partdefinition.addOrReplaceChild("RightArm1", CubeListBuilder.create().texOffs(0, 33).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition LeftArm1 = partdefinition.addOrReplaceChild("LeftArm1", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
				PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(16, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(16, 44).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
				PartPose.offset(1.9F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightArm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftArm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
