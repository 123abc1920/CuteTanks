package cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Scanner;

import cs.vsu.ru.myshkevich_a_n.littletanks.Drawing;
import cs.vsu.ru.myshkevich_a_n.littletanks.MainClass;

public class Game {
	private World world;
	private Level lvl;
	private int score = 0;
	private int steps = 0;

	public Game(int score, int lvl) {
		createNewGame(score, lvl);
	}

	private void createNewGame(int score, int lvl) {
		if (lvl <= 0) {
			lvl = 1;
		}
		int count = countFiles();

		if (lvl > count) {
			lvl = 1;
		}

		this.lvl = new Level(String.valueOf(lvl));
		this.world = new World(this.lvl);
		this.score = score;
		this.steps = 0;
	}

	private int countFiles() {
		/*
		 * File jarFile = null; try { jarFile = new
		 * File(MainClass.class.getProtectionDomain().getCodeSource().getLocation().
		 * toURI()); } catch (URISyntaxException e) { e.printStackTrace(); } File
		 * jarDirectory = jarFile.getParentFile(); File directory = new
		 * File(jarDirectory + "lvls");
		 */
		// для eclipse
		File directory = new File("lvls\\");
		if (directory.list() == null || directory.list().length == 0 || !directory.exists()) {
			System.out.println("Уровни не были добавлены, добавьте в lvls.");
			System.out.println("Нажмите Enter чтобы прервать...");
			new Scanner(System.in).nextLine();
			System.exit(0);
		}
		return directory.list().length;
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
		return world.getLifes();
	}

	public String getArmours() {
		return world.getArmours();
	}

	public String getVelocities() {
		return world.getVelocities();
	}

	public int getLvl() {
		return lvl.getLevel();
	}

	private void printTable(Game game, boolean isWin) {
		Drawing.printInfo(game);
		Drawing.draw(game);
		Drawing.printWin(isWin);
	}

	public GameStatus gameStep() {
		Drawing.printInfo(this);
		Drawing.draw(this);

		if ((this.steps + 1) % 5 == 0) {
			world.spawnEnemy();
			this.steps = 0;
		}

		if (world.playersMove()) {
			return GameStatus.STOP;
		}
		world.enemiesMove();
		world.coresMove();
		this.score += world.deleteStep();
		GameStatus status = world.checkGameStatus();

		if (status == GameStatus.LOSE) {
			printTable(this, false);
			return status;
		}

		if (status == GameStatus.WIN) {
			this.score += 50;
			printTable(this, true);
			return status;
		}

		this.steps++;
		return GameStatus.NOTHING;
	}
}
