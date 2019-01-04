package io.github.prospector.verymanyitems.client.gui.element;

import io.github.prospector.verymanyitems.client.gui.element.slot.VMISlot;
import net.minecraft.client.gui.Drawable;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public abstract class RecipeElement extends Drawable {
	int width;
	int height;
	List<VMISlot> slots;

	public RecipeElement(Triple<Integer, Integer, List<VMISlot>> args) {
		this(args.getLeft(), args.getMiddle(), args.getRight());
	}

	public RecipeElement(int width, int height, List<VMISlot> slots) {
		this.width = width;
		this.height = height;
		this.slots = slots;
	}

	public final void draw(int x, int y, int mouseX, int mouseY, boolean hovering, float delta) {
		this.drawBackground(x, y, mouseX, mouseY, hovering, delta);
		this.drawForeground(x, y, mouseX, mouseY, hovering, delta);
	}

	public void drawBackground(int x, int y, int mouseX, int mouseY, boolean hovering, float delta) {
		drawGradientRect(x, y, x + width, y + height, 0x44FFFFFF, 0x44FFFFFF);
	}

	public void drawForeground(int x, int y, int mouseX, int mouseY, boolean hovering, float delta) {
		for (VMISlot slot : slots) {
			slot.draw(x, y, mouseX, mouseY, hovering, delta);
		}
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setSlots(List<VMISlot> slots) {
		this.slots = slots;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<VMISlot> getSlots() {
		return slots;
	}
}
