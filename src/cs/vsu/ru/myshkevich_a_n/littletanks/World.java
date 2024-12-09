package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class World {
	private List<Enemy> enemies = new ArrayList<>();
	private List<Core> cores = new ArrayList<>();
	private List<Cell> cells = new ArrayList<>();
	private List<Player> players = new ArrayList<>();

	private int[][] board = new int[Global.size][Global.size];

	private Scanner s = new Scanner(System.in);

	public World(Level lvl) {
		players.add(new Player(Global.size - 1, (Global.size - 1) / 2, Target.TOP));
		enemies.add(new Enemy(0, (Global.size - 1) / 2, Target.BOTTOM));
		int index = 0;
		for (int i = 0; i < Global.size; i++) {
			for (int j = 0; j < Global.size; j++) {
				char c = lvl.getCell(i, j);
				if (c != '.') {
					if (c == '#') {
						cells.add(new Wall(i, j));
					} else if (c == '$') {
						cells.add(new Flag(i, j));
					} else if (c == 'X') {
						cells.add(new Spawner(i, j));
					} else if (c == '@') {
						cells.add(new Tree(i, j));
					}
					board[i][j] = index;
					index++;
				} else {
					board[i][j] = -1;
				}
			}
		}
	}

	public char drawCell(int row, int col) {
		Tank t = this.getTank(row, col);
		if (t != null) {
			return t.getSymbol();
		}
		Core core = this.getCore(row, col);
		if (core != null) {
			return core.getSymbol();
		}
		return this.getCell(row, col).getSymbol();
	}

	public Cell getCell(int row, int col) {
		for (Cell c : cells) {
			if (c.getRow() == row && c.getCol() == col) {
				return c;
			}
		}
		return new Empty(row, col);
	}

	public Tank getTank(int row, int col) {
		for (Tank t : enemies) {
			if (t.getRow() == row && t.getCol() == col) {
				return t;
			}
		}
		for (Tank t : players) {
			if (t.getRow() == row && t.getCol() == col) {
				return t;
			}
		}
		return null;
	}

	public Core getCore(int row, int col) {
		for (Core c : cores) {
			if (c.getRow() == row && c.getCol() == col) {
				return c;
			}
		}
		return null;
	}

	public void addCore(Tank tank) {
		Core core = new Core(tank.getRow() + tank.getTarget().changeRowsCols()[0],
				tank.getCol() + tank.getTarget().changeRowsCols()[1], tank.target, tank.isEnemy());
		if (core.getRow() >= 0 && core.getRow() <= Global.size - 1 && core.getCol() >= 0
				&& core.getCol() <= Global.size - 1) {
			cores.add(core);
		}
	}

	public void gameStep() {
		playersMove();
		enemiesMove();
		coresMove();

		Iterator<Player> iteratorP = players.iterator();
		while (iteratorP.hasNext()) {
			Player p = (Player) iteratorP.next();
			if (p.getKilled()) {
				iteratorP.remove();
			}
		}

		Iterator<Enemy> iteratorE = enemies.iterator();
		while (iteratorE.hasNext()) {
			Enemy p = (Enemy) iteratorE.next();
			if (p.getKilled()) {
				iteratorE.remove();
			}
		}

		/*
		 * if (players.size() == 0 || flag.getLifes() == 0) { Drawing.printInfo(this);
		 * Drawing.draw(this); Drawing.printWin(false); this.createNewGame(0); }
		 * 
		 * if (spawner.getLifes() == 0) { this.score += 50; Drawing.printInfo(this);
		 * Drawing.draw(this); Drawing.printWin(true); this.createNewGame(this.score); }
		 */
	}

	private void playersMove() {
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
	}

	private void enemiesMove() {
		char d = '0';

		Random rnd = new Random();
		for (Tank e : enemies) {
			d = Global.TARGETS.get(rnd.nextInt(Global.TARGETS.size()));
			move(d, e);
		}
	}

	private void coresMove() {
		/*
		 * while (cores.size() > 0) { Iterator<Core> iterator = cores.iterator(); while
		 * (iterator.hasNext()) { Core core = iterator.next(); if (core.getAvailable())
		 * { if (core.getRow() >= 0 && core.getRow() <= Global.size - 1 && core.getCol()
		 * >= 0 && core.getCol() <= Global.size - 1) { shot(core); } else {
		 * core.setNotAvailable(); } } if (!core.getAvailable()) { if (core.getRow() >=
		 * 0 && core.getRow() <= Global.size - 1 && core.getCol() >= 0 && core.getCol()
		 * <= Global.size - 1) { this.world.getCell(core.getRow(),
		 * core.getCol()).setCore(null); } iterator.remove(); } } }
		 */
	}

	private void shot(Core core) {
		/*
		 * this.world.getCell(core.getRow(), core.getCol()).setCore(null);
		 * core.setRow(core.getRow() + core.getTarget().changeRowsCols()[0]);
		 * core.setCol(core.getCol() + core.getTarget().changeRowsCols()[1]); if
		 * (core.getRow() >= 0 && core.getRow() <= Global.size - 1 && core.getCol() >= 0
		 * && core.getCol() <= Global.size - 1) { this.world.getCell(core.getRow(),
		 * core.getCol()).setCore(core); } else { core.setNotAvailable(); return; }
		 */
	}

	private void move(char c, Tank tank) {
		tank.setTarget(Target.values()[Global.TARGETS.indexOf(c)]);

		int newRow = Math.max(0, Math.min(tank.getRow() + tank.getTarget().changeRowsCols()[0], Global.size - 1));
		int newCol = Math.max(0, Math.min(tank.getCol() + tank.getTarget().changeRowsCols()[1], Global.size - 1));

		if (getCellAvailable(board[newRow][newCol])) {
			tank.setRow(newRow);
			tank.setCol(newCol);
		}

		// addCore(tank);
	}

	public boolean getCellAvailable(int index) {
		if (index < cells.size() && index >= 0) {
			return this.cells.get(index).getAvailable();
		}
		return true;
	}

	public void spawnEnemy(boolean isEnemy) {
		if (isEnemy) {
			Enemy enemy = new Enemy(0, (Global.size - 1) / 2, Target.BOTTOM);
			this.enemies.add(enemy);
			return;
		}
		Player player = new Player(Global.size - 1, (Global.size - 1) / 2, Target.TOP);
		this.players.add(player);
	}

}
