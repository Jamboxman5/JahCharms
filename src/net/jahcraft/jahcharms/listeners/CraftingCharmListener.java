package net.jahcraft.jahcharms.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.StonecuttingRecipe;

import de.tr7zw.nbtapi.NBTItem;

public class CraftingCharmListener implements Listener {

	@EventHandler
	public void onChestOpen(InventoryOpenEvent e) {
		
		if (e.getInventory().getType() != InventoryType.CHEST &&
				e.getInventory().getType() != InventoryType.SHULKER_BOX) return;
		
		boolean containsCharm = false;
		
		ItemStack charm = null;
		
		for (ItemStack i : e.getInventory().getContents()) {
			if (i != null &&
				i.getType() == Material.NETHER_STAR &&
				i.getItemMeta().hasCustomModelData() &&
				i.getItemMeta().getCustomModelData() == 7) {
				containsCharm = true;
				charm = i;
			}
		}
		
		if (!containsCharm) return;
		
		NBTItem nbti = new NBTItem(charm);
		if (nbti.getString("result") == null) return;
		
		ItemStack result = new ItemStack(Material.valueOf(nbti.getString("result")));
		
		Recipe r = Bukkit.getRecipesFor(result).get(0);
		
		result.setAmount(r.getResult().getAmount());
		
		List<ItemStack> ingredients = new ArrayList<>();
		
		if (r instanceof ShapedRecipe) {
		    ShapedRecipe shaped = (ShapedRecipe) r;
		    for(ItemStack ingredient : shaped.getIngredientMap().values()) {
		         ingredients.add(ingredient);
		    }
		} else if (r instanceof ShapelessRecipe) {
			ShapelessRecipe shaped = (ShapelessRecipe) r;
		    for(ItemStack ingredient : shaped.getIngredientList()) {
		         ingredients.add(ingredient);
		    }
		} else if (r instanceof StonecuttingRecipe) {
			StonecuttingRecipe shaped = (StonecuttingRecipe) r;
		    ingredients.add(shaped.getInput());
		} else if (r instanceof FurnaceRecipe) {
			FurnaceRecipe shaped = (FurnaceRecipe) r;
		    ingredients.add(shaped.getInput());
		}
				
		if (!hasIngredients(e.getInventory(), ingredients)) return;
		
		while (hasIngredients(e.getInventory(), ingredients)) {
			
			for (ItemStack i : ingredients) {
				if (i != null) {
					e.getInventory().removeItem(new ItemStack(i.getType()));
				}
			}
			e.getInventory().addItem(result);
			
		}
		
		
	}
	
	private boolean hasIngredients(Inventory inventory, List<ItemStack> ings) {

		boolean has = true;
		
		List<ItemStack> items = new ArrayList<>();
 		
		for (ItemStack i : ings) {
			if (i != null) {
				
				if (!inventory.containsAtLeast(new ItemStack(i.getType()), i.getAmount())) {
					has = false;
					break;
				}
				
				
				items.add(new ItemStack(i.getType()));
				inventory.removeItem(new ItemStack(i.getType()));
			}
			
		}
		
		for (ItemStack i : items) {
			if (i != null) {
				inventory.addItem(i);

			}
		}
		
		return has;
	}
	
}
