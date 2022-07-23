import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Food;
import models.Snake;
import panels.BackgroundPanel;
import panels.GamePanel;
import services.GameService;
import services.RunnerService;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class SnakeGame extends JFrame {

	private final int WINDOW_SIZE = 600;
	private final int QUANTITY = 30; // Cantidad de posiciones en una dirección
	private Snake snake;
	private Food food;
	private JPanel contentPane;
	private BackgroundPanel bgPanel;
	private GamePanel snakePanel;
	private GameService gameService;
	private RunnerService runnerService;
	private Thread thread;

	public SnakeGame() {
		initComponents();
		gameService.generateFood();
		runThread();

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				gameService.changeDirection(e);
			}
		});
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
		setBounds(100, 100, WINDOW_SIZE + 25, WINDOW_SIZE + 48);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		this.snake = new Snake(Color.GREEN);
		this.food = new Food(Color.RED);
		this.gameService = new GameService(QUANTITY, snake, food);
		this.snakePanel = new GamePanel(WINDOW_SIZE, QUANTITY, snake, food);
		getContentPane().add(snakePanel);
		snakePanel.setBounds(5, 5, WINDOW_SIZE, WINDOW_SIZE);
		snakePanel.setOpaque(false);
		snakePanel.setLayout(null);

		this.bgPanel = new BackgroundPanel(WINDOW_SIZE, QUANTITY);
		getContentPane().add(bgPanel);
		bgPanel.setBounds(5, 5, WINDOW_SIZE + 25, WINDOW_SIZE + 48);
		bgPanel.setLayout(null);
	}

	public void runThread() {
		this.runnerService = new RunnerService(gameService, snakePanel);
		this.thread = new Thread(runnerService);
		thread.start();
	}
}
