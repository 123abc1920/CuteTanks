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
	private List<Tank> players = new ArrayList<>();
	private List<Tank> enemies = new ArrayList<>();
	private List<Core> cores = new ArrayList<>();
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLifes() {
		int[] lifes = new int[players.size()];
		for (Tank p : players) {
			lifes[players.indexOf(p)] = p.getLife();
		}
		return Arrays.toString(lifes).replace("[", "").replace("]", "");
	}

	public void gameStep() {
		char d = '0';
		for (Tank p : players) {
			while (!Global.TARGETS.contains(d) && d != 'q') {
				String string = s.nextLine();
				if (!string.isEmpty()) {
					d = string.charAt(0);
				}
			}
			if (d == 'q') {
				System.exit(0);
			}
			move(d, p);
		}
		Random rnd = new Random();
		for (Tank e : enemies) {
			d = Global.TARGETS.get(rnd.nextInt(Global.TARGETS.size()));
			move(d, e);
		}

		while (cores.size() > 0) {
			Iterator<Core> iterator = cores.iterator();
			while (iterator.hasNext()) {
				Core core = iterator.next();
				if (core.getAvailable()) {
					shot(core);
				}
				if (!core.getAvailable()) {
					iterator.remove();
				}
			}
		}

		cores.clear();
	}

	private void move(char c, Tank tank) {
		world.getCell(tank.getRow(), tank.getCol()).setTank(null);
		tank.setTarget(Target.values()[Global.TARGETS.indexOf(c)]);

		int newRow = Math.max(0, Math.min(tank.getRow() + tank.getTarget().changeRowsCols()[0], 12));
		int newCol = Math.max(0, Math.min(tank.getCol() + tank.getTarget().changeRowsCols()[1], 12));
		if (world.getCell(newRow, newCol).getAvailable()) {
			tank.setRow(newRow);
			tank.setCol(newCol);
		}
		world.getCell(tank.getRow(), tank.getCol()).setTank(tank);

		int col = Math.max(0, Math.min(tank.getCol() + tank.getTarget().changeRowsCols()[1], 12));
		int row = Math.max(0, Math.min(tank.getRow() + tank.getTarget().changeRowsCols()[0], 12));
		Core core = new Core(row, col, tank.target);
		cores.add(core);
		this.world.getCell(row, col).setCore(core);
	};

	private void shot(Core core) {
		if (core.getRow() >= 0 && core.getRow() <= 12 && core.getCol() >= 0 && core.getCol() <= 12) {
			if (this.world.getCell(core.getRow(), core.getCol()).setDestroy(core)) {
				core.setCol(core.getCol() + core.getTarget().changeRowsCols()[1]);
				core.setRow(core.getRow() + core.getTarget().changeRowsCols()[0]);
				if (core.getRow() >= 0 && core.getRow() <= 12 && core.getCol() >= 0 && core.getCol() <= 12) {
					this.world.getCell(core.getRow(), core.getCol()).setCore(core);
				} else {
					core.setNotAvailable();
					return;
				}
			} else {
				if (this.world.getCell(core.getRow(), core.getCol()).getLifes() == 0) {
					Empty e = new Empty();
					e.setCol(core.getCol());
					e.setRow(core.getRow());
					this.world.setCell(core.getRow(), core.getCol(), e);
				}
			}
		} else {
			core.setNotAvailable();
			this.world.getCell(core.getRow(), core.getCol()).setCore(null);
			return;
		}
	}
}
