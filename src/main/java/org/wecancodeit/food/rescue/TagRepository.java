package org.wecancodeit.food.rescue;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByMeal(String tagName);

}
