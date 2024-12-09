package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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

		world.gameStep();

		if (this.steps % 5 == 0) {
			world.spawnEnemy(true);
			this.steps = 0;
		}

		this.steps++;
		this.gameStep();
	}
}
