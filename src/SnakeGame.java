import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Snake;
import panels.BackgroundPanel;
import panels.SnakePanel;
import services.GameService;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class SnakeGame extends JFrame {

	private final int MAX_SIZE = 600;
	private final int QUANTITY = 40;
	private Snake snake;
	private JPanel contentPane;
	private BackgroundPanel bgPanel;
	private SnakePanel snakePanel;
	private JButton btnMove;
	private GameService gameService;

	public SnakeGame() {
		initComponents();

		btnMove = new JButton("Move");
		btnMove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameService.move(snake);
				snakePanel.repaint();
			}
		});

		btnMove.setBounds(53, 21, 89, 23);
		snakePanel.add(btnMove);
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
	 * Create the frame and initialize the attributes
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, MAX_SIZE + 25, MAX_SIZE + 48);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		this.gameService = new GameService();
		this.snake = new Snake(Color.GREEN, Color.RED);
		this.snakePanel = new SnakePanel(MAX_SIZE, QUANTITY, snake);
		getContentPane().add(snakePanel);
		snakePanel.setBounds(5, 5, MAX_SIZE, MAX_SIZE);
		snakePanel.setOpaque(false);
		snakePanel.setLayout(null);

		this.bgPanel = new BackgroundPanel(MAX_SIZE, QUANTITY);
		getContentPane().add(bgPanel);
		bgPanel.setBounds(5, 5, MAX_SIZE + 25, MAX_SIZE + 48);
		bgPanel.setLayout(null);
	}
}
