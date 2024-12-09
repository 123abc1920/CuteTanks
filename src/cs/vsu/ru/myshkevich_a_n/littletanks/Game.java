package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.Scanner;

public class Game {
	private World world;
	private Level lvl;
	private int score = 0;
	private int steps = 0;
	private Scanner s = new Scanner(System.in);

	public Game() {
		createNewGame(0);
	}

	private void createNewGame(int score) {
		String str = s.nextLine();
		while (!"12345".contains(str)) {
			str = s.nextLine();
		}
		this.lvl = new Level(str);
		this.world = new World(lvl);
		this.score = score;
		this.steps = 0;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLifes() {
		/*
		 * int[] lifes = new int[players.size()]; for (Tank p : players) {
		 * lifes[players.indexOf(p)] = p.getLife(); } return
		 * Arrays.toString(lifes).replace("[", "").replace("]", "");
		 */
		return "";
	}

	public void gameStep() {
		Drawing.printInfo(this);
		Drawing.draw(this);

		if ((this.steps + 1) % 5 == 0) {
			world.spawnEnemy(true);
			this.steps = 0;
		}

		GameStatus status = world.gameStep();

		if (status == GameStatus.LOSE) {
			Drawing.printInfo(this);
			Drawing.draw(this);
			Drawing.printWin(false);
			this.createNewGame(0);
		}

		if (status == GameStatus.WIN) {
			this.score += 50;
			Drawing.printInfo(this);
			Drawing.draw(this);
			Drawing.printWin(true);
			this.createNewGame(this.score);
		}

		this.steps++;
		this.gameStep();
	}
}
