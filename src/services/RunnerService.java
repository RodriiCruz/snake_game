package services;

import panels.GamePanel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class RunnerService implements Runnable {

	private Integer timeToSleep;
	private Integer lvl;
	private GameService gameService;
	private GamePanel snakePanel;

	public RunnerService(GameService gameService, GamePanel snakePanel) {
		this.timeToSleep = 200;
		this.lvl = 1;
		this.gameService = gameService;
		this.snakePanel = snakePanel;
	}

	@Override
	public void run() {
		while (Boolean.TRUE) {
			if (gameService.getScore() % 5 == 0 && timeToSleep > 20) {
				if (gameService.getScore() / 5 == lvl) {
					this.timeToSleep -= 30;
					lvl++;
				}
			}

			gameService.move();
			snakePanel.repaint();
			try {
				Thread.sleep(timeToSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
