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
	private Spawner spawner;
	private Flag flag;
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
		this.enemies.clear();
		this.players.clear();
		this.enemies.add(world.spawnEnemy(true));
		this.players.add(world.spawnEnemy(false));
		this.score = score;
		this.flag = (Flag) world.getCell(12, 6);
		this.spawner = (Spawner) world.getCell(0, 6);
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
		Drawing.printInfo(this);
		Drawing.draw(this);
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
			Drawing.draw(this);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			Iterator<Core> iterator = cores.iterator();
			while (iterator.hasNext()) {
				Core core = iterator.next();
				if (core.getAvailable()) {
					if (core.getRow() >= 0 && core.getRow() <= 12 && core.getCol() >= 0 && core.getCol() <= 12) {
						shot(core);
					} else {
						core.setNotAvailable();
					}
				}
				if (!core.getAvailable()) {
					if (core.getRow() >= 0 && core.getRow() <= 12 && core.getCol() >= 0 && core.getCol() <= 12) {
						this.world.getCell(core.getRow(), core.getCol()).setCore(null);
					}
					iterator.remove();
				}
			}
		}

		cores.clear();

		Iterator<Tank> iteratorP = players.iterator();
		while (iteratorP.hasNext()) {
			Player p = (Player) iteratorP.next();
			if (p.getKilled()) {
				iteratorP.remove();
			}
		}

		Iterator<Tank> iteratorE = enemies.iterator();
		while (iteratorE.hasNext()) {
			Enemy p = (Enemy) iteratorE.next();
			if (p.getKilled()) {
				iteratorE.remove();
				this.score += 10;
			}
		}

		if (players.size() == 0 || flag.getLifes() == 0) {
			Drawing.printWin(false);
			this.createNewGame(0);
		}

		if (spawner.getLifes() == 0) {
			this.score += 50;
			Drawing.printWin(true);
			this.createNewGame(this.score);
		}

		this.gameStep();
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

		int row = tank.getRow() + tank.getTarget().changeRowsCols()[0];
		int col = tank.getCol() + tank.getTarget().changeRowsCols()[1];
		Core core = new Core(row, col, tank.target);
		if (core.getRow() >= 0 && core.getRow() <= 12 && core.getCol() >= 0 && core.getCol() <= 12) {
			cores.add(core);
			this.world.getCell(row, col).setCore(core);
		}
	};

	private void shot(Core core) {
		this.world.getCell(core.getRow(), core.getCol()).setCore(null);
		this.world.setCell(core.getRow(), core.getCol(),
				this.world.getCell(core.getRow(), core.getCol()).setDestroy(core));
		core.setRow(core.getRow() + core.getTarget().changeRowsCols()[0]);
		core.setCol(core.getCol() + core.getTarget().changeRowsCols()[1]);
		if (core.getRow() >= 0 && core.getRow() <= 12 && core.getCol() >= 0 && core.getCol() <= 12) {
			this.world.getCell(core.getRow(), core.getCol()).setCore(core);
		} else {
			core.setNotAvailable();
			return;
		}
	}
}
