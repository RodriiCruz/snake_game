package models;

import java.awt.Color;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Food {

	private Color foodColor;
	private Integer[] position;

	public Food(Color foodColor) {
		this.foodColor = foodColor;
	}

	public Color getFoodColor() {
		return foodColor;
	}

	public void setFoodColor(Color foodColor) {
		this.foodColor = foodColor;
	}

	public Integer[] getPosition() {
		return position;
	}

	public void setPosition(Integer[] position) {
		this.position = position;
	}
}
