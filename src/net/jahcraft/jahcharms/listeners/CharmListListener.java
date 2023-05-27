package net.jahcraft.jahcharms.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahcharms.commands.GetCharm;
import net.md_5.bungee.api.ChatColor;

public class CharmListListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if (e.getClickedInventory() != GetCharm.menu) return;
		if (e.getCurrentItem().getType() == Material.AIR) return;
		
		e.setCancelled(true);
		
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		String iName = item.getItemMeta().getDisplayName();
		
		
		if (p.getInventory().firstEmpty() == -1 ) {
			
			// full inventory
			
			Location loc = p.getLocation();
			World world = p.getWorld();
			
			world.dropItemNaturally(loc, item);
			p.sendMessage(ChatColor.of("#49B3FF") + "Inventory full. 1x " + iName + ChatColor.of("#49B3FF") + " dropped at your feet.");
			
			return;
			
		}
		
		p.getInventory().addItem(item);
		p.sendMessage(ChatColor.of("#49B3FF") + "You received 1x " + iName + ChatColor.of("#49B3FF") + ".");
		
		
	}
	
}
	

