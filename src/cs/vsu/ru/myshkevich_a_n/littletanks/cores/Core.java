package cs.vsu.ru.myshkevich_a_n.littletanks.cores;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;
import cs.vsu.ru.myshkevich_a_n.littletanks.tanks.Target;

public class Core {
	private int row, col;
	private Target target;
	private boolean isAvailable = true;
	private boolean fromEnemy = false;
	private int velocity = 1;

	public Core(int row, int col, Target target, boolean fromEnemy, int velocity) {
		this.target = target;
		this.row = row;
		this.col = col;
		this.isAvailable = true;
		this.fromEnemy = fromEnemy;
		this.velocity = velocity;
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

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
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

	public Symbol drawSymbol() {
		if (this.fromEnemy) {
			return new Symbol("XXXX");
		}
		return new Symbol("OOOO");
	}
}
