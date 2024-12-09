package cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Cell;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Empty;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Flag;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Spawner;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Tree;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Wall;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Water;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Core;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Enemy;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Player;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class World {
	private List<Enemy> enemies = new ArrayList<>();
	private List<Core> cores = new ArrayList<>();
	private List<Cell> cells = new ArrayList<>();
	private List<Player> players = new ArrayList<>();

	private Flag flag;
	private Spawner spawner;

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
						flag = new Flag(i, j);
						cells.add(flag);
					} else if (c == 'X') {
						spawner = new Spawner(i, j);
						cells.add(spawner);
					} else if (c == '@') {
						cells.add(new Tree(i, j));
					} else if (c == '~') {
						cells.add(new Water(i, j));
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
		Core core = new Core(tank.getRow(), tank.getCol(), tank.getTarget(), tank.isEnemy());
		if (core.getRow() >= 0 && core.getRow() <= Global.size - 1 && core.getCol() >= 0
				&& core.getCol() <= Global.size - 1) {
			cores.add(core);
		}
	}

	public GameStatus gameStep() {
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

		Iterator<Core> iteratorC = cores.iterator();
		while (iteratorC.hasNext()) {
			Core c = (Core) iteratorC.next();
			if (!c.getAvailable()) {
				iteratorC.remove();
			}
		}

		if (players.size() == 0 || flag.getLifes() == 0) {
			return GameStatus.LOSE;
		}

		if (spawner.getLifes() == 0) {
			return GameStatus.WIN;
		}

		return GameStatus.NOTHING;
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
		for (Core c : cores) {
			int newRow = c.getRow() + c.getTarget().changeRowsCols()[0];
			int newCol = c.getCol() + c.getTarget().changeRowsCols()[1];
			if (newRow < 0 || newRow >= Global.size || newCol < 0 || newCol >= Global.size) {
				c.setNotAvailable();
			}
			if (c.getAvailable()) {
				c.setRow(newRow);
				c.setCol(newCol);
				if (getCells(board[c.getRow()][c.getCol()]).setDestroy(c.getFromEnemy())) {
					c.setNotAvailable();
				} else {
					for (Tank t : enemies) {
						if (t.getCol() == c.getCol() && t.getRow() == c.getRow()) {
							t.setDestroy(c.getFromEnemy());
						}
					}
					for (Tank t : players) {
						if (t.getCol() == c.getCol() && t.getRow() == c.getRow()) {
							t.setDestroy(c.getFromEnemy());
						}
					}
				}
			}
		}
	}

	public Cell getCells(int index) {
		if (index != -1) {
			return this.cells.get(index);
		}
		return new Empty();
	}

	private void move(char c, Tank tank) {
		tank.setTarget(Target.values()[Global.TARGETS.indexOf(c)]);

		int newRow = Math.max(0, Math.min(tank.getRow() + tank.getTarget().changeRowsCols()[0], Global.size - 1));
		int newCol = Math.max(0, Math.min(tank.getCol() + tank.getTarget().changeRowsCols()[1], Global.size - 1));

		if (getCellAvailable(board[newRow][newCol]) && !getCellHasTank(newRow, newCol)
				&& !getCellHasCore(newRow, newCol)) {
			tank.setRow(newRow);
			tank.setCol(newCol);
		}

		addCore(tank);
	}

	private boolean getCellHasCore(int row, int col) {
		return cores.stream().anyMatch(e -> e.getCol() == col && e.getRow() == row);
	}

	private boolean getCellHasTank(int row, int col) {
		return Stream.concat(enemies.stream(), players.stream()).anyMatch(e -> e.getCol() == col && e.getRow() == row);
	}

	private boolean getCellAvailable(int index) {
		if (index != -1) {
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
