package org.wecancodeit.food.rescue;

import org.springframework.data.repository.CrudRepository;

public interface PackagedItemRepository extends CrudRepository<PackagedItem, Long> {

	PackagedItem findByItemName(String packagedItemName);

}
