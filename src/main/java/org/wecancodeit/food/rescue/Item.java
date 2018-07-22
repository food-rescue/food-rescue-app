package org.wecancodeit.food.rescue;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private long id;
	private String itemName;

	@ManyToMany(mappedBy = "items")
	private Collection<Recipe> recipes;

	public Item() {

	}

	public Item(String itemName) {
		this.itemName = itemName;
	}

	public long getId() {
		return id;
	}

	public String getItemName() {

		return itemName;
	}

	public Collection<Recipe> getRecipes() {
		return recipes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
