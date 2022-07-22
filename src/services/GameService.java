package services;

import models.Snake;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class GameService {

	public void move(Snake snake) {
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

		Integer[] newDir = { snakeHead[0] + newX, snakeHead[1] + newY };

		snake.move(newDir);
	}

}
