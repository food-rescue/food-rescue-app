package org.wecancodeit.food.rescue;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FoodRescuePopulator implements CommandLineRunner {

	@Resource
	private ItemRepository itemRepo;
	
	@Resource
	private RecipeRepository recipeRepo;
	
	@Resource
	private TagRepository tagRepo;
	
	@Resource
	private InventoryRepository inventoryRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Item bread = new Item("Bread");
		Item cheese = new Item("Cheese");
		Item eggs = new Item("Eggs");
		Item groundBeef = new Item("Ground Beef");
		Item milk = new Item("Milk");
		Item tortillas = new Item("Tortillas");
		itemRepo.save(bread);
		itemRepo.save(cheese);
		itemRepo.save(eggs);
		itemRepo.save(groundBeef);
		itemRepo.save(milk);
		itemRepo.save(tortillas);
		
		Tag breakfast = new Tag("Breakfast");
		Tag dinner = new Tag("Dinner");
		Tag lunch = new Tag("Lunch");
		Tag snack = new Tag("Snack");
		tagRepo.save(breakfast);
		tagRepo.save(dinner);
		tagRepo.save(lunch);
		tagRepo.save(snack);
		
		Recipe croutons = new Recipe("Croutons", "Instructions", "/images/bread.jpg", snack, bread);
		recipeRepo.save(croutons);
		
		Recipe grilledCheese = new Recipe("Grilled Cheese", "Instructions", "/images/bread.jpg", lunch, bread, cheese);
		recipeRepo.save(grilledCheese);
		
		Recipe scrambledEggs = new Recipe("Scrambled Eggs", "Instructions", "/images/bread.jpg", breakfast, eggs, cheese);
		recipeRepo.save(scrambledEggs);
		
		Recipe tacos = new Recipe("Tacos", "Instructions", "/images/bread.jpg", dinner, groundBeef, tortillas);
		recipeRepo.save(tacos);
		
		InventoryItem popcorn = new InventoryItem("Popcorn");
		InventoryItem butter = new InventoryItem("Butter");
		InventoryItem bread1 = new InventoryItem("Bread");
		InventoryItem cheese1 = new InventoryItem("Cheese");
		inventoryRepo.save(popcorn);
		inventoryRepo.save(butter);
		inventoryRepo.save(bread1);
		inventoryRepo.save(cheese1);
	}

}
