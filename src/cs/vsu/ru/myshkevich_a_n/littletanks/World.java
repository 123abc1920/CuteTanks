package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class World {
	private Cell[][] board = new Cell[13][13];

	public World(Level lvl) {
		CellFabric cellFabric = new CellFabric();

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				this.board[i][j] = cellFabric.getCell(lvl.getCell(i, j));
				this.board[i][j].setRowCol(i, j);
			}
		}
	}

	public Cell getCell(int row, int col) {
		return board[row][col];
	}

	public void setCell(int row, int col, Cell cell) {
		this.board[row][col] = cell;
	}

	public Tank spawnEnemy(boolean isEnemy) {
		if (isEnemy) {
			Enemy enemy = new Enemy(0, 6, Target.BOTTOM);
			this.board[0][6].setTank(enemy);
			return enemy;
		}
		Player player = new Player(12, 6, Target.TOP);
		this.board[12][6].setTank(player);
		return player;
	}

}
