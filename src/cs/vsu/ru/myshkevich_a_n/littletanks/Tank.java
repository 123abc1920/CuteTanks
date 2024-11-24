package cs.vsu.ru.myshkevich_a_n.littletanks;

public abstract class Tank {
	private char symbolUp;
	private char symbolLeft;
	private char symbolRight;
	private char symbolDown;

	private int row, col;
	private int lifes;

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
		if (this.target == Target.TOP) {
			return this.getSymbolUp();
		}
		if (this.target == Target.BOTTOM) {
			return this.getSymbolDown();
		}
		if (this.target == Target.RIGHT) {
			return this.getSymbolLeft();
		}
		if (this.target == Target.LEFT) {
			return this.getSymbolRight();
		}
		return 'u';
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public void setCol(int col) {
		if (col > 12 || col < 0) {
			return;
		}
		this.col = col;
	}

	public void setRow(int row) {
		if (row > 12 || row < 0) {
			return;
		}
		this.row = row;
	}

	public int getLifes() {
		return lifes;
	}

	public boolean setLifes(int lifes) {
		this.lifes = lifes;
		if (this.lifes == 0) {
			return false;
		}
		return true;
	}
}
