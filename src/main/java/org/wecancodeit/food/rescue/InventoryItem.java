package org.wecancodeit.food.rescue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InventoryItem {

	@Id
	@GeneratedValue
	private long id;
	private String inventoryItemName;

	public InventoryItem() {
	}

	public InventoryItem(String inventoryItemName) {
		this.inventoryItemName = inventoryItemName;
	}

	public long getId() {
		return id;
	}

	public String getInventoryItemName() {
		return inventoryItemName;
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
		InventoryItem other = (InventoryItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
