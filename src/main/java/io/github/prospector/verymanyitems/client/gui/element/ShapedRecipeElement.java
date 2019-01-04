package io.github.prospector.verymanyitems.client.gui.element;

import io.github.prospector.verymanyitems.client.gui.element.slot.ItemStackVMISlot;
import io.github.prospector.verymanyitems.client.gui.element.slot.VMISlot;
import net.minecraft.recipe.crafting.ShapedRecipe;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShapedRecipeElement extends RecipeElement {
	public ShapedRecipeElement(ShapedRecipe recipe) {
		super(buildSlotList(recipe));
	}

	public static Triple<Integer, Integer, List<VMISlot>> buildSlotList(ShapedRecipe recipe) {
		List<VMISlot> slots = new ArrayList<>();
		for (int r = 0; r < recipe.getHeight(); r++) {
			for (int c = 0; c < recipe.getWidth(); c++) {
				slots.add(new ItemStackVMISlot(c * 16 + 4, r * 16 + 4, Arrays.asList(recipe.getPreviewInputs().get(r * recipe.getWidth() + c).getStackArray())));

			}
		}
		int height = 16 * recipe.getHeight() + 8;
		slots.add(new ItemStackVMISlot((recipe.getWidth() + 1) * 16, height / 2 - 16 / 2, Collections.singletonList(recipe.getOutput())));
		int width = 16 * (recipe.getWidth() + 1) + 20;
		return new ImmutableTriple<>(width, height, slots);
	}
}
