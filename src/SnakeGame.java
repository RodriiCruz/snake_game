import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panels.BackgroundPanel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class SnakeGame extends JFrame {

	private final int MAX_SIZE = 800;
	private final int QUANTITY = 30;
	private JPanel contentPane;
	private BackgroundPanel bgPanel;

	public SnakeGame() {
		initComponents();
		this.bgPanel = new BackgroundPanel(MAX_SIZE, QUANTITY);

		this.add(bgPanel);
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
