package services;

import models.Snake;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class GameService {

	public void move(Snake snake, int quantity) {
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

		snake.move(newDir);
	}

}
