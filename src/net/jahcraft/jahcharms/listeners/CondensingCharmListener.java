package net.jahcraft.jahcharms.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahcharms.util.CondensingRecipes;

public class CondensingCharmListener implements Listener {

	@EventHandler
	public void onChestOpen(InventoryOpenEvent e) {
		
		if (e.getInventory().getType() != InventoryType.CHEST &&
				e.getInventory().getType() != InventoryType.SHULKER_BOX) return;
		
		boolean containsCharm = false;
		
		for (ItemStack i : e.getInventory().getContents()) {
			if (i != null &&
				i.getType() == Material.NETHER_STAR &&
				i.getItemMeta().hasCustomModelData() &&
				i.getItemMeta().getCustomModelData() == 2) {
				containsCharm = true;
			}
		}
		
		if (!containsCharm) return;
		
		
		for (ItemStack[] recipe : CondensingRecipes.recipes) {
			
			Player p = (Player) e.getPlayer();
			World world = p.getLocation().getWorld();
						
			ItemStack product = Bukkit.getCraftingRecipe(recipe, world).getResult();
			int amountCrafted = 0;
			
			while (checkMats(e.getInventory(), recipe)) {
				
				for (ItemStack i : recipe) {
					if (i != null) {
						e.getInventory().removeItem(i);
					}
				}
				amountCrafted++;
			}
			
			for (int i = 0; i < amountCrafted; i++) {
				
				e.getInventory().addItem(product);
				
			}
			
		}
		
		
		
		
		
	}
	
	private boolean checkMats(Inventory clickedInventory, ItemStack[] recipe) {
		
		Inventory temp = Bukkit.createInventory(null, clickedInventory.getSize());
		temp.setContents(clickedInventory.getContents());
		
		
		for (ItemStack i : recipe) {
			if (i != null) {
				if (!temp.containsAtLeast(i, 1)) {
					return false;
				}
				temp.removeItem(i);
			}
		}
		
		return true;
		
	}
	
}
