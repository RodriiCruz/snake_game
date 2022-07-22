package panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import models.Snake;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class SnakePanel extends JPanel {

	private Snake snake;
	private Integer maxSize;
	private Integer size;
	private Integer quantity;

	public SnakePanel(Integer maxSize, Integer quantity) {
		this.snake = new Snake(Color.GREEN, Color.RED);
		this.maxSize = maxSize;
		this.quantity = quantity;
		this.size = maxSize / quantity;
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
			pinter.fillRect(part[0] * size, part[1] * size, size - 1, size - 1);
		}
	}

}
