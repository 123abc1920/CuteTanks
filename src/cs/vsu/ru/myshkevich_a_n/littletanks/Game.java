package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private World world;
	private Level lvl;
	// private int score = 0;
	private List<Tank> players = new ArrayList<>();
	private List<Tank> enemies = new ArrayList<>();
	private Scanner s = new Scanner(System.in);

	public Game() {
		lvl = new Level(s.nextLine());
		world = new World(lvl);
		enemies.add(world.spawnEnemy(true));
		players.add(world.spawnEnemy(false));
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public void move() {
		for (Tank p : players) {
			char d = '0';
			while (!Global.TARGETS.contains(d) && d != 'q') {
				d = s.nextLine().charAt(0);
			}
			if (d == 'q') {
				System.exit(0);
			}
			world.getCell(p.getRow(), p.getCol()).setTank(null);
			int[] newCoords = p.move(d);
			if (world.getCell(newCoords[0], newCoords[1]).getAvailable()) {
				p.setRow(newCoords[0]);
				p.setCol(newCoords[1]);
			}
			world.getCell(p.getRow(), p.getCol()).setTank(p);
		}
		Random rnd = new Random();
		for (Tank e : enemies) {
			world.getCell(e.getRow(), e.getCol()).setTank(null);
			char c = Global.TARGETS.get(rnd.nextInt(Global.TARGETS.size()));
			int[] newCoords = e.move(c);
			if (world.getCell(newCoords[0], newCoords[1]).getAvailable()) {
				e.setRow(newCoords[0]);
				e.setCol(newCoords[1]);
			}
			world.getCell(e.getRow(), e.getCol()).setTank(e);
		}
	}
}
