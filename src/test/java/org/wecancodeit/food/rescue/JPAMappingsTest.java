package org.wecancodeit.food.rescue;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
	private UnpackagedItemRepository unpackagedRepo;
	
	@Resource
	private PackagedItemRepository packagedRepo;

	@Resource
	private RecipeRepository recipeRepo;

	@Resource
	private TagRepository tagRepo;
	
	@Resource
	private InventoryRepository inventoryRepo;
	
	@Test
	public void shouldSaveAndLoadTwoItems() {
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/18");
		unpackagedRepo.save(unpackagedItem);

		long packagedItemId = packagedItem.getId();
		long unpackagedItemId = unpackagedItem.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<PackagedItem> result = packagedRepo.findById(packagedItemId);
		Optional<UnpackagedItem> result2 = unpackagedRepo.findById(unpackagedItemId);
		packagedItem = result.get();
		unpackagedItem = result2.get();

		assertThat(packagedItem.getItemName(), is("Packaged Item Name"));
		assertThat(packagedItem.getItemImage(), is(""));
		assertThat(packagedItem.getExpirationDate(), is("8/06/18"));
		assertThat(unpackagedItem.getItemName(), is("Unpackaged Item Name"));
		assertThat(unpackagedItem.getItemImage(), is("Image"));
		assertThat(unpackagedItem.getPurchaseDate(), is("7/31/18"));
		assertTrue(result.isPresent());
		assertTrue(result2.isPresent());
	}

	@Test
	public void shouldGenerateTwoItemIds() {
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		unpackagedRepo.save(unpackagedItem);

		long packagedItemId = packagedItem.getId();
		long unpackagedItemId = unpackagedItem.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(packagedItemId, is(greaterThan(0L)));
		assertThat(unpackagedItemId, is(greaterThan(0L)));
	}

	@Test
	public void shouldBeAbleToReturnAFullInventory() {
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		PackagedItem packagedItem2 = new PackagedItem("Packaged Item Name2", "", "8/06/18");
		packagedRepo.save(packagedItem2);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		unpackagedRepo.save(unpackagedItem);
		
		UnpackagedItem unpackagedItem2 = new UnpackagedItem("Unpackaged Item Name2", "Image2", "7/31/2018");
		unpackagedRepo.save(unpackagedItem2);

		entityManager.flush();
		entityManager.clear();

		Iterable<PackagedItem> packagedItems = packagedRepo.findAll();
		Iterable<UnpackagedItem> unpackagedItems = unpackagedRepo.findAll();

		assertThat(packagedItems, containsInAnyOrder(packagedItem, packagedItem2));
		assertThat(unpackagedItems, containsInAnyOrder(unpackagedItem, unpackagedItem2));

	}

	@Test
	public void shouldBeAbleToRemoveAnItem() {
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		unpackagedRepo.save(unpackagedItem);

		long packagedItemId = packagedItem.getId();
		long unpackagedItemId = unpackagedItem.getId();

		entityManager.flush();
		entityManager.clear();

		packagedRepo.deleteById(packagedItemId);
		unpackagedRepo.deleteById(unpackagedItemId);

		Optional<PackagedItem> result = packagedRepo.findById(packagedItemId);
		Optional<UnpackagedItem> result2 = unpackagedRepo.findById(unpackagedItemId);

		assertFalse(result.isPresent());
		assertFalse(result2.isPresent());
	}

	@Test
	public void shouldFindItemByName() {
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		unpackagedRepo.save(unpackagedItem);

		String packagedItemName = packagedItem.getItemName();
		String unpackagedItemName = unpackagedItem.getItemName();

		entityManager.flush();
		entityManager.clear();

		PackagedItem result = packagedRepo.findByItemName(packagedItemName);
		UnpackagedItem result2 = unpackagedRepo.findByItemName(unpackagedItemName);

		assertThat(result, is(packagedItem));
		assertThat(result2, is(unpackagedItem));
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
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		Tag tag = new Tag("lunch");

		tagRepo.save(tag);
		packagedRepo.save(packagedItem);
		unpackagedRepo.save(unpackagedItem);

		Recipe recipe = new Recipe("Recipe Name", "Instructions", "Image", tag, unpackagedItem, packagedItem);
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
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		unpackagedRepo.save(unpackagedItem);

		Tag tag = new Tag("");
		tagRepo.save(tag);

		Recipe recipe = new Recipe("Name", "Instructions", "Image", tag, packagedItem, unpackagedItem);
		recipeRepo.save(recipe);
		long recipeId = recipe.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Recipe> result = recipeRepo.findById(recipeId);
		recipe = result.get();

		assertThat(recipe.getItems(), containsInAnyOrder(packagedItem, unpackagedItem));

	}

	@Test
	public void shouldEstablishItemToRecipeRelationship() {
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		unpackagedRepo.save(unpackagedItem);

		Tag tag = new Tag("");
		tagRepo.save(tag);

		Recipe recipe = new Recipe("Name", "Instructions", "Image", tag, packagedItem, unpackagedItem);
		recipeRepo.save(recipe);
		
		long packagedItemId = packagedItem.getId();
		long unpackagedItemId = unpackagedItem.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<PackagedItem> result = packagedRepo.findById(packagedItemId);
		Optional<UnpackagedItem> result2 = unpackagedRepo.findById(unpackagedItemId);
		
		packagedItem = result.get();
		unpackagedItem = result2.get();

		assertThat(packagedItem.getRecipes(), contains(recipe));
		assertThat(unpackagedItem.getRecipes(), contains(recipe));
	}
	
	@Test
	public void shouldEstablishRecipeToTagRelationship() {
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		unpackagedRepo.save(unpackagedItem);

		Tag tag = new Tag("");
		tagRepo.save(tag);

		Recipe recipe = new Recipe("Name", "Instructions", "Image", tag, packagedItem, unpackagedItem);
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
		PackagedItem packagedItem = new PackagedItem("Packaged Item Name", "", "8/06/18");
		packagedRepo.save(packagedItem);
		
		UnpackagedItem unpackagedItem = new UnpackagedItem("Unpackaged Item Name", "Image", "7/31/2018");
		unpackagedRepo.save(unpackagedItem);

		Tag tag = new Tag("");
		tagRepo.save(tag);

		Recipe recipe1 = new Recipe("Name1", "Instructions", "Image", tag, unpackagedItem);
		Recipe recipe2 = new Recipe("Name2", "Instructions", "Image", tag, packagedItem);
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
//	
//	@Test
//	public void shouldReturnMatchedItems() {
//		Item item1 = new Item("Item1", "");
//		Item item2 = new Item("Item2", "");
//		itemRepo.save(item1);
//		itemRepo.save(item2);
//		
//		InventoryItem item3 = new InventoryItem("Item1");
//		InventoryItem item4 = new InventoryItem("Item3");
//		inventoryRepo.save(item3);
//		inventoryRepo.save(item4);
//		
//		entityManager.flush();
//		entityManager.clear();
//		
//		Iterable<Item> items = itemRepo.findAll();
//		Iterable<InventoryItem> inventoryItems = inventoryRepo.findAll();
//		
//		Collection<Item> matchedItems = new ArrayList<>();
//		for(Item item: items) {
//			String itemName = item.getItemName();
//			for(InventoryItem iItem: inventoryItems) {
//				String inventoryItemName = iItem.getInventoryItemName();
//				if(itemName.equals(inventoryItemName)) {
//					matchedItems.add(item);
//				}
//			}
//		}
//		
//		assertThat(matchedItems, containsInAnyOrder(item1));
//		
//	}
}
