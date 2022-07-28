package utils;

import static utils.Constants.GAME_OVER;
import static utils.Constants.PLAY_AGAIN;

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

	public boolean checkCollisions(Integer[] position) {
		boolean keepPlaying = false;
		for (Integer[] aux : snake.getBody()) {
			if (aux[0] == position[0] && aux[1] == position[1]) {
				Integer option = JOptionPane.showInternalConfirmDialog(null, PLAY_AGAIN, GAME_OVER, 2,
						JOptionPane.PLAIN_MESSAGE, null);

				keepPlaying = option == 2 ? false : true;
				if (!keepPlaying) {
					System.exit(0);
				}
			}
		}
		return keepPlaying;
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
