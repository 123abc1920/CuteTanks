package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Tank {
	private char symbolUp;
	private char symbolLeft;
	private char symbolRight;
	private char symbolDown;

	private int row, col;

	protected Target target;

	public Target getTarget() {
		return target;
	}

	public char getSymbolDown() {
		return symbolDown;
	}

	public char getSymbolLeft() {
		return symbolLeft;
	}

	public char getSymbolRight() {
		return symbolRight;
	}

	public char getSymbolUp() {
		return symbolUp;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public void setSymbolDown(char symbolDown) {
		this.symbolDown = symbolDown;
	}

	public void setSymbolLeft(char symbolLeft) {
		this.symbolLeft = symbolLeft;
	}

	public void setSymbolRight(char symbolRight) {
		this.symbolRight = symbolRight;
	}

	public void setSymbolUp(char symbolUp) {
		this.symbolUp = symbolUp;
	}

	public char getSymbol() {
		return 'u';
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
