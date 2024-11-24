package cs.vsu.ru.myshkevich_a_n.littletanks;

public abstract class Cell {
	private int row, col;
	private char symbol;
	private Tank tank = null;
	private boolean isAvailable = true;
	private Core core = null;
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
		if (this.tank != null) {
			return this.tank.getSymbol();
		}
		if (this.core != null) {
			return Global.coreSymbol;
		}
		return this.symbol;
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

	public void setCore(Core core) {
		this.core = core;
	}

	public Core getCore() {
		return core;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public Cell setDestroy(Core core) {
		this.setCore(null);
		if (this.tank != null) {
			if (this.tank.isEnemy() != core.getFromEnemy()) {
				this.tank = this.tank.setDestroy();
			}
			return this;
		}
		return this;
	}
}
