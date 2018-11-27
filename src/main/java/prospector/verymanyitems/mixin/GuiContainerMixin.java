package prospector.verymanyitems.mixin;

import net.minecraft.client.gui.ContainerGui;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import prospector.verymanyitems.VMIGuiContainer;
import prospector.verymanyitems.gui.VMIGui;

import java.util.List;

@Mixin(ContainerGui.class)
public class GuiContainerMixin extends Gui implements VMIGuiContainer {

	@Shadow public int left;
	@Shadow public int top;
	@Shadow public int containerWidth;
	@Shadow public int containerHeight;

	@Inject(at = @At("RETURN"), method = "draw(IIF)V")
	public void draw(int mouseX, int mouseY, float elapsedTicks, CallbackInfo info) {
		new VMIGui().draw(mouseX, mouseY, elapsedTicks, this);
	}

	@Override
	public int getContainerWidth() {
		return containerWidth;
	}

	@Override
	public int getContainerHeight() {
		return containerHeight;
	}

	@Override
	public int getLeft() {
		return left;
	}

	@Override
	public int getTop() {
		return top;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void drawStackTooltip(ItemStack stack, int mouseX, int mouseY) {
		super.drawStackTooltip(stack, mouseX, mouseY);
	}

	@Override
	public void drawTooltip(List<String> strings, int mouseX, int mouseY) {
		super.drawTooltip(strings, mouseX, mouseY);
	}

	@Override
	public void drawTooltip(String string, int mouseX, int mouseY) {
		super.drawTooltip(string, mouseX, mouseY);
	}
}