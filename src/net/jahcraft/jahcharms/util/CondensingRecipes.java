package net.jahcraft.jahcharms.util;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CondensingRecipes {
	
	public static ArrayList<ItemStack[]> recipes = getRecipes();

	private static ArrayList<ItemStack[]> getRecipes() {

		ArrayList<ItemStack[]> recipeList = new ArrayList<>();

		recipeList.add(getRecipe("MELON_SLICE"));
		recipeList.add(getRecipe("DIAMOND"));
		recipeList.add(getRecipe("EMERALD"));
		recipeList.add(getRecipe("COAL"));
		recipeList.add(getRecipe("NETHER_WART"));
		recipeList.add(getRecipe("IRON_INGOT"));
		recipeList.add(getRecipe("GOLD_INGOT"));
		recipeList.add(getRecipe("COPPER_INGOT"));
		recipeList.add(getRecipe("IRON_NUGGET"));
		recipeList.add(getRecipe("GOLD_NUGGET"));
		recipeList.add(getRecipe("BONE_MEAL"));
		recipeList.add(getRecipe("NETHERITE_INGOT"));
		recipeList.add(getRecipe("LAPIS_LAZULI"));
		recipeList.add(getRecipe("REDSTONE"));
		recipeList.add(getRecipe("WHEAT"));
		recipeList.add(getRecipe("RAW_IRON"));
		recipeList.add(getRecipe("RAW_GOLD"));
		recipeList.add(getRecipe("RAW_COPPER"));
		recipeList.add(getRecipe("DRIED_KELP"));
		
		return recipeList;
		
	}
	
	private static ItemStack[] getRecipe(String rep) {
		
		rep = rep.toUpperCase();
		
		ItemStack[] recipe = {new ItemStack(Material.valueOf(rep)), 
			new ItemStack(Material.valueOf(rep)), 
			new ItemStack(Material.valueOf(rep)), 
			new ItemStack(Material.valueOf(rep)), 
			new ItemStack(Material.valueOf(rep)), 
			new ItemStack(Material.valueOf(rep)), 
			new ItemStack(Material.valueOf(rep)), 
			new ItemStack(Material.valueOf(rep)), 
			new ItemStack(Material.valueOf(rep))};
		 
		 return recipe;
		
	}
	
	

}
