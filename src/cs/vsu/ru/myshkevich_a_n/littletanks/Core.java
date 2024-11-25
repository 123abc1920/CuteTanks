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
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
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
