package org.wecancodeit.food.rescue;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

	Item findByItemName(String itemName);

}
