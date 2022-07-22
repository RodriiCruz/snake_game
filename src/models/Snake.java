package models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Snake {

	private Color snakeColor;
	private List<Integer[]> body;
	private Color foodColor;
	private String direccion;

	public Snake(Color snakeColor, Color foodColor) {
		this.snakeColor = snakeColor;
		this.body = new ArrayList<Integer[]>();
		this.foodColor = foodColor;
	}

	public Color getSnakeColor() {
		return snakeColor;
	}

	public void setSnakeColor(Color snakeColor) {
		this.snakeColor = snakeColor;
	}

	public List<Integer[]> getBody() {
		return body;
	}

	public void eatFood(Integer[] food) {
		this.body.add(food);
	}

	public Color getFoodColor() {
		return foodColor;
	}

	public void setFoodColor(Color foodColor) {
		this.foodColor = foodColor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
