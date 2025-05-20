package cc.unilock.visbenchemi;

import com.google.common.collect.Lists;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.VanillaEmiRecipeCategories;
import dev.emi.emi.api.recipe.handler.StandardRecipeHandler;
import fuzs.visualworkbench.init.ModRegistry;
import fuzs.visualworkbench.world.inventory.VisualCraftingMenu;
import net.minecraft.world.inventory.Slot;

import java.util.List;

@EmiEntrypoint
public class VisualWorkbenchEMIPlugin implements EmiPlugin {
	/**
	 * @see dev.emi.emi.handler.CraftingRecipeHandler
	 */
	@Override
	public void register(EmiRegistry emi) {
		emi.addRecipeHandler(ModRegistry.CRAFTING_MENU_TYPE.value(), new StandardRecipeHandler<>() {
			@Override
			public List<Slot> getInputSources(VisualCraftingMenu handler) {
				List<Slot> list = Lists.newArrayList();

				for (int i = 1; i < 10; ++i) {
					list.add(handler.getSlot(i));
				}

				int invStart = 10;

				for (int i = invStart; i < invStart + 36; ++i) {
					list.add(handler.getSlot(i));
				}

				return list;
			}

			@Override
			public List<Slot> getCraftingSlots(VisualCraftingMenu handler) {
				List<Slot> list = Lists.newArrayList();

				for (int i = 1; i < 10; ++i) {
					list.add(handler.getSlot(i));
				}

				return list;
			}

			@Override
			public Slot getOutputSlot(VisualCraftingMenu handler) {
				return handler.getSlot(0);
			}

			@Override
			public boolean supportsRecipe(EmiRecipe recipe) {
				return recipe.getCategory() == VanillaEmiRecipeCategories.CRAFTING && recipe.supportsRecipeTree();
			}
		});
	}
}
