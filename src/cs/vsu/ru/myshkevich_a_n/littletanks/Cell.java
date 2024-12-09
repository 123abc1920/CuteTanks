package cs.vsu.ru.myshkevich_a_n.littletanks;

public abstract class Cell {
	private int row, col;
	private char symbol;
	private boolean isAvailable = true;
	private int lifes = 1;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public void setRowCol(int row, int col) {
		this.col = col;
		this.row = row;
	}

	public void setAvailable(boolean a) {
		this.isAvailable = a;
	}

	public boolean getAvailable() {
		return isAvailable;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public boolean setDestroy(boolean getFromEnemy) {
		return false;
	}
}
