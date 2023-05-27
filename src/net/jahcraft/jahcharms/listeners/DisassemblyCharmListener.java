package net.jahcraft.jahcharms.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.StonecuttingRecipe;


public class DisassemblyCharmListener implements Listener {

	@EventHandler
	public void onChestOpen(InventoryOpenEvent e) {
		
		if (e.getInventory().getType() != InventoryType.CHEST &&
				e.getInventory().getType() != InventoryType.SHULKER_BOX) return;
		
		boolean containsCharm = false;
		
		for (ItemStack i : e.getInventory().getContents()) {
			if (i != null &&
				i.getType() == Material.NETHER_STAR &&
				i.getItemMeta().hasCustomModelData() &&
				i.getItemMeta().getCustomModelData() == 4) {
				containsCharm = true;
			}
		}
		
		if (!containsCharm) return;
		
		
		for (ItemStack item : e.getInventory().getContents()) {
			
			if (item != null &&
				!item.getItemMeta().hasCustomModelData() &&
				!item.getItemMeta().hasEnchants() &&
				(item.getType().toString().contains("PISTON") ||
				item.getType().toString().contains("BRICKS") ||
				item.getType().toString().contains("SLAB") ||
				item.getType().toString().contains("STAIRS") ||
				item.getType().toString().contains("FENCE") ||
				item.getType().toString().contains("DOOR") ||
				item.getType().toString().contains("PRESSURE") ||
				item.getType().toString().contains("PANE") ||
				item.getType().toString().contains("BARS") ||
				item.getType().toString().contains("SHOVEL") ||
				item.getType().toString().contains("AXE") ||
				item.getType().toString().contains("SIGN") ||
				item.getType().toString().contains("SWORD") ||
				item.getType().toString().contains("CHESTPLATE") ||
				item.getType().toString().contains("LEGGINGS") ||
				item.getType().toString().contains("BOOTS") ||
				item.getType().toString().contains("HELMET") ||
				item.getType().toString().contains("SHIELD") ||
				item.getType().toString().contains("HOE") ||
				item.getType().toString().contains("SHEARS") ||
				item.getType().toString().contains("STEEL") ||
				item.getType().toString().contains("BOAT") ||
				item.getType().toString().contains("RAIL") ||
				item.getType().toString().contains("CART") ||
				item.getType().toString().contains("CAULDRON") ||
				item.getType().toString().contains("BUCKET") ||
				item.getType().toString().contains("BUTTON") ||
				item.getType().toString().contains("LEVER") ||
				item.getType().toString().contains("HOPPER") ||
				item.getType().toString().contains("CHEST") ||
				item.getType().toString().contains("POLISHED") ||
				item.getType().toString().contains("WALL") ||
				item.getType().toString().contains("CHAIN") ||
				item.getType().toString().contains("BANNER") ||
				item.getType().toString().contains("GLOWSTONE") ||
				item.getType().toString().contains("HAY") ||
				item.getType().toString().contains("LAMP") ||
				item.getType().toString().contains("ANVIL") ||
				item.getType().toString().contains("DISPENSER") ||
				item.getType().toString().contains("DROPPER") ||
				item.getType().toString().contains("OBSERVER") ||
				item.getType().toString().contains("BRICKS") ||
				item.getType().toString().contains("BOW") ||		
				item.getType().toString().contains("LADDER") ||		
				item.getType().toString().contains("BLOCK") ||
				item.getType().toString().contains("BED") ||
				item.getType().toString().contains("PICKAXE")) &&
				Bukkit.getRecipesFor(item) != null &&
				Bukkit.getRecipesFor(item).size() > 0 &&
				Bukkit.getRecipesFor(item).get(0) != null) {
				
				List<ItemStack> ingredients = new ArrayList<>();
//				List<ItemStack> toAdd = new ArrayList<>();
				ItemStack result = null; 
				
				if (Bukkit.getRecipesFor(item).get(0) instanceof ShapedRecipe) {
					ShapedRecipe recipe = (ShapedRecipe) Bukkit.getRecipesFor(item).get(0);
					result = recipe.getResult();
					for (ItemStack ingredient : recipe.getIngredientMap().values()) {
						if (ingredient != null && ingredient.getType() != item.getType()) {
							ingredients.add(ingredient);
						}
						
					}
				} else if (Bukkit.getRecipesFor(item).get(0) instanceof ShapelessRecipe) {
					ShapelessRecipe recipe = (ShapelessRecipe) Bukkit.getRecipesFor(item).get(0);
					result = recipe.getResult();
					for (ItemStack ingredient : recipe.getIngredientList()) {
						if (ingredient != null && ingredient.getType() != item.getType()) {
							ingredients.add(ingredient);
						}
					}
				} else if (Bukkit.getRecipesFor(item).get(0) instanceof StonecuttingRecipe) {
					StonecuttingRecipe recipe = (StonecuttingRecipe) Bukkit.getRecipesFor(item).get(0);
					result = recipe.getResult();
					ItemStack ingredient = recipe.getInput(); 
					if (ingredient != null && ingredient.getType() != item.getType()) {
						ingredients.add(ingredient);
					}
				}
				
				if (ingredients.size() > 0) {
					while (item.getAmount() >= result.getAmount() && e.getInventory().firstEmpty() != -1) {
						for (ItemStack ingredient : ingredients) {
							if (ingredient != null && ingredient != item) {
								ingredient.setItemMeta(new ItemStack(ingredient.getType()).getItemMeta());
								e.getInventory().addItem(ingredient);
								
//								toAdd.add(ingredient);
							}
							
						}
						item.setAmount(item.getAmount() - result.getAmount());
//						for (ItemStack add : toAdd) {
//							e.getInventory().addItem(add);
//						}
					}
				}
			}
		}
	}
	
}
