package services;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import enums.Direction;
import models.Food;
import models.Snake;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class GameService {

	private int quantity;
	private Snake snake;
	private Food food;

	public GameService(int quantity, Snake snake, Food food) {
		this.quantity = quantity;
		this.snake = snake;
		this.food = food;
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

		this.checkBody(newDir);
		snake.move(newDir, this.checkFood(newDir));
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
		case KeyEvent.VK_SPACE:
			snake.setDirection(Direction.LEFT);
			break;
		default:
			break;
		}
	}

	private void checkBody(Integer[] position) {
		for (Integer[] aux : snake.getBody()) {
			if (aux[0] == position[0] && aux[1] == position[1]) {
				JOptionPane.showMessageDialog(null, "Chocaste contra tu cuerpo! Juego terminado.");
				System.exit(0);
			}
		}
	}

	private boolean checkFood(Integer[] position) {
		boolean isFood = false;
		if (food.getPosition()[0] == position[0] && food.getPosition()[1] == position[1]) {
			isFood = true;
			snake.eatFood(position);
			this.generateFood();
		}
		return isFood;
	}

}
