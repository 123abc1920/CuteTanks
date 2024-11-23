package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private World world;
	private Level lvl;
	private int score;
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
			char d = s.nextLine().charAt(0);
			if (d == 'q') {
				System.exit(0);
			}
			world.getCell(p.getRow(), p.getCol()).setTank(null);
			p.move(d);
			world.getCell(p.getRow(), p.getCol()).setTank(p);
		}
		/*for (Tank e : enemies) {
			world.getCell(e.getRow(), e.getCol()).setTank(null);
			e.move('a');
			world.getCell(e.getRow(), e.getCol()).setTank(e);
		}*/
	}
}
