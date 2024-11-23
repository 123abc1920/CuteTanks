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

	public Game() {
		Scanner s = new Scanner(System.in);
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
}
