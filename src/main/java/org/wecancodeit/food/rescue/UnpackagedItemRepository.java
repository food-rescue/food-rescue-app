package org.wecancodeit.food.rescue;

import org.springframework.data.repository.CrudRepository;

public interface UnpackagedItemRepository extends CrudRepository<UnpackagedItem, Long> {

	UnpackagedItem findByItemName(String unpackagedItemName);

}
