package cs.vsu.ru.myshkevich_a_n.littletanks;

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

}
