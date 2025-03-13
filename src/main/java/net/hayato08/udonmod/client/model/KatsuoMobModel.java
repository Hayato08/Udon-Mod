package net.hayato08.udonmod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class KatsuoMobModel<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("udonmod", "model_katsuo_mob"), "main");
	public final ModelPart backBody;
	public final ModelPart tale;
	public final ModelPart forntBody;
	public final ModelPart head;
	public final ModelPart sitabire;
	public final ModelPart bire;
	public final ModelPart bireL;
	public final ModelPart bireR;
	public final ModelPart uwabire;

	public KatsuoMobModel(ModelPart root) {
		this.backBody = root.getChild("backBody");
		this.tale = this.backBody.getChild("tale");
		this.forntBody = root.getChild("forntBody");
		this.head = root.getChild("head");
		this.sitabire = root.getChild("sitabire");
		this.bire = root.getChild("bire");
		this.bireL = this.bire.getChild("bireL");
		this.bireR = this.bire.getChild("bireR");
		this.uwabire = root.getChild("uwabire");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition backBody = partdefinition.addOrReplaceChild("backBody", CubeListBuilder.create().texOffs(3, 3).addBox(-2.0F, -6.0F, 0.0F, 5.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 5.0F));
		PartDefinition tale = backBody.addOrReplaceChild("tale",
				CubeListBuilder.create().texOffs(44, 42).addBox(0.0F, -2.0F, -0.8571F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 42).addBox(0.0F, -2.0F, 1.1429F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 42)
						.addBox(0.0F, -3.0F, 3.1429F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 46).addBox(0.0F, -4.0F, 5.1429F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 46)
						.addBox(0.0F, -4.0F, 7.1429F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 45).addBox(0.0F, 2.0F, 5.1429F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 46)
						.addBox(0.0F, 3.0F, 7.1429F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, -3.0F, 12.8571F));
		PartDefinition forntBody = partdefinition.addOrReplaceChild("forntBody", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -6.0F, -8.0F, 5.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-0.5F, 20.8852F, -7.7611F));
		PartDefinition cube7_r1 = head.addOrReplaceChild("cube7_r1", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition cube6_r1 = head.addOrReplaceChild("cube6_r1", CubeListBuilder.create().texOffs(16, 41).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition cube5_r1 = head.addOrReplaceChild("cube5_r1", CubeListBuilder.create().texOffs(0, 41).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.65F, -0.3F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube4_r1 = head.addOrReplaceChild("cube4_r1", CubeListBuilder.create().texOffs(36, 36).addBox(-1.0F, -2.0F, -4.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.65F, -0.3F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube3_r1 = head.addOrReplaceChild("cube3_r1", CubeListBuilder.create().texOffs(42, 15).addBox(-1.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -2.8779F, -5.7156F, -0.829F, 0.0F, 0.0F));
		PartDefinition cube2_r1 = head.addOrReplaceChild("cube2_r1", CubeListBuilder.create().texOffs(36, 29).addBox(-1.0F, -2.0F, -5.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.656F, -1.5455F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube1_r1 = head.addOrReplaceChild("cube1_r1", CubeListBuilder.create().texOffs(36, 22).addBox(-1.0F, -2.0F, -5.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.65F, -0.3F, 0.3927F, 0.0F, 0.0F));
		PartDefinition sitabire = partdefinition.addOrReplaceChild("sitabire", CubeListBuilder.create(), PartPose.offset(0.5F, 21.95F, 13.0F));
		PartDefinition cube10_r1 = sitabire.addOrReplaceChild("cube10_r1", CubeListBuilder.create().texOffs(16, 45).addBox(0.0F, -4.0F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition cube9_r1 = sitabire.addOrReplaceChild("cube9_r1", CubeListBuilder.create().texOffs(20, 45).addBox(0.0F, -4.0F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.45F, -2.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition cube8_r1 = sitabire.addOrReplaceChild("cube8_r1", CubeListBuilder.create().texOffs(30, 41).addBox(0.0F, -4.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.175F, -15.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition bire = partdefinition.addOrReplaceChild("bire", CubeListBuilder.create(), PartPose.offset(-3.5F, 19.0F, -1.0F));
		PartDefinition bireL = bire.addOrReplaceChild("bireL", CubeListBuilder.create(), PartPose.offset(6.0F, -1.0F, -3.0F));
		PartDefinition bireL_r1 = bireL.addOrReplaceChild("bireL_r1", CubeListBuilder.create().texOffs(42, 3).addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 3.0F, 0.0F, 0.5236F, 0.0F));
		PartDefinition bireR = bire.addOrReplaceChild("bireR", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, -3.0F));
		PartDefinition bireR_r1 = bireR.addOrReplaceChild("bireR_r1", CubeListBuilder.create().texOffs(42, 9).addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 3.0F, 0.0F, -0.5236F, 0.0F));
		PartDefinition uwabire = partdefinition.addOrReplaceChild("uwabire",
				CubeListBuilder.create().texOffs(42, 17).addBox(0.0F, -2.0F, -10.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(30, 47).addBox(0.0F, -3.0F, -11.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 46)
						.addBox(0.0F, -4.0F, -12.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 45).addBox(0.0F, -5.0F, -13.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 46)
						.addBox(0.0F, -4.0F, -3.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 47).addBox(0.0F, -3.0F, -2.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 48)
						.addBox(0.0F, -2.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, 16.0F, 9.0F));
		PartDefinition cube13_r1 = uwabire.addOrReplaceChild("cube13_r1", CubeListBuilder.create().texOffs(48, 19).addBox(0.0F, -2.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.35F, 7.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition cube12_r1 = uwabire.addOrReplaceChild("cube12_r1", CubeListBuilder.create().texOffs(48, 17).addBox(0.0F, -2.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.35F, 5.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition cube11_r1 = uwabire.addOrReplaceChild("cube11_r1", CubeListBuilder.create().texOffs(34, 47).addBox(0.0F, -2.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.35F, 3.0F, 0.7854F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		backBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		forntBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		sitabire.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bire.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		uwabire.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
