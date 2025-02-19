package cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.bonuses.Bonus;
import cs.vsu.ru.myshkevich_a_n.littletanks.bonuses.BonusFabric;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Cell;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.CellFabric;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Empty;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Flag;
import cs.vsu.ru.myshkevich_a_n.littletanks.cells.Spawner;
import cs.vsu.ru.myshkevich_a_n.littletanks.cores.Core;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Player;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Tank;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies.Enemy;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.enemies.EnemyFabric;

public class World {
	private List<Enemy> enemies = new ArrayList<>();
	private List<Core> cores = new ArrayList<>();
	private List<Cell> cells = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	private List<Bonus> bonuses = new ArrayList<>();

	private Flag flag;
	private Spawner spawner;

	private int[][] board = new int[Global.size][Global.size];

	private Scanner s = new Scanner(System.in);

	public World(Level lvl) {
		System.out.println("Add players count: \"1\" = 1, \"2\" = 2");
		int p = -1;
		while (p != 1 || p != 2) {
			String str = s.next();
			try {
				p = Integer.parseInt(str);
				if (p == 1 || p == 2) {
					break;
				}
			} catch (Exception e) {
				p = -1;
			}
		}
		if (p == 2) {
			players.add(new Player(Global.size - 1, (Global.size - 1) / 2 - 1, Target.TOP, '1'));
			players.add(new Player(Global.size - 1, (Global.size - 1) / 2 + 1, Target.TOP, '2'));
		} else {
			players.add(new Player(Global.size - 1, (Global.size - 1) / 2, Target.TOP, '\u2295'));
		}
		enemies.add(EnemyFabric.createEnemy(0, (Global.size - 1) / 2));

		int index = 0;
		for (int i = 0; i < Global.size; i++) {
			for (int j = 0; j < Global.size; j++) {
				char c = lvl.getCell(i, j);
				Cell newCell = CellFabric.createCell(c, i, j);
				if (newCell != null) {
					board[i][j] = index;
					index++;
					cells.add(newCell);
				} else {
					board[i][j] = -1;
					Bonus b = BonusFabric.createBonus(c, i, j);
					if (b != null) {
						bonuses.add(b);
					}
				}
			}
		}

		this.flag = (Flag) cells.get(this.board[Global.size - 1][(Global.size - 1) / 2]);
		this.spawner = (Spawner) cells.get(this.board[0][(Global.size - 1) / 2]);
	}

	public Symbol drawCell(int row, int col) {

		Tank t = this.getTank(row, col);
		if (t != null) {
			return t.drawSymbol();
		}
		Core core = this.getCore(row, col);
		if (core != null) {
			return core.drawSymbol();
		}
		Bonus b = this.getBonus(row, col);
		if (b != null) {
			return b.drawSymbol();
		}

		return this.getCell(row, col).drawSymbol();
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
		Core core = new Core(tank.getRow(), tank.getCol(), tank.getTarget(), tank.isEnemy(), tank.getCoreVelocity());
		if (core.getRow() >= 0 && core.getRow() <= Global.size - 1 && core.getCol() >= 0
				&& core.getCol() <= Global.size - 1 && getCore(core.getRow(), core.getCol()) == null) {
			cores.add(core);
		}
	}

	public boolean playersMove() {
		for (Tank p : players) {
			char d = '0';
			while (!Global.TARGETS.contains(d) && d != 'q') {
				String string = s.nextLine();
				if (!string.isEmpty()) {
					d = string.charAt(0);
				}
			}
			if (d == 'q') {
				return true;
			}
			move(d, p);
		}

		return false;
	}

	public void enemiesMove() {
		char d;

		Random rnd = new Random();
		for (Tank e : enemies) {
			d = Global.TARGETS.get(rnd.nextInt(Global.TARGETS.size()));
			move(d, e);
		}
	}

	public void coresMove() {
		for (Core c : cores) {
			for (int i = 0; i < c.getVelocity(); i++) {
				int newRow = c.getRow() + c.getTarget().changeRowsCols()[0];
				int newCol = c.getCol() + c.getTarget().changeRowsCols()[1];
				if (newRow < 0 || newRow >= Global.size || newCol < 0 || newCol >= Global.size) {
					c.setNotAvailable();
				}
				if (c.getAvailable()) {
					c.setRow(newRow);
					c.setCol(newCol);
					if (getCells(board[c.getRow()][c.getCol()]).setDestroy(c)) {
						c.setNotAvailable();
					} else {
						Tank t = getTank(c.getRow(), c.getCol());
						if (t != null) {
							t.setDestroy(c);
						} else {
							Core c2 = getCore(c.getRow(), c.getCol());
							if (c2 != null) {
								if (c2.getFromEnemy() != c.getFromEnemy()) {
									c2.setNotAvailable();
									c.setNotAvailable();
								}
							}
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

	public int deleteStep() {
		int result = 0;

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
				result++;
			}
		}

		Iterator<Core> iteratorC = cores.iterator();
		while (iteratorC.hasNext()) {
			Core c = (Core) iteratorC.next();
			if (!c.getAvailable()) {
				iteratorC.remove();
			}
		}

		return result;
	}

	private void move(char c, Tank tank) {
		tank.setTarget(Target.values()[Global.TARGETS.indexOf(c)]);

		int newRow = Math.max(0, Math.min(tank.getRow() + tank.getTarget().changeRowsCols()[0], Global.size - 1));
		int newCol = Math.max(0, Math.min(tank.getCol() + tank.getTarget().changeRowsCols()[1], Global.size - 1));

		if (getCells(board[newRow][newCol]).getAvailable() && !getCellHasTank(newRow, newCol)) {
			tank.setRow(newRow);
			tank.setCol(newCol);
		}

		Bonus b = getBonus(newRow, newCol);
		if (b != null) {
			b.setEffect(tank);
			bonuses.remove(b);
		}

		addCore(tank);
	}

	private Bonus getBonus(int row, int col) {
		for (Bonus b : bonuses) {
			if (b.getCol() == col && b.getRow() == row) {
				return b;
			}
		}
		return null;
	}

	private boolean getCellHasTank(int row, int col) {
		return Stream.concat(enemies.stream(), players.stream()).anyMatch(e -> e.getCol() == col && e.getRow() == row);
	}

	public void spawnEnemy() {
		Enemy enemy = EnemyFabric.createEnemy(0, (Global.size - 1) / 2);
		this.enemies.add(enemy);
	}

	public String getLifes() {
		int[] lifes = new int[players.size()];
		for (Tank p : players) {
			lifes[players.indexOf(p)] = p.getLife();
		}
		return Arrays.toString(lifes).replace("[", "").replace("]", "");
	}

	public String getArmours() {
		int[] armours = new int[players.size()];
		for (Tank p : players) {
			armours[players.indexOf(p)] = p.getArmor();
		}
		return Arrays.toString(armours).replace("[", "").replace("]", "");
	}

	public String getVelocities() {
		int[] velicities = new int[players.size()];
		for (Tank p : players) {
			velicities[players.indexOf(p)] = p.getCoreVelocity();
		}
		return Arrays.toString(velicities).replace("[", "").replace("]", "");
	}

	public GameStatus checkGameStatus() {
		if (players.size() == 0 || flag.getLifes() == 0) {
			return GameStatus.LOSE;
		}

		if (spawner.getLifes() == 0) {
			return GameStatus.WIN;
		}

		return GameStatus.NOTHING;
	}

}
