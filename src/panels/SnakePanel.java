package panels;

import java.awt.Graphics;

import javax.swing.JPanel;

import models.Snake;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class SnakePanel extends JPanel {

	private Snake snake;
	private Integer size;
	private Integer margin;

	public SnakePanel(Integer maxSize, Integer quantity, Snake snake) {
		this.snake = snake;
		this.size = maxSize / quantity;
		this.margin = (maxSize % quantity) / 2;
		Integer[] a = { quantity / 2 - 1, quantity / 2 - 1 };
		Integer[] b = { quantity / 2, quantity / 2 - 1 };

		snake.eatFood(a);
		snake.eatFood(b);
	}

	@Override
	public void paint(Graphics pinter) {
		super.paint(pinter);
		pinter.setColor(snake.getSnakeColor());

		for (Integer[] part : snake.getBody()) {
			pinter.fillRect(margin + part[0] * size, margin + part[1] * size, size - 1, size - 1);
		}
	}

	public Snake getSnake() {
		return snake;
	}
}
