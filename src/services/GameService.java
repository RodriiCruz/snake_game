package services;

import java.awt.event.KeyEvent;

import enums.Direction;
import models.Food;
import models.Snake;
import utils.Checker;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class GameService {

	private int quantity;
	private Snake snake;
	private Food food;
	private Checker checker;

	public GameService(int quantity, Snake snake, Food food) {
		this.quantity = quantity;
		this.snake = snake;
		this.food = food;
		this.checker = new Checker(snake, food);
	}

	public void move() {
		Integer[] snakeHead = snake.getBody().get(snake.getBody().size() - 1);

		int newX = 0;
		int newY = 0;

		switch (snake.getDirection()) {
		case UP:
			newY--;
			break;
		case RIGHT:
			newX++;
			break;
		case DOWN:
			newY++;
			break;
		case LEFT:
			newX--;
			break;
		default:
			break;
		}

		Integer[] newDir = { Math.floorMod(snakeHead[0] + newX, quantity),
				Math.floorMod(snakeHead[1] + newY, quantity) };

		this.checker.checkBody(newDir);

		boolean isFood = this.checker.checkFood(newDir);
		if (isFood) {
			generateFood();
		}

		snake.move(newDir, isFood);
	}

	public void generateFood() {
		boolean exists = false;
		int x = (int) (Math.random() * quantity);
		int y = (int) (Math.random() * quantity);

		for (Integer[] aux : snake.getBody()) {
			if (aux[0] == x && aux[1] == y) {
				exists = true;
				generateFood();
				break;
			}
		}

		if (!exists) {
			Integer[] position = { x, y };
			food.setPosition(position);
		}
	}

	public void changeDirection(KeyEvent e) {
		if (this.checker.checkDirection(e)) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				snake.setDirection(Direction.UP);
				break;
			case KeyEvent.VK_RIGHT:
				snake.setDirection(Direction.RIGHT);
				break;
			case KeyEvent.VK_DOWN:
				snake.setDirection(Direction.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				snake.setDirection(Direction.LEFT);
				break;
			default:
				break;
			}
		}

	}

}
