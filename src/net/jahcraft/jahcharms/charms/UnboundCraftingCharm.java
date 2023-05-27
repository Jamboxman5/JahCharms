package net.jahcraft.jahcharms.charms;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class UnboundCraftingCharm extends ItemStack {

public UnboundCraftingCharm() {
		
		super(Material.NETHER_STAR);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(6);
		meta.setDisplayName(ChatColor.of("#FFD700") + "Unbound Crafting Charm");
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add(ChatColor.of("#00E8FF") + "Bind this charm to an item in an");
		lore.add(ChatColor.of("#00E8FF") + "anvil to use it to automatically craft");
		lore.add(ChatColor.of("#00E8FF") + "the bound item when alongside its ingredients.");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
