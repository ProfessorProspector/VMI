package prospector.verymanyitems.gui;

import net.minecraft.class_308;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Drawable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import prospector.verymanyitems.VMIGuiContainer;

public class VMIGui extends Drawable {

	public void draw(int mouseX, int mouseY, float elapsedTicks, VMIGuiContainer gui) {
		int left = gui.getLeft();
		int top = gui.getTop();
		int containerWidth = gui.getContainerWidth();
		int containerHeight = gui.getContainerHeight();
		int width = gui.getWidth();
		int height = gui.getHeight();
		MinecraftClient client = MinecraftClient.getInstance();

		int spacing = 2;
		int defaultX = left + containerWidth + spacing * 2;
		int x = left + containerWidth + spacing * 2;
		int y = spacing * 2;
		drawGradientRect(x, y, width - 4, height - 4, 0x44FFFFFF, 0x44FFFFFF);
		y += spacing * 2;
		boolean drawTooltip = false;
		int tooltipX = 0, tooltipY = 0;
		ItemStack tooltipStack = ItemStack.EMPTY;
		class_308.method_1453();
		for (Item item : Registry.ITEMS) {
			x += 2;
			ItemStack stack = item.getDefaultStack();
			if (!stack.isEmpty()) {
				client.getItemRenderer().renderItemAndGlowInGui(stack, x, y);
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
			gui.drawStackTooltip(tooltipStack, mouseX, mouseY);
		}
	}
}
