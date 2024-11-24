package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private World world;
	private Level lvl;
	private int score = 0;
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

		shot(tank.getRow(), tank.getCol(), tank.getTarget());
	};

	private void shot(int row, int col, Target target) {
		row += target.changeRowsCols()[0];
		col += row + target.changeRowsCols()[1];
		while (row >= 0 && row <= 12 && col >= 0 && col <= 12) {
			if (!world.getCell(row, col).getAvailable()) {
				if (world.getCell(row, col).setDestroy()) {
					Cell c = world.getCell(row, col);
					c.setCol(col);
					c.setRow(row);
					if (c.getTank() != null) {
						if (c.getTank().isEnemy()) {
							enemies.remove(c.getTank());
						} else {
							players.remove(c.getTank());
						}
					}
					world.setCell(row, col, c);
				}
				if (players.size() == 0) {
					System.out.println("You lose");
					System.exit(0);
				}
				if (enemies.size() == 0) {
					System.out.println("You win");
					System.exit(0);
				}
				return;
			}
			row += target.changeRowsCols()[0];
			col += target.changeRowsCols()[1];
		}
	}
}
