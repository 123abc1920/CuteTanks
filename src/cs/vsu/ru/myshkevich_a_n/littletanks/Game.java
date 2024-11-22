package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Game {
	private World world;

	public Game() {
		world = new World();
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
