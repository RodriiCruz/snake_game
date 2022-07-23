package utils;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import enums.Direction;
import models.Food;
import models.Snake;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Checker {

	private Snake snake;
	private Food food;

	public Checker(Snake snake, Food food) {
		this.snake = snake;
		this.food = food;
	}

	public void checkCollisions(Integer[] position) {
		for (Integer[] aux : snake.getBody()) {
			if (aux[0] == position[0] && aux[1] == position[1]) {
				JOptionPane.showMessageDialog(null, "Game over");
				System.exit(0);
			}
		}
	}

	public boolean checkFood(Integer[] position) {
		boolean isFood = false;
		if (food.getPosition()[0] == position[0] && food.getPosition()[1] == position[1]) {
			isFood = true;
		}
		return isFood;
	}

	public boolean checkDirection(KeyEvent e) {
		boolean allowed = false;
		if ((snake.getDirection() == Direction.UP || snake.getDirection() == Direction.DOWN)
				&& (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)) {
			allowed = true;
		}

		if ((snake.getDirection() == Direction.RIGHT || snake.getDirection() == Direction.LEFT)
				&& (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)) {
			allowed = true;
		}

		return allowed;
	}

}
