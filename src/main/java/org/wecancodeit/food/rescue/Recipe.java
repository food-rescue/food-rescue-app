package org.wecancodeit.food.rescue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {

	@Id
	@GeneratedValue
	private long id;
	private String recipeName;
	private String instructions;
	private String imagePath;

	public Recipe(String recipeName, String instructions, String imagePath, Item... items) {
		this.recipeName = recipeName;
		this.instructions = instructions;
		this.imagePath = imagePath;

	}

	public Recipe() {

	}

	public long getId() {

		return id;
	}

	public String getRecipeName() {

		return recipeName;
	}

	public String getInstructions() {

		return instructions;
	}

	public String getImage() {

		return imagePath;
	}

}
