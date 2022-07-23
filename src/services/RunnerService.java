package services;

import panels.SnakePanel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class RunnerService implements Runnable {

	private final Integer TIME_TO_SLEEP = 200;
	private GameService gameService;
	private SnakePanel snakePanel;

	public RunnerService(GameService gameService, SnakePanel snakePanel) {
		this.gameService = gameService;
		this.snakePanel = snakePanel;
	}

	@Override
	public void run() {
		while (Boolean.TRUE) {
			gameService.move();
			snakePanel.repaint();
			try {
				Thread.sleep(TIME_TO_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
