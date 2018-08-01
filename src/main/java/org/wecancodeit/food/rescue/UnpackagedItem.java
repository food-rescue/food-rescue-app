package org.wecancodeit.food.rescue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnpackagedItem extends Item {
	
	@Id
	@GeneratedValue
	private long id;
	private String purchaseDate;

	public UnpackagedItem(String itemName, String itemImage, String purchaseDate) {
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.purchaseDate = purchaseDate;
	}
	
	public UnpackagedItem() {
		
	}

	public long getId() {
		return id;
	}

	public String getPurchaseDate() {

		return purchaseDate;
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
		UnpackagedItem other = (UnpackagedItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
