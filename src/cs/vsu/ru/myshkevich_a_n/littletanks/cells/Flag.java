package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Flag extends Cell {

	public Flag() {
		this.setSymbol(Global.flagSymbol);
		this.setLifes(1);
	}

	public Flag(int row, int col) {
		this.setCol(col);
		this.setRow(row);
		this.setSymbol(Global.flagSymbol);
		this.setLifes(1);
	}

	@Override
	public boolean setDestroy(boolean getFromEnemy) {
		if (getFromEnemy) {
			this.setLifes(this.getLifes() - 1);
			return true;
		}
		return false;
	}

	@Override
	public Symbol drawSymbol() {
		return new Symbol("$ $", "$ $");
	}

}
