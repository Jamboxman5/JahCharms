package net.jahcraft.jahcharms.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahcharms.charms.BoundCraftingCharm;

public class CharmBindingListener implements Listener {

	@EventHandler
	public void onAnvil(PrepareAnvilEvent e) {
		
		if (e.getInventory().getContents().length < 2) return;
		if (!isUnboundCharm(e.getInventory().getContents()[0])) return;
		if (e.getInventory().getContents()[1] == null) return;
		if (Bukkit.getRecipesFor(e.getInventory().getContents()[1]).size() == 0) return;
		
		e.setResult(new BoundCraftingCharm(e.getInventory().getContents()[1].getType().toString()).getItem());
		e.getInventory().setRepairCost(15);
	}

	private boolean isUnboundCharm(ItemStack i) {

		if (i == null) return false;
		if (!i.getItemMeta().hasCustomModelData()) return false;
		if (i.getType() != Material.NETHER_STAR) return false;
		if (i.getItemMeta().getCustomModelData() != 6) return false;
		
		return true;
	}
	
}
