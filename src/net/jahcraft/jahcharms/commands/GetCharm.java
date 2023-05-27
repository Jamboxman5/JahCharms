package net.jahcraft.jahcharms.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahcharms.util.CharmStorage;
import net.md_5.bungee.api.ChatColor;

public class GetCharm implements CommandExecutor {

	public static Inventory menu;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("getcharm")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahcraft.admin")) {
				p.sendMessage(ChatColor.RED + "You do not have permission to do that!");
				return true;
			}
			
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Usage: /getcharm <type>");
				return true;
			}
			
			String charmName = args[0].toLowerCase();
			
			if (charmName.equals("list")) {
				
				p.openInventory(menu);
				return true;
			}
			
			if (CharmStorage.getCharm.containsKey(charmName)) {
				
				ItemStack item = CharmStorage.getCharm.get(charmName);
				String iName = item.getItemMeta().getDisplayName().toString();
				
				if (p.getInventory().firstEmpty() == -1 ) {
					
					// full inventory
					
					Location loc = p.getLocation();
					World world = p.getWorld();
					
					world.dropItemNaturally(loc, item);
					p.sendMessage(ChatColor.AQUA + "Inventory full. 1x " + iName + ChatColor.AQUA + " dropped at your feet.");
					
					return true;
					
				}
				
				p.getInventory().addItem(item);
				p.sendMessage(ChatColor.AQUA + "You received 1x " + iName + ChatColor.AQUA + ".");
				
				return true;
				
			}
			
		}

		return false;

	}
	
	public static Inventory createList() {
		
		Inventory inv = Bukkit.createInventory(null, 54, "JahCharms List");
		
		for (ItemStack i : CharmStorage.getCharm.values()) {
			
			inv.addItem(i);
			
		}
		
		return inv;
		
	}
	
}
