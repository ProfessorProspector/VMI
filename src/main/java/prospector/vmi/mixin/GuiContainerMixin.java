package prospector.vmi.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiContainer.class)
public class GuiContainerMixin extends Gui {

	@Shadow public int containerWidth;
	@Shadow public int containerHeight;
	@Shadow public int left;
	@Shadow public int top;

	@Inject(at = @At("HEAD"), method = "onInitialized()V")
	public void onInitialized(CallbackInfo info) {

	}

	@Inject(at = @At("RETURN"), method = "draw(IIF)V")
	public void draw(int mouseX, int mouseY, float elapsedTicks, CallbackInfo info) {
		int spacing = 2;
		int defaultX = left + containerWidth + spacing * 2;
		int x = left + containerWidth + spacing * 2;
		int y = spacing * 2;
		drawGradientRect(x, y, width - 4, height - 4, 0x44FFFFFF, 0x44FFFFFF);
		y += spacing * 2;
		boolean drawTooltip = false;
		int tooltipX = 0, tooltipY = 0;
		ItemStack tooltipStack = ItemStack.NULL_STACK;
		for (Item item : Registry.ITEMS) {
			x += 2;
			ItemStack stack = item.getDefaultStack();
			if (!stack.isInvalid()) {
				game.getItemRenderer().renderItemAndGlowInGui(stack, x, y);
				if (mouseX >= x && mouseX <= x + 16 && mouseY >= y && mouseY <= y + 16) {
					drawTooltip = true;
					tooltipX = x;
					tooltipY = y;
					tooltipStack = stack;
				}
				if (x + 16 * 2 >= width - spacing * 3) {
					y += 16 + spacing;
					x = defaultX + spacing;
				} else {
					x += 16;
				}
				if (y + 16 >= height - spacing * 3) {
					break;
				}
			}
		}
		if (drawTooltip) {
			drawGradientRect(tooltipX, tooltipY, tooltipX + 16, tooltipY + 16, 0x80FFFFFF, 0x80FFFFFF);
			drawStackTooltip(tooltipStack, mouseX, mouseY);
		}
	}
}