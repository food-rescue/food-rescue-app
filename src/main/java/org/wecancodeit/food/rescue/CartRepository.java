package org.wecancodeit.food.rescue;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {

	Optional<Cart> findByItem(Item item);

}
 