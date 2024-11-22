package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class World {
	private Cell[][] board = new Cell[13][13];
	private List<Enemy> enemies = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	private List<Water> waters = new ArrayList<>();
	private List<Tree> trees = new ArrayList<>();
	private List<Wall> walls = new ArrayList<>();

	private Level lvl;

	public World() {
		CellFabric cellFabric = new CellFabric();

		Scanner s = new Scanner(System.in);
		lvl = new Level(s.nextLine());

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
}
