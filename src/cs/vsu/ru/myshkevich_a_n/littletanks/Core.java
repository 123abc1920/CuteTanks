package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Core {
	private int row, col;
	private static final char symbol = Global.coreSymbol;
	private Target target;
	private boolean isAvailable = true;

	public Core(int row, int col, Target target) {
		this.target = target;
		this.row = row;
		this.col = col;
		this.isAvailable = true;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setCol(int col) {
		if (this.isAvailable) {
			this.col = col;
		}
	}

	public void setRow(int row) {
		if (this.isAvailable) {
			this.row = row;
		}
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public boolean getAvailable() {
		return isAvailable;
	}

	public void setNotAvailable() {
		this.isAvailable = false;
	}
}
