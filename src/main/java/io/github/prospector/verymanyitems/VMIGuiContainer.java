package io.github.prospector.verymanyitems;

import net.minecraft.item.ItemStack;

import java.util.List;

public interface VMIGuiContainer {
	public int getLeft();

	public int getTop();

	public int getContainerWidth();

	public int getContainerHeight();

	public int getWidth();

	public int getHeight();

	public void drawStackTooltip(ItemStack stack, int mouseX, int mouseY);

	public void drawTooltip(List<String> strings, int mouseX, int mouseY);

	public void drawTooltip(String string, int mouseX, int mouseY);

}
