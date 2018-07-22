package org.wecancodeit.food.rescue;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoodRescueController {

	@Resource
	ItemRepository itemRepo;

	@Resource
	RecipeRepository recipeRepo;

	@Resource
	TagRepository tagRepo;

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

}
