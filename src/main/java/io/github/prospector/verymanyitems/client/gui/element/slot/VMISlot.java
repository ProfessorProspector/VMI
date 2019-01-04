package io.github.prospector.verymanyitems.client.gui.element.slot;

import net.minecraft.client.item.TooltipOptions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TextComponent;

import java.util.List;

public abstract class VMISlot<C> {
	public int relativeX;
	public int relativeY;
	public int width;
	public int height;
	protected List<C> contents;

	public VMISlot(int relativeX, int relativeY, int width, int height, List<C> contents) {
		this.relativeX = relativeX;
		this.relativeY = relativeY;
		this.width = width;
		this.height = height;
		this.contents = contents;
	}

	public List<C> getContents() {
		return contents;
	}

	public void setContents(List<C> contents) {
		this.contents = contents;
	}

	public abstract List<TextComponent> getTooltipText(PlayerEntity player, TooltipOptions options, int index);

	public final void draw(int x, int y, int mouseX, int mouseY, boolean hovering, float delta) {
		this.drawSlot(x + relativeX, y + relativeY, mouseX, mouseY, hovering, delta);
	}

	protected abstract void drawSlot(int x, int y, int mouseX, int mouseY, boolean hovering, float delta);
}
