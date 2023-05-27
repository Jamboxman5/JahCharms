package net.jahcraft.jahcharms.runnables;

import java.util.HashSet;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import net.jahcraft.jahcharms.main.Main;

public class RepairThread implements Runnable {

	public static HashSet<Inventory> repairing = new HashSet<>();
	
	@Override
	public void run() {

		while (Main.repairCharm) {
			
			for (Inventory i : repairing) {
				
				for (ItemStack item : i.getContents()) {
					
					if (item != null && item.getItemMeta() instanceof Damageable) { 
						
						Damageable meta = (Damageable) item.getItemMeta();
						if (meta.getDamage() > 0 && !meta.isUnbreakable()) {
							meta.setDamage(meta.getDamage() - 1);
							item.setItemMeta(meta);
						}
						
						
					}
					
				}
				
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	

}
