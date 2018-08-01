package org.wecancodeit.food.rescue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PackagedItem extends Item {
	
	@Id
	@GeneratedValue
	private long id;
	protected String expirationDate;
	
	public PackagedItem(String itemName, String itemImage, String expirationDate) {
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.expirationDate = expirationDate;
	}
	
	public PackagedItem() {
		
	}
	
	public long getId() {
		
		return id;
	}
	
	public String getExpirationDate() {
		
		return expirationDate;
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
		PackagedItem other = (PackagedItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
