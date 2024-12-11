package cs.vsu.ru.myshkevich_a_n.littletanks.cells;

import cs.vsu.ru.myshkevich_a_n.littletanks.Symbol;
import cs.vsu.ru.myshkevich_a_n.littletanks.gameattrs.Global;

public class Tree extends Cell {
	public Tree() {
		this.setSymbol(Global.treeSymbol);
	}

	public Tree(int row, int col) {
		this.setSymbol(Global.treeSymbol);
		this.setRow(row);
		this.setCol(col);
	}

	@Override
	public boolean getAvailable() {
		return true;
	}

	@Override
	public boolean setDestroy(boolean getFromEnemy) {
		return true;
	}

	@Override
	public Symbol drawSymbol() {
		return new Symbol("@@@@");
	}

}
