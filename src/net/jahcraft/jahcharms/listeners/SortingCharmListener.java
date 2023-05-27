package net.jahcraft.jahcharms.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class SortingCharmListener implements Listener {

	@EventHandler
	public void onChestOpen(InventoryOpenEvent e) {
		
		if (e.getInventory().getType() != InventoryType.CHEST &&
				e.getInventory().getType() != InventoryType.SHULKER_BOX) return;
		
		boolean containsCharm = false;
		
		for (ItemStack i : e.getInventory().getContents()) {
			if (i != null &&
				i.getType() == Material.NETHER_STAR &&
				i.getItemMeta().hasCustomModelData() &&
				i.getItemMeta().getCustomModelData() == 3) {
				containsCharm = true;
			}
		}
		
		if (!containsCharm) return;
		
		
		ItemStack[] contents = e.getInventory().getContents();
		
		ItemStack[] newContents = new ItemStack[contents.length];
		
		List<ItemStack> valuables = new ArrayList<>();
		List<ItemStack> foods = new ArrayList<>();
		List<ItemStack> woods = new ArrayList<>();
		List<ItemStack> andesites = new ArrayList<>();
		List<ItemStack> granites = new ArrayList<>();
		List<ItemStack> diorites = new ArrayList<>();
		List<ItemStack> stones = new ArrayList<>();
		List<ItemStack> deepslates = new ArrayList<>();
		List<ItemStack> misc = new ArrayList<>();
		List<ItemStack> sorters = new ArrayList<>();
		List<ItemStack> finalList = new ArrayList<>();
		
		int index = 0;
		
		for (ItemStack i : contents) {
			if (i != null) {
				newContents[index] = i;
				index++;
			}
		}
		
		for (ItemStack i : newContents) {
			if (i != null) {
				if (i.getType().toString().contains("SPRUCE") ||
						i.getType().toString().contains("OAK") ||
						i.getType().toString().contains("BIRCH") ||
						i.getType().toString().contains("JUNGLE") ||
						i.getType().toString().contains("DARK_OAK") ||
						i.getType().toString().contains("ACACIA") ||
						i.getType().toString().contains("MANGROVE") ||
						i.getType().toString().contains("CRIMSON") ||
						i.getType().toString().contains("WARPED")) {
					woods.add(i);
				} else if (i.getType().toString().contains("IRON") ||
						i.getType().toString().contains("GOLD") ||
						i.getType().toString().contains("DIAMOND") ||
						i.getType().toString().contains("EMERALD") ||
						i.getType().toString().contains("NETHERITE") ||
						i.getType().toString().contains("REDSTONE") ||
						i.getType().toString().contains("GLOWSTONE") ||
						i.getType().toString().contains("COAL") ||
						i.getType().toString().contains("NETHER_STAR") ||
						i.getType().toString().contains("DEBRIS") ||
						i.getType().toString().contains("ELYTRA") ||
						i.getType().toString().contains("TOTEM") ||
						i.getType().toString().contains("COPPER")) {
					valuables.add(i);
				
				} else if (i.getType().toString().contains("BEEF") ||
						i.getType().toString().contains("PORK") ||
						i.getType().toString().contains("MELON") ||
						i.getType().toString().contains("PUMPKIN") ||
						i.getType().toString().contains("EGG") ||
						i.getType().toString().contains("FLESH") ||
						i.getType().toString().contains("FRUIT") ||
						i.getType().toString().contains("APPLE") ||
						i.getType().toString().contains("BERRIES") ||
						i.getType().toString().contains("CARROT") ||
						i.getType().toString().contains("POTATO") ||
						i.getType().toString().contains("WHEAT") ||
						i.getType().toString().contains("BEETROOT") ||
						i.getType().toString().contains("MUSHROOM") ||
						i.getType().toString().contains("RABBIT") ||
						i.getType().toString().contains("COD") ||
						i.getType().toString().contains("PUFFERFISH") ||
						i.getType().toString().contains("SALMON") ||
						i.getType().toString().contains("BREAD")) {
					foods.add(i);
				
				} else if (i.getType().toString().contains("ANDESITE")) {
					andesites.add(i);
				} else if (i.getType().toString().contains("DIORITE")) {
					diorites.add(i);
				} else if (i.getType().toString().contains("GRANITE")) {
					granites.add(i);
				} else if (i.getType().toString().contains("STONE")) {
					stones.add(i);
				} else if (i.getType().toString().contains("DEEPSLATE")) {
					deepslates.add(i);
				} else if (i.getType() == Material.PAPER &&
						i.getItemMeta().hasCustomModelData() &&
						i.getItemMeta().getCustomModelData() == 3) {
					sorters.add(i);
				} else {
					misc.add(i);
				}
			}
		}
		
		valuables.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		foods.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		woods.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		stones.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		andesites.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		diorites.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		granites.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		deepslates.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		woods.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		misc.sort((ItemStack i, ItemStack j)->i.getType().toString().compareTo(j.getType().toString()));
		
		for (ItemStack i : valuables) {
			if (i != null) {
				finalList.add(i);
			}
		}
		for (ItemStack i : foods) {
			if (i != null) {
				finalList.add(i);
			}
		}
		
		for (ItemStack i : woods) {
			if (i != null) {
				finalList.add(i);
			}
		}
		
		for (ItemStack i : andesites) {
			if (i != null) {
				finalList.add(i);
			}
		}
		
		for (ItemStack i : diorites) {
			if (i != null) {
				finalList.add(i);
			}
		}
		
		for (ItemStack i : granites) {
			if (i != null) {
				finalList.add(i);
			}
		}
		
		for (ItemStack i : stones) {
			if (i != null) {
				finalList.add(i);
			}
		}
		
		for (ItemStack i : deepslates) {
			if (i != null) {
				finalList.add(i);
			}
		}
		
		for (ItemStack i : misc) {
			if (i != null) {
				finalList.add(i);
			}
		}
		
		int sorterCount = 0;
		
		for (ItemStack i : sorters) {
			sorterCount += i.getAmount();
		} 
		
		if (sorters.size() == 0) return;
		sorters.get(0).setAmount(sorterCount);
		
		
		ItemStack[] finalContents = new ItemStack[contents.length];
		
		for (int i = 0; i < finalList.size(); i++) {
			finalContents[i] = finalList.get(i);
		}
		
		finalContents[finalContents.length-1] = sorters.get(0);
		
		e.getInventory().setContents(finalContents);
		
		
	}
	
	
	
}
