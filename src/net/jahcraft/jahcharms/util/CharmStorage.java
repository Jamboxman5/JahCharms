package net.jahcraft.jahcharms.util;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahcharms.charms.BoundCraftingCharm;
import net.jahcraft.jahcharms.charms.CondensingCharm;
import net.jahcraft.jahcharms.charms.DisassemblyCharm;
import net.jahcraft.jahcharms.charms.RepairCharm;
import net.jahcraft.jahcharms.charms.SortingCharm;
import net.jahcraft.jahcharms.charms.UnboundCraftingCharm;

public class CharmStorage {

	public static HashMap<String, ItemStack> getCharm = getCharms();

	public static HashMap<String, ItemStack> getCharms() {

		HashMap<String, ItemStack> charms = new HashMap<>();
		
		charms.put("condensing", new CondensingCharm());
		charms.put("sorting", new SortingCharm());
		charms.put("disassembly", new DisassemblyCharm());
		charms.put("repair", new RepairCharm());
		charms.put("unbound", new UnboundCraftingCharm());
		charms.put("bound", new BoundCraftingCharm(Material.CRAFTING_TABLE.toString()).getItem());
		
		return charms;
		
	}
	
}
