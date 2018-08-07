package org.wecancodeit.food.rescue;

import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<InventoryItem, Long> {
	
	InventoryItem findByInventoryItemName(String inventoryItemName);

	InventoryItem findByInventoryItemNameIgnoreCaseLike(String inventoryItemName);

	InventoryItem findByInventoryItemId(long inventoryItemId);

	void deleteById(InventoryItem foodToDelete);

}
