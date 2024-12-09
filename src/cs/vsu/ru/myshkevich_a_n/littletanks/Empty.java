package cs.vsu.ru.myshkevich_a_n.littletanks;

public class Empty extends Cell {
	public Empty() {
		this.setSymbol(Global.emptySymbol);
	}

	public Empty(int row, int col) {
		this.setSymbol(Global.emptySymbol);
		this.setRow(row);
		this.setCol(col);
	}
}
