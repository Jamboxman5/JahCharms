package net.jahcraft.jahcharms.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahcharms.runnables.RepairThread;

public class RepairCharmListener implements Listener {

	@EventHandler
	public void onChestOpen(InventoryOpenEvent e) {
		
		if (e.getInventory().getType() != InventoryType.CHEST &&
				e.getInventory().getType() != InventoryType.SHULKER_BOX) return;
		
		boolean containsCharm = false;
				
		for (ItemStack i : e.getInventory().getContents()) {
			if (i != null &&
				i.getType() == Material.NETHER_STAR &&
				i.getItemMeta().hasCustomModelData() &&
				i.getItemMeta().getCustomModelData() == 5) {
				containsCharm = true;
			}
		}
		
		if (!containsCharm) return;		
		
		RepairThread.repairing.add(e.getInventory());
		
	}
	
	@EventHandler
	public void onChestClose(InventoryCloseEvent e) {
		
		if (e.getInventory().getType() != InventoryType.CHEST &&
				e.getInventory().getType() != InventoryType.SHULKER_BOX) return;
		
		boolean containsCharm = false;
				
		for (ItemStack i : e.getInventory().getContents()) {
			if (i != null &&
				i.getType() == Material.NETHER_STAR &&
				i.getItemMeta().hasCustomModelData() &&
				i.getItemMeta().getCustomModelData() == 5) {
				containsCharm = true;
			}
		}
		
		if (!containsCharm) return;		
		
		RepairThread.repairing.add(e.getInventory());
		
	}
	
	@EventHandler
	public void onChestClick(InventoryClickEvent e) {
		
		if (e.getInventory().getType() != InventoryType.CHEST &&
				e.getInventory().getType() != InventoryType.SHULKER_BOX) return;
		
		boolean containsCharm = false;
				
		for (ItemStack i : e.getInventory().getContents()) {
			if (i != null &&
				i.getType() == Material.NETHER_STAR &&
				i.getItemMeta().hasCustomModelData() &&
				i.getItemMeta().getCustomModelData() == 5) {
				containsCharm = true;
			}
		}
		
		if (!containsCharm) return;		
		
		RepairThread.repairing.add(e.getInventory());
		
	}
	
}
