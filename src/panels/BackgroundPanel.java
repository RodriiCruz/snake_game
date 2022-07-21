package panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class BackgroundPanel extends JPanel {

	private Color backgroundColor;
	private Integer maxSize;
	private Integer size;
	private Integer quantity;

	public BackgroundPanel(Integer maxSize, Integer quantity) {
		this.backgroundColor = Color.gray;
		this.maxSize = maxSize;
		this.quantity = quantity;
		this.size = maxSize / quantity;
	}

	@Override
	public void paint(Graphics pinter) {
		super.paint(pinter);
		pinter.setColor(backgroundColor);

		for (int i = 0; i < quantity; i++) {
			for (int j = 0; j < quantity; j++) {
				pinter.fillRect(j * size, j * size, size - 1, size - 1);
			}
		}
	}

}
