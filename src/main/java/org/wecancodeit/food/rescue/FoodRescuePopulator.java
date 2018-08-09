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
		
		Item avocado = new Item("Avocado", "/images/iAvocado.jpg", "You can brush your avocado's flesh with lemon juice -- the citric acid in the lemon juice dramatically slows the browning process. Store in an airtight container for extra protection.");
		Item bacon = new Item("Bacon", "/images/bacon.jpg", "Packaged sliced bacon can be kept in its unopened vacuum-sealed package in the refrigerator up to a week past the expiration date. Once opened, keep it tightly wrapped in foil or a zip-top bag and use within one week. Sealed packages of bacon can be frozen up to one month before the fat begins to go rancid."); 
		Item balsamicVinegar = new Item("Balsamic Vinegar", "/images/iBalsamicVinegar.jpg", "If you're using balsamic vinegars primarily for salads and like them chilled, they can be refrigerated. If you're using them for sauces, marinades, and reductions, store them in a cupboard. The shelf life of balsamic vinegar should be between 3-5 years.");
		Item bananas = new Item("Bananas", "/images/iBanana.jpg", "To keep a bunch of bananas fresh for longer, wrap the stems in some plastic wrap. Re-cover the bananas with the wrap after removing one. This method prevents ethylene gas, produced naturally in the ripening process, from reaching other parts of the fruit and prematurely ripening it.");
		Item bread = new Item("Bread", "/images/iBread.jpg", "Bread actually goes stale faster in the refrigerator than it does at room temperature. The best way to keep bread at its best is to keep it at room temperature for a day or two, then wrap it up and freeze it for longer-term storage. ");
		Item brownSugar = new Item("Brown Sugar", "/images/iBrownSugar.jpg", "You can put a slice of bread or a slice of an apple or even a damp paper towel in with the brown sugar to keep it soft. (What is quite amazing is that neither the apple nor the bread gets moldy or rancid.\r\n" + 
				"");
		Item butter = new Item("Butter", "/images/iButter.jpg", "Keep butter refrigerated in its original wrapper. The foil laminated paper helps prevent spoilage from exposure to light and air, and also protects butter from picking up the flavour of other foods. If you wrap it well, once opened, both salted and unsalted butter will keep in the fridge for three weeks.");
		Item cheese = new Item("Cheese", "/images/iCheese.jpg", "Use a fresh piece of plastic wrap or wax paper to rewrap cheese after each use.");
		Item chickenBreast = new Item("Chicken Breast", "/images/iChickenBreast.jpg", "Chicken should be discarded if left for more than 2 hours at room temperature. To further extend the shelf life of raw chicken, freeze; when freezing, place chicken in the freezer before the number of days shown for refrigerator storage has elapsed." );
		Item chiliPowder = new Item("Chili Powder", "/images/iChiliPowder.jpg", "Heat damages spices and weakens their flavor. Spices should be kept in a cool, dry, dark area of your kitchen, like in the pantry. Red-colored spices (including red pepper, paprika and chili powder) should always be stored in the fridge, especially in hot and humid climates.");
		Item chives = new Item("Chives", "/images/iChives.jpg", "Store fresh chives in the refrigerator in a resealable plastic bag, keeping the air inside, for up to a week. You can also place the stems standing up in a glass or jar filled with a few inches of water and covered with a plastic bag. Do not wash until ready to use the chives, as excessive moisture will promote decay.");
		Item cinnamon = new Item("Cinnamon", "/images/iCinnamon.jpg", "");
		Item cilantro = new Item("Cilantro", "/images/iCilantro.jpg", "Chop  up all the cilantro and just store it in a freezer zip lock bag and refrigerate.");
		Item cookedWhiteRice = new Item("Cooked White Rice", "/images/iCookedWhiteRice.jpg", "Cooked white rice will generally stay good for 4-6 days in the refrigerator and 6 months in the freezer. How long does uncooked brown rice last? Thanks to its higher oil content, brown rice will only keep for 3 to 6 months at room temperature.");
		Item eggs = new Item("Eggs", "/images/iEggs.jpg", "Should not be stored on the refrigerator door, but in the main body of the refrigerator to ensure that they keep a consistent and cool temperature."); 
		Item garlicPowder = new Item("Garlic Powder", "/images/iGarlicPowder.jpg", "Heat damages spices and weakens their flavor. Spices should be kept in a cool, dry, dark area of your kitchen, like in the pantry. Red-colored spices (including red pepper, paprika and chili powder) should always be stored in the fridge, especially in hot and humid climates.");
		Item garlicSalt = new Item("Garlic Salt", "/images/iGarlicSalt.jpg", "Heat damages spices and weakens their flavor. Spices should be kept in a cool, dry, dark area of your kitchen, like in the pantry. Red-colored spices (including red pepper, paprika and chili powder) should always be stored in the fridge, especially in hot and humid climates.");
		Item greenOnions = new Item("Green Onions", "/images/iGreenOnions.jpg", "Place your green onions in a jar with a bit of water. Then cover them with a plastic bag and store them in the refrigerator.");
		Item groundBeef = new Item("Ground Beef", "/images/iGroundBeef.jpg", "Keep refrigerated and use or freeze within 1 to 2 days of purchase. It's okay to keep the ground beef in its original store packaging when refrigerating; do not open the package until you're ready to use it. You can also freeze ground beef — use within 3 to 4 months for best quality.");
		Item honey = new Item("Honey", "/images/iHoney.jpg", "Liquid honey however should be stored in your cupboard at room temperature as if it is kept in the refrigerator; the cooler temperature will promote and speed up the crystallization of liquid honey.");
		Item lemons = new Item("Lemons", "/images/iLemons.jpg", "While there's nothing wrong with keeping your lemons out on the counter (especially if you don't buy more than you can use before they dry out), they'll definitely stay fresh longer if you put them in the fridge in a sealed plastic bag.");
		Item lettuce = new Item("Lettuce", "/images/iLettuce.jpg", "Spin dry if using a salad spinner. If not, transfer the lettuce to a colander and shake off excess water. Lay out and air dry the lettuce on a clean counter, dish towel, or paper towels until completely dry. Place the lettuce in a gallon plastic zip-top bag along with a paper towel.\r\n" + 
				"");
		Item limes = new Item("Limes", "/images/iLimes.jpg", "You can help limes keep fresh longer by storing them in your refrigerator drawer. If limes were purchased in a plastic bag, remove them from the bag which could have trapped moisture which will cause the limes to soften and spoil.");
		Item milk = new Item("Milk", "/images/iMilk.jpg", "Milk can be frozen for up to 6 weeks without any impact on its flavour and nutritional value; however, upon thawing, it can separate and lose its smooth texture. Partly skimmed and skim milk freeze better than whole milk (3.25%). Thaw milk in the fridge. If the milk separates upon thawing, beat it with an electric mixer or an immersion blender with the whip attachment.");
		Item onions = new Item("Onions", "/images/iOnions.jpg",  "You could store your onions in brown paper bags if you would rather. Take your brown paper sandwich bag (it can be any color, really) and fold it in half lengthwise.Using a hole punch, punch holes down both sides of the folded bag. When you’re done, unfold the bag. You should have 4 lines of holes down the front and back of the bag, and 2 lines on each side. Like the mesh or pantyhose, these holes will help the air circulate around the onions to keep them dry. Any residual moisture will be absorbed by the paper bag. Fold the top of the bag down and secure it with tape, staples, paper clips, clothes pins, or my personal favorite, binder clips.");
		Item pankoBreadCrumbs = new Item("Panko Bread Crumbs", "/images/iPankoBreadCrumbs.jpg", "As long as you keep them dry they will pretty much last forever. They don't really go bad.");
		Item poblanoPepper = new Item("Poblano Pepper", "/images/iPoblanoPepper.jpg", "To maximize the shelf life of raw poblano peppers, store in a paper bag in the vegetable crisper of refrigerator.");
		Item potatos = new Item("Potatos", "/images/iPotatos.jpg", "Potatoes keep best when placed in a well-ventilated container and stored in a dry location, away from sunlight, and at temperatures between 45 and 55 degrees F. That isn’t too easy to find in most homes today but if you place them in a paper bag, cardboard box, or bowl (not in a plastic bag) and keep them in the coolest part of the kitchen or a dry part of your basement, it should help their longevity.");
		Item ranchDressing = new Item("Ranch Dressing", "/images/iRanchDressing.jpg", "Store prepared dressing in the refrigerator in a covered container and if used as directed, the prepared dressing will stay fresh 3–4 weeks. Refrigerate after opening for better flavor.");
		Item salmon = new Item("Salmon", "/images/iSalmon.jpg", "Wrap the fish tightly in a layer of plastic wrap, followed by another layer of aluminum foil. You can also add lemon slices for taste, before you wrap up the salmon. Place in the coldest part of your refrigerator, most likely the bottom drawer.");
		Item sesameSeeds = new Item("Sesame Seeds", "/images/iSesameSeeds.jpg", "The best way to store sesame seeds is in an airtight container or bag in the pantry or another cool dark place with a constant temperature.");
		Item soySauce = new Item("Soy Sauce", "/images/iSoySauce.jpg", "It will keep its flavor and freshness longer when refrigerated. Kikkoman does say on their soy sauce product page that it should be kept in a cool place.");
		Item steamedBroccoli = new Item("Steamed Broccoli", "/images/iSteamedBroccoli.jpg", "Consume fresh broccoli as soon as you can as it will not keep long. To store, mist the unwashed heads, wrap loosely in damp paper towels, and refrigerate. Use within 2 to 3 days. Do not store broccoli in a sealed container or plastic bag.");
		Item strawberry = new Item("Strawberry", "/images/strawberry.jpg", "For the short term: Arrange the berries (without washing or removing the stems) on a paper towel-lined tray and cover with plastic wrap; then refrigerate. Before eating or using them, wash the berries under cool water and then remove stems.");
		Item tacoShells = new Item("Taco Shells", "/images/iTacoShells.jpg", "Report Abuse Comment\r\n" + 
				" kari\r\n" + 
				"Put them in a freezer bag. It's a much thicker plastic and will keep them fresh for a long time even if not in the freezer.");
		Item tomatoes = new Item("Tomatoes", "/images/iTomatoes.jpg", "You definitely shouldn't put those tomatoes in the refrigerator. They need to stay at room temperature, ideally in a single layer out of direct sunlight. And most importantly for keeping them fresher longer, store them stem side down while they finish ripening.\r\n" + 
				"");
		Item tomatoSauce = new Item("Tomato Sauce", "/images/iTomatoSauce.jpg", "Refrigerate sauce and use it within a week or freeze it for up to 3 months. Canned tomato sauce can be stored in the pantry for at least 1 year.");
		Item tortillas = new Item("Tortillas", "/images/iTortillas.jpg", "Place the tortillas in a resealable plastic bag or airtight storage container. Keep them in the refrigerator for up to two weeks");
		
		itemRepo.save(avocado);
		itemRepo.save(bacon);
		itemRepo.save(balsamicVinegar);
		itemRepo.save(bananas);
		itemRepo.save(bread);
		itemRepo.save(brownSugar);
		itemRepo.save(butter);
		itemRepo.save(cheese);
		itemRepo.save(chickenBreast);
		itemRepo.save(chiliPowder);
		itemRepo.save(chives);
		itemRepo.save(cilantro);
		itemRepo.save(cinnamon);
		itemRepo.save(cookedWhiteRice);
		itemRepo.save(eggs);
		itemRepo.save(garlicPowder);
		itemRepo.save(garlicSalt);
		itemRepo.save(greenOnions);
		itemRepo.save(groundBeef);
		itemRepo.save(honey);
		itemRepo.save(lemons);
		itemRepo.save(lettuce);
		itemRepo.save(limes);
		itemRepo.save(milk);
		itemRepo.save(pankoBreadCrumbs);
		itemRepo.save(onions);
		itemRepo.save(poblanoPepper);
		itemRepo.save(potatos);
		itemRepo.save(ranchDressing);
		itemRepo.save(salmon);
		itemRepo.save(sesameSeeds);
		itemRepo.save(soySauce);
		itemRepo.save(steamedBroccoli);
		itemRepo.save(strawberry);
		itemRepo.save(tacoShells);
		itemRepo.save(tomatoes);
		itemRepo.save(tomatoSauce);
		itemRepo.save(tortillas);
		
		Tag breakfast = new Tag("Breakfast");
		Tag dinner = new Tag("Dinner");
		Tag lunch = new Tag("Lunch");
		Tag snack = new Tag("Snack");
		tagRepo.save(breakfast);
		tagRepo.save(dinner);
		tagRepo.save(lunch);
		tagRepo.save(snack);
		tagRepo.save(snack);   
 		tagRepo.save(snack);   
   
 		Recipe lettuceWrap = new Recipe("Chicken, Bacon, Avocado Ranch Lettuce Wrap", "1) Start by seasoning the chicken with salt and pepper, then grill them (you could do stovetop as well). " + 
 				"2) Meanwhile, bake your bacon on a foil lined cookie sheet at 420°F. Start checking for doneness at 15 minutes but it will likely take closer to 20. " + 
 				"3) I had used ends and pieces so they came already chopped, but if you use regular slab bacon crumble it up after it's cooked. " + 
 				"4) When the chicken is done, cut it up into bite sized pieces and mix the cilantro in. " + 
 				"5) Wash the lettuce, and carefully remove each leaf so that it creates a boat, or cup to put the yumminess in. " + 
 				"6) Now set all your ingredients out so people can build their own lettuce wrap. Squeeze half a lime over the avocado, tomato, and chicken. " + 
 				"7) Take the lettuce leaf, fill it with the bacon, avocado, tomato, and chicken. Then drizzle with ranch. " + 
 				"8) Eat it like a taco and enjoy!", "/images/chicken.jpg", lunch, avocado, bacon, cilantro, chickenBreast, limes, ranchDressing, tomatoes);
 		recipeRepo.save(lettuceWrap);
 		
 		Recipe croutons = new Recipe("Croutons", "1) Preheat oven to 350°F. " + 
 						"2) Remove crusts from stale bread slices. Brush bread on both sides with melted butter. Cut bread slices up into small cubes. Sprinkle with garlic salt (if desired). Arrange cubes on an ungreased cookie sheet. " + 
 						"3) Bake at 350°F for 15 minutes or until browned. Let cool. Store croutons in a covered container or plastic bag. Serve in soups or salads.", "/images/croutons.jpg", snack, bread, butter, garlicSalt);
 		recipeRepo.save(croutons);
 		
 		Recipe teriyakiChicken = new Recipe("Easy Teriyaki Chicken", "1) Season the chicken with a salt and pepper, to taste. Set aside. " + 
 				"2) Heat the oil in a heavy bottomed frying pan or wok over medium heat. " + 
 				"3) You don't want to start the chicken off too high a heat otherwise it will not cook through before burning. " + 
 				"4) Add chicken and saute, stirring occasionally, until the chicken is no longer pink on the inside, and golden brown on the sides. " + 
 				"5) Once the chicken is ready to go, pour the soy sauce, brown sugar, and sesame seeds over it, then toss to combine until the chicken is evenly coated. " + 
 				"6) Continue cooking, stirring frequently until the sauce reaches a simmer and thickens. " + 
 				"7) Remove from heat, and serve immediately with cooked white rice and steamed broccoli, garnished with thinly-sliced green onions if desired. " + 
 				"8) Drizzle the remaining teriyaki sauce over if desired. " + 
 				"9) * The magic is not over cooking the chicken during the sauteing process. It gives the glaze mixture more time to cook down. Keep stiring the chicken while its glazing. It will help it not to burn.",
 				"/images/teriyaki.jpg", dinner, chickenBreast, soySauce, brownSugar, cookedWhiteRice, steamedBroccoli, greenOnions, sesameSeeds); 
 		recipeRepo.save(teriyakiChicken);
 		
 		Recipe hashbrownWaffle = new Recipe("Egg & Cheese Hashbrown Waffle", "1) Heat waffle iron on medium-high setting. Spray each side generously with non-stick cooking spray or brush with melted butter. " + 
 				"2) In a medium-sized mixing bowl, whisk together eggs and milk. Stir in potatoes, cheese, chives and season with 1/2 teaspoon salt and 1/4 teaspoon pepper. " + 
 				"3) Depending on the size of your waffle iron, scoop a layer of the potato mixture onto the surface (for the round waffle maker, I used about 1 cup of the mixture). Spread to about 1/2 inch from the edges and close the waffle iron. Cook for about 5 minutes, checking every few minutes to avoid burning. When the entire waffle is golden brown in color, carefully remove from the waffle iron with a fork or tongs. " + 
 				"4) *Tip: Turn your oven to the \"warm\" function and place finished waffles on a baking sheet in the oven to keep warm while the rest are cooking.", "/images/waffles.jpg", breakfast, potatos, eggs, cheese, butter, milk, chives);
 		recipeRepo.save(hashbrownWaffle);
 		
 		Recipe grilledCheese = new Recipe("Grilled Cheese", "1) Preheat skillet over medium heat. 2) Generously butter one side of a slice of bread. 3) Place bread butter-side-down onto skillet bottom and add 1 slice of cheese. 4) Butter a second slice of bread on one side and place butter-side-up on top of sandwich. 5) Grill until lightly browned and flip over; continue grilling until cheese is melted. *Repeat with remaining 2 slices of bread, butter and slice of cheese.",
 				"/images/grilled.jpg", lunch, bread, cheese, butter);
 		recipeRepo.save(grilledCheese);
 		
 		Recipe salmonBurger = new Recipe("Grilled Salmon Burgers with Avocado Salsa", "1) Skin and chop salmon fillet. " + 
 				"2)Put in large bowl. " + 
 				"3) Add panko, poblano,egg, green onion, lemon or lime juice, salt and pepper. " + 
 				"4) Mix well. " + 
 				"(Hint: make a cross on top of the salmon mixture before making into patties to ensure consistent size) " + 
 				"5) Heat indoor grill pan or outdoor BBQ to medium high heat. " + 
 				"6) Cook for about 4 minutes on each side until cooked through. " + 
 				"7) Avocado Salsa " + 
 				"8) Combine all ingredients in medium bowl. " + 
 				"9) Top burgers with salsa. Serve with or without bun.", "/images/salmon.jpg", dinner, avocado, salmon, pankoBreadCrumbs, poblanoPepper, lemons, limes, eggs, greenOnions);
 		recipeRepo.save(salmonBurger);
 		
 		Recipe friedBananas = new Recipe("Pan Fried Bananas", "1) Combine the cinnamon, butter and honey in a frying pan over medium-high heat until melted and combined. " + 
 				"2) Add the banana slices and cook for 4 minutes until the bottoms start to caramelize and turn golden brown. Adjust the temperature and cooking time as needed so that they don't burn. " + 
 				"3) Flip all the banana pieces and cook for another 4 minutes until the other side is golden brown. " + 
 				"4) Serve immediately over ice cream, yogurt, pancakes or french toast.", "/images/bananas.jpg", snack, bananas, butter, cinnamon, honey);
 		recipeRepo.save(friedBananas);
 		
 		Recipe scrambledEggs = new Recipe("Scrambled Eggs", "1) Beat eggs, milk, salt and pepper in medium bowl until blended. " + 
 				"2) Heat butter in large nonstick skillet over medium heat until hot. Pour in egg mixture. As eggs begin to set, gently pull the eggs across the pan with a spatula, forming large soft curds. " + 
 				"3) Continue cooking, pulling, lifting and folding eggs until thickened and no visible liquid egg remains. *Do not stir constantly. 4) Remove from heat and serve immediately.", 
 				"/images/eggs.jpg", breakfast, eggs, cheese, butter, milk);
 		recipeRepo.save(scrambledEggs);
 		
		Recipe avocadoToast = new Recipe("Strawberry Balsamic Avocado Toast", "Toss sliced strawberries with a drizzle of balsamic vinegar, then pile on top of your avocado toast! The unexpected combination of strawberries and avocados works really well, especially with the rich tartness of balsamic vinegar.", 
				"/images/toast.jpg", breakfast, avocado, balsamicVinegar, bread, strawberry);
		recipeRepo.save(avocadoToast);
		
		Recipe tacos = new Recipe("Tacos", "1) Heat oven to 250°F. In medium skillet, brown ground beef and onion over medium heat for 8 to 10 minutes or until beef is thoroughly cooked, stirring frequently. Drain. " + 
				"2) Stir in chili powder, salt, garlic powder and tomato sauce. Reduce heat to low; cover and simmer 10 minutes. " + 
				"3) Meanwhile, place taco shells on ungreased cookie sheet. Heat at 250°F. for 5 minutes. " + 
				"4) To assemble tacos, layer beef mixture, cheese, lettuce and tomatoes in each taco shell. Serve with salsa; top with sour cream.", "/images/tacos.jpg", dinner, groundBeef, onions, tortillas, tacoShells, chiliPowder, tomatoSauce);
		recipeRepo.save(tacos);
		
	}

}
