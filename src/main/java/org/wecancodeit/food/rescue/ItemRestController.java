package org.wecancodeit.food.rescue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemRestController {
	
	@Resource
	private ItemRepository itemRepo;
	
	@Resource
	private InventoryRepository inventoryRepo;
	
	@Resource
	private RecipeRepository recipeRepo;
	
	@RequestMapping("/inventory")
	public Iterable<InventoryItem> findAllItemsInInventory() {
		return inventoryRepo.findAll();
	}
	
	@RequestMapping("/matched-items")
	public Iterable<Item> findMatchedItems() {
		Iterable<Item> items = itemRepo.findAll();
		Iterable<InventoryItem> inventoryItems = inventoryRepo.findAll();
		
		Collection<Item> matchedItems = new ArrayList<>();
		for(Item item: items) {
			String itemName = item.getItemName();
			for(InventoryItem iItem: inventoryItems) {
				String inventoryItemName = iItem.getInventoryItemName();
				if(itemName.equals(inventoryItemName)) {
					matchedItems.add(item);
				}
			}
		}
		return matchedItems;
	}
	
	@RequestMapping("/suggested-recipes")
	public Iterable<Recipe> findRecipes() {
		Iterable<InventoryItem> inventoryItems = inventoryRepo.findAll();
		Iterable<Recipe> recipes = recipeRepo.findAll();
		Collection<Recipe> matchedRecipes = new HashSet<Recipe>();
		
		for(InventoryItem inventoryItem: inventoryItems) {
			for(Recipe recipe: recipes) {
				Collection<Item> recipeItems = recipe.getItems();
				for(Item item: recipeItems) {
					if(inventoryItem.getInventoryItemName().equals(item.getItemName())) {
						matchedRecipes.add(recipe);
					}
				}
			}
		}
		return matchedRecipes;
	}

}
