import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.BackgroundPanel;
import panels.SnakePanel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class SnakeGame extends JFrame {

	private final int MAX_SIZE = 600;
	private final int QUANTITY = 30;
	private JPanel contentPane;
	private BackgroundPanel bgPanel;
	private SnakePanel snakePanel;

	public SnakeGame() {
		initComponents();
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);

		this.snakePanel = new SnakePanel(MAX_SIZE, QUANTITY);
		getContentPane().add(snakePanel);
		snakePanel.setBounds(5, 5, 601, 599);
		snakePanel.setOpaque(false);
		snakePanel.setLayout(null);

		this.bgPanel = new BackgroundPanel(MAX_SIZE, QUANTITY);
		getContentPane().add(bgPanel);
		bgPanel.setBounds(5, 5, 601, 599);
		bgPanel.setLayout(null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeGame frame = new SnakeGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 648);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setResizable(false);
	}

}
