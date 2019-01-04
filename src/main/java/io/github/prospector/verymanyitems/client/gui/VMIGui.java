package io.github.prospector.verymanyitems.client.gui;

import io.github.prospector.silk.client.util.DrawingUtil;
import io.github.prospector.silk.util.MathUtil;
import io.github.prospector.verymanyitems.client.gui.element.RecipeElement;
import io.github.prospector.verymanyitems.client.gui.element.ShapedRecipeElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Drawable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.crafting.ShapedRecipe;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VMIGui extends Drawable {

	public final List<RecipeElement> displayedRecipes = new ArrayList<>();

	public void draw(int mouseX, int mouseY, float delta, VMIContainerGui gui) {
		int containerX = gui.vmi_getLeft();
		int containerY = gui.vmi_getTop();
		int containerWidth = gui.vmi_getContainerWidth();
		int containerHeight = gui.vmi_getContainerHeight();
		int width = gui.vmi_getWidth();
		int height = gui.vmi_getHeight();

		int spacing = 2;
		int defaultX = containerX + containerWidth + spacing * 2;
		int x = containerX + containerWidth + spacing * 2;
		int y = spacing * 2;
		drawGradientRect(x, y, width - 4, height - 4, 0x44FFFFFF, 0x44FFFFFF);
		y += spacing * 2;
		boolean drawTooltip = false;
		int tooltipX = 0, tooltipY = 0;
		ItemStack tooltipStack = ItemStack.EMPTY;

		int slotSize = 18;

//		MinecraftClient.getInstance().world.getRecipeManager().values().stream().filter(recipe -> recipe instanceof ShapedRecipe).sorted(Collections.reverseOrder()).forEach(recipe -> displayedRecipes.add(new ShapedRecipeElement((ShapedRecipe) recipe)));

		for (Item item : Registry.ITEM) {
			x += 2;
			ItemStack stack = item.getDefaultStack();
			if (!stack.isEmpty()) {
				DrawingUtil.drawItemStack(stack, x, y);
				if (MathUtil.isInRect(mouseX, mouseY, x, y, x + slotSize, y + slotSize)) {
					drawTooltip = true;
					tooltipX = x;
					tooltipY = y;
					tooltipStack = stack;
				}
				if (x + slotSize * 2 >= width - spacing * 3) {
					y += slotSize + spacing;
					x = defaultX + spacing;
				} else {
					x += slotSize;
				}
				if (y + slotSize >= height - spacing * 3) {
					break;
				}
			}
		}

		int leftCenter = containerX / 2;
		int recipeY = 4;
		for (RecipeElement element : displayedRecipes) {
			element.draw(leftCenter - element.getWidth() / 2, recipeY, mouseX, mouseY, false, delta);
			recipeY += element.getHeight() + 4;
		}
		if (drawTooltip) {
			drawGradientRect(tooltipX, tooltipY, tooltipX + 16, tooltipY + 16, 0x80FFFFFF, 0x80FFFFFF);
			gui.vmi_drawStackTooltip(tooltipStack, mouseX, mouseY);
		}
	}
}
