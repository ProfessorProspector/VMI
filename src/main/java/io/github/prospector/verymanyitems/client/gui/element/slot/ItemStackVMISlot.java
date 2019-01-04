package io.github.prospector.verymanyitems.client.gui.element.slot;

import io.github.prospector.silk.client.util.DrawingUtil;
import net.minecraft.client.item.TooltipOptions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TextComponent;

import java.util.List;

public class ItemStackVMISlot extends VMISlot<ItemStack> {

	public ItemStackVMISlot(int relativeX, int relativeY, List<ItemStack> contents) {
		this(relativeX, relativeY, 16, 16, contents);
	}

	public ItemStackVMISlot(int relativeX, int relativeY, int width, int height, List<ItemStack> contents) {
		super(relativeX, relativeY, width, height, contents);
	}

	@Override
	public List<TextComponent> getTooltipText(PlayerEntity player, TooltipOptions options, int index) {
		return contents.get(index).getTooltipText(player, options);
	}

	@Override
	public void drawSlot(int x, int y, int mouseX, int mouseY, boolean hovering, float delta) {
		if (!contents.isEmpty()) {
			DrawingUtil.drawItemStack(contents.get(0), x, y);
		}
	}
}
