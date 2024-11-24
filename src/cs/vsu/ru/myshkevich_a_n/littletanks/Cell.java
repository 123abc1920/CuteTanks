package cs.vsu.ru.myshkevich_a_n.littletanks;

public abstract class Cell {
	private int row, col;
	private char symbol;
	private Tank tank = null;
	private boolean isAvailable = true;

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
		if (this.tank != null) {
			return this.tank.getSymbol();
		}
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public void setRowCol(int row, int col) {
		this.col = col;
		this.row = row;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}

	public Tank getTank() {
		return tank;
	}

	public void setAvailable(boolean a) {
		this.isAvailable = a;
	}

	public boolean getAvailable() {
		if (this.tank != null) {
			return false;
		}
		return isAvailable;
	}
}
