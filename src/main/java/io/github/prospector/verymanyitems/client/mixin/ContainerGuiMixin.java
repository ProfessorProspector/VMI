package io.github.prospector.verymanyitems.client.mixin;

import io.github.prospector.verymanyitems.client.gui.VMIContainerGui;
import io.github.prospector.verymanyitems.client.gui.VMIGui;
import net.minecraft.client.gui.ContainerGui;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ContainerGui.class)
public class ContainerGuiMixin extends Gui implements VMIContainerGui {

	@Shadow protected int left;
	@Shadow protected int top;
	@Shadow protected int containerWidth;
	@Shadow protected int containerHeight;

	@Inject(at = @At("RETURN"), method = "draw(IIF)V")
	public void draw(int mouseX, int mouseY, float elapsedTicks, CallbackInfo info) {
		new VMIGui().draw(mouseX, mouseY, elapsedTicks, this);
	}

	@Override
	public int vmi_getContainerWidth() {
		return containerWidth;
	}

	@Override
	public int vmi_getContainerHeight() {
		return containerHeight;
	}

	@Override
	public int vmi_getLeft() {
		return left;
	}

	@Override
	public int vmi_getTop() {
		return top;
	}

	@Override
	public int vmi_getHeight() {
		return height;
	}

	@Override
	public int vmi_getWidth() {
		return width;
	}

	@Override
	public void vmi_drawStackTooltip(ItemStack stack, int mouseX, int mouseY) {
		super.drawStackTooltip(stack, mouseX, mouseY);
	}

	@Override
	public void vmi_drawTooltip(List<String> strings, int mouseX, int mouseY) {
		super.drawTooltip(strings, mouseX, mouseY);
	}

	@Override
	public void vmi_drawTooltip(String string, int mouseX, int mouseY) {
		super.drawTooltip(string, mouseX, mouseY);
	}
}