package services;

import panels.GamePanel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class RunnerService implements Runnable {

	private Integer pauseTime;
	private GameService gameService;
	private GamePanel gamePanel;

	public RunnerService(GameService gameService, GamePanel gamePanel) {
		this.pauseTime = 200;
		this.gameService = gameService;
		this.gamePanel = gamePanel;
	}

	@Override
	public void run() {
		while (Boolean.TRUE) {
			if (gameService.getScore() < 5 || gameService.getScore() % 5 == 0 && pauseTime > 20) {
				switch (gameService.getScore() / 5) {
				case 0:
					this.pauseTime = 200;
					break;
				case 1:
					this.pauseTime = 170;
					break;
				case 2:
					this.pauseTime = 140;
					break;
				case 3:
					this.pauseTime = 110;
					break;
				case 4:
					this.pauseTime = 80;
					break;
				case 5:
					this.pauseTime = 50;
					break;
				case 6:
					this.pauseTime = 20;
					break;
				}
			}

			gamePanel.repaint();
			gameService.move();
			try {
				Thread.sleep(pauseTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
