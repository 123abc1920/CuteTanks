package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class StrongWall extends Cell {

	public StrongWall(int row, int col) {
		this.setCol(col);
		this.setRow(row);
		this.setSymbol(Global.wallSymbol);
		this.setAvailable(false);
	}

	@Override
	public boolean setDestroy(boolean getFromEnemy) {
		return true;
	}

	@Override
	public boolean getAvailable() {
		return false;
	}

	@Override
	public Symbol drawSymbol() {
		return new Symbol(String.valueOf(Global.strongWallSymbol).repeat(4));
	}

}
