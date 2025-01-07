package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Wall extends Cell {
	public Wall() {
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
		this.setLifes(4);
	}

	public Wall(int row, int col) {
		this.setCol(col);
		this.setRow(row);
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
		this.setLifes(4);
	}

	@Override
	public char getSymbol() {
		if (this.getLifes() <= 0) {
			return '.';
		}
		String s = Integer.toString(this.getLifes());
		return s.charAt(0);
	}

	@Override
	public boolean setDestroy(boolean getFromEnemy) {
		if (this.getLifes() <= 0) {
			return false;
		}
		this.setLifes(this.getLifes() - 1);
		return true;
	}

	@Override
	public boolean getAvailable() {
		if (this.getLifes() <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public Symbol drawSymbol() {
		String s = "#";
		return new Symbol(s.repeat(getLifes()));
	}

}
