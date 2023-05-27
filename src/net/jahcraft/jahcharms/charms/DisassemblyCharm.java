package net.jahcraft.jahcharms.charms;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class DisassemblyCharm extends ItemStack {

	public DisassemblyCharm() {
		
		super(Material.NETHER_STAR);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(4);
		meta.setDisplayName(ChatColor.of("#FFD700") + "Disassembly Charm");
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add(ChatColor.of("#00E8FF") + "This charm will automatically");
		lore.add(ChatColor.of("#00E8FF") + "uncraft any materials placed");
		lore.add(ChatColor.of("#00E8FF") + "alongside it in a chest.");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
