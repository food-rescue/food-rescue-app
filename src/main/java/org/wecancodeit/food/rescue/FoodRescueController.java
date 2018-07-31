package org.wecancodeit.food.rescue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoodRescueController {

	@Resource
	ItemRepository itemRepo;

	@Resource
	RecipeRepository recipeRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	InventoryRepository inventoryRepo;

	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	@RequestMapping("/item")
	public String findOneItem(@RequestParam(value = "id") long itemId, Model model) throws ItemNotFoundException {
		Optional<Item> item = itemRepo.findById(itemId);
		if (item.isPresent()) {
			model.addAttribute("itemsModel", item.get());
			return "item";
		}
		throw new ItemNotFoundException();
	}

	@RequestMapping("/show-items")
	public String findAllItems(Model model) {
		model.addAttribute("itemsModel", itemRepo.findAll());
		return "items";

	}

	@RequestMapping("/recipe")
	public String findOneRecipe(@RequestParam(value = "id") long recipeId, Model model) throws RecipeNotFoundException {
		Optional<Recipe> recipe = recipeRepo.findById(recipeId);
		if (recipe.isPresent()) {
			model.addAttribute("recipesModel", recipe.get());
			return "recipe";
		}
		throw new RecipeNotFoundException();
	}

	@RequestMapping("/show-recipes")
	public String findAllRecipes(Model model) {
		model.addAttribute("recipesModel", recipeRepo.findAll());
		return "recipes";
	}

	@RequestMapping("/tag")
	public String findOneTag(@RequestParam(value = "id") long tagId, Model model) throws TagNotFoundException {
		Optional<Tag> tag = tagRepo.findById(tagId);
		if (tag.isPresent()) {
			model.addAttribute("tagsModel", tag.get());
			return "tag";
		}
		throw new TagNotFoundException();

	}

	@RequestMapping("/show-tags")
	public String findAllTags(Model model) {
		model.addAttribute("tagsModel", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/inventoryItem")
	public String findOneInventoryItem(@RequestParam(value = "id") long inventoryItemId, Model model)
			throws InventoryItemNotFoundException {
		Optional<InventoryItem> inventoryItem = inventoryRepo.findById(inventoryItemId);
		if (inventoryItem.isPresent()) {
			model.addAttribute("inventoryItemsModel", inventoryItem.get());
			return "inventoryItem";
		}
		throw new InventoryItemNotFoundException();

	}

	@RequestMapping("/show-inventory-items")
	public String findAllInventoryItems(Model model) {
		model.addAttribute("inventoryItemsModel", inventoryRepo.findAll());
		return "inventoryItems";
	}

	@RequestMapping("/add-inventory-item")
	public String addItem(String itemName, String inventoryItemName) {
		Iterable<Item> items = itemRepo.findAll();

		for (Item item : items) {
			itemName = item.getItemName();
			if(itemName.equals(inventoryItemName)) {
				InventoryItem inventoryItem = new InventoryItem(inventoryItemName);
				inventoryRepo.save(inventoryItem);
			}
		}
		return "redirect:/show-inventory-items";
	}
	
	@RequestMapping("/find-recipes")
	public String findRecipes(Model model) {
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
		model.addAttribute("recipesModel", matchedRecipes);
		
		return "find-recipes";
	}
	
	
	
	//Add food inventory with Ajax
		@RequestMapping(path = "/index/add-food/{inventoryItemName}", method = RequestMethod.POST)
		public String AddInventoryItem(@PathVariable String inventoryItemName, Model model) {
			InventoryItem foodToAdd = inventoryRepo.findByInventoryItemName(inventoryItemName);
			if(foodToAdd == null) {
				foodToAdd = new InventoryItem(inventoryItemName);
				inventoryRepo.save(foodToAdd);
			}	
			
			model.addAttribute("inventoryItemsModel", inventoryRepo.findAll());		
			return "partials/food-list-added";
		}
		
	@RequestMapping(path = "/food-list-added/clear-inventory", method = RequestMethod.POST)
	public String deleteAllInventoryItems(@PathVariable Model model) {
	
		inventoryRepo.deleteAll();
		model.addAttribute("inventoryItemsModel", inventoryRepo.findAll());
		
		return "redirect:/partials/food-list-added";
	}
	

	}
	



