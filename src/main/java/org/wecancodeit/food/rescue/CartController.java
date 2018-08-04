package org.wecancodeit.food.rescue;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

	@Resource
	private CartRepository cartRepo;

	@Resource
	private ItemRepository itemRepo;

	@Resource
	private RecipeRepository recipeRepo;

	@RequestMapping("/cart")
	public String findAllCartItems(Model model) {
		model.addAttribute("cartModel", cartRepo.findAll());
		return "cart";
	}

	@RequestMapping("/add-item")
	public String addItemsToCart(@RequestParam(value = "id") long itemId) {
		Optional<Item> itemResult = itemRepo.findById(itemId);
		Item item = itemResult.get();
		Cart lineItem;

		Optional<Cart> foundItem = cartRepo.findByItem(item);

		if (foundItem.isPresent()) {
			lineItem = foundItem.get();
		} else {
			lineItem = new Cart(item);
		}

		cartRepo.save(lineItem);

		return "redirect:/cart";
	}

	@RequestMapping("/add-item-to-cart-button")
	public String addItemsToCartFromRecipe(@RequestParam(value = "itemId") long itemId,
			@RequestParam(value = "recipeId") Long recipeId) {
		Optional<Item> itemResult = itemRepo.findById(itemId);
		Item item = itemResult.get();
		Cart lineItem;

		Optional<Cart> foundItem = cartRepo.findByItem(item);

		if (foundItem.isPresent()) {
			lineItem = foundItem.get();
		} else {
			lineItem = new Cart(item);
		}

		cartRepo.save(lineItem);

		return "redirect:/cart";
	}
}
