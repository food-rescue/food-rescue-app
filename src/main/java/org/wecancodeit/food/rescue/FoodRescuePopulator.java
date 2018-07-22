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
		
	}

}
