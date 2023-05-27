package net.jahcraft.jahcharms.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import net.jahcraft.jahcharms.commands.GetCharm;
import net.jahcraft.jahcharms.listeners.CharmBindingListener;
import net.jahcraft.jahcharms.listeners.CharmListListener;
import net.jahcraft.jahcharms.listeners.CondensingCharmListener;
import net.jahcraft.jahcharms.listeners.CraftingCharmListener;
import net.jahcraft.jahcharms.listeners.DisassemblyCharmListener;
import net.jahcraft.jahcharms.listeners.RepairCharmListener;
import net.jahcraft.jahcharms.listeners.SortingCharmListener;
import net.jahcraft.jahcharms.runnables.RepairThread;


public class Main extends JavaPlugin {
	
	public static boolean repairCharm = true;

	@Override
	public void onEnable() {
		
		//JAHCHARMS
				try {
					
					//COMMANDS
					getCommand("getcharm").setExecutor((CommandExecutor) new GetCharm());
					
					//LISTENERS
					getServer().getPluginManager().registerEvents(new CondensingCharmListener(), this);
					getServer().getPluginManager().registerEvents(new SortingCharmListener(), this);
					getServer().getPluginManager().registerEvents(new DisassemblyCharmListener(), this);
					getServer().getPluginManager().registerEvents(new RepairCharmListener(), this);
					getServer().getPluginManager().registerEvents(new CharmListListener(), this);
					getServer().getPluginManager().registerEvents(new CharmBindingListener(), this);
					getServer().getPluginManager().registerEvents(new CraftingCharmListener(), this);
					
					//GUI
					GetCharm.menu = GetCharm.createList();
					
					//THREADS
					Bukkit.getScheduler().runTaskAsynchronously(this, new RepairThread());
					
				} catch (Exception e) {

					Bukkit.getLogger().warning("Failed to load JahCharms!");
					e.printStackTrace();
					
				}
	}
	
	@Override 
	public void onDisable() {
		
		repairCharm = false;

		Bukkit.getLogger().info("JahCharms Unloaded and Disabled!");
		
	}

}
