package com.xiaosuoaa.moreliver.ui.Screen;

import com.xiaosuoaa.moreliver.ui.menu.StructuralCompressorMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import org.jetbrains.annotations.NotNull;

public class StructuralCompressorScreen extends AbstractContainerScreen<StructuralCompressorMenu> {
	private final static HashMap<String, Object> guistate = StructuralCompressorMenu.guiState;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_both_arrow;

	public StructuralCompressorScreen(StructuralCompressorMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse(("moreliver:textures/screens/structural_compressor_gui.png"));

	@Override
	public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.moreliver.structural_compressor_gui.label_structural_compressor"), 10, 10, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_both_arrow = new ImageButton(this.leftPos + 82, this.topPos + 26, 32, 32, new WidgetSprites(ResourceLocation.parse("moreliver:textures/screens/both_arrow.png"), ResourceLocation.parse("moreliver:textures/screens/both_arrow.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_both_arrow", imagebutton_both_arrow);
		this.addRenderableWidget(imagebutton_both_arrow);
	}
}
