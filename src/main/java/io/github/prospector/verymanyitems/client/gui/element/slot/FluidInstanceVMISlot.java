package io.github.prospector.verymanyitems.client.gui.element.slot;

import io.github.prospector.silk.fluid.FluidInstance;
import net.minecraft.client.item.TooltipOptions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TextComponent;

import java.util.List;

public class FluidInstanceVMISlot extends VMISlot<FluidInstance> {

	public FluidInstanceVMISlot(int relativeX, int relativeY, int width, int height, List<FluidInstance> contents) {
		super(relativeX, relativeY, width, height, contents);
	}

	@Override
	public List<TextComponent> getTooltipText(PlayerEntity player, TooltipOptions options, int index) {
		return null;
	}

	@Override
	public void drawSlot(int x, int y, int mouseX, int mouseY, boolean hovering, float delta) {

	}
}
