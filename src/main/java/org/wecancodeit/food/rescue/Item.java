package org.wecancodeit.food.rescue;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private long id;
	private String itemName;
	
	@Lob
	private String itemTip; 
	

	@JsonIgnore
	@ManyToMany(mappedBy = "items")
	private Collection<Recipe> recipes;
	private String itemImage;

	public Item() {

	}

	public Item(String itemName, String itemImage, String itemTip) {
		this.itemName = itemName;
		this.setItemImage(itemImage);
		this.itemTip = itemTip; 
	}

	public long getId() {
		return id;
	}


	public Collection<Recipe> getRecipes() {
		return recipes;
	}
	
	public String getItemName() {
		
		return itemName;
	}
	public String getItemImage() {
		return itemImage;
	}
	
	public String getTip() {
		return itemTip; 
	}
	
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
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
