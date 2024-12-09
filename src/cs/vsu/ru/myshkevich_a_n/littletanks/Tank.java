package cs.vsu.ru.myshkevich_a_n.littletanks;

public abstract class Tank {
	private char symbolUp;
	private char symbolLeft;
	private char symbolRight;
	private char symbolDown;

	private int row, col;
	private int lifes = 1;

	protected Target target;

	public boolean isKilled = false;

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
		if (col > Global.size - 1 || col < 0) {
			return;
		}
		this.col = col;
	}

	public void setRow(int row) {
		if (row > Global.size - 1 || row < 0) {
			return;
		}
		this.row = row;
	}

	public int getLife() {
		return this.lifes;
	}

	public void setLife(int life) {
		this.lifes = life;
	}

	public boolean getKilled() {
		return isKilled;
	}

	public boolean setDestroy(boolean getFromEnemy) {
		return true;
	}

	public abstract boolean isEnemy();

}
