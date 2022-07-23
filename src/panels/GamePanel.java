package panels;

import static utils.Constants.ARIAL_FONT;
import static utils.Constants.LEVEL;
import static utils.Constants.SCORE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import models.Food;
import models.Snake;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class GamePanel extends JPanel {

	private Snake snake;
	private Food food;
	private Integer unitSize;
	private Integer margin;

	public GamePanel(Integer maxSize, Integer quantity, Snake snake, Food food) {
		this.snake = snake;
		this.food = food;
		this.unitSize = maxSize / quantity;
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
			pinter.fillRect(margin + part[0] * unitSize, margin + part[1] * unitSize, unitSize - 1, unitSize - 1);
		}

		pinter.setColor(food.getFoodColor());
		pinter.fillRect(food.getPosition()[0] * unitSize, margin + food.getPosition()[1] * unitSize, unitSize - 1,
				unitSize - 1);

		pinter.setColor(Color.WHITE);
		pinter.setFont(new Font(ARIAL_FONT, Font.BOLD, 20));
		pinter.drawString(SCORE + snake.getBody().size() + LEVEL + (snake.getBody().size() / 5 + 1), 15, 25);
	}
}
