package org.wecancodeit.food.rescue;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class FoodRescueControllerTest {

	@InjectMocks
	private FoodRescueController underTest;

	@Mock
	private ItemRepository itemRepo;

	@Mock
	private Item item1;

	@Mock
	private Item item2;

	@Mock
	private TagRepository tagRepo;

	@Mock
	private Tag tag1;

	@Mock
	private Tag tag2;

	@Mock
	private RecipeRepository recipeRepo;

	@Mock
	private Recipe recipe1;

	@Mock
	private Recipe recipe2;

	@Mock
	private InventoryRepository inventoryRepo;

	@Mock
	private InventoryItem inventoryItem1;

	@Mock
	private InventoryItem inventoryItem2;
	
	@Mock
	private CartRepository cartRepo;
	
	@Mock
	private Cart cartItem1;
	
	@Mock
	private Cart cartItem2;

	@Mock
	private Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddSingleItemToModel() throws ItemNotFoundException {
		long item1Id = 1L;
		when(itemRepo.findById(item1Id)).thenReturn(Optional.of(item1));
		underTest.findOneItem(item1Id, model);

		verify(model).addAttribute("itemsModel", item1);
	}

	@Test
	public void shouldAddAllItemsToModel() {
		Collection<Item> allItems = Arrays.asList(item1, item2);
		when(itemRepo.findAll()).thenReturn(allItems);
		underTest.findAllItems(model);

		verify(model).addAttribute("itemsModel", allItems);
	}

	@Test
	public void shouldAddSingleRecipeToModel() throws RecipeNotFoundException {
		long recipe1Id = 1L;
		when(recipeRepo.findById(recipe1Id)).thenReturn(Optional.of(recipe1));
		underTest.findOneRecipe(recipe1Id, model);

		verify(model).addAttribute("recipesModel", recipe1);
	}

	@Test
	public void shouldAddAllRecipesToModel() {
		Collection<Recipe> allRecipes = Arrays.asList(recipe1, recipe2);
		when(recipeRepo.findAll()).thenReturn(allRecipes);
		underTest.findAllRecipes(model);

		verify(model).addAttribute("recipesModel", allRecipes);
	}

	@Test
	public void shouldAddSingleTagToModel() throws TagNotFoundException {
		long tag1Id = 1L;
		when(tagRepo.findById(tag1Id)).thenReturn(Optional.of(tag1));
		underTest.findOneTag(tag1Id, model);

		verify(model).addAttribute("tagsModel", tag1);
	}

	@Test
	public void shouldAddAllTagsToModel() {
		Collection<Tag> allTags = Arrays.asList(tag1, tag2);
		when(tagRepo.findAll()).thenReturn(allTags);
		underTest.findAllTags(model);

		verify(model).addAttribute("tagsModel", allTags);
	}

	@Test
	public void shouldAddSingleInventoryItemToModel() throws InventoryItemNotFoundException {
		long inventoryItem1Id = 1L;
		when(inventoryRepo.findById(inventoryItem1Id)).thenReturn(Optional.of(inventoryItem1));
		underTest.findOneInventoryItem(inventoryItem1Id, model);

		verify(model).addAttribute("inventoryItemsModel", inventoryItem1);
	}

	@Test
	public void shouldAddAllInventoryItemsToModel() {
		Collection<InventoryItem> allInventoryItems = Arrays.asList(inventoryItem1, inventoryItem2);
		when(inventoryRepo.findAll()).thenReturn(allInventoryItems);
		underTest.findAllInventoryItems(model);

		verify(model).addAttribute("inventoryItemsModel", allInventoryItems);
	}

	@Test
	public void shouldAddItemsToCartModel() {
		Collection<Cart> cartItems = Arrays.asList(cartItem1, cartItem2);
		when(cartRepo.findAll()).thenReturn(cartItems);
		underTest.findAllCartItems(model);

		verify(model).addAttribute("cartModel", cartItems);
	}
	
	
	
	
	
	
	
}
