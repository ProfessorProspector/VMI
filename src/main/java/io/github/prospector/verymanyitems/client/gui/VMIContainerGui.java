package io.github.prospector.verymanyitems.client.gui;

import net.minecraft.item.ItemStack;

import java.util.List;

public interface VMIContainerGui {
	public int vmi_getLeft();

	public int vmi_getTop();

	public int vmi_getContainerWidth();

	public int vmi_getContainerHeight();

	public int vmi_getWidth();

	public int vmi_getHeight();

	public void vmi_drawStackTooltip(ItemStack stack, int mouseX, int mouseY);

	public void vmi_drawTooltip(List<String> strings, int mouseX, int mouseY);

	public void vmi_drawTooltip(String string, int mouseX, int mouseY);

}
