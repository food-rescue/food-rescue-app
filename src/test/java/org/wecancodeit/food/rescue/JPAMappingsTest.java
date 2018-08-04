package org.wecancodeit.food.rescue;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ItemRepository itemRepo;

	@Resource
	private RecipeRepository recipeRepo;

	@Resource
	private TagRepository tagRepo;
	
	@Resource
	private InventoryRepository inventoryRepo;
	
	@Resource
	private CartRepository cartRepo;

	
	@Test
	public void shouldGetCalendarItems() {
		Calendar day1 = new GregorianCalendar(2018,8,4);
		
		assertEquals(4, day1.get(Calendar.DATE));
		assertEquals(2018, day1.get(Calendar.YEAR));
		assertEquals(8, day1.get(Calendar.MONTH));
	}
	
	@Test
	public void shouldSaveAndLoadAnItem() {
		Item item = new Item("Item Name", "", new GregorianCalendar(2018,8,04));
		itemRepo.save(item);

		long itemId = item.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Item> result = itemRepo.findById(itemId);
		item = result.get();

		assertThat(item.getItemName(), is("Item Name"));
		assertTrue(result.isPresent());
		assertEquals(4,item.getDate().get(Calendar.DATE));
		assertEquals(8,item.getDate().get(Calendar.MONTH));
		assertEquals(2018,item.getDate().get(Calendar.YEAR));
	}

	@Test
	public void shouldGenerateItemId() {
		Item item = new Item("Item Name", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item);

		long itemId = item.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(itemId, is(greaterThan(0L)));
	}

	@Test
	public void shouldBeAbleToReturnAFullInventory() {
		Item item1 = new Item("Item1 Name", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item1);

		Item item2 = new Item("Item2 Name", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item2);

		entityManager.flush();
		entityManager.clear();

		Iterable<Item> items = itemRepo.findAll();

		assertThat(items, containsInAnyOrder(item1, item2));
	}

	@Test
	public void shouldBeAbleToRemoveAnItem() {
		Item item = new Item("Item Name", "Item Image", new GregorianCalendar(5,9,2019));
		itemRepo.save(item);

		long itemId = item.getId();

		entityManager.flush();
		entityManager.clear();

		itemRepo.deleteById(itemId);

		Optional<Item> result = itemRepo.findById(itemId);

		assertFalse(result.isPresent());
	}

	@Test
	public void shouldFindItemByName() {
		Item item = new Item("Item Name", "Item Image", new GregorianCalendar(5,9,2019));
		itemRepo.save(item);

		String itemName = item.getItemName();

		entityManager.flush();
		entityManager.clear();

		Item result = itemRepo.findByItemName(itemName);

		assertThat(result, is(item));
	}

	@Test
	public void shouldSaveAndLoadATag() {
		Tag tag = new Tag("Meal");
		tagRepo.save(tag);

		long tagId = tag.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Tag> result = tagRepo.findById(tagId);
		tag = result.get();

		assertThat(tag.getMeal(), is("Meal"));
		assertTrue(result.isPresent());
	}

	@Test
	public void shouldGenerateTagId() {
		Tag tag = new Tag("");
		tagRepo.save(tag);

		long tagId = tag.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(tagId, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadARecipe() {
		Item item1 = new Item("bread", "", new GregorianCalendar(5,9,2019));
		Item item2 = new Item("cheese", "", new GregorianCalendar(5,9,2019));
		Tag tag = new Tag("lunch");

		tagRepo.save(tag);
		itemRepo.save(item1);
		itemRepo.save(item2);

		Recipe recipe = new Recipe("Recipe Name", "Instructions", "Image", tag, item1, item2);
		recipeRepo.save(recipe);

		long recipeId = recipe.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Recipe> result = recipeRepo.findById(recipeId);

		recipe = result.get();

		assertThat(recipe.getRecipeName(), is("Recipe Name"));
		assertTrue(result.isPresent());

		assertThat(recipe.getInstructions(), is("Instructions"));

		assertThat(recipe.getImage(), is("Image"));

	}

	@Test
	public void shouldEstablishRecipeToItemRelationship() {
		Item item = new Item("", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item);

		Tag tag = new Tag("");
		tagRepo.save(tag);

		Recipe recipe = new Recipe("Name", "Instructions", "Image", tag, item);
		recipeRepo.save(recipe);
		long recipeId = recipe.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Recipe> result = recipeRepo.findById(recipeId);
		recipe = result.get();

		assertThat(recipe.getItems(), contains(item));

	}

	@Test
	public void shouldEstablishItemToRecipeRelationship() {
		Item item = new Item("", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item);

		Tag tag = new Tag("");
		tagRepo.save(tag);

		Recipe recipe = new Recipe("Name", "Instructions", "Image", tag, item);
		recipeRepo.save(recipe);
		long itemId = item.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Item> result = itemRepo.findById(itemId);
		item = result.get();

		assertThat(item.getRecipes(), contains(recipe));
	}
	
	@Test
	public void shouldEstablishRecipeToTagRelationship() {
		Item item = new Item("", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item);

		Tag tag = new Tag("");
		tagRepo.save(tag);

		Recipe recipe = new Recipe("Name", "Instructions", "Image", tag, item);
		recipeRepo.save(recipe);
		long recipeId = recipe.getId();

		entityManager.flush();
		entityManager.clear();
		
		Optional<Recipe> result = recipeRepo.findById(recipeId);
		recipe = result.get();

		assertThat(recipe.getTag(), is(tag));
	}
	
	@Test
	public void shouldEstablishTagToRecipeRelationship() {
		Item item = new Item("", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item);

		Tag tag = new Tag("");
		tagRepo.save(tag);

		Recipe recipe1 = new Recipe("Name1", "Instructions", "Image", tag, item);
		Recipe recipe2 = new Recipe("Name2", "Instructions", "Image", tag, item);
		recipeRepo.save(recipe1);
		recipeRepo.save(recipe2);
		long tagId = tag.getId();

		entityManager.flush();
		entityManager.clear();
		
		Optional<Tag> result = tagRepo.findById(tagId);
		tag = result.get();

		assertThat(tag.getRecipes(), containsInAnyOrder(recipe1, recipe2));
	}
	
	@Test
	public void shouldBeAbleToSaveAndLoadToInventoryRepo() {
		InventoryItem item = new InventoryItem("Item name");
		inventoryRepo.save(item);
		
		long itemId = item.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<InventoryItem> result = inventoryRepo.findById(itemId);
		item = result.get();

		assertThat(item.getInventoryItemName(), is("Item name"));
		assertTrue(result.isPresent());
	}
	
	@Test
	public void shouldBeAbleToReturnAFullInventoryFromInventoryRepo() {
		InventoryItem item1 = new InventoryItem("Item1 Name");
		inventoryRepo.save(item1);

		InventoryItem item2 = new InventoryItem("Item2 Name");
		inventoryRepo.save(item2);

		entityManager.flush();
		entityManager.clear();

		Iterable<InventoryItem> items = inventoryRepo.findAll();

		assertThat(items, containsInAnyOrder(item1, item2));
	}
	
	@Test
	public void shouldBeAbleToRemoveAnItemFromInventoryRepo() {
		InventoryItem item = new InventoryItem("Item Name");
		inventoryRepo.save(item);

		long itemId = item.getId();

		entityManager.flush();
		entityManager.clear();

		inventoryRepo.deleteById(itemId);
	
		Optional<InventoryItem> result = inventoryRepo.findById(itemId);

		assertFalse(result.isPresent());
	}
	
	@Test
	public void shouldReturnMatchedItems() {
		Item item1 = new Item("Item1", "", new GregorianCalendar(5,9,2019));
		Item item2 = new Item("Item2", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item1);
		itemRepo.save(item2);
		
		InventoryItem item3 = new InventoryItem("Item1");
		InventoryItem item4 = new InventoryItem("Item3");
		inventoryRepo.save(item3);
		inventoryRepo.save(item4);
		
		entityManager.flush();
		entityManager.clear();
		
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
		
		assertThat(matchedItems, containsInAnyOrder(item1));
	}
	
	@Test
	public void shouldSaveAndLoadAnItemToTheCart() {
		Item item = new Item("Item Name", "", new GregorianCalendar(5,9,2019));
		itemRepo.save(item);
		
		Cart cart = new Cart(item);
		cartRepo.save(cart);

		long cartId = cart.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Cart> result = cartRepo.findById(cartId);
		cart = result.get();

		assertThat(cart.getItem().getItemName(), is("Item Name"));
		assertTrue(result.isPresent());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
