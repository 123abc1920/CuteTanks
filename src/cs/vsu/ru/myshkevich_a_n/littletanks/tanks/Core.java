package cs.vsu.ru.myshkevich_a_n.littletanks.tanks;

import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Core {
	private int row, col;
	private Target target;
	private boolean isAvailable = true;
	private boolean fromEnemy = false;

	public Core(int row, int col, Target target, boolean fromEnemy) {
		this.target = target;
		this.row = row;
		this.col = col;
		this.isAvailable = true;
		this.fromEnemy = fromEnemy;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public char getSymbol() {
		if (this.fromEnemy) {
			return Global.coreEnemySymbol;
		}
		return Global.corePlayerSymbol;
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

	public void setFromEnemy(boolean fromEnemy) {
		this.fromEnemy = fromEnemy;
	}

	public boolean getFromEnemy() {
		return this.fromEnemy;
	}
}