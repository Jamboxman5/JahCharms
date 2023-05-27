package net.jahcraft.jahcharms.charms;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.nbtapi.NBTItem;
import net.md_5.bungee.api.ChatColor;

public class BoundCraftingCharm extends NBTItem {

	public BoundCraftingCharm(String recipe) {
		
		super(new ItemStack(Material.NETHER_STAR));
		
		ItemMeta meta = getItem().getItemMeta();
		meta.setCustomModelData(7);
		meta.setDisplayName(ChatColor.of("#FFD700") + "Bound Crafting Charm");
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add(ChatColor.of("#00E8FF") + "This charm is bound and will");
		lore.add(ChatColor.of("#00E8FF") + "automatically craft '" + ChatColor.YELLOW +  getName(recipe) + ChatColor.of("#00E8FF") + "'");
		lore.add(ChatColor.of("#00E8FF") + "when placed alongside its ingredients.");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		meta.setLore(lore);
		
		getItem().setItemMeta(meta);
		
		setString("result", recipe);
		
	}
	
	private String getName(String base) {

		if (base.contains("tnt")) {
			return "TNT ";
		}
		
		String newNameBase;
		String nameSpaced = "";
		
		newNameBase = base.toLowerCase();
		
		for (String s : newNameBase.split("_")) {
			nameSpaced = nameSpaced + s.substring(0,1).toUpperCase() + s.substring(1) + " ";
		}
		
		return nameSpaced.substring(0, nameSpaced.length()-1);
		
	}
	
}
