package io.github.prospector.verymanyitems.client.gui.element;

import io.github.prospector.verymanyitems.client.gui.element.slot.ItemStackVMISlot;
import io.github.prospector.verymanyitems.client.gui.element.slot.VMISlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.crafting.ShapelessRecipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapelessRecipeElement extends RecipeElement {
	public ShapelessRecipeElement(ShapelessRecipe recipe) {
		super(100, 50, makeSlotList(recipe));
	}

	public static List<VMISlot> makeSlotList(ShapelessRecipe recipe) {
		int x = 4;
		int y = 4;
		List<VMISlot> slots = new ArrayList<>();

		for (Ingredient ingredient : recipe.getPreviewInputs()) {
			slots.add(new ItemStackVMISlot(x, y, Arrays.asList(ingredient.getStackArray())));

		}
		return slots;
	}
}
