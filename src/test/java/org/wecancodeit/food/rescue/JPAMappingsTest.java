package org.wecancodeit.food.rescue;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
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

	@Test
	public void shouldSaveAndLoadAnItem() {
		Item item = new Item("Item Name");
		itemRepo.save(item);

		long itemId = item.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Item> result = itemRepo.findById(itemId);
		item = result.get();

		assertThat(item.getItemName(), is("Item Name"));
		assertTrue(result.isPresent());
	}

	@Test
	public void shouldGenerateItemId() {
		Item item = new Item("Item Name");
		itemRepo.save(item);

		long itemId = item.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(itemId, is(greaterThan(0L)));
	}

	@Test
	public void shouldBeAbleToReturnAFullInventory() {
		Item item1 = new Item("Item1 Name");
		itemRepo.save(item1);

		Item item2 = new Item("Item2 Name");
		itemRepo.save(item2);

		entityManager.flush();
		entityManager.clear();

		Iterable<Item> items = itemRepo.findAll();

		assertThat(items, containsInAnyOrder(item1, item2));
	}

	@Test
	public void shouldBeAbleToRemoveAnItem() {
		Item item = new Item("Item Name");
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
		Item item = new Item("Item Name");
		itemRepo.save(item);

		String itemName = item.getItemName();

		entityManager.flush();
		entityManager.clear();

		Item result = itemRepo.findByItemName(itemName);

		assertThat(result, is(item));
	}

	@Test
	public void shouldSaveAndLoadARecipe() {
		Item item1 = new Item("bread");
		Item item2 = new Item("cheese");

		Recipe recipe = new Recipe("Recipe Name", "Instructions", "Image", item1, item2);
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

}
