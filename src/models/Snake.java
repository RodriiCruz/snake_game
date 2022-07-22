package models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import enums.Direction;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Snake {

	private Color snakeColor;
	private List<Integer[]> body;
	private Color foodColor;
	private Direction direction;

	public Snake(Color snakeColor, Color foodColor) {
		this.snakeColor = snakeColor;
		this.body = new ArrayList<Integer[]>();
		this.foodColor = foodColor;
		this.direction = Direction.RIGHT;
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

	public void move(Integer[] dir) {
		this.body.add(dir);
		this.body.remove(0);
	}

	public Color getFoodColor() {
		return foodColor;
	}

	public void setFoodColor(Color foodColor) {
		this.foodColor = foodColor;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
