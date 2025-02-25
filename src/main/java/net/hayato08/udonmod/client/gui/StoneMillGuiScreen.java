package net.hayato08.udonmod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.hayato08.udonmod.world.inventory.StoneMillGuiMenu;
import net.hayato08.udonmod.network.StoneMillGuiButtonMessage;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.HashMap;

public class StoneMillGuiScreen extends AbstractContainerScreen<StoneMillGuiMenu> {
	private final static HashMap<String, Object> guistate = StoneMillGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_mill;

	public StoneMillGuiScreen(StoneMillGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("udonmod:textures/screens/stone_mill_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		// ボタンが押されたとき
		button_mill = Button.builder(Component.translatable("gui.udonmod.stone_mill_gui.button_mill"), e ->
		{
			PacketDistributor.sendToServer(new StoneMillGuiButtonMessage(0, x, y, z));
			StoneMillGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
		}).bounds(this.leftPos + 64, this.topPos + 56, 46, 20).build();
		guistate.put("button:button_mill", button_mill);
		this.addRenderableWidget(button_mill);
	}
}
